package com.huatec.controller;

import com.huatec.domain.SysLog;
import com.huatec.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    //日志列表
    @RequestMapping("sysLogList")
    public ModelAndView sysLogList(ModelAndView modelAndView){
//        System.out.println(sysLogService);
        List<SysLog> sysLogList = sysLogService.sysLogList();
        modelAndView.addObject("sysLogList",sysLogList);
//        System.out.println(sysLogList + "111111111111");
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
