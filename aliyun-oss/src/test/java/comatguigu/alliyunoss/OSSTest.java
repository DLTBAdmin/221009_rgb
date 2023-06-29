package comatguigu.alliyunoss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.AccessControlList;
import org.junit.Test;

public class OSSTest {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "oss-cn-guangzhou.aliyuncs.com/";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "LTAI5tPoFszjcAYVhNPyWEAx";
    String accessKeySecret = "motQUGGsTDJ1IbuqLw35xfsmkK1vQe";
    String bucketName = "srb-file-220914";

    @Test
    public void test(){

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testGetBucketAcl(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        AccessControlList acl = ossClient.getBucketAcl(bucketName);
        System.out.println(acl.toString());

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testDoesBucketExist(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        //判断存储空间examplebucket是否存在，如果存在返回ture
        boolean exist = ossClient.doesBucketExist(bucketName);
        System.out.println(exist);

        // 关闭OSSClient。
        ossClient.shutdown();
    }


}
