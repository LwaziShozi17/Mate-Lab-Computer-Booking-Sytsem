package za.ac.cput.service;

import za.ac.cput.domain.Faculty;

import java.util.List;

public interface IFaculty extends IService<Faculty, String> {
    List<Faculty> findAllFaculties();
}
