package com.squareup.okhttp.internal.framed;

import okio.ByteString;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f49144d = ByteString.encodeUtf8(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f49145e = ByteString.encodeUtf8(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f49146f = ByteString.encodeUtf8(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f49147g = ByteString.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f49148h = ByteString.encodeUtf8(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f49149i = ByteString.encodeUtf8(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteString f49150j = ByteString.encodeUtf8(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f49151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteString f49152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49153c;

    public b(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public b(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public b(ByteString byteString, ByteString byteString2) {
        this.f49151a = byteString;
        this.f49152b = byteString2;
        this.f49153c = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f49151a.equals(bVar.f49151a) && this.f49152b.equals(bVar.f49152b);
    }

    public int hashCode() {
        return ((527 + this.f49151a.hashCode()) * 31) + this.f49152b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f49151a.utf8(), this.f49152b.utf8());
    }
}
