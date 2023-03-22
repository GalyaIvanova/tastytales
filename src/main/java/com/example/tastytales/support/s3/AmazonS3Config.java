package com.example.tastytales.support.s3;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.eclipse.jgit.transport.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.server.support.AwsCodeCommitCredentialProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {
    //TODO

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.bucketName}")
    private String bucketName;
    // TODO - does not exist yet
//    @Bean
//    public AmazonS3 amazonS3Client() {
//
//
//         BasicAWSCredentials awsCreds=new BasicAWSCredentials(accessKey, secretKey);
//         AmazonS3 s3Client=(AmazonS3) AmazonS3ClientBuilder.standard()
//                 .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                 .withRegion(region)
//                 .build();
//
//         return s3Client;
//    }

    @Bean
    public String s3BucketName() {
        return bucketName;
    }
}

