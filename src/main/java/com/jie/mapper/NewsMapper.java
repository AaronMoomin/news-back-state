package com.jie.mapper;

import com.jie.pojo.NewCategoryRole;
import com.jie.pojo.News;
import com.jie.pojo.NewsCategories;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * auditState 0=>未审核 1=>审核中 2=>已通过 3=>未通过
 * publishState 0=>未发布 1=>审核中 2=>已发布 3=>已下线
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
    List<NewsCategories> queryAudit(String username);

    /**
     * 新闻详情
     * @return
     */
    NewCategoryRole queryPreview(int id);

    /**
     * 待发布 已发布 已下线
     * @param author
     * @param publishState
     * @return
     */
    List<NewsCategories> queryNewsByPublishState(String author,int publishState);

    int insertNews(News news);

    int updateNew(News news,int id);

    int updateAuditState(int id,int auditState);
    int updatePublishState(int id,int publishState);

    int updateState(int id,int auditState,int publishState);

    int releaseNews(int id,int publishState,String publishTime);

    int deleteNews(int id);

    int updateView(int id,int view);
    int updateStar(int id,int star);
}
