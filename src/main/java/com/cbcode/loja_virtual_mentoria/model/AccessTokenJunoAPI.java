package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents an access token for the Juno API.
 * This class is used to store information about an access token for the Juno API.
 */
@Entity
@Table(name = "access_token_juno_api")
@SequenceGenerator(name = "access_token_juno_api_seq", sequenceName = "access_token_juno_api_seq", allocationSize = 1)
public class AccessTokenJunoAPI implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_token_juno_api_seq")
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String access_token;
}
