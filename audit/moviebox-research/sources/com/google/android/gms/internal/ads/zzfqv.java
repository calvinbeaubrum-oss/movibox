package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfqv extends zzfqs {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    @Override // com.google.android.gms.internal.ads.zzfqs
    public final zzfqs zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqs
    public final zzfqs zzb(boolean z11) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqs
    public final zzfqs zzc(boolean z11) {
        this.zzb = z11;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqs
    public final zzfqt zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzfqx(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb2.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb2.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
