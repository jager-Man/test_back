<%@ page language="java" import="java.util.*,javaBean.*,Dao.*" pageEncoding="gb2312"%><%@page import="tools.MyTools"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>adminView</title>
		<link rel="stylesheet" type="text/css" href="css/changeStudents.css"/>
		<link rel="stylesheet" type="text/css" href="css/studentsView.css" />
	 
	</head>
	<body>
		<div class="main">
			<div class="top">
				<div class="topMenue">
					<div class="topMenue_show">
						<ul>
							<li><a href="index.jsp">��ҳ</a></li>
							<li><a href="superAdminManagementpage.jsp">����ҳ��</a></li>
							<li><a href="">ˢ��</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="left">
				<div class="leftMenue">
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>Ȩ�޹���</h2>
							<li><a href="lookingadmins.jsp">����Ա����</a></li>
							<li><a href="lookingStudents.jsp">ѧ������</a></li>
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>�ɼ�����</h2>
							<li><a href="insertGrade.jsp">�ɼ�¼��</a></li>
							<li><a href="lookingGrade.jsp">�ɼ���ѯ</a></li>
							<li><a href="changeGrade.jsp">�ɼ��޸�</a></li>
							
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>�γ̹���</h2>
							<li><a href="insertClasses.jsp">�γ�¼��</a></li>
							<li><a href="lookingClasses.jsp">�γ̲�ѯ</a></li>
						    <li><a href="changeClasses.jsp">�γ��޸�</a></li>
						</ul>
					</div>
					
				</div>
			</div>
			<div class="clear"></div>
			<div class="show">
				<div class="show_continent">
				      <div id="show" style="top:-20px;left:200px; height:30px;width:300px; opcity:0.5">
				      	
				      <form action="insertGrade.jsp" class="searchButton">
					   <input type="text" name="sClasses"  placeholder="������༶" >
					   <input type="submit" value="��ѯ" >
					</form>
				     </div>
				     <table>
							<tr>
							    <th  style="width:120px;">����</th>
								<th >ѧ��</th>
								<th >�༶</th>
								<th >�ɼ�</th>
								<th >�γ̱��</th>
								<th style="width=60px;">����</th>
							</tr>
				     <%
						GradeDao gd=new GradeDao();
						String sClasse= MyTools.toChinese( request.getParameter("sClasses"));
						String sql=null;
						
						List<inGradeBean> newlist= gd.findGrade(sClasse);
						for(inGradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+"<input type=text id=inputsName    name=sName  value="+admin.getsName()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputsNo      name=sNo    value="+admin.getsNo()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputClasses  name=sClasses value="+admin.getsClasses()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputGrade    name=grade  value="+admin.getGrade()+">"+" </td>");
							out.println("<td>"+"<input type=text id=inputId       name=cId    value="+admin.getcId()+">"+"</td>");
							out.println("<td>"+"<input type=button value=¼�� onclick=submit()>"+"</td>");
							out.println("<a id=url ></a>");
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">�޸�|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  ɾ��</a></td></tr>");*/
						}
					  
						/**for(inGradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td id=inputsName    name=sName>"+admin.getsName()+"</td>");
							out.println("<td>"+"<input type=text id=inputsNo      name=sNo    value="+admin.getsNo()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputClasses  name=sClasses value="+admin.getsClasses()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputGrade    name=grade  value="+admin.getGrade()+">"+" </td>");
							out.println("<td>"+"<input type=text id=inputId       name=cId    value="+admin.getcId()+">"+"</td>");
							out.println("<td><a id=linkTo href= >¼��</a></td>");
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">�޸�|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  ɾ��</a></td></tr>");*/
						/*}**/
						%>
							
						
				     
				     
				</div>
			</div>
			<div class="clear"></div>
			
		</div>
		<div class="bottom">
		
		</div>
	</body>
    
</html>

 <script src="http://localhost:8080/gSystem/js/jQuery/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
   function submit(){
var sName = document.getElementById('inputsName').value;
var sNo = document.getElementById('inputsNo').value;

var sClasses = document.getElementById('inputClasses').value;
var grade = document.getElementById('inputGrade').value;
var cId = document.getElementById('inputId').value;
console.log(sName);
document.getElementById("url").innerHTML = '<a href="SinsertGrade.jsp?sName='+sName+'&sClasses='+sClasses+'&cId='+cId+'&grade='+grade+'&sNo='+sNo+'">�ύ</a>';
alert(document.getElementById("url").innerHTML);
}
</script>