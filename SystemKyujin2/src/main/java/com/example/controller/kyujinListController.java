package com.example.controller;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;
import com.example.entity.Kyushoku;
import com.example.service.kyujinListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//20220806 wangyide:kyujinListControllerクラスの作成

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
     * 名
     * 作用
     * 引数
     * 戻り値
     * バージョン
     */
    @RequestMapping("kyujin/{rtype}")
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid,
                                         Integer startpage,
                                         Integer pagesize) {
        ModelAndView mav = new ModelAndView();
        pagesize = 10;
        //设置jsp路径
        mav.setViewName("kyujinjoho");
        //设置数据
        PageHelper.startPage(startpage,pagesize);
        List<Kyujin> KyujinList = kyujinListService.kyujinList();
        PageInfo<Kyujin> PageList = new PageInfo<>(KyujinList);
        mav.addObject("kyujinlist",PageList);
        //管理機能
        mav.addObject("Rid",Rid);
        return mav;
    }

    /*
     * 求人詳細画面
     */
    @RequestMapping("/detail/{rtype}")
    public String detailKyushoku(@PathVariable("rtype") Integer Rid,
                                 Integer id,
                                 Model model){
        //管理機能
        model.addAttribute("Rtype",Rid);
        //根据id查询员工
        Kyujin kyujin = kyujinListService.idByKyushoku(id);
        //放入model
        model.addAttribute("kyujin",kyujin);
        return "forward:/KigyoShosai.jsp";
    }

    /*
     * 求人追加
     */
    @RequestMapping("/add/{rtype}")
    public String addKojinShosai(@PathVariable("rtype") Integer Rid,Kyujin kyujin, Model model) {
        model.addAttribute("kyujin",kyujin);
        model.addAttribute("rtype",Rid);
        return "forward:/KigyoJohoShinkiKakunin.jsp";
    }

    /*
     * 求人追加確認
     */
    @RequestMapping("/addKakunin/{rtype}")
    public String addKakunin(@PathVariable("rtype") Integer Rid,Kaisha kaisha, Kyujin kyujin, Model model) {
        //保存员工信息
        kyujinListService.addKyujinList(kaisha,kyujin);
        model.addAttribute("rtype",Rid);

        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }

    /*
     * 求人変更画面
     */
    @RequestMapping("/updateKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,Model model, HttpServletRequest request) {
        try {
            String [] ids = request.getParameterValues("KJId");
            if (ids.length != 1){
                return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
            }
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //根据id查询员工
                Kyujin kyujin = kyujinListService.idByKyushoku(Id);
                //放入model
                model.addAttribute("kyujin",kyujin);
                model.addAttribute("rtype",Rid);
                return "forward:/UpdKigyoJoho.jsp";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
        }
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }

    /*
     * 求人変更確認画面
     */
    @RequestMapping("/henkouKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,Model model,Kyujin kyujin) {
        model.addAttribute("kyujin",kyujin);
        model.addAttribute("rtype",Rid);
        return "KigyoJohoHenkouKakunin";
    }
    /*
     * 変更
     */
    @RequestMapping("/update/{rtype}")
    public String updateKyushoku(@PathVariable("rtype") Integer Rid,Model model,Kyujin kyujin) {
        kyujinListService.updateKyuJin(kyujin);
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }

    /*
     * 「トップページ」画面の管理機能
     */
    @RequestMapping("toppage/{rtype}")
    public ModelAndView toppage(@PathVariable("rtype") Integer Rid) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("toppage");
        //设置数据
        mav.addObject("Rid",Rid);

        return mav;
    }
    /*
     * 「求人広告掲載」画面の管理機能
     */
    @RequestMapping("KigyoJohoToroku/{rtype}")
    public ModelAndView KigyoJohoToroku(@PathVariable("rtype") Integer Rid) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KigyoJohoToroku");
        //设置数据
        mav.addObject("Rid",Rid);

        return mav;
    }

    /*
     * 「閉める」ボタン押下
     */
    @RequestMapping("close/{rtype}")
    public String shosaiClose(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 更新「戻る」ボタン押下
     */
    @RequestMapping("updateModoru/{rtype}")
    public String updateModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 更新確認画面「戻る」ボタン押下
     */
    @RequestMapping("updKauninModoru/{rtype}")
    public String updKauninModoru(@PathVariable("rtype") Integer Rid, Model model, Kyujin kyujin) {
        model.addAttribute("rtype",Rid);
        Integer Kjid = kyujin.getKJId();
        if (Rid == 1){
            return "redirect:/kyujinList/updateKakunin/1?KJId="+Kjid;
        } else if (Rid == 2) {
            return "redirect:/kyujinList/updateKakunin/2?KJId="+Kjid;
        } else if (Rid == 3) {
            return "redirect:/kyujinList/updateKakunin/3?KJId="+Kjid;
        }else {
            return "redirect:/kyujinList/updateKakunin/4?KJId="+Kjid;
        }
    }
    /*
     * 求職削除確認画面
     */
    @RequestMapping("/deleteKakunin/{rtype}")
    public String deleteKakunin(@PathVariable("rtype") Integer Rid,Model model,HttpServletRequest request) {
        try {
            String [] ids = request.getParameterValues("KJId");
            if (ids.length != 1){
                return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
            }
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //根据id查询员工
                Kyujin kyujin = kyujinListService.idByKyushoku(Id);
                //放入model
                model.addAttribute("kyujin",kyujin);
                model.addAttribute("rtype",Rid);
                return "forward:/KigyoJohoDeleteKakunin.jsp";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
        }

        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 削除確認画面「戻る」ボタン押下
     */
    @RequestMapping("/deleteModoru/{rtype}")
    public String deleteModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 求人削除機能
     */
    @RequestMapping("/deleteKyujin/{rtype}")
    public String deleteKakunin(@PathVariable("rtype") Integer Rid,Model model, Kyujin kyujin) {
        model.addAttribute("rtype",Rid);
        //DelFlag
        kyujin.setDelFlag(1);
        kyujinListService.deleteKyuJin(kyujin);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 追加「戻る」ボタン押下
     */
    @RequestMapping("addModoru/{rtype}")
    public String addModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/kyujinList/kyujin/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/kyujinList/kyujin/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/kyujinList/kyujin/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/kyujinList/kyujin/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 追加確認画面「戻る」ボタン押下
     */
    @RequestMapping("addKauninModoru/{rtype}")
    public String addKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyujin kyujin) {
        model.addAttribute("rtype",Rid);
        model.addAttribute("kyujin",kyujin);
        return "KigyoJohoToroku";
    }
}
