package com.seecoder.BlueWhale.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seecoder.BlueWhale.po.MyObject;
import com.seecoder.BlueWhale.repository.ObjectRepository;
import com.seecoder.BlueWhale.service.ObjectService;
import com.seecoder.BlueWhale.vo.ObjectVO;

@Service
public class ObjectServiceImpl implements ObjectService {

  @Autowired
  ObjectRepository objectRepository;

  @Override
  public Boolean addObjectToStore(ObjectVO newObjectVO, String newURL) {
    MyObject newObject = new MyObject(newObjectVO, newURL);
    objectRepository.save(newObject);
    return true;
  }

  @Override
  public Boolean removeObjectFromStore(Long objectID) {
    objectRepository.deleteById(objectID);
    return true;
  }

  @Override
  public List<ObjectVO> allObject() {
    List<MyObject> myObjectList = objectRepository.findAll();
    List<ObjectVO> result = new ArrayList<ObjectVO>();
    for (MyObject myObject : myObjectList) {
      result.add(new ObjectVO(myObject));
    }
    return result;

  }

  @Override
  public List<ObjectVO> allObject(Long storeID) {
    List<MyObject> myObjectList = objectRepository.findByStoreID(storeID);
    List<ObjectVO> result = new ArrayList<ObjectVO>();
    for (MyObject myObject : myObjectList) {
      result.add(new ObjectVO(myObject));
    }
    return result;

  }
}
