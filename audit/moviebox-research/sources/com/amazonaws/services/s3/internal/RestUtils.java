package com.amazonaws.services.s3.internal;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.Request;
import com.amazonaws.util.StringUtils;
import com.cloud.config.utils.ConstantsKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RestUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f15970a = Arrays.asList(RequestParameters.SUBRESOURCE_ACL, "torrent", RequestParameters.SUBRESOURCE_LOGGING, RequestParameters.SUBRESOURCE_LOCATION, "policy", "requestPayment", "versioning", "versions", "versionId", "notification", RequestParameters.UPLOAD_ID, RequestParameters.SUBRESOURCE_UPLOADS, RequestParameters.PART_NUMBER, RequestParameters.SUBRESOURCE_WEBSITE, RequestParameters.SUBRESOURCE_DELETE, RequestParameters.SUBRESOURCE_LIFECYCLE, "tagging", RequestParameters.SUBRESOURCE_CORS, RequestParameters.X_OSS_RESTORE, "replication", "accelerate", "inventory", "analytics", "metrics", RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES);

    public static <T> String a(String str, String str2, Request<T> request, String str3, Collection<String> collection) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str + "\n");
        Map<String, String> headers = request.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null) {
                    String strB = StringUtils.b(key);
                    if ("content-type".equals(strB) || ConstantsKt.CONTENT_MD5.equals(strB) || "date".equals(strB) || strB.startsWith("x-amz-")) {
                        treeMap.put(strB, value);
                    }
                }
            }
        }
        if (treeMap.containsKey("x-amz-date")) {
            treeMap.put("date", "");
        }
        if (str3 != null) {
            treeMap.put("date", str3);
        }
        if (!treeMap.containsKey("content-type")) {
            treeMap.put("content-type", "");
        }
        if (!treeMap.containsKey(ConstantsKt.CONTENT_MD5)) {
            treeMap.put(ConstantsKt.CONTENT_MD5, "");
        }
        for (Map.Entry<String, String> entry2 : request.getParameters().entrySet()) {
            if (entry2.getKey().startsWith("x-amz-")) {
                treeMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            String str4 = (String) entry3.getKey();
            String str5 = (String) entry3.getValue();
            if (str4.startsWith("x-amz-")) {
                sb2.append(str4);
                sb2.append(':');
                if (str5 != null) {
                    sb2.append(str5);
                }
            } else if (str5 != null) {
                sb2.append(str5);
            }
            sb2.append("\n");
        }
        sb2.append(str2);
        String[] strArr = (String[]) request.getParameters().keySet().toArray(new String[request.getParameters().size()]);
        Arrays.sort(strArr);
        char c11 = '?';
        for (String str6 : strArr) {
            if (f15970a.contains(str6) || (collection != null && collection.contains(str6))) {
                if (sb2.length() == 0) {
                    sb2.append(c11);
                }
                sb2.append(str6);
                String str7 = request.getParameters().get(str6);
                if (str7 != null) {
                    sb2.append("=");
                    sb2.append(str7);
                }
                c11 = '&';
            }
        }
        return sb2.toString();
    }
}
