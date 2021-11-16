package business.entities;

import java.util.List;

public class Cupcake {
    private int cupcakeId;
    private int toppingId;
    private int bundId;

    public List<Cupcake> cupcakeList;

    public Cupcake(int toppingId, int bundId) {
        this.toppingId = toppingId;
        this.bundId = bundId;
    }


    public Cupcake(int cupcakeId, int toppingId, int bundId) {
        this.cupcakeId = cupcakeId;
        this.toppingId = toppingId;
        this.bundId = bundId;
    }


    public int getCupcakeId() {
        return cupcakeId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public int getBundId() {
        return bundId;
    }

    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }


}

