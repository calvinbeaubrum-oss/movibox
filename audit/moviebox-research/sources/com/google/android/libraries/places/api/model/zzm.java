package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzm extends zzca {
    private int zza;
    private int zzb;
    private int zzc;
    private byte zzd;

    @Override // com.google.android.libraries.places.api.model.zzca
    public final zzca zza(int i11) {
        this.zzc = i11;
        this.zzd = (byte) (this.zzd | 4);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzca
    public final zzca zzb(int i11) {
        this.zzb = i11;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzca zzc(int i11) {
        this.zza = i11;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzca
    public final LocalDate zzd() {
        if (this.zzd == 7) {
            return new zzba(this.zza, this.zzb, this.zzc);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.zzd & 1) == 0) {
            sb2.append(" year");
        }
        if ((this.zzd & 2) == 0) {
            sb2.append(" month");
        }
        if ((this.zzd & 4) == 0) {
            sb2.append(" day");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
