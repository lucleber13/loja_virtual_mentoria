package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a Juno boleto.
 * This class is used to store information about a Juno boleto.
 */
@Entity
@Table(name = "juno_boleto")
@SequenceGenerator(name = "juno_boleto_seq", sequenceName = "juno_boleto_seq", allocationSize = 1)
public class JunoBoleto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "juno_boleto_seq")
    private Long id;

}
