package newProject.publicData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/calendar")
    public String calendar(){
        return "calendar";
    }
}
