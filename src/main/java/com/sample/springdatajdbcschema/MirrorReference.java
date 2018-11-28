package com.sample.springdatajdbcschema;

import org.springframework.data.relational.core.mapping.Table;

@Table("mirror_register")
public class MirrorReference {
    Long mirror;

    public MirrorReference(Long mirror) {
        this.mirror = mirror;
    }
}
