package pletain.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
  
  @GetMapping("sta")
	public String index2() {
    System.out.println("stasta");  
		return "sta";
	}

  @GetMapping("myname")
  public String myname(@RequestParam("name") String name, Model model) {
    model.addAttribute("name",name);
    return "myname";
  }

	@GetMapping("hi")
	public String hi(Model model) {
		model.addAttribute("data", "hi~!");
    System.out.println("hihi");
		return "hi";
	}
}