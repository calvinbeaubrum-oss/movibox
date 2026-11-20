package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfn {

    @Nullable
    private static zzfn zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    private int zze = 0;

    private zzfn(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new zzfm(this, null), intentFilter);
    }

    public static synchronized zzfn zzb(Context context) {
        try {
            if (zza == null) {
                zza = new zzfn(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zza;
    }

    public static /* synthetic */ void zzc(zzfn zzfnVar, int i11) {
        synchronized (zzfnVar.zzd) {
            try {
                if (zzfnVar.zze == i11) {
                    return;
                }
                zzfnVar.zze = i11;
                for (WeakReference weakReference : zzfnVar.zzc) {
                    zzyy zzyyVar = (zzyy) weakReference.get();
                    if (zzyyVar != null) {
                        zzyyVar.zza.zzk(i11);
                    } else {
                        zzfnVar.zzc.remove(weakReference);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int zza() {
        int i11;
        synchronized (this.zzd) {
            i11 = this.zze;
        }
        return i11;
    }

    public final void zzd(final zzyy zzyyVar) {
        for (WeakReference weakReference : this.zzc) {
            if (weakReference.get() == null) {
                this.zzc.remove(weakReference);
            }
        }
        this.zzc.add(new WeakReference(zzyyVar));
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfj
            @Override // java.lang.Runnable
            public final void run() {
                zzyyVar.zza.zzk(this.zza.zza());
            }
        });
    }
}
