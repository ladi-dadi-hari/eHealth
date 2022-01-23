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
        int radius;
        String address;

        Scanner scan = new Scanner(System.in);
        location loc = new location();
        List<Float> lat_lng;



        System.out.println("Bitte geben sie ihre Adresse ein.");
        address = loc.checkUmlaut();
        lat_lng = loc.getLocInfo(address);

        System.out.println("Lat = " + lat_lng.get(0) + "\n" + "Lng = " + lat_lng.get(1));

        System.out.println("Bitte geben sie den Radius (in km) ein in dem sie suchen wollen");
        radius = scan.nextInt();

        System.out.println("Bitte geben sie die Art des Doctors ein nach der sie suchen wollen");
        String doc_art = loc.checkUmlaut();

        String neu = loc.getDoc(radius, lat_lng.get(0), lat_lng.get(1), doc_art);

        System.out.println(loc.createDoc(neu));
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



    public String getDoc(int rad, float lat, float lng, String doc_art) throws IOException
    {
        int radius = rad * 1000;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request doc = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                        "location="+ lat +"%2C" + lng +
                        "&radius="+ radius +
                        "&type=Location.doctor" +
                        "&keyword=" + doc_art +
                        "&key=" + key)
                .method("GET", null)
                .build();

        //call response
        Response doc_response = client.newCall(doc).execute();

        //safe response (JSON) as string
        String doc_data = Objects.requireNonNull(doc_response.body().string());

        doc_response.close();

        /*-------------------------------------------------------------------------------*/

        System.out.println(doc_data);

        return doc_data;
    }

    public List<String> createDoc(String doc_data)
    {
        List<String> namemitAdresse = new ArrayList<>();


        String[] split = doc_data.split("business_status");


        for(int y = 0; y <= split.length; y++) {
            int i = split[y+1].indexOf("name");
            int x = split[y+1].indexOf("\"opening_hours");
            String a = split[y+1].substring(i, x);

            a = a.replace("name\" : \"", "")
                    .replace("\",\n", "");

            namemitAdresse.add(a);
        }
        /* namemitAdresse.add(a); */

        /*return namemitAdresse[]*/


        return namemitAdresse;

    }

}
