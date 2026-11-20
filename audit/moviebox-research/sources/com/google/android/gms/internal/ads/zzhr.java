package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhr extends zzhp {
    public final int zzd;

    @Nullable
    public final String zze;
    public final Map zzf;
    public final byte[] zzg;

    public zzhr(int i11, @Nullable String str, @Nullable IOException iOException, Map map, zzhb zzhbVar, byte[] bArr) {
        super("Response code: " + i11, iOException, zzhbVar, 2004, 1);
        this.zzd = i11;
        this.zze = str;
        this.zzf = map;
        this.zzg = bArr;
    }
}
