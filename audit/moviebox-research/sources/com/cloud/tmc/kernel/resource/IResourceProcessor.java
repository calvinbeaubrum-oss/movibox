package com.cloud.tmc.kernel.resource;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.cloud.tmc.kernel.node.Node;
import java.io.File;
import java.util.List;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.resource.BaseResourceProcessor")
public interface IResourceProcessor {
    List<String> fuzzySearch(String str, String str2);

    WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node);

    WebResourceResponse get(WebResourceRequest webResourceRequest, String str, String str2, Node node);

    File get(String str, String str2);

    File get(String str, String str2, String str3);

    boolean shouldIntercept(WebResourceRequest webResourceRequest, String str);

    boolean shouldIntercept(String str, String str2);

    boolean shouldInterceptFuzzySearch(String str);
}
