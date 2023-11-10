package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private Double contractValue;

    public Installment(){

    }

    public Installment(LocalDate dueDate, Double contractValue) {
        this.dueDate = dueDate;
        this.contractValue = contractValue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    @Override
    public String toString(){
        return dueDate.format(dtf) + " - R$ " + String.format("%.2f", contractValue);
    }
}
