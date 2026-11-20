package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.s;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewf implements zzexq {
    private final Context zza;
    private final zzgey zzb;
    private final zzfhh zzc;
    private final zzcei zzd;

    public zzewf(Context context, zzgey zzgeyVar, zzfhh zzfhhVar, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = zzgeyVar;
        this.zzc = zzfhhVar;
        this.zzd = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewe
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x0047 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007d, B:18:0x008f, B:20:0x00a5, B:22:0x00ae, B:27:0x00d4, B:29:0x00ee, B:30:0x0112, B:32:0x011d, B:25:0x00c2, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0059 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007d, B:18:0x008f, B:20:0x00a5, B:22:0x00ae, B:27:0x00d4, B:29:0x00ee, B:30:0x0112, B:32:0x011d, B:25:0x00c2, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00c2 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007d, B:18:0x008f, B:20:0x00a5, B:22:0x00ae, B:27:0x00d4, B:29:0x00ee, B:30:0x0112, B:32:0x011d, B:25:0x00c2, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d4 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007d, B:18:0x008f, B:20:0x00a5, B:22:0x00ae, B:27:0x00d4, B:29:0x00ee, B:30:0x0112, B:32:0x011d, B:25:0x00c2, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ee A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007d, B:18:0x008f, B:20:0x00a5, B:22:0x00ae, B:27:0x00d4, B:29:0x00ee, B:30:0x0112, B:32:0x011d, B:25:0x00c2, B:13:0x0047), top: B:36:0x0000 }] */
    public final /* synthetic */ zzewg zzc() throws Exception {
        zzfub zzfubVar;
        boolean z11;
        boolean zZzp;
        zzfuf zzfufVarZzi;
        try {
            Context context = this.zza;
            boolean zZzb = this.zzc.zzb();
            zzfub zzfubVar2 = new zzfub();
            zzfub zzfubVar3 = new zzfub();
            boolean zZzo = true;
            if (zZzb) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcO)).booleanValue()) {
                    return new zzewg(true);
                }
            }
            if (!zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcK)).booleanValue()) {
                    zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                } else if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcM)).booleanValue()) {
                        zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                    }
                }
            } else if (zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcM)).booleanValue()) {
                    zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcV)).booleanValue()) {
                if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                    zzfuf.zzi(context).zzj();
                }
            }
            if (zZzb) {
                if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcN)).booleanValue()) {
                        zzfufVarZzi = zzfuf.zzi(context);
                        if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                            zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                            zZzo = zzfufVarZzi.zzo();
                        }
                        zZzp = zzfufVarZzi.zzp();
                        zzfubVar = zzfubVar3;
                        z11 = zZzo;
                    }
                }
                zzfubVar = zzfubVar3;
                z11 = true;
                zZzp = true;
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcL)).booleanValue()) {
                    zzfufVarZzi = zzfuf.zzi(context);
                    if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                        zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                        zZzo = zzfufVarZzi.zzo();
                    }
                    zZzp = zzfufVarZzi.zzp();
                    zzfubVar = zzfubVar3;
                    z11 = zZzo;
                } else {
                    if (zZzb) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcN)).booleanValue()) {
                            zzfufVarZzi = zzfuf.zzi(context);
                            if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                                zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                                zZzo = zzfufVarZzi.zzo();
                            }
                            zZzp = zzfufVarZzi.zzp();
                            zzfubVar = zzfubVar3;
                            z11 = zZzo;
                        }
                    }
                    zzfubVar = zzfubVar3;
                    z11 = true;
                    zZzp = true;
                }
            }
            return new zzewg(zzfubVar2, zzfubVar, z11, zZzp, zZzb);
        } catch (IOException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "PerAppIdSignal");
            return new zzewg(this.zzc.zzb());
        }
    }
}
