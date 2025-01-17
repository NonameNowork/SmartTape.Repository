package by.bsu.smarttape.controllers;

import by.bsu.smarttape.models.User;
import by.bsu.smarttape.utils.services.ActiveSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/debug")
public class DebugController {

    public static class SessionInfo {
        private User user;
        private String session;

        public SessionInfo(User user, String session) {
            this.user = user;
            this.session = session;
        }

        public String getSession() {
            return session;
        }

        public User getUser() {
            return user;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    @GetMapping("/sessions")
    public String getSessions(Model model) {;
        List<SessionInfo> infoList = new ArrayList<>();
        for (String session : ActiveSessionService.getSessions())
            infoList.add(new SessionInfo(ActiveSessionService.getUserByString(session), session));
        for (SessionInfo info : infoList)
            System.out.println(info.getSession() + " | " + info.getUser().getId());
        model.addAttribute("items", infoList);
        model.addAttribute("nowtime", System.currentTimeMillis());
        return "views/debug/debug-sessions";
    }

}
