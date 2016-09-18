package com.intertec.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "RESTRICTED_WORDS")
@NamedQuery(name = "RestrictedWord.findAll", query = "SELECT r FROM RestrictedWord r")
public class RestrictedWord implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int restrictedWordId;
    
    @Column(name = "WORD")
    private String restrictedWordWord;
    
    @Column(name = "ACTIVE")
    private Boolean restrictedWordActive;

    public RestrictedWord() {
    }

    public RestrictedWord(String restrictedWordWord) {
        this.restrictedWordWord = restrictedWordWord;
        this.restrictedWordActive = true;
    }

    public RestrictedWord(int id, String word, Boolean active) {
        this.restrictedWordId = id;
        this.restrictedWordWord = word;
        this.restrictedWordActive = active;
    }

    public Boolean getRestrictedWordActive() {
        return restrictedWordActive;
    }

    public void setRestrictedWordActive(Boolean active) {
        this.restrictedWordActive = active;
    }

    public int getRestrictedWordId() {
        return restrictedWordId;
    }

    public void setRestrictedWordId(int id) {
        this.restrictedWordId = id;
    }

    public String getRestrictedWordWord() {
        return restrictedWordWord;
    }

    public void setRestrictedWordWord(String word) {
        this.restrictedWordWord = word;
    }
    
}
