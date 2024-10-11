package lesson;

import lesson.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
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

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("res") Alien res){
//        Alien alien = new Alien();
//        alien.setId(id);
//        alien.setName(name);
        //model.addAttribute("res", alien);
        return "result";
    }
}
