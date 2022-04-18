package com.amado.service;

import com.amado.model.users;
import com.amado.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class userService implements UserDetailsService {

    @Autowired
    usersRepository usersRepository;

    public users create(users u){
        return usersRepository.save(u);
    }

    public users update(users a){
        users b = usersRepository.findById(a.getId()).get();
        if(a.getEmail() != b.getEmail()){
            b.setEmail(a.getEmail());
        }
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getLast() != b.getLast()){
            b.setLast(a.getLast());
        }
        if(a.getNumber() != b.getNumber()){
            b.setNumber(a.getNumber());
        }
        if(a.getPassword() != b.getPassword()){
            b.setPassword(a.getPassword());
        }
        return usersRepository.save(b);
    }
    public users findById(int id){
        Optional<users> a = usersRepository.findById(id);
        if(a.isPresent()){
            return  a.get();
        }
        return null;
    }

    public users findByEmail(String email){
        Optional<users> a = usersRepository.findByEmailIgnoreCase(email);
        if(a.isPresent()){
            return a.get();
        }
        return null;
    }

    public List<users> getAll(){
        return usersRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users userData = usersRepository.findByEmailIgnoreCase(username).get();
        if(userData == null){
            throw new UsernameNotFoundException("Invalid email address");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new User(userData.getEmail(),userData.getPassword(),grantedAuthorities);
    }
}
