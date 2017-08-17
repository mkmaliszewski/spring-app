package com.marek.springapplication.model;

import com.marek.springapplication.validator.Date;
import com.marek.springapplication.validator.Phone;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="contacts")
public class Contact implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "The name field must not be empty!")
    @NotBlank(message = "The name field must not be blank!")
    @Size(min = 3, max = 20, 
            message = "The name feild size must be between 3 and 20 cahracters!")
    private String name;
    @NotEmpty(message = "The last name field must not be empty!")
    @NotBlank(message = "The last name field must not be blank!")
    @Size(min = 5, max = 30, 
            message = "The last name field size must be between 5 and 30 characters!")
    @Column (name = "last_name")
    private String lastName;
    @NotEmpty(message = "The mail field must not be empty!")
    @Email(message = "The mail field must be well-formed!")
    private String mail;
    @Phone
    @NotBlank(message = "The number field must not be blank!")
    private String number;
    @NotEmpty(message = "The born date field must not be empty!")
    @NotBlank(message = "The born date field must not be blank!")
    @Date
    @Column (name = "born")
    private String bornDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    } 
}