package com.seecoder.BlueWhale.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

  @Value("${upload.directory}")
  private String uploadDir;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // Create uploads directory if it doesn't exist
    File directory = new File(uploadDir);
    if (!directory.exists()) {
      directory.mkdirs();
    }

    // Convert relative path to absolute path
    String absolutePath = Paths.get(uploadDir).toAbsolutePath().toString();

    // Ensure path ends with separator
    if (!absolutePath.endsWith(File.separator)) {
      absolutePath += File.separator;
    }

    // Map /static/** URL pattern to the file system location
    registry.addResourceHandler("/static/**")
        .addResourceLocations("file:" + absolutePath);

    System.out.println("Configured static resource handler for path: " + absolutePath);
  }
}