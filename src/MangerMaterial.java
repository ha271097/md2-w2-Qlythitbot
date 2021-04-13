import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MangerMaterial {
    public static void main(String[] args) {
        List<Material> materials = new ArrayList<>();
        CrispyFlour crispyFlour1 = new CrispyFlour("1","rice1",LocalDate.of(2021,4,8),20000,1);
        CrispyFlour crispyFlour2 = new CrispyFlour("2","rice2",LocalDate.of(2021,4,7),20000,2);
        CrispyFlour crispyFlour3 = new CrispyFlour("3","rice3",LocalDate.of(2021,4,6),20000,3);
        CrispyFlour crispyFlour4 = new CrispyFlour("4","rice4",LocalDate.of(2021,4,5),20000,4);
        CrispyFlour crispyFlour5 = new CrispyFlour("5","rice5",LocalDate.of(2021,4,4),20000,5);
        materials.add(crispyFlour1);
        materials.add(crispyFlour2);
        materials.add(crispyFlour3);
        materials.add(crispyFlour4);
        materials.add(crispyFlour5);
        Meat meat1 = new Meat("1","ChikenMeat1", LocalDate.of(2021,4,8),20000,1);
        Meat meat2 = new Meat("2","ChikenMeat1",LocalDate.of(2021,4,7),20000,2);
        Meat meat3 = new Meat("3","ChikenMeat1",LocalDate.of(2021,4,6),20000,3);
        Meat meat4 = new Meat("4","ChikenMeat1",LocalDate.of(2021,4,5),20000,4);
        Meat meat5 = new Meat("5","ChikenMeat1",LocalDate.of(2021,4,4),20000,5);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        double total = 0;
        double totolDiscount = 0;

        luonhaanh(materials, total, totolDiscount);


    }

    private static void luonhaanh(List<Material> materials, double total, double totolDiscount) {
        double result = 0;
        for (Material material: materials) {
            total += material.getAmout();
            if(material instanceof Meat ){
                Meat metarial = (Meat) material;
                totolDiscount += ((Meat) material).getRealMoney();

        }
    }
        result = total - totolDiscount;
        System.out.println("Monney Discount = " + result);
        System.out.println("Total After Discount = " + total);
    }
}
