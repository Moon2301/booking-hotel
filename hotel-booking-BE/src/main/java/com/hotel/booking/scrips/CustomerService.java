package com.hotel.booking.scrips;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.repository.KhachHangRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private KhachHangRepository customerRepository;

    public KhachHang saveCustomer(KhachHang customer) {
        return customerRepository.save(customer);
    }
}
