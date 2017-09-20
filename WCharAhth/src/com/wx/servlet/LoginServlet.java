package com.wx.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.AuthUtil;
import com.wx.auth.TokenUtil;

@WebServlet("/wxLogin")
public class LoginServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("stats-------");
		String signature = request.getParameter("signature");
		 String timestamp = request.getParameter("timestamp");
		 String nonce = request.getParameter("nonce");
		 String echostr = request.getParameter("echostr");
		  
		 ArrayList<String> array = new ArrayList<String>();
		 array.add(signature);
		 array.add(timestamp);
		 array.add(nonce);
		  
		 //����
		 String sortString = TokenUtil.sort(AuthUtil.TOKEN, timestamp, nonce);
		 //����
		 String mytoken = TokenUtil.SHA1(sortString);
		 //У��ǩ��
		 if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
			 System.out.println("ǩ��У��ͨ����");
			 response.getWriter().println(echostr); //�������ɹ����echostr��΢�ŷ��������յ���������Ż�ȷ�ϼ�����ɡ�
		 } else {
			 System.out.println("ǩ��У��ʧ�ܡ�");
		 }
		
//	   String backUrl="http://lyouyue.imwork.net/wxLogin/callBcak";
//       String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
//       		+ "&redirect_uri="+URLEncoder.encode(backUrl)
//       		+ "&response_type=code"
//       		+ "&scope=snsapi_base"
//       		+ "&state=STATE#wechat_redirect";
//       response.sendRedirect(url);
       
	}
	 
}
