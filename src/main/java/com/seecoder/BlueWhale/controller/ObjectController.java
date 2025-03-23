package com.seecoder.BlueWhale.controller;

import com.seecoder.BlueWhale.service.ObjectService;
import com.seecoder.BlueWhale.vo.ObjectVO;
import com.seecoder.BlueWhale.vo.ResultVO;

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
@RequestMapping("/api/object")
public class ObjectController {

  @Autowired
  ObjectService objectService;

  @Value("${upload.directory}")
  private String uploadDir;

  @GetMapping("/all")
  public ResultVO<List<ObjectVO>> allObject() {
    return ResultVO.buildSuccess(objectService.allObject());

  }

  @GetMapping("/store")
  public ResultVO<List<ObjectVO>> allObjectOfStore(@RequestParam("store_id") Long storeID) {
    // Long storeID = (Long) body.get("store_id");
    return ResultVO.buildSuccess(objectService.allObject(storeID));

  }

  @PostMapping("/new")
  public ResultVO<Boolean> addObject(
      @RequestPart("name") String name,
      @RequestPart("description") String des,
      @RequestPart("price") String price,
      @RequestPart("store_id") String store_id,
      @RequestPart("image") MultipartFile image) {
    ObjectVO newObject = new ObjectVO(name, des, Long.parseLong(price), Long.parseLong(store_id));
    // ObjectVO newObject = new ObjectVO();
    File directory = new File(uploadDir);
    if (!directory.exists()) {
      directory.mkdirs();
    }
    String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
    Path path = Paths.get(uploadDir + fileName);
    try {
      Files.write(path, image.getBytes());
    } catch (IOException e) {
      String errMsg = "Failed to save photo in ObjectController";
      System.err.println(errMsg);
      return ResultVO.buildFailure(errMsg);
    }
    return ResultVO.buildSuccess(objectService.addObjectToStore(newObject, fileName));
  }

  // TODO:
  @PostMapping("/remove")
  public ResultVO<Boolean> removeObject(@RequestBody Map<String, Object> requestBody) {
    Long objectId = (Long) requestBody.get("object_id");
    return ResultVO.buildSuccess(objectService.removeObjectFromStore(objectId));
  }

}
