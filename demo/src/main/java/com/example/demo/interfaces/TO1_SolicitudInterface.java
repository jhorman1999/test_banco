package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.T01_Solicitud;
import java.util.List;


public interface TO1_SolicitudInterface extends JpaRepository<T01_Solicitud, Integer>{
	T01_Solicitud findByIdSolicitud(Integer id);	
	List<T01_Solicitud> findByIdCliente(String idCliente);
}
