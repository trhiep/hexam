package com.hexam.services.classes;

import com.hexam.models.Classes;

/**
 * @author trhiep
 */
public interface ClassService {
    void saveClass(Classes classes);
    Classes getClassesByJoinCode(String joinCode);
}
