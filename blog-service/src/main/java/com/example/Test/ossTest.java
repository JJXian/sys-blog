package com.example.Test;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

import java.io.ByteArrayInputStream;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-04
 */
public class ossTest {
    public static void main(String[] args) throws com.aliyuncs.exceptions.ClientException {
        ossTest t = new ossTest();
        t.testUpload();
    }
    public void testUpload() throws com.aliyuncs.exceptions.ClientException {
        // 填写Bucket名称，
        String bucketName = "xian-blog";
        String objectName = "hello.txt";//在oss上显示的文件名称

        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKey = "LTAI5tQ3atsyXyYHvPFE8iTp";
        String secretKey = "Fu3LpH2IjQYhQ5jFghcIIoPl8TRKry";
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKey,secretKey);
        try {
            String content = "Hello OSS";

            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        } catch (OSSException oe) {
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Error Message:" + ce.getMessage());
            System.out.println(ce);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        System.out.println("上传成功");
    }


}
