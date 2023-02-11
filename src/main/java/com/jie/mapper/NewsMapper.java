package com.jie.mapper;

import com.jie.pojo.News;
import com.jie.pojo.NewsCategories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {

    List<NewsCategories> queryNewsMostOften();
    List<NewsCategories> queryNewsMostStar();
    List<NewsCategories> queryNews();

    List<NewsCategories> queryDraft(String username);

    List<NewsCategories> queryAudit();

    int insertNews(News news);

    int updateAuditState(int id,int auditState);

    int updateState(int id,int auditState,int publishState);

    int deleteNews(int id);
}
