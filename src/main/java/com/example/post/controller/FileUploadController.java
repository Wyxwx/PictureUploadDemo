package com.example.post.controller;

import com.example.post.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: wyx
 * @Date: 2019-04-08 10:13
 * @Description:
 */

@Controller
public class FileUploadController {

    @Value("${web.upload-path}")
    private String path;

    /**
     *
     * @param file 上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file){
        //1定义要上传文件 的存放路径
        String localPath="E:/image";
//        String localPath = "/root/photo";
        //2获得文件名字
        String fileName=file.getOriginalFilename();
        //2上传失败提示
        String warning="";
        String newFileName = FileUtils.upload(file, localPath, fileName);
        if(newFileName != null){
            //上传成功
            warning="上传成功";

        }else{
            warning="上传失败";
        }
        System.out.println(warning);
        return warning;
    }

}

