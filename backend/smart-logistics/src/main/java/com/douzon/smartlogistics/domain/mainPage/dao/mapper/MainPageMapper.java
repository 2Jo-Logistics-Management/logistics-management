package com.douzon.smartlogistics.domain.mainPage.dao.mapper;

import com.douzon.smartlogistics.domain.entity.MainPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainPageMapper {

    List<MainPage> warehouseRankList();
}
