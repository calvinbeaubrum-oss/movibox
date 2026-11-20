package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f15732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f15733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputStream f15734e;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InputStream f15737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f15738d = new HashMap();

        public HttpResponse a() {
            return new HttpResponse(this.f15735a, this.f15736b, Collections.unmodifiableMap(this.f15738d), this.f15737c);
        }

        public Builder b(InputStream inputStream) {
            this.f15737c = inputStream;
            return this;
        }

        public Builder c(String str, String str2) {
            this.f15738d.put(str, str2);
            return this;
        }

        public Builder d(int i11) {
            this.f15736b = i11;
            return this;
        }

        public Builder e(String str) {
            this.f15735a = str;
            return this;
        }
    }

    public HttpResponse(String str, int i11, Map<String, String> map, InputStream inputStream) {
        this.f15730a = str;
        this.f15731b = i11;
        this.f15733d = map;
        this.f15732c = inputStream;
    }

    public static Builder a() {
        return new Builder();
    }

    public InputStream b() throws IOException {
        if (this.f15734e == null) {
            synchronized (this) {
                try {
                    if (this.f15732c == null || !"gzip".equals(this.f15733d.get(HttpHeaders.CONTENT_ENCODING))) {
                        this.f15734e = this.f15732c;
                    } else {
                        this.f15734e = new GZIPInputStream(this.f15732c);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f15734e;
    }

    public Map<String, String> c() {
        return this.f15733d;
    }

    public InputStream d() throws IOException {
        return this.f15732c;
    }

    public int e() {
        return this.f15731b;
    }

    public String f() {
        return this.f15730a;
    }
}
