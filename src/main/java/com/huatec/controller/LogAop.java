package com.huatec.controller;

import com.huatec.domain.SysLog;
import com.huatec.domain.User;
import com.huatec.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    //如何获取访问ip
    @Autowired
    private HttpServletRequest request;
    private Date visitTime;  //开始时间
    private Class clazz;    //访问的类
    private Method method;    //访问的方法

    @Autowired
    private SysLogService sysLogService;

    //    前置通知   获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* com.huatec.controller.*.*(..))")  //导错包了！！！！！！！！！！！
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date(); //当前时间就是开始访问的时间
//        clazz = jp.getClass();  //获取当前访问的类
//        String methodName = jp.getSignature().getName(); //获取方法的名字
//        Object[] args = jp.getArgs();//获取访问的方法的参数
////        获取具体执行方法的method对象
//        if (args == null || args.length == 0) {
//            method = clazz.getMethod(methodName);  //只能获取无参数的方法
//        } else {
//            Class[] classArgs = new Class[args.length];
//            for (int i = 0; i < args.length; i++) {
//                classArgs[i] = args[i].getClass();
//            }
////            clazz.getMethod(methodName);
//        }
    }

    //    后置通知
    @After("execution(* com.huatec.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
//访问时长作差获取
        long time = new Date().getTime() - visitTime.getTime(); //获取访问时长
//        String url = "http://localhost:8080/";
        String url = "http://39.107.237.70:8080/Spring_Case/";
        ////通过反射完成操作 获取url
//        if (clazz != null && method != null && clazz != LogAop.class) {
////
////            获取类上的注解RequestMapping("/orders")
//            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//            if (classAnnotation != null) {
//                String[] classValue = classAnnotation.value();
////                获取方法上的RequestMapping注解的value的值
//                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
//                if (methodAnnotation != null) {
//                    String[] methodValue = methodAnnotation.value();
//                    url = classValue[0] + methodValue[0];
//                }
//            }
//        }
        System.out.println(url);
        //通过request对象获取ip
        String ip = request.getRemoteAddr();
//        获取当前操作的用户
        SecurityContext context = SecurityContextHolder.getContext();  //从上下文中获取当前登录的用户
//        User user = (User) context.getAuthentication().getPrincipal();
//        String username = user.getUsername();

//    将日志相关信息封装到SysLog对象里
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);
        sysLog.setIp(ip);
//        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名]" + method.getName());
        sysLog.setMethod("method");
        sysLog.setUrl(url);
        sysLog.setUserName("lisi");
        sysLog.setVisitTime(visitTime);
        System.out.println("0000121212" + sysLog);
//        System.out.println(sysLogService);
//        调用service完成操作
        sysLogService.saveLog(sysLog);
    }
}
