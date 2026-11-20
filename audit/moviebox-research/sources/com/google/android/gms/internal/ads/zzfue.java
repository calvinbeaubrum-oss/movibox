package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfue extends zzfuc {
    private static zzfue zzc;

    private zzfue(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfue zzj(Context context) {
        zzfue zzfueVar;
        synchronized (zzfue.class) {
            try {
                if (zzc == null) {
                    zzc = new zzfue(context);
                }
                zzfueVar = zzc;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzfueVar;
    }

    public final zzfub zzh(long j11, boolean z11) throws IOException {
        zzfub zzfubVarZzb;
        synchronized (zzfue.class) {
            zzfubVarZzb = zzb(null, null, j11, z11);
        }
        return zzfubVarZzb;
    }

    public final zzfub zzi(String str, String str2, long j11, boolean z11) throws IOException {
        zzfub zzfubVarZzb;
        synchronized (zzfue.class) {
            zzfubVarZzb = zzb(str, str2, j11, z11);
        }
        return zzfubVarZzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfue.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfue.class) {
            zzf(true);
        }
    }
}
