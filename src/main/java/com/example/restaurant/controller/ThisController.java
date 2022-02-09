package com.example.restaurant.controller;

import com.example.restaurant.dto.MenuDto;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.Pembeli;
import com.example.restaurant.model.Rider;
import com.example.restaurant.model.TransaksiMapping;
import com.example.restaurant.repository.MenuRepository;
import com.example.restaurant.repository.PembeliRepository;
import com.example.restaurant.repository.RiderRepository;
import com.example.restaurant.services.MenuService;
import com.example.restaurant.services.TransaksiDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ThisController {
    @Autowired
    private MenuRepository menuRepo;
    @Autowired
    private RiderRepository riderRepo;
    @Autowired
    private PembeliRepository pembeliRepo;
    @Autowired
    private TransaksiDAO trDao;
    @Autowired
    private MenuService menuService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    @GetMapping("/getMenuDto")
    public ResponseEntity getUserDto() {
        List<MenuDto> userDtos = menuService.getMenuDto();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/getMenu")
    public ResponseEntity getMenu(){
        List<Menu> result = menuRepo.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getMenuById")
    public ResponseEntity<List<Menu>> getById(@RequestParam int id){
       List<Menu> result = menuRepo.findById(id);
       if(result == null){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/saveMenu")
    public ResponseEntity addMenu(@RequestBody Menu menu){
        try{
            Menu mn = menuRepo.save(menu);
            return new ResponseEntity<>(mn, HttpStatus.CREATED);
        }catch(Exception e){
            log.error("Error saving user{}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteMenu")
    public ResponseEntity<String> deleteMenu(@RequestParam String id){
        try {
            menuRepo.deleteById(Integer.valueOf(id));
            return new ResponseEntity<>("Delete", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRider")
    public ResponseEntity getRider(){
        List<Rider> result = riderRepo.findAll();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getPembeli")
    public ResponseEntity getPembeli(){
        List<Pembeli> result = pembeliRepo.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tryNative")
    public ResponseEntity<List<TransaksiMapping>> tryNative(@RequestParam String namaPembeli){
        List<TransaksiMapping> result = trDao.tryNative(namaPembeli);
        return ResponseEntity.ok(result);
    }
}
