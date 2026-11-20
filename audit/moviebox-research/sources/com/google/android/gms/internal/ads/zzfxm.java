package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxm extends zzfxp {
    final /* synthetic */ zzfxn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxm(zzfxn zzfxnVar, zzfxr zzfxrVar, CharSequence charSequence) {
        super(zzfxrVar, charSequence);
        this.zza = zzfxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp
    public final int zzc(int i11) {
        return i11;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp
    public final int zzd(int i11) {
        int i12 = i11 + 4000;
        if (i12 < ((zzfxp) this).zzb.length()) {
            return i12;
        }
        return -1;
    }
}
