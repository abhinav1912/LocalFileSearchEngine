package org.example;

import FileUtils.ConfigData;
import FileUtils.ConfigReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter path to config file: ");
            String configPath = reader.readLine();
            ConfigData config = ConfigReader.readConfig(configPath);
            config.cleanConfig();
            System.out.println(config.getIncludedPaths());
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}