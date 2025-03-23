package com.seecoder.BlueWhale.vo;

import com.seecoder.BlueWhale.po.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreVO {

  private Long id;

  private String name;

  private String introduction;

  private String description;

  private String logoURL;

  public StoreVO(Store store) {
    this.id = store.getId();
    this.name = store.getName();
    this.introduction = store.getIntroduction();
    this.description = store.getDescription();
    this.logoURL = store.getLogoURL();
  }

  public StoreVO(String name, String introduction, String des) {
    this.name = name;
    this.introduction = introduction;
    this.description = des;
  }

}
