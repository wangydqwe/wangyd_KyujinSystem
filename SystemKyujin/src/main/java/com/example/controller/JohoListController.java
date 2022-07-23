package com.example.controller;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;
import com.example.service.JohoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*、
 *　情報開発list
 */
@Controller
@RequestMapping("/list")
public class JohoListController {
    private final JohoListService johoListService;
    @Autowired
    public JohoListController(JohoListService johoListService){
        this.johoListService = johoListService;
    }

//    @RequestMapping("kyushoku")
//    public String kyushokuListJoho(Model model){
//
//        //获取list
//        List<Kyushoku> KyushokuList = johoListService.kyushokuList();
//        model.addAttribute("kyushokulist",KyushokuList);
//        return "forward:/kyushokujoho.jsp";
//    }
    /*
     * 求職list
     */
    @RequestMapping("kyushoku")
    public ModelAndView kyushokuListJoho() {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("kyushokujoho");
        //设置数据
        List<Kyushoku> KyushokuList = johoListService.kyushokuList();
        mav.addObject("kyushokulist",KyushokuList);

        return mav;
    }
    /*
     * 求職詳細
     */
    @RequestMapping("/kojinShosai/{kojinId}")
    public ModelAndView kojinShosai(@PathVariable("kojinId")Integer kojinId) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KojinShoSai");
        //设置数据
        Integer kId = kojinId;
        List<Kyushoku> KyushokuList = johoListService.kyushokuList();
        mav.addObject("kyushokulist",KyushokuList);

        return mav;
    }

    /*
     * 求職追加
     */
    @RequestMapping("/add")
    public String addKojinShosai(Kyushoku kyushoku, Model model) {
        model.addAttribute("kyushoku",kyushoku);
        return "forward:/KojinJohoShinkiKakunin.jsp";
    }
    /*
     * 求職追加確認
     */
    @RequestMapping("/addKakunin")
    public String addKakunin(Kojin kojin, Kyushoku kyushoku, Model model) {
        //保存员工信息
        johoListService.addKyuShokuList(kojin,kyushoku);

        return "redirect:kyushoku";
    }

    /*
     * 根据id查询员工信息
     */
    @RequestMapping("/detail")
    public String detailKyushoku(Integer id, Model model){

        //根据id查询员工
        Kyushoku kyushoku = johoListService.idByKyushoku(id);
        //放入model
        model.addAttribute("kyushoku",kyushoku);
        return "UpdKojinJoho.jsp";
    }
}
