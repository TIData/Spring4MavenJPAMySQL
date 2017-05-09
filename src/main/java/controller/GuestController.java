package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GuestDao;

@Controller
public class GuestController {
    
    @Autowired
    private GuestDao guestDao;
    
    @RequestMapping(value = "/guest",method = RequestMethod.GET)
    public String listGuest(Model model){
        model.addAttribute("guestList",guestDao.findAll());
        return "guest";
    }
}
