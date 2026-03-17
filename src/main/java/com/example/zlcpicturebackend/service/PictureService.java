package com.example.zlcpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zlcpicturebackend.model.dto.picture.PictureQueryRequest;
import com.example.zlcpicturebackend.model.dto.picture.PictureReviewRequest;
import com.example.zlcpicturebackend.model.dto.picture.PictureUploadByBatchRequest;
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


    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);
    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 批量创建和抓取图片
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest,User loginUser);
    void fillReviewParams(Picture picture, User loginUser);
}
