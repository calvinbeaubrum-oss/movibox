package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeu {

    @VisibleForTesting
    final String zza;
    final /* synthetic */ zzew zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzeu(zzew zzewVar, String str, long j11, zzet zzetVar) {
        this.zzb = zzewVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j11 > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j11;
    }

    private final long zzc() {
        return this.zzb.zza().getLong(this.zza, 0L);
    }

    private final void zzd() {
        this.zzb.zzg();
        long jCurrentTimeMillis = this.zzb.zzt.zzav().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zzb.zza().edit();
        editorEdit.remove(this.zzc);
        editorEdit.remove(this.zzd);
        editorEdit.putLong(this.zza, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public final Pair zza() {
        long jAbs;
        this.zzb.zzg();
        this.zzb.zzg();
        long jZzc = zzc();
        if (jZzc == 0) {
            zzd();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jZzc - this.zzb.zzt.zzav().currentTimeMillis());
        }
        long j11 = this.zze;
        if (jAbs < j11) {
            return null;
        }
        if (jAbs > j11 + j11) {
            zzd();
            return null;
        }
        String string = this.zzb.zza().getString(this.zzd, null);
        long j12 = this.zzb.zza().getLong(this.zzc, 0L);
        zzd();
        return (string == null || j12 <= 0) ? zzew.zza : new Pair(string, Long.valueOf(j12));
    }

    public final void zzb(String str, long j11) {
        this.zzb.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        long j12 = this.zzb.zza().getLong(this.zzc, 0L);
        if (j12 <= 0) {
            SharedPreferences.Editor editorEdit = this.zzb.zza().edit();
            editorEdit.putString(this.zzd, str);
            editorEdit.putLong(this.zzc, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = this.zzb.zzt.zzv().zzG().nextLong();
        long j13 = j12 + 1;
        long j14 = Long.MAX_VALUE / j13;
        SharedPreferences.Editor editorEdit2 = this.zzb.zza().edit();
        if ((jNextLong & Long.MAX_VALUE) < j14) {
            editorEdit2.putString(this.zzd, str);
        }
        editorEdit2.putLong(this.zzc, j13);
        editorEdit2.apply();
    }
}
