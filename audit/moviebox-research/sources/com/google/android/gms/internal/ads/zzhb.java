package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhb {
    public static final /* synthetic */ int zzj = 0;
    public final Uri zza;
    public final int zzb;

    @Nullable
    public final byte[] zzc;
    public final Map zzd;

    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;

    @Nullable
    public final String zzh;
    public final int zzi;

    static {
        zzbq.zzb("media3.datasource");
    }

    public zzhb(Uri uri) {
        this(uri, 0L, 1, null, Collections.emptyMap(), 0L, -1L, null, 0, null);
    }

    private zzhb(Uri uri, long j11, int i11, @Nullable byte[] bArr, Map map, long j12, long j13, @Nullable String str, int i12, @Nullable Object obj) {
        long j14 = j11 + j12;
        boolean z11 = false;
        zzek.zzd(j14 >= 0);
        zzek.zzd(j12 >= 0);
        if (j13 > 0) {
            z11 = true;
        } else if (j13 == -1) {
            j13 = -1;
            z11 = true;
        }
        zzek.zzd(z11);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j12;
        this.zze = j14;
        this.zzg = j13;
        this.zzh = null;
        this.zzi = i12;
    }

    @Deprecated
    public zzhb(Uri uri, @Nullable byte[] bArr, long j11, long j12, long j13, @Nullable String str, int i11) {
        this(uri, j11 - j12, 1, null, Collections.emptyMap(), j12, j13, null, i11, null);
    }

    public final String toString() {
        return "DataSpec[GET " + String.valueOf(this.zza) + ", " + this.zzf + ", " + this.zzg + ", null, " + this.zzi + "]";
    }

    public final boolean zza(int i11) {
        return (this.zzi & i11) == i11;
    }
}
