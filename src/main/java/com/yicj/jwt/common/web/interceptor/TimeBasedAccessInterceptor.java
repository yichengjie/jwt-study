package com.yicj.jwt.common.web.interceptor;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {
	private int openingTime;  
    private int closingTime;  
    private String mappingURL;//利用正则映射到需要拦截的路径  
    
    
	public TimeBasedAccessInterceptor(int openingTime,int closingTime,String mappingURL) {
		this.openingTime = openingTime ;
		this.closingTime = closingTime ;
		this.mappingURL = mappingURL ;
	}
    
    public void setOpeningTime(int openingTime) {  
        this.openingTime = openingTime;  
    }  
    public void setClosingTime(int closingTime) {  
        this.closingTime = closingTime;  
    }  
    public void setMappingURL(String mappingURL) {  
        this.mappingURL = mappingURL;  
    }  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
        String url=request.getRequestURL().toString();  
        if(mappingURL==null || url.contains(mappingURL)){  
            Calendar c=Calendar.getInstance();  
            c.setTime(new Date());  
            int now=c.get(Calendar.HOUR_OF_DAY);  
            if(now<openingTime || now>closingTime){  
                request.setAttribute("msg", "注册开放时间：9：00-12：00");  
                String contextPath = request.getContextPath();
                //request.getRequestDispatcher(contextPath + "/msg").forward(request, response);  
                response.sendRedirect(contextPath + "/msg");
                return false;  
            }  
            return true;  
        }  
        return true;  
    }  

}
