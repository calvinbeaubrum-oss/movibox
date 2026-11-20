package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajk {
    private static final zzfxr zza = zzfxr.zzc(zzfwp.zzc(':'));
    private static final zzfxr zzb = zzfxr.zzc(zzfwp.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x009d  */
    public final int zza(zzacv zzacvVar, zzadr zzadrVar, List list) throws IOException {
        byte b11;
        char c11;
        int i11 = this.zzd;
        if (i11 == 0) {
            long jZzd = zzacvVar.zzd();
            zzadrVar.zza = (jZzd == -1 || jZzd < 8) ? 0L : jZzd - 8;
            this.zzd = 1;
            return 1;
        }
        int i12 = 2;
        if (i11 != 1) {
            short s11 = 2817;
            short s12 = 2816;
            short s13 = 2192;
            if (i11 != 2) {
                long jZzf = zzacvVar.zzf();
                int iZzd = (int) ((zzacvVar.zzd() - zzacvVar.zzf()) - ((long) this.zze));
                zzfp zzfpVar = new zzfp(iZzd);
                zzacvVar.zzi(zzfpVar.zzM(), 0, iZzd);
                for (int i13 = 0; i13 < this.zzc.size(); i13++) {
                    zzajj zzajjVar = (zzajj) this.zzc.get(i13);
                    zzfpVar.zzK((int) (zzajjVar.zza - jZzf));
                    zzfpVar.zzL(4);
                    int iZzi = zzfpVar.zzi();
                    Charset charset = zzfwq.zzc;
                    switch (zzfpVar.zzA(iZzi, charset)) {
                        case "SlowMotion_Data":
                            b11 = 0;
                            break;
                        case "Super_SlowMotion_Edit_Data":
                            b11 = 3;
                            break;
                        case "Super_SlowMotion_Data":
                            b11 = 1;
                            break;
                        case "Super_SlowMotion_Deflickering_On":
                            b11 = 4;
                            break;
                        case "Super_SlowMotion_BGM":
                            b11 = 2;
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    if (b11 == 0) {
                        c11 = 2192;
                    } else if (b11 == 1) {
                        c11 = 2816;
                    } else if (b11 == 2) {
                        c11 = 2817;
                    } else if (b11 == 3) {
                        c11 = 2819;
                    } else {
                        if (b11 != 4) {
                            throw zzcc.zza("Invalid SEF name", null);
                        }
                        c11 = 2820;
                    }
                    int i14 = zzajjVar.zzb - (iZzi + 8);
                    if (c11 == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZzf = zzb.zzf(zzfpVar.zzA(i14, charset));
                        for (int i15 = 0; i15 < listZzf.size(); i15++) {
                            List listZzf2 = zza.zzf((CharSequence) listZzf.get(i15));
                            if (listZzf2.size() != 3) {
                                throw zzcc.zza(null, null);
                            }
                            try {
                                arrayList.add(new zzahi(Long.parseLong((String) listZzf2.get(0)), Long.parseLong((String) listZzf2.get(1)), 1 << (Integer.parseInt((String) listZzf2.get(2)) - 1)));
                            } catch (NumberFormatException e11) {
                                throw zzcc.zza(null, e11);
                            }
                        }
                        list.add(new zzahj(arrayList));
                    } else if (c11 != 2816 && c11 != 2817 && c11 != 2819 && c11 != 2820) {
                        throw new IllegalStateException();
                    }
                }
                zzadrVar.zza = 0L;
            } else {
                long jZzd2 = zzacvVar.zzd();
                int i16 = this.zze - 20;
                zzfp zzfpVar2 = new zzfp(i16);
                zzacvVar.zzi(zzfpVar2.zzM(), 0, i16);
                int i17 = 0;
                while (i17 < i16 / 12) {
                    zzfpVar2.zzL(i12);
                    short sZzC = zzfpVar2.zzC();
                    if (sZzC == s13 || sZzC == s12 || sZzC == s11 || sZzC == 2819 || sZzC == 2820) {
                        this.zzc.add(new zzajj(sZzC, (jZzd2 - ((long) this.zze)) - ((long) zzfpVar2.zzi()), zzfpVar2.zzi()));
                    } else {
                        zzfpVar2.zzL(8);
                    }
                    i17++;
                    i16 = i16;
                    i12 = 2;
                    s11 = 2817;
                    s12 = 2816;
                    s13 = 2192;
                }
                if (this.zzc.isEmpty()) {
                    zzadrVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzadrVar.zza = ((zzajj) this.zzc.get(0)).zza;
                }
            }
        } else {
            zzfp zzfpVar3 = new zzfp(8);
            zzacvVar.zzi(zzfpVar3.zzM(), 0, 8);
            this.zze = zzfpVar3.zzi() + 8;
            if (zzfpVar3.zzg() != 1397048916) {
                zzadrVar.zza = 0L;
            } else {
                zzadrVar.zza = zzacvVar.zzf() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }
}
