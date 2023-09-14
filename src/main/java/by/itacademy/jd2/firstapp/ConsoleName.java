package by.itacademy.jd2.firstapp;

import de.mklinger.micro.uribuilder.UriBuilder;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsoleName  {

    public static void main(String[] args)  {

        try {
            URL url = new URL("http://localhost:8080/firstapp/hello_with_name");

            Scanner scannerReq = new Scanner(System.in);
            System.out.println("Введите имя");
            String firstname = scannerReq.nextLine();
            System.out.println("Введите фамилию");
            String secondname = scannerReq.nextLine();

             url = new URLBuilder("http://localhost:8080/firstapp/hello_with_name")
                    .withParam("firstname", firstname)
                    .withParam("secondname", secondname)
                    .build();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scannerRes = new Scanner(new BufferedInputStream(connection.getInputStream()));

            while (scannerRes.hasNextLine()) {
                System.out.println(scannerRes.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}








