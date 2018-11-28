package com.sample.springdatajdbcschema;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class MirrorRequester {
    @Id
    private Long id;
    private String serviceInstanceId;
    private ConfigServerParameters parameters;
    private Set<MirrorReference> mirrors;

    void addMirror(Mirror mirror) {
        this.mirrors.add(new MirrorReference(mirror.getId()));
    }

    private static Set<MirrorReference> $default$mirrors() {
        return new HashSet();
    }

    MirrorRequester(final Long id, final String serviceInstanceId, final ConfigServerParameters parameters, final Set<MirrorReference> mirrors) {
        this.id = id;
        this.serviceInstanceId = serviceInstanceId;
        this.parameters = parameters;
        this.mirrors = mirrors;
    }

    public static MirrorRequester.MirrorRequesterBuilder builder() {
        return new MirrorRequester.MirrorRequesterBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getServiceInstanceId() {
        return this.serviceInstanceId;
    }

    public ConfigServerParameters getParameters() {
        return this.parameters;
    }

    public Set<MirrorReference> getMirrors() {
        return this.mirrors;
    }

    public static class MirrorRequesterBuilder {
        private Long id;
        private String serviceInstanceId;
        private ConfigServerParameters parameters;
        private boolean mirrors$set;
        private Set<MirrorReference> mirrors;

        MirrorRequesterBuilder() {
        }

        public MirrorRequester.MirrorRequesterBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MirrorRequester.MirrorRequesterBuilder serviceInstanceId(final String serviceInstanceId) {
            this.serviceInstanceId = serviceInstanceId;
            return this;
        }

        public MirrorRequester.MirrorRequesterBuilder parameters(final ConfigServerParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public MirrorRequester.MirrorRequesterBuilder mirrors(final Set<MirrorReference> mirrors) {
            this.mirrors = mirrors;
            this.mirrors$set = true;
            return this;
        }

        public MirrorRequester build() {
            Set<MirrorReference> mirrors = this.mirrors;
            if (!this.mirrors$set) {
                mirrors = MirrorRequester.$default$mirrors();
            }

            return new MirrorRequester(this.id, this.serviceInstanceId, this.parameters, mirrors);
        }

        public String toString() {
            return "MirrorRequester.MirrorRequesterBuilder(id=" + this.id + ", serviceInstanceId=" + this.serviceInstanceId + ", parameters=" + this.parameters + ", mirrors=" + this.mirrors + ")";
        }
    }
}

