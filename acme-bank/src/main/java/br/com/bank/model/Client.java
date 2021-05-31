package br.com.bank.model;

import lombok.*;

import javax.persistence.*;


/**
 * @author cbgomes Classe de dominio da aplicação, modelo de persistência
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;


}
