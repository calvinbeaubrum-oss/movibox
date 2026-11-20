package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzawh implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzawj zzb;

    public zzawh(zzawj zzawjVar, int i11, boolean z11) {
        this.zzb = zzawjVar;
        this.zza = i11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatd zzatdVarZza;
        int i11 = this.zza;
        zzawj zzawjVar = this.zzb;
        if (i11 > 0) {
            try {
                Thread.sleep(i11 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzawjVar.zza.getPackageManager().getPackageInfo(zzawjVar.zza.getPackageName(), 0);
            Context context = zzawjVar.zza;
            zzatdVarZza = zzfqz.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzatdVarZza = null;
        }
        this.zzb.zzm = zzatdVarZza;
        if (this.zza < 4) {
            if (zzatdVarZza != null && zzatdVarZza.zzaj() && !zzatdVarZza.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzatdVarZza.zzak() && zzatdVarZza.zzf().zze() && zzatdVarZza.zzf().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
