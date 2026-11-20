package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaco {
    private final zzacn zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzaco(zzacn zzacnVar) {
        this.zza = zzacnVar;
    }

    @Nullable
    public final zzacu zza(Object... objArr) {
        Constructor constructorZza;
        synchronized (this.zzb) {
            if (!this.zzb.get()) {
                try {
                    constructorZza = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                    constructorZza = null;
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating extension", e11);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzacu) constructorZza.newInstance(objArr);
        } catch (Exception e12) {
            throw new IllegalStateException("Unexpected error creating extractor", e12);
        }
    }
}
