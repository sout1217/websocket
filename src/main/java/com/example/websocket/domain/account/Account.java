package com.example.websocket.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @CreationTimestamp
    private Date createAt;

    private Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Account of(String username, String password) {
        return new Account(username, password);
    }
}
