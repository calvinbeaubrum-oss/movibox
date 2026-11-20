package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajc implements zzacu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaiy
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzajc()};
        }
    };
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzam zzc;
    private int zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private zzacx zzE;
    private zzaea[] zzF;
    private zzaea[] zzG;
    private boolean zzH;
    private final zzakp zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzfp zzg;
    private final zzfp zzh;
    private final zzfp zzi;
    private final byte[] zzj;
    private final zzfp zzk;
    private final zzafu zzl;
    private final zzfp zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private int zzp;
    private int zzq;
    private long zzr;
    private int zzs;

    @Nullable
    private zzfp zzt;
    private long zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private long zzy;

    @Nullable
    private zzajb zzz;

    static {
        zzak zzakVar = new zzak();
        zzakVar.zzW(MimeTypes.APPLICATION_EMSG);
        zzc = zzakVar.zzac();
    }

    @Deprecated
    public zzajc() {
        this(zzakp.zza, 32, null, null, zzgaa.zzl(), null);
    }

    public zzajc(zzakp zzakpVar, int i11, @Nullable zzfw zzfwVar, @Nullable zzajm zzajmVar, List list, @Nullable zzaea zzaeaVar) {
        this.zzd = zzakpVar;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafu();
        this.zzm = new zzfp(16);
        this.zzg = new zzfp(zzgm.zza);
        this.zzh = new zzfp(5);
        this.zzi = new zzfp();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzfp(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzx = C.TIME_UNSET;
        this.zzw = C.TIME_UNSET;
        this.zzy = C.TIME_UNSET;
        this.zzE = zzacx.zza;
        this.zzF = new zzaea[0];
        this.zzG = new zzaea[0];
    }

    private static int zza(int i11) throws zzcc {
        if (i11 >= 0) {
            return i11;
        }
        throw zzcc.zza("Unexpected negative value: " + i11, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    @Nullable
    private static zzae zzf(List list) {
        zzaji zzajiVar;
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            zzain zzainVar = (zzain) list.get(i11);
            if (zzainVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzM = zzainVar.zza.zzM();
                zzfp zzfpVar = new zzfp(bArrZzM);
                if (zzfpVar.zze() < 32) {
                    zzajiVar = null;
                } else {
                    zzfpVar.zzK(0);
                    if (zzfpVar.zzg() == zzfpVar.zzb() + 4 && zzfpVar.zzg() == 1886614376) {
                        int iZze = zzaio.zze(zzfpVar.zzg());
                        if (iZze > 1) {
                            zzff.zzf("PsshAtomUtil", "Unsupported pssh version: " + iZze);
                        } else {
                            UUID uuid = new UUID(zzfpVar.zzt(), zzfpVar.zzt());
                            if (iZze == 1) {
                                zzfpVar.zzL(zzfpVar.zzp() * 16);
                            }
                            int iZzp = zzfpVar.zzp();
                            if (iZzp == zzfpVar.zzb()) {
                                byte[] bArr = new byte[iZzp];
                                zzfpVar.zzG(bArr, 0, iZzp);
                                zzajiVar = new zzaji(uuid, iZze, bArr);
                            }
                        }
                        zzajiVar = null;
                    } else {
                        zzajiVar = null;
                    }
                }
                UUID uuid2 = zzajiVar == null ? null : zzajiVar.zza;
                if (uuid2 == null) {
                    zzff.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzad(uuid2, null, MimeTypes.VIDEO_MP4, bArrZzM));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzae(arrayList);
    }

    private final void zzg() {
        this.zzp = 0;
        this.zzs = 0;
    }

    private static void zzh(zzfp zzfpVar, int i11, zzajo zzajoVar) throws zzcc {
        zzfpVar.zzK(i11 + 8);
        int iZzg = zzfpVar.zzg();
        if ((iZzg & 1) != 0) {
            throw zzcc.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z11 = (iZzg & 2) != 0;
        int iZzp = zzfpVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzajoVar.zzl, 0, zzajoVar.zze, false);
            return;
        }
        int i12 = zzajoVar.zze;
        if (iZzp != i12) {
            throw zzcc.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i12, null);
        }
        Arrays.fill(zzajoVar.zzl, 0, iZzp, z11);
        zzajoVar.zza(zzfpVar.zzb());
        zzfp zzfpVar2 = zzajoVar.zzn;
        zzfpVar.zzG(zzfpVar2.zzM(), 0, zzfpVar2.zze());
        zzajoVar.zzn.zzK(0);
        zzajoVar.zzo = false;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0347 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0349  */
    /* JADX WARN: Code duplicated, block: B:123:0x0352  */
    /* JADX WARN: Code duplicated, block: B:126:0x035b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0364  */
    /* JADX WARN: Code duplicated, block: B:130:0x036d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0376  */
    /* JADX WARN: Code duplicated, block: B:133:0x037a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x037c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0380  */
    /* JADX WARN: Code duplicated, block: B:136:0x0381 A[PHI: r12
  0x0381: PHI (r12v12 int) = (r12v10 int), (r12v13 int) binds: [B:132:0x0378, B:135:0x0380] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:138:0x0385  */
    /* JADX WARN: Code duplicated, block: B:139:0x0390  */
    /* JADX WARN: Code duplicated, block: B:142:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:145:0x03be  */
    /* JADX WARN: Code duplicated, block: B:146:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c8  */
    private final void zzi(long j11) throws zzcc {
        zzajc zzajcVar;
        SparseArray sparseArray;
        zzaim zzaimVar;
        int i11;
        int i12;
        byte[] bArr;
        int i13;
        byte[] bArr2;
        byte[] bArr3;
        int i14;
        boolean z11;
        zzajo zzajoVar;
        int i15;
        zzaim zzaimVar2;
        int i16;
        boolean z12;
        long j12;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        int i17;
        long j13;
        long j14;
        int iZzg;
        int iZzg2;
        int i18;
        int iZzg3;
        int iZzg4;
        long jZzs;
        boolean z13;
        long[] jArr2;
        final zzajc zzajcVar2 = this;
        while (!zzajcVar2.zzn.isEmpty() && ((zzaim) zzajcVar2.zzn.peek()).zza == j11) {
            zzaim zzaimVar3 = (zzaim) zzajcVar2.zzn.pop();
            int i19 = zzaimVar3.zzd;
            int i21 = 12;
            int i22 = 8;
            if (i19 == 1836019574) {
                zzae zzaeVarZzf = zzf(zzaimVar3.zzb);
                zzaim zzaimVarZza = zzaimVar3.zza(1836475768);
                zzaimVarZza.getClass();
                SparseArray sparseArray2 = new SparseArray();
                int size = zzaimVarZza.zzb.size();
                long jZzu = C.TIME_UNSET;
                int i23 = 0;
                while (i23 < size) {
                    zzain zzainVar = (zzain) zzaimVarZza.zzb.get(i23);
                    int i24 = zzainVar.zzd;
                    if (i24 == 1953654136) {
                        zzfp zzfpVar = zzainVar.zza;
                        zzfpVar.zzK(i21);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzfpVar.zzg()), new zzaix(zzfpVar.zzg() - 1, zzfpVar.zzg(), zzfpVar.zzg(), zzfpVar.zzg()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (zzaix) pairCreate.second);
                    } else if (i24 == 1835362404) {
                        zzfp zzfpVar2 = zzainVar.zza;
                        zzfpVar2.zzK(8);
                        jZzu = zzaio.zze(zzfpVar2.zzg()) == 0 ? zzfpVar2.zzu() : zzfpVar2.zzv();
                    }
                    i23++;
                    i21 = 12;
                }
                List listZzd = zzaiw.zzd(zzaimVar3, new zzadk(), jZzu, zzaeVarZzf, false, false, new zzfws() { // from class: com.google.android.gms.internal.ads.zzaiz
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return (zzajm) obj;
                    }
                });
                int size2 = listZzd.size();
                if (zzajcVar2.zzf.size() == 0) {
                    for (int i25 = 0; i25 < size2; i25++) {
                        zzajp zzajpVar = (zzajp) listZzd.get(i25);
                        zzajm zzajmVar = zzajpVar.zza;
                        zzajcVar2.zzf.put(zzajmVar.zza, new zzajb(zzajcVar2.zzE.zzw(i25, zzajmVar.zzb), zzajpVar, zzj(sparseArray2, zzajmVar.zza)));
                        zzajcVar2.zzx = Math.max(zzajcVar2.zzx, zzajmVar.zze);
                    }
                    zzajcVar2.zzE.zzD();
                } else {
                    zzek.zzf(zzajcVar2.zzf.size() == size2);
                    for (int i26 = 0; i26 < size2; i26++) {
                        zzajp zzajpVar2 = (zzajp) listZzd.get(i26);
                        zzajm zzajmVar2 = zzajpVar2.zza;
                        ((zzajb) zzajcVar2.zzf.get(zzajmVar2.zza)).zzh(zzajpVar2, zzj(sparseArray2, zzajmVar2.zza));
                    }
                }
            } else {
                if (i19 == 1836019558) {
                    SparseArray sparseArray3 = zzajcVar2.zzf;
                    byte[] bArr4 = zzajcVar2.zzj;
                    int size3 = zzaimVar3.zzc.size();
                    int i27 = 0;
                    while (i27 < size3) {
                        zzaim zzaimVar4 = (zzaim) zzaimVar3.zzc.get(i27);
                        if (zzaimVar4.zzd == 1953653094) {
                            zzain zzainVarZzb = zzaimVar4.zzb(1952868452);
                            zzainVarZzb.getClass();
                            zzfp zzfpVar3 = zzainVarZzb.zza;
                            zzfpVar3.zzK(i22);
                            int iZzg5 = zzfpVar3.zzg();
                            zzajb zzajbVar = (zzajb) sparseArray3.get(zzfpVar3.zzg());
                            if (zzajbVar == null) {
                                zzajbVar = null;
                            } else {
                                if ((iZzg5 & 1) != 0) {
                                    long jZzv = zzfpVar3.zzv();
                                    zzajo zzajoVar2 = zzajbVar.zzb;
                                    zzajoVar2.zzb = jZzv;
                                    zzajoVar2.zzc = jZzv;
                                }
                                zzaix zzaixVar = zzajbVar.zze;
                                zzajbVar.zzb.zza = new zzaix((iZzg5 & 2) != 0 ? zzfpVar3.zzg() - 1 : zzaixVar.zza, (iZzg5 & 8) != 0 ? zzfpVar3.zzg() : zzaixVar.zzb, (iZzg5 & 16) != 0 ? zzfpVar3.zzg() : zzaixVar.zzc, (iZzg5 & 32) != 0 ? zzfpVar3.zzg() : zzaixVar.zzd);
                            }
                            if (zzajbVar == null) {
                                sparseArray = sparseArray3;
                                zzaimVar = zzaimVar3;
                                i11 = size3;
                                i12 = i27;
                                bArr = bArr4;
                            } else {
                                zzajo zzajoVar3 = zzajbVar.zzb;
                                long j15 = zzajoVar3.zzp;
                                boolean z14 = zzajoVar3.zzq;
                                zzajbVar.zzi();
                                zzajbVar.zzl = true;
                                zzain zzainVarZzb2 = zzaimVar4.zzb(1952867444);
                                if (zzainVarZzb2 != null) {
                                    zzfp zzfpVar4 = zzainVarZzb2.zza;
                                    zzfpVar4.zzK(i22);
                                    zzajoVar3.zzp = zzaio.zze(zzfpVar4.zzg()) == 1 ? zzfpVar4.zzv() : zzfpVar4.zzu();
                                    zzajoVar3.zzq = true;
                                } else {
                                    zzajoVar3.zzp = j15;
                                    zzajoVar3.zzq = z14;
                                }
                                List list = zzaimVar4.zzb;
                                int size4 = list.size();
                                int i28 = 0;
                                int i29 = 0;
                                int i31 = 0;
                                while (true) {
                                    i13 = 1953658222;
                                    if (i28 >= size4) {
                                        break;
                                    }
                                    zzain zzainVar2 = (zzain) list.get(i28);
                                    SparseArray sparseArray4 = sparseArray3;
                                    if (zzainVar2.zzd == 1953658222) {
                                        zzfp zzfpVar5 = zzainVar2.zza;
                                        zzfpVar5.zzK(12);
                                        int iZzp = zzfpVar5.zzp();
                                        if (iZzp > 0) {
                                            i31 += iZzp;
                                            i29++;
                                        }
                                    }
                                    i28++;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                zzajbVar.zzh = 0;
                                zzajbVar.zzg = 0;
                                zzajbVar.zzf = 0;
                                zzajo zzajoVar4 = zzajbVar.zzb;
                                zzajoVar4.zzd = i29;
                                zzajoVar4.zze = i31;
                                if (zzajoVar4.zzg.length < i29) {
                                    zzajoVar4.zzf = new long[i29];
                                    zzajoVar4.zzg = new int[i29];
                                }
                                if (zzajoVar4.zzh.length < i31) {
                                    int i32 = (i31 * 125) / 100;
                                    zzajoVar4.zzh = new int[i32];
                                    zzajoVar4.zzi = new long[i32];
                                    zzajoVar4.zzj = new boolean[i32];
                                    zzajoVar4.zzl = new boolean[i32];
                                }
                                int i33 = 0;
                                int i34 = 0;
                                int i35 = 0;
                                while (i33 < size4) {
                                    zzain zzainVar3 = (zzain) list.get(i33);
                                    if (zzainVar3.zzd == i13) {
                                        int i36 = i34 + 1;
                                        zzfp zzfpVar6 = zzainVar3.zza;
                                        zzfpVar6.zzK(8);
                                        int iZzg6 = zzfpVar6.zzg();
                                        zzajm zzajmVar3 = zzajbVar.zzd.zza;
                                        zzajo zzajoVar5 = zzajbVar.zzb;
                                        zzaix zzaixVar2 = zzajoVar5.zza;
                                        int i37 = zzfy.zza;
                                        zzajoVar5.zzg[i34] = zzfpVar6.zzp();
                                        long[] jArr3 = zzajoVar5.zzf;
                                        long j16 = zzajoVar5.zzb;
                                        jArr3[i34] = j16;
                                        if ((iZzg6 & 1) != 0) {
                                            jArr3[i34] = j16 + ((long) zzfpVar6.zzg());
                                        }
                                        boolean z15 = (iZzg6 & 4) != 0;
                                        int iZzg7 = zzaixVar2.zzd;
                                        if (z15) {
                                            iZzg7 = zzfpVar6.zzg();
                                        }
                                        int i38 = iZzg6 & 256;
                                        int i39 = iZzg6 & 512;
                                        int i40 = iZzg6 & 1024;
                                        int i41 = iZzg6 & 2048;
                                        int i42 = iZzg7;
                                        long[] jArr4 = zzajmVar3.zzh;
                                        if (jArr4 != null) {
                                            i15 = i27;
                                            zzaimVar2 = zzaimVar4;
                                            if (jArr4.length != 1 || (jArr2 = zzajmVar3.zzi) == null) {
                                                z12 = z15;
                                                i16 = i41;
                                            } else {
                                                long j17 = jArr4[0];
                                                if (j17 == 0) {
                                                    z12 = z15;
                                                    i16 = i41;
                                                } else {
                                                    long jZzs2 = zzfy.zzs(j17 + jArr2[0], 1000000L, zzajmVar3.zzd, RoundingMode.FLOOR);
                                                    z12 = z15;
                                                    i16 = i41;
                                                    if (jZzs2 < zzajmVar3.zze) {
                                                    }
                                                    iArr = zzajoVar5.zzh;
                                                    jArr = zzajoVar5.zzi;
                                                    zArr = zzajoVar5.zzj;
                                                    i17 = zzajoVar5.zzg[i34] + i35;
                                                    zzajo zzajoVar6 = zzajoVar3;
                                                    j13 = zzajmVar3.zzc;
                                                    zzajoVar = zzajoVar6;
                                                    j14 = zzajoVar5.zzp;
                                                    while (i35 < i17) {
                                                        if (i38 != 0) {
                                                            iZzg = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg = zzaixVar2.zzb;
                                                        }
                                                        zza(iZzg);
                                                        if (i39 != 0) {
                                                            iZzg2 = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg2 = zzaixVar2.zzc;
                                                        }
                                                        zza(iZzg2);
                                                        if (i40 != 0) {
                                                            i18 = i17;
                                                            iZzg3 = zzfpVar6.zzg();
                                                        } else {
                                                            i18 = i17;
                                                            if (i35 != 0) {
                                                                iZzg3 = zzaixVar2.zzd;
                                                            } else if (z12) {
                                                                iZzg3 = i42;
                                                                i35 = 0;
                                                            } else {
                                                                i35 = 0;
                                                                iZzg3 = zzaixVar2.zzd;
                                                            }
                                                        }
                                                        if (i16 != 0) {
                                                            iZzg4 = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg4 = 0;
                                                        }
                                                        jZzs = zzfy.zzs((((long) iZzg4) + j14) - j12, 1000000L, j13, RoundingMode.FLOOR);
                                                        jArr[i35] = jZzs;
                                                        long j18 = j13;
                                                        if (!zzajoVar5.zzq) {
                                                            jArr[i35] = jZzs + zzajbVar.zzd.zzh;
                                                        }
                                                        iArr[i35] = iZzg2;
                                                        if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                            z13 = false;
                                                        } else {
                                                            z13 = true;
                                                        }
                                                        zArr[i35] = z13;
                                                        j14 += (long) iZzg;
                                                        i35++;
                                                        j13 = j18;
                                                        i38 = i38;
                                                        i39 = i39;
                                                        i17 = i18;
                                                        z12 = z12;
                                                        zzaixVar2 = zzaixVar2;
                                                    }
                                                    int i43 = i17;
                                                    zzajoVar5.zzp = j14;
                                                    i34 = i36;
                                                    i35 = i43;
                                                }
                                                j12 = zzajmVar3.zzi[0];
                                                iArr = zzajoVar5.zzh;
                                                jArr = zzajoVar5.zzi;
                                                zArr = zzajoVar5.zzj;
                                                i17 = zzajoVar5.zzg[i34] + i35;
                                                zzajo zzajoVar7 = zzajoVar3;
                                                j13 = zzajmVar3.zzc;
                                                zzajoVar = zzajoVar7;
                                                j14 = zzajoVar5.zzp;
                                                while (i35 < i17) {
                                                    if (i38 != 0) {
                                                        iZzg = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg = zzaixVar2.zzb;
                                                    }
                                                    zza(iZzg);
                                                    if (i39 != 0) {
                                                        iZzg2 = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg2 = zzaixVar2.zzc;
                                                    }
                                                    zza(iZzg2);
                                                    if (i40 != 0) {
                                                        i18 = i17;
                                                        iZzg3 = zzfpVar6.zzg();
                                                    } else {
                                                        i18 = i17;
                                                        if (i35 != 0) {
                                                            iZzg3 = zzaixVar2.zzd;
                                                        } else if (z12) {
                                                            iZzg3 = i42;
                                                            i35 = 0;
                                                        } else {
                                                            i35 = 0;
                                                            iZzg3 = zzaixVar2.zzd;
                                                        }
                                                    }
                                                    if (i16 != 0) {
                                                        iZzg4 = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg4 = 0;
                                                    }
                                                    jZzs = zzfy.zzs((((long) iZzg4) + j14) - j12, 1000000L, j13, RoundingMode.FLOOR);
                                                    jArr[i35] = jZzs;
                                                    long j19 = j13;
                                                    if (!zzajoVar5.zzq) {
                                                        jArr[i35] = jZzs + zzajbVar.zzd.zzh;
                                                    }
                                                    iArr[i35] = iZzg2;
                                                    if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                        z13 = false;
                                                    } else {
                                                        z13 = true;
                                                    }
                                                    zArr[i35] = z13;
                                                    j14 += (long) iZzg;
                                                    i35++;
                                                    j13 = j19;
                                                    i38 = i38;
                                                    i39 = i39;
                                                    i17 = i18;
                                                    z12 = z12;
                                                    zzaixVar2 = zzaixVar2;
                                                }
                                                int i44 = i17;
                                                zzajoVar5.zzp = j14;
                                                i34 = i36;
                                                i35 = i44;
                                            }
                                        } else {
                                            i15 = i27;
                                            i16 = i41;
                                            zzaimVar2 = zzaimVar4;
                                            z12 = z15;
                                        }
                                        j12 = 0;
                                        iArr = zzajoVar5.zzh;
                                        jArr = zzajoVar5.zzi;
                                        zArr = zzajoVar5.zzj;
                                        i17 = zzajoVar5.zzg[i34] + i35;
                                        zzajo zzajoVar8 = zzajoVar3;
                                        j13 = zzajmVar3.zzc;
                                        zzajoVar = zzajoVar8;
                                        j14 = zzajoVar5.zzp;
                                        while (i35 < i17) {
                                            if (i38 != 0) {
                                                iZzg = zzfpVar6.zzg();
                                            } else {
                                                iZzg = zzaixVar2.zzb;
                                            }
                                            zza(iZzg);
                                            if (i39 != 0) {
                                                iZzg2 = zzfpVar6.zzg();
                                            } else {
                                                iZzg2 = zzaixVar2.zzc;
                                            }
                                            zza(iZzg2);
                                            if (i40 != 0) {
                                                i18 = i17;
                                                iZzg3 = zzfpVar6.zzg();
                                            } else {
                                                i18 = i17;
                                                if (i35 != 0) {
                                                    iZzg3 = zzaixVar2.zzd;
                                                } else if (z12) {
                                                    iZzg3 = i42;
                                                    i35 = 0;
                                                } else {
                                                    i35 = 0;
                                                    iZzg3 = zzaixVar2.zzd;
                                                }
                                            }
                                            if (i16 != 0) {
                                                iZzg4 = zzfpVar6.zzg();
                                            } else {
                                                iZzg4 = 0;
                                            }
                                            jZzs = zzfy.zzs((((long) iZzg4) + j14) - j12, 1000000L, j13, RoundingMode.FLOOR);
                                            jArr[i35] = jZzs;
                                            long j110 = j13;
                                            if (!zzajoVar5.zzq) {
                                                jArr[i35] = jZzs + zzajbVar.zzd.zzh;
                                            }
                                            iArr[i35] = iZzg2;
                                            if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                z13 = false;
                                            } else {
                                                z13 = true;
                                            }
                                            zArr[i35] = z13;
                                            j14 += (long) iZzg;
                                            i35++;
                                            j13 = j110;
                                            i38 = i38;
                                            i39 = i39;
                                            i17 = i18;
                                            z12 = z12;
                                            zzaixVar2 = zzaixVar2;
                                        }
                                        int i45 = i17;
                                        zzajoVar5.zzp = j14;
                                        i34 = i36;
                                        i35 = i45;
                                    } else {
                                        i33 = i33;
                                        zzajoVar = zzajoVar3;
                                        i15 = i27;
                                        zzaimVar2 = zzaimVar4;
                                    }
                                    i33++;
                                    list = list;
                                    size3 = size3;
                                    size4 = size4;
                                    zzaimVar3 = zzaimVar3;
                                    bArr4 = bArr4;
                                    i27 = i15;
                                    zzaimVar4 = zzaimVar2;
                                    zzajoVar3 = zzajoVar;
                                    i13 = 1953658222;
                                }
                                zzaimVar = zzaimVar3;
                                byte[] bArr5 = bArr4;
                                zzajo zzajoVar9 = zzajoVar3;
                                i11 = size3;
                                i12 = i27;
                                zzaim zzaimVar5 = zzaimVar4;
                                zzajm zzajmVar4 = zzajbVar.zzd.zza;
                                zzaix zzaixVar3 = zzajoVar9.zza;
                                zzaixVar3.getClass();
                                zzajn zzajnVarZza = zzajmVar4.zza(zzaixVar3.zza);
                                zzain zzainVarZzb3 = zzaimVar5.zzb(1935763834);
                                if (zzainVarZzb3 != null) {
                                    zzajnVarZza.getClass();
                                    zzfp zzfpVar7 = zzainVarZzb3.zza;
                                    zzfpVar7.zzK(8);
                                    if ((zzfpVar7.zzg() & 1) == 1) {
                                        zzfpVar7.zzL(8);
                                    }
                                    int iZzm = zzfpVar7.zzm();
                                    int iZzp2 = zzfpVar7.zzp();
                                    int i46 = zzajoVar9.zze;
                                    if (iZzp2 > i46) {
                                        throw zzcc.zza("Saiz sample count " + iZzp2 + " is greater than fragment sample count" + i46, null);
                                    }
                                    int i47 = zzajnVarZza.zzd;
                                    if (iZzm == 0) {
                                        boolean[] zArr2 = zzajoVar9.zzl;
                                        i14 = 0;
                                        for (int i48 = 0; i48 < iZzp2; i48++) {
                                            int iZzm2 = zzfpVar7.zzm();
                                            i14 += iZzm2;
                                            zArr2[i48] = iZzm2 > i47;
                                        }
                                        z11 = false;
                                    } else {
                                        boolean z16 = iZzm > i47;
                                        i14 = iZzm * iZzp2;
                                        z11 = false;
                                        Arrays.fill(zzajoVar9.zzl, 0, iZzp2, z16);
                                    }
                                    Arrays.fill(zzajoVar9.zzl, iZzp2, zzajoVar9.zze, z11);
                                    if (i14 > 0) {
                                        zzajoVar9.zza(i14);
                                    }
                                }
                                zzain zzainVarZzb4 = zzaimVar5.zzb(1935763823);
                                if (zzainVarZzb4 != null) {
                                    zzfp zzfpVar8 = zzainVarZzb4.zza;
                                    zzfpVar8.zzK(8);
                                    int iZzg8 = zzfpVar8.zzg();
                                    if ((iZzg8 & 1) == 1) {
                                        zzfpVar8.zzL(8);
                                    }
                                    int iZzp3 = zzfpVar8.zzp();
                                    if (iZzp3 != 1) {
                                        throw zzcc.zza("Unexpected saio entry count: " + iZzp3, null);
                                    }
                                    zzajoVar9.zzc += zzaio.zze(iZzg8) == 0 ? zzfpVar8.zzu() : zzfpVar8.zzv();
                                }
                                zzain zzainVarZzb5 = zzaimVar5.zzb(1936027235);
                                if (zzainVarZzb5 != null) {
                                    zzh(zzainVarZzb5.zza, 0, zzajoVar9);
                                }
                                String str = zzajnVarZza != null ? zzajnVarZza.zzb : null;
                                zzfp zzfpVar9 = null;
                                zzfp zzfpVar10 = null;
                                for (int i49 = 0; i49 < zzaimVar5.zzb.size(); i49++) {
                                    zzain zzainVar4 = (zzain) zzaimVar5.zzb.get(i49);
                                    zzfp zzfpVar11 = zzainVar4.zza;
                                    int i50 = zzainVar4.zzd;
                                    if (i50 == 1935828848) {
                                        zzfpVar11.zzK(12);
                                        if (zzfpVar11.zzg() == 1936025959) {
                                            zzfpVar9 = zzfpVar11;
                                        }
                                    } else if (i50 == 1936158820) {
                                        zzfpVar11.zzK(12);
                                        if (zzfpVar11.zzg() == 1936025959) {
                                            zzfpVar10 = zzfpVar11;
                                        }
                                    }
                                }
                                if (zzfpVar9 != null && zzfpVar10 != null) {
                                    zzfpVar9.zzK(8);
                                    int iZze = zzaio.zze(zzfpVar9.zzg());
                                    zzfpVar9.zzL(4);
                                    if (iZze == 1) {
                                        zzfpVar9.zzL(4);
                                    }
                                    if (zzfpVar9.zzg() != 1) {
                                        throw zzcc.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzfpVar10.zzK(8);
                                    int iZze2 = zzaio.zze(zzfpVar10.zzg());
                                    zzfpVar10.zzL(4);
                                    if (iZze2 == 1) {
                                        if (zzfpVar10.zzu() == 0) {
                                            throw zzcc.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZze2 >= 2) {
                                        zzfpVar10.zzL(4);
                                    }
                                    if (zzfpVar10.zzu() != 1) {
                                        throw zzcc.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    zzfpVar10.zzL(1);
                                    int iZzm3 = zzfpVar10.zzm();
                                    int i51 = (iZzm3 & 240) >> 4;
                                    int i52 = iZzm3 & 15;
                                    if (zzfpVar10.zzm() == 1) {
                                        int iZzm4 = zzfpVar10.zzm();
                                        byte[] bArr6 = new byte[16];
                                        zzfpVar10.zzG(bArr6, 0, 16);
                                        if (iZzm4 == 0) {
                                            int iZzm5 = zzfpVar10.zzm();
                                            byte[] bArr7 = new byte[iZzm5];
                                            zzfpVar10.zzG(bArr7, 0, iZzm5);
                                            bArr3 = bArr7;
                                        } else {
                                            bArr3 = null;
                                        }
                                        zzajoVar9.zzk = true;
                                        zzajoVar9.zzm = new zzajn(true, str, iZzm4, bArr6, i51, i52, bArr3);
                                    }
                                }
                                int size5 = zzaimVar5.zzb.size();
                                int i53 = 0;
                                while (i53 < size5) {
                                    zzain zzainVar5 = (zzain) zzaimVar5.zzb.get(i53);
                                    if (zzainVar5.zzd == 1970628964) {
                                        zzfp zzfpVar12 = zzainVar5.zza;
                                        zzfpVar12.zzK(8);
                                        bArr2 = bArr5;
                                        zzfpVar12.zzG(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zzb)) {
                                            zzh(zzfpVar12, 16, zzajoVar9);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i53++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                            }
                        } else {
                            sparseArray = sparseArray3;
                            zzaimVar = zzaimVar3;
                            i11 = size3;
                            i12 = i27;
                            bArr = bArr4;
                        }
                        bArr4 = bArr;
                        size3 = i11;
                        zzaimVar3 = zzaimVar;
                        i22 = 8;
                        i27 = i12 + 1;
                        sparseArray3 = sparseArray;
                    }
                    zzae zzaeVarZzf2 = zzf(zzaimVar3.zzb);
                    zzajcVar = this;
                    if (zzaeVarZzf2 != null) {
                        int size6 = zzajcVar.zzf.size();
                        for (int i54 = 0; i54 < size6; i54++) {
                            zzajb zzajbVar2 = (zzajb) zzajcVar.zzf.valueAt(i54);
                            zzajm zzajmVar5 = zzajbVar2.zzd.zza;
                            zzaix zzaixVar4 = zzajbVar2.zzb.zza;
                            int i55 = zzfy.zza;
                            zzajn zzajnVarZza2 = zzajmVar5.zza(zzaixVar4.zza);
                            zzae zzaeVarZzb = zzaeVarZzf2.zzb(zzajnVarZza2 != null ? zzajnVarZza2.zzb : null);
                            zzak zzakVarZzb = zzajbVar2.zzd.zza.zzf.zzb();
                            zzakVarZzb.zzE(zzaeVarZzb);
                            zzajbVar2.zza.zzl(zzakVarZzb.zzac());
                        }
                    }
                    if (zzajcVar.zzw != C.TIME_UNSET) {
                        int size7 = zzajcVar.zzf.size();
                        for (int i56 = 0; i56 < size7; i56++) {
                            zzajb zzajbVar3 = (zzajb) zzajcVar.zzf.valueAt(i56);
                            long j21 = zzajcVar.zzw;
                            int i57 = zzajbVar3.zzf;
                            while (true) {
                                zzajo zzajoVar10 = zzajbVar3.zzb;
                                if (i57 >= zzajoVar10.zze || zzajoVar10.zzi[i57] > j21) {
                                    break;
                                }
                                if (zzajoVar10.zzj[i57]) {
                                    zzajbVar3.zzi = i57;
                                }
                                i57++;
                            }
                        }
                        zzajcVar.zzw = C.TIME_UNSET;
                    }
                } else {
                    zzajcVar = zzajcVar2;
                    if (!zzajcVar.zzn.isEmpty()) {
                        ((zzaim) zzajcVar.zzn.peek()).zzc(zzaimVar3);
                    }
                }
                zzajcVar2 = zzajcVar;
            }
        }
        zzg();
    }

    private static final zzaix zzj(SparseArray sparseArray, int i11) {
        if (sparseArray.size() == 1) {
            return (zzaix) sparseArray.valueAt(0);
        }
        zzaix zzaixVar = (zzaix) sparseArray.get(i11);
        zzaixVar.getClass();
        return zzaixVar;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x025a  */
    /* JADX WARN: Code duplicated, block: B:105:0x026f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0276  */
    /* JADX WARN: Code duplicated, block: B:111:0x0290  */
    /* JADX WARN: Code duplicated, block: B:391:0x0234 A[EDGE_INSN: B:391:0x0234->B:96:0x0234 BREAK  A[LOOP:7: B:63:0x0140->B:65:0x0146], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0140 A[LOOP:7: B:63:0x0140->B:65:0x0146, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:65:0x0146 A[LOOP:7: B:63:0x0140->B:65:0x0146, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0151  */
    /* JADX WARN: Code duplicated, block: B:69:0x0169  */
    /* JADX WARN: Code duplicated, block: B:71:0x016f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0182  */
    /* JADX WARN: Code duplicated, block: B:75:0x019b  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:94:0x0221  */
    /* JADX WARN: Code duplicated, block: B:98:0x023e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0243  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v10 */
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
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i11;
        ?? r11;
        zzajb zzajbVar;
        zzajm zzajmVar;
        zzaea zzaeaVar;
        long jZze;
        int i12;
        byte[] bArrZzM;
        int i13;
        int i14;
        int i15;
        int iZzf;
        int iZzg;
        boolean z11;
        String str;
        zzajn zzajnVarZzf;
        zzadz zzadzVar;
        zzaja zzajaVar;
        long j11;
        int i16;
        int i17;
        int i18;
        int iZzc;
        long jZzs;
        long jZzs2;
        String str2;
        String str3;
        long jZzu;
        long j12;
        long jZzv;
        long jZzv2;
        while (true) {
            int i19 = this.zzp;
            i11 = 1;
            r11 = 0;
            if (i19 == 0) {
                if (this.zzs == 0) {
                    if (!zzacvVar.zzn(this.zzm.zzM(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzs = 8;
                    this.zzm.zzK(0);
                    this.zzr = this.zzm.zzu();
                    this.zzq = this.zzm.zzg();
                }
                long j13 = this.zzr;
                if (j13 == 1) {
                    ((zzack) zzacvVar).zzn(this.zzm.zzM(), 8, 8, false);
                    this.zzs += 8;
                    this.zzr = this.zzm.zzv();
                } else if (j13 == 0) {
                    long jZzd = zzacvVar.zzd();
                    if (jZzd == -1) {
                        jZzd = !this.zzn.isEmpty() ? ((zzaim) this.zzn.peek()).zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzr = (jZzd - zzacvVar.zzf()) + ((long) this.zzs);
                    }
                }
                long j14 = this.zzr;
                long j15 = this.zzs;
                if (j14 < j15) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                long jZzf = zzacvVar.zzf() - j15;
                int i21 = this.zzq;
                if ((i21 == 1836019558 || i21 == 1835295092) && !this.zzH) {
                    this.zzE.zzO(new zzadt(this.zzx, jZzf));
                    this.zzH = true;
                }
                if (this.zzq == 1836019558) {
                    int size = this.zzf.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        zzajo zzajoVar = ((zzajb) this.zzf.valueAt(i22)).zzb;
                        zzajoVar.zzc = jZzf;
                        zzajoVar.zzb = jZzf;
                    }
                }
                int i23 = this.zzq;
                if (i23 == 1835295092) {
                    this.zzz = null;
                    this.zzu = jZzf + this.zzr;
                    this.zzp = 2;
                } else if (i23 == 1836019574 || i23 == 1953653099 || i23 == 1835297121 || i23 == 1835626086 || i23 == 1937007212 || i23 == 1836019558 || i23 == 1953653094 || i23 == 1836475768 || i23 == 1701082227) {
                    long jZzf2 = (zzacvVar.zzf() + this.zzr) - 8;
                    this.zzn.push(new zzaim(i23, jZzf2));
                    if (this.zzr == this.zzs) {
                        zzi(jZzf2);
                    } else {
                        zzg();
                    }
                } else if (i23 == 1751411826 || i23 == 1835296868 || i23 == 1836476516 || i23 == 1936286840 || i23 == 1937011556 || i23 == 1937011827 || i23 == 1668576371 || i23 == 1937011555 || i23 == 1937011578 || i23 == 1937013298 || i23 == 1937007471 || i23 == 1668232756 || i23 == 1937011571 || i23 == 1952867444 || i23 == 1952868452 || i23 == 1953196132 || i23 == 1953654136 || i23 == 1953658222 || i23 == 1886614376 || i23 == 1935763834 || i23 == 1935763823 || i23 == 1936027235 || i23 == 1970628964 || i23 == 1935828848 || i23 == 1936158820 || i23 == 1701606260 || i23 == 1835362404 || i23 == 1701671783) {
                    if (this.zzs != 8) {
                        throw zzcc.zzc("Leaf atom defines extended atom size (unsupported).");
                    }
                    if (this.zzr > 2147483647L) {
                        throw zzcc.zzc("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    zzfp zzfpVar = new zzfp((int) this.zzr);
                    System.arraycopy(this.zzm.zzM(), 0, zzfpVar.zzM(), 0, 8);
                    this.zzt = zzfpVar;
                    this.zzp = 1;
                } else {
                    if (this.zzr > 2147483647L) {
                        throw zzcc.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.zzt = null;
                    this.zzp = 1;
                }
            } else if (i19 != 1) {
                long j16 = Long.MAX_VALUE;
                if (i19 != 2) {
                    zzajbVar = this.zzz;
                    if (zzajbVar != null) {
                        break;
                    }
                    SparseArray sparseArray = this.zzf;
                    int size2 = sparseArray.size();
                    long j17 = Long.MAX_VALUE;
                    zzajb zzajbVar2 = null;
                    for (int i24 = 0; i24 < size2; i24++) {
                        zzajb zzajbVar3 = (zzajb) sparseArray.valueAt(i24);
                        if ((zzajbVar3.zzl || zzajbVar3.zzf != zzajbVar3.zzd.zzb) && (!zzajbVar3.zzl || zzajbVar3.zzh != zzajbVar3.zzb.zzd)) {
                            long jZzd2 = zzajbVar3.zzd();
                            if (jZzd2 < j17) {
                                zzajbVar2 = zzajbVar3;
                                j17 = jZzd2;
                            }
                        }
                    }
                    if (zzajbVar2 != null) {
                        int iZzd = (int) (zzajbVar2.zzd() - zzacvVar.zzf());
                        if (iZzd < 0) {
                            zzff.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZzd = 0;
                        }
                        ((zzack) zzacvVar).zzo(iZzd, false);
                        this.zzz = zzajbVar2;
                        zzajbVar = zzajbVar2;
                        break;
                    }
                    int iZzf2 = (int) (this.zzu - zzacvVar.zzf());
                    if (iZzf2 < 0) {
                        throw zzcc.zza("Offset to end of mdat was negative.", null);
                    }
                    ((zzack) zzacvVar).zzo(iZzf2, false);
                    zzg();
                } else {
                    int size3 = this.zzf.size();
                    zzajb zzajbVar4 = null;
                    for (int i25 = 0; i25 < size3; i25++) {
                        zzajo zzajoVar2 = ((zzajb) this.zzf.valueAt(i25)).zzb;
                        if (zzajoVar2.zzo) {
                            long j18 = zzajoVar2.zzc;
                            if (j18 < j16) {
                                zzajbVar4 = (zzajb) this.zzf.valueAt(i25);
                                j16 = j18;
                            }
                        }
                    }
                    if (zzajbVar4 == null) {
                        this.zzp = 3;
                    } else {
                        int iZzf3 = (int) (j16 - zzacvVar.zzf());
                        if (iZzf3 < 0) {
                            throw zzcc.zza("Offset to encryption data was negative.", null);
                        }
                        zzack zzackVar = (zzack) zzacvVar;
                        zzackVar.zzo(iZzf3, false);
                        zzajo zzajoVar3 = zzajbVar4.zzb;
                        zzfp zzfpVar2 = zzajoVar3.zzn;
                        zzackVar.zzn(zzfpVar2.zzM(), 0, zzfpVar2.zze(), false);
                        zzajoVar3.zzn.zzK(0);
                        zzajoVar3.zzo = false;
                    }
                }
            } else {
                int i26 = ((int) this.zzr) - this.zzs;
                zzfp zzfpVar3 = this.zzt;
                if (zzfpVar3 != null) {
                    ((zzack) zzacvVar).zzn(zzfpVar3.zzM(), 8, i26, false);
                    zzain zzainVar = new zzain(this.zzq, zzfpVar3);
                    long jZzf3 = zzacvVar.zzf();
                    if (this.zzn.isEmpty()) {
                        int i27 = zzainVar.zzd;
                        if (i27 == 1936286840) {
                            zzfp zzfpVar4 = zzainVar.zza;
                            zzfpVar4.zzK(8);
                            int iZze = zzaio.zze(zzfpVar4.zzg());
                            zzfpVar4.zzL(4);
                            long jZzu2 = zzfpVar4.zzu();
                            if (iZze == 0) {
                                jZzv = zzfpVar4.zzu();
                                jZzv2 = zzfpVar4.zzu();
                            } else {
                                jZzv = zzfpVar4.zzv();
                                jZzv2 = zzfpVar4.zzv();
                            }
                            long j19 = jZzf3 + jZzv2;
                            long jZzs3 = zzfy.zzs(jZzv, 1000000L, jZzu2, RoundingMode.FLOOR);
                            zzfpVar4.zzL(2);
                            int iZzq = zzfpVar4.zzq();
                            int[] iArr = new int[iZzq];
                            long[] jArr = new long[iZzq];
                            long[] jArr2 = new long[iZzq];
                            long[] jArr3 = new long[iZzq];
                            long jZzs4 = jZzs3;
                            int i28 = 0;
                            while (i28 < iZzq) {
                                int iZzg2 = zzfpVar4.zzg();
                                if ((iZzg2 & Integer.MIN_VALUE) != 0) {
                                    throw zzcc.zza("Unhandled indirect reference", null);
                                }
                                long jZzu3 = zzfpVar4.zzu();
                                iArr[i28] = iZzg2 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                                jArr[i28] = j19;
                                jArr3[i28] = jZzs4;
                                long j21 = jZzv + jZzu3;
                                long[] jArr4 = jArr3;
                                int i29 = i28;
                                long[] jArr5 = jArr2;
                                int[] iArr2 = iArr;
                                jZzs4 = zzfy.zzs(j21, 1000000L, jZzu2, RoundingMode.FLOOR);
                                jArr5[i29] = jZzs4 - jArr4[i29];
                                zzfpVar4.zzL(4);
                                j19 += (long) iArr2[i29];
                                i28 = i29 + 1;
                                iArr = iArr2;
                                jArr2 = jArr5;
                                jArr3 = jArr4;
                                jZzv = j21;
                                jArr = jArr;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jZzs3), new zzaci(iArr, jArr, jArr2, jArr3));
                            this.zzy = ((Long) pairCreate.first).longValue();
                            this.zzE.zzO((zzadu) pairCreate.second);
                            this.zzH = true;
                        } else if (i27 == 1701671783) {
                            zzfp zzfpVar5 = zzainVar.zza;
                            if (this.zzF.length != 0) {
                                zzfpVar5.zzK(8);
                                int iZze2 = zzaio.zze(zzfpVar5.zzg());
                                if (iZze2 == 0) {
                                    String strZzx = zzfpVar5.zzx((char) 0);
                                    strZzx.getClass();
                                    String strZzx2 = zzfpVar5.zzx((char) 0);
                                    strZzx2.getClass();
                                    long jZzu4 = zzfpVar5.zzu();
                                    long jZzu5 = zzfpVar5.zzu();
                                    RoundingMode roundingMode = RoundingMode.FLOOR;
                                    jZzs = zzfy.zzs(jZzu5, 1000000L, jZzu4, roundingMode);
                                    long j22 = this.zzy;
                                    long j23 = j22 != C.TIME_UNSET ? j22 + jZzs : -9223372036854775807L;
                                    jZzs2 = zzfy.zzs(zzfpVar5.zzu(), 1000L, jZzu4, roundingMode);
                                    str2 = strZzx;
                                    str3 = strZzx2;
                                    jZzu = zzfpVar5.zzu();
                                    j12 = j23;
                                } else if (iZze2 != 1) {
                                    zzff.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iZze2);
                                } else {
                                    long jZzu6 = zzfpVar5.zzu();
                                    long jZzv3 = zzfpVar5.zzv();
                                    RoundingMode roundingMode2 = RoundingMode.FLOOR;
                                    long jZzs5 = zzfy.zzs(jZzv3, 1000000L, jZzu6, roundingMode2);
                                    long jZzs6 = zzfy.zzs(zzfpVar5.zzu(), 1000L, jZzu6, roundingMode2);
                                    long jZzu7 = zzfpVar5.zzu();
                                    String strZzx3 = zzfpVar5.zzx((char) 0);
                                    strZzx3.getClass();
                                    String strZzx4 = zzfpVar5.zzx((char) 0);
                                    strZzx4.getClass();
                                    jZzs2 = jZzs6;
                                    jZzu = jZzu7;
                                    str2 = strZzx3;
                                    str3 = strZzx4;
                                    j12 = jZzs5;
                                    jZzs = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzfpVar5.zzb()];
                                zzfpVar5.zzG(bArr, 0, zzfpVar5.zzb());
                                zzfp zzfpVar6 = new zzfp(this.zzl.zza(new zzaft(str2, str3, jZzs2, jZzu, bArr)));
                                int iZzb = zzfpVar6.zzb();
                                for (zzaea zzaeaVar2 : this.zzF) {
                                    zzfpVar6.zzK(0);
                                    zzaeaVar2.zzr(zzfpVar6, iZzb);
                                }
                                if (j12 == C.TIME_UNSET) {
                                    this.zzo.addLast(new zzaja(jZzs, true, iZzb));
                                    this.zzv += iZzb;
                                } else if (this.zzo.isEmpty()) {
                                    for (zzaea zzaeaVar3 : this.zzF) {
                                        zzaeaVar3.zzt(j12, 1, iZzb, 0, null);
                                    }
                                } else {
                                    this.zzo.addLast(new zzaja(j12, false, iZzb));
                                    this.zzv += iZzb;
                                }
                            }
                        }
                    } else {
                        ((zzaim) this.zzn.peek()).zzd(zzainVar);
                    }
                } else {
                    ((zzack) zzacvVar).zzo(i26, false);
                }
                zzi(zzacvVar.zzf());
            }
        }
        char c11 = 6;
        if (this.zzp == 3) {
            int iZzb2 = zzajbVar.zzb();
            this.zzA = iZzb2;
            if (zzajbVar.zzf < zzajbVar.zzi) {
                ((zzack) zzacvVar).zzo(iZzb2, false);
                zzajn zzajnVarZzf2 = zzajbVar.zzf();
                if (zzajnVarZzf2 != null) {
                    zzfp zzfpVar7 = zzajbVar.zzb.zzn;
                    int i31 = zzajnVarZzf2.zzd;
                    if (i31 != 0) {
                        zzfpVar7.zzL(i31);
                    }
                    if (zzajbVar.zzb.zzb(zzajbVar.zzf)) {
                        zzfpVar7.zzL(zzfpVar7.zzq() * 6);
                    }
                }
                if (!zzajbVar.zzk()) {
                    this.zzz = null;
                }
            } else {
                if (zzajbVar.zzd.zza.zzg == 1) {
                    this.zzA = iZzb2 - 8;
                    ((zzack) zzacvVar).zzo(8, false);
                }
                if ("audio/ac4".equals(zzajbVar.zzd.zza.zzf.zzm)) {
                    this.zzB = zzajbVar.zzc(this.zzA, 7);
                    zzaby.zzb(this.zzA, this.zzk);
                    zzajbVar.zza.zzr(this.zzk, 7);
                    iZzc = this.zzB + 7;
                    this.zzB = iZzc;
                } else {
                    iZzc = zzajbVar.zzc(this.zzA, 0);
                    this.zzB = iZzc;
                }
                this.zzA += iZzc;
                this.zzp = 4;
                this.zzC = 0;
                zzajmVar = zzajbVar.zzd.zza;
                zzaeaVar = zzajbVar.zza;
                jZze = zzajbVar.zze();
                i12 = zzajmVar.zzj;
                if (i12 == 0) {
                    while (true) {
                        i17 = this.zzB;
                        i18 = this.zzA;
                        if (i17 < i18) {
                            break;
                        }
                        this.zzB += zzaeaVar.zzf(zzacvVar, i18 - i17, false);
                    }
                } else {
                    bArrZzM = this.zzh.zzM();
                    bArrZzM[0] = 0;
                    bArrZzM[1] = 0;
                    bArrZzM[2] = 0;
                    i13 = i12 + 1;
                    i14 = 4 - i12;
                    while (this.zzB < this.zzA) {
                        i15 = this.zzC;
                        if (i15 == 0) {
                            ((zzack) zzacvVar).zzn(bArrZzM, i14, i13, r11);
                            this.zzh.zzK(r11);
                            iZzg = this.zzh.zzg();
                            if (iZzg > 0) {
                                throw zzcc.zza("Invalid NAL length", null);
                            }
                            this.zzC = iZzg - 1;
                            this.zzg.zzK(r11);
                            zzaeaVar.zzr(this.zzg, 4);
                            zzaeaVar.zzr(this.zzh, i11);
                            if (this.zzG.length > 0) {
                                str = zzajmVar.zzf.zzm;
                                byte b11 = bArrZzM[4];
                                byte[] bArr2 = zzgm.zza;
                                if ((MimeTypes.VIDEO_H264.equals(str) || (b11 & Ascii.US) != c11) && !(MimeTypes.VIDEO_H265.equals(str) && ((b11 & 126) >> i11) == 39)) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                            } else {
                                z11 = false;
                            }
                            this.zzD = z11;
                            this.zzB += 5;
                            this.zzA += i14;
                        } else {
                            if (this.zzD) {
                                this.zzi.zzH(i15);
                                ((zzack) zzacvVar).zzn(this.zzi.zzM(), 0, this.zzC, false);
                                zzaeaVar.zzr(this.zzi, this.zzC);
                                iZzf = this.zzC;
                                zzfp zzfpVar8 = this.zzi;
                                int iZzb3 = zzgm.zzb(zzfpVar8.zzM(), zzfpVar8.zze());
                                this.zzi.zzK(MimeTypes.VIDEO_H265.equals(zzajmVar.zzf.zzm) ? 1 : 0);
                                this.zzi.zzJ(iZzb3);
                                zzach.zza(jZze, this.zzi, this.zzG);
                            } else {
                                iZzf = zzaeaVar.zzf(zzacvVar, i15, false);
                            }
                            this.zzB += iZzf;
                            this.zzC -= iZzf;
                            c11 = 6;
                            i11 = 1;
                        }
                        r11 = 0;
                    }
                }
                int iZza = zzajbVar.zza();
                zzajnVarZzf = zzajbVar.zzf();
                if (zzajnVarZzf != null) {
                    zzadzVar = zzajnVarZzf.zzc;
                } else {
                    zzadzVar = null;
                }
                zzaeaVar.zzt(jZze, iZza, this.zzA, 0, zzadzVar);
                while (!this.zzo.isEmpty()) {
                    zzajaVar = (zzaja) this.zzo.removeFirst();
                    this.zzv -= zzajaVar.zzc;
                    j11 = zzajaVar.zza;
                    if (zzajaVar.zzb) {
                        j11 += jZze;
                    }
                    for (zzaea zzaeaVar4 : this.zzF) {
                        zzaeaVar4.zzt(j11, 1, zzajaVar.zzc, this.zzv, null);
                    }
                }
                if (!zzajbVar.zzk()) {
                    this.zzz = null;
                }
            }
        } else {
            zzajmVar = zzajbVar.zzd.zza;
            zzaeaVar = zzajbVar.zza;
            jZze = zzajbVar.zze();
            i12 = zzajmVar.zzj;
            if (i12 == 0) {
                while (true) {
                    i17 = this.zzB;
                    i18 = this.zzA;
                    if (i17 < i18) {
                        break;
                        break;
                    }
                    this.zzB += zzaeaVar.zzf(zzacvVar, i18 - i17, false);
                }
            } else {
                bArrZzM = this.zzh.zzM();
                bArrZzM[0] = 0;
                bArrZzM[1] = 0;
                bArrZzM[2] = 0;
                i13 = i12 + 1;
                i14 = 4 - i12;
                while (this.zzB < this.zzA) {
                    i15 = this.zzC;
                    if (i15 == 0) {
                        ((zzack) zzacvVar).zzn(bArrZzM, i14, i13, r11);
                        this.zzh.zzK(r11);
                        iZzg = this.zzh.zzg();
                        if (iZzg > 0) {
                            throw zzcc.zza("Invalid NAL length", null);
                        }
                        this.zzC = iZzg - 1;
                        this.zzg.zzK(r11);
                        zzaeaVar.zzr(this.zzg, 4);
                        zzaeaVar.zzr(this.zzh, i11);
                        if (this.zzG.length > 0) {
                            str = zzajmVar.zzf.zzm;
                            byte b12 = bArrZzM[4];
                            byte[] bArr3 = zzgm.zza;
                            if (MimeTypes.VIDEO_H264.equals(str)) {
                                z11 = false;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z11 = false;
                        }
                        this.zzD = z11;
                        this.zzB += 5;
                        this.zzA += i14;
                    } else {
                        if (this.zzD) {
                            this.zzi.zzH(i15);
                            ((zzack) zzacvVar).zzn(this.zzi.zzM(), 0, this.zzC, false);
                            zzaeaVar.zzr(this.zzi, this.zzC);
                            iZzf = this.zzC;
                            zzfp zzfpVar9 = this.zzi;
                            int iZzb4 = zzgm.zzb(zzfpVar9.zzM(), zzfpVar9.zze());
                            this.zzi.zzK(MimeTypes.VIDEO_H265.equals(zzajmVar.zzf.zzm) ? 1 : 0);
                            this.zzi.zzJ(iZzb4);
                            zzach.zza(jZze, this.zzi, this.zzG);
                        } else {
                            iZzf = zzaeaVar.zzf(zzacvVar, i15, false);
                        }
                        this.zzB += iZzf;
                        this.zzC -= iZzf;
                        c11 = 6;
                        i11 = 1;
                    }
                    r11 = 0;
                }
            }
            int iZza2 = zzajbVar.zza();
            zzajnVarZzf = zzajbVar.zzf();
            if (zzajnVarZzf != null) {
                zzadzVar = zzajnVarZzf.zzc;
            } else {
                zzadzVar = null;
            }
            zzaeaVar.zzt(jZze, iZza2, this.zzA, 0, zzadzVar);
            while (!this.zzo.isEmpty()) {
                zzajaVar = (zzaja) this.zzo.removeFirst();
                this.zzv -= zzajaVar.zzc;
                j11 = zzajaVar.zza;
                if (zzajaVar.zzb) {
                    j11 += jZze;
                }
                while (i16 < r6) {
                    zzaeaVar4.zzt(j11, 1, zzajaVar.zzc, this.zzv, null);
                }
            }
            if (!zzajbVar.zzk()) {
                this.zzz = null;
            }
        }
        this.zzp = 3;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzE = zzacxVar;
        zzg();
        zzaea[] zzaeaVarArr = new zzaea[2];
        this.zzF = zzaeaVarArr;
        int i11 = 0;
        zzaea[] zzaeaVarArr2 = (zzaea[]) zzfy.zzL(zzaeaVarArr, 0);
        this.zzF = zzaeaVarArr2;
        for (zzaea zzaeaVar : zzaeaVarArr2) {
            zzaeaVar.zzl(zzc);
        }
        this.zzG = new zzaea[this.zze.size()];
        int i12 = 100;
        while (i11 < this.zzG.length) {
            int i13 = i12 + 1;
            zzaea zzaeaVarZzw = this.zzE.zzw(i12, 3);
            zzaeaVarZzw.zzl((zzam) this.zze.get(i11));
            this.zzG[i11] = zzaeaVarZzw;
            i11++;
            i12 = i13;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        int size = this.zzf.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((zzajb) this.zzf.valueAt(i11)).zzi();
        }
        this.zzo.clear();
        this.zzv = 0;
        this.zzw = j12;
        this.zzn.clear();
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzajl.zza(zzacvVar);
    }
}
