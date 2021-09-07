package com.spring.security.demo.app.service;

import com.spring.security.demo.app.model.PasswordResetToken;
import com.spring.security.demo.app.model.Role;
import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.model.UserPrincipal;
import com.spring.security.demo.app.repository.PasswordTokenRepository;
import com.spring.security.demo.app.repository.UserRepository;
import com.spring.security.demo.app.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordTokenRepository passwordTokenRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto, String hashcode) {

        User user = new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                             userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")), hashcode);


        return userRepository.save(user);
    }

    @Override
    public void activateAccount(String email, String hashcode) {

        userRepository.activateAccount(email, hashcode);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Invalid email or password!");
        }
        return new UserPrincipal(user);

//                org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));

    }



//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    @Override
    public void createPasswordResetTokenForUser(User user, String token, Date currentdate) {

        PasswordResetToken myToken = new PasswordResetToken(token, user, currentdate);
        passwordTokenRepository.save(myToken);
    }

    }

