package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyh {
    public final zzcz zza;
    public final int[] zzb;

    public zzyh(zzcz zzczVar, int[] iArr, int i11) {
        if (iArr.length == 0) {
            zzff.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzczVar;
        this.zzb = iArr;
    }
}
