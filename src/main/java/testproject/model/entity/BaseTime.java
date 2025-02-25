package testproject.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public class BaseTime{
    @CreatedDate
    private LocalDateTime createdat;

    @LastModifiedDate
    private LocalDateTime udate;
}
