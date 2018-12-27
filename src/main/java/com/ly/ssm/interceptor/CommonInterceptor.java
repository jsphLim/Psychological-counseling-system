package com.ly.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.ssm.model.student;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class CommonInterceptor extends HandlerInterceptorAdapter{
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI(); //请求完整路径，可用于登陆后跳转
        String contextPath = request.getContextPath();  //项目下完整路径
        String url = requestUri.substring(contextPath.length()); //请求页面
        System.out.print("发生拦截...");
        System.out.println("来自："+requestUri+"的请求");
        student user =  (student)request.getSession().getAttribute("user");
        if(user == null){  //判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
            /**
             * 拦截目录下请求，是否为ajax请求
             *   是：无需登录，直接访问（因为我是用于首页的ajax登录请求）
             *   否：跳转至登录界面
             */
//            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
//                //如果是ajax请求响应头会有，x-requested-with
//                System.out.print("发生ajax请求...");
//                return true;
//                //response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
//            }else{
                System.out.print("返回主页...");
                request.getRequestDispatcher("/index.html").forward(request, response);//转发到登录界面
//            }
            return false;
        }else
            return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){  //加入当前时间
            modelAndView.addObject("var", "测试postHandle");
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
