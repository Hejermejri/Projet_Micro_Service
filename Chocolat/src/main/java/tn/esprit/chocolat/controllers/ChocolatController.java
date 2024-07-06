package tn.esprit.chocolat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chocolat.entities.Chocolat;
import tn.esprit.chocolat.entities.ChocolatWithStockDTO;
import tn.esprit.chocolat.services.ChocolatService;
import tn.esprit.chocolat.services.IChocolatService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Chocolat")
public class ChocolatController {
    @Autowired
    public IChocolatService ps;

    @GetMapping("/get")
    public List<ChocolatWithStockDTO> getAllProducts(){
        return ps.reteriveAllProducts();
    }
    @GetMapping("/getProductById/{id}")
    public ChocolatWithStockDTO getProductById(@PathVariable("id") Long id){
        return ps.getProductById(id);
    }

    @PostMapping("/saveProduit")
    public ChocolatWithStockDTO add(@RequestBody ChocolatWithStockDTO produit) {
        return ps.addProduct(produit);

    }

    @PatchMapping("/updateProduit/{id}")
    public Chocolat update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ps.updateProduit(id, updates);

    }
    @DeleteMapping("/deleteProduit/{id}")
    public void delete(@PathVariable("id") Long id) {
        ps.deleteProduitById(id);

    }
}