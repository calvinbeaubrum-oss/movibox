package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzcff {
    private final WeakReference zza;

    public zzcff(View view) {
        this.zza = new WeakReference(view);
    }

    public abstract void zza(ViewTreeObserver viewTreeObserver);

    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    @Nullable
    public final ViewTreeObserver zzc() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void zzd() {
        ViewTreeObserver viewTreeObserverZzc = zzc();
        if (viewTreeObserverZzc != null) {
            zza(viewTreeObserverZzc);
        }
    }

    public final void zze() {
        ViewTreeObserver viewTreeObserverZzc = zzc();
        if (viewTreeObserverZzc != null) {
            zzb(viewTreeObserverZzc);
        }
    }
}
