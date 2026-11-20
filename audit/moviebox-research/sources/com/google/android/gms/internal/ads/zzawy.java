package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawy extends zzaxx {
    public zzawy(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "nK4MIXXv/sY+coqtAjalB6f9NiJ1zVnlRnfsJ++LIaOoNJXY+cpXhUK9rjjc0N2G", "gziBDgIPHk3UnbqAN9Ta9zRxJ8KBrTfiKBXyCZDQ588=", zzasgVar, i11, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzm(-1L);
        this.zze.zzl(-1L);
        int[] iArr = (int[]) this.zzf.invoke(null, this.zzb.zzb());
        synchronized (this.zze) {
            try {
                this.zze.zzm(iArr[0]);
                this.zze.zzl(iArr[1]);
                int i11 = iArr[2];
                if (i11 != Integer.MIN_VALUE) {
                    this.zze.zzk(i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
