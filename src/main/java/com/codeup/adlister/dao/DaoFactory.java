package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao; // instance of Ads DAO
    private static Users usersDao; // instance of Users DAO
    private static Config config = new Config(); // instance of configuration class

    // Get the Ads DAO instance
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config); // create a new instance if it doesn't exist
        }
        return adsDao; // return the Ads DAO instance
    }

    // Get the Users DAO instance
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config); // create a new instance if it doesn't exist
        }
        return usersDao; // return the Users DAO instance
    }

    // Get the Categories DAO instance (not implemented)
    public static Ads getCategoriesDao() {
        return null;
    }

    public static Ads getCategoriesDao() {
        return null;
    }
}