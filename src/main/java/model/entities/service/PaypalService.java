package model.entities.service;

public class PaypalService implements OnlinePaymentService{

    private static final double feePercentage = 0.01;
    private static final double interestPercentage = 0.02;

    @Override
    public double paymentFee(double amount){
        return amount * interestPercentage;
    }

    @Override
    public double interest(double amount, int months){
        return amount * feePercentage * months;
    }
}
