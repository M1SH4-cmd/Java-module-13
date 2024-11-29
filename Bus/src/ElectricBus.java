public class ElectricBus extends Bus{
    private final double minimalTankFullnessRate;
    private static final double degradationRate = 0.00001;
    private static final double minRateToDegrate = 0.1;
    private static int count;

    public ElectricBus(double consumptionRate, double minimalTankFullnessRate){
        super(consumptionRate);
        this.minimalTankFullnessRate = minimalTankFullnessRate;
        count++;
    }

    @Override
    public int powerReserve() {
        double remainingRate = getTankFullnessRate() - minimalTankFullnessRate;
        if(remainingRate <= 0) return 0;

        return (int) (remainingRate / getConsumptionRate());
    }

    @Override
    public void refuel(double tankRate) {
        super.refuel(tankRate);
        if(tankRate > minRateToDegrate) consumptionRate += degradationRate;
    }

    public static int getCount() {
        return count;
    }

    

}
