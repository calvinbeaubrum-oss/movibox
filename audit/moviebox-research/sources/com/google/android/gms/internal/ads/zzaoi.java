package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoi {
    public final int zza;

    @Nullable
    public final String zzb;
    public final List zzc;
    public final byte[] zzd;

    public zzaoi(int i11, @Nullable String str, @Nullable List list, byte[] bArr) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzd = bArr;
    }
}
