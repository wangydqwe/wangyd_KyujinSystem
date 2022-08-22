package com.example.controller;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;
import com.example.entity.User;
import com.example.service.kyushokuListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 求職情報機能
 * クラス名：kyushokuListController
 * 機能：求人リストに関する機能
 * 引数：なし
 * 戻り値：なし
 * バージョン：1.000.000 by wangyd
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
     * 求職情報機能
     * 関数名：kyushokuListJoho
     * 機能：求職情報リストデータの取得
     * 引数：Integer Rid
     * 　　　Integer startpage
     * 　　　Integer pagesize
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("kyushoku/{rtype}")
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid,
                                         Integer startpage,
//2022.08.12 by wangyd add version.1.000.000
//                                         Integer pagesize
                                         Integer pagesize,
                                         Kyushoku kyushoku,
                                         HttpSession session) {
        ModelAndView mav = new ModelAndView();
        pagesize = 10;
        //设置jsp路径
        mav.setViewName("kyushokujoho");
//2022.08.12 by wangyd add start version.1.000.000
        //获取session信息
        User user = (User) session.getAttribute("user");
        Integer Rtype = (Integer) session.getAttribute("rtype");
        kyushoku.setMail(user.getMail());
//2022.08.12 add end
        //设置数据
        PageHelper.startPage(startpage,pagesize);
//2022.08.12 by wangyd update start version.1.000.000
//        List<Kyushoku> KyushokuList = kyushokuListService.kyushokuList();
        List<Kyushoku> KyushokuList = kyushokuListService.kyushokuList(kyushoku.getMail(),Rtype);
        PageInfo<Kyushoku> PageList = new PageInfo<>(KyushokuList);
        mav.addObject("kyushokulist",PageList);
        //管理機能
        mav.addObject("Rid",Rid);
        return mav;
    }

    /*
     * 「履歴書を作成」画面の管理機能
     * 関数名：KojinJohoTouRoku
     * 機能：「履歴書を作成」画面の管理機能
     * 引数：Integer Rid
     *      Kyushoku kyushoku
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("KojinJohoTouRoku/{rtype}")
    public ModelAndView KojinJohoTouRoku(@PathVariable("rtype") Integer Rid,
                                         Kyushoku kyushoku,
                                         HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KojinJohoTouRoku");
        //设置数据
        User user = (User)session.getAttribute("user");
        kyushoku.setMail(user.getMail());
        mav.addObject("rtype",Rid);
        mav.addObject("kyushoku",kyushoku);
        return mav;
    }

    /*
     * トップページ」画面の管理
     * 関数名：toppage
     * 機能：トップページ」画面の管理機能
     * 引数：Integer Rid
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
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
     * 関数名：detailKyushoku
     * 機能：求職追加の処理
     * 引数：Integer Rid
     * 　　　Kyushoku kyushoku
     * 　　　Model model
     * 戻り値：KojinJohoShinkiKakunin.jsp
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/add/{rtype}")
    public String addKojinShosai(@PathVariable("rtype") Integer Rid,
                                 @Valid Kyushoku kyushoku,
                                 BindingResult bindingResult,
                                 Model model) {
        try {
            Map<String,Object> map = new HashMap<>();
            if (bindingResult.hasErrors()) {
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                //遍历报错信息集合取出每一个
                for (FieldError fieldError : fieldErrors) {
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                model.addAttribute("kyushoku",kyushoku);
                model.addAttribute("rtype",Rid);
                model.addAttribute("errorInfo", map);
                return "forward:/list/KojinJohoTouRoku/" + Rid;
            }
            model.addAttribute("kyushoku",kyushoku);
            model.addAttribute("rtype",Rid);
            return "forward:/KojinJohoShinkiKakunin.jsp";
        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/list/KojinJohoTouRoku/" + Rid;
        }

    }

    /*
     * 求職追加確認
     * 関数名：detailKyushoku
     * 機能：求職追加確認の処理
     * 引数：Integer Rid
     * 　　　Kojin kojin
     * 　　　Kyushoku kyushoku
     * 　　　Model model
     * 戻り値："redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/addKakunin/{rtype}")
    public String addKakunin(@PathVariable("rtype") Integer Rid,Kojin kojin, Kyushoku kyushoku, Model model) {
        //保存员工信息
        kyushokuListService.addKyuShokuList(kojin,kyushoku);
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }

    /*
     * 求職詳細画面
     * 関数名：detailKyushoku
     * 機能：求職詳細画面の処理
     * 引数：Integer Rid
     * 　　　Integer id
     * 　　　Model model
     * 戻り値：KojinShoSai.jsp
     * バージョン：1.000.000 by wangyd
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
     * 関数名：KyushokuUpdate
     * 機能：求職変更画面の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　HttpServletRequest request
     * 戻り値："redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/updateKakunin/{rtype}")
    public String KyushokuUpdate(@PathVariable("rtype") Integer Rid,Model model,HttpServletRequest request) {
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
     * 求人変更確認画面
     * 関数名：updateKakunin
     * 機能：求人変更確認画面の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　Kyushoku kyushoku
     * 　　　HttpServletRequest request
     * 戻り値："KigyoJohoHenkouKakunin"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/henkouKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,
                                Model model,
                                @Valid Kyushoku kyushoku,
                                BindingResult bindingResult) {
        try {
            Map<String, Object> map = new HashMap<>();
            if (bindingResult.hasErrors()) {
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                //遍历报错信息集合取出每一个
                for (FieldError fieldError : fieldErrors) {
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                model.addAttribute("errorInfo", map);
                model.addAttribute("kyushoku",kyushoku);
                model.addAttribute("rtype",Rid);
                return "forward:/UpdKojinJoho.jsp";
            }
            Kyushoku oldKyushoku = kyushokuListService.idByKyushoku(kyushoku.getKSId());
            model.addAttribute("kyushoku",kyushoku);
            model.addAttribute("rtype",Rid);
            if (oldKyushoku.getKojinName().equals(kyushoku.getKojinName()) &&
                    oldKyushoku.getYakuShokuName().equals(kyushoku.getYakuShokuName()) &&
                    oldKyushoku.getKyoyu().equals(kyushoku.getKyoyu()) &&
                    oldKyushoku.getJusho1().equals(kyushoku.getJusho1()) &&
                    oldKyushoku.getTele().equals(kyushoku.getTele()) &&
                    oldKyushoku.getMail().equals(kyushoku.getMail()) &&
                    oldKyushoku.getBiko().equals(kyushoku.getBiko())){
                String error = "データは変更されていません";
                model.addAttribute("error", error);
                return "forward:/UpdKojinJoho.jsp";
            }
            return "KojinJohoHenkouKakunin";
        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/UpdKojinJoho.jsp";
        }
    }
    /*
     * 変更
     * 関数名：updateKyushoku
     * 機能：変更の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　Kyushoku kyushoku
     * 戻り値："KigyoJohoHenkouKakunin"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("update/{rtype}")
    public String updateKyushoku(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        kyushokuListService.updateKyuShoku(kyushoku);
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 求職削除確認画面
     * 関数名：deleteKakunin
     * 機能：求職削除確認画面の処理
     * 引数：Integer Rid
     *      Model model
     *      HttpServletRequest request
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
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
     * 関数名：deleteKyuShoku
     * 機能：求職削除機能
     * 引数：Integer Rid
     *      Model model
     *      Kyushoku kyushoku
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/deleteKyuShoku/{rtype}")
    public String deleteKyuShoku(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        //DelFlag
        kyushoku.setDelFlag(1);
        kyushokuListService.deleteKyuShoku(kyushoku);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 「閉める」ボタン押下
     */
    @RequestMapping("close/{rtype}")
    public String shosaiClose(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 更新「戻る」ボタン押下
     * 関数名：shosaiClose
     * 機能：更新「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("updateModoru/{rtype}")
    public String updateModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 更新確認画面「戻る」ボタン押下
     * 関数名：updKauninModoru
     * 機能：更新確認画面「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     *      Kyushoku kyushoku
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("updKauninModoru/{rtype}")
    public String updKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        Integer Ksid = kyushoku.getKSId();
        return "UpdKojinJoho.jsp?KSId=" + Ksid;
    }
    /*
     * 追加「戻る」ボタン押下
     * 関数名：addModoru
     * 機能：追加「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("addModoru/{rtype}")
    public String addModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 追加確認画面「戻る」ボタン押下
     * 関数名：addKauninModoru
     * 機能：追加確認画面「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     *      Kyushoku kyushoku
     * 戻り値："KigyoJohoToroku"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("addKauninModoru/{rtype}")
    public String addKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyushoku kyushoku) {
        model.addAttribute("rtype",Rid);
        model.addAttribute("kyushoku",kyushoku);
        return "KojinJohoTouRoku";

    }
    /*
     * 削除確認画面「戻る」ボタン押下
     * 関数名：deleteModoru
     * 機能：求職削除確認画面の処理
     * 引数：Integer Rid
     *      Model model
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("deleteModoru/{rtype}")
    public String deleteModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/list/kyushoku/" + Rid +"?startpage=1&pagesize=10";
    }
}
