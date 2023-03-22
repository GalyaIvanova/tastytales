package com.example.tastytales.support.s3;


import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.eclipse.jgit.transport.AmazonS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

@Service
public class AmazonS3Service {
    //TODO
//    @Autowired
//    private AmazonS3 amazonS3Client;
//
//    @Autowired
//    private  String s3BucketName;

    //    TODO - check classpath conflict between different versions of the Amazon S3 library. It's possible that
    //     the "AmazonS3Config" class is using a different version of the Amazon S3 library than the one used by
    //     the "amazonS3Service" bean.

    //    public void uploadFile(String key, File file) throws IOException {
    //        PutObjectRequest request = new PutObjectRequest(s3BucketName, key, file);
    //        amazonS3Client.beginPut(s3BucketName,key,null,null);
    //                ///putObject(request);
    //    }
    //
    //    public InputStream downloadFile(String key) throws IOException {
    //        URLConnection urlConnection=amazonS3Client.get(s3BucketName, key);
    //        S3Object object =new S3Object();
    //        object.setObjectContent(urlConnection.getInputStream());
    //        return object.getObjectContent();
    //    }
}

