package br.com.senai.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="barber")
@EqualsAndHashCode(of="id")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private BigInteger telefone;
}