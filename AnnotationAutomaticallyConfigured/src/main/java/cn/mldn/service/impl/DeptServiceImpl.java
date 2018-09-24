package cn.mldn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.service.IDeptService;
import cn.mldn.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource 
	private IDeptDAO deptDAO ;	// dao对象注入完成
	@Override
	public boolean add(Dept vo) {
		return this.deptDAO.doCreate(vo);
	}

}
