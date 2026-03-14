package com.example.zlcpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zlcpicturebackend.model.dto.picture.PictureQueryRequest;
import com.example.zlcpicturebackend.model.dto.picture.PictureUploadRequest;
import com.example.zlcpicturebackend.model.enity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zlcpicturebackend.model.enity.User;
import com.example.zlcpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author zhanglinchao
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2026-03-14 14:49:07
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);
}
