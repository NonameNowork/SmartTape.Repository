package by.bsu.smarttape.controllers;

import by.bsu.smarttape.models.User;
import by.bsu.smarttape.utils.presentation.HeaderModel;
import by.bsu.smarttape.utils.services.ActiveSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeedController {
    @GetMapping("/nl-feed")
    public String feed(Model model, HttpServletRequest request) {
        User user = ActiveSessionService.getUserBySession(request.getSession());
        HeaderModel header = HeaderModel.getInstance(user, true);
        model.addAttribute("header", header);
        return "views/feed/nl-feed";
    }
}
