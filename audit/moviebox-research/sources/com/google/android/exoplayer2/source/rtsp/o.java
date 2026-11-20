package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f34566b = new b().e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableListMultimap<String, String> f34567a;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableListMultimap.a<String, String> f34568a;

        public b() {
            this.f34568a = new ImmutableListMultimap.a<>();
        }

        public b(String str, @Nullable String str2, int i11) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i11));
            if (str2 != null) {
                b("Session", str2);
            }
        }

        public b b(String str, String str2) {
            this.f34568a.c(o.c(str.trim()), str2.trim());
            return this;
        }

        public b c(List<String> list) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                String[] strArrU0 = o0.U0(list.get(i11), ":\\s?");
                if (strArrU0.length == 2) {
                    b(strArrU0[0], strArrU0[1]);
                }
            }
            return this;
        }

        public b d(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public o e() {
            return new o(this);
        }
    }

    public o(b bVar) {
        this.f34567a = bVar.f34568a.f();
    }

    public static String c(String str) {
        if (com.google.common.base.a.a(str, "Accept")) {
            return "Accept";
        }
        if (com.google.common.base.a.a(str, "Allow")) {
            return "Allow";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.AUTHORIZATION)) {
            return HttpHeaders.AUTHORIZATION;
        }
        if (com.google.common.base.a.a(str, "Bandwidth")) {
            return "Bandwidth";
        }
        if (com.google.common.base.a.a(str, "Blocksize")) {
            return "Blocksize";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.CACHE_CONTROL)) {
            return HttpHeaders.CACHE_CONTROL;
        }
        if (com.google.common.base.a.a(str, "Connection")) {
            return "Connection";
        }
        if (com.google.common.base.a.a(str, "Content-Base")) {
            return "Content-Base";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.CONTENT_ENCODING)) {
            return HttpHeaders.CONTENT_ENCODING;
        }
        if (com.google.common.base.a.a(str, "Content-Language")) {
            return "Content-Language";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.CONTENT_LENGTH)) {
            return HttpHeaders.CONTENT_LENGTH;
        }
        if (com.google.common.base.a.a(str, "Content-Location")) {
            return "Content-Location";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.CONTENT_TYPE)) {
            return HttpHeaders.CONTENT_TYPE;
        }
        if (com.google.common.base.a.a(str, "CSeq")) {
            return "CSeq";
        }
        if (com.google.common.base.a.a(str, HttpHeaders.DATE)) {
            return HttpHeaders.DATE;
        }
        if (com.google.common.base.a.a(str, HttpHeaders.EXPIRES)) {
            return HttpHeaders.EXPIRES;
        }
        if (com.google.common.base.a.a(str, HttpHeaders.LOCATION)) {
            return HttpHeaders.LOCATION;
        }
        if (com.google.common.base.a.a(str, "Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (com.google.common.base.a.a(str, "Proxy-Require")) {
            return "Proxy-Require";
        }
        if (com.google.common.base.a.a(str, "Public")) {
            return "Public";
        }
        if (com.google.common.base.a.a(str, "Range")) {
            return "Range";
        }
        if (com.google.common.base.a.a(str, "RTP-Info")) {
            return "RTP-Info";
        }
        if (com.google.common.base.a.a(str, "RTCP-Interval")) {
            return "RTCP-Interval";
        }
        if (com.google.common.base.a.a(str, "Scale")) {
            return "Scale";
        }
        if (com.google.common.base.a.a(str, "Session")) {
            return "Session";
        }
        if (com.google.common.base.a.a(str, "Speed")) {
            return "Speed";
        }
        if (com.google.common.base.a.a(str, "Supported")) {
            return "Supported";
        }
        if (com.google.common.base.a.a(str, "Timestamp")) {
            return "Timestamp";
        }
        if (com.google.common.base.a.a(str, "Transport")) {
            return "Transport";
        }
        if (com.google.common.base.a.a(str, "User-Agent")) {
            return "User-Agent";
        }
        if (com.google.common.base.a.a(str, "Via")) {
            return "Via";
        }
        return com.google.common.base.a.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public ImmutableListMultimap<String, String> b() {
        return this.f34567a;
    }

    @Nullable
    public String d(String str) {
        ImmutableList<String> immutableListE = e(str);
        if (immutableListE.isEmpty()) {
            return null;
        }
        return (String) com.google.common.collect.e0.g(immutableListE);
    }

    public ImmutableList<String> e(String str) {
        return this.f34567a.get(c(str));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return this.f34567a.equals(((o) obj).f34567a);
        }
        return false;
    }

    public int hashCode() {
        return this.f34567a.hashCode();
    }
}
