package com.cubanoar.springboot.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.cubanoar.springboot.app.models.entity.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long>{

}
