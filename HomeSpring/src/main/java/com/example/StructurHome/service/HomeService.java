package com.example.StructurHome.service;


import com.example.StructurHome.Model.Dto.Request.HomeRequest;
import com.example.StructurHome.Model.Dto.Response.HomeResponse;

import java.util.List;
public interface HomeService {
    List<HomeResponse> getAllHomes();
    HomeResponse getHomeByNumber(Long number);
    void addHome(HomeRequest homeRequest);
    void updateHome(Long number, HomeRequest homeRequest);

    void updateHomeFloor(Long number, Integer floor);
    void deleteHome(Long number);

}