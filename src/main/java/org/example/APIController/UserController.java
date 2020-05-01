package org.example.APIController;

import org.example.DataAccessLayer.Repository;
import org.example.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    Repository repo = new Repository();
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/user")
    public Users getUser(@RequestParam String username)
    {
        if(repo.getUser(username) == null)
        {
            return null;
        }
        return repo.getUser(username);
    }

    @PostMapping("/user")
    public String addUser(@RequestBody Users user)
    {

        if(repo.getUser(user.getUSER_ID()) != null)
            return "User Id Not Available";
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPASSWORD());
        user.setPASSWORD(encodedPassword);
        boolean status = repo.addUser(user);

        if(status)
        {
            return "Successful";
        }
        return "Unsuccessful";
    }
}
