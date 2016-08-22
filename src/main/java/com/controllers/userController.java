package com.controllers;

import com.business.data.UserDAO;
import com.business.model.User;
import com.utilities.Encryptor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by zakaria on 02/08/2016.
 */

@RestController
public class userController {

    @RequestMapping(value="/register.do", method = RequestMethod.GET)
    public String viewRegistration(ModelMap model)
    {
        model.addAttribute("userForm", new User());
        return "Registration";
    }

    @RequestMapping(value="/register.do",method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, ModelMap errors)
    {
        if(UserDAO.insertUser(user)==null)
        {
            errors.addAttribute("error","error while inserting user");
            return "redirect:/register";
        }
        else
             return   "RegistrationSuccess";
    }

    @RequestMapping(value="/profile/update.do", method = RequestMethod.GET)
    public String viewProfileUpdate(ModelMap model)
    {
        model.addAttribute("userForm", new User());
        return "updateProfile";
    }

    @RequestMapping(value="profile/update.do",method= RequestMethod.POST)
    public String updateUser(@ModelAttribute("userForm") User user, ModelMap errors)
    {
        if(UserDAO.updateUser(user)==null)
        {
            errors.addAttribute("error","error while updating user");
            return "redirect:/profile";
        }
        else
            return "UpdateSuccess";
    }

    @RequestMapping(value="profile/updatePassword.do",method = RequestMethod.POST)
    public String updatePassword(HttpServletRequest request, ModelMap model)
    {
        if(request.getParameter("newPwd")!=null)
        {
            User u=UserDAO.getUser(Long.parseLong(request.getParameter("id")));
            u.getAuth().setPassword(request.getParameter("newPwd"));
            if(UserDAO.updateUser(u)==null)
            {
                model.addAttribute("error", "Error while updating Password");
                return "redirect:/profile";
            }
            else
            {
                return "PasswordUpdateSuccess";
            }
        }
        else
        {
            model.addAttribute("error", "Error while updating Password, newPwd is null");
            return "redirect:/profile";
        }
    }

    @RequestMapping(value="/connexion.do",method = RequestMethod.POST)
    public String Connexion(HttpServletRequest request,ModelMap model)
    {
        if(UserDAO.getAll().size()>0)
        {
            for ( User u : UserDAO.getAll())
            {
                User user = u;
                if (request.getParameter("email").equals(u.getAuth().getEmail()))
                    try
                    {
                        if(Encryptor.testPassword(request.getParameter("password"), user.getAuth().getPassword()))
                        {
                            model.addAttribute("userid",user.getUserId());
                            return "ConnexionSuccess";
                        }
                    }
                    catch (NoSuchAlgorithmException e)
                    {
                        e.printStackTrace();
                    }
            }
            model.addAttribute("message","no user found");
        }
        else
            model.addAttribute("Error","List user empty");
        return "redirect:/connexion";
    }

    //TO DO : I forgot my password !!
}
