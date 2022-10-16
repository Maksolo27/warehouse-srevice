package com.example.warehousesrevice.controllers;

import com.example.warehousesrevice.entity.Ware;
import com.example.warehousesrevice.services.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/warehouse")
public class WarehouseController {


    @Autowired
    WareService wareService;


    @GetMapping()
    public ResponseEntity<List<Ware>> getAllWares () {
        System.out.println (wareService.getAllWares ());
        return ResponseEntity.ok (wareService.getAllWares ());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ware> getAllWares (@PathVariable String id) {
        return ResponseEntity.ok (wareService.getAllWares ().get (Integer.parseInt(id)));
    }

    @DeleteMapping("delete/{id}")
    public void deleteWare (@PathVariable String id) {
        wareService.deleteWare (wareService.getWareById(Long.parseLong(id)));
    }

    @PostMapping("update/{id}")
    public void updateWare (@PathVariable String id, @RequestParam String name, @RequestParam String price) {
        Ware ware = wareService.getWareById(Long.parseLong(id));
        ware.setName(name);
        ware.setPrice(Double.parseDouble(price));
        wareService.updateWare (ware);
    }

    @PostMapping("create")
    public void createWare (@RequestParam String name, @RequestParam String price) {
        Ware ware = new Ware(name, Double.parseDouble(price));
        wareService.addWare(ware);
    }

}
