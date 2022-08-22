package com.example.controller;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;
import com.example.entity.User;
import com.example.service.kyujinListService;
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
 * 求人情報機能
 * クラス名：kyujinListController
 * 機能：求人リストに関する機能
 * 引数：なし
 * 戻り値：なし
 * バージョン：1.000.000 by wangyd
 */
@Controller
@RequestMapping("/kyujinList")
public class kyujinListController {
    private final kyujinListService kyujinListService;
    @Autowired
    public kyujinListController(kyujinListService kyujinListService){

        this.kyujinListService = kyujinListService;
    }

    /*
     * 求人情報機能
     * 関数名：kyushokuListJoho
     * 機能：求人情報リストデータの取得
     * 引数：Integer Rid
     * 　　　Integer startpage
     * 　　　Integer pagesize
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("kyujin/{rtype}")
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid,
                                         Integer startpage,
//2022.08.12 by wangyd update version.1.000.000
//                                         Integer pagesize
                                         Integer pagesize,
                                         Kyujin kyujin,
                                         HttpSession session) {
        ModelAndView mav = new ModelAndView();
        pagesize = 10;
        //设置jsp路径
        mav.setViewName("kyujinjoho");
//2022.08.12 by wangyd add start version.1.000.000
        //获取session信息
        User user = (User) session.getAttribute("user");
        Integer Rtype = (Integer) session.getAttribute("rtype");
        kyujin.setMail(user.getMail());
//2022.08.12 add end
        //设置数据
        PageHelper.startPage(startpage,pagesize);
        List<Kyujin> KyujinList = kyujinListService.kyujinList(kyujin.getMail(),Rtype);
        PageInfo<Kyujin> PageList = new PageInfo<>(KyujinList);
        mav.addObject("kyujinlist",PageList);
        //管理機能
        mav.addObject("Rid",Rid);
        return mav;
    }
    /*
     * 求人詳細画面
     * 関数名：detailKyujin
     * 機能：求人詳細画面の処理
     * 引数：Integer Rid
     * 　　　Integer id
     * 　　　Model model
     * 戻り値：KigyoShosai.jsp
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/detail/{rtype}")
    public String detailKyujin(@PathVariable("rtype") Integer Rid,
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
     * 関数名：detailKyushoku
     * 機能：求人追加の処理
     * 引数：Integer Rid
     * 　　　Kyujin kyujin
     * 　　　Model model
     * 戻り値：KigyoJohoShinkiKakunin.jsp
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/add/{rtype}")
    public String addKojinShosai(@PathVariable("rtype") Integer Rid,
                                 @Valid Kyujin kyujin,
                                 BindingResult bindingResult,
                                 Model model) {
        try {
            Map<String,Object> map = new HashMap<>();
            if (bindingResult.hasErrors()){
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                //遍历报错信息集合取出每一个
                for (FieldError fieldError:fieldErrors) {
                    map.put(fieldError.getField(),fieldError.getDefaultMessage());
                }
                model.addAttribute("kyujin",kyujin);
                model.addAttribute("rtype",Rid);
                model.addAttribute("errorInfo",map);
                return "forward:/kyujinList/KigyoJohoToroku/" + Rid;
            }
            model.addAttribute("kyujin",kyujin);
            model.addAttribute("rtype",Rid);
            return "forward:/KigyoJohoShinkiKakunin.jsp";
        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/kyujinList/KigyoJohoToroku/" + Rid;
        }

    }
    /*
     * 求人追加確認
     * 関数名：addKakunin
     * 機能：求人追加確認の処理
     * 引数：Integer Rid
     * 　　　Kaisha kaisha
     * 　　　Kyujin kyujin
     * 　　　Model model
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/addKakunin/{rtype}")
    public String addKakunin(@PathVariable("rtype") Integer Rid,
                             Kaisha kaisha,
                             Kyujin kyujin,
                             Model model) {
        //保存员工信息
        kyujinListService.addKyujinList(kaisha,kyujin);
        model.addAttribute("rtype",Rid);
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 求人変更画面
     * 関数名：KyujinUpdate
     * 機能：求人変更画面の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　HttpServletRequest request
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/updateKakunin/{rtype}")
    public String KyujinUpdate(@PathVariable("rtype") Integer Rid,
                                Model model,
                                HttpServletRequest request) {
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
     * 関数名：updateKakunin
     * 機能：求人変更確認画面の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　Kyujin kyujin
     * 　　　HttpServletRequest request
     * 戻り値："KigyoJohoHenkouKakunin"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/henkouKakunin/{rtype}")
    public String updateKakunin(@PathVariable("rtype") Integer Rid,
                                Model model,
                                @Valid Kyujin kyujin,
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
                model.addAttribute("kyujin",kyujin);
                model.addAttribute("rtype",Rid);
                return "forward:/UpdKigyoJoho.jsp";
            }
            Kyujin oldkyujin = kyujinListService.idByKyushoku(kyujin.getKJId());
            model.addAttribute("kyujin",kyujin);
            model.addAttribute("rtype",Rid);
            if (oldkyujin.getKaishaName().equals(kyujin.getKaishaName()) &&
                    oldkyujin.getYakuShokuName().equals(kyujin.getYakuShokuName()) &&
                    oldkyujin.getKyoyu().equals(kyujin.getKyoyu()) &&
                    oldkyujin.getJusho1().equals(kyujin.getJusho1()) &&
                    oldkyujin.getTele().equals(kyujin.getTele()) &&
                    oldkyujin.getMail().equals(kyujin.getMail()) &&
                    oldkyujin.getBiko().equals(kyujin.getBiko())){
                String error = "データは変更されていません";
                model.addAttribute("error", error);
                return "forward:/UpdKigyoJoho.jsp";
            }
            return "KigyoJohoHenkouKakunin";
        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/UpdKigyoJoho.jsp";
        }
    }

    /*
     * 変更
     * 関数名：updateKyushoku
     * 機能：変更の処理
     * 引数：Integer Rid
     * 　　　Model model
     * 　　　Kyujin kyujin
     * 戻り値："KigyoJohoHenkouKakunin"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/update/{rtype}")
    public String updateKyushoku(@PathVariable("rtype") Integer Rid,
                                 Model model,
                                 Kyujin kyujin) {
        kyujinListService.updateKyuJin(kyujin);
        model.addAttribute("rtype",Rid);
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
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
     * 「求人広告掲載」画面の管理機能
     * 関数名：KigyoJohoToroku
     * 機能：「求人広告掲載」画面の管理機能
     * 引数：Integer Rid
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("KigyoJohoToroku/{rtype}")
    public ModelAndView KigyoJohoToroku(@PathVariable("rtype") Integer Rid,
                                        Kyujin kyujin,
                                        HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KigyoJohoToroku");
        //设置数据
        User user = (User)session.getAttribute("user");
        kyujin.setMail(user.getMail());
        mav.addObject("kyujin",kyujin);
        mav.addObject("Rid",Rid);

        return mav;
    }

    /*
     * 閉める」ボタン押下
     * 関数名：shosaiClose
     * 機能：閉める」ボタン押下のとき、前画面へ戻る
     * 引数：Integer Rid
     *      Model model
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("close/{rtype}")
    public String shosaiClose(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
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
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }
    /*
     * 更新確認画面「戻る」ボタン押下
     * 関数名：updKauninModoru
     * 機能：更新確認画面「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     *      Kyujin kyujin
     * 戻り値：mav
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("updKauninModoru/{rtype}")
    public String updKauninModoru(@PathVariable("rtype") Integer Rid,
                                  Model model,
                                  Kyujin kyujin) {
        model.addAttribute("rtype",Rid);
        model.addAttribute("kyujin",kyujin);
        Integer Kjid = kyujin.getKJId();
        return "UpdKigyoJoho.jsp?KJId=" + Kjid;
    }

    /*
     * 求人削除確認画面
     * 関数名：deleteKakunin
     * 機能：求人削除確認画面の処理
     * 引数：Integer Rid
     *      Model model
     *      HttpServletRequest request
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
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
     * 関数名：deleteModoru
     * 機能：求職削除確認画面の処理
     * 引数：Integer Rid
     *      Model model
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/deleteModoru/{rtype}")
    public String deleteModoru(@PathVariable("rtype") Integer Rid,Model model) {
        model.addAttribute("rtype",Rid);
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }

    /*
     * 求人削除機能
     * 関数名：deleteKakunin
     * 機能：求人削除機能
     * 引数：Integer Rid
     *      Model model
     *      Kyujin kyujin
     * 戻り値："redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/deleteKyujin/{rtype}")
    public String deleteKakunin(@PathVariable("rtype") Integer Rid,
                                Model model,
                                Kyujin kyujin) {
        model.addAttribute("rtype",Rid);
        //DelFlag
        kyujin.setDelFlag(1);
        kyujinListService.deleteKyuJin(kyujin);
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
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
        return "redirect:/kyujinList/kyujin/" + Rid +"?startpage=1&pagesize=10";
    }

    /*
     * 追加確認画面「戻る」ボタン押下
     * 関数名：addKauninModoru
     * 機能：追加確認画面「戻る」ボタン押下
     * 引数：Integer Rid
     *      Model model
     *      Kyujin kyujin
     * 戻り値："KigyoJohoToroku"
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("addKauninModoru/{rtype}")
    public String addKauninModoru(@PathVariable("rtype") Integer Rid,Model model,Kyujin kyujin) {
        model.addAttribute("Rid",Rid);
        model.addAttribute("kyujin",kyujin);
        return "KigyoJohoToroku";
    }
}
