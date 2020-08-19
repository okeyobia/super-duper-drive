package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class File {

    private Integer fileId;
    private String filename;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private byte[] fileData;

    public File(String filename, String contentType, String fileSize, byte[] fileData) {
        this.filename = filename;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.fileData = fileData;
    }
}
