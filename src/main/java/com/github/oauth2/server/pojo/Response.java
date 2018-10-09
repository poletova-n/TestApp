package com.github.oauth2.server.pojo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Response {

    @Column
    private String id;

    @Column
    private DateTime createTime;

    @Column
    private State state;

    public Response(String id, State state){
        this.id = id;
        this.createTime = createTime();
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime.toString();
    }

    public DateTime createTime() {
        DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis();
        String jtdate = "2010-01-01T12:00:00Z";
        return parser2.parseDateTime(jtdate);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
