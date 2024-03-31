package com.example.StructurHome.controller;

import com.example.StructurHome.Model.Dto.Request.HomeRequest;
import com.example.StructurHome.Model.Dto.Response.HomeResponse;
import com.example.StructurHome.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

//    public HomeController(HomeService homeService) {
//        this.homeService = homeService;
//    }

    @GetMapping
    public ResponseEntity<List<HomeResponse>> getAllHomes() {
        List<HomeResponse> homes = homeService.getAllHomes();
        return ResponseEntity.ok(homes);
    }

    @GetMapping("number/{number}")
    public ResponseEntity<HomeResponse> getHomeByNumber(@PathVariable("number") Long number) {
        HomeResponse home = homeService.getHomeByNumber(number);
        return ResponseEntity.ok(home);
    }

    //   @GetMapping("/number")
    //  public ResponseEntity<HomeResponse> getHomeByNumber(@RequestParam("number") Long number) {
    //     HomeResponse homeResponse = homeService.getHomeByNumber(number);
    //    return ResponseEntity.ok(home);
    //  }


//    @GetMapping("/number")
//    public ResponseEntity<HomeResponse> getHomeByNumber(@RequestHeader("number") Long number) {
//        HomeResponse home = homeService.getHomeByNumber(number);
//        return ResponseEntity.ok(home);
//    }

    @PostMapping
    public ResponseEntity<Void> addHome(@RequestBody HomeRequest homeRequest ) {
        homeService.addHome(homeRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/number/{number}")
    public ResponseEntity<Void> updateHome(@PathVariable Long number,
                                             @RequestBody HomeRequest homeRequest ) {
        homeService.updateHome(number, homeRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/number/{number}")
    public ResponseEntity<Void> updateHomeFloor(@PathVariable Long number,
                                                @RequestParam Integer floor) {
        homeService.updateHomeFloor(number, floor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/number/{number}")
    public ResponseEntity<Void> deleteHomeByNumber(@PathVariable Long number){
        homeService.deleteHome(number);
        return ResponseEntity.ok().build();
    }

}
