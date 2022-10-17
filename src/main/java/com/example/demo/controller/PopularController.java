package com.example.demo.controller;

import com.example.demo.entity.CiDoBetweenMoveCopy;
import com.example.demo.entity.MonGoobulMoveCopy;
import com.example.demo.service.PopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PopularController {

    @Autowired
    PopularService popularService;

    @GetMapping(value = "/popular/first")
    public String popularfirst(Model model){

        List<CiDoBetweenMoveCopy> ciDoBetweenMoveCopy =
                popularService.popularWhere();

        List<MonGoobulMoveCopy> monGoobulMoveCopies =
                popularService.findAndJongro();

        int in_city_amount = ciDoBetweenMoveCopy.get(0).getIn_city();
        int out_city_amount = ciDoBetweenMoveCopy.get(0).getOut_city();
        int in_city_incheon = ciDoBetweenMoveCopy.get(1).getIn_city();
        int out_city_incheon = ciDoBetweenMoveCopy.get(1).getOut_city();
        int in_city_other = ciDoBetweenMoveCopy.get(2).getIn_city();
        int out_city_other = ciDoBetweenMoveCopy.get(2).getOut_city();

        int monGoobul_move_amount_10 =monGoobulMoveCopies.get(0).getAmount2021_10();
        int monGoobul_move_amount_11 =monGoobulMoveCopies.get(0).getAmount2021_11();
        int monGoobul_move_amount_12 =monGoobulMoveCopies.get(0).getAmount2021_12();
        int monGoobul_in_10 =monGoobulMoveCopies.get(1).getAmount2021_10();
        int monGoobul_in_11 =monGoobulMoveCopies.get(1).getAmount2021_11();
        int monGoobul_in_12 =monGoobulMoveCopies.get(1).getAmount2021_12();
        int monGoobul_out_10 =monGoobulMoveCopies.get(2).getAmount2021_10();
        int monGoobul_out_11 =monGoobulMoveCopies.get(2).getAmount2021_11();
        int monGoobul_out_12 =monGoobulMoveCopies.get(2).getAmount2021_12();

        model.addAttribute("in_city_amount",in_city_amount);
        model.addAttribute("out_city_amount",out_city_amount);
        model.addAttribute("in_city_incheon",in_city_incheon);
        model.addAttribute("out_city_incheon",out_city_incheon);
        model.addAttribute("in_city_other",in_city_other);
        model.addAttribute("out_city_other",out_city_other);

        model.addAttribute("monGoobul_move_amount_10",monGoobul_move_amount_10);
        model.addAttribute("monGoobul_move_amount_11",monGoobul_move_amount_11);
        model.addAttribute("monGoobul_move_amount_12",monGoobul_move_amount_12);
        model.addAttribute("monGoobul_in_10",monGoobul_in_10);
        model.addAttribute("monGoobul_in_11",monGoobul_in_11);
        model.addAttribute("monGoobul_in_12",monGoobul_in_12);
        model.addAttribute("monGoobul_out_10",monGoobul_out_10);
        model.addAttribute("monGoobul_out_11",monGoobul_out_11);
        model.addAttribute("monGoobul_out_12",monGoobul_out_12);

        return "/popular/first_page";
    }

    @GetMapping(value = "/popular/mon_goobul")
    public String popularMon(Model model){

        List<CiDoBetweenMoveCopy> ciDoBetweenMoveCopyList = popularService.popularSearch();

       /* for(CiDoBetweenMoveCopy abc : ciDoBetweenMoveCopyList){
            System.out.println(abc.toString());
        }*/
        model.addAttribute("ciDoBetween", ciDoBetweenMoveCopyList);

        return "/popular/mon_goobul";
    }
}
