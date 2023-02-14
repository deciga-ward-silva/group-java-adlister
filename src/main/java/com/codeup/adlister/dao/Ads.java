package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad findOne(Long adId);

    void update(Ad ad);

    void delete(Long adId);

    List <Ad>searchAds(String search);

    List<Ad> findByUserId(Long userId);

    public List<Ad> findByTitle(String title);


}