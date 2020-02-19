package br.com.mastertech.danieldias.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Usuario usuario;
    private LocalDateTime dataHoraBatida;

    @Enumerated(EnumType.STRING)
    TipoBatida tipoBatida;

    public Ponto(int id, Usuario usuario, LocalDateTime dataHoraBatida, TipoBatida tipoBatida) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.dataHoraBatida = dataHoraBatida;
        this.tipoBatida = tipoBatida;
    }
    
    public Ponto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraBatida() {
        return dataHoraBatida;
    }

    public void setDataHoraBatida(LocalDateTime dataHoraBatida) {
        this.dataHoraBatida = dataHoraBatida;
    }

    public TipoBatida getTipoBatida() {
        return tipoBatida;
    }

    public void setTipoBatida(TipoBatida tipoBatida) {
        this.tipoBatida = tipoBatida;
    }
}