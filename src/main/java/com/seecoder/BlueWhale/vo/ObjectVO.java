package com.seecoder.BlueWhale.vo;

import com.seecoder.BlueWhale.po.MyObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectVO {

  private Long id;

  private String name;

  private Long price;

  private String descrption;

  private Long storeID;

  private String imageURL;

  public ObjectVO(MyObject myObject) {
    this.id = myObject.getId();
    this.name = myObject.getName();
    this.price = myObject.getPrice();
    this.descrption = myObject.getDescription();
    this.storeID = myObject.getStoreID();
    this.imageURL = myObject.getPhoto_url();
  }

  public ObjectVO(String name, String des, Long pri, Long s_id) {
    this.name = name;
    this.price = pri;
    this.descrption = des;
    this.storeID = s_id;
  }
}
