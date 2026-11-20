package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzana implements zzamy {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzaea zzc;

    @Nullable
    private final zzaon zzd;

    @Nullable
    private final zzfp zze;

    @Nullable
    private final zzann zzf;
    private final boolean[] zzg;
    private final zzamz zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzana() {
        this(null);
    }

    public zzana(@Nullable zzaon zzaonVar) {
        zzfp zzfpVar;
        this.zzd = zzaonVar;
        this.zzg = new boolean[4];
        this.zzh = new zzamz(128);
        if (zzaonVar != null) {
            this.zzf = new zzann(178, 128);
            zzfpVar = new zzfp();
        } else {
            zzfpVar = null;
            this.zzf = null;
        }
        this.zze = zzfpVar;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x0124  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i11;
        int i12;
        int i13;
        float f11;
        int i14;
        long j11;
        double d11;
        int i15;
        int i16;
        zzek.zzb(this.zzc);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zzi += (long) zzfpVar.zzb();
        this.zzc.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzg);
            if (iZza == iZze) {
                break;
            }
            int i17 = iZza + 3;
            int i18 = zzfpVar.zzM()[i17] & 255;
            int i19 = iZza - iZzd;
            if (!this.zzk) {
                if (i19 > 0) {
                    this.zzh.zza(bArrZzM, iZzd, iZza);
                }
                if (this.zzh.zzc(i18, i19 < 0 ? -i19 : 0)) {
                    zzamz zzamzVar = this.zzh;
                    String str = this.zzb;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzamzVar.zzc, zzamzVar.zza);
                    int i21 = bArrCopyOf[4] & 255;
                    byte b11 = bArrCopyOf[5];
                    int i22 = bArrCopyOf[6] & 255;
                    int i23 = ((b11 & 255) >> 4) | (i21 << 4);
                    int i24 = (bArrCopyOf[7] & 240) >> 4;
                    int i25 = ((b11 & Ascii.SI) << 8) | i22;
                    if (i24 == 2) {
                        i12 = i25 * 4;
                        i13 = i23 * 3;
                    } else if (i24 != 3) {
                        if (i24 != 4) {
                            f11 = 1.0f;
                        } else {
                            i12 = i25 * 121;
                            i13 = i23 * 100;
                        }
                        zzak zzakVar = new zzak();
                        zzakVar.zzK(str);
                        zzakVar.zzW(MimeTypes.VIDEO_MPEG2);
                        zzakVar.zzab(i23);
                        zzakVar.zzI(i25);
                        zzakVar.zzS(f11);
                        zzakVar.zzL(Collections.singletonList(bArrCopyOf));
                        zzam zzamVarZzac = zzakVar.zzac();
                        i14 = (bArrCopyOf[7] & Ascii.SI) - 1;
                        j11 = 0;
                        if (i14 >= 0 && i14 < 8) {
                            d11 = zza[i14];
                            byte b12 = bArrCopyOf[zzamzVar.zzb + 9];
                            i15 = (b12 & 96) >> 5;
                            i16 = b12 & Ascii.US;
                            if (i15 != i16) {
                                d11 *= (((double) i15) + 1.0d) / ((double) (i16 + 1));
                            }
                            j11 = (long) (1000000.0d / d11);
                        }
                        Pair pairCreate = Pair.create(zzamVarZzac, Long.valueOf(j11));
                        this.zzc.zzl((zzam) pairCreate.first);
                        this.zzl = ((Long) pairCreate.second).longValue();
                        this.zzk = true;
                    } else {
                        i12 = i25 * 16;
                        i13 = i23 * 9;
                    }
                    f11 = i12 / i13;
                    zzak zzakVar2 = new zzak();
                    zzakVar2.zzK(str);
                    zzakVar2.zzW(MimeTypes.VIDEO_MPEG2);
                    zzakVar2.zzab(i23);
                    zzakVar2.zzI(i25);
                    zzakVar2.zzS(f11);
                    zzakVar2.zzL(Collections.singletonList(bArrCopyOf));
                    zzam zzamVarZzac2 = zzakVar2.zzac();
                    i14 = (bArrCopyOf[7] & Ascii.SI) - 1;
                    j11 = 0;
                    if (i14 >= 0) {
                        d11 = zza[i14];
                        byte b13 = bArrCopyOf[zzamzVar.zzb + 9];
                        i15 = (b13 & 96) >> 5;
                        i16 = b13 & Ascii.US;
                        if (i15 != i16) {
                            d11 *= (((double) i15) + 1.0d) / ((double) (i16 + 1));
                        }
                        j11 = (long) (1000000.0d / d11);
                    }
                    Pair pairCreate2 = Pair.create(zzamVarZzac2, Long.valueOf(j11));
                    this.zzc.zzl((zzam) pairCreate2.first);
                    this.zzl = ((Long) pairCreate2.second).longValue();
                    this.zzk = true;
                }
            }
            zzann zzannVar = this.zzf;
            if (zzannVar != null) {
                if (i19 > 0) {
                    zzannVar.zza(bArrZzM, iZzd, iZza);
                    i11 = 0;
                } else {
                    i11 = -i19;
                }
                if (this.zzf.zzd(i11)) {
                    zzann zzannVar2 = this.zzf;
                    int iZzb = zzgm.zzb(zzannVar2.zza, zzannVar2.zzb);
                    zzfp zzfpVar2 = this.zze;
                    int i26 = zzfy.zza;
                    zzfpVar2.zzI(this.zzf.zza, iZzb);
                    this.zzd.zza(this.zzo, this.zze);
                }
                if (i18 == 178) {
                    if (zzfpVar.zzM()[iZza + 2] == 1) {
                        this.zzf.zzc(178);
                    }
                    i18 = 178;
                }
            }
            if (i18 == 0 || i18 == 179) {
                int i27 = iZze - iZza;
                if (this.zzq && this.zzk) {
                    long j12 = this.zzo;
                    if (j12 != C.TIME_UNSET) {
                        this.zzc.zzt(j12, this.zzp ? 1 : 0, ((int) (this.zzi - this.zzn)) - i27, i27, null);
                    }
                }
                if (!this.zzj || this.zzq) {
                    this.zzn = this.zzi - ((long) i27);
                    long j13 = this.zzm;
                    if (j13 == C.TIME_UNSET) {
                        long j14 = this.zzo;
                        j13 = j14 != C.TIME_UNSET ? j14 + this.zzl : -9223372036854775807L;
                    }
                    this.zzo = j13;
                    this.zzp = false;
                    this.zzm = C.TIME_UNSET;
                    this.zzj = true;
                }
                this.zzq = i18 == 0;
            } else if (i18 == 184) {
                this.zzp = true;
            }
            iZzd = i17;
        }
        if (!this.zzk) {
            this.zzh.zza(bArrZzM, iZzd, iZze);
        }
        zzann zzannVar3 = this.zzf;
        if (zzannVar3 != null) {
            zzannVar3.zza(bArrZzM, iZzd, iZze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzb = zzaokVar.zzb();
        this.zzc = zzacxVar.zzw(zzaokVar.zza(), 2);
        zzaon zzaonVar = this.zzd;
        if (zzaonVar != null) {
            zzaonVar.zzb(zzacxVar, zzaokVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        zzek.zzb(this.zzc);
        if (z11) {
            boolean z12 = this.zzp;
            long j11 = this.zzi - this.zzn;
            this.zzc.zzt(this.zzo, z12 ? 1 : 0, (int) j11, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzm = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzg);
        this.zzh.zzb();
        zzann zzannVar = this.zzf;
        if (zzannVar != null) {
            zzannVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = C.TIME_UNSET;
        this.zzo = C.TIME_UNSET;
    }
}
