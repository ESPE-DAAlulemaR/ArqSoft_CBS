package com.banquito.cbs.aplicacion.transaccion.controlador.peticion;

import java.math.BigDecimal;

public class ItemDetalleJsonPeticion
{
    private String referencia;

    private BigDecimal comision;

    private String numeroCuenta;

    private String binBanco;

    public String getReferencia() {
        return referencia;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getBinBanco() {
        return binBanco;
    }
}
