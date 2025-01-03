package com.example.demo.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "T01_SOLICITUD" ,indexes = {
		@Index( name = "INDEXSOLICITUD",columnList = "ID_CLIENTE")
})

public class T01_Solicitud {

	@Id
	@Column(name = "ID_SOLICITUD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idSolicitud;
	
	@Column(name = "ESTADO")
	private Integer estado;
	
	@Column(name = "FECHA_INGRESO")
    @JsonFormat(pattern = "dd/MM/yyyy") 
	private Date fechaIngreso;
	
	@Column(name = "MONTO")
	private Double monto;
	
	@Column(name = "ID_CLIENTE")
	private String idCliente;

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	

}
