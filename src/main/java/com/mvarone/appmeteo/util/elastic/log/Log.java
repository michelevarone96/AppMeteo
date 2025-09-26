package com.mvarone.appmeteo.util.elastic.log;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.time.LocalDateTime;

@Document(indexName = "log")
public class Log {
    @Id
    private String id;
    private String level;
    private String message;
    private String payload_applicativo;
    private LocalDateTime timestamp;

    public Log(String id, String level, String message, String payload_applicativo, LocalDateTime timestamp) {
        this.id = id;
        this.level = level;
        this.message = message;
        this.payload_applicativo = payload_applicativo;
        this.timestamp = timestamp;
    }

    public Log(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayload_applicativo() {
        return payload_applicativo;
    }

    public void setPayload_applicativo(String payload_applicativo) {
        this.payload_applicativo = payload_applicativo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
