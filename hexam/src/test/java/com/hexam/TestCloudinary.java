package com.hexam;

import com.hexam.utils.cloudinary.CloudinaryUploader;

/**
 * @author trhiep
 */
public class TestCloudinary {
    public static void main(String[] args) {
        String uploadedUrl = CloudinaryUploader.uploadImage("C:\\Users\\tranh\\Pictures\\Saved Pictures\\Screenshot 2022-10-08 001913.png");
        System.out.println(uploadedUrl);
    }
}
