package src.model;

/**
 * class Produkten with the followings attributes
 */

public class Produkten {
    private String name;
    private double price;
    private String herkunftsregion;

    public Produkten(String name, double price, String herkunftsregion) {
        this.name = name;
        this.price = price;
        this.herkunftsregion = herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", herkunftsregion='" + herkunftsregion + '\'' +
                '}';
    }
}
