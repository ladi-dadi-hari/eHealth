package Location;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        if(distance <= radius)
        {

        }


    }

    /*
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
    }*/
    final private String key = "AIzaSyCuFtEOQhiW5_JlW0J2IE3YX6_sh3LwCbw";

    /**
     * checkUmlaut
     * This method (checkUmlaut) checks, if a mutated vowel exists in the given address, replaces that mutated vowel and returns the paraphrased address.
     * It is used especially for the search of the location's longitude and latitude, since the Google API, we use, doesn't recognize mutated vowels.
     * @param addresse
     * @return
     *
     * @author Maximilian Rabe
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
     * getLocInfo
     * The method getLocInfo takes a string containing the users address and
     * returns the longitude and latitude for the given address in a list of the type float.
     * By building a package of information, containing the predefined API Key (taken from the Google API website) and the address string,
     * and using the GeocodingAPI method to send this package to the Google Service, we receive a GeocodingResults Array.
     * The GeocodingResults Array contains all sorts of information about the address,
     * for example the place_id given by Google, what sort of establishment it is and more, but for us, only the values for the latitude and the longitude are of use.
     * We then store both values into a list of the data type float called lat_lng and return that list.
     *
     * @param address
     * @throws IOException
     * @throws InterruptedException
     * @throws ApiException
     * @return List of data type Float, containing latitude and longitude of address
     *
     * @author Maximilian Rabe
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
     * getDistance (Haversine Formula for distance)
     * This method calculates the distance between two points using the haversine formula.
     * getDistance receives four float values, first the latitude, second the longitude, both belonging to the patient,
     * third another latitude and fourth another longitude, both belonging to the doctor.
     * It then returns the calculated distance between both points as a float variable.
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

        double distance_lat = Math.toRadians(doc_lat - lat);                            //conversion into radiants (earth isnt flat)
        double distance_lng = Math.toRadians(doc_lng - lng);                            //conversion into radiants (earth isnt flat)
        double radiants_doclat = Math.toRadians(doc_lat);                               //doctor lat to radiants
        double radiants_patlat = Math.toRadians(lat);                                   //patient lat to radiants
        double x = Math.sin(distance_lat / 2) * Math.sin(distance_lat / 2)              //
                + Math.cos(radiants_patlat) * Math.cos(radiants_doclat)                 //
                * Math.sin(distance_lng / 2) * Math.sin(distance_lng / 2);              // Harversine Formula
        double distance = 2 * earth_radius * Math.asin(Math.sqrt(x)) ;                         //


        return (float) distance;

    }


    }


