package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Services.T01_SolicitudServices;
import com.example.demo.helpers.ValidateDate;
import com.example.demo.models.T01_Solicitud;

@RestController
@RequestMapping("/api/t01_solicitud")
public class T01_SolicitudController {

	//service
	@Autowired
	T01_SolicitudServices t01_SolicitudServices;
	
	@GetMapping
	public List<T01_Solicitud> getAllSolicitud(){
		return t01_SolicitudServices.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T01_Solicitud> getSolicitud(@PathVariable Integer id){
		
		T01_Solicitud solicitud = t01_SolicitudServices.getSolicitudId(id);
		return ResponseEntity.ok(solicitud);
		
	}
	
	@PostMapping
	public ResponseEntity postSolicitud(@RequestBody T01_Solicitud solicitud){
		Double montoMinimo = 1000000.;
		
		if(solicitud.getMonto() <  montoMinimo) {
			return ResponseEntity.badRequest().body("El monto debe ser mayor a un millon"); 
		}
		
		Date today = new Date();
		
		ValidateDate validateDate = new ValidateDate();
		
		if(solicitud.getFechaIngreso().before(today)  ) {
			if(!validateDate.isToday2(today)){
				return ResponseEntity.badRequest().body("la fecha debe ser igual o mayor a hoy"); 

			}
		}
		
		List<T01_Solicitud> exisSolicitud = t01_SolicitudServices.getSolicitudIdCliente(solicitud.getIdCliente());
		
		if(exisSolicitud != null) {
			return ResponseEntity.badRequest().body("el cliente ya tiene una solicitud"); 
		}
		
		T01_Solicitud saveSolicitud = t01_SolicitudServices.saveSolicitud(solicitud);
			
		return ResponseEntity.ok(saveSolicitud);
	}
	
	@PutMapping
	public ResponseEntity<T01_Solicitud> putSolicitud(@RequestBody T01_Solicitud solicitud){
		T01_Solicitud exitsSolicitud = t01_SolicitudServices.getSolicitudId(solicitud.getIdSolicitud());
		
		if(exitsSolicitud == null) {
			return ResponseEntity.notFound().build();
		}
		
		exitsSolicitud.setEstado(solicitud.getEstado());
		exitsSolicitud.setFechaIngreso(solicitud.getFechaIngreso());
		exitsSolicitud.setMonto(solicitud.getMonto());
		exitsSolicitud.setIdCliente(solicitud.getIdCliente());

		T01_Solicitud saveSolicitud= t01_SolicitudServices.saveSolicitud(exitsSolicitud);
		
		return  ResponseEntity.ok(saveSolicitud);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<T01_Solicitud> postSolicitud(@PathVariable Integer id){

		t01_SolicitudServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
