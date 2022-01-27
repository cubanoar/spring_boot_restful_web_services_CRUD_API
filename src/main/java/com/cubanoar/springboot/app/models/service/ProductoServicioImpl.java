package com.cubanoar.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubanoar.springboot.app.models.dao.IProductoRepository;
import com.cubanoar.springboot.app.models.entity.Producto;

@Service
public class ProductoServicioImpl implements IProductoServicio{

	@Autowired
	private IProductoRepository repositorio;

	@Override
	public List<Producto> findAll() {
		return repositorio.findAll();
	}

	@Override
	public void save(Producto producto) {
		repositorio.save(producto);
	}

	@Override
	public Producto findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
