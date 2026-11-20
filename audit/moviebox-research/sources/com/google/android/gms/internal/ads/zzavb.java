package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavb implements zzave {

    @Nullable
    private static zzavb zzb;
    private final Context zzc;
    private final zzfsg zzd;
    private final zzfsn zze;
    private final zzfsp zzf;
    private final zzawd zzg;
    private final zzfqr zzh;
    private final Executor zzi;
    private final zzfsm zzj;
    private final zzaws zzl;

    @Nullable
    private final zzawk zzm;

    @Nullable
    private final zzawb zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    public zzavb(@NonNull Context context, @NonNull zzfqr zzfqrVar, @NonNull zzfsg zzfsgVar, @NonNull zzfsn zzfsnVar, @NonNull zzfsp zzfspVar, @NonNull zzawd zzawdVar, @NonNull Executor executor, @NonNull zzfqm zzfqmVar, int i11, @Nullable zzaws zzawsVar, @Nullable zzawk zzawkVar, @Nullable zzawb zzawbVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfqrVar;
        this.zzd = zzfsgVar;
        this.zze = zzfsnVar;
        this.zzf = zzfspVar;
        this.zzg = zzawdVar;
        this.zzi = executor;
        this.zzr = i11;
        this.zzl = zzawsVar;
        this.zzm = zzawkVar;
        this.zzn = zzawbVar;
        this.zzq = false;
        this.zzj = new zzauz(this, zzfqmVar);
    }

    public static synchronized zzavb zza(@NonNull String str, @NonNull Context context, boolean z11, boolean z12) {
        return zzb(str, context, Executors.newCachedThreadPool(), z11, z12);
    }

    @Deprecated
    public static synchronized zzavb zzb(@NonNull String str, @NonNull Context context, @NonNull Executor executor, boolean z11, boolean z12) {
        try {
            if (zzb == null) {
                zzfqs zzfqsVarZza = zzfqt.zza();
                zzfqsVarZza.zza(str);
                zzfqsVarZza.zzc(z11);
                zzfqt zzfqtVarZzd = zzfqsVarZza.zzd();
                zzfqr zzfqrVarZza = zzfqr.zza(context, executor, z12);
                zzavm zzavmVarZzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdi)).booleanValue() ? zzavm.zzc(context) : null;
                zzaws zzawsVarZzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdj)).booleanValue() ? zzaws.zzd(context, executor) : null;
                zzawk zzawkVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue() ? new zzawk() : null;
                zzawb zzawbVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue() ? new zzawb() : null;
                zzfrk zzfrkVarZze = zzfrk.zze(context, executor, zzfqrVarZza, zzfqtVarZzd);
                zzawc zzawcVar = new zzawc(context);
                zzawd zzawdVar = new zzawd(zzfqtVarZzd, zzfrkVarZze, new zzawq(context, zzawcVar), zzawcVar, zzavmVarZzc, zzawsVarZzd, zzawkVar, zzawbVar);
                int iZzb = zzfrt.zzb(context, zzfqrVarZza);
                zzfqm zzfqmVar = new zzfqm();
                zzavb zzavbVar = new zzavb(context, zzfqrVarZza, new zzfsg(context, iZzb), new zzfsn(context, iZzb, new zzauy(zzfqrVarZza), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcg)).booleanValue()), new zzfsp(context, zzawdVar, zzfqrVarZza, zzfqmVar), zzawdVar, executor, zzfqmVar, iZzb, zzawsVarZzd, zzawkVar, zzawbVar);
                zzb = zzavbVar;
                zzavbVar.zzm();
                zzb.zzp();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzb;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d5 A[Catch: all -> 0x009d, zzhag -> 0x00a0, TryCatch #2 {zzhag -> 0x00a0, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:32:0x00a3, B:36:0x00bc, B:42:0x00d5, B:43:0x00e2, B:45:0x00e8, B:47:0x00f0, B:48:0x00f2, B:39:0x00c6, B:40:0x00cd, B:23:0x0074, B:25:0x008a, B:49:0x00fc, B:50:0x0109, B:51:0x0116), top: B:60:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00fc A[Catch: all -> 0x009d, zzhag -> 0x00a0, TryCatch #2 {zzhag -> 0x00a0, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:32:0x00a3, B:36:0x00bc, B:42:0x00d5, B:43:0x00e2, B:45:0x00e8, B:47:0x00f0, B:48:0x00f2, B:39:0x00c6, B:40:0x00cd, B:23:0x0074, B:25:0x008a, B:49:0x00fc, B:50:0x0109, B:51:0x0116), top: B:60:0x0021, outer: #1 }] */
    public static /* bridge */ /* synthetic */ void zzj(zzavb zzavbVar) {
        String str;
        String strZzj;
        int length;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfsf zzfsfVarZzt = zzavbVar.zzt(1);
        if (zzfsfVarZzt != null) {
            String strZzk = zzfsfVarZzt.zza().zzk();
            strZzj = zzfsfVarZzt.zza().zzj();
            str = strZzk;
        } else {
            str = null;
            strZzj = null;
        }
        try {
            try {
                zzfsk zzfskVarZza = zzfrb.zza(zzavbVar.zzc, 1, zzavbVar.zzr, str, strZzj, "1", zzavbVar.zzh);
                byte[] bArr = zzfskVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzavbVar.zzh.zzd(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzayc zzaycVarZzc = zzayc.zzc(zzgyl.zzv(bArr, 0, length), zzgzf.zza());
                        if (zzaycVarZzc.zzd().zzk().isEmpty() || zzaycVarZzc.zzd().zzj().isEmpty() || zzaycVarZzc.zze().zzA().length == 0) {
                            zzavbVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzfsf zzfsfVarZzt2 = zzavbVar.zzt(1);
                            if (zzfsfVarZzt2 != null) {
                                zzayf zzayfVarZza = zzfsfVarZzt2.zza();
                                if (zzaycVarZzc.zzd().zzk().equals(zzayfVarZza.zzk()) && zzaycVarZzc.zzd().zzj().equals(zzayfVarZza.zzj())) {
                                    zzavbVar.zzh.zzd(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                            }
                            zzfsm zzfsmVar = zzavbVar.zzj;
                            int i11 = zzfskVarZza.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzce)).booleanValue()) {
                                zZza = zzavbVar.zzd.zza(zzaycVarZzc, zzfsmVar);
                            } else if (i11 == 3) {
                                zZza = zzavbVar.zze.zza(zzaycVarZzc);
                            } else if (i11 == 4) {
                                zZza = zzavbVar.zze.zzb(zzaycVarZzc, zzfsmVar);
                            } else {
                                zzavbVar.zzh.zzd(TaErrorCode.CODE_AD_SHOW_NOT_IN_INTERVAL, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zZza) {
                                zzfsf zzfsfVarZzt3 = zzavbVar.zzt(1);
                                if (zzfsfVarZzt3 != null) {
                                    if (zzavbVar.zzf.zzc(zzfsfVarZzt3)) {
                                        zzavbVar.zzq = true;
                                    }
                                    zzavbVar.zza = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                zzavbVar.zzh.zzd(TaErrorCode.CODE_AD_SHOW_NOT_IN_INTERVAL, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        zzavbVar.zzh.zzd(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } catch (zzhag e11) {
                zzavbVar.zzh.zzc(4002, System.currentTimeMillis() - jCurrentTimeMillis, e11);
            }
        } finally {
            zzavbVar.zzk.countDown();
        }
    }

    private final void zzs() {
        zzaws zzawsVar = this.zzl;
        if (zzawsVar != null) {
            zzawsVar.zzh();
        }
    }

    private final zzfsf zzt(int i11) {
        if (zzfrt.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzce)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zze(Context context, @Nullable String str, @Nullable View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzf(Context context, String str, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfqu zzfquVarZza = this.zzf.zza();
        if (zzfquVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfquVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfqu zzfquVarZza = this.zzf.zza();
        if (zzfquVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfquVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcx)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfqu zzfquVarZza = this.zzf.zza();
        if (zzfquVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfquVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzk(@Nullable MotionEvent motionEvent) {
        zzfqu zzfquVarZza = this.zzf.zza();
        if (zzfquVarZza != null) {
            try {
                zzfquVarZza.zzd(null, motionEvent);
            } catch (zzfso e11) {
                this.zzh.zzc(e11.zza(), -1L, e11);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzl(int i11, int i12, int i13) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlp)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f11 = i11;
        float f12 = displayMetrics.density;
        float f13 = i12;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f11 * f12, f13 * f12, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        float f14 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f11 * f14, f13 * f14, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        float f15 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i13, 1, f11 * f15, f13 * f15, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfsf zzfsfVarZzt = zzt(1);
        if (zzfsfVarZzt == null) {
            this.zzh.zzd(TaErrorCode.CODE_LOAD_FAILED_CAUSE_LOADING, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfsfVarZzt)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawb zzawbVar = this.zzn;
        if (zzawbVar != null) {
            zzawbVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzo(@Nullable View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            try {
                if (!this.zzp) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zzfsf zzfsfVarZzb = this.zzf.zzb();
                    if ((zzfsfVarZzb == null || zzfsfVarZzb.zzd(3600L)) && zzfrt.zza(this.zzr)) {
                        this.zzi.execute(new zzava(this));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
