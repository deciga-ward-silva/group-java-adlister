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
<<<<<<< HEAD
}
=======
}
>>>>>>> 7218a12e0060644bcd8d4ae22259c7c0e7dff609
