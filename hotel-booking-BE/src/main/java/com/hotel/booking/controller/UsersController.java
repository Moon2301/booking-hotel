package com.hotel.booking.controller;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.model.LoginRequest;
import com.hotel.booking.model.UserDTO;
import com.hotel.booking.model.Users;
import com.hotel.booking.repository.KhachHangRepository;
import com.hotel.booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        if (usersRepository.findByUsername(userDTO.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username đã tồn tại");
        }

        Users user = new Users();
        user.setUsername(userDTO.getUsername());
        user.setPasswordHash(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        // Tìm khách hàng theo maKH
        KhachHang kh = khachHangRepository.findById(userDTO.getMaKH()).orElse(null);
        if (kh == null) {
            return ResponseEntity.badRequest().body("Khách hàng không tồn tại");
        }
        user.setKhachHang(kh);
        usersRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        user.setUserID(id);
        return usersRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersRepository.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestBody LoginRequest loginRequest) {
        Users user = usersRepository.findByUsername(loginRequest.getUsername());

        if (user != null && user.getPasswordHash().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
