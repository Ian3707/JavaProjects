package com.lesson;

import com.lesson.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller()
public class HomeController {
    @Autowired
    AlienRepo repo;

    @ModelAttribute()
    public void modelData(Model model){
        model.addAttribute("name", "Alien");
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int num1,
                      @RequestParam("num2") int num2,
                    Model m){ //| or ModelMap (same) //var 4
        //var1
        //arg: HttpServletRequest request
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        HttpSession session = request.getSession();
//        session.setAttribute("res", (num1+num2));

        //var2
        //arg: HttpSession session
        //session.setAttribute("res", (num1 + num2));

        //var3
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("result");
//        mv.addObject("res", (num1 + num2));
//        return mv;
        m.addAttribute("res", (num1 + num2));

        return "result";
    }

    //@RequestMapping(value = "addAlien", method = RequestMethod.GET)
    //@RequestMapping("addAlien")
//    @GetMapping("addAlien")
//    public String addAlien(@ModelAttribute("res") Alien res){
////        Alien alien = new Alien();
////        alien.setId(id);
////        alien.setName(name);
//        //model.addAttribute("res", alien);
//
//
//        return "show_aliens";
//    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("res") Alien alien, Model model){
        //model.addAttribute("aliens", alien);
        repo.save(alien);
        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model){
        model.addAttribute("aliens", repo.findAll());

        return "show_aliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam("id") int id, Model model){
        model.addAttribute("aliens", repo.getOne(id));

        return "show_aliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam("name") String name, Model model){
        model.addAttribute("aliens", repo.find(name));

        return "show_aliens";
    }

    @GetMapping("deleteAlien")
    public String deleteAlien(@RequestParam("id") int id, Model model){
        repo.deleteById(id);
        model.addAttribute("aliens", repo.findAll());
        return "show_aliens";
    }

//    @GetMapping("getAliens")
//    public String getAliens(Model m){
//        List<Alien> aliens = Arrays.asList(
//                new Alien(1, "Sam"),
//                new Alien(2, "Bob"),
//                new Alien(3, "Adam"));
//
//        m.addAttribute("aliens", aliens);
//        return "show_aliens";
//    }
}
