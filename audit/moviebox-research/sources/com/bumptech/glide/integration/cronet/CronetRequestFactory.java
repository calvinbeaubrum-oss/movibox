package com.bumptech.glide.integration.cronet;

import java.util.Map;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CronetRequestFactory {
    UrlRequest.Builder newRequest(String str, int i11, Map<String, String> map, UrlRequest.Callback callback);
}
