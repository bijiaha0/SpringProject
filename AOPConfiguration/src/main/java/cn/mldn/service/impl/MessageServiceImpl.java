package cn.mldn.service.impl;

import org.apache.log4j.Logger;

import cn.mldn.service.IMessageService;

public class MessageServiceImpl implements IMessageService {

	@Override
	public boolean remove(String mid) {
		Logger.getLogger(IMessageService.class).info("【业务层】执行删除调用，删除的数据ID = " + mid);
		return false ; 
	} 

}
