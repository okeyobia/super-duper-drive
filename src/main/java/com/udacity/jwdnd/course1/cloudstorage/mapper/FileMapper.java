package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File findById(Integer fileId);

    @Select("SELECT * FROM FILES")
    List<File> findAll();

    @Insert("INSERT INTO FILES(filename, contenttype, filesize, userid, fileData) " +
            "values(#{filename}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    @Results({
            @Result(column="data", property="fileData", jdbcType = JdbcType.BLOB)
    })
    Integer insert(File file);

    @Insert("INSERT INTO FILES(filename, contenttype, filesize, userid, fileData)" +
            "values(#{filename}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    Integer insertFileData(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    void delete(Integer fileId);
}
