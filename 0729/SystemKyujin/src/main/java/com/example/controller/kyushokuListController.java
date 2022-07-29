package com.example.controller;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;
import com.example.service.kyushokuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView kyushokuListJoho(@PathVariable("rtype") Integer Rid) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("kyushokujoho");
        //设置数据
        List<Kyushoku> KyushokuList = kyushokuListService.kyushokuList();
        //管理機能
        mav.addObject("Rid",Rid);

        mav.addObject("kyushokulist",KyushokuList);

        return mav;
    }

    /*
     * 「履歴書を作成」画面の管理機能
     */
    @RequestMapping("KojinJohoTouRoku/{rtype}")
    public ModelAndView KojinJohoTouRoku(@PathVariable("rtype") Integer Rid) {
        ModelAndView mav = new ModelAndView();
        //设置jsp路径
        mav.setViewName("KojinJohoTouRoku");
        //设置数据
        mav.addObject("Rid",Rid);

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
    @RequestMapping("/add")
    public String addKojinShosai(Kyushoku kyushoku, Model model) {
        model.addAttribute("kyushoku",kyushoku);
        return "forward:/KojinJohoShinkiKakunin.jsp";
    }

    /*
     * 求職追加確認
     */
    @RequestMapping("/addKakunin")
    public String addKakunin(Kojin kojin, Kyushoku kyushoku) {
        //保存员工信息
        kyushokuListService.addKyuShokuList(kojin,kyushoku);

        return "redirect:kyushoku/1";
    }

    /*
     * 求職詳細画面
     */
    @RequestMapping("/detail")
    public String detailKyushoku(Integer id, Model model){
        //根据id查询员工
        Kyushoku kyushoku = kyushokuListService.idByKyushoku(id);
        //放入model
        model.addAttribute("kyushoku",kyushoku);
        return "forward:/KojinShoSai.jsp";
    }


    /*
     * 求職変更確認画面
     */
    @RequestMapping("/updateKakunin")
    public String updateKakunin(Model model,HttpServletRequest request) {
        String [] ids = request.getParameterValues("KSId");
        for (String id:ids) {
            int Id = Integer.parseInt(id);
            //根据id查询员工
            Kyushoku kyushoku = kyushokuListService.idByKyushoku(Id);
            //放入model
            model.addAttribute("kyushoku",kyushoku);
            return "forward:/KojinJohoHenkouKakunin.jsp";
        }
        return "forward:/KojinShoSai.jsp";
    }

    /*
     * 求職変更画面
     */
    @RequestMapping("/update")
    public String updateKyushoku(Kyushoku kyushoku) {
        kyushokuListService.updateKyuShoku(kyushoku);
        return "redirect:kyushoku/1";
    }

    /*
     * 求職削除機能
     */
    @RequestMapping("/deleteKyuShoku")
    public String deleteKakunin(HttpServletRequest request,Kyushoku kyushoku) {
        try {
            String [] ids = request.getParameterValues("KSId");
            for (String id:ids) {
                int Id = Integer.parseInt(id);
                //DelFlag
                kyushoku.setDelFlag(1);
                kyushokuListService.deleteKyuShoku(kyushoku);
                return "redirect:kyushoku/1";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:kyushoku/1";
        }
        return "redirect:kyushoku/1";
    }
}
