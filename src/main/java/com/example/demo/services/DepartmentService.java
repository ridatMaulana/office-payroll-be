package com.example.demo.services;

import com.example.demo.components.Response;
import com.example.demo.components.ResponseCode;
import com.example.demo.components.UUIDGenerator;
import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.requests.AddDepartmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    public ResponseEntity<?> insert(AddDepartmentRequest request){
        Response<List<?>> response = new Response<>();
        String id = UUIDGenerator.idGenerator();
        Department data = new Department();
        data.setId(id);
        data.setName(request.getName());
        repository.save(data);
        response.setResponseCode(ResponseCode.SUCCESS);
        response.setData(repository.findAll());
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> getId(String id){
        Response<Department> response = new Response<>();
        response.setResponseCode(ResponseCode.NO_DATA);
        if(repository.existsById(id)){
            response.setResponseCode(ResponseCode.SUCCESS);
            Department data = repository.findById(id).orElseThrow();
            response.setData(data);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    public ResponseEntity<?> update(AddDepartmentRequest request, String id){
        Response<Department> response = new Response<>();
        response.setResponseCode(ResponseCode.NO_DATA);
        if(repository.existsById(id)){
            response.setResponseCode(ResponseCode.SUCCESS);
            Department data = repository.findById(id).orElseThrow();
            data.setName(request.getName());
            repository.save(data);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
