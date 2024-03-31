package com.example.StructurHome.service.Impl;

import com.example.StructurHome.Model.Dto.Request.HomeRequest;
import com.example.StructurHome.Model.Dto.Response.HomeResponse;
import com.example.StructurHome.Model.Entity.Home;
import com.example.StructurHome.mapper.HomeMapper;
import com.example.StructurHome.repository.jdbc.HomeJdbcRepository;
import com.example.StructurHome.repository.mapper.HomeMyBatisRepository;
import com.example.StructurHome.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor  //22ci setirle bagli
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;
    private final HomeJdbcRepository homeJdbcRepository;
    private final HomeMyBatisRepository homeMyBatisRepository;

//    public HomeServiceImpl(HomeMapper homeMapper, HomeRepository homeRepository) {
//        this.homeMapper = homeMapper;
//        this.homeRepository = homeRepository;
//    }

    @Override
    public List<HomeResponse> getAllHomes() {
        List<Home> homes = homeMyBatisRepository.findAll();

        List<HomeResponse> homeResponseList = homeMapper.toHomeResponseList(homes);

        return homeResponseList;
    }

    @Override
    public HomeResponse getHomeByNumber(Long number) {
        Optional<Home> homeOptional = homeMyBatisRepository.findByNumber(number);
        return homeOptional.map(homeMapper ::toHomeResponse).orElse(null);
        //2ci usul
//        if(homeOptional.isEmpty())
//        {
//            return null;
//        }
        //mybatisden sonra deyisdi opitnial ver
//        Home home = homeJdbcRepository.getByNumber(number);
//
//        HomeResponse homeResponse = homeMapper.toHomeResponse(home);
//
//        return homeResponse;
    }

    @Override
    public void addHome(HomeRequest homeRequest) {
        Home home = homeMapper.toHome(homeRequest);
    //    Home build = Home.builder()
      //                  .a
        homeMyBatisRepository.insert(home);
    }

    @Override
    public void updateHome(Long number, HomeRequest homeRequest) {
        Home home  = homeMapper.toHome(number, homeRequest);
       // homeJdbcRepository.update(home);
        homeMyBatisRepository.update(home);
    }

    @Override
    public void updateHomeFloor(Long number, Integer floor) {
    //    homeJdbcRepository.updateFloor(number, floor);
        homeMyBatisRepository.updateFloor(number,floor);
    }

    @Override
    public void deleteHome(Long number) {
      //  homeJdbcRepository.delete(number);
        homeMyBatisRepository.delete(number);
    }

}