package ra.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ra.jdbc.service.ISongService;

@Controller
//@RequestMapping
public class Songcontroller {
    @Autowired
    private ISongService songService;
    @RequestMapping (value = "/home",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("list",songService.findAll()

        );
        return "home";
    }
    @RequestMapping (value = "/search",method = RequestMethod.GET)
    public String search(@RequestParam String search, Model model){
        model.addAttribute("list",songService.findSongByName(search));
        model.addAttribute("search",search);
    }
}
