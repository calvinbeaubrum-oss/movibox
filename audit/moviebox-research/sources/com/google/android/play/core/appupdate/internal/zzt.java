package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzn {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ x zzb;

    public zzt(x xVar, IBinder iBinder) {
        this.zzb = xVar;
        this.zza = iBinder;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        this.zzb.f38067a.f38081m = k.f0(this.zza);
        y.q(this.zzb.f38067a);
        this.zzb.f38067a.f38075g = false;
        Iterator it = this.zzb.f38067a.f38072d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zzb.f38067a.f38072d.clear();
    }
}
