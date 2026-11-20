package com.google.android.gms.internal.ads;

import android.text.Layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzamg {
    public CharSequence zzc;
    public long zza = 0;
    public long zzb = 0;
    public int zzd = 2;
    public float zze = -3.4028235E38f;
    public int zzf = 1;
    public int zzg = 0;
    public float zzh = -3.4028235E38f;
    public int zzi = Integer.MIN_VALUE;
    public float zzj = 1.0f;
    public int zzk = Integer.MIN_VALUE;

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    public final zzea zza() {
        Layout.Alignment alignment;
        float f11 = this.zzh;
        float f12 = -3.4028235E38f;
        if (f11 == -3.4028235E38f) {
            int i11 = this.zzd;
            if (i11 != 4) {
                f11 = i11 != 5 ? 0.5f : 1.0f;
            } else {
                f11 = 0.0f;
            }
        }
        int i12 = this.zzi;
        if (i12 == Integer.MIN_VALUE) {
            int i13 = this.zzd;
            if (i13 == 1) {
                i12 = 0;
            } else if (i13 == 3) {
                i12 = 2;
            } else if (i13 == 4) {
                i12 = 0;
            } else if (i13 != 5) {
                i12 = 1;
            } else {
                i12 = 2;
            }
        }
        zzea zzeaVar = new zzea();
        int i14 = this.zzd;
        if (i14 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (i14 == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i14 == 3) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else if (i14 == 4) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (i14 != 5) {
            zzff.zzf("WebvttCueParser", "Unknown textAlignment: " + i14);
            alignment = null;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        zzeaVar.zzm(alignment);
        float f13 = this.zze;
        int i15 = this.zzf;
        if (f13 != -3.4028235E38f && i15 == 0 && (f13 < 0.0f || f13 > 1.0f)) {
            f12 = 1.0f;
        } else if (f13 != -3.4028235E38f) {
            f12 = f13;
        } else if (i15 == 0) {
            f12 = 1.0f;
        }
        zzeaVar.zze(f12, i15);
        zzeaVar.zzf(this.zzg);
        zzeaVar.zzh(f11);
        zzeaVar.zzi(i12);
        float f14 = this.zzj;
        if (i12 == 0) {
            f11 = 1.0f - f11;
        } else if (i12 != 1) {
            if (i12 != 2) {
                throw new IllegalStateException(String.valueOf(i12));
            }
        } else if (f11 <= 0.5f) {
            f11 += f11;
        } else {
            float f15 = 1.0f - f11;
            f11 = f15 + f15;
        }
        zzeaVar.zzk(Math.min(f14, f11));
        zzeaVar.zzo(this.zzk);
        CharSequence charSequence = this.zzc;
        if (charSequence != null) {
            zzeaVar.zzl(charSequence);
        }
        return zzeaVar;
    }
}
