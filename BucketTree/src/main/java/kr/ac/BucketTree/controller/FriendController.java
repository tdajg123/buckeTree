package kr.ac.BucketTree.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.FriendService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class FriendController {
	@Autowired
	TimelineService ts;
	@Autowired 
	BucketTreeCommon  bucketTreeCommon; 
	@Autowired
	FriendService fs;
	@Autowired
	UserService us;
	//메신저 친구목록 검색(새로운 메세지 제외)
	@ResponseBody
	@RequestMapping(value = "/Friend/MessengerFriendList", method = RequestMethod.POST)
	public List<FriendVO> srchTextByMessengerFriendList(Pagination p) {
		// 유저 정보가져오기
		UserVO user = us.getCurrentUser();
		// 검색에 따른 친구 목록
		List<FriendVO> list = fs.FriendByMessagener(user.getIdx(), p);
		return list;
	}
	
	//새로운 메신저 온거 갱신
	@ResponseBody
	@RequestMapping(value = "/Friend/NewMessengerFriendList", method = RequestMethod.POST)
	public List<FriendVO> NewMessengerFriendList()
	{
		// 유저 정보가져오기
		UserVO user = us.getCurrentUser();
		
		return fs.FriendByNewMessagener(user.getIdx());
	}
	//검색된 친구 목록 POST 검색 결과 페이지
		@RequestMapping(value = "/Friend/searchFriendListPost", method = RequestMethod.POST)
		public String friendSearchPost(Model model,HttpServletRequest request) {
			model = bucketTreeCommon.commonMessenger(model);
			UserVO user =us.getCurrentUser();
			System.out.println("포스트 친구검색 도착");
			int srchType = Integer.parseInt(request.getParameter("srchType"));
			String srchText = request.getParameter("srchText");
			Pagination page = new Pagination();
			page.setSrchType(srchType);
			page.setSrchText(srchText);
			page.setCurrentPage(1);
			page.setPageSize(10);
			int idx = user.getIdx();
			List<UserVO> list = fs.FriendSearch(page,idx);
			model=bucketTreeCommon.commonMessenger(model);
			model.addAttribute("list", list);
			model.addAttribute("srch", page);
			return "friend/friendsearch";
		}
		//검색된 친구 목록 GET 방식 초기페이지
		@RequestMapping(value = "/Friend/searchFriendList", method = RequestMethod.GET)
		public String friendSearchGet(Model model,HttpServletRequest request) {
			model=bucketTreeCommon.commonMessenger(model);
			UserVO user = us.getCurrentUser();
			List<UserVO> list = new ArrayList();
			Pagination page = new Pagination();
	        page.setCurrentPage(1);
			page.setPageSize(10);
			list = fs.UserSearch(page, user.getIdx());
			model.addAttribute("list", list);
			return "friend/friendsearch";
		}
		//검색된 친구 목록 추가 로딩(무한 스크롤) , AJAX 활용
		@ResponseBody
		@RequestMapping(value="/Friend/searchAjaxFriendList", method = RequestMethod.POST)
		public List<UserVO> friendsearchAjaxFriendList (@RequestParam("row") String row,@RequestParam("srchType") String srchType,@RequestParam("srchText") String srchText, HttpServletResponse response, Model model){
			
			UserVO user =us.getCurrentUser();
			Pagination page = new Pagination();
			int srchTypeResult = Integer.parseInt(srchType);
			int rowResult = Integer.parseInt(row);
			int idx = user.getIdx();
			page.setSrchType(srchTypeResult);
			page.setSrchText(srchText);
		    page.setRow(rowResult);
		    page.setPageSize(5);
		    
			List<UserVO> list = fs.FriendAjaxSearch(page,idx);
		    return list;
		}
		@ResponseBody
		@RequestMapping(value="/Friend/sendFriendRequestAjaxList", method = RequestMethod.POST)
		public List<UserVO> sendRequestAjaxFriendList(@RequestParam("row") String row,@RequestParam("srchType") String srchType,@RequestParam("srchText") String srchText, HttpServletResponse response, Model model){
			System.out.println("무한스크롤:"+row);
			UserVO user =us.getCurrentUser();
			Pagination page = new Pagination();
			int srchTypeResult = Integer.parseInt(srchType);
			int rowResult = Integer.parseInt(row);
			int idx = user.getIdx();
			page.setSrchType(srchTypeResult);
			page.setSrchText(srchText);
		    page.setRow(rowResult);
		    page.setPageSize(5);
			List<UserVO> SendAjaxlist = fs.FriendSendAjaxList(page,idx);
		    return SendAjaxlist;
		}
		//친구 추가
		@ResponseBody
		@RequestMapping(value = "friend/addFriendRequestAjax", method = RequestMethod.POST)
		public boolean addFriend(@RequestParam("add_idx") String add_idx, HttpServletResponse response, Model model) throws Exception {

			 UserVO user =us.getCurrentUser();
			 int fromUser = user.getIdx();
			 int toUser = Integer.parseInt(add_idx);
			 System.out.println("신청한 사람 :"+fromUser+" 신청받은 사람:"+toUser + " 상태 2");
			 FriendVO friend = new FriendVO();
			 friend.setFromUser(fromUser);
			 friend.setToUser(toUser);
			 fs.InsertFriendFromRequest(friend);
			 fs.insertFriendToRequest(friend);
			 
			return true;

		}
		@ResponseBody
		@RequestMapping(value = "friend/deleteFriendAjax", method = RequestMethod.POST)
		public boolean deleteFriend(@RequestParam("delete_idx") String delete_idx, HttpServletResponse response, Model model) throws Exception {

			 UserVO user =us.getCurrentUser();
			 FriendVO friend = new FriendVO();
			 friend.setToUser(Integer.parseInt(delete_idx));
			 friend.setFromUser(user.getIdx());
			 
			 System.out.println("삭제 수행 :"+ delete_idx);
			 fs.deleteFromFriend(friend);
			 fs.deleteToFriend(friend);
			 
			return true;

		}
		//친구 목록
		@RequestMapping(value = "/Friend/FriendList", method = RequestMethod.GET)
		public String friendListGet(Model model,HttpServletRequest request) {
			model=bucketTreeCommon.commonMessenger(model);
			UserVO user =us.getCurrentUser();
			Pagination page = new Pagination();
			int idx = user.getIdx();
			page.setPageSize(10);
			page.setCurrentPage(1);		
			List<UserVO> list = fs.FriendList(page,idx);
			model.addAttribute("list",list);
			return "friend/friendlist";
		}
		//친구 목록 내 검색   
		@RequestMapping(value = "/Friend/FriendListSearch", method = RequestMethod.POST)
		public String SearchFriendList(Model model,HttpServletRequest request) {
			model = bucketTreeCommon.commonMessenger(model);
			UserVO user =us.getCurrentUser();
			int srchType = Integer.parseInt(request.getParameter("srchType"));
			String srchText = request.getParameter("srchText");
			Pagination page = new Pagination();
			page.setSrchType(srchType);
			page.setSrchText(srchText);
			page.setCurrentPage(1);
			page.setPageSize(10); //사이즈 고민해 볼 것
			int idx = user.getIdx();
			List<UserVO> list = fs.SearchFriendList(page, idx);

			model.addAttribute("list", list);
			model.addAttribute("srch", page);
			return "friend/friendlist";
		}
		@ResponseBody         
		@RequestMapping(value="/Friend/fRecommendRequestAjax", method = RequestMethod.POST)
		public List<UserVO> fReccommedRequestAjax (HttpServletRequest request,HttpServletResponse response, Model model){
			System.out.println("컨트롤러 도착함");
			UserVO user =us.getCurrentUser();
			int srchType = Integer.parseInt(request.getParameter("sType"));
			String srchText = request.getParameter("sText");
			System.out.println(srchType +" aa" + srchText);
			Pagination page = new Pagination();
			page.setSrchType(srchType);
			page.setSrchText(srchText);
			page.setCurrentPage(1);
			page.setPageSize(10); //사이즈 고민해 볼 것
			int idx = user.getIdx();
			List<UserVO> list = fs.SearchFriendList(page, idx);
			return list;
		}
		//친구 목록 추가 로드 (무한 스크롤), AJAX 활용
		@ResponseBody
		@RequestMapping(value="/Friend/FriendListAjax", method = RequestMethod.POST)
		public List<UserVO> FriendListAjax (@RequestParam("row") String row,@RequestParam("srchType") String srchType,@RequestParam("srchText") String srchText, HttpServletResponse response, Model model){
			
			UserVO user =us.getCurrentUser();
			Pagination page = new Pagination();
			int srchTypeResult = Integer.parseInt(srchType);
			int rowResult = Integer.parseInt(row);
			int idx = user.getIdx();
			page.setSrchType(srchTypeResult);
			page.setSrchText(srchText);
		    page.setRow(rowResult);
		    page.setPageSize(5);
		    
			List<UserVO> list = fs.FriendListAjax(page, idx);
		    return list;
		}
		
		//받은 친구 요청 목록
		@RequestMapping(value="/Friend/FriendRequestList", method= RequestMethod.GET)
		public String friendRequestListGet(Model model){
			UserVO user =us.getCurrentUser();
			Pagination page = new Pagination();
			int idx = user.getIdx();
			page.setCurrentPage(1);
			page.setPageSize(10);
			List<UserVO> rlist = fs.FriendRequestList(page,idx);
			List<UserVO> slist = fs.FriendSendList(page,idx);
			model.addAttribute("rlist",rlist);
			model.addAttribute("slist",slist);
			return "friend/friendrequest";
			
		}
		//친구 요청 삭제
		@ResponseBody
		@RequestMapping(value = "friend/deleteRequestAjax", method = RequestMethod.POST)
		public boolean deleteRequest(@RequestParam("delete_idx") String delete_idx, HttpServletResponse response, Model model) throws Exception {

			 UserVO user =us.getCurrentUser();
			 FriendVO friend = new FriendVO();
			 friend.setToUser(Integer.parseInt(delete_idx));
			 friend.setFromUser(user.getIdx());
			 
			 System.out.println("요청 삭제 수행 :"+ delete_idx);
		     fs.FriendRequestFromDelete(friend);
		     fs.FriendRequestToDelete(friend);
			 
			return true;

		}
		//친구 요청 수락
		@ResponseBody
		@RequestMapping(value = "friend/addFriendAjax", method = RequestMethod.POST)
		public boolean addFriendAjax(@RequestParam("add_idx") String add_idx, HttpServletResponse response, Model model) throws Exception {

			 UserVO user =us.getCurrentUser();
			 FriendVO friend = new FriendVO();
			 friend.setToUser(Integer.parseInt(add_idx));
			 friend.setFromUser(user.getIdx());
			 UserVO fv = fs.selectByIdFriend(Integer.parseInt(add_idx));

			 System.out.println("친구 수락 수행 :"+ add_idx);
			 fs.FriendRequestFromUpdate(friend);
			 fs.FriendRequestToUpdate(friend);
			 //타임라인 두개 등록
			 ts.Friendnsert_Timeline(fv, user);
			 ts.Friendnsert_Timeline(user, fv);
			 
			return true;

		}
		@ResponseBody
		@RequestMapping(value ="/friend/lungeFriendAjax",method = RequestMethod.POST)
		public boolean lungeFriendAjax(@RequestParam("lunge_idx") String lunge_idx,HttpServletResponse response,Model model) throws Exception {
			//찌른 사람 toUser
			
			UserVO uv = us.getCurrentUser();
			//찔린 사람 UserVO
			UserVO fv = fs.selectByIdFriend(Integer.parseInt(lunge_idx));
		 	boolean checkDate = ts.checkDate(fv.getIdx(), uv.getIdx());
			if(checkDate==false){
				ts.FriendPointing_Timeline(fv, uv);
				return true;
			}
				
			
			return false;	
			
			
			
		}
		
		
		
		
		/* 친구리스트 프로필 이미지 보여주기*/
		@RequestMapping("Friend/{idx}/profile")
	    public void profileImage(@PathVariable("idx") int idx, HttpServletResponse response) throws IOException {
			
			UserVO image = us.selectByIdx(idx);
	
			String fileName = URLEncoder.encode(image.getFileName(),"UTF-8");
	        response.setContentType(image.getMimeType());
	        response.setHeader("Content-Disposition", "filename=" + fileName + ";");
	        try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
	            output.write(us.selectByIdx(idx).getImage());
	        }
	    }
		
		/* 친구가 아닌 유저리스트 Ajax */
		@ResponseBody
		@RequestMapping(value = "/Friend/UserListAjax", method = RequestMethod.POST)
		public List<UserVO> UserListAjax(@RequestParam("row") String row, HttpServletResponse response, Model model) throws Exception {

			UserVO user = us.getCurrentUser();
			Pagination page = new Pagination();
			page.setRow(Integer.parseInt(row));
			page.setPageSize(10);
			List<UserVO> list= fs.UserSearchAjax(page, user.getIdx());
			return list;

		}
		
		

}
