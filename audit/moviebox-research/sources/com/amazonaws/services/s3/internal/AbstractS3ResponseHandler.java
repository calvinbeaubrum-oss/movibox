package com.amazonaws.services.s3.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Log f15943a = LogFactory.b(S3MetadataResponseHandler.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f15944b;

    static {
        HashSet hashSet = new HashSet();
        f15944b = hashSet;
        hashSet.add(HttpHeaders.DATE);
        hashSet.add("Server");
        hashSet.add("x-amz-request-id");
        hashSet.add("x-amz-id-2");
        hashSet.add("X-Amz-Cf-Id");
        hashSet.add("Connection");
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return false;
    }

    public AmazonWebServiceResponse<T> c(HttpResponse httpResponse) {
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        String str = httpResponse.c().get("x-amz-request-id");
        String str2 = httpResponse.c().get("x-amz-id-2");
        String str3 = httpResponse.c().get("X-Amz-Cf-Id");
        HashMap map = new HashMap();
        map.put("AWS_REQUEST_ID", str);
        map.put("HOST_ID", str2);
        map.put("CLOUD_FRONT_ID", str3);
        amazonWebServiceResponse.c(new S3ResponseMetadata(map));
        return amazonWebServiceResponse;
    }

    public void d(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Map.Entry<String, String> entry : httpResponse.c().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("x-amz-meta-")) {
                objectMetadata.addUserMetadata(key.substring(11), entry.getValue());
            } else if (f15944b.contains(key)) {
                f15943a.a(String.format("%s is ignored.", key));
            } else if (key.equalsIgnoreCase(HttpHeaders.LAST_MODIFIED)) {
                try {
                    objectMetadata.setHeader(key, ServiceUtils.e(entry.getValue()));
                } catch (Exception e11) {
                    f15943a.i("Unable to parse last modified date: " + entry.getValue(), e11);
                }
            } else if (key.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                try {
                    objectMetadata.setHeader(key, Long.valueOf(Long.parseLong(entry.getValue())));
                } catch (NumberFormatException e12) {
                    f15943a.i("Unable to parse content length: " + entry.getValue(), e12);
                }
            } else if (key.equalsIgnoreCase("ETag")) {
                objectMetadata.setHeader(key, ServiceUtils.f(entry.getValue()));
            } else if (key.equalsIgnoreCase(HttpHeaders.EXPIRES)) {
                try {
                    objectMetadata.setHttpExpiresDate(DateUtils.i(entry.getValue()));
                } catch (Exception e13) {
                    f15943a.i("Unable to parse http expiration date: " + entry.getValue(), e13);
                }
            } else if (key.equalsIgnoreCase("x-amz-expiration")) {
                new ObjectExpirationHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-restore")) {
                new ObjectRestoreHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-request-charged")) {
                new S3RequesterChargedHeaderHandler().a(objectMetadata, httpResponse);
            } else if (key.equalsIgnoreCase("x-amz-mp-parts-count")) {
                try {
                    objectMetadata.setHeader(key, Integer.valueOf(Integer.parseInt(entry.getValue())));
                } catch (NumberFormatException e14) {
                    throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e14.getMessage(), e14);
                }
            } else {
                objectMetadata.setHeader(key, entry.getValue());
            }
        }
    }
}
