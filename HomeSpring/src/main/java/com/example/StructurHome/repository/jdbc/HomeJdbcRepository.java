package com.example.StructurHome.repository.jdbc;

import java.util.List;
import com.example.StructurHome.Model.Entity.Home;

public interface HomeJdbcRepository {
    List<Home> getAll();
    Home getByNumber(Long number);
    boolean insert(Home home );
    boolean update(Home home);
    boolean updateFloor(Long number, Integer floor);
    boolean delete(Long number);

}
