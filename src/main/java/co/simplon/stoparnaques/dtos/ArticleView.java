package co.simplon.stoparnaques.dtos;

import java.time.LocalDate;

public interface ArticleView {

    String getTitle();

    String getSubTitle();

    String getEditor();

    String getDescription();

    String getIntroduction();

    String getImageUrl();

    Long getId();

    Long getCategoryId();

    LocalDate getDate();

}
