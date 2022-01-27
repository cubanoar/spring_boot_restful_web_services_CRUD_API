package com.cubanoar.springboot.app.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.cubanoar.springboot.app.models.entity.Producto;
import com.cubanoar.springboot.app.models.service.IProductoServicio;

@RestController
public class ProductoController {

	@Autowired
	private IProductoServicio servicio;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return servicio.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
		try {
			Producto producto = servicio.findOne(id);
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}	 
	
	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto) {
		servicio.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto ,@PathVariable Long id) {
		try {
			Producto productoActual = servicio.findOne(id);
			
			productoActual.setNombre(producto.getNombre());
			productoActual.setPrecio(producto.getPrecio());
			
			servicio.save(productoActual);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		servicio.delete(id);
	}
}
