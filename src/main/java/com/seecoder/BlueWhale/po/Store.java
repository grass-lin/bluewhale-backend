package com.seecoder.BlueWhale.po;

import com.seecoder.BlueWhale.vo.StoreVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Store {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "description")
  private String description;

  @Basic
  @Column(name = "introduction")
  private String introduction;

  @Basic
  @Column(name = "logo_url")
  private String logoURL;

  public Store(StoreVO storeVO, String url) {
    this.name = storeVO.getName();
    this.description = storeVO.getDescription();
    this.introduction = storeVO.getIntroduction();
    this.logoURL = url;
  }

}
