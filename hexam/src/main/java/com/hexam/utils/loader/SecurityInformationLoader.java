package com.hexam.utils.loader;

import com.hexam.config.CustomUserDetails;
import com.hexam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author trhiep
 */
public class SecurityInformationLoader {

    public static CustomUserDetails getCustomUserDetails() {
        try {
            return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException classCastException) {
            return null;
        }
    }

}
