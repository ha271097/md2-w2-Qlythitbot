import java.time.LocalDate;

public class Meat extends Material implements Discount{
    final static double DISCOUNT_30 = 0.7;
    final static double DISCOUNT_50 = 0.5;
    final static double DISCOUNT_10 = 0.9;
    private double weight;



    public Meat( ) {

    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    double getAmout() {
        return getCost() * weight;
    }

    @Override
    LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        if (now.isBefore(getExpiryDate()) && now.isAfter(getExpiryDate().plusMonths(4))){
            return  getAmout() * DISCOUNT_30;
        }else if (now.isBefore(getExpiryDate()) && now.isAfter(getExpiryDate().plusMonths(2))){
            return  getAmout() * DISCOUNT_50;
        }else {
            return getAmout() * DISCOUNT_10;
        }


    }
}
