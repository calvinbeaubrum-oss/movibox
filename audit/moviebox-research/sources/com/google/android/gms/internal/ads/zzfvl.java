package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"RestrictedApi"})
final class zzfvl {
    private static final zzfvt zzb = new zzfvt("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");

    @Nullable
    final zzfwe zza;
    private final String zzd;

    public zzfvl(Context context) {
        if (zzfwh.zza(context)) {
            this.zza = new zzfwe(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfvg.zza, null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    public final void zzc() {
        if (this.zza == null) {
            return;
        }
        zzb.zzc("unbind LMD display overlay service", new Object[0]);
        this.zza.zzu();
    }

    public final void zzd(zzfvc zzfvcVar, zzfvq zzfvqVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfvi(this, taskCompletionSource, zzfvcVar, zzfvqVar, taskCompletionSource), taskCompletionSource);
        }
    }

    public final void zze(zzfvn zzfvnVar, zzfvq zzfvqVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        if (zzfvnVar.zzg() != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfvh(this, taskCompletionSource, zzfvnVar, zzfvqVar, taskCompletionSource), taskCompletionSource);
        } else {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfvo zzfvoVarZzc = zzfvp.zzc();
            zzfvoVarZzc.zzb(8160);
            zzfvqVar.zza(zzfvoVarZzc.zzc());
        }
    }

    public final void zzf(zzfvs zzfvsVar, zzfvq zzfvqVar, int i11) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfvj(this, taskCompletionSource, zzfvsVar, i11, zzfvqVar, taskCompletionSource), taskCompletionSource);
        }
    }
}
