package com.example.controller;

import com.example.entity.Kyujin;
import com.example.service.kyujinListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kyujinList")
public class kyujinListController {
    private final kyujinListService kyujinListService;
    @Autowired
    public kyujinListController(kyujinListService kyujinListService){

        this.kyujinListService = kyujinListService;
    }

    /*
     * 求人情報画面
     */
    @RequestMapping("kyujin/{rtype}")
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("kyujinjoho");
        //设置数据
        List<Kyujin> KyujinList = kyujinListService.kyujinList();
        //管理機能
        mav.addObject("Rid",Rid);

        mav.addObject("kyujinlist",KyujinList);

        return mav;
    }

    /*
     * 求人詳細画面
     */
    @RequestMapping("/detail")
    public String detailKyushoku(Integer id, Model model){
        //根据id查询员工
        Kyujin kyujin = kyujinListService.idByKyushoku(id);
        //放入model
        model.addAttribute("kyujin",kyujin);
        return "forward:/KigyoShosai.jsp";
    }
}
