package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Cupcake {
    private Topping topping;
    private Bunde bunde;
    private int cupcakeId;
    private int toppingId;
    private int bundId;

    public static List<Cupcake> cupcakeList = new ArrayList<>();

    public Cupcake(Topping topping, Bunde bunde) {

        this.topping = topping;
        this.bunde = bunde;
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

    public Topping getTopping() {
        return topping;
    }

    public Bunde getBunde() {
        return bunde;
    }
}

