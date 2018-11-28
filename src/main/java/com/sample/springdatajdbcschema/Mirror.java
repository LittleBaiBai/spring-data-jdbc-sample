package com.sample.springdatajdbcschema;

import org.springframework.data.annotation.Id;

public class Mirror {
    @Id
    private Long id;
    private String mirrorName;

    public Long getId() {
        return id;
    }

    public String getMirrorName() {
        return mirrorName;
    }

    public void setMirrorName(String mirrorName) {
        this.mirrorName = mirrorName;
    }
}
