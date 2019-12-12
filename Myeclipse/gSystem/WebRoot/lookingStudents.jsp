<%@ page language="java" import="java.util.*,javaBean.*,DB.*,com.servlet.*,tools.*" pageEncoding="gb2312"%><%@page import="Dao.Admindao"%><%@page import="Dao.studentsDao"%>



<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>adminView</title>
		
		<link rel="stylesheet" type="text/css" href="css/studentsView.css" />
	</head>
	<body>
		<div class="main">
			<div class="top">
				<div class="topMenue">
					<div class="topMenue_show">
						<ul>
							<li><a href="index.jsp">首页</a></li>
							<li><a href="superAdminManagementpage.jsp">管理页面</a></li>
							<li><a href="">刷新</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="left">
				<div class="leftMenue">
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>权限管理</h2>
							<li><a href="lookingadmins.jsp">管理员管理</a></li>
							<li><a href="lookingStudents.jsp">学生管理</a></li>
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>成绩管理</h2>
							<li><a href="insertGrade.jsp">成绩录入</a></li>
							<li><a href="lookingGrade.jsp">成绩查询</a></li>
							<li><a href="changeGrade.jsp">成绩修改</a></li>
							
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>课程管理</h2>
							<li><a href="insertClasses.jsp">课程录入</a></li>
							<li><a href="lookingClasses.jsp">课程查询</a></li>
						    <li><a href="changeClasses.jsp">课程修改</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="show">
				<div class="show_continent">
				       <form action="lookingStudents.jsp" class="searchButton">
					   <input type="text" name="sNo"  placeholder="请输入学号查询" >
					   <input type="submit" value="查询" >
					   </form>
					  <span id="add"> <a  href="insertStudent.jsp"  >添加学生</a></span>
					<table>
						
							<tr>
								<th class="first_th">学号</th>
								<th class="second_th">姓名</th>
								<th class="third_th">密码</th>
								<th class="frouth_th">性别</th>
								<th class="five_th">班级</th>
								<th class="sixth_th">学院</th>
								<th class="seventh_th">功能</th>	
							</tr>
							<%
						    studentsDao sdo=new studentsDao();
							String sNo=request.getParameter("sNo");
							String sql=null;
							if(sNo==null){
								sql="select * from students";
							}else{
						        sql="select * from students where sNo like '%" + sNo + "%'";
							}
						List<studentBean> newlist= sdo.findall(sql);
					   
						for(studentBean student:newlist){
							out.println("<tr><td>"+student.getsNo()+"</td><td>"+student.getsName()+"</td><td>"
									+student.getsPwd()+"</td><td>"+student.getsGender()+"</td><td>"+student.getsMajor()
									+"</td><td>"+student.getsDepart()+
									"</td><td><a id=change href=changeStudents.jsp?sNo="+student.getsNo()+"&sName="+student.getsName()+"&sPwd="+student.getsPwd()+"&sGender="+student.getsGender()+"&sMajor="+student.getsMajor()+"&sDepart="+student.getsDepart()+" onclick=if(confirm('确认跳转吗？')==false)return href='#';>修改|</a><a  id=del href=deleateStudents.jsp?sNo="+student.getsNo()+">删除</a></td></tr>");
						}
						%>	
						
				</div>
	
				
			</div>
			<div class="clear"></div>
			
		</div>
		<div class="bottom">
		
		</div>
			<script>
		  function delete(){
			 var msg = "您真的确定要删除吗？\n\n请确认！";
			  if (confirm(msg)==true){ 
              return true; 
             }else{ 
                return false; 
             } 
		};
			</script>
	
	</body>
</html>

