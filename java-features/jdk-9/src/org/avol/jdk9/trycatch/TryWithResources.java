package org.avol.jdk9.trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
        //try(BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));)  in jdk7.
        try (reader1) {
            System.out.println(reader1.readLine());
        }
    }
}
