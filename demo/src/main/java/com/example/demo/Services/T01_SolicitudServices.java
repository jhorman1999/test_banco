package com.example.demo.Services;

import java.net.http.HttpClient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.interfaces.TO1_SolicitudInterface;
import com.example.demo.models.T01_Solicitud;

@Service
public class T01_SolicitudServices {

	@Autowired
	private TO1_SolicitudInterface t01To1_SolicitudInterface;
	
	public List<T01_Solicitud> getAll(){
		return t01To1_SolicitudInterface.findAll();
	}
	
	public T01_Solicitud getSolicitudId(Integer id) {
		return t01To1_SolicitudInterface.findByIdSolicitud(id);
	}
	
	public T01_Solicitud saveSolicitud(T01_Solicitud solicitud) {		
		return t01To1_SolicitudInterface.save(solicitud);
	}
	
	public void delete(Integer id) {
	 t01To1_SolicitudInterface.deleteById(id);
	}
	
	public List<T01_Solicitud> getSolicitudIdCliente(String id) {
		return t01To1_SolicitudInterface.findByIdCliente(id);
	}
	
}
