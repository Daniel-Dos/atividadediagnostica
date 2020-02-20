package br.com.mastertech.danieldias.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Ponto() {
    }

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

    @Override
    public String toString() {
        return "Ponto [id=" + id + ", usuario=" + usuario + ", dataHoraBatida=" + dataHoraBatida + ", tipoBatida="
                + tipoBatida + "]";
    }

}