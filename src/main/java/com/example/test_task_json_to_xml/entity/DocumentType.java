package com.example.test_task_json_to_xml.entity;

import lombok.Getter;

@Getter
public enum DocumentType {
    PASSPORT,
    INTERNATIONAL_PASSPORT,
    DRIVER;

    DocumentType() {
    }
}
