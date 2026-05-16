package com.example.zlcpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zlcpicturebackend.model.dto.space.SpaceAddRequest;
import com.example.zlcpicturebackend.model.dto.space.SpaceQueryRequest;
import com.example.zlcpicturebackend.model.enity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zlcpicturebackend.model.enity.User;
import com.example.zlcpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author zhanglinchao
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2026-03-26 09:47:47
*/
public interface SpaceService extends IService<Space> {

    /**
     * 校验空间更新或创建请求
     * @param space
     * @param add
     */
    public void validSpace(Space space,boolean add);

    /**
     * 根据空间级别自动填充大小
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);
}
