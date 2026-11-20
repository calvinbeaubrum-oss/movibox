package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzib {
    private int zza;

    public final void zza(int i11) {
        this.zza = i11 | this.zza;
    }

    @CallSuper
    public void zzb() {
        this.zza = 0;
    }

    public final void zzc(int i11) {
        this.zza = i11;
    }

    public final boolean zzd(int i11) {
        return (this.zza & i11) == i11;
    }

    public final boolean zze() {
        return zzd(ASTNode.DEOP);
    }

    public final boolean zzf() {
        return zzd(4);
    }

    public final boolean zzg() {
        return zzd(1);
    }

    public final boolean zzh() {
        return zzd(ASTNode.DISCARD);
    }
}
