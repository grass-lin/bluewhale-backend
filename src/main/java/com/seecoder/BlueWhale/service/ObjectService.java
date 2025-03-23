package com.seecoder.BlueWhale.service;

import java.util.List;

import com.seecoder.BlueWhale.vo.ObjectVO;

public interface ObjectService {
  Boolean addObjectToStore(ObjectVO newObject, String photoURL);

  Boolean removeObjectFromStore(Long objectID);

  List<ObjectVO> allObject();

  List<ObjectVO> allObject(Long storeID);
}
