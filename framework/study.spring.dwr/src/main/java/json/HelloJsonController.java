/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zhouxh
 */
@Controller("helloJsonController")
public class HelloJsonController{

    @RequestMapping("/hello.json")
    protected ModelAndView HelloJson() throws Exception {
        Map model = new HashMap();
        model.put("firstname", "Peter");
        model.put("secondname", "Schmitt");
        model.put("success", false);

        return new ModelAndView("jsonView", model);
    }
}
