package com.banquito.cbs.aplicacion.transaccion.controlador.peticion;

import java.math.BigDecimal;

public class ConsumoPeticion
{
    private String numeroTarjeta;
    private String cvv;
    private String fechaCaducidad;
    private BigDecimal valor;
    private String descripcion;
    private String canal;
    private String beneficiario;
    private String numeroCuenta;
    private String binBanco;
    private Boolean esDiferido;
    private Integer cuotas;
    private DetalleJsonPeticion detalle;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCanal() {
        return canal;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getBinBanco() {
        return binBanco;
    }

    public Boolean getEsDiferido() {
        return esDiferido;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public DetalleJsonPeticion getDetalle() {
        return detalle;
    }
}
