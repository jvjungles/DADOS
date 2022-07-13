package pos.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pos.dados.entity.User;
import pos.dados.repository.UserRepository;
import pos.dados.service.UserService;

/**
 * Class UserController
 */
@Controller
public class UserController {


  @Autowired
  private UserService userService;
  
  @Autowired
  private UserRepository userDao;

  @RequestMapping(value="/usercreate")
  public String create(
          String email, String name, Model model) {

    User user = userService.create(email, name);
    model.addAttribute("user", user);
    return "/test";
  }
  
  @RequestMapping(value="/userdelete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/userget-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }
  
  @RequestMapping(value="/userupdate")
  @ResponseBody
  public String updateName(long id, String email, String name) {
    try {
      User user = userDao.getById(id);
      user.setEmail(email);
      user.setName(name);
      userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }  
}
