package cn.mldn.dao.impl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.vo.Dept;
// 写上此注解之后就相当于这个bean对象已经在applicationContext.xml文件里面配置上了
// 而它的引用名字就是首字母小写，即：deptDAOImpl
@Repository 
public class DeptDAOImpl implements IDeptDAO {
	@Override
	public boolean doCreate(Dept vo) {
		LoggerFactory.getLogger(DeptDAOImpl.class).info(vo.toString());
		return true ;
	}

}
