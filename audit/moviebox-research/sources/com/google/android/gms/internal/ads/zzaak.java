package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(17)
public final class zzaak extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaai zzd;
    private boolean zze;

    public /* synthetic */ zzaak(zzaai zzaaiVar, SurfaceTexture surfaceTexture, boolean z11, zzaaj zzaajVar) {
        super(surfaceTexture);
        this.zzd = zzaaiVar;
        this.zza = z11;
    }

    public static zzaak zza(Context context, boolean z11) {
        boolean z12 = true;
        if (z11 && !zzb(context)) {
            z12 = false;
        }
        zzek.zzf(z12);
        return new zzaai().zza(z11 ? zzb : 0);
    }

    public static synchronized boolean zzb(Context context) {
        int i11;
        try {
            if (!zzc) {
                if (zzeu.zzc(context)) {
                    i11 = zzeu.zzd() ? 1 : 2;
                } else {
                    i11 = 0;
                }
                zzb = i11;
                zzc = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzb != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzd) {
            try {
                if (!this.zze) {
                    this.zzd.zzb();
                    this.zze = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
