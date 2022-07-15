package com.example.testtaskjsontoxml.entity;

import lombok.Getter;

@Getter
public enum DocumentType {
    PASSPORT,
    INTERNATIONAL_PASSPORT,
    DRIVER;

    DocumentType() {
    }
}
