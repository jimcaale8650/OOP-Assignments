
import java.util.Date;

public class Loan {

    public static void main(String[] args) {

        Loan loan1 = new Loan();
        System.out.println("=== Loan 1 (Default Values) ===");
        System.out.println("Annual Interest Rate: " + loan1.getAnnualInterestRate() + "%");
        System.out.println("Number of Years: " + loan1.getNumberOfYears());
        System.out.println("Loan Amount: $" + loan1.getLoanAmount());
        System.out.println("Loan Date: " + loan1.getLoanDate());
        System.out.printf("Monthly Payment: $%.2f\n", loan1.getMonthlyPayment());
        System.out.printf("Total Payment: $%.2f\n", loan1.getTotalPayment());

        System.out.println("\n-----------------------------------\n");


        Loan loan2 = new Loan(5.5, 3, 5000.0);
        System.out.println("=== Loan 2 (Custom Values) ===");
        System.out.println("Annual Interest Rate: " + loan2.getAnnualInterestRate() + "%");
        System.out.println("Number of Years: " + loan2.getNumberOfYears());
        System.out.println("Loan Amount: $" + loan2.getLoanAmount());
        System.out.println("Loan Date: " + loan2.getLoanDate());
        System.out.printf("Monthly Payment: $%.2f\n", loan2.getMonthlyPayment());
        System.out.printf("Total Payment: $%.2f\n", loan2.getTotalPayment());
    }


    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;


    /** No-argument constructor (Default values) */
    public Loan() {
        this(2.5, 1, 1000.0);
    }

    /** Parameterized constructor */
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
        this.loanDate = new Date();
    }


    // 4. GETTER METHODS


    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }


    // 5. SETTER METHODS


    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than zero.");
        }
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than zero.");
        }
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        this.loanAmount = loanAmount;
    }


    // 6. CALCULATION METHODS


    /** Monthly Payment Formula */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;

        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    /** Total Payment Formula */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}