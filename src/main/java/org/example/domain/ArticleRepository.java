package org.example.domain;

import org.example.base.CommonUtill;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article>articleList = new ArrayList<>();
    CommonUtill commonUtill = new CommonUtill();
    int latestArticleId = 4;

    public ArticleRepository(){
        makeTestDate();
    }
    public void makeTestDate(){
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.","냉무",0,commonUtill.getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~","냉무",0,commonUtill.getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?","냉무",0,commonUtill.getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }
    public ArrayList<Article> findArticleByKeyword(String keyword){
        ArrayList<Article> searchedList = new ArrayList<>();
        for (int i=0; i<articleList.size(); i++){
            Article article = articleList.get(i);
            if (article.getTitle().contains(keyword)){
                searchedList.add(article);
            }
        }
        return searchedList;
    }
    public Article findArticleById(int id){
        for (int i=0; i<articleList.size(); i++){
            Article article = articleList.get(i);

            if (article.getId() == id){
                return article;
            }
        }
        return null;
    }
    public void deleteArticle(Article article){
        articleList.remove(article);
    }
    public void updateArticle(Article article, String newTitle, String newBody){
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public ArrayList<Article>findAll(){
        return articleList;
    }
    public Article saveArticle(String title, String body){
        Article article = new Article(latestArticleId, title, body, 0, commonUtill.getCurrentDateTime());
        articleList.add(article);
        latestArticleId++;

        return article;
    }


}
