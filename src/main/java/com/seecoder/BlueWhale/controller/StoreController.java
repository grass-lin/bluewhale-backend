package com.seecoder.BlueWhale.controller;

import com.seecoder.BlueWhale.service.StoreService;
import com.seecoder.BlueWhale.vo.ResultVO;
import com.seecoder.BlueWhale.vo.StoreVO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/store")
public class StoreController {

  @Autowired
  StoreService storeService;

  @Value("${upload.directory}")
  private String uploadDir;

  @GetMapping("/all")
  public ResultVO<List<StoreVO>> allStore() {
    return ResultVO.buildSuccess(storeService.allStore());
  }

  @GetMapping("/certain")
  public ResultVO<StoreVO> certainStore(@RequestParam("store_id") Long storeID) {
    // Long storeID = (Long) body.get("id");
    return ResultVO.buildSuccess(storeService.getStoreByID(storeID));

  }

  // TODO:
  @PostMapping("/new")
  public ResultVO<Boolean> addStore(@RequestPart("name") String name, @RequestPart("introduction") String intro,
      @RequestPart("description") String des, @RequestPart("image") MultipartFile image) {
    StoreVO newStore = new StoreVO(name, intro, des);
    File directory = new File(uploadDir);
    if (!directory.exists()) {
      directory.mkdirs();
    }
    String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
    Path path = Paths.get(uploadDir + fileName);
    try {
      Files.write(path, image.getBytes());
    } catch (IOException e) {
      String errMsg = "Failed to save photo in StoreController";
      System.err.println(errMsg);
      return ResultVO.buildFailure(errMsg);
    }
    return ResultVO.buildSuccess(storeService.addStore(newStore, fileName));

  }

  // TODO:
  @PostMapping("/remove")
  public ResultVO<Boolean> removeStore(@RequestBody Map<String, Object> requestBody) {
    Integer storeIdInt = (Integer) requestBody.get("store_id");
    Long storeId = storeIdInt != null ? storeIdInt.longValue() : null;
    return ResultVO.buildSuccess(storeService.removeStore(storeId));
  }

}
