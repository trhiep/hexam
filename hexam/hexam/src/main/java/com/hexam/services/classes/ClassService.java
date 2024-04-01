package com.hexam.services.classes;

import com.hexam.models.Classes;

/**
 * @author trhiep
 */
public interface ClassService {
    void saveClass(Classes classes);
    Classes getClassByJoinCode(String joinCode);
    Classes getClassByClassUrl(String classUrl);
}
