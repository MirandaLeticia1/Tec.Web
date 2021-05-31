/**
 *
 */
package br.com.bank.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author cbgomes
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;
}
