package src.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse Charakter mit den folgenden Attributen
 */
public class Charakteren {
    private Integer id;
    private String name;
    private String herkunftsort;
    private List<Produkten> orderedProducts;

    public Charakteren(Integer id, String name, String herkunftsort) {
        this.id = id;
        this.name = name;
        this.herkunftsort = herkunftsort;
        this.orderedProducts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsort() {
        return herkunftsort;
    }

    public void setHerkunftsort(String herkunftsort) {
        this.herkunftsort = herkunftsort;
    }

    public List<Produkten> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Produkten> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void kaufeProdukt(Produkten produkt) {
        this.orderedProducts.add(produkt);
    }

    @Override
    public String toString() {
        return "Charakter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herkunftsort='" + herkunftsort + '\'' +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}