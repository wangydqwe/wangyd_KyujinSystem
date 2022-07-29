package com.example.controller;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;
import com.example.entity.Kyushoku;
import com.example.service.kyujinListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    /*
     * 求人追加
     */
    @RequestMapping("/add")
    public String addKojinShosai(Kyujin kyujin, Model model) {
        model.addAttribute("kyujin",kyujin);
        return "forward:/KigyoJohoShinkiKakunin.jsp";
    }

    /*
     * 求人追加確認
     */
    @RequestMapping("/addKakunin")
    public String addKakunin(Kaisha kaisha, Kyujin kyujin) {
        //保存员工信息
        kyujinListService.addKyujinList(kaisha,kyujin);

        return "redirect:kyujin/2";
    }

    /*
     * 求人変更確認画面
     */
    @RequestMapping("/updateKakunin")
    public String updateKakunin(Model model, HttpServletRequest request) {
        String [] ids = request.getParameterValues("KJId");
        for (String id:ids) {
            int Id = Integer.parseInt(id);
            //根据id查询员工
            Kyujin kyujin = kyujinListService.idByKyushoku(Id);
            //放入model
            model.addAttribute("kyujin",kyujin);
            return "forward:/KigyoJohoHenkouKakunin.jsp";
        }
        return "forward:/KojinShoSai.jsp";
    }

    /*
     * 求人変更画面
     */
    @RequestMapping("/update")
    public String updateKyushoku(Kyujin kyujin) {
        kyujinListService.updateKyuJin(kyujin);
        return "redirect:kyujin/2";
    }
    /*
     * 求人削除機能
     */
    @RequestMapping("/deleteKyujin")
    public String deleteKakunin(HttpServletRequest request, Kyujin kyujin) {
        try {
            String [] ids = request.getParameterValues("KJId");
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //DelFlag
                kyujin.setDelFlag(1);
                kyujinListService.deleteKyuJin(kyujin);
                return "redirect:kyujin/2";

            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:kyujin/2";
        }
        return "redirect:kyujin/2";
    }
}
