package com.wx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.AuthUtil;

import net.sf.json.JSONObject;

@WebServlet("/wxLogin/callBcak")
public class CallBackServlet extends HttpServlet{
   @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("backResststst---------");
	   System.out.println("yetettttt------5");
       String code =req.getParameter("code");
       String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
       		+ "&secret="+AuthUtil.APPSECRET
       		+ "&code="+code
       		+ "&grant_type=authorization_code";
       JSONObject jsonObject=AuthUtil.doGetJson(url);
       String openid =jsonObject.getString("openid");
       System.out.println("openid:"+openid);
       String access_token =jsonObject.getString("access_token");
       System.out.println("yetettttt=====6");
       String infoUrl ="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
       		+ "&openid="+openid
       		+ "&lang=zh_CN";
       JSONObject userinfo = AuthUtil.doGetJson(infoUrl);
       System.out.println("yetettttt------7");
       System.out.println("userinfo"+userinfo);
       
       req.setAttribute("userinfo", userinfo);
       req.getRequestDispatcher("/test.jsp").forward(req, resp);
	}
}
