package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzgx extends IOException {
    public final int zza;

    public zzgx(int i11) {
        this.zza = i11;
    }

    public zzgx(@Nullable String str, int i11) {
        super(str);
        this.zza = i11;
    }

    public zzgx(@Nullable String str, @Nullable Throwable th2, int i11) {
        super(str, th2);
        this.zza = i11;
    }

    public zzgx(@Nullable Throwable th2, int i11) {
        super(th2);
        this.zza = i11;
    }
}
