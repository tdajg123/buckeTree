package kr.ac.BucketTree.dao.impl;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.BucketTree.dao.CategoryDAO;
import kr.ac.BucketTree.vo.CategoryVO;
@Repository
public class CategoryDAOimpl implements CategoryDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.CategoryMapper";
	
	@Override
	public List<CategoryVO> whoList() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".whoList");
	}

	@Override
	public List<CategoryVO> whenList() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".whenList");
	}

	@Override
	public List<CategoryVO> whatList() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".whatList");
	}
	
	@Override
	public CategoryVO whoName(int idx){
		return session.selectOne(namespace+".whoName",idx);
	}
	@Override
	public CategoryVO whenName(int idx){
		return session.selectOne(namespace+".whenName",idx);
	}
	@Override
	public CategoryVO whatName(int idx){
		return session.selectOne(namespace+".whatName", idx);
	}
}

