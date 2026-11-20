package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class S3ClientReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Integer, AmazonS3> f15786a = new ConcurrentHashMap();

    public static AmazonS3 a(Integer num) {
        return f15786a.get(num);
    }

    public static void b(Integer num, AmazonS3 amazonS3) {
        f15786a.put(num, amazonS3);
    }

    public static void c(Integer num) {
        f15786a.remove(num);
    }
}
