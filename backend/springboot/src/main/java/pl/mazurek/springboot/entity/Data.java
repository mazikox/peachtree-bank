package pl.mazurek.springboot.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@lombok.Data
@ToString
public class Data {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryCode;
    private String date;
    private Double amount;
    private String currencyCode;
    private String originatorAccountNumber;
    private String counterpartyAccount;
    private String paymentType;
    private String status;
    private String title;

}
