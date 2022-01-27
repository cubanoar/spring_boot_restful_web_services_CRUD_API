package com.cubanoar.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cubanoar.springboot.app.models.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long>{

}
