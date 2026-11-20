package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f20336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f20339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f20340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f20341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f20342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f20343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f20344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f20345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f20346k;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f20347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f20348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f20350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f20351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f20352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f20353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f20354h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20355i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f20356j;

        public b() {
            this.f20349c = 1;
            this.f20351e = Collections.emptyMap();
            this.f20353g = -1L;
        }

        private b(l5 l5Var) {
            this.f20347a = l5Var.f20336a;
            this.f20348b = l5Var.f20337b;
            this.f20349c = l5Var.f20338c;
            this.f20350d = l5Var.f20339d;
            this.f20351e = l5Var.f20340e;
            this.f20352f = l5Var.f20342g;
            this.f20353g = l5Var.f20343h;
            this.f20354h = l5Var.f20344i;
            this.f20355i = l5Var.f20345j;
            this.f20356j = l5Var.f20346k;
        }

        public b a(int i11) {
            this.f20355i = i11;
            return this;
        }

        public b a(long j11) {
            this.f20352f = j11;
            return this;
        }

        public b a(Uri uri) {
            this.f20347a = uri;
            return this;
        }

        public b a(String str) {
            this.f20354h = str;
            return this;
        }

        public b a(Map map) {
            this.f20351e = map;
            return this;
        }

        public b a(byte[] bArr) {
            this.f20350d = bArr;
            return this;
        }

        public l5 a() {
            b1.a(this.f20347a, "The uri must be set.");
            return new l5(this.f20347a, this.f20348b, this.f20349c, this.f20350d, this.f20351e, this.f20352f, this.f20353g, this.f20354h, this.f20355i, this.f20356j);
        }

        public b b(int i11) {
            this.f20349c = i11;
            return this;
        }

        public b b(String str) {
            this.f20347a = Uri.parse(str);
            return this;
        }
    }

    private l5(Uri uri, long j11, int i11, byte[] bArr, Map map, long j12, long j13, String str, int i12, Object obj) {
        byte[] bArr2 = bArr;
        long j14 = j11 + j12;
        boolean z11 = true;
        b1.a(j14 >= 0);
        b1.a(j12 >= 0);
        if (j13 <= 0 && j13 != -1) {
            z11 = false;
        }
        b1.a(z11);
        this.f20336a = uri;
        this.f20337b = j11;
        this.f20338c = i11;
        this.f20339d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f20340e = Collections.unmodifiableMap(new HashMap(map));
        this.f20342g = j12;
        this.f20341f = j14;
        this.f20343h = j13;
        this.f20344i = str;
        this.f20345j = i12;
        this.f20346k = obj;
    }

    public static String a(int i11) {
        if (i11 == 1) {
            return "GET";
        }
        if (i11 == 2) {
            return "POST";
        }
        if (i11 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return a(this.f20338c);
    }

    public boolean b(int i11) {
        return (this.f20345j & i11) == i11;
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f20336a + ", " + this.f20342g + ", " + this.f20343h + ", " + this.f20344i + ", " + this.f20345j + "]";
    }
}
