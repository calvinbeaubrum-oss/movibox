package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Headers f49311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedSource f49312b;

    public i(Headers headers, BufferedSource bufferedSource) {
        this.f49311a = headers;
        this.f49312b = bufferedSource;
    }

    @Override // com.squareup.okhttp.ResponseBody
    public long contentLength() {
        return OkHeaders.c(this.f49311a);
    }

    @Override // com.squareup.okhttp.ResponseBody
    public MediaType contentType() {
        String str = this.f49311a.get(HttpHeaders.CONTENT_TYPE);
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.squareup.okhttp.ResponseBody
    public BufferedSource source() {
        return this.f49312b;
    }
}
