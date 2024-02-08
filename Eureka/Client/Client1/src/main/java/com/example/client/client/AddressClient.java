package com.example.client.client;

import com.example.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:9003", path = "/address-service")
public interface AddressClient {
    @GetMapping("/address/{id}")
     ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);

}
