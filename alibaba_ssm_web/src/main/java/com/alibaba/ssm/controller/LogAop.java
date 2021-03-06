package com.alibaba.ssm.controller;

import com.alibaba.ssm.domain.SysLog;
import com.alibaba.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/31 - 13:48
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //开始时间
    private Date visitTime;
    //访问的类
    private Class clazz;
    //访问的方法
    private Method method;

    //前置通知 主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* com.alibaba.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException{
        //当前时间就是开始访问的时间
        visitTime = new Date();
        //具体要访问的类
        clazz = jp.getTarget().getClass();
        //要获取方法的名称
        String methodName = jp.getSignature().getName();
        //获取访问的的方法的参数
        Object[] args = jp.getArgs();

        //获取具体执行的方法的Method对象
        if(args == null || args.length == 0){
           //只能获取无参数的方法
            method = clazz.getMethod(methodName);
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }

    //后置通知
    @After("execution(* com.alibaba.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception{
        //获取访问的时长
        long time = new Date().getTime() - visitTime.getTime();
        String url = "";
        //获取url
        if(clazz != null && method != null && clazz != LogAop.class){
            //获取类上的@RequestMapping("/orders")
           RequestMapping classAnnotation =  (RequestMapping)clazz.getAnnotation(RequestMapping.class);
           if(classAnnotation != null){
               String[] classValue = classAnnotation.value();
               //2.获取方法上的@RequestMapping(xxx)
               RequestMapping methodAnnotation = this.method.getAnnotation(RequestMapping.class);
               if(methodAnnotation != null){
                   String[] methodValue = methodAnnotation.value();
                   url = classValue[0] + methodValue[0];

                   //获取访问的ip
                   String ip = request.getRemoteAddr();

                   //获取当前操作的用户
                   //从上下文中获取当前登录的用户
                   SecurityContext context = SecurityContextHolder.getContext();
                   User user = (User) context.getAuthentication().getPrincipal();
                   String username = user.getUsername();

                   //将日志信息封装到SysLog对象
                   SysLog sysLog = new SysLog();
                   //执行时长
                   sysLog.setExecutionTime(time);
                   sysLog.setIp(ip);
                   sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]" +method.getName());
                   sysLog.setUrl(url);
                   sysLog.setUsername(username);
                   sysLog.setVisitTime(visitTime);

                   //调用Service完成操作
                   sysLogService.save(sysLog);
               }
           }
        }
    }
}
