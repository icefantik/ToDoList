package com.example.todolist;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TasksFile {
    private static final String nameFile = "Tasks.txt";
    public static void writeInFile(String dataTask)
    {
        try (FileWriter writer = new FileWriter(nameFile))
        {
            writer.write(dataTask);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void readFromFile()
    {
        try (FileReader reader = new FileReader(nameFile))
        {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
