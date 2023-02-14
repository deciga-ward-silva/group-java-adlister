package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad findOne(Long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where id = ?");
            ResultSet rs = stmt.executeQuery();
            stmt.setLong(1, adId);
            rs.next();
            return new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    // Code We Might Use //

//    @Override
//    public Ad findOne(Long adId) {
//        String query = "SELECT * FROM ads WHERE id = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setLong(1, adId);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return extractAd(rs);
//            }
//            return null;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding ad with ID: " + adId, e);
//        }
//    }

    @Override
    public void update(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ?, image_url = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());

//            We might use this code for images. //
//            stmt.setString(3, ad.getImageUrl());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error editing ad", e);
        }
    }

    @Override
    public void delete(Long adId) {
        try {
            String deleteQuery = "DELETE FROM ads WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setLong(1, adId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public List<Ad> searchAds(String searchTerm) {
        try {
            String searchQuery = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(searchQuery);
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");
            ResultSet rs = stmt.
                    executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for ads.", e);
        }
    }

    @Override
    public List<Ad> findByUserId(Long userId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by user ID: " + userId, e);
        }
    }


    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
                1,
                1,
                "playstation for sale",
                "This is a slightly used playstation"
        ));
        ads.add(new Ad(
                2,
                1,
                "Super Nintendo",
                "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
                3,
                2,
                "Junior Java Developer Position",
                "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
                4,
                2,
                "JavaScript Developer needed",
                "Must have strong Java skills"
        ));
        return ads;
    }

    public List<Ad> findByTitle(String title) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ?");
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by title: " + title, e);
        }
    }


}