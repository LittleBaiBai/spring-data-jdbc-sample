package com.sample.springdatajdbcschema;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
public class MirrorAndMirrorRequesterTest {

    @Autowired
    MirrorRepository mirrors;

    @Autowired
    MirrorRequesterRepository mirrorRequesters;

    @Test
    public void mirrorsAndMirrorRequesters() {

        Mirror mirror = new Mirror();
        mirror.setMirrorName("mirror name");
        Mirror mirror2 = new Mirror();
        mirror2.setMirrorName("another mirror name");

        mirrors.save(mirror);
        mirrors.save(mirror2);

        MirrorRequester requester = MirrorRequester.builder()
                .serviceInstanceId("randomId")
                .parameters(new ConfigServerParameters(Maps.newHashMap("git", "someValue")))
                .build();
        requester.addMirror(mirror);
        requester.addMirror(mirror2);

        mirrorRequesters.save(requester);

        mirrorRequesters.findAll();
        mirrorRequesters.findByServiceInstanceId("randomId");

        mirrorRequesters.deleteAll();

        assertThat(mirrors.count()).isEqualTo(2);
    }
}