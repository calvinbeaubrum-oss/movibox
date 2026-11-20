package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbww {
    public static final String zza(byte[] bArr) {
        Intrinsics.g(bArr, "<this>");
        return new String(bArr, Charsets.f69091b);
    }

    public static final byte[] zzb(String str) {
        Intrinsics.g(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f69091b);
        Intrinsics.f(bytes, "getBytes(...)");
        return bytes;
    }
}
