package ru.kuzmin.demohelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HelloController {

    @Value("${app.word}")
    private String word;

    @Value("${app.pathToFile}")
    private String pathToFile;
    private int counter;

    @GetMapping
    public String hello(Model model) throws IOException {
        model.addAttribute("word", word);
        model.addAttribute("time", new Date().toString());
        File file = new File(pathToFile);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("file created");
            }
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lineToRead = reader.readLine();
        if (lineToRead != null) {
            System.out.println(lineToRead);
            counter = Integer.parseInt(lineToRead.split(" ")[1]);
        }
        reader.close();
//        File file1 = ResourceUtils.getFile("classpath:file.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        StringBuilder stringBuilder = new StringBuilder("");
        counter++;
        stringBuilder.append("hello ").append(counter).append(" ");
        writer.write(stringBuilder.toString());
        writer.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));

        String line = reader1.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = reader1.readLine();
        }
        reader1.close();
        model.addAttribute("file", stringBuilder);
        return "Hello";
    }

}
