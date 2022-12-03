package co.mini.prj.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.mini.prj.common.DataSource;
import co.mini.prj.mapper.PointMapper;
import co.mini.prj.service.PayVO;
import co.mini.prj.service.PointService;
import co.mini.prj.service.PointVO;

public class PointServiceImpl implements PointService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	PointMapper map = sqlSession.getMapper(PointMapper.class);
	
	@Override
	public List<PointVO> pointSelectList(PointVO vo) {
		return map.pointSelectList(vo);
	}

	@Override
	public PointVO pointSelect(PointVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pointInsert(PointVO vo) {
		return map.pointInsert(vo);
	}

	@Override
	public int pointDelete(PointVO vo) {
		// TODO Auto-generated method stub
		return map.pointDelete(vo);
	}

	@Override
	public int pointUpdate(PayVO vo) {
		// TODO Auto-generated method stub
		return map.pointUpdate(vo);
	}

	@Override
	public PointVO pointSum(PointVO vo) {
		// TODO Auto-generated method stub
		return map.pointSum(vo);
	}

	@Override
	public int pointSumUpdate(PayVO vo) {
		// TODO Auto-generated method stub
		return map.pointSumUpdate(vo);
	}

}
