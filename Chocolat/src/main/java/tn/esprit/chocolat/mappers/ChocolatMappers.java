package tn.esprit.chocolat.mappers;


import tn.esprit.chocolat.entities.Chocolat;
import tn.esprit.chocolat.entities.ChocolatWithStockDTO;
import tn.esprit.chocolat.entities.StockDTO;

public class ChocolatMappers {

    public static ChocolatWithStockDTO mapToDto(Chocolat produit) {

        ChocolatWithStockDTO articleDTO = ChocolatWithStockDTO.builder().id(produit.getId()).name(produit.getName())
                .size(produit.getSize()).id_stock(produit.getId_stock()).build();
        return articleDTO;
    }

    public static ChocolatWithStockDTO mapToDto(Chocolat produit, StockDTO stockDTO) {

        ChocolatWithStockDTO produitDTO = ChocolatWithStockDTO.builder().id(produit.getId()).name(produit.getName())
                .size(produit.getSize()).id_stock(produit.getId_stock()).stockdto(stockDTO).build();

        return produitDTO;
    }

    public static Chocolat mapToEntity(ChocolatWithStockDTO produitDTO) {
        Chocolat produit = Chocolat.builder().id(produitDTO.getId()).name(produitDTO.getName()).size(produitDTO.getSize())
                .id_stock(produitDTO.getId_stock()).build();
        return produit;

    }

}

