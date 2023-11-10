package model.entities.service;

public interface OnlinePaymentService {

    double paymentFee(double amount);
    double interest(double amount, int months);

}
