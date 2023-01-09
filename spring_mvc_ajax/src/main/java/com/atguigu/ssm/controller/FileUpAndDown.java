package com.atguigu.ssm.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @date 2023/1/5   22:32
 */
@Controller
public class FileUpAndDown {

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径 ///static/img/1.jpeg
        String realPath = servletContext.getRealPath("static");
        realPath = realPath + File.separator + "img" + File.separator + "1.jpeg";
        //创建输入流
        System.out.println(realPath);
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpeg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传文件的文件名称
        String filename = photo.getOriginalFilename();
        //获取文件名后缀
        String hzName = filename.substring(filename.lastIndexOf("."));
        //获取UUID
        String uuid = UUID.randomUUID().toString();
        //拼接一个新的文件名
        filename = uuid + hzName;
        System.out.println(filename);
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        //创建photoPath所对应的File对象
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }else if (!file.isDirectory()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;
        //上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
