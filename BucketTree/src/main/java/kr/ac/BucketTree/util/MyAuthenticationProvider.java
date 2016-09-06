package kr.ac.BucketTree.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.vo.UserVO;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		String password = authentication.getCredentials().toString();

		return authenticate(email, password);
	}

	public Authentication authenticate(String email, String password) throws AuthenticationException {
		
		UserVO user = service.selectByEmail(email);
		if (user == null) {
			return null;
		}
		// 프로젝트 완료하면 비밀번호 암호화 적용
		/*
		 * if (user.getPassword().equals(encryptPasswd(password)) == false)
		 * return null;
		 */
		if (user.getPassword().equals(password) == false) {
			return null;
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_전체"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getType()));
		return new MyAuthenticaion(email, password, grantedAuthorities, user);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
		private static final long serialVersionUID = 1L;
		UserVO user;

		public MyAuthenticaion(String email, String password, List<GrantedAuthority> grantedAuthorities, UserVO user) {
			super(email, password, grantedAuthorities);
			this.user = user;
		}

		public UserVO getUser() {
			return user;
		}

		public void setUser(UserVO user) {
			this.user = user;
		}
	}

	// 프로젝트 완료하면 비밀번호 암호화 적용
	/*
	 * public static String encryptPasswd(String passwd) { try { MessageDigest
	 * md = MessageDigest.getInstance("MD5"); byte[] passBytes =
	 * passwd.getBytes(); md.reset(); byte[] digested = md.digest(passBytes);
	 * StringBuffer sb = new StringBuffer(); for (int i = 0; i <
	 * digested.length; i++) sb.append(Integer.toHexString(0xff & digested[i]));
	 * return sb.toString(); } catch (Exception e) { return passwd; } }
	 */

}