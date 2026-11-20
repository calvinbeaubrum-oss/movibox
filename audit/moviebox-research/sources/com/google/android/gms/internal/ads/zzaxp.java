package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxp extends zzaxx {
    private final StackTraceElement[] zzi;

    public zzaxp(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, StackTraceElement[] stackTraceElementArr) {
        super(zzawjVar, "kB6Ls9/mn9iw4biP/HsD3FFR9Vy1jOQ1ljTH52MXzz14qrvyk1QMusJQlJpZNqjT", "pY1LPqV65osROa0AkcabhXHjwpz5nP0HOapDW2QtdtU=", zzasgVar, i11, 45);
        this.zzi = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzi;
        if (stackTraceElementArr != null) {
            zzawa zzawaVar = new zzawa((String) this.zzf.invoke(null, stackTraceElementArr));
            synchronized (this.zze) {
                try {
                    this.zze.zzF(zzawaVar.zza.longValue());
                    if (zzawaVar.zzb.booleanValue()) {
                        this.zze.zzac(true != zzawaVar.zzc.booleanValue() ? 2 : 1);
                    } else {
                        this.zze.zzac(3);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
