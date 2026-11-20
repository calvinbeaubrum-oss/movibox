package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzapi;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzceu;
import com.google.common.util.concurrent.s;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbq {
    private static zzaqd zzb;
    private static final Object zzc = new Object();

    @Deprecated
    public static final zzbl zza = new zzbi();

    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:17:0x003b, B:16:0x0036, B:18:0x003d), top: B:22:0x0010 }] */
    public zzbq(Context context) {
        zzaqd zzaqdVarZza;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            try {
                if (zzb == null) {
                    zzbgc.zza(context);
                    if (ClientLibraryUtils.isPackageSide()) {
                        zzaqdVarZza = zzarg.zza(context, null);
                    } else {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzer)).booleanValue()) {
                            zzaqdVarZza = zzaz.zzb(context);
                        } else {
                            zzaqdVarZza = zzarg.zza(context, null);
                        }
                    }
                    zzb = zzaqdVarZza;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final s zza(String str) {
        zzceu zzceuVar = new zzceu();
        zzb.zza(new zzbp(str, null, zzceuVar));
        return zzceuVar;
    }

    public final s zzb(int i11, String str, @Nullable Map map, @Nullable byte[] bArr) {
        zzbn zzbnVar = new zzbn(null);
        zzbj zzbjVar = new zzbj(this, str, zzbnVar);
        zzceb zzcebVar = new zzceb(null);
        zzbk zzbkVar = new zzbk(this, i11, str, zzbnVar, zzbjVar, bArr, map, zzcebVar);
        if (zzceb.zzk()) {
            try {
                zzcebVar.zzd(str, "GET", zzbkVar.zzl(), zzbkVar.zzx());
            } catch (zzapi e11) {
                zzcec.zzj(e11.getMessage());
            }
        }
        zzb.zza(zzbkVar);
        return zzbnVar;
    }
}
