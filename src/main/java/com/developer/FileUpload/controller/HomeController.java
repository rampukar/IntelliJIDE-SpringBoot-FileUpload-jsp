package com.developer.FileUpload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Pukar on 6/17/2017.
 */
@Controller
public class HomeController {
    private static String UPLOAD_FOLDER = "D://filebox//";
    @RequestMapping("/")
    public String doHome(){
        return "index";
    }

    @PostMapping("/upload")
    public ModelAndView fileUpload(@RequestParam("filex") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return new ModelAndView("status", "message", "Please select a file and try again");
        }
        try {
            // read and write the file to the slelected location-
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("status", "message", "File Uploaded sucessfully");
    }
}
