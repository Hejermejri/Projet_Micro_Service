package tn.esprit.chocolat.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.chocolat.entities.StockDTO;

@FeignClient(name = "api", url = "http://localhost:8097")
public interface StockClient {
    @GetMapping("/api/getbyid/{id}")
    StockDTO getById(@PathVariable("id") String id);


}
