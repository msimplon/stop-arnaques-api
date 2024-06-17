package co.simplon.stoparnaques.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ArticleLastAdded {

    String getTitle();

    String getSubTitle();

    String getEditor();

    String getDescription();

    String getIntroduction();

    String getImageUrl();

    LocalDateTime getCreatedAt();

    Long getId();

    Long getCategoryId();

    LocalDate getDate();

}
