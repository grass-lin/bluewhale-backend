package com.seecoder.BlueWhale.service;

import java.util.List;

import com.seecoder.BlueWhale.vo.StoreVO;

public interface StoreService {
  Boolean addStore(StoreVO newStore, String url);

  Boolean removeStore(Long objectID);

  List<StoreVO> allStore();

  StoreVO getStoreByID(Long id);
}
