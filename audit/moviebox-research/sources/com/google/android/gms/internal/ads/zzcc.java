package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzcc extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzcc(@Nullable String str, @Nullable Throwable th2, boolean z11, int i11) {
        super(str, th2);
        this.zza = z11;
        this.zzb = i11;
    }

    public static zzcc zza(@Nullable String str, @Nullable Throwable th2) {
        return new zzcc(str, th2, true, 1);
    }

    public static zzcc zzb(@Nullable String str, @Nullable Throwable th2) {
        return new zzcc(str, th2, true, 0);
    }

    public static zzcc zzc(@Nullable String str) {
        return new zzcc(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    @Nullable
    public final String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.zza + ", dataType=" + this.zzb + "}";
    }
}
