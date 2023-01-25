package entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Customer {


    @CsvBindByName
    private String incorrectUser;
    @CsvBindByName
    private String incorrectPassword;
    @CsvBindByName
    private String customerName;
    @CsvBindByName
    private String customerLastname;
    @CsvBindByName
    private String zipCode;
}
