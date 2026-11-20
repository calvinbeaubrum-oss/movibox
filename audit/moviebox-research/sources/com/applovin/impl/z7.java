package com.applovin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface z7 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f24816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f24818c;

        public a(byte[] bArr, String str, int i11) {
            this.f24816a = bArr;
            this.f24817b = str;
            this.f24818c = i11;
        }

        public byte[] a() {
            return this.f24816a;
        }

        public String b() {
            return this.f24817b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(z7 z7Var, byte[] bArr, int i11, int i12, byte[] bArr2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        z7 a(UUID uuid);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f24819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24820b;

        public d(byte[] bArr, String str) {
            this.f24819a = bArr;
            this.f24820b = str;
        }

        public byte[] a() {
            return this.f24819a;
        }

        public String b() {
            return this.f24820b;
        }
    }

    a a(byte[] bArr, List list, int i11, HashMap map);

    void a();

    void a(b bVar);

    void a(byte[] bArr);

    void a(byte[] bArr, byte[] bArr2);

    boolean a(byte[] bArr, String str);

    d b();

    Map b(byte[] bArr);

    byte[] b(byte[] bArr, byte[] bArr2);

    int c();

    void c(byte[] bArr);

    z4 d(byte[] bArr);

    byte[] d();
}
