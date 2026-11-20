package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzax implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    public zzax(zzay zzayVar, Context context, String str, boolean z11, boolean z12) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = z12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = zzt.zzJ(this.zza);
        builderZzJ.setMessage(this.zzb);
        if (this.zzc) {
            builderZzJ.setTitle("Error");
        } else {
            builderZzJ.setTitle("Info");
        }
        if (this.zzd) {
            builderZzJ.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderZzJ.setPositiveButton("Learn More", new zzaw(this));
            builderZzJ.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderZzJ.create().show();
    }
}
