package application;

import model.entities.ContractData;
import model.entities.Installment;
import model.entities.service.ContractService;
import model.entities.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("US"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("===================");
        System.out.println("Enter contract data");
        System.out.println("===================");
        System.out.println();

        System.out.print("Contract Number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Contract Date (DD/MM/YYYY): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), dtf);
        System.out.print("Contract Value: R$ ");
        double totalValue = sc.nextDouble();

        ContractData contractData = new ContractData(contractNumber,contractDate,totalValue);

        System.out.print("Enter the number of installments: ");
        int installmentsNumber = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contractData, installmentsNumber);

        System.out.println();
        System.out.println("=======================");
        System.out.println("         PARCELAS      ");
        System.out.println("=======================");
        for(Installment installment : contractData.getInstallments()){
            System.out.println(installment);
        }
        sc.close();
    }
}
