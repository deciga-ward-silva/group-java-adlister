package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;


    // This is the constructor for the MySQLAdsDao class. It takes in a Config object and uses the properties of that object to establish a connection to a MySQL database. If an error occurs during the connection process, a RuntimeException is thrown with an error message and the root exception.
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


    // This method overrides the all() method defined in the Ads interface. It retrieves all ads from the ads table in the database by executing a SELECT statement. It returns a List of Ad objects created from the query results using the createAdsFromResults() method. If an exception occurs during the database operation, a RuntimeException is thrown with an error message indicating the failure to retrieve the ads.
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



    // This code block overrides the insert method to insert a new ad into the database.
    //
    //The method takes an Ad object as input, and first creates an INSERT query using a prepared statement, with user_id, title, and description as the values.
    //
    //The prepared statement is executed using the executeUpdate() method, which inserts the new ad into the database. The generated key for the newly inserted ad is obtained using the getGeneratedKeys() method, and the value of the key is returned as a Long.
    //
    //In case of any exceptions during the process, the method throws a RuntimeException with an appropriate error message.
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



    // This method finds and returns a single ad from the database with the specified ID. It takes a Long adId parameter, and returns an Ad object.
    //
    //It first prepares a SELECT statement to retrieve the row of the ad with the matching ID from the ads table.
    //
    //It then sets the adId value as the parameter in the prepared statement and executes it.
    //
    //After that, it retrieves the ResultSet object and moves the cursor to the first row of the ResultSet.
    //
    //Then, it creates and returns a new Ad object by passing values retrieved from the ResultSet object.
    //
    //If the method fails to execute the query, it throws a RuntimeException with an appropriate message.
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


  //   Code We Might Use //

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

        // Define the SQL query for updating an ad with a new title, description, and image URL
        String query = "UPDATE ads SET title = ?, description = ?, image_url = ? WHERE id = ?";

        try {
            // Prepare the SQL statement with placeholders for the new title, description, and image URL
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());

            // Note: this section is currently commented out, but it could be used for updating the image URL if desired
            // stmt.setString(3, ad.getImageUrl());

            // Set the ID placeholder to the ID of the ad being updated
            stmt.setLong(4, ad.getId());

            // Execute the SQL statement and update the ad in the database
            stmt.executeUpdate();

        } catch (SQLException e) {
            // If an error occurs, throw a runtime exception with a helpful error message
            throw new RuntimeException("Error editing ad", e);
        }
    }

     // Deletes an ad from the database with the given ID.
      // @param adId the ID of the ad to be deleted
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

<<<<<<< HEAD
    @Override
    public List<Ad> searchAds(String search) {
        return null;
    }

    @Override
    public List<Ad> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Ad> findByTitle(String title) {
        return null;
    }

=======
// // This is a private method that extracts a single Ad object from a ResultSet. It is used by other methods in the class that retrieve data from the database.
//
//// Extracts a single Ad object from a ResultSet.
//// This method is used by other methods in the class that retrieve data from the database.
//// It takes a ResultSet as an argument and returns a new Ad object.
//// It throws a SQLException if there is an error retrieving the data.
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    /**
     * Creates a list of Ad objects from a given ResultSet object.
     *
     * @param rs the ResultSet object to be used to generate the list of Ad objects
     * @return a list of Ad objects generated from the ResultSet object
     * @throws SQLException if there is an error accessing data in the ResultSet object
     */
    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }


    // searchAds method to search for ads containing searchTerm in title or description
    public List<Ad> searchAds(String searchTerm) {
        try {
            // create SQL query to search for ads based on title and description columns using the LIKE operator
            String searchQuery = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            // prepare statement to execute the search query and set search term parameters
            PreparedStatement stmt = connection.prepareStatement(searchQuery);
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");
            // execute the search query and retrieve results into a ResultSet
            ResultSet rs = stmt.executeQuery();
            // create and return a list of Ad objects based on the ResultSet
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            // throw a runtime exception with error message if an error occurs during the search
            throw new RuntimeException("Error searching for ads.", e);
        }
    }

<<<<<<< HEAD
=======
    // findByUserId method to find all ads associated with a given user ID
    @Override
    public List<Ad> findByUserId(Long userId) {
        try {
            // create SQL query to find all ads associated with the specified user ID
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, userId);
            // execute the query and retrieve results into a ResultSet
            ResultSet rs = stmt.executeQuery();
            // create and return a list of Ad objects based on the ResultSet
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            // throw a runtime exception with error message if an error occurs during the search
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


>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
}

