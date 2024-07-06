package tn.esprit.chocolat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.chocolat.entities.Chocolat;
import tn.esprit.chocolat.entities.ChocolatWithStockDTO;
import tn.esprit.chocolat.entities.StockDTO;
import tn.esprit.chocolat.mappers.ChocolatMappers;
import tn.esprit.chocolat.repositories.ChocolatRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChocolatService implements IChocolatService{

    @Autowired
    private ChocolatRepository pRepo;

    @Autowired
    private StockClient stockClient;

    @Override
    public List<ChocolatWithStockDTO> reteriveAllProducts() {
        return pRepo.findAll().stream().map(produit -> ChocolatMappers.mapToDto(produit))
                .collect(Collectors.toList());

        //return (List<Product>) pRepo.findAll();
    }

    @Override
    public ChocolatWithStockDTO addProduct(ChocolatWithStockDTO p) {
        pRepo.save(ChocolatMappers.mapToEntity(p));
        return p;
        //return pRepo.save(p);
    }

    @Override
    public ChocolatWithStockDTO getProductById(Long id) {
        Chocolat produit = pRepo.findById(id).get();

        //OpenFeign
        StockDTO stockDTO = stockClient.getById(produit.getId_stock());

        //RestTemplate
        //StockDTO stockDTO =getById(article.getId_stock());
        return ChocolatMappers.mapToDto(produit, stockDTO);

        //return pRepo.findById(id);
    }

    @Override
    public Chocolat updateProduit(Long id, Map<String, Object> produit) {
        Chocolat isProduit = pRepo.findById(id).get();

        if (isProduit == null) {

            return null;
        }

        for (Map.Entry<String, Object> entry : produit.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = isProduit.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(isProduit, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return pRepo.save(isProduit);
    }

    @Override
    public void deleteProduitById(Long id) {
        pRepo.deleteById(id);

    }

    public StockDTO getById(String id) {
        String url = "http://localhost:8097/api/getbyid/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, StockDTO.class);
    }
}
