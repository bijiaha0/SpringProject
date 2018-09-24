package cn.mldn.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.mldn.util.SplitPageUtil;
import cn.mldn.vo.Member;
import net.sf.json.JSONObject;
@Controller
public class MemberAction {
	private Logger log = Logger.getLogger(MemberAction.class);
	@RequestMapping(value = "/echo/{msgParam}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String echo(@PathVariable("msgParam") String msg) {
		return "ECHO : " + msg;
	}

	// 定义该方法的访问路径，而后表示该方法返回的数据类型为普通的文本类型（MIME）
	@RequestMapping(value = "/info", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String info() { // 该方法的返回值即回应的主题消息
		return "www.mldnjava.cn";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object edit(Member vo1) {
		log.info("【*** 修改用户信息 ***】" + vo1);
		JSONObject obj = new JSONObject();
		obj.put("flag", true);
		return obj;
	}
	@RequestMapping(value = "/member/{condition}",produces = "application/json;charset=UTF-8",method=RequestMethod.PATCH)
	public @ResponseBody Object list(@PathVariable("condition") String condition,SplitPageUtil su) {
		log.info("【当前查询】 condition = " + condition);
		List<Member> all = new ArrayList<Member>() ;
		for (int x = (su.getCurrentPage() - 1) * su.getLineSize() ; x < su.getCurrentPage() * su.getLineSize() ; x ++) {
			Member vo = new Member() ;
			vo.setMid(x);
			vo.setName("姓名 - " + x);
			vo.setSalary(10000.0 + x);
			vo.setHiredate(new Date());
			all.add(vo) ;
		}
		Map<String,Object> result  = new HashMap<String,Object>() ;
		result.put("memberCount", 892349) ;
		result.put("allMembers", all) ;
		result.put("condition", condition) ;	// 下次可能继续使用
		return result ;
	} 
	
	@RequestMapping(value = "/member/{mid:\\d+}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object get(@PathVariable("mid") int mid) {
		Member vo = new Member() ;
		vo.setMid(mid);
		vo.setName("史密斯");
		vo.setSalary(1999.99);
		vo.setHiredate(new Date());
		return vo ;
	} 
	

	@RequestMapping(value = "/member/{mid:\\d+}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object delete(@PathVariable("mid") int mid) {
		log.info("【*** 删除用户信息 ***】" + mid);
		JSONObject obj = new JSONObject();
		obj.put("flag", true);
		return obj;
	}

	
	@RequestMapping(value = "/member", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object add(Member vo) {
		log.info("【*** 增加用户信息 ***】" + vo);
		JSONObject obj = new JSONObject();
		obj.put("flag", true);
		return obj;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
