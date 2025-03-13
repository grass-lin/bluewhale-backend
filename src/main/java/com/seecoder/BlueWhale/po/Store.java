package com.seecoder.BlueWhale.po;

import com.seecoder.BlueWhale.vo.StoreVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Store {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Integer id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "create_time")
  private Date createTime;

  @Basic
  @Column(name = "user_id")
  private Integer userId;

  @Basic
  @Column(name = "logo_url")
  private String logoURL;

  public Store(StoreVO storeVO, int userId) {
    this.id = storeVO.getId();
    this.name = storeVO.getName();
    this.createTime = storeVO.getCreateTime();
    this.userId = userId;
    this.logoURL = storeVO.getLogoURL();
  }

  public StoreVO toVO() {
    return new StoreVO(this.id, this.name, this.createTime, this.logoURL);
  }
}
