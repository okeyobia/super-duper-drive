package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public int save(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            File doc = new File(filename, file.getContentType(), String.valueOf(file.getSize()), file.getBytes());
            System.out.println(doc);
            return fileMapper.insertFileData(doc);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<File> getFiles(){
        return fileMapper.findAll();
    }
}