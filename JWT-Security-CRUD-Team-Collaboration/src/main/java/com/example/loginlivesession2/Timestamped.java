package com.sparta.jwtsession;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {
    @Column(nullable = false)
    @CreatedDate
    public LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    public LocalDateTime modifiedAt;
}
