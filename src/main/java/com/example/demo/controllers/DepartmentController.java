package com.example.demo.controllers;

import com.example.demo.components.Iseng;
import com.example.demo.components.Response;
import com.example.demo.components.ResponseCode;
import com.example.demo.requests.AddDepartmentRequest;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/department/")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddDepartmentRequest request){
        if (request.getName().isEmpty()){

            Response<?> response = new Response<>();
            response.setResponseCode(ResponseCode.BAD_REQUEST);
            response.setMessage("Harap isi data terlebih dahulu");
            return ResponseEntity.badRequest().body(response);
        }
        return service.insert(request);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> getId(@PathVariable String id){
        return service.getId(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody AddDepartmentRequest request, @PathVariable String id){
        if (request.getName().isEmpty()){

            Response<?> response = new Response<>();
            response.setResponseCode(ResponseCode.BAD_REQUEST);
            response.setMessage("Harap isi data terlebih dahulu");
            return ResponseEntity.badRequest().body(response);
        }
        return service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return service.delete(id);
    }
}
