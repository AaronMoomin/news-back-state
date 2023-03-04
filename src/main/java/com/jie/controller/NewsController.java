package com.jie.controller;

import com.jie.mapper.NewsMapper;
import com.jie.pojo.NewCategoryRole;
import com.jie.pojo.News;
import com.jie.pojo.NewsCategories;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@Api(value = "新闻接口", tags = "新闻相关的接口")
public class NewsController {

    @Autowired
    NewsMapper newsMapper;

    /**
     * 删除新闻
     *
     * @param id
     * @return
     */
    @Operation(summary = "删除新闻", description = "删除新闻")
    @DeleteMapping("/delete/{id}")
    public String deleteNews(@PathVariable String id) {
        newsMapper.deleteNews(Integer.parseInt(id));
        return "删除成功";
    }

    /**
     * 更新审核状态
     * @param id
     * @param auditState
     * @return
     */
    @Operation(summary = "更新审核状态", description = "更新审核状态")
    @PostMapping("/updateAuditState")
    public String updateAuditState(String id, int auditState) {
        newsMapper.updateAuditState(Integer.parseInt(id), auditState);
        return "更新成功";
    }

    /**
     * 更新审核状态
     * @param id
     * @param publishState
     * @return
     */
    @Operation(summary = "更新发布状态", description = "更新发布状态")
    @PostMapping("/updatePublishState")
    public String updatePublishState(String id, int publishState) {
        newsMapper.updatePublishState(Integer.parseInt(id), publishState);
        return "更新成功";
    }

    /**
     * 更新状态
     * @param id
     * @param auditState
     * @param publishState
     * @return
     */
    @Operation(summary = "更新状态",description = "更新状态")
    @PostMapping("/updateState")
    public String updateState(int id, int auditState, int publishState) {
        newsMapper.updateState(id, auditState, publishState);
        return "更新成功";
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @Operation(summary = "添加新闻",description = "添加新闻")
    @PostMapping("/add")
    public String addNews(@RequestBody News news) {
        newsMapper.insertNews(news);
        return "添加成功";
    }

    /**
     * 更新新闻
     * @param news
     * @return
     */
    @Operation(summary = "更新新闻",description = "更新新闻")
    @PostMapping("/update/{id}")
    public String updateNew(@PathVariable String id,@RequestBody News news) {
        newsMapper.updateNew(news,Integer.parseInt(id));
        return "更新成功";
    }

    @Operation(summary = "发布新闻",description = "发布新闻")
    @PostMapping("/releaseNews/{id}")
    public String releaseNews(@PathVariable String id,@RequestBody News news){
        newsMapper.releaseNews(Integer.parseInt(id),news.getPublishState(),news.getPublishTime());
        return "更新成功";
    }

    /**
     * 获取发布的新闻
     * @param author
     * @param publishState
     * @return
     */
    @Operation(summary = "获取发布的新闻",description = "获取发布的新闻")
    @GetMapping("/lists/{author}/{publishState}")
    public List<NewsCategories> queryNewsByPublishState(@PathVariable String author, @PathVariable int publishState) {
        return newsMapper.queryNewsByPublishState(author, publishState);
    }

    /**
     * 获取新闻详情
     * @return
     */
    @Operation(summary = "获取新闻详情",description = "获取新闻详情")
    @GetMapping("/lists/preview/{id}")
    public NewCategoryRole queryPreview(@PathVariable String id) {
        return newsMapper.queryPreview(Integer.parseInt(id));
    }

    /**
     * 获取已审核未发布的新闻
     * @return
     */
    @Operation(summary = "获取已审核未发布的新闻",description = "获取已审核未发布的新闻")
    @GetMapping("/lists/audit/{username}")
    public List<NewsCategories> queryAudit(@PathVariable String username) {
        return newsMapper.queryAudit(username);
    }

    /**
     * 获取审核中的新闻
     * @return
     */
    @Operation(summary = "获取审核中的新闻",description = "获取审核中的新闻")
    @GetMapping("/lists/underReview")
    public List<NewsCategories> queryUnderReview() {
        return newsMapper.queryUnderReview();
    }

    /**
     * 获取用户的新闻
     * @param username
     * @return
     */
    @Operation(summary = "获取用户的新闻",description = "获取用户的新闻")
    @GetMapping("/lists/{username}")
    public List<NewsCategories> queryNewsByUsername(@PathVariable String username) {
        return newsMapper.queryDraft(username);
    }

    /**
     * 获取浏览量最高的新闻
     * @return
     */
    @Operation(summary = "获取浏览量最高的新闻",description = "获取浏览量最高的新闻")
    @GetMapping("/newsMostOften")
    public List<NewsCategories> getNewsMostOften() {
        return newsMapper.queryNewsMostOften();
    }

    /**
     * 获取点赞最多的新闻
     * @return
     */
    @Operation(summary = "获取点赞最多的新闻",description = "获取点赞最多的新闻")
    @GetMapping("/newsMostStar")
    public List<NewsCategories> getNewsMostStar() {
        return newsMapper.queryNewsMostStar();
    }

    /**
     * 获取新闻
     * @return
     */
    @Operation(summary = "获取新闻",description = "获取新闻")
    @GetMapping("/lists")
    public List<NewsCategories> getNews() {
        return newsMapper.queryNews();
    }

    @Operation(summary = "浏览量",description = "浏览量")
    @PostMapping("/updateView/{id}")
    public String updateView(@PathVariable String id, int view) {
        System.out.println(view);
        newsMapper.updateView(Integer.parseInt(id),view);
        return "更新成功";
    }

    @Operation(summary = "点赞",description = "点赞")
    @PostMapping("/updateStar/{id}")
    public String updateStar(@PathVariable String id, int star) {
        newsMapper.updateStar(Integer.parseInt(id),star);
        return "更新成功";
    }
}
