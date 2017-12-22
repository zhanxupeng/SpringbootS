package com.mybatis.test.controller.business;

import com.mybatis.test.common.config.CustomerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("{index}")
    public String getUrl(@PathVariable("index") String index) {
        System.out.println("index:" + CustomerUtils.getCustomer());
        return index;
    }

    @RequestMapping("user/{index}")
    public String getUser(@PathVariable("index") String index) {
        return "user/" + index;
    }

    @RequestMapping("jie/{index}")
    public String getJie(@PathVariable("index") String index) {
        return "jie/" + index;
    }

    @RequestMapping("test/{index}")
    public String getTest(@PathVariable("index") String index) {
        return "test/" + index;
    }

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

    @GetMapping("image/url")
    public void imageUlr(String imageName, HttpServletResponse response) throws IOException {
        String imagePath;
        if (StringUtils.isNotBlank(imageName)) {
            imagePath = "E:\\lunwen\\picture\\" + imageName;
        } else {
            imagePath = "E:\\lunwen\\picture\\28_140425143005_2.jpg";
        }
        FileInputStream inputStream = new FileInputStream(new File(imagePath));
        response.setContentType("multipart/form-data");
        ServletOutputStream out = response.getOutputStream();
        int i;
        byte[] buffer = new byte[4096];
        while ((i = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        out.flush();
        inputStream.close();
        out.close();
    }

    @PostMapping("test/upload")
    @ResponseBody
    public Map testUpload(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();//文件原名称
        //自定义的文件名称
        String newFileName = String.valueOf(System.currentTimeMillis()) + fileName;

        File currentFile = new File("E:\\lunwen\\picture", newFileName);
        if (!currentFile.getParentFile().exists()) {
            currentFile.getParentFile().mkdirs();
        }
        if (!currentFile.exists()) {
            currentFile.createNewFile();
        }

        file.transferTo(currentFile);

        Map<String, Object> map = new TreeMap<>();

        map.put("url", newFileName);
        return map;
    }
}
