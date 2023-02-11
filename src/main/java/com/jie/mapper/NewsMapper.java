package com.jie.mapper;

import com.jie.pojo.NewCategoryRole;
import com.jie.pojo.News;
import com.jie.pojo.NewsCategories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * auditState 0=>未审核 1=>审核中 2=>已通过 3=>未通过
 * publishState 1=>未发布 1=>审核中 2=>已发布 3=>已下线
 */
@Mapper
@Repository
public interface NewsMapper {

    List<NewsCategories> queryNewsMostOften();
    List<NewsCategories> queryNewsMostStar();

    /**
     * 全部新闻
     * @return
     */
    List<NewsCategories> queryNews();

    /**
     * 草稿箱
     * @param username
     * @return
     */
    List<NewsCategories> queryDraft(String username);

    /**
     * 审核新闻 (审核中)
     * @return
     */
    List<NewsCategories> queryUnderReview();

    /**
     * 审核列表
     * @return
     */
    List<NewsCategories> queryAudit();

    /**
     * 新闻详情
     * @return
     */
    List<NewCategoryRole> queryPreview();

    /**
     * 待发布 已发布 已下线
     * @param author
     * @param publishState
     * @return
     */
    List<NewsCategories> queryNewsByPublishState(String author,int publishState);

    int insertNews(News news);

    int updateAuditState(int id,int auditState);

    int updateState(int id,int auditState,int publishState);

    int deleteNews(int id);
}
