package com.banquito.cbs.aplicacion.transaccion.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DETALLE_TRANSACCION")
public class DetalleTransaccion implements Serializable
{
    @Id
    @NotNull
    @Column(name = "TRANSACCION_ID")
    private Integer transaccionId;

    @Column(name = "TIPO_CUENTA", length = 3)
    private String tipoCuenta;

    @Column(name = "BENEFICIARIO", length = 128)
    private String beneficiario;

    @Column(name = "NUMERO", length = 16)
    private String numero;

    @Column(name = "BIN_BANCO_ORIGEN", length = 8)
    private String binBancoOrigen;

    @Column(name = "BIN_BANCO_DESTINO", length = 8)
    private String binBancoDestino;

    @Column(name = "DESCRIPCION", length = 128)
    private String descripcion;

    @Column(name = "DETALLE_JSON")
    private String detalleJson;

    @Column(name = "FECHA_AUTORIZACION")
    private LocalDate fechaAutorizacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TRANSACCION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Transaccion transaccion;

    public DetalleTransaccion() {}

    public DetalleTransaccion(Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public @NotNull Integer getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(@NotNull Integer transaccionId) {
        this.transaccionId = transaccionId;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBinBancoOrigen() {
        return binBancoOrigen;
    }

    public void setBinBancoOrigen(String binBancoOrigen) {
        this.binBancoOrigen = binBancoOrigen;
    }

    public String getBinBancoDestino() {
        return binBancoDestino;
    }

    public void setBinBancoDestino(String binBancoDestino) {
        this.binBancoDestino = binBancoDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalleJson() {
        return detalleJson;
    }

    public void setDetalleJson(String detalleJson) {
        this.detalleJson = detalleJson;
    }

    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public @NotNull Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(@NotNull Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleTransaccion that = (DetalleTransaccion) o;
        return Objects.equals(transaccionId, that.transaccionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transaccionId);
    }

    @Override
    public String toString() {
        return "TransaccionDetalle{" +
                "transaccionId=" + transaccionId +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", beneficiario='" + beneficiario + '\'' +
                ", numero='" + numero + '\'' +
                ", binBancoOrigen='" + binBancoOrigen + '\'' +
                ", binBancoDestino='" + binBancoDestino + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", detalleJson='" + detalleJson + '\'' +
                ", fechaAutorizacion=" + fechaAutorizacion +
                '}';
    }
}
