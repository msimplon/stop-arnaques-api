package co.simplon.stoparnaques.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subTitle;

    @Column(name = "editor")
    private String editor;

    @Column(name = "description")
    private String description;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_of_publication")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDateTime createdAt;

    public Article() {

    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getSubTitle() {
	return subTitle;
    }

    public void setSubTitle(String subTitle) {
	this.subTitle = subTitle;
    }

    public String getEditor() {
	return editor;
    }

    public void setEditor(String editor) {
	this.editor = editor;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;

    }

    public Category getCategory() {
	return category;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

    public LocalDateTime getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
    }

    public String getIntroduction() {
	return introduction;
    }

    public void setIntroduction(String introduction) {
	this.introduction = introduction;
    }

    @PrePersist
    private void createdAt() {
	setCreatedAt(LocalDateTime.now());
    }

    @Override
    public String toString() {
	return "{title=" + title + ", subTitle=" + subTitle
		+ ", editor=" + editor + ", description="
		+ description + ", introduction="
		+ introduction + ", imageUrl=" + imageUrl
		+ ", date=" + date + ", category="
		+ category + ", createdAt=" + createdAt
		+ "}";
    }

}
