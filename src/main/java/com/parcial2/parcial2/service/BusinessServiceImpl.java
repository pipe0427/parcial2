package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.entity.Business;
import com.parcial2.parcial2.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService{
    
    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public List<Business> listAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).get();
    }

    @Override
    public Business updateBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

    
}
