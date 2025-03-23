package com.seecoder.BlueWhale.repository;

import com.seecoder.BlueWhale.po.MyObject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<MyObject, Long> {
  // MyObject findById(Long id);

  List<MyObject> findByStoreID(Long storeID);
}
