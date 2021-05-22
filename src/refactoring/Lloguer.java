package refactoring;

import java.util.ArrayList;
import java.util.Date;

public class Lloguer {

    private Date data;
    private int dies;
    private Vehicle vehicle;
    private int quantitat;

    public Lloguer(Date data, int dies, Vehicle vehicle) {
        super();
        this.data = data;
        this.dies = dies;
        this.vehicle = vehicle;
        this.setData(data);
        this.setDies(dies);
    }

    public Date GetData(Date Date) {

        return Date;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getDies() {
        return dies;
    }

    public void setDies(int dies) {
        this.dies = dies;
    }

    public void treuLloguer() {
        setVehicle(null);
    }

    // ejercicio 7
    //  public double quantitat(){
    public double quantitat() {

        double quantitat = 0;
        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (this.getDies() > 3) {
                    quantitat += (this.getDies() - 3) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (this.getDies() > 2) {
                    quantitat += (this.getDies() - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += this.getDies() * 6;
                break;
        }
        return quantitat;
    }

    public double getQuantitat() {
        return this.quantitat;
    }

    public int bonificacions() {
        int bonificacions = 0;
        bonificacions++;
        if (getVehicle().getCategoria() == Vehicle.LUXE && getDies() > 1) {

            bonificacions++;
        }
        return bonificacions;
    }
}
