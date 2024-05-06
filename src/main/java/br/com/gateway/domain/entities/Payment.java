package br.com.gateway.domain.entities;

import br.com.gateway.domain.enums.PaymentStatusEnum;
import br.com.gateway.domain.enums.PaymentTypeEnum;

import java.math.BigDecimal;

public class Payment {

    private Integer id;

    private BigDecimal value;

    private BigDecimal tax;

    private String beneficiary;

    private String payer;

    private PaymentTypeEnum type;

    private PaymentStatusEnum status;

    public Payment(BigDecimal value, String beneficiary, String payer, PaymentTypeEnum paymentTypeEnum) {
        this.value = value;
        this.beneficiary = beneficiary;
        this.payer = payer;
        this.type = paymentTypeEnum;
    }

    public Payment() {
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public PaymentTypeEnum getType() {
        return type;
    }

    public void setType(PaymentTypeEnum type) {
        this.type = type;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }
}
