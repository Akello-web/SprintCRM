package kz.sprint.techboot.sprintSecond.controller;

import kz.sprint.techboot.sprintSecond.model.ApplicationRequest;
import kz.sprint.techboot.sprintSecond.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AppService appService;

    @GetMapping(value = "/")
    public String mainPage(Model model){
        model.addAttribute("apps", appService.getApps());
        return "index";
    }

    @PostMapping(value = "/add-app")
    public String addApplication(ApplicationRequest appRequest){
        appService.addApps(appRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/add-app")
    public String addApplicationPage(){
        return "addApp";
    }

    @GetMapping(value = "/new-apps")
    public String newApps(Model model){
        model.addAttribute("apps", appService.getApps());
        return "newApps";
    }

    @GetMapping(value = "/old-apps")
    public String oldApps(Model model){
        model.addAttribute("apps", appService.getApps());
        return "oldApps";
    }

    @GetMapping(value = "/details/{appId}")
    public String appDetails(@PathVariable(name = "appId") Long id, Model model){
        ApplicationRequest app = appService.getApp(id);
        model.addAttribute("appById", app);
        return "details";
    }

    @PostMapping(value = "/handle-app")
    public String handleApp(ApplicationRequest appRequest){
        appService.handledApp(appRequest);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-app")
    public String deleteApp(Long id){
        appService.deleteApp(id);
        return "redirect:/";
    }

}
