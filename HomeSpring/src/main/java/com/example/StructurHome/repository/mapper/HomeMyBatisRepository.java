package com.example.StructurHome.repository.mapper;


import com.example.StructurHome.Model.Entity.Home;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper

public interface HomeMyBatisRepository {

    List<Home> findAll();
        Optional<Home> findByNumber(@Param("number") Long number); //Paramsizda olar
        void insert(Home home);
        void update(Home home);
        void updateFloor(@Param("number") Long number, @Param("floor") Integer floor);
        void delete(@Param("number") Long number);

    }


