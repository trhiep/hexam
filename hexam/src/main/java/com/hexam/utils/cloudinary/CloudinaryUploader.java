package com.hexam.utils.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author trhiep
 */
public class CloudinaryUploader {

    public static String uploadImage(String imageLink) {
        Dotenv dotenv = Dotenv.load();
        Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
        cloudinary.config.secure = true;

        String customFileName = UUID.randomUUID().toString();
        Map<String, Object> uploadParam = ObjectUtils.asMap(
                "use_filename", false,
                "unique_filename", true,
                "overwrite", true,
                "public_id",  customFileName
        );

        Map uploadResult;
        try {
            uploadResult = cloudinary.uploader().upload(imageLink, uploadParam);
        } catch (IOException e) {
            System.out.println("Failed to upload!");
            return null;
        }
        return uploadResult.get("url").toString();
    }


}
