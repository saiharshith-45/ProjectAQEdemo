package com.AQEproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@SpringBootApplication
public class DemoAqeProjectApplication {
	@GetMapping("/project")
    public String home() {
        return "index";
    }
	@GetMapping("/welcome")
    public String welcome(@RequestParam(name="employeeName", required=false, defaultValue="Employee") String employeeName, Model model) {
        model.addAttribute("employeeName", employeeName);
        return "welcome";
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoAqeProjectApplication.class, args);
	}

}
