package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SM3_stand.SM3_Attack;

public class send_test1 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sm3x1 = request.getParameter("sm3x1");
		String sm3y1 = request.getParameter("sm3y1");
		String sm3x2 = request.getParameter("sm3x2");
		String sm3d2 = request.getParameter("sm3d2");
		String sm3y2 = request.getParameter("sm3y2");
		String sm3h2 = request.getParameter("sm3h2");
		String sm3c3 = request.getParameter("sm3c3");
		String sm3d3 = request.getParameter("sm3d3");
		String sm3g3 = request.getParameter("sm3g3");
		String sm3h3 = request.getParameter("sm3h3");
		
		
		
		String sm3tracefirst = request.getParameter("tracefirst");
		String sm3tracenumber = request.getParameter("tracenumber");
		String sm3round = request.getParameter("sm3round");
		String sm3step = request.getParameter("sm3step");
		String firstSampleIndex= request.getParameter("first");
		String number = request.getParameter("numberofsamples");
		
		int numberofsamples=Integer.parseInt(number);
		int round=Integer.parseInt(sm3round);
		//int step=Integer.parseInt(sm3step);
		int first=Integer.parseInt(firstSampleIndex);
		int lastSampleIndex=first+numberofsamples;
		
//		Trace t = new Trace();
//		t.setSm3round(sm3round);
//		t.setSm3step(sm3step);
//		t.setSm3x1(sm3x1);
//		t.setSm3y1(sm3y1);
//		t.setSm3x2(sm3x2);
//		t.setSm3d2(sm3d2);
//		t.setSm3y2(sm3y2);
//		t.setSm3h2(sm3h2);
//		t.setSm3c3(sm3c3);
//		t.setSm3d3(sm3d3);
//		t.setSm3g3(sm3g3);
//		t.setSm3h3(sm3h3);
//		t.setNumberOfSamples(numberofsamples);
//		t.setFirstSampleIndex(first);
//		t.setLastSampleIndex(lastSampleIndex);
		
				
        SM3_Attack a=new SM3_Attack();	
//		a.analyze(t) ;
        float[] fArr = null;
        Trace t=new Trace(fArr);
		int j=a.analyze(t);
		System.out.println("j:"+j);
		
		
		response.setCharacterEncoding("UTF-8");
		while(round==1 ){
		response.getWriter().append(sm3step).append(sm3h3);//返回给python的字段，这里是sm3round，测试用，可以按照需要改
		}
		
	}


}
