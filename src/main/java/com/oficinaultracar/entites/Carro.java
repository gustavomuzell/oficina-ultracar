package com.oficinaultracar.entites;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;

    private String veiculo;
    private String placa;
    private String cor;
    private String ano;
    private String acessorio;

    public Carro() {}

    public Carro(Long id, String veiculo, String placa, String cor, String ano, String acessorio, Cliente cliente) {
        this.id = id;
        this.veiculo = veiculo;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.acessorio = acessorio;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(String acessorio) {
        this.acessorio = acessorio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
