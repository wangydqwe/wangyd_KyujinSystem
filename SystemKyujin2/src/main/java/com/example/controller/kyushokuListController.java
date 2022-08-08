package com.example.controller;

import com.example.entity.Kojin;
import com.example.entity.Kyujin;
import com.example.entity.Kyushoku;
import com.example.service.kyushokuListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//20220806 wangyide:kyushokuListControllerクラスの作成
/*、
 *　情報開発list
 */
@Controller
@RequestMapping("/list")
public class kyushokuListController {
    private final kyushokuListService kyushokuListService;
    @Autowired
    public kyushokuListController(kyushokuListService kyushokuListService){
        this.kyushokuListService = kyushokuListService;
    }

    /*
     * 求職情報画面
     */
    @RequestMapping("kyushoku/{rtype}")
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid,
                                         Integer startpage,
                                         Integer pagesize) {
        ModelAndView mav = new ModelAndView();
        pagesize = 10;
        //设置jsp路径
        mav.setViewName("kyushokujoho");
        //设置数据
        PageHelper.startPage(startpage,pagesize);
        List<Kyushoku> KyushokuList = kyushokuListService.kyushokuList();
        PageInfo<Kyushoku> PageList = new PageInfo<>(KyushokuList);
        mav.addObject("kyushokulist",PageList);
        //管理機能
        mav.addObject("Rid",Rid);
        return mav;
    }

    /*
     * 「履歴書を作成」画面の管理機能
     */
    @RequestMapping("KojinJohoTouRoku/{rtype}")
    public ModelAndView KojinJohoTouRoku(@PathVariable("rtype") Integer Rid,Kyushoku kyushoku) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KojinJohoTouRoku");
        //设置数据
        mav.addObject("rtype",Rid);
        mav.addObject("kyushoku",kyushoku);
        return mav;
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
     * 求職追加
     */
    @RequestMapping("/add/{rtype}")
    public String addKojinShosai(@PathVariable("rtype") Integer Rid,Kyushoku kyushoku, Model model) {
        model.addAttribute("kyushoku",kyushoku);
        model.addAttribute("rtype",Rid);
        return "forward:/KojinJohoShinkiKakunin.jsp";
    }

    /*
     * 求職追加確認
     */
    @RequestMapping("/addKakunin/{rtype}")
    public String addKakunin(@PathVariable("rtype") Integer Rid,Kojin kojin, Kyushoku kyushoku, Model model) {
        //保存员工信息
        kyushokuListService.addKyuShokuList(kojin,kyushoku);
        model.addAttribute("rtype",Rid);

        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }

    /*
     * 求職詳細画面
     */
    @RequestMapping("/detail/{rtype}")
    public String detailKyushoku(@PathVariable("rtype") Integer Rid,Integer id, Model model){
        //根据id查询员工
        Kyushoku kyushoku = kyushokuListService.idByKyushoku(id);
        //放入model
        model.addAttribute("kyushoku",kyushoku);
        model.addAttribute("rtype",Rid);
        return "forward:/KojinShoSai.jsp";
    }


    /*
     * 求職変更画面
     */
    @RequestMapping("/updateKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,Model model,HttpServletRequest request) {
        try {
            String [] ids = request.getParameterValues("KSId");
            if (ids.length != 1){
                return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
            }
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //根据id查询员工
                Kyushoku kyushoku = kyushokuListService.idByKyushoku(Id);
                //放入model
                model.addAttribute("kyushoku",kyushoku);
                model.addAttribute("rtype",Rid);
                return "forward:/UpdKojinJoho.jsp";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
        }
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 求職変更確認画面
     */
    @RequestMapping("/henkouKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("kyushoku",kyushoku);
        model.addAttribute("rtype",Rid);
        return "KojinJohoHenkouKakunin";
    }
    /*
     * 変更
     */
    @RequestMapping("update/{rtype}")
    public String updateKyushoku(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        kyushokuListService.updateKyuShoku(kyushoku);
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 求職削除確認画面
     */
    @RequestMapping("/deleteKakunin/{rtype}")
    public String deleteKakunin(@PathVariable("rtype") Integer Rid,Model model,HttpServletRequest request) {
        try {
            String [] ids = request.getParameterValues("KSId");
            if (ids.length != 1){
                return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
            }
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //根据id查询员工
                Kyushoku kyushoku = kyushokuListService.idByKyushoku(Id);
                //放入model
                model.addAttribute("kyushoku",kyushoku);
                model.addAttribute("rtype",Rid);
                return "forward:/KojinJohoDeleteKakunin.jsp";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
        }

        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 求職削除機能
     */
    @RequestMapping("/deleteKyuShoku/{rtype}")
    public String deleteKyuShoku(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        //DelFlag
        kyushoku.setDelFlag(1);
        kyushokuListService.deleteKyuShoku(kyushoku);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 「閉める」ボタン押下
     */
    @RequestMapping("close/{rtype}")
    public String shosaiClose(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 更新「戻る」ボタン押下
     */
    @RequestMapping("updateModoru/{rtype}")
    public String updateModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 更新確認画面「戻る」ボタン押下
     */
    @RequestMapping("updKauninModoru/{rtype}")
    public String updKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        Integer Ksid = kyushoku.getKSId();
        if (Rid == 1){
            return "redirect:/list/updateKakunin/1?KSId="+Ksid;
        } else if (Rid == 2) {
            return "redirect:/list/updateKakunin/2?KSId="+Ksid;
        } else if (Rid == 3) {
            return "redirect:/list/updateKakunin/3?KSId="+Ksid;
        }else {
            return "redirect:/list/updateKakunin/4?KSId="+Ksid;
        }
    }
    /*
     * 追加「戻る」ボタン押下
     */
    @RequestMapping("addModoru/{rtype}")
    public String addModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
    /*
     * 追加確認画面「戻る」ボタン押下
     */
    @RequestMapping("addKauninModoru/{rtype}")
    public String addKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        model.addAttribute("kyushoku",kyushoku);
        return "KojinJohoTouRoku";

    }
    /*
     * 削除確認画面「戻る」ボタン押下
     */
    @RequestMapping("deleteModoru/{rtype}")
    public String deleteModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        if (Rid == 1){
            return "redirect:/list/kyushoku/1?startpage=1&pagesize=10";
        } else if (Rid == 2) {
            return "redirect:/list/kyushoku/2?startpage=1&pagesize=10";
        } else if (Rid == 3) {
            return "redirect:/list/kyushoku/3?startpage=1&pagesize=10";
        }else {
            return "redirect:/list/kyushoku/4?startpage=1&pagesize=10";
        }
    }
}
