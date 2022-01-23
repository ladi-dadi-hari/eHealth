package Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Hashing {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input password");

        String salt = getSalt();
        //System.out.println(salt);

        System.out.println(doHashing(scanner.nextLine(), salt));

    }



    public static String doHashing (String password, String salt) {

        String hashedpw = null;
        try {

            // final String salt = "123456789";

            // Choosing the hashing algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-512");


            // Add salt to complicate password dictionary attacks
            password = password + salt;


            // passing byte-array of password + salt to messageDigest.digest()
            md.update(password.getBytes());


            // bytehashedpassword is the hashed pw as a byte-array
            byte[] bytehashedpassword = md.digest();


            // Stringbuilder coverts the byte-array to String
            StringBuilder sb = new StringBuilder();


            // The digits get iterated one by one and appended to one String in Hexadec
            for (byte b : bytehashedpassword) {
                sb.append(String.format("%02x", b));
            }

            hashedpw = sb.toString();

        }
        catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        }
        return hashedpw;
    }


    // Generate random salt and return as String

    public static String getSalt() {

        SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];

        random.nextBytes(salt);

        String s = new String(salt);

        return s;
    }


}
