package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgvg extends zzgzu implements zzhbf {
    private static final zzgvg zzb;
    private int zzd;
    private zzhad zze = zzgzu.zzaN();

    static {
        zzgvg zzgvgVar = new zzgvg();
        zzb = zzgvgVar;
        zzgzu.zzaU(zzgvg.class, zzgvgVar);
    }

    private zzgvg() {
    }

    public static zzgvd zzd() {
        return (zzgvd) zzb.zzaA();
    }

    public static zzgvg zzg(InputStream inputStream, zzgzf zzgzfVar) throws IOException {
        return (zzgvg) zzgzu.zzaH(zzb, inputStream, zzgzfVar);
    }

    public static /* synthetic */ void zzj(zzgvg zzgvgVar, zzgvf zzgvfVar) {
        zzgvfVar.getClass();
        zzhad zzhadVar = zzgvgVar.zze;
        if (!zzhadVar.zzc()) {
            zzgvgVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzgvgVar.zze.add(zzgvfVar);
    }

    public final int zza() {
        return this.zze.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgvf.class});
        }
        if (i12 == 3) {
            return new zzgvg();
        }
        zzgvc zzgvcVar = null;
        if (i12 == 4) {
            return new zzgvd(zzgvcVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzgvf zze(int i11) {
        return (zzgvf) this.zze.get(i11);
    }

    public final List zzh() {
        return this.zze;
    }
}
