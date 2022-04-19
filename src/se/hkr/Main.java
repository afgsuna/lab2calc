package se.hkr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Calculation: Addition, Subtraction, Division, Multiplication");
        connectToCloud("add",93,46);
        connectToCloud("sub",93,46);
        connectToCloud("div",93,46);
        connectToCloud("mul",93,46);

    }

    private static void connectToCloud(String operation, int numberone, int numbertwo) throws IOException {
        StringBuilder result = new StringBuilder();

        URL url = new URL("https://lab2calcapp.herokuapp.com/calc?operation=" + operation +
                "&numberone=" + numberone + "&numbertwo=" + numbertwo);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (var reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            System.out.print("Answer:  ");
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.println(result.toString());
    }
}
