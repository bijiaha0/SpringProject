$(function() {
	$(listMember).on("click",function(){ 
		$.ajax({
			url : "member/splitByName" ,	// 处理的请求路径
			type : "patch" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			success : function(data) {
				$(showDiv).append("<p>" + data.condition + "</p>");
				$(showDiv).append("<p>" + data.memberCount + "</p>");
				for (var x = 0 ; x < data.allMembers.length ; x ++) {
					$(showDiv).append(
							"<p>修改处理结果：" + data.allMembers[x].mid + "，" + data.allMembers[x].name + "，"
									+ data.allMembers[x].salary + "，" + new Date(data.allMembers[x].hiredate).format("yyyy-MM-dd hh:mm:ss")
									+ "</p>");
				}
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
	$(getMember).on("click",function(){ 
		$.ajax({
			url : "member/1001" ,	// 处理的请求路径
			type : "get" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			success : function(data) {
				$(showDiv).append(
						"<p>修改处理结果：" + data.mid + "，" + data.name + "，"
								+ data.salary + "，" + new Date(data.hiredate).format("yyyy-MM-dd hh:mm:ss")
								+ "</p>");
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
	
	$(removeMember).on("click",function(){ 
		$.ajax({
			url : "member/1001" ,	// 处理的请求路径
			type : "delete" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			success : function(data) {
				$(showDiv).append("<p>修改处理结果：" + data.flag + "</p>") ;
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
	$(editMember).on("click",function(){ 
		$.ajax({
			url : "member?mid=1009&name=阿伦&salary=19777.77&hiredate=1969-10-10" ,	// 处理的请求路径
			type : "put" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			success : function(data) {
				$(showDiv).append("<p>修改处理结果：" + data.flag + "</p>") ;
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
	$(addMember).on("click",function(){ 
		$.ajax({
			url : "member" ,	// 处理的请求路径
			type : "post" ,		// 此处发送的是POST请求
			dataType : "json" ,	// 返回的数据类型为json类型
			data : {
				mid : 1001 ,
				name : "史密斯" ,
				salary : 9888.12 ,
				hiredate : "1981-10-10" 
			} ,
			success : function(data) {
				$(showDiv).append("<p>增加处理结果：" + data.flag + "</p>") ;
			} ,
			error : function(data) {
				$(showDiv).append("<p>对不起，出错啦！</p>") ;
			} 
		}) ;
	}) ;
})

	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	// 例子： 
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
	Date.prototype.format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
			"S" : this.getMilliseconds()
		//毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	} 
