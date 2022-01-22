package com.bahadirmemis.n11.n11bootcamp.ord.controller;

import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderDetailDto;
import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrder;
import com.bahadirmemis.n11.n11bootcamp.ord.service.OrdOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@CrossOrigin
public class OrdOrderController {

    private OrdOrderService ordOrderService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody OrdOrderSaveRequestDto ordOrderSaveRequestDto){

        OrdOrder ordOrder = ordOrderService.saveOrdOrder(ordOrderSaveRequestDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ordOrder.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrdOrderById(@PathVariable Long id){

        OrdOrderSaveRequestDto ordOrder = ordOrderService.getOrdOrderById(id);

        return ResponseEntity.ok(ordOrder);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity getOrdOrderByUsername(@PathVariable String username){

        List<OrdOrderDetailDto> ordOrderList = ordOrderService.getOrdOrderByUsername(username);

        return ResponseEntity.ok(ordOrderList);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<OrdOrderSaveRequestDto> ordOrderList = ordOrderService.findAll();

        return ResponseEntity.ok(ordOrderList);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        ordOrderService.delete(id);
    }
}
