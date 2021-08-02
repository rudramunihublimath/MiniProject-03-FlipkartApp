package com.rph.flipkartapp.repo;

import com.rph.flipkartapp.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MobileRepo extends JpaRepository<Mobile, Serializable> {

    @Query("Select distinct(brand) from Mobile")
    public List<String> findBrandNames();

    @Query("Select distinct(ram) from Mobile")
    public List<Integer> findMobileRam();

    @Query("Select distinct(rating) from Mobile")
    public List<Integer> findMobileRating();



}
