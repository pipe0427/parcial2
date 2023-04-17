package com.parcial2.parcial2.service;

import java.util.List;

import com.parcial2.parcial2.entity.Business;

public interface BusinessService {
    
    public List<Business> lisAllBusinesses();

    public Business saveBusiness(Business business);

    public Business getBusinessById(Long id);

    public Business updateBusiness(Business business);

    public void deleteBusiness(Long id);
}
