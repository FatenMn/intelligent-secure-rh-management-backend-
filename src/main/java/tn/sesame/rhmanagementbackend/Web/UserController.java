package tn.sesame.rhmanagementbackend.Web;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.sesame.rhmanagementbackend.Services.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired

   private final UserService userService;



}
