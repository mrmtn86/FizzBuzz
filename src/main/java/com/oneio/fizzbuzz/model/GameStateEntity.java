package com.oneio.fizzbuzz.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GameStateEntity extends BaseEntity {

    @Column(unique = true)
    private String key;

    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public int getValueAsInt() {
        return Integer.parseInt(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(int value) {
        setValue(String.valueOf(value));
    }
}
