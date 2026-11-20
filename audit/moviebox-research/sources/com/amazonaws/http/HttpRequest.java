package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public URI f15726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f15727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputStream f15728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15729e;

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        this.f15725a = StringUtils.c(str);
        this.f15726b = uri;
        this.f15727c = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.f15728d = inputStream;
    }

    public InputStream a() {
        return this.f15728d;
    }

    public long b() {
        String str;
        Map<String, String> map = this.f15727c;
        if (map == null || (str = map.get(HttpHeaders.CONTENT_LENGTH)) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map<String, String> c() {
        return this.f15727c;
    }

    public String d() {
        return this.f15725a;
    }

    public URI e() {
        return this.f15726b;
    }

    public boolean f() {
        return this.f15729e;
    }

    public void g(boolean z11) {
        this.f15729e = z11;
    }
}
