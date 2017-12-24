/*
package com.mybatis.test.controller.business;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class HelloController {


    private final static String DEFAULT_PATH = "G:\\lunwen\\picture";

    @GetMapping("test")
    public String test(Model model) {
        Map<String, Object> map1 = new TreeMap<>();
        map1.put("name", "小明");
        map1.put("sex", "男");
        Map<String, Object> map2 = new TreeMap<>();
        map2.put("name", "小鹿");
        map2.put("sex", "女");
        Map<String, Object> map3 = new TreeMap<>();
        map3.put("name", "小张");
        map3.put("sex", "男");
        List<Map<String, Object>> list = new ArrayList<>(Arrays.asList(map1, map2, map3));
        model.addAttribute("list", list);
        return "test";
    }

    @PostMapping("test/upload")
    @ResponseBody
    public Map testUpload(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();//文件原名称
        //自定义的文件名称
        String newFileName = String.valueOf(System.currentTimeMillis()) + fileName;

        File currentFile = new File(DEFAULT_PATH, newFileName);
        if (!currentFile.getParentFile().exists()) {
            currentFile.getParentFile().mkdirs();
        }
        if (!currentFile.exists()) {
            currentFile.createNewFile();
        }

        file.transferTo(currentFile);

        Map<String, Object> map = new TreeMap<>();

        //图片保存路径
        String urlStr = "\\image\\show?imagePath=" + URLEncoder.encode(DEFAULT_PATH + "\\" + newFileName, "utf-8");

        System.out.println(urlStr);

        map.put("url", urlStr);
        return map;
    }
}
*/
