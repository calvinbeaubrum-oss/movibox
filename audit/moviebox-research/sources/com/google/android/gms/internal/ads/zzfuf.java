package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfuf extends zzfuc {
    private static zzfuf zzc;

    private zzfuf(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfuf zzi(Context context) {
        zzfuf zzfufVar;
        synchronized (zzfuf.class) {
            try {
                if (zzc == null) {
                    zzc = new zzfuf(context);
                }
                zzfufVar = zzc;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzfufVar;
    }

    public final zzfub zzh(long j11, boolean z11) throws IOException {
        synchronized (zzfuf.class) {
            try {
                if (zzo()) {
                    return zzb(null, null, j11, z11);
                }
                return new zzfub();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfuf.class) {
            try {
                if (zzg(false)) {
                    zzf(false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z11) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z11));
    }

    public final void zzn(boolean z11) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z11));
        if (z11) {
            return;
        }
        zzj();
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
