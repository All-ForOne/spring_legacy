package org.allforone.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "menu")
public class Menu {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String url;
    @Column(length = 10)
    private String topId;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
    @Column(length = 1)
    private String useYn;
    private Integer orders;

    protected Menu() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getTopId() {
        return topId;
    }

    public String getUseYn() {
        return useYn;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", topId='" + topId + '\'' +
                ", regDt=" + regDt +
                ", modDt=" + modDt +
                ", useYn='" + useYn + '\'' +
                ", order=" + orders +
                '}';
    }
}
