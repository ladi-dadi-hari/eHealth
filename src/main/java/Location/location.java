package Location;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class location {

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        String address;
        int radius;

        Scanner scan = new Scanner(System.in);
        location loc = new location();
        List<Float> lat_lng;
        List<Float> doc_lat_lng;



        System.out.println("Bitte geben sie ihre Adresse ein.");
        address = loc.checkUmlaut();
        lat_lng = loc.getLocInfo(address);

        System.out.println("Lat = " + lat_lng.get(0) + "\n" + "Lng = " + lat_lng.get(1));

        System.out.println("Bitte geben sie den Radius (in km) ein in dem sie suchen wollen");
        radius = scan.nextInt();

        System.out.println("Bitte geben sie die Art des Doctors ein nach der sie suchen wollen");
        String doc_art = loc.checkUmlaut();

        System.out.println("Bitte geben sie die Adresse des Doctors ein");
        String doc_adresse = loc.checkUmlaut();
        doc_lat_lng = loc.getLocInfo(doc_adresse);

        float distance = loc.getDistance(lat_lng.get(0), lat_lng.get(1), doc_lat_lng.get(0), doc_lat_lng.get(1));

        System.out.println(distance);

        /*if(distance <= radius)
        {

        }*/


    }

    final private String key = "AIzaSyBVcFqOaiopJLsNjMUnLYhMxuAEoWXu9hg";
    Scanner scan = new Scanner(System.in);

    public String checkUmlaut()
    {
        String address = scan.nextLine();
        String new_address = address.replace("ß", "ss")
                .replace("ü", "ue")
                .replace("ä", "ae")
                .replace("ö", "oe");
        return new_address;

    }


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



    public float getDistance(float lat, float lng, float doc_lat, float doc_lng)
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


