package src.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Charakteren class with the followings attributes
 */
public class Charakteren  {
    private Integer id;
    private String name;
    private String herkunfsort;
    List<Produkten> orederdProducts;

    public <E> Charakteren(Integer id, String name, String herkunfsort) {
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + herkunfsort + '\'' +
                ", orederdProducts=" + orederdProducts +
                '}';
    }

    public void Charaktere(Integer id, String name, String herkunfsort) {
        this.id = id;
        this.name = name;
        this.herkunfsort = herkunfsort;
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

    public String getHerkunfsort() {
        return herkunfsort;
    }

    public void setHerkunfsort(String herkunfsort) {
        this.herkunfsort = herkunfsort;
    }

    public List<Produkten> getOrederdProducts() {
        return orederdProducts;
    }

    public void setOrederdProducts(List<Produkten> orederdProducts) {
        this.orederdProducts = orederdProducts;
    }

    public void kaufeProdukt(Produkten produkten) {
    }
}

