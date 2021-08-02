package com.rph.flipkartapp.service;

import com.rph.flipkartapp.binding.SearchForm;
import com.rph.flipkartapp.entity.Mobile;
import com.rph.flipkartapp.repo.MobileRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    public List<String> getBrandNames(){
        return mobileRepo.findBrandNames();
    }

    public List<Integer> getMobileRam() {
        return mobileRepo.findMobileRam();
    }

    public List<Integer> getMobileRating() {
        return mobileRepo.findMobileRating();
    }

    public List<Mobile> filterProduct(SearchForm formObj){
        Mobile entity = new Mobile();
        if( null!=formObj.getBrand() && !"".equals(formObj.getBrand()) ){
            entity.setBrand(formObj.getBrand());
        }

        entity.setRam(formObj.getRam());
        entity.setRating(formObj.getRating());
        Example<Mobile> example= Example.of(entity);
        List<Mobile> all = mobileRepo.findAll(example);
        if(null!=formObj.getPrice()) {
            return filterMobilesByPrice(all, formObj.getPrice());
        }
        return all;
    }

    private List<Mobile> filterMobilesByPrice(List<Mobile> mobiles, Double price) {
        List<Mobile> filteredArraylist= new ArrayList<>();
        mobiles.forEach( mobile -> {
                    if(mobile.getPrice() <= price){
                        filteredArraylist.add(mobile);
                    }
                });
        return filteredArraylist;
    }


}
