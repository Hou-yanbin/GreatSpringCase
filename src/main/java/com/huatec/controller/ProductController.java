package com.huatec.controller;

import com.huatec.domain.Pro;
import com.huatec.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pro")
public class ProductController {
    @Autowired
    private ProService proService;

    @RequestMapping("/proList")
    public ModelAndView proList(ModelAndView modelAndView) {
//        System.out.println(proService);
        List<Pro> proList = proService.proList();
        modelAndView.addObject("proList", proList);
        modelAndView.setViewName("pro-list");
        return modelAndView;
    }

    @RequestMapping("/del/{productNum}")
    public String del(@PathVariable("productNum") String productNum) {
        proService.delPro(productNum);
        return "redirect:/pro/proList";
    }

//    //    跳转产品编辑页面
//    @RequestMapping("/editor")
//    public String editor(@PathVariable("productNum") String productNum, ModelAndView modelAndView) {
//        List<Pro> onePro = proService.findOne(productNum);
//        System.out.println(proService);
//        modelAndView.addObject("onePro", onePro);
//        modelAndView.setViewName("pro-edit");
//        return "redirect:/pro/update";
//    }

    @RequestMapping("/query/{productNum}")
    public ModelAndView findOne(@PathVariable("productNum") String productNum, ModelAndView modelAndView) {
        List<Pro> onePro = proService.findOne(productNum);
//        System.out.println(proService);
        System.out.println("111111111111111" + onePro);
        modelAndView.addObject("onePro",onePro);
        modelAndView.setViewName("pro-edit");
        return modelAndView;
    }

////    @PathVariable("productNum,productName,productCity,proDescription,numbers")
//    @RequestMapping("/update")
//    public String update( String productNum,String productName,String productCity,String proDescription,String numbers) {
//        proService.updatePro(productNum,productName,productCity,proDescription,numbers);
//        return "redirect:/pro/proList";
//    }

    @RequestMapping("/update")
    public String update( Pro pro) {
        proService.updatePro(pro);
        return "redirect:/pro/proList";
    }

    @RequestMapping("/addPro")
    public String addPro(Pro pro){
        proService.addPro(pro);
        return "redirect:/pro/proList";
    }
}
