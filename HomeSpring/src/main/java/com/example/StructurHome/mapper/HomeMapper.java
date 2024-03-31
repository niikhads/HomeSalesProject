package com.example.StructurHome.mapper;

import com.example.StructurHome.Model.Dto.Request.HomeRequest;
import com.example.StructurHome.Model.Dto.Response.HomeResponse;
import com.example.StructurHome.Model.Entity.Home;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HomeMapper {
    HomeMapper INSTANCE = Mappers.getMapper(HomeMapper.class);
    List<HomeResponse> toHomeResponseList(List<Home> homeList);
    @Mapping(target = "number", source = "number", qualifiedByName = "buildUserFriendHome")
    HomeResponse toHomeResponse(Home home);
    @Named("buildUserFriendHome")
    default Long buildUserFriendHome(Long number){
        if(number == null){
            return null;
        }
      return  number+1;  // numbere hemise +1 verir 3 versen 4 gonderir
    };



  //  @Mapping(target = "number", constant = "5L")//sabit olaraq numbere 5 verir(Ustune 5 de gele bilir) sorus??
    Home toHome(HomeRequest homeRequest);
  //  @Mapping(target = "number" , source = "number") // Ferq nedir
  //  @Mapping(target = "area" , source = "homeRequest.area")
  // @Mapping(target = "repaircondition" , source = "homeRequest.repaircondition")
  // @Mapping(target = "floor" , source = "homeRequest.floor")
  // @Mapping(target = "type" , source = "homeRequest.type")
  // @Mapping(target = "place" , source = "homeRequest.place") //place  de bir field varsa meselen place.kv
  // @Mapping(target = "roominformation" , source = "homeRequest.roominformation")

    Home toHome(Long number, HomeRequest homeRequest);
}
