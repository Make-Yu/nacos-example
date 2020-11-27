package com.boot.www.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.boot.www.dao.StorageDao;
import com.boot.www.entity.Storage;
import com.boot.www.service.StorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageDao storageDao;

	@Override
	public Storage findById(long id) {
		Optional<Storage> opt = storageDao.findById(id);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public void deduct(String commodityCode, int count) {
		Storage storage = new Storage();
		storage.setCommodityCode(commodityCode);
	    Example<Storage> example = Example.of(storage);
	    Optional<Storage> opt = storageDao.findOne(example);
	    storage =  opt.get();
	    storage.setCount(storage.getCount()-count);
//		storageDao.updateCountByCommodityCode(count,commodityCode);
	    
	    storageDao.save(storage);
		log.info("Storage Service End ... ");
	}
}
