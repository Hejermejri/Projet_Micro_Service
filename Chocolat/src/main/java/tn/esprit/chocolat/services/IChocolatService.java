package tn.esprit.chocolat.services;
import tn.esprit.chocolat.entities.Chocolat;
import tn.esprit.chocolat.entities.ChocolatWithStockDTO;

import java.util.List;
import java.util.Map;

public interface IChocolatService {

    List<ChocolatWithStockDTO> reteriveAllProducts();

    void deleteProduitById(Long id);
    ChocolatWithStockDTO addProduct(ChocolatWithStockDTO p);

    ChocolatWithStockDTO getProductById(Long id);

    Chocolat updateProduit(Long id, Map<String, Object> produit);

}
