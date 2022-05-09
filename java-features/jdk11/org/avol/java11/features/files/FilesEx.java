package org.avol.java11.features.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class FilesEx {
    public static void main(String[] args) throws IOException {
        //Files.writeString() static method introduced in Java 11.
        Path file = Files.writeString(Files.createTempFile(Path.of("."), "f", ".txt"), "Hello world");
        String fc = Files.readString(file);
        System.out.println(fc);
        assert fc.contains("Hello world");
    }
}
