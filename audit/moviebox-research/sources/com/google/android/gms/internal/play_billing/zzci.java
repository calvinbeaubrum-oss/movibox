package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzci extends zzby {
    private final zzbd zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzci(String str, @NullableDecl String str2, boolean z11, zzbd zzbdVar, boolean z12, boolean z13) {
        super(str2);
        Level level = Level.ALL;
        Set set = zzck.zza;
        zzbq zzbqVar = zzck.zzb;
        this.zza = zzbdVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzbqVar;
    }
}
