package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfwp implements zzfxf {
    public static zzfwp zzc(char c11) {
        return new zzfwm(c11);
    }

    @Override // com.google.android.gms.internal.ads.zzfxf
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c11);
}
