package Location;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**<h1> Location Search</h1>
 * This class provides all functionalities to search for location of an address (Longitude and Latitude),
 * save those values into our databse and later calculate the distance between the patient and the doctors from our database by using the haversine formula.
 * @author Maximilian Rabe
 */

public class location {

   /* public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        String address;
        int radius;

        Scanner scan = new Scanner(System.in);
        location loc = new location();
        List<Float> lat_lng;
        List<Float> doc_lat_lng;




        System.out.println("Bitte geben sie ihre Adresse ein.");

        lat_lng = loc.getLocInfo(loc.checkUmlaut(loc.getAddress()));

        System.out.println("Lat = " + lat_lng.get(0) + "\n" + "Lng = " + lat_lng.get(1));

        System.out.println("Bitte geben sie den Radius (in km) ein in dem sie suchen wollen");
        radius = scan.nextInt();

        System.out.println("Bitte geben sie die Art des Doctors ein nach der sie suchen wollen");
       // String doc_art = loc.checkUmlaut();

        doc_lat_lng = loc.getLocInfo(loc.checkUmlaut(loc.getAddress()));

        float distance = loc.getDistance(lat_lng.get(0), lat_lng.get(1), doc_lat_lng.get(0), doc_lat_lng.get(1));

        System.out.println(distance);

        /*if(distance <= radius)
        {

        }


    }*/


    static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    static final String USER = "root";
    static final String AUTH_STRING ="TokyoGhoul^^123";
    final private String key = "AIzaSyCuFtEOQhiW5_JlW0J2IE3YX6_sh3LwCbw";
    Scanner scan = new Scanner(System.in);


    /**
     * This method
     * @return
     */
    public String getAddress()
    {
        String loc = "";
        try
        {
            Connection connect = DriverManager.getConnection(DB_URL, USER, AUTH_STRING);
            String sql_statement = "SELECT address FROM Users.doctor";
            PreparedStatement getAddress = connect.prepareStatement(sql_statement);
            ResultSet rs = getAddress.executeQuery();

            while(rs.next())
            {
                loc = rs.getString("address");
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return loc;
    }


    /**
     * This method (checkUmlaut) checks, if a mutated vowel exists in the given address, replaces that mutated vowel and returns the paraphased address.
     * It is used especially for the search of the location's longitude and latitude, since the Google API, we use, doesn't recognize mutated vowels.
     * @param addresse
     * @return
     */

    public static String checkUmlaut(String addresse)
    {

        String new_address = addresse.replace("ß", "ss")
                .replace("ü", "ue")
                .replace("ä", "ae")
                .replace("ö", "oe");
        return new_address;

    }

    /**
     * The method getLocInfo takes a string containing the users address and
     * returns the longitude and latitude for the given address in a list of the type float.
     * By building a package of information, containing the predefined API Key (taken from the Google API website) and the address string,
     * and using the GeocodingAPI method to send this package to the Google Service, we receive a GeocodingResults Array.
     * The GeocodingResults Array contains all sorts of information about the address,
     * for example the place_id given by Google or ..., but for us, only the values for the latitude and the longitude are of use.
     * We then store both values into a list of the data type float called lat_lng and return that list.
     *
     * @param address
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws ApiException
     * @return
     */

    public List<Float> getLocInfo(String address) throws IOException, InterruptedException, ApiException {
        List<Float> lat_lng = new ArrayList<>(2);

        GeoApiContext setAuthorization = new GeoApiContext.Builder()
                .apiKey(key)
                .build();

        GeocodingResult[] getResults =  GeocodingApi.geocode(setAuthorization,
                address).await();

        lat_lng.add((float) getResults[0].geometry.location.lat);
        lat_lng.add((float) getResults[0].geometry.location.lng);

        setAuthorization.shutdown();

        return lat_lng;
    }

    /**
     * This method calculates the distance between two points using the haversine formula.
     * getDistance receives four float values, first the latitude, second the longitude, both belonging to the patient,
     * third another latitude and fourth another longitude, both belonging to the doctor.
     * The method then
     *
     * @param lat
     * @param lng
     * @param doc_lat
     * @param doc_lng
     * @return
     */

    public static float getDistance(float lat, float lng, float doc_lat, float doc_lng)
    {
        final int earth_radius = 6371;

        double distance_lat = Math.toRadians(doc_lat - lat);
        double distance_lng = Math.toRadians(doc_lng - lng);
        double a = Math.sin(distance_lat / 2) * Math.sin(distance_lat / 2)
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(doc_lat))
                * Math.sin(distance_lng / 2) * Math.sin(distance_lng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earth_radius * c; // convert to meters


        distance = Math.pow(distance, 2);

        return (float) Math.sqrt(distance);

    }


    }


