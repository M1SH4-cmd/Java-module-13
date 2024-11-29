import java.util.Objects;

public class Bus {
    private double tankFullnessRate = 0.0; //rate of tank fullness, 0-1
    protected double consumptionRate; // rate (0-1) per 1km
    private static int count;


    public Bus(double consumptionRate) {
        this.consumptionRate = consumptionRate;
        count++;
    }

    public boolean run(int distance){
        if(powerReserve() < distance) return false;

        tankFullnessRate -= distance * consumptionRate;
        return true;
    }

    public void refuel(double tankRate){
        double total = tankFullnessRate + tankRate;
        tankFullnessRate = total > 1 ? 1 : total;
    }

    protected int powerReserve(){
        return (int) (tankFullnessRate / consumptionRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение ссылок
        if (o == null || getClass() != o.getClass()) return false; // Сравнение классов
        Bus bus = (Bus) o; // Создание промежуточного экза класса Bus. Копитует экз переданный в параметрах
        return Double.compare(tankFullnessRate, bus.tankFullnessRate) == 0 && Double.compare(consumptionRate, bus.consumptionRate) == 0; // Сравнение параметров экзов класса Bus
    }

    @Override
    public int hashCode() {
        return Objects.hash(tankFullnessRate, consumptionRate); // Если хэш код обьектов одинаковый, то они возможно одинаковые. Если он отличается, то обьекты 100% разные
    }

    @Override
    public String toString() {
        return "Bus{" +
                "tankFullnessRate=" + tankFullnessRate +
                ", consumptionRate=" + consumptionRate +
                '}';
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }

    public double getTankFullnessRate() {
        return tankFullnessRate;
    }

    public static int getCount() {
        return count;
    }
    

}
