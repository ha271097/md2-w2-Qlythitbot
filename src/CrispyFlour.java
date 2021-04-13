import java.time.LocalDate;

public class CrispyFlour extends  Material implements Discount{
    final static double DISCOUNT_20 = 0.8;
    final static double DISCOUNT_40 = 0.6;
    final static double DISCOUNT_10 = 0.95;

    private int quantity;

    public CrispyFlour() {

    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    double getAmout() {
        return quantity * getCost();
    }

    @Override
    LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        if (now.isBefore(getExpiryDate()) && now.isAfter(getExpiryDate().plusMonths(4))){
            return  getAmout() * DISCOUNT_20;
        }else if (now.isBefore(getExpiryDate()) && now.isAfter(getExpiryDate().plusMonths(2))){
            return  getAmout() * DISCOUNT_40;
        }else {
            return getAmout() * DISCOUNT_10;
        }

    }
}
