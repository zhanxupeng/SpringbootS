package com.mybatis.test.controller.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("image")
public class ImageController {
    private final static String DEFAULT_PATH = "G:\\lunwen\\picture";

    /**
     * 显示图片接口
     */
    @GetMapping("show")
    public void imageUlr(String imagePath, HttpServletResponse response) throws IOException {
        File file;
        if (StringUtils.isBlank(imagePath)) {
            Resource resource = new ClassPathResource("\\static\\images\\avatar\\default.png");
            file = resource.getFile();
        } else {
            imagePath = URLDecoder.decode(imagePath, "utf-8");
            file = new File(imagePath);
        }
        FileInputStream inputStream = new FileInputStream(file);
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

    /**
     * 上传图片
     */
    @PostMapping("upload")
    @ResponseBody
    public Map testUpload(MultipartFile file) {

        Map<String, Object> map = null;
        try {
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

            map = new TreeMap<>();

            //图片保存路径
            String urlStr = "\\image\\show?imagePath=" + URLEncoder.encode(DEFAULT_PATH + "\\" + newFileName, "utf-8");
            map.put("status", 0);
            map.put("url", urlStr);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("msg", "系统异常，上传失败");
            return map;
        }
    }
}
