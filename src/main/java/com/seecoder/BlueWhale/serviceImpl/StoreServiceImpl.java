package com.seecoder.BlueWhale.serviceImpl;

import com.seecoder.BlueWhale.exception.BlueWhaleException;
import com.seecoder.BlueWhale.po.Store;
import com.seecoder.BlueWhale.repository.StoreRepository;
import com.seecoder.BlueWhale.service.StoreService;
import com.seecoder.BlueWhale.vo.StoreVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
  @Autowired
  StoreRepository storeRepository;

  @Override
  public Boolean addStore(StoreVO newStoreVO, String url) {
    Store newStore = new Store(newStoreVO, url);
    storeRepository.save(newStore);

    return true;
  }

  @Override
  public Boolean removeStore(Long storeID) {
    if (!storeRepository.existsById(storeID)) {
      return false;
      // throw new BlueWhaleException("Store not found");
    }
    storeRepository.deleteById(storeID);
    return true;
  }

  @Override
  public List<StoreVO> allStore() {
    List<Store> storeList = storeRepository.findAll();
    List<StoreVO> result = new ArrayList<StoreVO>();
    for (Store store : storeList) {
      result.add(new StoreVO(store));
    }

    return result;
  }

  @Override
  public StoreVO getStoreByID(Long id) {
    Optional<Store> storeOptional = storeRepository.findById(id);
    if (storeOptional.isPresent()) {
      return new StoreVO(storeOptional.get());
    } else {
      // Handle the case where the store is not found
      throw new BlueWhaleException("Store not found");
    }
  }

}
