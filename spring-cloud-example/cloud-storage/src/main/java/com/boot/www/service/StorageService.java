package com.boot.www.service;

import com.boot.www.entity.Storage;

public interface StorageService {

	 /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
    
    Storage findById(long id);
}
