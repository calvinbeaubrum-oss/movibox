package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanp implements zzaol {
    private final zzamy zza;
    private final zzfo zzb = new zzfo(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfw zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzanp(zzamy zzamyVar) {
        this.zza = zzamyVar;
    }

    private final void zzd(int i11) {
        this.zzc = i11;
        this.zzd = 0;
    }

    private final boolean zze(zzfp zzfpVar, @Nullable byte[] bArr, int i11) {
        int iMin = Math.min(zzfpVar.zzb(), i11 - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfpVar.zzL(iMin);
        } else {
            zzfpVar.zzG(bArr, this.zzd, iMin);
        }
        int i12 = this.zzd + iMin;
        this.zzd = i12;
        return i12 == i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zza(zzfp zzfpVar, int i11) throws zzcc {
        int i12;
        long jZzb;
        zzek.zzb(this.zze);
        int i13 = -1;
        int i14 = 2;
        ?? r11 = 0;
        int i15 = 1;
        if ((i11 & 1) != 0) {
            int i16 = this.zzc;
            if (i16 != 0 && i16 != 1) {
                if (i16 != 2) {
                    int i17 = this.zzj;
                    if (i17 != -1) {
                        zzff.zzf("PesReader", "Unexpected start indicator: expected " + i17 + " more bytes");
                    }
                    this.zza.zzc(zzfpVar.zze() == 0);
                } else {
                    zzff.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i18 = i11;
        while (zzfpVar.zzb() > 0) {
            int i19 = this.zzc;
            if (i19 == 0) {
                zzfpVar.zzL(zzfpVar.zzb());
            } else if (i19 != i15) {
                if (i19 != i14) {
                    int iZzb = zzfpVar.zzb();
                    int i21 = this.zzj;
                    int i22 = i21 == i13 ? 0 : iZzb - i21;
                    if (i22 > 0) {
                        iZzb -= i22;
                        zzfpVar.zzJ(zzfpVar.zzd() + iZzb);
                    }
                    this.zza.zza(zzfpVar);
                    int i23 = this.zzj;
                    if (i23 != i13) {
                        int i24 = i23 - iZzb;
                        this.zzj = i24;
                        if (i24 == 0) {
                            this.zza.zzc(r11);
                            zzd(i15);
                        }
                    }
                } else {
                    if (zze(zzfpVar, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfpVar, null, this.zzi)) {
                        this.zzb.zzk(r11);
                        if (this.zzf) {
                            this.zzb.zzm(4);
                            long jZzd = this.zzb.zzd(3);
                            this.zzb.zzm(i15);
                            int iZzd = this.zzb.zzd(15) << 15;
                            this.zzb.zzm(i15);
                            long jZzd2 = this.zzb.zzd(15);
                            this.zzb.zzm(i15);
                            if (!this.zzh && this.zzg) {
                                this.zzb.zzm(4);
                                long jZzd3 = ((long) this.zzb.zzd(3)) << 30;
                                this.zzb.zzm(i15);
                                int iZzd2 = this.zzb.zzd(15) << 15;
                                this.zzb.zzm(i15);
                                long jZzd4 = this.zzb.zzd(15);
                                this.zzb.zzm(i15);
                                this.zze.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                                this.zzh = true;
                            }
                            jZzb = this.zze.zzb((jZzd << 30) | ((long) iZzd) | jZzd2);
                        } else {
                            jZzb = C.TIME_UNSET;
                        }
                        i18 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(jZzb, i18);
                        zzd(3);
                        i13 = -1;
                    }
                }
            } else if (zze(zzfpVar, this.zzb.zza, 9)) {
                this.zzb.zzk(0);
                int iZzd3 = this.zzb.zzd(24);
                if (iZzd3 != 1) {
                    zzff.zzf("PesReader", "Unexpected start code prefix: " + iZzd3);
                    i13 = -1;
                    this.zzj = -1;
                    i12 = 0;
                } else {
                    this.zzb.zzm(8);
                    zzfo zzfoVar = this.zzb;
                    int iZzd4 = zzfoVar.zzd(16);
                    zzfoVar.zzm(5);
                    this.zzk = this.zzb.zzo();
                    this.zzb.zzm(2);
                    this.zzf = this.zzb.zzo();
                    this.zzg = this.zzb.zzo();
                    this.zzb.zzm(6);
                    int iZzd5 = this.zzb.zzd(8);
                    this.zzi = iZzd5;
                    if (iZzd4 == 0) {
                        this.zzj = -1;
                    } else {
                        int i25 = (iZzd4 - 3) - iZzd5;
                        this.zzj = i25;
                        if (i25 < 0) {
                            zzff.zzf("PesReader", "Found negative packet payload size: " + i25);
                            i13 = -1;
                            this.zzj = -1;
                        }
                        i12 = 2;
                    }
                    i13 = -1;
                    i12 = 2;
                }
                zzd(i12);
            } else {
                i13 = -1;
            }
            i14 = 2;
            r11 = 0;
            i15 = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
        this.zze = zzfwVar;
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
