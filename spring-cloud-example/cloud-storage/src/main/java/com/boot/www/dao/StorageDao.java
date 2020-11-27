package com.boot.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.www.entity.Storage;

public interface StorageDao extends JpaRepository<Storage, Long>{

}
