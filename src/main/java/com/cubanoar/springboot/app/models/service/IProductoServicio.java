package com.cubanoar.springboot.app.models.service;

import java.util.List;


import com.cubanoar.springboot.app.models.entity.Producto;

public interface IProductoServicio {

	public List<Producto> findAll();

	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);

}
