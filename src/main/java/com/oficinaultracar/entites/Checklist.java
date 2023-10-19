package com.oficinaultracar.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "tb_checklist")
public class Checklist {


    private boolean avarias, amassado, sujo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "checklist", cascade = CascadeType.ALL)
    private List<Carro> carros;

    public boolean isAvarias() {
        return avarias;
    }

    public Checklist() {}

    public Checklist(boolean avarias, boolean amassado, boolean sujo) {
        this.avarias = avarias;
        this.amassado = amassado;
        this.sujo = sujo;
    }

    public void setAvarias(boolean avarias) {this.avarias = avarias;}

    public boolean isAmassado() {return amassado;}

    public void setAmassado(boolean amassado) {this.amassado = amassado;}

    public boolean isSujo() {return sujo;}

    public void setSujo(boolean sujo) {this.sujo = sujo;}
}
