package com.hexam.utils.loader;

import com.hexam.config.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

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
