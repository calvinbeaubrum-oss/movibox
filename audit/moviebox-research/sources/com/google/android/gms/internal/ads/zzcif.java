package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcif extends zzchw implements zzcgb {
    public static final /* synthetic */ int zzd = 0;
    private zzcgc zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcho zzi;
    private long zzj;
    private long zzk;

    public zzcif(zzcgl zzcglVar, zzcgk zzcgkVar) {
        super(zzcglVar);
        zzcix zzcixVar = new zzcix(zzcglVar.getContext(), zzcgkVar, (zzcgl) this.zzc.get(), null);
        zzcec.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcixVar;
        zzcixVar.zzL(this);
    }

    public static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzcdv.zze(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j11) {
        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcie
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.zza.zzb();
            }
        }, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzchw, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcgc zzcgcVar = this.zze;
        if (zzcgcVar != null) {
            zzcgcVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzD(int i11, int i12) {
    }

    public final zzcgc zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcgc zzcgcVar = this.zze;
        this.zze = null;
        return zzcgcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzb() throws Throwable {
        String str;
        zzcif zzcifVar;
        zzcif zzcifVar2;
        zzcif zzcifVar3;
        long j11;
        String str2;
        zzcif zzcifVar4;
        long j12;
        String strZzc = zzc(this.zzf);
        try {
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzx)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
            try {
                synchronized (this) {
                    try {
                        if (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzj > jLongValue) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue + " ms");
                        }
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = this.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = this.zze.zzv();
                                if (jZzv != this.zzk) {
                                    try {
                                        str2 = strZzc;
                                        try {
                                            zzo(this.zzf, strZzc, jZzv, jZzz, jZzv > 0, zBooleanValue ? this.zze.zzA() : -1L, zBooleanValue ? this.zze.zzx() : -1L, zBooleanValue ? this.zze.zzB() : -1L, zzcgc.zzs(), zzcgc.zzu());
                                            zzcifVar4 = this;
                                            j11 = jZzv;
                                            try {
                                                zzcifVar4.zzk = j11;
                                                j12 = jZzz;
                                                zzcifVar4 = zzcifVar4;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                str = str2;
                                                zzcifVar = zzcifVar4;
                                                try {
                                                    throw th;
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    zzcec.zzj("Failed to preload url " + zzcifVar.zzf + " Exception: " + e.getMessage());
                                                    com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                                                    release();
                                                    zzcifVar.zzg(zzcifVar.zzf, str, "error", zzd("error", e));
                                                    zzcifVar2 = zzcifVar;
                                                    com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcifVar2.zzi);
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            zzcifVar4 = this;
                                            str = str2;
                                            zzcifVar = zzcifVar4;
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str2 = strZzc;
                                        zzcifVar4 = this;
                                    }
                                } else {
                                    j11 = jZzv;
                                    str2 = strZzc;
                                    zzcifVar4 = this;
                                    j12 = jZzz;
                                }
                                if (j11 >= j12) {
                                    zzcifVar4.zzj(zzcifVar4.zzf, str2, j12);
                                    zzcifVar2 = zzcifVar4;
                                } else if (zzcifVar4.zze.zzw() >= jIntValue && j11 > 0) {
                                    zzcifVar2 = zzcifVar4;
                                }
                            } else {
                                zzcifVar3 = this;
                            }
                            zzcifVar3.zzx(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue());
                            return;
                        }
                        zzcifVar2 = this;
                        com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcifVar2.zzi);
                    } catch (Throwable th5) {
                        th = th5;
                        str = strZzc;
                        zzcifVar = this;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zzcifVar = zBooleanValue;
            }
        } catch (Exception e12) {
            e = e12;
            str = strZzc;
            zzcifVar = this;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzi(final boolean z11, final long j11) {
        final zzcgl zzcglVar = (zzcgl) this.zzc.get();
        if (zzcglVar != null) {
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
                @Override // java.lang.Runnable
                public final void run() {
                    zzcglVar.zzv(z11, j11);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk(String str, Exception exc) {
        zzcec.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl(String str, Exception exc) {
        zzcec.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm(int i11) {
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzp(int i11) {
        this.zze.zzJ(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzq(int i11) {
        this.zze.zzK(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzr(int i11) {
        this.zze.zzM(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzs(int i11) {
        this.zze.zzN(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzcgl] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzchw, com.google.android.gms.internal.ads.zzcif] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcif] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzchw] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12, types: [int] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzu(String str, String[] strArr) throws Throwable {
        ?? r11;
        String str2;
        ?? r12;
        long j11;
        ?? r13;
        ?? r14;
        String str3;
        long j12;
        ?? r15 = this;
        ?? r16 = str;
        r15.zzf = r16;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                uriArr[i11] = Uri.parse(strArr[i11]);
            }
            r15.zze.zzF(uriArr, r15.zzb);
            ?? r17 = (zzcgl) r15.zzc.get();
            if (r17 != 0) {
                r17.zzt(strZzc, r15);
            }
            Clock clockZzB = com.google.android.gms.ads.internal.zzt.zzB();
            long jCurrentTimeMillis = clockZzB.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzx)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue();
            long j13 = -1;
            long j14 = jIntValue;
            r16 = r16;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzB.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (r15.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!r15.zzh) {
                            if (!r15.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = r15.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = r15.zze.zzv();
                                if (jZzv != j13) {
                                    try {
                                        long j15 = jZzz;
                                        str3 = strZzc;
                                        try {
                                            zzo(str, strZzc, jZzv, j15, jZzv > 0, zBooleanValue ? r15.zze.zzA() : -1L, zBooleanValue ? r15.zze.zzx() : -1L, zBooleanValue ? r15.zze.zzB() : -1L, zzcgc.zzs(), zzcgc.zzu());
                                            j13 = jZzv;
                                            j12 = jZzz;
                                            r13 = j15;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r12 = this;
                                            r11 = str;
                                            str2 = str3;
                                            try {
                                                throw th;
                                            } catch (Exception e11) {
                                                e = e11;
                                                zzcec.zzj("Failed to preload url " + r11 + " Exception: " + e.getMessage());
                                                com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                                                release();
                                                r12.zzg(r11, str2, "error", zzd("error", e));
                                                return false;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str3 = strZzc;
                                    }
                                } else {
                                    str3 = strZzc;
                                    j12 = jZzz;
                                    r13 = j14;
                                }
                                r14 = (jZzv > j12 ? 1 : (jZzv == j12 ? 0 : -1));
                                if (r14 >= 0) {
                                    zzj(str, str3, j12);
                                } else {
                                    try {
                                        zzcif zzcifVar = this;
                                        r13 = str;
                                        str2 = str3;
                                        if (zzcifVar.zze.zzw() < j14 || jZzv <= 0) {
                                            r14 = zzcifVar;
                                            j11 = j14;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        r12 = r14;
                                        r11 = r13;
                                        throw th;
                                    }
                                }
                            } else {
                                j11 = j14;
                                jLongValue2 = jLongValue2;
                                r13 = r16;
                                str2 = strZzc;
                                r14 = r15;
                            }
                            try {
                                r14.wait(jLongValue);
                            } catch (InterruptedException unused) {
                                throw new IOException("Wait interrupted.");
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        r11 = r16;
                        str2 = strZzc;
                        r12 = r15;
                    }
                }
                return true;
                jLongValue = jLongValue;
                r15 = r14;
                r16 = r13;
                strZzc = str2;
                j14 = j11;
                jLongValue2 = jLongValue2;
            }
        } catch (Exception e12) {
            e = e12;
            r11 = r16;
            str2 = strZzc;
            r12 = r15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzv() {
        zzcec.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzw(String str, String[] strArr, zzcho zzchoVar) {
        this.zzf = str;
        this.zzi = zzchoVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                uriArr[i11] = Uri.parse(strArr[i11]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcgl zzcglVar = (zzcgl) this.zzc.get();
            if (zzcglVar != null) {
                zzcglVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e11) {
            zzcec.zzj("Failed to preload url " + str + " Exception: " + e11.getMessage());
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e11, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e11));
            return false;
        }
    }
}
