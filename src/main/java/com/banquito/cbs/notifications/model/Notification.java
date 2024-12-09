package com.banquito.cbs.notifications.model;

import com.banquito.cbs.customer.model.Customer;
import com.banquito.cbs.transactions.model.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.util.Objects;

public class Notification {
    @Id
    @Column
    private Integer id;

    @Column(name = "cliente_id", nullable = false)
    private Long customerId;

    @Column(name = "transaccion_id", nullable = false)
    private Long transactionId;

    @Column(name = "tipo_notificacion", length = 3, nullable = false)
    private String notificationType;

    @Column(name = "contenido", nullable = false)
    private String content;

    @Column(name = "fecha_envio", nullable = false)
    private Date sendDate;

    @Column(name = "estado", nullable = false)
    private String notificationState;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Transaction transaction;

    public Notification() { }

    public Notification(Long customerId, Long transactionId, String notificationType, String content, Date sendDate, String notificationState) {
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.notificationType = notificationType;
        this.content = content;
        this.sendDate = sendDate;
        this.notificationState = notificationState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(customerId, that.customerId) && Objects.equals(transactionId, that.transactionId) && Objects.equals(notificationType, that.notificationType) && Objects.equals(content, that.content) && Objects.equals(sendDate, that.sendDate) && Objects.equals(notificationState, that.notificationState) && Objects.equals(customer, that.customer) && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
