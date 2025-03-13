package com.seecoder.BlueWhale.vo;

import com.seecoder.BlueWhale.po.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreVO {

  private Integer id;

  private String name;

  private Date createTime;

  private String logoURL;

  public Store toPO(int userId) {
    return new Store(this, userId);
  }
}
