package com.banquito.cbs.aplicacion.transaccion.controlador;

import com.banquito.cbs.aplicacion.transaccion.controlador.adaptador.TransaccionAdaptador;
import com.banquito.cbs.aplicacion.transaccion.controlador.peticion.ConsumoPeticion;
import com.banquito.cbs.aplicacion.transaccion.modelo.Transaccion;
import com.banquito.cbs.aplicacion.transaccion.servicio.TransaccionServicio;
import com.banquito.cbs.compartido.utilidades.UtilidadRespuesta;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("transacciones")
public class TransaccionControlador {
    private final TransaccionServicio servicio;
    private final TransaccionAdaptador adaptador;

    public TransaccionControlador(TransaccionServicio servicio, TransaccionAdaptador adaptador) {
        this.servicio = servicio;
        this.adaptador = adaptador;
    }

    /*@PostMapping("/deposito")
    public ResponseEntity<?> crearDeposito(@RequestBody Map<String, Object> datos) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/pago-tarjeta")
    public ResponseEntity<?> crearPagoTarjetaCredito(@RequestBody Map<String, Object> datos) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/transferencia-interna")
    public ResponseEntity<?> crearTransferenciaInterna(@RequestBody Map<String, Object> datos) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/transferencia-externa")
    public ResponseEntity<?> crearTransferenciaExterna(@RequestBody Map<String, Object> datos) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/

    @PostMapping("/consumo-tarjeta")
    public ResponseEntity<?> registrarConsumoTarjeta(@Valid @RequestBody ConsumoPeticion peticion)
    {
        Transaccion transaccion = this.adaptador.consumoATransaccion(peticion);
        this.servicio.registrarConsumoTarjeta(transaccion, peticion.getNumeroTarjeta(), peticion.getCvv(), peticion.getFechaCaducidad(), peticion.getDescripcion(), peticion.getNumeroCuenta(), peticion.getDetalle() );
        return ResponseEntity.status(HttpStatus.CREATED).body(UtilidadRespuesta.exito(peticion));
    }
}
