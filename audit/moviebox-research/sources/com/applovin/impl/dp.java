package com.applovin.impl;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface dp {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f18485c;

        public a(String str, int i11, byte[] bArr) {
            this.f18483a = str;
            this.f18484b = i11;
            this.f18485c = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f18488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f18489d;

        public b(int i11, String str, List list, byte[] bArr) {
            this.f18486a = i11;
            this.f18487b = str;
            this.f18488c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f18489d = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        SparseArray a();

        dp a(int i11, b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f18492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f18493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f18494e;

        public d(int i11, int i12) {
            this(Integer.MIN_VALUE, i11, i12);
        }

        public d(int i11, int i12, int i13) {
            String str;
            if (i11 != Integer.MIN_VALUE) {
                str = i11 + "/";
            } else {
                str = "";
            }
            this.f18490a = str;
            this.f18491b = i12;
            this.f18492c = i13;
            this.f18493d = Integer.MIN_VALUE;
            this.f18494e = "";
        }

        private void d() {
            if (this.f18493d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i11 = this.f18493d;
            this.f18493d = i11 == Integer.MIN_VALUE ? this.f18491b : i11 + this.f18492c;
            this.f18494e = this.f18490a + this.f18493d;
        }

        public String b() {
            d();
            return this.f18494e;
        }

        public int c() {
            d();
            return this.f18493d;
        }
    }

    void a();

    void a(bh bhVar, int i11);

    void a(ho hoVar, m8 m8Var, d dVar);
}
