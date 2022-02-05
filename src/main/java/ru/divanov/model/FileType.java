package ru.divanov.model;

public enum FileType {
    TXT("*.txt"),
    INI(".*ini");

    private final String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
