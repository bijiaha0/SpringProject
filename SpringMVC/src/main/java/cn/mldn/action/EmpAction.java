package cn.mldn.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.mldn.util.action.AbstractAction;
import cn.mldn.vo.Emp;
// 如果要定义该Action映射路径，则可以在类上定义统一名称与方法中的路径组合
// 或者直接在某一个方法上进行具体的映射路径不在类上进行映射路径的配置
// 该名称绝对不能够重复（完全重复）
@Controller	// 当前的这个程序属于Spring MVC中的一个控制器
@RequestMapping("/pages/emp/*") 
public class EmpAction extends AbstractAction {	// 只要以“/pages/emp/”开头就表示访问此Action
	private Logger log = Logger.getLogger(EmpAction.class) ;
	@RequestMapping("add")	// 表单的文件选择框的参数名称必须是photo
	public ModelAndView add(Emp emp,MultipartFile photo,HttpServletRequest request) {	// 此时作为一个参数，并且没有实例化
		log.info(emp); 
		log.info("*** 文件原始名称：" + photo.getOriginalFilename());
		log.info("*** 文件是否上传：" + photo.isEmpty());
		log.info("*** 文件大小：" + photo.getSize());
		log.info("*** 文件类型：" + photo.getContentType());
		String fileName = super.createFileName(photo) ;
		log.info("*** 上传结果：" + super.saveFile(photo, fileName, request)); 
		return null ; 
	}
	@RequestMapping("get")
	public ModelAndView get(HttpServletRequest request,int eid,HttpServletResponse response) {
		HttpSession session = request.getSession();	// 取得Session对象
		ServletContext application = request.getServletContext() ;
		log.info("*** contextPath = " + request.getContextPath());
		log.info("*** sessionId = " + session.getId());
		log.info("*** realPath = " + application.getRealPath("/")); 
		try {
			response.getWriter().println("Hello World !") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null ; 
	}
	@RequestMapping("remove")
	public ModelAndView remove(@RequestParam(value = "empno", defaultValue = "10") int eid) {
		System.out.println(eid * 2); // 观察是否可以正常接收到EID，以及其是否是数字
		return null;
	}
	@RequestMapping("list") 
	public ModelAndView list(
			@RequestParam(value = "cp", defaultValue = "1") int currentPage,
			@RequestParam(value = "ls", defaultValue = "5") int lineSize , 
			@RequestParam(value = "col", defaultValue = "ename") String column, 
			@RequestParam(value = "kw", defaultValue = "")  String keyWord) {
		log.info("*** currentPage = " + currentPage);
		log.info("*** lineSize = " + lineSize);
		log.info("*** column = " + column);
		log.info("*** keyWord = " + keyWord);
		return null ;
	}
	@RequestMapping("info")
	public ModelAndView info() {
		log.info(super.getValue("vo.edit.msg", "雇员"));
		log.info(super.getValue("emp.add.page"));
		log.info(super.getValue("emp.add.rules"));
		return null ;
	}
	/*http://localhost:8088/pages/emp/echo.action?msg=helloworld*/
	@RequestMapping("echo")	// 最终路径：/pages/emp/echo 
	public ModelAndView echo(String msg) {	// 进行消息的接收，msg就表示参数
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allEmps", new ArrayList<String>()) ;
		map.put("empCount", 1000) ; 
		ModelAndView mav = new ModelAndView("show") ;
		mav.addAllObjects(map) ;	// 将Map集合交由ModelAndView处理
		mav.addObject("info", "ECHO : " + msg) ;	// 设置request属性范围
		Logger.getLogger(EmpAction.class).info("ECHO : " + msg);
		return mav ;	// 表示现在不进行跳转，一般如果使用Ajax连接，才需要使用这样的返回方式
	}
	@Override
	public String getFileUploadDir() {
		return "/upload/emp/";
	}  
}  
