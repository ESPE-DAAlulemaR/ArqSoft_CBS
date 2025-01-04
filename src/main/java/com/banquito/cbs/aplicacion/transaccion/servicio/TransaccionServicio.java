package com.banquito.cbs.aplicacion.transaccion.servicio;

import com.banquito.cbs.aplicacion.producto.modelo.Tarjeta;
import com.banquito.cbs.aplicacion.producto.servicio.TarjetaServicio;
import com.banquito.cbs.aplicacion.transaccion.modelo.Transaccion;
import com.banquito.cbs.aplicacion.transaccion.modelo.DetalleTransaccion;
import com.banquito.cbs.aplicacion.transaccion.repositorio.TransaccionRepositorio;
import com.banquito.cbs.aplicacion.transaccion.repositorio.DetalleTransaccionRepositorio;
import com.banquito.cbs.compartido.excepciones.OperacionInvalidaExcepcion;
import com.banquito.cbs.compartido.utilidades.UtilidadHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TransaccionServicio {
    private final TransaccionRepositorio repositorio;
    private final DetalleTransaccionRepositorio detalleTransaccionRepositorio;

    private final TarjetaServicio tarjetaServicio;

    private static final String TIPO_DEPOSITO = "DEP";
    private static final String TIPO_PAGO_TARJETA = "PTC";
    private static final String TIPO_CONSUMO = "CNS";
    private static final String TIPO_REVERSO = "REV";
    private static final String TIPO_TRANSFERENCIA_INTERNA = "TRI";
    private static final String TIPO_TRANSFERENCIA_EXTERNA = "TRE";

    private static final String CANAL_WEB = "WEB";
    private static final String CANAL_MOVIL = "MOV";
    private static final String CANAL_POS = "POS";

    private static final String ESTADO_APROBADA = "APR";
    private static final String ESTADO_RECHAZADA = "REC";
    private static final String ESTADO_PENDIENTE = "PEN";
    private static final String ESTADO_REVERSADA = "REV";
    private static final String ESTADO_ANULADA = "ANU";

    private static final BigDecimal INTERES_CONSUMO = BigDecimal.valueOf(16.5);
    private static final BigDecimal PORCENTAJE_COMISION_CONSUMO = BigDecimal.valueOf(0.01);

    public TransaccionServicio(TransaccionRepositorio repositorio,
                               DetalleTransaccionRepositorio detalleTransaccionRepositorio, TarjetaServicio tarjetaServicio) {
        this.repositorio = repositorio;
        this.detalleTransaccionRepositorio = detalleTransaccionRepositorio;
        this.tarjetaServicio = tarjetaServicio;
    }

    @Transactional
    public void crearDeposito(Integer cuentaId, BigDecimal valor, String canal, String descripcion) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId(cuentaId);
        transaccion.setTipo(TransaccionServicio.TIPO_DEPOSITO);
        transaccion.setCanal(canal);
        transaccion.setValor(valor);
        transaccion.setComision(BigDecimal.ZERO);
        transaccion.setTazaInteres(BigDecimal.ZERO);
        transaccion.setEsDiferido(false);
        transaccion.setEstado(TransaccionServicio.ESTADO_APROBADA);
        transaccion.setFechaHora(LocalDate.now());

        repositorio.save(transaccion);

        // Detalle de la transacción
        DetalleTransaccion detalle = new DetalleTransaccion();
        detalle.setTransaccionId(transaccion.getId());
        detalle.setDescripcion(descripcion);

        detalleTransaccionRepositorio.save(detalle);
    }

    @Transactional
    public void crearPagoTarjetaCredito(Integer tarjetaId, BigDecimal valor, String canal, String descripcion) {
        Transaccion transaccion = new Transaccion();
        transaccion.setTarjetaId(tarjetaId);
        transaccion.setTipo(TransaccionServicio.TIPO_PAGO_TARJETA);
        transaccion.setCanal(canal);
        transaccion.setValor(valor);
        transaccion.setComision(BigDecimal.ZERO);
        transaccion.setTazaInteres(BigDecimal.ZERO);
        transaccion.setEsDiferido(false);
        transaccion.setEstado(TransaccionServicio.ESTADO_PENDIENTE);
        transaccion.setFechaHora(LocalDate.now());

        repositorio.save(transaccion);

        // Detalle de la transacción
        DetalleTransaccion detalle = new DetalleTransaccion();
        detalle.setTransaccionId(transaccion.getId());
        detalle.setDescripcion(descripcion);

        detalleTransaccionRepositorio.save(detalle);
    }

    @Transactional
    public void crearTransferenciaInterna(Integer cuentaOrigenId, Integer cuentaDestinoId, BigDecimal valor, String canal, String descripcion) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId(cuentaOrigenId);
        transaccion.setTipo(TransaccionServicio.TIPO_TRANSFERENCIA_INTERNA);
        transaccion.setTazaInteres(BigDecimal.ZERO);
        transaccion.setEstado(TransaccionServicio.ESTADO_APROBADA);
        transaccion.setFechaHora(LocalDate.now());

        repositorio.save(transaccion);

        // Detalle de la transacción
        DetalleTransaccion detalle = new DetalleTransaccion();
        detalle.setTransaccionId(transaccion.getId());
        detalle.setNumero(cuentaDestinoId.toString());
        detalle.setDescripcion(descripcion);

        detalleTransaccionRepositorio.save(detalle);
    }

    @Transactional
    public void crearTransferenciaExterna(Integer cuentaOrigenId, String binBancoDestino, BigDecimal valor, String canal, String descripcion) {
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId(cuentaOrigenId);
        transaccion.setTipo(TransaccionServicio.TIPO_TRANSFERENCIA_EXTERNA);
        transaccion.setCanal(canal);
        transaccion.setValor(valor);
        transaccion.setComision(BigDecimal.ZERO);
        transaccion.setTazaInteres(BigDecimal.ZERO);
        transaccion.setEsDiferido(false);
        transaccion.setEstado(TransaccionServicio.ESTADO_PENDIENTE);
        transaccion.setFechaHora(LocalDate.now());

        repositorio.save(transaccion);

        // Detalle de la transacción
        DetalleTransaccion detalle = new DetalleTransaccion();
        detalle.setTransaccionId(transaccion.getId());
        detalle.setBinBancoDestino(binBancoDestino);
        detalle.setDescripcion(descripcion);

        detalleTransaccionRepositorio.save(detalle);
    }

    @Transactional
    public void registrarConsumoTarjeta(Transaccion transaccion, String numeroTarjeta, String cvv, String fechaCaducidad, String descripcion, String beneficiario, Object detalleJson)
    {
        Tarjeta tarjeta = this.tarjetaServicio.buscarPorNumero(numeroTarjeta);

        if (!UtilidadHash.verificarString(cvv, tarjeta.getCvv()))
            throw new OperacionInvalidaExcepcion("Código de seguridad de la tarjeta incorrecto");

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate fechaEntrada = LocalDate.parse(fechaCaducidad, inputFormatter.withResolverStyle(java.time.format.ResolverStyle.STRICT));

        if (fechaEntrada.getMonthValue() != tarjeta.getFechaExpiracion().getMonthValue() || fechaEntrada.getYear() != tarjeta.getFechaExpiracion().getYear())
            throw new OperacionInvalidaExcepcion("La fecha de caducidad de la tarjeta no es correcta");

        if (transaccion.getEsDiferido())
            transaccion.setTazaInteres(TransaccionServicio.INTERES_CONSUMO);
        else
            transaccion.setTazaInteres(BigDecimal.ZERO);

        transaccion.setTarjetaId(tarjeta.getId());
        transaccion.setTipo(TransaccionServicio.TIPO_CONSUMO);
        transaccion.setComision(this.calcularComisionBanco(transaccion.getValor()));
        transaccion.setEstado(TransaccionServicio.ESTADO_PENDIENTE);
        transaccion.setFechaHora(LocalDate.now());

        repositorio.save(transaccion);

        // Detalle adicional de la transacción
        /*DetalleTransaccion detalle = new DetalleTransaccion();
        detalle.setTransaccionId(transaccion.getId());
        detalle.setBeneficiario(beneficiario);
        detalle.setNumero(numeroTarjeta);
        detalle.setDescripcion(descripcion);

        detalleTransaccionRepositorio.save(detalle);*/
    }

    private BigDecimal calcularComisionBanco(BigDecimal valor) {
        return valor.multiply(TransaccionServicio.PORCENTAJE_COMISION_CONSUMO);
    }
}
