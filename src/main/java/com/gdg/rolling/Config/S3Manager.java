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
            // 원본 파일명에서 확장자 제거 후 .mp4 추가
            String originalFileName = file.getOriginalFilename();
            String baseName = originalFileName != null ? originalFileName.substring(0, originalFileName.lastIndexOf(".")) : "video";
            String fileName = "upload/" + baseName + ".mp4"; // ✅ 확장자를 무조건 .mp4로 변경

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("video/mp4"); // ✅ contentType도 video/mp4로 설정
            metadata.setContentLength(file.getSize());

            // ✅ S3에 파일 업로드
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);

            // ✅ 올바른 S3 URL 반환
            return amazonS3Client.getUrl(bucket, fileName).toString();
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

}

