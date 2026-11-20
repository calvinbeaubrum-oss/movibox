package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxk extends zzfxp {
    final /* synthetic */ zzfxl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxk(zzfxl zzfxlVar, zzfxr zzfxrVar, CharSequence charSequence) {
        super(zzfxrVar, charSequence);
        this.zza = zzfxlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp
    public final int zzc(int i11) {
        return i11 + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp
    public final int zzd(int i11) {
        CharSequence charSequence = ((zzfxp) this).zzb;
        int length = charSequence.length();
        zzfxe.zzb(i11, length, "index");
        while (i11 < length) {
            zzfxl zzfxlVar = this.zza;
            if (zzfxlVar.zza.zzb(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }
}
