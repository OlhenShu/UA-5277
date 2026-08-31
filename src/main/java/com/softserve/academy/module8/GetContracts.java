package com.softserve.academy.module8;

public interface GetContracts {
    double BASE_PERCENT = 30; //constants are public static final by default

    /**
     * Calculates the bonus based on the given bonus amount.
     *
     * @param bonus
     * @return
     */
    static double calculateBonus(int bonus) {//static method, public static by default
        return BASE_PERCENT * bonus;
    }

    String getContract();//abstract method, public abstract by default

    int getSalary();

    default String getContractDetails() {//default method, public by default
        return "Contract details: " + getContract() + ", Salary: " + getSalary() + ", Bonus: " + calculateBonus(getSalary());
    }

    private void logContractDetails() {//private method, private by default
        System.out.println("Logging contract details: " + getContractDetails());
    }

    default void printContractDetails() {
        logContractDetails();
    }
}
