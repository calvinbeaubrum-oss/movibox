package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzemg {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;

    @Nullable
    final Integer zze;

    public zzemg(String str, String str2, int i11, long j11, @Nullable Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = j11;
        this.zze = num;
    }

    public final String toString() {
        String str = this.zza + InstructionFileId.DOT + this.zzc + InstructionFileId.DOT + this.zzd;
        if (!TextUtils.isEmpty(this.zzb)) {
            str = str + InstructionFileId.DOT + this.zzb;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbC)).booleanValue() || this.zze == null || TextUtils.isEmpty(this.zzb)) {
            return str;
        }
        return str + InstructionFileId.DOT + this.zze;
    }
}
