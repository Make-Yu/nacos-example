package com.boot.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.www.service.StorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("storage")
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	@GetMapping("/find/{id}")
	public Object getUser(@PathVariable long id) {
		return storageService.findById(id);
	}
	
	@PutMapping("deduct")
	public void deduct(String commodityCode, int count) {
		storageService.deduct(commodityCode, count);
		log.info("Storage Controller End ... ");
	}
}
