package com.sample.springdatajdbcschema;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@AccessType(AccessType.Type.PROPERTY)
class ConfigServerParameters {
    @Id
    private Long id;

    @Transient
    private ObjectMapper json = new ObjectMapper();
    @Transient
    private Map<String, Object> parametersMap;

    ConfigServerParameters(Map<String, Object> parametersMap) {
        this.parametersMap = parametersMap;
    }

    public ConfigServerParameters() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Map<String, Object> toMap() {
        return parametersMap;
    }

    /**
     * This property is used by spring data and must be public
     * @return parameters in json format
     */
    public String getParameters() {
        try {
            return json.writeValueAsString(parametersMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setParameters(String parameters) {
        try {
            this.parametersMap = json.readValue(parameters, new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
