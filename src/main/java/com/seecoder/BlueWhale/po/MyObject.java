package com.seecoder.BlueWhale.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.seecoder.BlueWhale.vo.ObjectVO;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MyObject {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "price")
  private Long price;

  @Basic
  @Column(name = "descripton")
  private String description;

  @Basic
  @Column(name = "store_id")
  private Long storeID;

  @Basic
  @Column(name = "photo_url")
  private String photo_url;

  public MyObject(ObjectVO newObject, String photo_url) {
    this.id = newObject.getId();
    this.name = newObject.getName();
    this.price = newObject.getPrice();
    this.description = newObject.getDescrption();
    this.storeID = newObject.getStoreID();
    this.photo_url = photo_url;
  }

}
