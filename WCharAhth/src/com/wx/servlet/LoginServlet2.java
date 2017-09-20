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

@WebServlet("/authTest")
public class LoginServlet2 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("stats-------");
//		String signature = request.getParameter("signature");
//		 String timestamp = request.getParameter("timestamp");
//		 String nonce = request.getParameter("nonce");
//		 String echostr = request.getParameter("echostr");
//		 System.out.println("stats-------signature:"+signature);
//		 System.out.println("stats-------timestamp:"+timestamp);
//		 System.out.println("stats-------nonce:"+nonce);
//		 System.out.println("stats-------echostr:"+echostr);
//		 
//		 ArrayList<String> array = new ArrayList<String>();
//		 array.add(signature);
//		 array.add(timestamp);
//		 array.add(nonce);
//		  
//		 //排序
//		 String sortString = TokenUtil.sort(AuthUtil.TOKEN, timestamp, nonce);
//		 //加密
//		 String mytoken = TokenUtil.SHA1(sortString);
//		 //校验签名
//		 if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
//			 System.out.println("签名校验通过。");
//			 response.getWriter().println(echostr); //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
//		 } else {
//			 System.out.println("签名校验失败。");
//		 }
//		 
	   System.out.println("yetettttt");
	   String backUrl="http://www.qydjk.org";
	   System.out.println("yetettttt------2");
       String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
       		+ "&redirect_uri="+URLEncoder.encode(backUrl)
       		+ "&response_type=code"
       		+ "&scope=snsapi_userinfo"
       		+ "&state=STATE#wechat_redirect";
       System.out.println("yetettttt-----3"+url);
       response.sendRedirect(url);
       System.out.println("yetettttt----4");
       
	}
	 
}
