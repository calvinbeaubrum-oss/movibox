package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zziz extends zzce {

    @Deprecated
    public static final zzn zzd = new zzn() { // from class: com.google.android.gms.internal.ads.zziy
    };
    private static final String zzl = Integer.toString(1001, 36);
    private static final String zzm = Integer.toString(1002, 36);
    private static final String zzn = Integer.toString(1003, 36);
    private static final String zzo = Integer.toString(1004, 36);
    private static final String zzp = Integer.toString(1005, 36);
    private static final String zzq = Integer.toString(PointerIconCompat.TYPE_CELL, 36);
    public final int zze;

    @Nullable
    public final String zzf;
    public final int zzg;

    @Nullable
    public final zzam zzh;
    public final int zzi;

    @Nullable
    public final zzur zzj;
    final boolean zzk;

    private zziz(int i11, Throwable th2, int i12) {
        this(i11, th2, null, i12, null, -1, null, 4, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zziz(int i11, @Nullable Throwable th2, @Nullable String str, int i12, @Nullable String str2, int i13, @Nullable zzam zzamVar, int i14, boolean z11) {
        String str3;
        String str4;
        if (i11 == 0) {
            str3 = "Source error";
        } else if (i11 != 1) {
            str3 = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzamVar);
            int i15 = zzfy.zza;
            if (i14 == 0) {
                str4 = "NO";
            } else if (i14 == 1) {
                str4 = "NO_UNSUPPORTED_TYPE";
            } else if (i14 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i14 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i14 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            str3 = str2 + " error, index=" + i13 + ", format=" + strValueOf + ", format_supported=" + str4;
        }
        this(TextUtils.isEmpty(null) ? str3 : str3.concat(": null"), th2, i12, i11, str2, i13, zzamVar, i14, null, SystemClock.elapsedRealtime(), z11);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    private zziz(String str, @Nullable Throwable th2, int i11, int i12, @Nullable String str2, int i13, @Nullable zzam zzamVar, int i14, @Nullable zzur zzurVar, long j11, boolean z11) {
        int i15;
        boolean z12;
        super(str, th2, i11, j11);
        if (z11) {
            i15 = i12;
            if (i15 == 1) {
                i15 = 1;
            } else {
                z12 = false;
            }
            zzek.zzd(z12);
            zzek.zzd(th2 != null);
            this.zze = i15;
            this.zzf = str2;
            this.zzg = i13;
            this.zzh = zzamVar;
            this.zzi = i14;
            this.zzj = zzurVar;
            this.zzk = z11;
        }
        i15 = i12;
        z12 = true;
        zzek.zzd(z12);
        zzek.zzd(th2 != null);
        this.zze = i15;
        this.zzf = str2;
        this.zzg = i13;
        this.zzh = zzamVar;
        this.zzi = i14;
        this.zzj = zzurVar;
        this.zzk = z11;
    }

    public static zziz zzb(Throwable th2, String str, int i11, @Nullable zzam zzamVar, int i12, boolean z11, int i13) {
        return new zziz(1, th2, null, i13, str, i11, zzamVar, zzamVar == null ? 4 : i12, z11);
    }

    public static zziz zzc(IOException iOException, int i11) {
        return new zziz(0, iOException, i11);
    }

    public static zziz zzd(RuntimeException runtimeException, int i11) {
        return new zziz(2, runtimeException, i11);
    }

    @CheckResult
    public final zziz zza(@Nullable zzur zzurVar) {
        String message = getMessage();
        int i11 = zzfy.zza;
        return new zziz(message, getCause(), this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, zzurVar, this.zzc, this.zzk);
    }
}
