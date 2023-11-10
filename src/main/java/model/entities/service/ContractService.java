package model.entities.service;

import model.entities.ContractData;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(ContractData contract, int months){

        double contractBasicValue = contract.getTotalValue()/months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interestContract = onlinePaymentService.interest(contractBasicValue, i);
            double feeContract = onlinePaymentService.paymentFee(contractBasicValue + interestContract);
            double contractTotalValue = contractBasicValue + interestContract + feeContract;

            contract.getInstallments().add(new Installment(dueDate,contractTotalValue));
        }
    }

}
