package com.google.android.libraries.places.internal;

import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SourceDebugExtension
public final class zzbwe {
    private zzbwe() {
        throw null;
    }

    public /* synthetic */ zzbwe(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @JvmStatic
    public static final zzbwf zza(String str) {
        Intrinsics.g(str, "<this>");
        zzbwf zzbwfVar = new zzbwf(zzbww.zzb(str));
        zzbwfVar.zzi(str);
        return zzbwfVar;
    }

    @JvmStatic
    public static final zzbwf zzb(byte... data) {
        Intrinsics.g(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.f(bArrCopyOf, "copyOf(...)");
        return new zzbwf(bArrCopyOf);
    }
}
