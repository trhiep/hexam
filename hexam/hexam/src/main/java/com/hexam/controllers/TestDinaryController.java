package com.hexam.controllers;

import com.hexam.utils.cloudinary.CloudinaryUploader;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author trhiep
 */
@Controller
public class TestDinaryController {

    @RequestMapping(value = "/upload",  method = RequestMethod.GET)
    public String uploadGET() {
        return "pages/teacher/test-cloudinary";
    }

    @RequestMapping(value = "/upload",  method = RequestMethod.POST)
    public String uploadPOST(@RequestParam("image") MultipartFile image, Model model) {
        String uploadedUrl = CloudinaryUploader.uploadImage(image);
        model.addAttribute("uploadedUrl", uploadedUrl);
        return "pages/teacher/test-cloudinary";
    }
}
