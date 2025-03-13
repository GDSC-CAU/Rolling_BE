package com.gdg.rolling.Config;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class S3Manager {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile file) throws Exception {
        try {
            String fileName = "upload/" + file.getOriginalFilename(); // ✅ S3 경로 포함
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            // ✅ S3에 파일 업로드
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);

            // ✅ 올바른 S3 URL 반환
            String fileUrl = amazonS3Client.getUrl(bucket, fileName).toString();
            return fileUrl;
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

}