//package com.example.StructurHome.mapper;
//
//import com.example.StructurHome.Model.Dto.Request.HomeRequest;
//import com.example.StructurHome.Model.Dto.Response.HomeResponse;
//import com.example.StructurHome.Model.Entity.Home;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class HomeMapperOld {
//
//    public List<HomeResponse> toHomeResponseList(List<Home> homeList) {
//        List<HomeResponse> homeResponseList = new ArrayList<>();
//
//        for (Home home : homeList) {
//            HomeResponse homeResponse = toHomeResponse(home);
//            homeResponseList.add(homeResponse);
//        }
//
//        return homeResponseList;
//    }
//
//    public HomeResponse toHomeResponse(Home home) {
//        HomeResponse homeResponse = HomeResponse.builder()
//                .number(home.getNumber())
//                .area(home.getArea())
//                .repaircondition(home.getRepaircondition())
//                .floor(home.getFloor())
//                .type(home.getType())
//                .place(home.getPlace())
//                .roominformation(home.getRoominformation())
//                .build();
//
//        return homeResponse;
//    }
//
//    public Home toHome(HomeRequest homeRequest) {
//        return Home.builder()
//                .area(homeRequest.getArea())
//                .repaircondition(homeRequest.getRepaircondition())
//                .floor(homeRequest.getFloor())
//                .type(homeRequest.getType())
//                .place(homeRequest.getPlace())
//                .roominformation(homeRequest.getRoominformation())
//                .build();
//    }
//
//    public Home toHome(Long number, HomeRequest homeRequest) {
//        return Home.builder()
//                .number(number)
//                .area(homeRequest.getArea())
//                .repaircondition(homeRequest.getRepaircondition())
//                .floor(homeRequest.getFloor())
//                .type(homeRequest.getType())
//                .place(homeRequest.getPlace())
//                .roominformation(homeRequest.getRoominformation())
//                .build();
//    }
//
//}