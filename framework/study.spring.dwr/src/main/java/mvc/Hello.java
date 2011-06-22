package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("helloController")  
public class Hello {  
    /** 
     * User Dao 
     */  
    private UserDao userDao;  
  
    /** 
     * Employee dao 
     */  
    private EmployeeDao employeeDao;  
  
    @RequestMapping("/sayHello.htm")
    public String sayHello(ModelMap map) {  
        String str = "hello";  
        System.out.println(str);  
        map.put("Hello", "World!");
        return str;  
    }  
  
    public User getUser(String userName) {  
        User user = this.getUserDao().getUser();  
        user.setName(user.getName() + " _ "  
                + this.getEmployeeDao().getEmployeeName());  
        return user;  
    }  
  
    @RequestMapping(params = "method=sayBye")  
    public ModelAndView sayBye() {  
        String str = "bye";  
        System.out.println(str);  
        return null;  
    }

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}  
  
}  
