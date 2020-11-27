package com.boot.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.www.entity.Order;

@Repository
public interface OrdersDao extends JpaRepository<Order,Long>{

}
