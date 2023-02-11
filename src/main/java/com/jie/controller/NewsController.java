package com.jie.controller;

import com.jie.mapper.NewsMapper;
import com.jie.pojo.NewCategoryRole;
import com.jie.pojo.News;
import com.jie.pojo.NewsCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsMapper newsMapper;

    @DeleteMapping("/delete/{id}")
    public String deleteNews(@PathVariable int id){
        newsMapper.deleteNews(id);
        return "删除成功";
    }

    @PostMapping("/updateAuditState")
    public String updateAuditState(int id,int auditState){
        newsMapper.updateAuditState(id,auditState);
        return "更新成功";
    }

    @PostMapping("/updateState")
    public String updateState(int id,int auditState,int publishState){
        newsMapper.updateState(id,auditState,publishState);
        return "更新成功";
    }

    @PostMapping("/add")
    public String addNews(@RequestBody News news){
        newsMapper.insertNews(news);
        return "添加成功";
    }

    @PostMapping("/update")
    public String updateNew(@RequestBody News news){
        newsMapper.updateNew(news);
        return "更新成功";
    }

    @GetMapping("/lists/{author}/{publishState}")
    public List<NewsCategories> queryNewsByPublishState(@PathVariable String author,@PathVariable int publishState){
        return newsMapper.queryNewsByPublishState(author,publishState);
    }

    /**
     * 详情
     * @return
     */
    @GetMapping("/lists/preview")
    public List<NewCategoryRole> queryPreview(){
        return newsMapper.queryPreview();
    }

    @GetMapping("/lists/audit")
    public List<NewsCategories> queryAudit(){
        return newsMapper.queryAudit();
    }

    @GetMapping("/lists/underReview")
    public List<NewsCategories> queryUnderReview(){
        return newsMapper.queryUnderReview();
    }

    @GetMapping("/lists/{username}")
    public List<NewsCategories> queryNewsByUsername(@PathVariable String username){
        return newsMapper.queryDraft(username);
    }

    @GetMapping("/newsMostOften")
    public List<NewsCategories> getNewsMostOften(){
        return newsMapper.queryNewsMostOften();
    }

    @GetMapping("/newsMostStar")
    public List<NewsCategories> getNewsMostStar(){
        return newsMapper.queryNewsMostStar();
    }

    @GetMapping("/lists")
    public List<NewsCategories> getNews(){
        return newsMapper.queryNews();
    }
}
