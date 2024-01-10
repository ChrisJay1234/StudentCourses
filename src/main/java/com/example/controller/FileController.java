package com.example.controller;


import cn.hutool.core.io.FileUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class FileController {
    // 获取 application.yml 中的值
    @Value("${ip:localhost}") // ":localhost"设置默认值
    String ip;
    @Value("${server.port}")
    String port;
    private static String ROOT_PATH = System.getProperty("user.dir") + File.separator + "files";

    @PostMapping("/upload")
    public Map<String, String> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename(); // 文件的原始名称 aa.txt
        String mainName = FileUtil.mainName(originalFilename); // 不包含后缀的名称 aa
        String extName = FileUtil.extName(originalFilename);// 获取文件后缀 不带.  txt

        if (!FileUtil.exist(ROOT_PATH)){
            FileUtil.mkdir(ROOT_PATH);// 如果当前文件的父级目录不存在，就创建
        }
        // File.separator 是分隔符
        if (FileUtil.exist(ROOT_PATH + File.separator + originalFilename)){ // 如果当前的文件名已经存在，就重命名
            originalFilename = System.currentTimeMillis() + "_" + mainName + "." + extName;
        }
        File saveFile = new File(ROOT_PATH + File.separator + originalFilename) ; // D:\Desktop\PBL\files\1142141_aa.txt
        file.transferTo(saveFile); // 存储传过来的文件到本地的磁盘
        String url = "http://" + ip + ":" + port + "/files/download/" + originalFilename;
        Map<String, String> res = new HashMap<>();
        res.put("error_message", "success");
        res.put("url", url); // 返回文件的地址
        return res;
    }
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        String filePath = ROOT_PATH + File.separator + fileName;
        if (!FileUtil.exist(filePath)) return;

        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes); // 数组是一个字节数组，也就是文件的字节流数组
        outputStream.flush();
        outputStream.close();
    }
}
