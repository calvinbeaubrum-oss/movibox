package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzchw implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzchw(zzcgl zzcglVar) {
        Context context = zzcglVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzcglVar.zzn().zza);
        this.zzc = new WeakReference(zzcglVar);
    }

    public static /* bridge */ /* synthetic */ void zze(zzchw zzchwVar, String str, Map map) {
        zzcgl zzcglVar = (zzcgl) zzchwVar.zzc.get();
        if (zzcglVar != null) {
            zzcglVar.zzd("onPrecacheEvent", map);
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    public abstract void zzf();

    public final void zzg(String str, @Nullable String str2, String str3, @Nullable String str4) {
        zzcdv.zza.post(new zzchv(this, str, str2, str3, str4));
    }

    public final void zzh(String str, String str2, int i11) {
        zzcdv.zza.post(new zzcht(this, str, str2, i11));
    }

    public final void zzj(String str, String str2, long j11) {
        zzcdv.zza.post(new zzchu(this, str, str2, j11));
    }

    public final void zzn(String str, String str2, int i11, int i12, long j11, long j12, boolean z11, int i13, int i14) {
        zzcdv.zza.post(new zzchs(this, str, str2, i11, i12, j11, j12, z11, i13, i14));
    }

    public final void zzo(String str, String str2, long j11, long j12, boolean z11, long j13, long j14, long j15, int i11, int i12) {
        zzcdv.zza.post(new zzchr(this, str, str2, j11, j12, j13, j14, j15, z11, i11, i12));
    }

    public void zzp(int i11) {
    }

    public void zzq(int i11) {
    }

    public void zzr(int i11) {
    }

    public void zzs(int i11) {
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzcho zzchoVar) {
        return zzt(str);
    }
}
