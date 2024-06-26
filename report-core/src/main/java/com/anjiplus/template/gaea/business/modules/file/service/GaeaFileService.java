package com.anjiplus.template.gaea.business.modules.file.service;

import com.anji.plus.gaea.curd.service.GaeaBaseService;
import com.anjiplus.template.gaea.business.modules.file.entity.GaeaFile;
import com.anjiplus.template.gaea.business.modules.file.controller.param.GaeaFileParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * (GaeaFile)Service
 *

 */
public interface GaeaFileService extends GaeaBaseService<GaeaFileParam, GaeaFile> {

    /**
     * 文件上传
     *
     * @param multipartFile  文件
     * @return
     */
    GaeaFile upload(MultipartFile multipartFile);


    /**
     * 文件上传
     *
     * @param file 二选一
     * @return
     */
    GaeaFile upload(File file);
    /**
     * 根据fileId显示图片或者下载文件
     *
     * @param request
     * @param response
     * @param fileId
     * @return
     */
    ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response, String fileId);

    /**
     * 获取文件
     * @param fileId
     * @return
     */
    byte[] getFile(String fileId);
}
