package com.example.controller;

import com.example.entity.Kyushoku;
import com.example.service.JohoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    /*
     * 求職list
     */
    @RequestMapping("kyushoku")
    public String kyushokuListJoho(HttpServletRequest request, Model model){

        //获取list
        List<Kyushoku> KyushokuList = johoListService.kyushokuList();

        //request.setAttribute("KyushokuList",KyushokuList);
        model.addAttribute("KyushokuList",KyushokuList);
        return "forward:/kyushokujoho.jsp";
    }
}
