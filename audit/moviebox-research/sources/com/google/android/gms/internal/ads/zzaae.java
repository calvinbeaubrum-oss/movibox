package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaae extends zzst {
    public zzaae(Throwable th2, @Nullable zzsv zzsvVar, @Nullable Surface surface) {
        super(th2, zzsvVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
    }
}
