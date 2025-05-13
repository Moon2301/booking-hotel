package com.hotel.booking.scrips;

import com.hotel.booking.model.Users;
import com.hotel.booking.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    // Lưu người dùng
    public Users saveUser(Users user) {
        return userRepository.save(user);  // Sửa lại từ UsersRepository.save(user)
    }

    // Xác thực người dùng
    public Users authenticate(String username, String password) {
        Users user = userRepository.findByUsername(username);  // Sửa lại từ UserRepository.findByUsername
        if (user != null && user.getPasswordHash().equals(password)) {
            return user;
        }
        return null;
    }
}
