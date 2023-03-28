package com.sg.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
//UserDAOService -> Static List
//public List<User> findAll()
 // public User save(User user)
 //public User findOne(int id)
    private static List<User> users =new ArrayList<>();
    static Integer count=0;
    static {
        users.add(new User(count++,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(count++,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(count++,"Jim",LocalDate.now().minusYears(20)));

    }
    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        Integer id=user.getId();
        user.setId(count++);
        users.add(user);
        return user;
    }

    public void deleteByID(int id){
        Predicate<? super User> userPredicate=user -> user.getId().equals(id);
        System.out.println("User size before delete "+users.size());
        users.removeIf(userPredicate);
        System.out.println("User size after delete "+users.size());
    }


    public User findUser(Integer id) {
        Predicate<? super User> userPredicate=user -> user.getId().equals(id);
        return users.stream().filter(userPredicate).findFirst().orElse(null);
    }
}
