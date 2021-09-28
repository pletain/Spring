package pletain.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("spring_api")
  @ResponseBody
  public spring_api api(@RequestParam("key_value") String key) {
    spring_api a = new spring_api();
    a.setKey(key);
    return a;
  }



  static class spring_api {
    private String key;

    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

  }

}