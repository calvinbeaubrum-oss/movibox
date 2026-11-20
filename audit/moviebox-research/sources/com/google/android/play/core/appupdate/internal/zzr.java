package com.google.android.play.core.appupdate.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzr extends zzn {
    final /* synthetic */ y zza;

    public zzr(y yVar) {
        this.zza = yVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        synchronized (this.zza.f38074f) {
            try {
                if (this.zza.f38079k.get() > 0 && this.zza.f38079k.decrementAndGet() > 0) {
                    this.zza.f38070b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                y yVar = this.zza;
                if (yVar.f38081m != null) {
                    yVar.f38070b.d("Unbind from service.", new Object[0]);
                    y yVar2 = this.zza;
                    yVar2.f38069a.unbindService(yVar2.f38080l);
                    this.zza.f38075g = false;
                    this.zza.f38081m = null;
                    this.zza.f38080l = null;
                }
                this.zza.w();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
