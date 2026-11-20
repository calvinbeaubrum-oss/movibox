package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.view.FlowLayout;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaiw {
    private static final byte[] zza;

    static {
        int i11 = zzfy.zza;
        zza = "OpusHead".getBytes(zzfwq.zzc);
    }

    @Nullable
    public static zzby zza(zzaim zzaimVar) {
        zzgc zzgcVar;
        zzain zzainVarZzb = zzaimVar.zzb(1751411826);
        zzain zzainVarZzb2 = zzaimVar.zzb(1801812339);
        zzain zzainVarZzb3 = zzaimVar.zzb(1768715124);
        if (zzainVarZzb != null && zzainVarZzb2 != null && zzainVarZzb3 != null && zzg(zzainVarZzb.zza) == 1835299937) {
            zzfp zzfpVar = zzainVarZzb2.zza;
            zzfpVar.zzK(12);
            int iZzg = zzfpVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i11 = 0; i11 < iZzg; i11++) {
                int iZzg2 = zzfpVar.zzg();
                zzfpVar.zzL(4);
                strArr[i11] = zzfpVar.zzA(iZzg2 - 8, zzfwq.zzc);
            }
            zzfp zzfpVar2 = zzainVarZzb3.zza;
            zzfpVar2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzfpVar2.zzb() > 8) {
                int iZzd = zzfpVar2.zzd() + zzfpVar2.zzg();
                int iZzg3 = zzfpVar2.zzg() - 1;
                if (iZzg3 < 0 || iZzg3 >= iZzg) {
                    zzff.zzf("AtomParsers", "Skipped metadata with unknown key index: " + iZzg3);
                } else {
                    String str = strArr[iZzg3];
                    int i12 = zzajd.zzb;
                    while (true) {
                        int iZzd2 = zzfpVar2.zzd();
                        if (iZzd2 >= iZzd) {
                            zzgcVar = null;
                            break;
                        }
                        int iZzg4 = zzfpVar2.zzg();
                        if (zzfpVar2.zzg() == 1684108385) {
                            int iZzg5 = zzfpVar2.zzg();
                            int iZzg6 = zzfpVar2.zzg();
                            int i13 = iZzg4 - 16;
                            byte[] bArr = new byte[i13];
                            zzfpVar2.zzG(bArr, 0, i13);
                            zzgcVar = new zzgc(str, bArr, iZzg6, iZzg5);
                            break;
                        }
                        zzfpVar2.zzK(iZzd2 + iZzg4);
                    }
                    if (zzgcVar != null) {
                        arrayList.add(zzgcVar);
                    }
                }
                zzfpVar2.zzK(iZzd);
            }
            if (!arrayList.isEmpty()) {
                return new zzby(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    public static zzby zzb(zzain zzainVar) {
        int iZzn;
        zzfp zzfpVar = zzainVar.zza;
        zzfpVar.zzK(8);
        zzby zzbyVar = new zzby(C.TIME_UNSET, new zzbx[0]);
        while (zzfpVar.zzb() >= 8) {
            int iZzd = zzfpVar.zzd();
            int iZzg = zzfpVar.zzg() + iZzd;
            int iZzg2 = zzfpVar.zzg();
            zzby zzbyVar2 = null;
            if (iZzg2 == 1835365473) {
                zzfpVar.zzK(iZzd);
                zzfpVar.zzL(8);
                zze(zzfpVar);
                while (zzfpVar.zzd() < iZzg) {
                    int iZzd2 = zzfpVar.zzd();
                    int iZzg3 = zzfpVar.zzg() + iZzd2;
                    if (zzfpVar.zzg() == 1768715124) {
                        zzfpVar.zzK(iZzd2);
                        zzfpVar.zzL(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzfpVar.zzd() < iZzg3) {
                            zzbx zzbxVarZza = zzajd.zza(zzfpVar);
                            if (zzbxVarZza != null) {
                                arrayList.add(zzbxVarZza);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzbyVar2 = new zzby(arrayList);
                            break;
                        }
                        break;
                    }
                    zzfpVar.zzK(iZzg3);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzg2 == 1936553057) {
                zzfpVar.zzK(iZzd);
                zzfpVar.zzL(12);
                while (zzfpVar.zzd() < iZzg) {
                    int iZzd3 = zzfpVar.zzd();
                    int iZzg4 = zzfpVar.zzg();
                    if (zzfpVar.zzg() == 1935766900) {
                        if (iZzg4 < 16) {
                            break;
                        }
                        zzfpVar.zzL(4);
                        int i11 = -1;
                        int i12 = 0;
                        for (int i13 = 0; i13 < 2; i13++) {
                            int iZzm = zzfpVar.zzm();
                            int iZzm2 = zzfpVar.zzm();
                            if (iZzm == 0) {
                                i11 = iZzm2;
                            } else if (iZzm == 1) {
                                i12 = iZzm2;
                            }
                        }
                        if (i11 == 12) {
                            iZzn = 240;
                        } else if (i11 == 13) {
                            iZzn = 120;
                        } else if (i11 == 21 && zzfpVar.zzb() >= 8 && zzfpVar.zzd() + 8 <= iZzg) {
                            int iZzg5 = zzfpVar.zzg();
                            int iZzg6 = zzfpVar.zzg();
                            if (iZzg5 < 12 || iZzg6 != 1936877170) {
                                iZzn = -2147483647;
                            } else {
                                iZzn = zzfpVar.zzn();
                            }
                        } else {
                            iZzn = -2147483647;
                        }
                        if (iZzn == -2147483647) {
                            break;
                        }
                        zzbyVar2 = new zzby(C.TIME_UNSET, new zzahm(iZzn, i12));
                        break;
                    }
                    zzfpVar.zzK(iZzd3 + iZzg4);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzg2 == -1451722374) {
                zzbyVar = zzbyVar.zzd(zzi(zzfpVar));
            }
            zzfpVar.zzK(iZzg);
        }
        return zzbyVar;
    }

    public static zzgi zzc(zzfp zzfpVar) {
        long jZzt;
        long jZzt2;
        zzfpVar.zzK(8);
        if (zzaio.zze(zzfpVar.zzg()) == 0) {
            jZzt = zzfpVar.zzu();
            jZzt2 = zzfpVar.zzu();
        } else {
            jZzt = zzfpVar.zzt();
            jZzt2 = zzfpVar.zzt();
        }
        return new zzgi(jZzt, jZzt2, zzfpVar.zzu());
    }

    /* JADX WARN: Code duplicated, block: B:312:0x064a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:313:0x064c  */
    /* JADX WARN: Code duplicated, block: B:314:0x064f  */
    /* JADX WARN: Code duplicated, block: B:358:0x0746  */
    /* JADX WARN: Code duplicated, block: B:359:0x074b  */
    /* JADX WARN: Code duplicated, block: B:362:0x0756 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:363:0x0758  */
    /* JADX WARN: Code duplicated, block: B:364:0x075c  */
    /* JADX WARN: Code duplicated, block: B:366:0x075f  */
    /* JADX WARN: Code duplicated, block: B:369:0x0767  */
    /* JADX WARN: Code duplicated, block: B:372:0x076e  */
    /* JADX WARN: Code duplicated, block: B:374:0x077e  */
    /* JADX WARN: Code duplicated, block: B:376:0x0781  */
    /* JADX WARN: Code duplicated, block: B:378:0x0785 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:379:0x0787  */
    /* JADX WARN: Code duplicated, block: B:380:0x078a  */
    /* JADX WARN: Code duplicated, block: B:382:0x078e  */
    /* JADX WARN: Code duplicated, block: B:386:0x079d  */
    /* JADX WARN: Code duplicated, block: B:387:0x079f  */
    /* JADX WARN: Code duplicated, block: B:519:0x0b11  */
    /* JADX WARN: Code duplicated, block: B:520:0x0b15  */
    /* JADX WARN: Code duplicated, block: B:60:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x0127  */
    /* JADX WARN: Code duplicated, block: B:65:0x012e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0130  */
    /* JADX WARN: Code duplicated, block: B:67:0x0133  */
    /* JADX WARN: Code duplicated, block: B:73:0x013f  */
    /* JADX WARN: Instruction removed from duplicated block: B:369:0x0767, please report this as an issue */
    public static List zzd(zzaim zzaimVar, zzadk zzadkVar, long j11, @Nullable zzae zzaeVar, boolean z11, boolean z12, zzfws zzfwsVar) throws zzcc {
        int i11;
        long jZzs;
        long j12;
        int i12;
        int i13;
        ArrayList arrayList;
        zzaim zzaimVar2;
        long[] jArr;
        long[] jArr2;
        zzajm zzajmVar;
        Pair pairCreate;
        String str;
        zzae zzaeVarZzb;
        int i14;
        String str2;
        byte[] bArrCopyOfRange;
        String str3;
        byte[] bArrArray;
        int i15;
        int i16;
        boolean z13;
        int i17;
        int i18;
        int i19;
        int i21;
        boolean zZzo;
        boolean z14;
        zzt zztVarZzg;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int i22;
        int iZzd4;
        int i23;
        int i24;
        List list;
        float f11;
        boolean z15;
        String str4;
        int i25;
        int i26;
        int i27;
        int i28;
        String str5;
        boolean z16;
        String str6;
        String str7;
        zzgaa zzgaaVarZzm;
        long j13;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int i29 = 0;
        while (i29 < zzaimVar.zzc.size()) {
            zzaim zzaimVar3 = (zzaim) zzaimVar.zzc.get(i29);
            if (zzaimVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i13 = i29;
            } else {
                zzain zzainVarZzb = zzaimVar.zzb(1836476516);
                zzainVarZzb.getClass();
                zzaim zzaimVarZza = zzaimVar3.zza(1835297121);
                zzaimVarZza.getClass();
                zzain zzainVarZzb2 = zzaimVarZza.zzb(1751411826);
                zzainVarZzb2.getClass();
                int iZzg = zzg(zzainVarZzb2.zza);
                if (iZzg == 1936684398) {
                    i11 = 1;
                } else if (iZzg == 1986618469) {
                    i11 = 2;
                } else if (iZzg == 1952807028 || iZzg == 1935832172 || iZzg == 1937072756 || iZzg == 1668047728) {
                    i11 = 3;
                } else {
                    i11 = iZzg == 1835365473 ? 5 : -1;
                }
                if (i11 == -1) {
                    arrayList = arrayList3;
                    i13 = i29;
                    zzaimVar2 = zzaimVar3;
                    zzajmVar = null;
                } else {
                    zzain zzainVarZzb3 = zzaimVar3.zzb(1953196132);
                    zzainVarZzb3.getClass();
                    zzfp zzfpVar = zzainVarZzb3.zza;
                    zzfpVar.zzK(8);
                    int iZze = zzaio.zze(zzfpVar.zzg());
                    zzfpVar.zzL(iZze == 0 ? 8 : 16);
                    int iZzg2 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    int iZzd5 = zzfpVar.zzd();
                    int i31 = 0;
                    while (true) {
                        int i32 = iZze == 0 ? 4 : 8;
                        jZzs = C.TIME_UNSET;
                        if (i31 >= i32) {
                            zzfpVar.zzL(i32);
                        } else {
                            if (zzfpVar.zzM()[iZzd5 + i31] != -1) {
                                long jZzu = iZze == 0 ? zzfpVar.zzu() : zzfpVar.zzv();
                                if (jZzu != 0) {
                                    j12 = jZzu;
                                    break;
                                }
                                break;
                            }
                            i31++;
                        }
                        j12 = -9223372036854775807L;
                        break;
                    }
                    zzfpVar.zzL(16);
                    int iZzg3 = zzfpVar.zzg();
                    int iZzg4 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    int iZzg5 = zzfpVar.zzg();
                    int iZzg6 = zzfpVar.zzg();
                    int i33 = 65536;
                    if (iZzg3 != 0) {
                        if (iZzg3 == 0) {
                            i33 = iZzg5;
                        } else if (iZzg4 == -65536) {
                            if (iZzg5 == 65536) {
                                i33 = iZzg5;
                            } else if (iZzg6 == 0) {
                                i12 = 270;
                            }
                            iZzg3 = 0;
                            iZzg4 = FlowLayout.SPACING_AUTO;
                        } else {
                            i33 = iZzg5;
                            iZzg3 = 0;
                        }
                        if (iZzg3 != -65536 && iZzg4 == 0 && i33 == 0 && iZzg6 == -65536) {
                            i12 = 180;
                        } else {
                            i12 = 0;
                        }
                    } else {
                        if (iZzg4 == 65536) {
                            if (iZzg5 == -65536) {
                                if (iZzg6 == 0) {
                                    i12 = 90;
                                } else {
                                    iZzg5 = FlowLayout.SPACING_AUTO;
                                }
                            }
                            iZzg3 = 0;
                            iZzg4 = 65536;
                        } else {
                            iZzg3 = 0;
                        }
                        if (iZzg3 == 0) {
                            i33 = iZzg5;
                        } else if (iZzg4 == -65536) {
                            if (iZzg5 == 65536) {
                                i33 = iZzg5;
                            } else if (iZzg6 == 0) {
                                i12 = 270;
                            }
                            iZzg3 = 0;
                            iZzg4 = FlowLayout.SPACING_AUTO;
                        } else {
                            i33 = iZzg5;
                            iZzg3 = 0;
                        }
                        if (iZzg3 != -65536) {
                            i12 = 0;
                        } else {
                            i12 = 0;
                        }
                    }
                    zzaiv zzaivVar = new zzaiv(iZzg2, j12, i12);
                    long j14 = j11 == C.TIME_UNSET ? zzaivVar.zzb : j11;
                    long j15 = zzc(zzainVarZzb.zza).zzc;
                    if (j14 != C.TIME_UNSET) {
                        jZzs = zzfy.zzs(j14, 1000000L, j15, RoundingMode.FLOOR);
                    }
                    zzaim zzaimVarZza2 = zzaimVarZza.zza(1835626086);
                    zzaimVarZza2.getClass();
                    zzaim zzaimVarZza3 = zzaimVarZza2.zza(1937007212);
                    zzaimVarZza3.getClass();
                    zzain zzainVarZzb4 = zzaimVarZza.zzb(1835296868);
                    zzainVarZzb4.getClass();
                    zzfp zzfpVar2 = zzainVarZzb4.zza;
                    zzfpVar2.zzK(8);
                    int iZze2 = zzaio.zze(zzfpVar2.zzg());
                    zzfpVar2.zzL(iZze2 == 0 ? 8 : 16);
                    int i34 = iZze2 == 0 ? 4 : 8;
                    long jZzu2 = zzfpVar2.zzu();
                    zzfpVar2.zzL(i34);
                    int iZzq = zzfpVar2.zzq();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((char) (((iZzq >> 10) & 31) + 96));
                    sb2.append((char) (((iZzq >> 5) & 31) + 96));
                    sb2.append((char) ((iZzq & 31) + 96));
                    Pair pairCreate2 = Pair.create(Long.valueOf(jZzu2), sb2.toString());
                    zzain zzainVarZzb5 = zzaimVarZza3.zzb(1937011556);
                    if (zzainVarZzb5 == null) {
                        throw zzcc.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                    }
                    int i35 = zzaivVar.zza;
                    int i36 = zzaivVar.zzc;
                    String str8 = (String) pairCreate2.second;
                    zzfp zzfpVar3 = zzainVarZzb5.zza;
                    zzfpVar3.zzK(12);
                    int iZzg7 = zzfpVar3.zzg();
                    i13 = i29;
                    zzais zzaisVar = new zzais(iZzg7);
                    arrayList = arrayList3;
                    int i37 = 0;
                    while (i37 < iZzg7) {
                        zzaiv zzaivVar2 = zzaivVar;
                        int iZzd6 = zzfpVar3.zzd();
                        zzaim zzaimVar4 = zzaimVar3;
                        int iZzg8 = zzfpVar3.zzg();
                        zzacy.zzb(iZzg8 > 0, "childAtomSize must be positive");
                        int iZzg9 = zzfpVar3.zzg();
                        int i38 = iZzg7;
                        if (iZzg9 == 1635148593 || iZzg9 == 1635148595 || iZzg9 == 1701733238 || iZzg9 == 1831958048 || iZzg9 == 1836070006 || iZzg9 == 1752589105 || iZzg9 == 1751479857 || iZzg9 == 1932670515 || iZzg9 == 1211250227 || iZzg9 == 1987063864 || iZzg9 == 1987063865 || iZzg9 == 1635135537 || iZzg9 == 1685479798 || iZzg9 == 1685479729 || iZzg9 == 1685481573 || iZzg9 == 1685481521) {
                            str = str8;
                            int i39 = i36;
                            i11 = i11;
                            int i40 = i35;
                            pairCreate2 = pairCreate2;
                            j15 = j15;
                            i38 = i38;
                            zzfpVar3.zzK(iZzd6 + 16);
                            zzfpVar3.zzL(16);
                            int iZzq2 = zzfpVar3.zzq();
                            int iZzq3 = zzfpVar3.zzq();
                            zzfpVar3.zzL(50);
                            int iZzd7 = zzfpVar3.zzd();
                            if (iZzg9 == 1701733238) {
                                Pair pairZzh = zzh(zzfpVar3, iZzd6, iZzg8);
                                if (pairZzh != null) {
                                    int iIntValue = ((Integer) pairZzh.first).intValue();
                                    zzaeVarZzb = zzaeVar == null ? null : zzaeVar.zzb(((zzajn) pairZzh.second).zzb);
                                    zzaisVar.zza[i37] = (zzajn) pairZzh.second;
                                    iZzg9 = iIntValue;
                                } else {
                                    zzaeVarZzb = zzaeVar;
                                    iZzg9 = 1701733238;
                                }
                                zzfpVar3.zzK(iZzd7);
                            } else {
                                zzaeVarZzb = zzaeVar;
                            }
                            if (iZzg9 == 1831958048) {
                                int i41 = iZzg9;
                                str2 = MimeTypes.VIDEO_MPEG;
                                i14 = i41;
                            } else {
                                i14 = 1211250227;
                                if (iZzg9 == 1211250227) {
                                    str2 = MimeTypes.VIDEO_H263;
                                } else {
                                    i14 = iZzg9;
                                    str2 = null;
                                }
                            }
                            int i42 = iZzd7;
                            zzae zzaeVar2 = zzaeVarZzb;
                            i37 = i37;
                            ByteBuffer byteBufferZzl = null;
                            float fZzp = 1.0f;
                            String str9 = null;
                            byte[] bArr = null;
                            int iZzb = -1;
                            int iZza = -1;
                            zzaiq zzaiqVar = null;
                            boolean z17 = false;
                            int i43 = 8;
                            int i44 = 8;
                            int i45 = -1;
                            List listZzm = null;
                            int i46 = -1;
                            while (true) {
                                if (i42 - iZzd6 >= iZzg8) {
                                    bArrCopyOfRange = bArr;
                                    break;
                                }
                                zzfpVar3.zzK(i42);
                                int iZzd8 = zzfpVar3.zzd();
                                int iZzg10 = zzfpVar3.zzg();
                                if (iZzg10 == 0) {
                                    bArrCopyOfRange = bArr;
                                    if (zzfpVar3.zzd() - iZzd6 == iZzg8) {
                                        break;
                                    }
                                    i15 = 0;
                                } else {
                                    bArrCopyOfRange = bArr;
                                    i15 = iZzg10;
                                }
                                zzacy.zzb(i15 > 0, "childAtomSize must be positive");
                                int iZzg11 = zzfpVar3.zzg();
                                if (iZzg11 == 1635148611) {
                                    int i47 = iZzd8 + 8;
                                    zzacy.zzb(str2 == null, null);
                                    zzfpVar3.zzK(i47);
                                    zzabz zzabzVarZza = zzabz.zza(zzfpVar3);
                                    list = zzabzVarZza.zza;
                                    zzaisVar.zzc = zzabzVarZza.zzb;
                                    if (z17) {
                                        f11 = fZzp;
                                        z16 = true;
                                    } else {
                                        f11 = zzabzVarZza.zzj;
                                        z16 = false;
                                    }
                                    str4 = zzabzVarZza.zzk;
                                    iZza = zzabzVarZza.zzg;
                                    i25 = zzabzVarZza.zzh;
                                    i26 = zzabzVarZza.zzi;
                                    z17 = z16;
                                    i27 = zzabzVarZza.zze;
                                    i28 = zzabzVarZza.zzf;
                                    str5 = MimeTypes.VIDEO_H264;
                                } else {
                                    if (iZzg11 == 1752589123) {
                                        int i48 = iZzd8 + 8;
                                        zzacy.zzb(str2 == null, null);
                                        zzfpVar3.zzK(i48);
                                        zzadl zzadlVarZza = zzadl.zza(zzfpVar3);
                                        list = zzadlVarZza.zza;
                                        zzaisVar.zzc = zzadlVarZza.zzb;
                                        if (z17) {
                                            f11 = fZzp;
                                            z15 = true;
                                        } else {
                                            f11 = zzadlVarZza.zzh;
                                            z15 = false;
                                        }
                                        str4 = zzadlVarZza.zzi;
                                        iZza = zzadlVarZza.zze;
                                        i25 = zzadlVarZza.zzf;
                                        i26 = zzadlVarZza.zzg;
                                        z17 = z15;
                                        i27 = zzadlVarZza.zzc;
                                        i28 = zzadlVarZza.zzd;
                                        str5 = MimeTypes.VIDEO_H265;
                                    } else if (iZzg11 == 1685480259 || iZzg11 == 1685485123) {
                                        i16 = i14;
                                        iZzq2 = iZzq2;
                                        iZzq3 = iZzq3;
                                        fZzp = fZzp;
                                        str9 = str9;
                                        zzaisVar = zzaisVar;
                                        zzacq zzacqVarZza = zzacq.zza(zzfpVar3);
                                        if (zzacqVarZza != null) {
                                            str2 = "video/dolby-vision";
                                            str9 = zzacqVarZza.zza;
                                            fZzp = fZzp;
                                        } else {
                                            fZzp = fZzp;
                                            str9 = str9;
                                        }
                                    } else if (iZzg11 == 1987076931) {
                                        zzacy.zzb(str2 == null, null);
                                        zzfpVar3.zzK(iZzd8 + 12);
                                        zzfpVar3.zzL(2);
                                        int iZzm = zzfpVar3.zzm();
                                        int i49 = iZzm >> 4;
                                        int i50 = iZzm & 1;
                                        int iZzm2 = zzfpVar3.zzm();
                                        int iZzm3 = zzfpVar3.zzm();
                                        iZza = zzt.zza(iZzm2);
                                        int i51 = 1 != i50 ? 2 : 1;
                                        int iZzb2 = zzt.zzb(iZzm3);
                                        i16 = i14;
                                        i45 = i51;
                                        i43 = i49;
                                        i44 = i43;
                                        str2 = i14 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                                        iZzb = iZzb2;
                                    } else {
                                        i16 = i14;
                                        if (iZzg11 == 1635135811) {
                                            zzfpVar3.zzK(iZzd8 + 8);
                                            zzr zzrVar = new zzr();
                                            byte[] bArrZzM = zzfpVar3.zzM();
                                            zzfo zzfoVar = new zzfo(bArrZzM, bArrZzM.length);
                                            zzfoVar.zzk(zzfpVar3.zzd() * 8);
                                            zzfoVar.zzn(1);
                                            int iZzd9 = zzfoVar.zzd(3);
                                            zzfoVar.zzm(6);
                                            boolean zZzo2 = zzfoVar.zzo();
                                            boolean zZzo3 = zzfoVar.zzo();
                                            if (iZzd9 != 2) {
                                                i17 = 1;
                                                if (iZzd9 <= 2) {
                                                    if (true != zZzo2) {
                                                        i18 = 8;
                                                    } else {
                                                        i18 = 10;
                                                    }
                                                    zzrVar.zzf(i18);
                                                    zzrVar.zza(i18);
                                                }
                                            } else if (zZzo2) {
                                                int i52 = true != zZzo3 ? 10 : 12;
                                                zzrVar.zzf(i52);
                                                zzrVar.zza(i52);
                                                i17 = 1;
                                            } else {
                                                zZzo2 = false;
                                                iZzd9 = 2;
                                                i17 = 1;
                                                if (iZzd9 <= 2) {
                                                    if (true != zZzo2) {
                                                        i18 = 8;
                                                    } else {
                                                        i18 = 10;
                                                    }
                                                    zzrVar.zzf(i18);
                                                    zzrVar.zza(i18);
                                                }
                                            }
                                            zzfoVar.zzm(13);
                                            zzfoVar.zzl();
                                            int iZzd10 = zzfoVar.zzd(4);
                                            if (iZzd10 != i17) {
                                                zzff.zze("AtomParsers", "Unsupported obu_type: " + iZzd10);
                                                zztVarZzg = zzrVar.zzg();
                                            } else if (zzfoVar.zzo()) {
                                                zzff.zze("AtomParsers", "Unsupported obu_extension_flag");
                                                zztVarZzg = zzrVar.zzg();
                                            } else {
                                                boolean zZzo4 = zzfoVar.zzo();
                                                zzfoVar.zzl();
                                                if (!zZzo4 || zzfoVar.zzd(8) <= 127) {
                                                    int iZzd11 = zzfoVar.zzd(3);
                                                    zzfoVar.zzl();
                                                    if (zzfoVar.zzo()) {
                                                        zzff.zze("AtomParsers", "Unsupported reduced_still_picture_header");
                                                        zztVarZzg = zzrVar.zzg();
                                                    } else if (zzfoVar.zzo()) {
                                                        zzff.zze("AtomParsers", "Unsupported timing_info_present_flag");
                                                        zztVarZzg = zzrVar.zzg();
                                                    } else {
                                                        if (zzfoVar.zzo()) {
                                                            zzff.zze("AtomParsers", "Unsupported initial_display_delay_present_flag");
                                                            zztVarZzg = zzrVar.zzg();
                                                        } else {
                                                            int i53 = 5;
                                                            int iZzd12 = zzfoVar.zzd(5);
                                                            int i54 = 0;
                                                            while (i54 <= iZzd12) {
                                                                zzfoVar.zzm(12);
                                                                if (zzfoVar.zzd(i53) > 7) {
                                                                    zzfoVar.zzl();
                                                                }
                                                                i54++;
                                                                i53 = 5;
                                                            }
                                                            int iZzd13 = zzfoVar.zzd(4);
                                                            int iZzd14 = zzfoVar.zzd(4);
                                                            zzfoVar.zzm(iZzd13 + 1);
                                                            zzfoVar.zzm(iZzd14 + 1);
                                                            if (zzfoVar.zzo()) {
                                                                zzfoVar.zzm(7);
                                                            }
                                                            zzfoVar.zzm(7);
                                                            boolean zZzo5 = zzfoVar.zzo();
                                                            if (zZzo5) {
                                                                zzfoVar.zzm(2);
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                                i19 = 1;
                                                            } else {
                                                                i19 = 1;
                                                                if (zzfoVar.zzd(1) > 0) {
                                                                }
                                                                if (zZzo5) {
                                                                    i21 = 3;
                                                                    zzfoVar.zzm(3);
                                                                } else {
                                                                    i21 = 3;
                                                                }
                                                                zzfoVar.zzm(i21);
                                                                zZzo = zzfoVar.zzo();
                                                                if (iZzd11 == 2) {
                                                                    z14 = iZzd11 != 1;
                                                                    if (zzfoVar.zzo()) {
                                                                        iZzd = zzfoVar.zzd(8);
                                                                        iZzd2 = zzfoVar.zzd(8);
                                                                        iZzd3 = zzfoVar.zzd(8);
                                                                        if (z14) {
                                                                            i22 = 1;
                                                                        } else {
                                                                            i22 = 1;
                                                                            if (iZzd == 1) {
                                                                                i23 = 13;
                                                                                if (iZzd2 == 13) {
                                                                                    if (iZzd3 == 0) {
                                                                                        iZzd4 = 1;
                                                                                        iZzd = 1;
                                                                                    } else {
                                                                                        iZzd2 = 13;
                                                                                    }
                                                                                }
                                                                                iZzd = 1;
                                                                            }
                                                                            zzrVar.zzc(zzt.zza(iZzd));
                                                                            if (iZzd4 == i22) {
                                                                                i24 = 1;
                                                                            } else {
                                                                                i24 = 2;
                                                                            }
                                                                            zzrVar.zzb(i24);
                                                                            zzrVar.zzd(zzt.zzb(i23));
                                                                        }
                                                                        iZzd4 = zzfoVar.zzd(i22);
                                                                        i23 = iZzd2;
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i22) {
                                                                            i24 = 1;
                                                                        } else {
                                                                            i24 = 2;
                                                                        }
                                                                        zzrVar.zzb(i24);
                                                                        zzrVar.zzd(zzt.zzb(i23));
                                                                    }
                                                                    zztVarZzg = zzrVar.zzg();
                                                                } else if (zZzo) {
                                                                    zzfoVar.zzl();
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                    iZzd = zzfoVar.zzd(8);
                                                                    iZzd2 = zzfoVar.zzd(8);
                                                                    iZzd3 = zzfoVar.zzd(8);
                                                                    if (z14) {
                                                                        i22 = 1;
                                                                        if (iZzd == 1) {
                                                                            i23 = 13;
                                                                            if (iZzd2 == 13) {
                                                                                if (iZzd3 == 0) {
                                                                                    iZzd4 = 1;
                                                                                    iZzd = 1;
                                                                                } else {
                                                                                    iZzd2 = 13;
                                                                                }
                                                                            }
                                                                            iZzd = 1;
                                                                        }
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i22) {
                                                                            i24 = 1;
                                                                        } else {
                                                                            i24 = 2;
                                                                        }
                                                                        zzrVar.zzb(i24);
                                                                        zzrVar.zzd(zzt.zzb(i23));
                                                                    } else {
                                                                        i22 = 1;
                                                                    }
                                                                    iZzd4 = zzfoVar.zzd(i22);
                                                                    i23 = iZzd2;
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i22) {
                                                                        i24 = 1;
                                                                    } else {
                                                                        i24 = 2;
                                                                    }
                                                                    zzrVar.zzb(i24);
                                                                    zzrVar.zzd(zzt.zzb(i23));
                                                                }
                                                                zztVarZzg = zzrVar.zzg();
                                                            }
                                                            if (!zzfoVar.zzo()) {
                                                                zzfoVar.zzm(i19);
                                                            }
                                                            if (zZzo5) {
                                                                i21 = 3;
                                                                zzfoVar.zzm(3);
                                                            } else {
                                                                i21 = 3;
                                                            }
                                                            zzfoVar.zzm(i21);
                                                            zZzo = zzfoVar.zzo();
                                                            if (iZzd11 == 2) {
                                                                if (iZzd11 != 1) {
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                    iZzd = zzfoVar.zzd(8);
                                                                    iZzd2 = zzfoVar.zzd(8);
                                                                    iZzd3 = zzfoVar.zzd(8);
                                                                    if (z14) {
                                                                        i22 = 1;
                                                                        if (iZzd == 1) {
                                                                            i23 = 13;
                                                                            if (iZzd2 == 13) {
                                                                                if (iZzd3 == 0) {
                                                                                    iZzd4 = 1;
                                                                                    iZzd = 1;
                                                                                } else {
                                                                                    iZzd2 = 13;
                                                                                }
                                                                            }
                                                                            iZzd = 1;
                                                                        }
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i22) {
                                                                            i24 = 1;
                                                                        } else {
                                                                            i24 = 2;
                                                                        }
                                                                        zzrVar.zzb(i24);
                                                                        zzrVar.zzd(zzt.zzb(i23));
                                                                    } else {
                                                                        i22 = 1;
                                                                    }
                                                                    iZzd4 = zzfoVar.zzd(i22);
                                                                    i23 = iZzd2;
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i22) {
                                                                        i24 = 1;
                                                                    } else {
                                                                        i24 = 2;
                                                                    }
                                                                    zzrVar.zzb(i24);
                                                                    zzrVar.zzd(zzt.zzb(i23));
                                                                }
                                                                zztVarZzg = zzrVar.zzg();
                                                            } else if (zZzo) {
                                                                zzfoVar.zzl();
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                                iZzd = zzfoVar.zzd(8);
                                                                iZzd2 = zzfoVar.zzd(8);
                                                                iZzd3 = zzfoVar.zzd(8);
                                                                if (z14) {
                                                                    i22 = 1;
                                                                    if (iZzd == 1) {
                                                                        i23 = 13;
                                                                        if (iZzd2 == 13) {
                                                                            if (iZzd3 == 0) {
                                                                                iZzd4 = 1;
                                                                                iZzd = 1;
                                                                            } else {
                                                                                iZzd2 = 13;
                                                                            }
                                                                        }
                                                                        iZzd = 1;
                                                                    }
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i22) {
                                                                        i24 = 1;
                                                                    } else {
                                                                        i24 = 2;
                                                                    }
                                                                    zzrVar.zzb(i24);
                                                                    zzrVar.zzd(zzt.zzb(i23));
                                                                } else {
                                                                    i22 = 1;
                                                                }
                                                                iZzd4 = zzfoVar.zzd(i22);
                                                                i23 = iZzd2;
                                                                zzrVar.zzc(zzt.zza(iZzd));
                                                                if (iZzd4 == i22) {
                                                                    i24 = 1;
                                                                } else {
                                                                    i24 = 2;
                                                                }
                                                                zzrVar.zzb(i24);
                                                                zzrVar.zzd(zzt.zzb(i23));
                                                            }
                                                            zztVarZzg = zzrVar.zzg();
                                                        }
                                                        int i55 = zztVarZzg.zzf;
                                                        int i56 = zztVarZzg.zze;
                                                        iZza = zztVarZzg.zzd;
                                                        int i57 = zztVarZzg.zzi;
                                                        i44 = zztVarZzg.zzh;
                                                        iZzb = i55;
                                                        i45 = i56;
                                                        i43 = i57;
                                                        str2 = "video/av01";
                                                    }
                                                } else {
                                                    zzff.zze("AtomParsers", "Excessive obu_size");
                                                    zztVarZzg = zzrVar.zzg();
                                                }
                                            }
                                            int i58 = zztVarZzg.zzf;
                                            int i59 = zztVarZzg.zze;
                                            iZza = zztVarZzg.zzd;
                                            int i510 = zztVarZzg.zzi;
                                            i44 = zztVarZzg.zzh;
                                            iZzb = i58;
                                            i45 = i59;
                                            i43 = i510;
                                            str2 = "video/av01";
                                        } else if (iZzg11 == 1668050025) {
                                            if (byteBufferZzl == null) {
                                                byteBufferZzl = zzl();
                                            }
                                            byteBufferZzl.position(21);
                                            byteBufferZzl.putShort(zzfpVar3.zzD());
                                            byteBufferZzl.putShort(zzfpVar3.zzD());
                                            iZzq2 = iZzq2;
                                            iZzq3 = iZzq3;
                                            zzaisVar = zzaisVar;
                                        } else {
                                            if (iZzg11 == 1835295606) {
                                                if (byteBufferZzl == null) {
                                                    byteBufferZzl = zzl();
                                                }
                                                short sZzD = zzfpVar3.zzD();
                                                short sZzD2 = zzfpVar3.zzD();
                                                short sZzD3 = zzfpVar3.zzD();
                                                short sZzD4 = zzfpVar3.zzD();
                                                zzaisVar = zzaisVar;
                                                short sZzD5 = zzfpVar3.zzD();
                                                fZzp = fZzp;
                                                short sZzD6 = zzfpVar3.zzD();
                                                iZzq3 = iZzq3;
                                                short sZzD7 = zzfpVar3.zzD();
                                                iZzq2 = iZzq2;
                                                short sZzD8 = zzfpVar3.zzD();
                                                long jZzu3 = zzfpVar3.zzu();
                                                long jZzu4 = zzfpVar3.zzu();
                                                str9 = str9;
                                                byteBufferZzl.position(1);
                                                byteBufferZzl.putShort(sZzD5);
                                                byteBufferZzl.putShort(sZzD6);
                                                byteBufferZzl.putShort(sZzD);
                                                byteBufferZzl.putShort(sZzD2);
                                                byteBufferZzl.putShort(sZzD3);
                                                byteBufferZzl.putShort(sZzD4);
                                                byteBufferZzl.putShort(sZzD7);
                                                byteBufferZzl.putShort(sZzD8);
                                                byteBufferZzl.putShort((short) (jZzu3 / 10000));
                                                byteBufferZzl.putShort((short) (jZzu4 / 10000));
                                            } else {
                                                iZzq2 = iZzq2;
                                                iZzq3 = iZzq3;
                                                fZzp = fZzp;
                                                str9 = str9;
                                                zzaisVar = zzaisVar;
                                                if (iZzg11 == 1681012275) {
                                                    zzacy.zzb(str2 == null, null);
                                                    str2 = MimeTypes.VIDEO_H263;
                                                } else if (iZzg11 == 1702061171) {
                                                    zzacy.zzb(str2 == null, null);
                                                    zzaiq zzaiqVarZzj = zzj(zzfpVar3, iZzd8);
                                                    str2 = zzaiqVarZzj.zza;
                                                    byte[] bArr2 = zzaiqVarZzj.zzb;
                                                    if (bArr2 != null) {
                                                        zzaiqVar = zzaiqVarZzj;
                                                        listZzm = zzgaa.zzm(bArr2);
                                                    } else {
                                                        zzaiqVar = zzaiqVarZzj;
                                                    }
                                                } else if (iZzg11 == 1885434736) {
                                                    zzfpVar3.zzK(iZzd8 + 8);
                                                    fZzp = zzfpVar3.zzp() / zzfpVar3.zzp();
                                                    str9 = str9;
                                                    z17 = true;
                                                } else if (iZzg11 == 1937126244) {
                                                    int i60 = iZzd8 + 8;
                                                    while (true) {
                                                        if (i60 - iZzd8 < i15) {
                                                            zzfpVar3.zzK(i60);
                                                            int iZzg12 = zzfpVar3.zzg() + i60;
                                                            if (zzfpVar3.zzg() == 1886547818) {
                                                                bArrCopyOfRange = Arrays.copyOfRange(zzfpVar3.zzM(), i60, iZzg12);
                                                            } else {
                                                                i60 = iZzg12;
                                                            }
                                                        } else {
                                                            fZzp = fZzp;
                                                            str9 = str9;
                                                            bArrCopyOfRange = null;
                                                        }
                                                    }
                                                } else if (iZzg11 == 1936995172) {
                                                    int iZzm4 = zzfpVar3.zzm();
                                                    zzfpVar3.zzL(3);
                                                    if (iZzm4 == 0) {
                                                        int iZzm5 = zzfpVar3.zzm();
                                                        if (iZzm5 == 0) {
                                                            fZzp = fZzp;
                                                            str9 = str9;
                                                            i46 = 0;
                                                        } else if (iZzm5 == 1) {
                                                            fZzp = fZzp;
                                                            str9 = str9;
                                                            i46 = 1;
                                                        } else if (iZzm5 == 2) {
                                                            fZzp = fZzp;
                                                            str9 = str9;
                                                            i46 = 2;
                                                        } else if (iZzm5 == 3) {
                                                            fZzp = fZzp;
                                                            str9 = str9;
                                                            i46 = 3;
                                                        }
                                                    }
                                                    fZzp = fZzp;
                                                    str9 = str9;
                                                } else {
                                                    if (iZzg11 == 1668246642) {
                                                        if (iZza == -1) {
                                                            if (iZzb == -1) {
                                                                int iZzg13 = zzfpVar3.zzg();
                                                                if (iZzg13 == 1852009592 || iZzg13 == 1852009571) {
                                                                    int iZzq4 = zzfpVar3.zzq();
                                                                    int iZzq5 = zzfpVar3.zzq();
                                                                    zzfpVar3.zzL(2);
                                                                    if (i15 != 19) {
                                                                        z13 = false;
                                                                    } else if ((zzfpVar3.zzm() & 128) != 0) {
                                                                        i15 = 19;
                                                                        z13 = true;
                                                                    } else {
                                                                        i15 = 19;
                                                                        z13 = false;
                                                                    }
                                                                    int iZza2 = zzt.zza(iZzq4);
                                                                    int i61 = true != z13 ? 2 : 1;
                                                                    iZza = iZza2;
                                                                    iZzb = zzt.zzb(iZzq5);
                                                                    i45 = i61;
                                                                } else {
                                                                    zzff.zzf("AtomParsers", "Unsupported color type: ".concat(zzaio.zzf(iZzg13)));
                                                                    iZzb = -1;
                                                                }
                                                            }
                                                            iZza = -1;
                                                        }
                                                    }
                                                    fZzp = fZzp;
                                                    str9 = str9;
                                                }
                                            }
                                            fZzp = fZzp;
                                            str9 = str9;
                                        }
                                    }
                                    i42 += i15;
                                    iZzd6 = iZzd6;
                                    bArr = bArrCopyOfRange;
                                    iZzg8 = iZzg8;
                                    i14 = i16;
                                    zzaisVar = zzaisVar;
                                    iZzq3 = iZzq3;
                                    iZzq2 = iZzq2;
                                }
                                i16 = i14;
                                iZzq2 = iZzq2;
                                iZzq3 = iZzq3;
                                i44 = i27;
                                listZzm = list;
                                fZzp = f11;
                                str9 = str4;
                                i45 = i25;
                                zzaisVar = zzaisVar;
                                iZzb = i26;
                                String str10 = str5;
                                i43 = i28;
                                str2 = str10;
                                i42 += i15;
                                iZzd6 = iZzd6;
                                bArr = bArrCopyOfRange;
                                iZzg8 = iZzg8;
                                i14 = i16;
                                zzaisVar = zzaisVar;
                                iZzq3 = iZzq3;
                                iZzq2 = iZzq2;
                            }
                            iZzd6 = iZzd6;
                            zzais zzaisVar2 = zzaisVar;
                            iZzg8 = iZzg8;
                            if (str2 == null) {
                                i36 = i39;
                                i35 = i40;
                                zzaisVar = zzaisVar2;
                            } else {
                                zzak zzakVar = new zzak();
                                i35 = i40;
                                zzakVar.zzJ(i35);
                                zzakVar.zzW(str2);
                                zzakVar.zzz(str3);
                                zzakVar.zzab(iZzq2);
                                zzakVar.zzI(iZzq3);
                                zzakVar.zzS(fZzp);
                                i36 = i39;
                                zzakVar.zzV(i36);
                                zzakVar.zzT(bArrCopyOfRange);
                                zzakVar.zzZ(i46);
                                zzakVar.zzL(listZzm);
                                zzakVar.zzE(zzaeVar2);
                                zzr zzrVar2 = new zzr();
                                zzrVar2.zzc(iZza);
                                zzrVar2.zzb(i45);
                                zzrVar2.zzd(iZzb);
                                if (byteBufferZzl != null) {
                                    str3 = str9;
                                    bArrArray = byteBufferZzl.array();
                                } else {
                                    str3 = str9;
                                    bArrArray = null;
                                }
                                zzrVar2.zze(bArrArray);
                                zzrVar2.zzf(i44);
                                zzrVar2.zza(i43);
                                zzakVar.zzA(zzrVar2.zzg());
                                if (zzaiqVar != null) {
                                    zzakVar.zzx(zzgcu.zzc(zzaiqVar.zzc));
                                    zzakVar.zzR(zzgcu.zzc(zzaiqVar.zzd));
                                }
                                zzaisVar = zzaisVar2;
                                zzaisVar.zzb = zzakVar.zzac();
                            }
                        } else if (iZzg9 == 1836069985 || iZzg9 == 1701733217 || iZzg9 == 1633889587 || iZzg9 == 1700998451 || iZzg9 == 1633889588 || iZzg9 == 1835823201 || iZzg9 == 1685353315 || iZzg9 == 1685353317 || iZzg9 == 1685353320 || iZzg9 == 1685353324 || iZzg9 == 1685353336 || iZzg9 == 1935764850 || iZzg9 == 1935767394 || iZzg9 == 1819304813 || iZzg9 == 1936684916 || iZzg9 == 1953984371 || iZzg9 == 778924082 || iZzg9 == 778924083 || iZzg9 == 1835557169 || iZzg9 == 1835560241 || iZzg9 == 1634492771 || iZzg9 == 1634492791 || iZzg9 == 1970037111 || iZzg9 == 1332770163 || iZzg9 == 1716281667) {
                            i38 = i38;
                            str = str8;
                            i11 = i11;
                            pairCreate2 = pairCreate2;
                            j15 = j15;
                            zzm(zzfpVar3, iZzg9, iZzd6, iZzg8, i35, str, z12, zzaeVar, zzaisVar, i37);
                            i37 = i37;
                            iZzd6 = iZzd6;
                            zzaisVar = zzaisVar;
                            iZzg8 = iZzg8;
                            i36 = i36;
                            i35 = i35;
                        } else if (iZzg9 == 1414810956 || iZzg9 == 1954034535 || iZzg9 == 2004251764 || iZzg9 == 1937010800 || iZzg9 == 1664495672) {
                            zzfpVar3.zzK(iZzd6 + 16);
                            long j16 = Long.MAX_VALUE;
                            if (iZzg9 == 1414810956) {
                                str7 = MimeTypes.APPLICATION_TTML;
                            } else {
                                if (iZzg9 == 1954034535) {
                                    int i62 = iZzg8 - 16;
                                    byte[] bArr3 = new byte[i62];
                                    zzfpVar3.zzG(bArr3, 0, i62);
                                    zzgaaVarZzm = zzgaa.zzm(bArr3);
                                    str6 = MimeTypes.APPLICATION_TX3G;
                                    j13 = Long.MAX_VALUE;
                                } else if (iZzg9 == 2004251764) {
                                    str7 = MimeTypes.APPLICATION_MP4VTT;
                                } else {
                                    if (iZzg9 == 1937010800) {
                                        j16 = 0;
                                        str7 = MimeTypes.APPLICATION_TTML;
                                    } else {
                                        zzaisVar.zzd = 1;
                                        str6 = MimeTypes.APPLICATION_MP4CEA608;
                                    }
                                    j13 = j16;
                                    zzgaaVarZzm = null;
                                }
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzJ(i35);
                                zzakVar2.zzW(str6);
                                zzakVar2.zzN(str8);
                                zzakVar2.zzaa(j13);
                                zzakVar2.zzL(zzgaaVarZzm);
                                zzaisVar.zzb = zzakVar2.zzac();
                                str = str8;
                            }
                            str6 = str7;
                            j13 = j16;
                            zzgaaVarZzm = null;
                            zzak zzakVar3 = new zzak();
                            zzakVar3.zzJ(i35);
                            zzakVar3.zzW(str6);
                            zzakVar3.zzN(str8);
                            zzakVar3.zzaa(j13);
                            zzakVar3.zzL(zzgaaVarZzm);
                            zzaisVar.zzb = zzakVar3.zzac();
                            str = str8;
                        } else {
                            if (iZzg9 == 1835365492) {
                                zzfpVar3.zzK(iZzd6 + 16);
                                zzfpVar3.zzx((char) 0);
                                String strZzx = zzfpVar3.zzx((char) 0);
                                if (strZzx != null) {
                                    zzak zzakVar4 = new zzak();
                                    zzakVar4.zzJ(i35);
                                    zzakVar4.zzW(strZzx);
                                    zzaisVar.zzb = zzakVar4.zzac();
                                }
                            } else if (iZzg9 == 1667329389) {
                                zzak zzakVar5 = new zzak();
                                zzakVar5.zzJ(i35);
                                zzakVar5.zzW(MimeTypes.APPLICATION_CAMERA_MOTION);
                                zzaisVar.zzb = zzakVar5.zzac();
                            }
                            str = str8;
                        }
                        zzfpVar3.zzK(iZzd6 + iZzg8);
                        i37++;
                        zzaeVar = zzaeVar;
                        i36 = i36;
                        i35 = i35;
                        zzaisVar = zzaisVar;
                        iZzg7 = i38;
                        i11 = i11;
                        zzaivVar = zzaivVar2;
                        j15 = j15;
                        str8 = str;
                        zzaimVar3 = zzaimVar4;
                        pairCreate2 = pairCreate2;
                    }
                    int i63 = i11;
                    Pair pair = pairCreate2;
                    long j17 = j15;
                    zzaiv zzaivVar3 = zzaivVar;
                    zzais zzaisVar3 = zzaisVar;
                    zzaim zzaimVar5 = zzaimVar3;
                    if (z11) {
                        zzaimVar2 = zzaimVar5;
                    } else {
                        zzaimVar2 = zzaimVar5;
                        zzaim zzaimVarZza4 = zzaimVar2.zza(1701082227);
                        if (zzaimVarZza4 != null) {
                            zzain zzainVarZzb6 = zzaimVarZza4.zzb(1701606260);
                            if (zzainVarZzb6 == null) {
                                pairCreate = null;
                            } else {
                                zzfp zzfpVar4 = zzainVarZzb6.zza;
                                zzfpVar4.zzK(8);
                                int iZze3 = zzaio.zze(zzfpVar4.zzg());
                                int iZzp = zzfpVar4.zzp();
                                long[] jArr3 = new long[iZzp];
                                long[] jArr4 = new long[iZzp];
                                for (int i64 = 0; i64 < iZzp; i64++) {
                                    jArr3[i64] = iZze3 == 1 ? zzfpVar4.zzv() : zzfpVar4.zzu();
                                    jArr4[i64] = iZze3 == 1 ? zzfpVar4.zzt() : zzfpVar4.zzg();
                                    if (zzfpVar4.zzD() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    zzfpVar4.zzL(2);
                                }
                                pairCreate = Pair.create(jArr3, jArr4);
                            }
                            if (pairCreate != null) {
                                jArr = (long[]) pairCreate.first;
                                jArr2 = (long[]) pairCreate.second;
                            }
                        }
                        if (zzaisVar3.zzb == null) {
                            zzajmVar = null;
                        } else {
                            zzajmVar = new zzajm(zzaivVar3.zza, i63, ((Long) pair.first).longValue(), j17, jZzs, zzaisVar3.zzb, zzaisVar3.zzd, zzaisVar3.zza, zzaisVar3.zzc, jArr, jArr2);
                        }
                    }
                    jArr = null;
                    jArr2 = null;
                    if (zzaisVar3.zzb == null) {
                        zzajmVar = null;
                    } else {
                        zzajmVar = new zzajm(zzaivVar3.zza, i63, ((Long) pair.first).longValue(), j17, jZzs, zzaisVar3.zzb, zzaisVar3.zzd, zzaisVar3.zza, zzaisVar3.zzc, jArr, jArr2);
                    }
                }
                zzajm zzajmVar2 = (zzajm) zzfwsVar.apply(zzajmVar);
                if (zzajmVar2 != null) {
                    zzaim zzaimVarZza5 = zzaimVar2.zza(1835297121);
                    zzaimVarZza5.getClass();
                    zzaim zzaimVarZza6 = zzaimVarZza5.zza(1835626086);
                    zzaimVarZza6.getClass();
                    zzaim zzaimVarZza7 = zzaimVarZza6.zza(1937007212);
                    zzaimVarZza7.getClass();
                    zzajp zzajpVarZzk = zzk(zzajmVar2, zzaimVarZza7, zzadkVar);
                    arrayList2 = arrayList;
                    arrayList2.add(zzajpVarZzk);
                } else {
                    arrayList2 = arrayList;
                }
            }
            i29 = i13 + 1;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }

    public static void zze(zzfp zzfpVar) {
        int iZzd = zzfpVar.zzd();
        zzfpVar.zzL(4);
        if (zzfpVar.zzg() != 1751411826) {
            iZzd += 4;
        }
        zzfpVar.zzK(iZzd);
    }

    private static int zzf(zzfp zzfpVar) {
        int iZzm = zzfpVar.zzm();
        int i11 = iZzm & 127;
        while ((iZzm & 128) == 128) {
            iZzm = zzfpVar.zzm();
            i11 = (i11 << 7) | (iZzm & 127);
        }
        return i11;
    }

    private static int zzg(zzfp zzfpVar) {
        zzfpVar.zzK(16);
        return zzfpVar.zzg();
    }

    @Nullable
    private static Pair zzh(zzfp zzfpVar, int i11, int i12) throws zzcc {
        zzajn zzajnVar;
        Pair pairCreate;
        int i13;
        int i14;
        byte[] bArr;
        int iZzd = zzfpVar.zzd();
        while (iZzd - i11 < i12) {
            zzfpVar.zzK(iZzd);
            int iZzg = zzfpVar.zzg();
            zzacy.zzb(iZzg > 0, "childAtomSize must be positive");
            if (zzfpVar.zzg() == 1936289382) {
                int i15 = iZzd + 8;
                int i16 = -1;
                int i17 = 0;
                String strZzA = null;
                Integer numValueOf = null;
                while (i15 - iZzd < iZzg) {
                    zzfpVar.zzK(i15);
                    int iZzg2 = zzfpVar.zzg();
                    int iZzg3 = zzfpVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzfpVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzfpVar.zzL(4);
                        strZzA = zzfpVar.zzA(4, zzfwq.zzc);
                    } else if (iZzg3 == 1935894633) {
                        i16 = i15;
                        i17 = iZzg2;
                    }
                    i15 += iZzg2;
                }
                if (C.CENC_TYPE_cenc.equals(strZzA) || C.CENC_TYPE_cbc1.equals(strZzA) || C.CENC_TYPE_cens.equals(strZzA) || C.CENC_TYPE_cbcs.equals(strZzA)) {
                    zzacy.zzb(numValueOf != null, "frma atom is mandatory");
                    zzacy.zzb(i16 != -1, "schi atom is mandatory");
                    int i18 = i16 + 8;
                    while (true) {
                        if (i18 - i16 >= i17) {
                            zzajnVar = null;
                            break;
                        }
                        zzfpVar.zzK(i18);
                        int iZzg4 = zzfpVar.zzg();
                        if (zzfpVar.zzg() == 1952804451) {
                            int iZze = zzaio.zze(zzfpVar.zzg());
                            zzfpVar.zzL(1);
                            if (iZze == 0) {
                                zzfpVar.zzL(1);
                                i13 = 0;
                                i14 = 0;
                            } else {
                                int iZzm = zzfpVar.zzm();
                                int i19 = (iZzm & 240) >> 4;
                                i13 = iZzm & 15;
                                i14 = i19;
                            }
                            boolean z11 = zzfpVar.zzm() == 1;
                            int iZzm2 = zzfpVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzfpVar.zzG(bArr2, 0, 16);
                            if (z11 && iZzm2 == 0) {
                                int iZzm3 = zzfpVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzfpVar.zzG(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            zzajnVar = new zzajn(z11, strZzA, iZzm2, bArr2, i14, i13, bArr);
                            break;
                        }
                        i18 += iZzg4;
                    }
                    zzacy.zzb(zzajnVar != null, "tenc atom is mandatory");
                    int i21 = zzfy.zza;
                    pairCreate = Pair.create(numValueOf, zzajnVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzd += iZzg;
        }
        return null;
    }

    @Nullable
    private static zzby zzi(zzfp zzfpVar) {
        short sZzD = zzfpVar.zzD();
        zzfpVar.zzL(2);
        String strZzA = zzfpVar.zzA(sZzD, zzfwq.zzc);
        int iMax = Math.max(strZzA.lastIndexOf(43), strZzA.lastIndexOf(45));
        try {
            return new zzby(C.TIME_UNSET, new zzgf(Float.parseFloat(strZzA.substring(0, iMax)), Float.parseFloat(strZzA.substring(iMax, strZzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzaiq zzj(zzfp zzfpVar, int i11) {
        zzfpVar.zzK(i11 + 12);
        zzfpVar.zzL(1);
        zzf(zzfpVar);
        zzfpVar.zzL(2);
        int iZzm = zzfpVar.zzm();
        if ((iZzm & 128) != 0) {
            zzfpVar.zzL(2);
        }
        if ((iZzm & 64) != 0) {
            zzfpVar.zzL(zzfpVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzfpVar.zzL(2);
        }
        zzfpVar.zzL(1);
        zzf(zzfpVar);
        String strZzd = zzcb.zzd(zzfpVar.zzm());
        if (MimeTypes.AUDIO_MPEG.equals(strZzd) || MimeTypes.AUDIO_DTS.equals(strZzd) || MimeTypes.AUDIO_DTS_HD.equals(strZzd)) {
            return new zzaiq(strZzd, null, -1L, -1L);
        }
        zzfpVar.zzL(4);
        long jZzu = zzfpVar.zzu();
        long jZzu2 = zzfpVar.zzu();
        zzfpVar.zzL(1);
        int iZzf = zzf(zzfpVar);
        byte[] bArr = new byte[iZzf];
        zzfpVar.zzG(bArr, 0, iZzf);
        return new zzaiq(strZzd, bArr, jZzu2 <= 0 ? -1L : jZzu2, jZzu > 0 ? jZzu : -1L);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0274 A[DONT_INVERT, LOOP:12: B:102:0x0274->B:106:0x027e, LOOP_START, PHI: r16
  0x0274: PHI (r16v6 int) = (r16v2 int), (r16v7 int) binds: [B:101:0x0272, B:106:0x027e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x0276  */
    /* JADX WARN: Code duplicated, block: B:106:0x027e A[LOOP:12: B:102:0x0274->B:106:0x027e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:107:0x0284 A[EDGE_INSN: B:107:0x0284->B:108:0x0285 BREAK  A[LOOP:12: B:102:0x0274->B:106:0x027e]] */
    /* JADX WARN: Code duplicated, block: B:109:0x0287 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0289 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x028b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x028d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x028f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0291  */
    /* JADX WARN: Code duplicated, block: B:115:0x029c  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:121:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:123:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:126:0x031f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0322  */
    /* JADX WARN: Code duplicated, block: B:160:0x041a  */
    /* JADX WARN: Code duplicated, block: B:249:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x0244 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x027c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0191  */
    /* JADX WARN: Code duplicated, block: B:65:0x0195  */
    /* JADX WARN: Code duplicated, block: B:67:0x019b A[LOOP:10: B:64:0x0193->B:67:0x019b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x01de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01e3 A[ADDED_TO_REGION, LOOP:11: B:74:0x01e3->B:76:0x01e7, LOOP_START, PHI: r16 r23 r25
  0x01e3: PHI (r16v8 int) = (r16v2 int), (r16v9 int) binds: [B:72:0x01de, B:76:0x01e7] A[DONT_GENERATE, DONT_INLINE]
  0x01e3: PHI (r23v2 int) = (r23v1 int), (r23v6 int) binds: [B:72:0x01de, B:76:0x01e7] A[DONT_GENERATE, DONT_INLINE]
  0x01e3: PHI (r25v2 int) = (r25v1 int), (r25v3 int) binds: [B:72:0x01de, B:76:0x01e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x01e7 A[LOOP:11: B:74:0x01e3->B:76:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:82:0x0206  */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    /* JADX WARN: Code duplicated, block: B:86:0x0212  */
    /* JADX WARN: Code duplicated, block: B:87:0x0214  */
    /* JADX WARN: Code duplicated, block: B:90:0x0219  */
    /* JADX WARN: Code duplicated, block: B:92:0x0220  */
    /* JADX WARN: Code duplicated, block: B:95:0x0235 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0237  */
    /* JADX WARN: Code duplicated, block: B:97:0x0243  */
    private static zzajp zzk(zzajm zzajmVar, zzaim zzaimVar, zzadk zzadkVar) throws zzcc {
        zzair zzaiuVar;
        boolean z11;
        int iZzp;
        int iZzp2;
        int iZzp3;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int i11;
        int i12;
        int i13;
        int iZzp4;
        int iZzg;
        int i14;
        long j11;
        long j12;
        boolean z12;
        int i15;
        int i16;
        int i17;
        int i18;
        long[] jArr;
        int[] iArr;
        int i19;
        int[] iArr2;
        int i21;
        long j13;
        String str;
        boolean zZza;
        int i22;
        int iZzc;
        int i23;
        int i24;
        int iZzp5;
        int[] iArr3;
        int i25;
        int[] iArr4;
        int[] iArr5;
        int i26;
        int i27;
        int length;
        zzain zzainVarZzb = zzaimVar.zzb(1937011578);
        if (zzainVarZzb != null) {
            zzaiuVar = new zzait(zzainVarZzb, zzajmVar.zzf);
        } else {
            zzain zzainVarZzb2 = zzaimVar.zzb(1937013298);
            if (zzainVarZzb2 == null) {
                throw zzcc.zza("Track has no sample table size information", null);
            }
            zzaiuVar = new zzaiu(zzainVarZzb2);
        }
        int iZzb = zzaiuVar.zzb();
        if (iZzb == 0) {
            return new zzajp(zzajmVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        zzain zzainVarZzb3 = zzaimVar.zzb(1937007471);
        if (zzainVarZzb3 == null) {
            zzainVarZzb3 = zzaimVar.zzb(1668232756);
            zzainVarZzb3.getClass();
            z11 = true;
        } else {
            z11 = false;
        }
        zzain zzainVarZzb4 = zzaimVar.zzb(1937011555);
        zzainVarZzb4.getClass();
        zzain zzainVarZzb5 = zzaimVar.zzb(1937011827);
        zzainVarZzb5.getClass();
        zzain zzainVarZzb6 = zzaimVar.zzb(1937011571);
        zzfp zzfpVar = zzainVarZzb6 != null ? zzainVarZzb6.zza : null;
        zzain zzainVarZzb7 = zzaimVar.zzb(1668576371);
        zzfp zzfpVar2 = zzainVarZzb7 != null ? zzainVarZzb7.zza : null;
        zzfp zzfpVar3 = zzainVarZzb5.zza;
        zzaip zzaipVar = new zzaip(zzainVarZzb4.zza, zzainVarZzb3.zza, z11);
        zzfpVar3.zzK(12);
        int iZzp6 = zzfpVar3.zzp() - 1;
        int iZzp7 = zzfpVar3.zzp();
        int iZzp8 = zzfpVar3.zzp();
        if (zzfpVar2 != null) {
            zzfpVar2.zzK(12);
            iZzp = zzfpVar2.zzp();
        } else {
            iZzp = 0;
        }
        if (zzfpVar != null) {
            zzfpVar.zzK(12);
            iZzp3 = zzfpVar.zzp();
            if (iZzp3 > 0) {
                iZzp2 = zzfpVar.zzp() - 1;
            } else {
                zzfpVar = null;
                iZzp2 = -1;
            }
        } else {
            iZzp2 = -1;
            iZzp3 = 0;
        }
        int iZza = zzaiuVar.zza();
        String str2 = zzajmVar.zzf.zzm;
        if (iZza == -1 || !((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && iZzp6 == 0)) {
            jArrCopyOf = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArrCopyOf2 = new long[iZzb];
            iArrCopyOf2 = new int[iZzb];
            i11 = iZzp6;
            i12 = 0;
            i13 = 0;
            iZzp4 = 0;
            iZzg = 0;
            i14 = 0;
            j11 = 0;
            j12 = 0;
            while (true) {
                if (i12 < iZzb) {
                    iZzp7 = iZzp7;
                    break;
                }
                zZza = true;
                while (true) {
                    if (i13 != 0) {
                        i22 = i13;
                        break;
                    }
                    zZza = zzaipVar.zza();
                    if (zZza) {
                        i22 = 0;
                        break;
                    }
                    int i28 = iZzp7;
                    long j14 = zzaipVar.zzd;
                    i13 = zzaipVar.zzc;
                    j11 = j14;
                    iZzp7 = i28;
                    iZzp8 = iZzp8;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i12);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i12);
                    iZzb = i12;
                    break;
                }
                if (zzfpVar2 != null) {
                    while (iZzp4 == 0) {
                        if (iZzp > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        iZzp--;
                        iZzp4 = zzfpVar2.zzp();
                        iZzg = zzfpVar2.zzg();
                    }
                    iZzp4--;
                }
                int i29 = iZzg;
                jArrCopyOf[i12] = j11;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i12] = iZzc;
                i23 = i14;
                if (iZzc > i23) {
                    i14 = iZzc;
                } else {
                    i14 = i23;
                }
                jArrCopyOf2[i12] = j12 + ((long) i29);
                if (zzfpVar == null) {
                    i24 = 1;
                } else {
                    i24 = 0;
                }
                iArrCopyOf2[i12] = i24;
                if (i12 == iZzp2) {
                    iArrCopyOf2[i12] = 1;
                    iZzp3--;
                    if (iZzp3 > 0) {
                        zzfpVar.getClass();
                        iZzp2 = zzfpVar.zzp() - 1;
                    }
                }
                int i31 = iZzp2;
                long[] jArr2 = jArrCopyOf2;
                iZzp8 = iZzp8;
                j12 += (long) iZzp8;
                iZzp5 = iZzp7 - 1;
                if (iZzp5 != 0) {
                    if (i11 > 0) {
                        iZzp5 = zzfpVar3.zzp();
                        i11--;
                        iZzp8 = zzfpVar3.zzg();
                    } else {
                        iZzp5 = 0;
                    }
                }
                int[] iArr6 = iArrCopyOf;
                j11 += (long) iArrCopyOf[i12];
                int i32 = i22 - 1;
                i12++;
                iZzg = i29;
                jArrCopyOf2 = jArr2;
                jArrCopyOf = jArrCopyOf;
                iZzb = iZzb;
                iZzp7 = iZzp5;
                iZzp2 = i31;
                i13 = i32;
                iArrCopyOf = iArr6;
            }
            long j15 = j12 + ((long) iZzg);
            if (zzfpVar2 != null) {
                z12 = true;
                break;
            }
            while (true) {
                if (iZzp > 0) {
                    z12 = true;
                    break;
                }
                if (zzfpVar2.zzp() != 0) {
                    z12 = false;
                    break;
                }
                zzfpVar2.zzg();
                iZzp--;
            }
            if (iZzp3 == 0) {
                if (iZzp7 == 0) {
                    if (i13 == 0) {
                        if (i11 == 0) {
                            i18 = 0;
                            i16 = 0;
                        } else if (iZzp4 == 0) {
                            i18 = 0;
                            i16 = 0;
                            i17 = 0;
                            zzajmVar = zzajmVar;
                            z12 = z12;
                            jArrCopyOf = jArrCopyOf;
                        } else if (z12) {
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        } else {
                            i15 = 0;
                            i18 = 0;
                            z12 = false;
                            i16 = 0;
                            i17 = 0;
                            iZzp4 = 0;
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        }
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf2;
                        i19 = i14;
                        iArr2 = iArrCopyOf;
                        i21 = iZzb;
                        j13 = j15;
                    } else {
                        i18 = 0;
                        i16 = i13;
                    }
                    i17 = i11;
                } else {
                    zzajmVar = zzajmVar;
                    z12 = z12;
                    jArrCopyOf = jArrCopyOf;
                    i16 = i13;
                    i17 = i11;
                    i18 = iZzp7;
                }
                i15 = 0;
            } else {
                z12 = z12;
                jArrCopyOf = jArrCopyOf;
                i15 = iZzp3;
                i16 = i13;
                i17 = i11;
                iZzp4 = iZzp4;
                i18 = iZzp7;
                zzajmVar = zzajmVar;
            }
            int i33 = zzajmVar.zza;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Inconsistent stbl box for track ");
            sb2.append(i33);
            sb2.append(": remainingSynchronizationSamples ");
            sb2.append(i15);
            sb2.append(", remainingSamplesAtTimestampDelta ");
            sb2.append(i18);
            sb2.append(", remainingSamplesInChunk ");
            sb2.append(i16);
            sb2.append(", remainingTimestampDeltaChanges ");
            sb2.append(i17);
            sb2.append(", remainingSamplesAtTimestampOffset ");
            sb2.append(iZzp4);
            if (true != z12) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb2.append(str);
            zzff.zzf("AtomParsers", sb2.toString());
            jArr = jArrCopyOf;
            iArr = iArrCopyOf2;
            i19 = i14;
            iArr2 = iArrCopyOf;
            i21 = iZzb;
            j13 = j15;
        } else if (iZzp == 0 && iZzp3 == 0) {
            int i34 = zzaipVar.zza;
            long[] jArr3 = new long[i34];
            int[] iArr7 = new int[i34];
            while (zzaipVar.zza()) {
                int i35 = zzaipVar.zzb;
                jArr3[i35] = zzaipVar.zzd;
                iArr7[i35] = zzaipVar.zzc;
            }
            long j16 = iZzp8;
            int i36 = 8192 / iZza;
            int i37 = 0;
            for (int i38 = 0; i38 < i34; i38++) {
                int i39 = iArr7[i38];
                int i40 = zzfy.zza;
                i37 += ((i39 + i36) - 1) / i36;
            }
            long[] jArr4 = new long[i37];
            int[] iArr8 = new int[i37];
            long[] jArr5 = new long[i37];
            int[] iArr9 = new int[i37];
            int i41 = 0;
            int i42 = 0;
            int iMax = 0;
            int i43 = 0;
            while (i41 < i34) {
                int i44 = iArr7[i41];
                long j17 = jArr3[i41];
                int i45 = i34;
                int i46 = i44;
                while (i46 > 0) {
                    int iMin = Math.min(i36, i46);
                    jArr4[i43] = j17;
                    long[] jArr6 = jArr3;
                    int i47 = iZza * iMin;
                    iArr8[i43] = i47;
                    iMax = Math.max(iMax, i47);
                    jArr5[i43] = ((long) i42) * j16;
                    iArr9[i43] = 1;
                    j17 += (long) iArr8[i43];
                    i42 += iMin;
                    i46 -= iMin;
                    i43++;
                    jArr3 = jArr6;
                    iArr7 = iArr7;
                }
                i41++;
                i34 = i45;
            }
            i21 = iZzb;
            j13 = j16 * ((long) i42);
            jArr = jArr4;
            iArr = iArr9;
            iArr2 = iArr8;
            jArrCopyOf2 = jArr5;
            i19 = iMax;
            zzajmVar = zzajmVar;
        } else {
            iZzp6 = 0;
            jArrCopyOf = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArrCopyOf2 = new long[iZzb];
            iArrCopyOf2 = new int[iZzb];
            i11 = iZzp6;
            i12 = 0;
            i13 = 0;
            iZzp4 = 0;
            iZzg = 0;
            i14 = 0;
            j11 = 0;
            j12 = 0;
            while (true) {
                if (i12 < iZzb) {
                    iZzp7 = iZzp7;
                    break;
                }
                zZza = true;
                while (true) {
                    if (i13 != 0) {
                        i22 = i13;
                        break;
                    }
                    zZza = zzaipVar.zza();
                    if (zZza) {
                        i22 = 0;
                        break;
                    }
                    int i210 = iZzp7;
                    long j18 = zzaipVar.zzd;
                    i13 = zzaipVar.zzc;
                    j11 = j18;
                    iZzp7 = i210;
                    iZzp8 = iZzp8;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i12);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i12);
                    iZzb = i12;
                    break;
                }
                if (zzfpVar2 != null) {
                    while (iZzp4 == 0) {
                        if (iZzp > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        iZzp--;
                        iZzp4 = zzfpVar2.zzp();
                        iZzg = zzfpVar2.zzg();
                    }
                    iZzp4--;
                }
                int i211 = iZzg;
                jArrCopyOf[i12] = j11;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i12] = iZzc;
                i23 = i14;
                if (iZzc > i23) {
                    i14 = iZzc;
                } else {
                    i14 = i23;
                }
                jArrCopyOf2[i12] = j12 + ((long) i211);
                if (zzfpVar == null) {
                    i24 = 1;
                } else {
                    i24 = 0;
                }
                iArrCopyOf2[i12] = i24;
                if (i12 == iZzp2) {
                    iArrCopyOf2[i12] = 1;
                    iZzp3--;
                    if (iZzp3 > 0) {
                        zzfpVar.getClass();
                        iZzp2 = zzfpVar.zzp() - 1;
                    }
                }
                int i310 = iZzp2;
                long[] jArr7 = jArrCopyOf2;
                iZzp8 = iZzp8;
                j12 += (long) iZzp8;
                iZzp5 = iZzp7 - 1;
                if (iZzp5 != 0) {
                    if (i11 > 0) {
                        iZzp5 = zzfpVar3.zzp();
                        i11--;
                        iZzp8 = zzfpVar3.zzg();
                    } else {
                        iZzp5 = 0;
                    }
                }
                int[] iArr10 = iArrCopyOf;
                j11 += (long) iArrCopyOf[i12];
                int i311 = i22 - 1;
                i12++;
                iZzg = i211;
                jArrCopyOf2 = jArr7;
                jArrCopyOf = jArrCopyOf;
                iZzb = iZzb;
                iZzp7 = iZzp5;
                iZzp2 = i310;
                i13 = i311;
                iArrCopyOf = iArr10;
            }
            long j19 = j12 + ((long) iZzg);
            if (zzfpVar2 != null) {
                z12 = true;
                break;
            }
            while (true) {
                if (iZzp > 0) {
                    z12 = true;
                    break;
                }
                if (zzfpVar2.zzp() != 0) {
                    z12 = false;
                    break;
                }
                zzfpVar2.zzg();
                iZzp--;
            }
            if (iZzp3 == 0) {
                if (iZzp7 == 0) {
                    if (i13 == 0) {
                        if (i11 == 0) {
                            i18 = 0;
                            i16 = 0;
                        } else if (iZzp4 == 0) {
                            i18 = 0;
                            i16 = 0;
                            i17 = 0;
                            zzajmVar = zzajmVar;
                            z12 = z12;
                            jArrCopyOf = jArrCopyOf;
                        } else if (z12) {
                            i15 = 0;
                            i18 = 0;
                            z12 = false;
                            i16 = 0;
                            i17 = 0;
                            iZzp4 = 0;
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        } else {
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        }
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf2;
                        i19 = i14;
                        iArr2 = iArrCopyOf;
                        i21 = iZzb;
                        j13 = j19;
                    } else {
                        i18 = 0;
                        i16 = i13;
                    }
                    i17 = i11;
                } else {
                    zzajmVar = zzajmVar;
                    z12 = z12;
                    jArrCopyOf = jArrCopyOf;
                    i16 = i13;
                    i17 = i11;
                    i18 = iZzp7;
                }
                i15 = 0;
            } else {
                z12 = z12;
                jArrCopyOf = jArrCopyOf;
                i15 = iZzp3;
                i16 = i13;
                i17 = i11;
                iZzp4 = iZzp4;
                i18 = iZzp7;
                zzajmVar = zzajmVar;
            }
            int i312 = zzajmVar.zza;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Inconsistent stbl box for track ");
            sb3.append(i312);
            sb3.append(": remainingSynchronizationSamples ");
            sb3.append(i15);
            sb3.append(", remainingSamplesAtTimestampDelta ");
            sb3.append(i18);
            sb3.append(", remainingSamplesInChunk ");
            sb3.append(i16);
            sb3.append(", remainingTimestampDeltaChanges ");
            sb3.append(i17);
            sb3.append(", remainingSamplesAtTimestampOffset ");
            sb3.append(iZzp4);
            if (true != z12) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb3.append(str);
            zzff.zzf("AtomParsers", sb3.toString());
            jArr = jArrCopyOf;
            iArr = iArrCopyOf2;
            i19 = i14;
            iArr2 = iArrCopyOf;
            i21 = iZzb;
            j13 = j19;
        }
        long j21 = zzajmVar.zzc;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        long jZzs = zzfy.zzs(j13, 1000000L, j21, roundingMode);
        long[] jArr8 = zzajmVar.zzh;
        if (jArr8 == null) {
            zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
            return new zzajp(zzajmVar, jArr, iArr2, i19, jArrCopyOf2, iArr, jZzs);
        }
        if (jArr8.length == 1 && zzajmVar.zzb == 1 && (length = jArrCopyOf2.length) >= 2) {
            long[] jArr9 = zzajmVar.zzi;
            jArr9.getClass();
            long j22 = jArr9[0];
            long jZzs2 = j22 + zzfy.zzs(jArr8[0], zzajmVar.zzc, zzajmVar.zzd, roundingMode);
            int i48 = length - 1;
            int iMax2 = Math.max(0, Math.min(4, i48));
            int iMax3 = Math.max(0, Math.min(length - 4, i48));
            long j23 = jArrCopyOf2[0];
            if (j23 > j22 || j22 >= jArrCopyOf2[iMax2] || jArrCopyOf2[iMax3] >= jZzs2 || jZzs2 > j13) {
                iArr3 = iArr2;
                i25 = i19;
            } else {
                long jZzs3 = zzfy.zzs(j22 - j23, zzajmVar.zzf.zzA, zzajmVar.zzc, roundingMode);
                iArr3 = iArr2;
                i25 = i19;
                long jZzs4 = zzfy.zzs(j13 - jZzs2, zzajmVar.zzf.zzA, zzajmVar.zzc, roundingMode);
                if (jZzs3 != 0) {
                    if (jZzs3 <= 2147483647L && jZzs4 <= 2147483647L) {
                        zzadkVar.zza = (int) jZzs3;
                        zzadkVar.zzb = (int) jZzs4;
                        zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
                        return new zzajp(zzajmVar, jArr, iArr3, i25, jArrCopyOf2, iArr, zzfy.zzs(zzajmVar.zzh[0], 1000000L, zzajmVar.zzd, roundingMode));
                    }
                } else if (jZzs4 != 0) {
                    jZzs3 = 0;
                    if (jZzs3 <= 2147483647L) {
                        zzadkVar.zza = (int) jZzs3;
                        zzadkVar.zzb = (int) jZzs4;
                        zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
                        return new zzajp(zzajmVar, jArr, iArr3, i25, jArrCopyOf2, iArr, zzfy.zzs(zzajmVar.zzh[0], 1000000L, zzajmVar.zzd, roundingMode));
                    }
                }
            }
        } else {
            iArr3 = iArr2;
            i25 = i19;
        }
        long[] jArr10 = zzajmVar.zzh;
        int length2 = jArr10.length;
        if (length2 == 1) {
            if (jArr10[0] == 0) {
                long[] jArr11 = zzajmVar.zzi;
                jArr11.getClass();
                long j24 = jArr11[0];
                for (int i49 = 0; i49 < jArrCopyOf2.length; i49++) {
                    jArrCopyOf2[i49] = zzfy.zzs(jArrCopyOf2[i49] - j24, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
                }
                return new zzajp(zzajmVar, jArr, iArr3, i25, jArrCopyOf2, iArr, zzfy.zzs(j13 - j24, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR));
            }
            length2 = 1;
        }
        boolean z13 = zzajmVar.zzb == 1;
        long[] jArr12 = zzajmVar.zzi;
        int[] iArr11 = new int[length2];
        int[] iArr12 = new int[length2];
        jArr12.getClass();
        int i50 = 0;
        boolean z14 = false;
        int i51 = 0;
        int i52 = 0;
        while (true) {
            long[] jArr13 = zzajmVar.zzh;
            if (i52 >= jArr13.length) {
                break;
            }
            boolean z15 = z14;
            int i53 = i51;
            long j25 = jArr12[i52];
            if (j25 != -1) {
                iArr5 = iArr12;
                long jZzs5 = zzfy.zzs(jArr13[i52], zzajmVar.zzc, zzajmVar.zzd, RoundingMode.FLOOR);
                int i54 = 1;
                iArr11[i52] = zzfy.zzc(jArrCopyOf2, j25, true, true);
                iArr5[i52] = zzfy.zza(jArrCopyOf2, j25 + jZzs5, z13, false);
                while (true) {
                    i26 = iArr11[i52];
                    i27 = iArr5[i52];
                    if (i26 >= i27 || (iArr[i26] & i54) != 0) {
                        break;
                    }
                    iArr11[i52] = i26 + 1;
                    i54 = 1;
                }
                i50 += i27 - i26;
                i51 = i27;
                z14 = z15 | (i53 != i26);
            } else {
                iArr5 = iArr12;
                i51 = i53;
                z14 = z15;
            }
            i52++;
            jArr = jArr;
            iArr12 = iArr5;
        }
        long[] jArr14 = jArr;
        int[] iArr13 = iArr12;
        boolean z16 = z14 | (i50 != i21);
        long[] jArr15 = z16 ? new long[i50] : jArr14;
        int[] iArr14 = z16 ? new int[i50] : iArr3;
        if (true == z16) {
            i25 = 0;
        }
        int[] iArr15 = z16 ? new int[i50] : iArr;
        long[] jArr16 = new long[i50];
        long j26 = 0;
        int i55 = 0;
        int i56 = 0;
        while (i55 < zzajmVar.zzh.length) {
            long j27 = zzajmVar.zzi[i55];
            int i57 = iArr11[i55];
            int[] iArr16 = iArr11;
            int i58 = iArr13[i55];
            int i59 = i25;
            if (z16) {
                int i60 = i58 - i57;
                System.arraycopy(jArr14, i57, jArr15, i56, i60);
                iArr4 = iArr3;
                System.arraycopy(iArr4, i57, iArr14, i56, i60);
                System.arraycopy(iArr, i57, iArr15, i56, i60);
            } else {
                iArr4 = iArr3;
            }
            i25 = i59;
            while (i57 < i58) {
                int[] iArr17 = iArr15;
                int[] iArr18 = iArr4;
                long j28 = zzajmVar.zzd;
                RoundingMode roundingMode2 = RoundingMode.FLOOR;
                long jZzs6 = zzfy.zzs(j26, 1000000L, j28, roundingMode2);
                long[] jArr17 = jArrCopyOf2;
                int[] iArr19 = iArr;
                long jZzs7 = zzfy.zzs(jArrCopyOf2[i57] - j27, 1000000L, zzajmVar.zzc, roundingMode2);
                int i61 = i58;
                long j29 = j27;
                long j31 = j26;
                if (zzajmVar.zzb != 1) {
                    jZzs7 = Math.max(0L, jZzs7);
                }
                jArr16[i56] = jZzs6 + jZzs7;
                if (z16 && iArr14[i56] > i25) {
                    i25 = iArr18[i57];
                }
                i56++;
                i57++;
                iArr4 = iArr18;
                jArrCopyOf2 = jArr17;
                iArr = iArr19;
                i58 = i61;
                j27 = j29;
                j26 = j31;
                iArr15 = iArr17;
            }
            long[] jArr18 = jArrCopyOf2;
            iArr3 = iArr4;
            long j32 = j26 + zzajmVar.zzh[i55];
            i55++;
            j26 = j32;
            iArr11 = iArr16;
            jArrCopyOf2 = jArr18;
            iArr = iArr;
            iArr15 = iArr15;
        }
        return new zzajp(zzajmVar, jArr15, iArr14, i25, jArr16, iArr15, zzfy.zzs(j26, 1000000L, zzajmVar.zzd, RoundingMode.FLOOR));
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:133:0x01db  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:136:0x0203  */
    /* JADX WARN: Code duplicated, block: B:139:0x0220  */
    /* JADX WARN: Code duplicated, block: B:142:0x022f  */
    /* JADX WARN: Code duplicated, block: B:143:0x023a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0241  */
    /* JADX WARN: Code duplicated, block: B:147:0x024c  */
    /* JADX WARN: Code duplicated, block: B:149:0x0254  */
    /* JADX WARN: Code duplicated, block: B:151:0x025b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0271  */
    /* JADX WARN: Code duplicated, block: B:155:0x0276  */
    /* JADX WARN: Code duplicated, block: B:177:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:178:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:180:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:181:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:183:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:185:0x0313  */
    /* JADX WARN: Code duplicated, block: B:186:0x0317  */
    /* JADX WARN: Code duplicated, block: B:188:0x032b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0330 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x0332  */
    /* JADX WARN: Code duplicated, block: B:194:0x0351  */
    /* JADX WARN: Code duplicated, block: B:198:0x035c  */
    /* JADX WARN: Code duplicated, block: B:210:0x0418 A[PHI: r2
  0x0418: PHI (r2v5 int) = (r2v6 int), (r2v13 int), (r2v14 int) binds: [B:213:0x0446, B:211:0x041d, B:209:0x0416] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:212:0x043d  */
    /* JADX WARN: Code duplicated, block: B:214:0x0448  */
    /* JADX WARN: Code duplicated, block: B:216:0x0456  */
    /* JADX WARN: Code duplicated, block: B:218:0x045e  */
    /* JADX WARN: Code duplicated, block: B:227:0x048c  */
    /* JADX WARN: Code duplicated, block: B:229:0x0494 A[LOOP:3: B:225:0x0486->B:229:0x0494, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:235:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:237:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:238:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:240:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:251:0x033a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x049f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x049d A[EDGE_INSN: B:261:0x049d->B:230:0x049d BREAK  A[LOOP:3: B:225:0x0486->B:229:0x0494], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:82:0x013b  */
    private static void zzm(zzfp zzfpVar, int i11, int i12, int i13, int i14, String str, boolean z11, @Nullable zzae zzaeVar, zzais zzaisVar, int i15) throws zzcc {
        int iZzq;
        int iZzn;
        int iZzg;
        int iZzp;
        int i16;
        zzae zzaeVarZzb;
        String str2;
        int i17;
        String str3;
        List listZzm;
        zzaiq zzaiqVarZzj;
        int iZzg2;
        boolean z12;
        int iZzg3;
        int i18;
        int iZzd;
        int i19;
        int i21;
        String str4;
        byte[] bArr;
        String str5;
        String str6;
        zzfp zzfpVar2;
        int i22;
        int i23;
        int iZzm;
        int i24;
        String str7;
        boolean z13;
        int iZzm2;
        byte[] bArr2;
        int iZzm3;
        int i25;
        byte[] bArr3;
        zzfp zzfpVar3 = zzfpVar;
        int i26 = i12;
        int i27 = i13;
        zzfpVar3.zzK(i26 + 16);
        if (z11) {
            iZzq = zzfpVar.zzq();
            zzfpVar3.zzL(6);
        } else {
            zzfpVar3.zzL(8);
            iZzq = 0;
        }
        if (iZzq == 0 || iZzq == 1) {
            int iZzq2 = zzfpVar.zzq();
            zzfpVar3.zzL(6);
            iZzn = zzfpVar.zzn();
            zzfpVar3.zzK(zzfpVar.zzd() - 4);
            iZzg = zzfpVar.zzg();
            if (iZzq == 1) {
                zzfpVar3.zzL(16);
            }
            iZzp = iZzq2;
            i16 = -1;
        } else {
            if (iZzq != 2) {
                return;
            }
            zzfpVar3.zzL(16);
            iZzn = (int) Math.round(Double.longBitsToDouble(zzfpVar.zzt()));
            iZzp = zzfpVar.zzp();
            zzfpVar3.zzL(4);
            int iZzp2 = zzfpVar.zzp();
            int iZzp3 = zzfpVar.zzp();
            int i28 = iZzp3 & 1;
            int i29 = iZzp3 & 2;
            if (i28 == 0) {
                if (iZzp2 == 8) {
                    i16 = 3;
                } else if (iZzp2 == 16) {
                    i16 = i29 != 0 ? ASTNode.DEOP : 2;
                } else if (iZzp2 == 24) {
                    i16 = i29 != 0 ? 1342177280 : 21;
                } else if (iZzp2 == 32) {
                    i16 = i29 != 0 ? 1610612736 : 22;
                } else {
                    i16 = -1;
                }
            } else if (iZzp2 == 32) {
                i16 = 4;
            } else {
                i16 = -1;
            }
            zzfpVar3.zzL(8);
            iZzg = 0;
        }
        int iZzd2 = zzfpVar.zzd();
        int iIntValue = 1701733217;
        int i31 = i11;
        if (i31 == 1701733217) {
            Pair pairZzh = zzh(zzfpVar3, i26, i27);
            if (pairZzh != null) {
                iIntValue = ((Integer) pairZzh.first).intValue();
                zzaeVarZzb = zzaeVar == null ? null : zzaeVar.zzb(((zzajn) pairZzh.second).zzb);
                zzaisVar.zza[i15] = (zzajn) pairZzh.second;
            } else {
                zzaeVarZzb = zzaeVar;
            }
            zzfpVar3.zzK(iZzd2);
            i31 = iIntValue;
        } else {
            zzaeVarZzb = zzaeVar;
        }
        String str8 = "audio/mhm1";
        if (i31 == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else {
            if (i31 != 1700998451) {
                if (i31 == 1633889588) {
                    i17 = i16;
                    str2 = "audio/ac4";
                } else if (i31 == 1685353315) {
                    str2 = MimeTypes.AUDIO_DTS;
                } else if (i31 == 1685353320 || i31 == 1685353324) {
                    str2 = MimeTypes.AUDIO_DTS_HD;
                } else if (i31 == 1685353317) {
                    str2 = MimeTypes.AUDIO_DTS_EXPRESS;
                } else if (i31 == 1685353336) {
                    str2 = "audio/vnd.dts.uhd;profile=p2";
                } else if (i31 == 1935764850) {
                    str2 = MimeTypes.AUDIO_AMR_NB;
                } else if (i31 == 1935767394) {
                    str2 = MimeTypes.AUDIO_AMR_WB;
                } else if (i31 == 1936684916) {
                    str2 = MimeTypes.AUDIO_RAW;
                    i17 = 2;
                } else if (i31 == 1953984371) {
                    str2 = MimeTypes.AUDIO_RAW;
                    i17 = ASTNode.DEOP;
                } else if (i31 == 1819304813) {
                    if (i16 == -1) {
                        str2 = MimeTypes.AUDIO_RAW;
                        i17 = 2;
                    } else {
                        i17 = i16;
                        str2 = MimeTypes.AUDIO_RAW;
                    }
                } else if (i31 == 778924082 || i31 == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (i31 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (i31 == 1835560241) {
                    i17 = i16;
                    str2 = "audio/mhm1";
                } else if (i31 == 1634492771) {
                    str2 = MimeTypes.AUDIO_ALAC;
                } else if (i31 == 1634492791) {
                    str2 = MimeTypes.AUDIO_ALAW;
                } else if (i31 == 1970037111) {
                    str2 = MimeTypes.AUDIO_MLAW;
                } else if (i31 == 1332770163) {
                    str2 = MimeTypes.AUDIO_OPUS;
                } else if (i31 == 1716281667) {
                    str2 = MimeTypes.AUDIO_FLAC;
                } else if (i31 == 1835823201) {
                    str2 = MimeTypes.AUDIO_TRUEHD;
                } else {
                    i17 = i16;
                    str2 = null;
                }
                int i32 = i17;
                str3 = null;
                listZzm = null;
                zzaiqVarZzj = null;
                while (iZzd2 - i26 < i27) {
                    zzfpVar3.zzK(iZzd2);
                    iZzg2 = zzfpVar.zzg();
                    if (iZzg2 > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    String str9 = "childAtomSize must be positive";
                    zzacy.zzb(z12, "childAtomSize must be positive");
                    iZzg3 = zzfpVar.zzg();
                    i18 = iZzn;
                    if (iZzg3 == 1835557187) {
                        zzfpVar3.zzK(iZzd2 + 8);
                        zzfpVar3.zzL(1);
                        iZzm3 = zzfpVar.zzm();
                        zzfpVar3.zzL(1);
                        if (Objects.equals(str2, str8)) {
                            i25 = 0;
                            str6 = String.format("mhm1.%02X", Integer.valueOf(iZzm3));
                        } else {
                            i25 = 0;
                            str6 = String.format("mha1.%02X", Integer.valueOf(iZzm3));
                        }
                        int iZzq3 = zzfpVar.zzq();
                        bArr3 = new byte[iZzq3];
                        zzfpVar3.zzG(bArr3, i25, iZzq3);
                        if (listZzm == null) {
                            listZzm = zzgaa.zzm(bArr3);
                        } else {
                            listZzm = zzgaa.zzn(bArr3, (byte[]) listZzm.get(i25));
                        }
                    } else {
                        str8 = str8;
                        if (iZzg3 == 1835557200) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            iZzm2 = zzfpVar.zzm();
                            if (iZzm2 > 0) {
                                bArr2 = new byte[iZzm2];
                                zzfpVar3.zzG(bArr2, 0, iZzm2);
                                if (listZzm == null) {
                                    listZzm = zzgaa.zzm(bArr2);
                                } else {
                                    listZzm = zzgaa.zzn((byte[]) listZzm.get(0), bArr2);
                                }
                                str6 = str3;
                            }
                            i18 = i18;
                            i21 = iZzg;
                            iZzn = i18;
                            str6 = str3;
                        } else {
                            if (iZzg3 == 1702061171) {
                                i18 = i18;
                                iZzd = iZzd2;
                                i19 = -1;
                            } else if (z11 || iZzg3 != 2002876005) {
                                if (iZzg3 == 1684103987) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    zzaisVar.zzb = zzabv.zzc(zzfpVar3, Integer.toString(i14), str, zzaeVarZzb);
                                } else if (iZzg3 == 1684366131) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    zzaisVar.zzb = zzabv.zzd(zzfpVar3, Integer.toString(i14), str, zzaeVarZzb);
                                } else if (iZzg3 == 1684103988) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    String string = Integer.toString(i14);
                                    int i33 = zzaby.zza;
                                    zzfpVar3.zzL(1);
                                    iZzm = zzfpVar.zzm() & 32;
                                    zzak zzakVar = new zzak();
                                    zzakVar.zzK(string);
                                    zzakVar.zzW("audio/ac4");
                                    zzakVar.zzy(2);
                                    if (1 != (iZzm >> 5)) {
                                        i24 = 44100;
                                    } else {
                                        i24 = 48000;
                                    }
                                    zzakVar.zzX(i24);
                                    zzakVar.zzE(zzaeVarZzb);
                                    zzakVar.zzN(str);
                                    zzaisVar.zzb = zzakVar.zzac();
                                } else if (iZzg3 != 1684892784) {
                                    if (iZzg3 != 1684305011 || iZzg3 == 1969517683) {
                                        zzak zzakVar2 = new zzak();
                                        zzakVar2.zzJ(i14);
                                        zzakVar2.zzW(str2);
                                        zzakVar2.zzy(iZzp);
                                        i18 = i18;
                                        zzakVar2.zzX(i18);
                                        zzakVar2.zzE(zzaeVarZzb);
                                        zzakVar2.zzN(str);
                                        zzaisVar.zzb = zzakVar2.zzac();
                                    } else if (iZzg3 == 1682927731) {
                                        int i34 = iZzg2 - 8;
                                        byte[] bArr4 = zza;
                                        byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i34);
                                        zzfpVar3.zzK(iZzd2 + 8);
                                        zzfpVar3.zzG(bArrCopyOf, bArr4.length, i34);
                                        listZzm = zzadq.zze(bArrCopyOf);
                                        str6 = str3;
                                    } else if (iZzg3 == 1684425825) {
                                        byte[] bArr5 = new byte[iZzg2 - 8];
                                        bArr5[0] = 102;
                                        bArr5[1] = 76;
                                        bArr5[2] = 97;
                                        bArr5[3] = 67;
                                        zzfpVar3.zzK(iZzd2 + 12);
                                        zzfpVar3.zzG(bArr5, 4, iZzg2 - 12);
                                        listZzm = zzgaa.zzm(bArr5);
                                        str6 = str3;
                                        iZzn = i18;
                                        i21 = iZzg;
                                    } else {
                                        if (iZzg3 == 1634492771) {
                                            int i35 = iZzg2 - 12;
                                            byte[] bArr6 = new byte[i35];
                                            zzfpVar3.zzK(iZzd2 + 12);
                                            zzfpVar3.zzG(bArr6, 0, i35);
                                            int i36 = zzem.zza;
                                            zzfp zzfpVar4 = new zzfp(bArr6);
                                            zzfpVar4.zzK(9);
                                            int iZzm4 = zzfpVar4.zzm();
                                            zzfpVar4.zzK(20);
                                            Pair pairCreate = Pair.create(Integer.valueOf(zzfpVar4.zzp()), Integer.valueOf(iZzm4));
                                            int iIntValue2 = ((Integer) pairCreate.first).intValue();
                                            int iIntValue3 = ((Integer) pairCreate.second).intValue();
                                            listZzm = zzgaa.zzm(bArr6);
                                            iZzp = iIntValue3;
                                            iZzn = iIntValue2;
                                            i21 = iZzg;
                                        } else {
                                            i18 = i18;
                                        }
                                        str6 = str3;
                                    }
                                    i21 = iZzg;
                                    iZzn = i18;
                                    str6 = str3;
                                } else {
                                    if (iZzg > 0) {
                                        throw zzcc.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                                    }
                                    str6 = str3;
                                    iZzn = iZzg;
                                    i21 = iZzn;
                                    iZzp = 2;
                                }
                                i18 = i18;
                                i21 = iZzg;
                                iZzn = i18;
                                str6 = str3;
                            } else {
                                iZzd = zzfpVar.zzd();
                                if (iZzd >= iZzd2) {
                                    str7 = null;
                                    z13 = true;
                                } else {
                                    str7 = null;
                                    z13 = false;
                                }
                                zzacy.zzb(z13, str7);
                                while (true) {
                                    if (iZzd - iZzd2 >= iZzg2) {
                                        iZzd = -1;
                                        break;
                                    }
                                    zzfpVar3.zzK(iZzd);
                                    int iZzg4 = zzfpVar.zzg();
                                    zzacy.zzb(iZzg4 > 0, str9);
                                    String str10 = str9;
                                    if (zzfpVar.zzg() == 1702061171) {
                                        break;
                                    }
                                    iZzd += iZzg4;
                                    str9 = str10;
                                }
                                i19 = -1;
                            }
                            if (iZzd != i19) {
                                zzaiqVarZzj = zzj(zzfpVar3, iZzd);
                                str4 = zzaiqVarZzj.zza;
                                bArr = zzaiqVarZzj.zzb;
                                if (bArr != null) {
                                    i21 = iZzg;
                                } else if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                    zzfpVar2 = new zzfp(bArr);
                                    zzfpVar2.zzL(1);
                                    i22 = 0;
                                    while (zzfpVar2.zzb() > 0 && zzfpVar2.zzf() == 255) {
                                        zzfpVar2.zzL(1);
                                        i22 += 255;
                                    }
                                    int iZzm5 = i22 + zzfpVar2.zzm();
                                    i23 = 0;
                                    while (true) {
                                        if (zzfpVar2.zzb() > 0) {
                                            i21 = iZzg;
                                            break;
                                        }
                                        i21 = iZzg;
                                        if (zzfpVar2.zzf() == 255) {
                                            break;
                                        }
                                        zzfpVar2.zzL(1);
                                        i23 += 255;
                                        iZzg = i21;
                                    }
                                    int iZzm6 = i23 + zzfpVar2.zzm();
                                    byte[] bArr7 = new byte[iZzm5];
                                    int iZzd3 = zzfpVar2.zzd();
                                    System.arraycopy(bArr, iZzd3, bArr7, 0, iZzm5);
                                    int i37 = iZzd3 + iZzm5 + iZzm6;
                                    int length = bArr.length - i37;
                                    byte[] bArr8 = new byte[length];
                                    System.arraycopy(bArr, i37, bArr8, 0, length);
                                    listZzm = zzgaa.zzn(bArr7, bArr8);
                                } else {
                                    i21 = iZzg;
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        zzabr zzabrVarZza = zzabs.zza(bArr);
                                        iZzn = zzabrVarZza.zza;
                                        iZzp = zzabrVarZza.zzb;
                                        str5 = zzabrVarZza.zzc;
                                    } else {
                                        str5 = str3;
                                        iZzn = i18;
                                    }
                                    listZzm = zzgaa.zzm(bArr);
                                    str6 = str5;
                                    str2 = str4;
                                }
                                str2 = str4;
                            } else {
                                i21 = iZzg;
                            }
                            iZzn = i18;
                            str6 = str3;
                        }
                        iZzd2 += iZzg2;
                        zzfpVar3 = zzfpVar;
                        i26 = i12;
                        str3 = str6;
                        str8 = str8;
                        iZzg = i21;
                        i27 = i13;
                    }
                    iZzn = i18;
                    i21 = iZzg;
                    iZzd2 += iZzg2;
                    zzfpVar3 = zzfpVar;
                    i26 = i12;
                    str3 = str6;
                    str8 = str8;
                    iZzg = i21;
                    i27 = i13;
                }
                int i38 = iZzn;
                if (zzaisVar.zzb == null || str2 == null) {
                }
                zzak zzakVar3 = new zzak();
                zzakVar3.zzJ(i14);
                zzakVar3.zzW(str2);
                zzakVar3.zzz(str3);
                zzakVar3.zzy(iZzp);
                zzakVar3.zzX(i38);
                zzakVar3.zzQ(i32);
                zzakVar3.zzL(listZzm);
                zzakVar3.zzE(zzaeVarZzb);
                zzakVar3.zzN(str);
                if (zzaiqVarZzj != null) {
                    zzakVar3.zzx(zzgcu.zzc(zzaiqVarZzj.zzc));
                    zzakVar3.zzR(zzgcu.zzc(zzaiqVarZzj.zzd));
                }
                zzaisVar.zzb = zzakVar3.zzac();
                return;
            }
            str2 = MimeTypes.AUDIO_E_AC3;
        }
        i17 = i16;
        int i39 = i17;
        str3 = null;
        listZzm = null;
        zzaiqVarZzj = null;
        while (iZzd2 - i26 < i27) {
            zzfpVar3.zzK(iZzd2);
            iZzg2 = zzfpVar.zzg();
            if (iZzg2 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            String str11 = "childAtomSize must be positive";
            zzacy.zzb(z12, "childAtomSize must be positive");
            iZzg3 = zzfpVar.zzg();
            i18 = iZzn;
            if (iZzg3 == 1835557187) {
                zzfpVar3.zzK(iZzd2 + 8);
                zzfpVar3.zzL(1);
                iZzm3 = zzfpVar.zzm();
                zzfpVar3.zzL(1);
                if (Objects.equals(str2, str8)) {
                    i25 = 0;
                    str6 = String.format("mhm1.%02X", Integer.valueOf(iZzm3));
                } else {
                    i25 = 0;
                    str6 = String.format("mha1.%02X", Integer.valueOf(iZzm3));
                }
                int iZzq4 = zzfpVar.zzq();
                bArr3 = new byte[iZzq4];
                zzfpVar3.zzG(bArr3, i25, iZzq4);
                if (listZzm == null) {
                    listZzm = zzgaa.zzm(bArr3);
                } else {
                    listZzm = zzgaa.zzn(bArr3, (byte[]) listZzm.get(i25));
                }
            } else {
                str8 = str8;
                if (iZzg3 == 1835557200) {
                    zzfpVar3.zzK(iZzd2 + 8);
                    iZzm2 = zzfpVar.zzm();
                    if (iZzm2 > 0) {
                        bArr2 = new byte[iZzm2];
                        zzfpVar3.zzG(bArr2, 0, iZzm2);
                        if (listZzm == null) {
                            listZzm = zzgaa.zzm(bArr2);
                        } else {
                            listZzm = zzgaa.zzn((byte[]) listZzm.get(0), bArr2);
                        }
                        str6 = str3;
                    }
                    i18 = i18;
                    i21 = iZzg;
                    iZzn = i18;
                    str6 = str3;
                } else {
                    if (iZzg3 == 1702061171) {
                        if (z11) {
                        }
                        if (iZzg3 == 1684103987) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            zzaisVar.zzb = zzabv.zzc(zzfpVar3, Integer.toString(i14), str, zzaeVarZzb);
                        } else if (iZzg3 == 1684366131) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            zzaisVar.zzb = zzabv.zzd(zzfpVar3, Integer.toString(i14), str, zzaeVarZzb);
                        } else if (iZzg3 == 1684103988) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            String string2 = Integer.toString(i14);
                            int i310 = zzaby.zza;
                            zzfpVar3.zzL(1);
                            iZzm = zzfpVar.zzm() & 32;
                            zzak zzakVar4 = new zzak();
                            zzakVar4.zzK(string2);
                            zzakVar4.zzW("audio/ac4");
                            zzakVar4.zzy(2);
                            if (1 != (iZzm >> 5)) {
                                i24 = 44100;
                            } else {
                                i24 = 48000;
                            }
                            zzakVar4.zzX(i24);
                            zzakVar4.zzE(zzaeVarZzb);
                            zzakVar4.zzN(str);
                            zzaisVar.zzb = zzakVar4.zzac();
                        } else if (iZzg3 != 1684892784) {
                            if (iZzg > 0) {
                                throw zzcc.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                            }
                            str6 = str3;
                            iZzn = iZzg;
                            i21 = iZzn;
                            iZzp = 2;
                        } else if (iZzg3 != 1684305011) {
                            zzak zzakVar5 = new zzak();
                            zzakVar5.zzJ(i14);
                            zzakVar5.zzW(str2);
                            zzakVar5.zzy(iZzp);
                            i18 = i18;
                            zzakVar5.zzX(i18);
                            zzakVar5.zzE(zzaeVarZzb);
                            zzakVar5.zzN(str);
                            zzaisVar.zzb = zzakVar5.zzac();
                            i21 = iZzg;
                            iZzn = i18;
                            str6 = str3;
                        } else {
                            zzak zzakVar6 = new zzak();
                            zzakVar6.zzJ(i14);
                            zzakVar6.zzW(str2);
                            zzakVar6.zzy(iZzp);
                            i18 = i18;
                            zzakVar6.zzX(i18);
                            zzakVar6.zzE(zzaeVarZzb);
                            zzakVar6.zzN(str);
                            zzaisVar.zzb = zzakVar6.zzac();
                            i21 = iZzg;
                            iZzn = i18;
                            str6 = str3;
                        }
                        i18 = i18;
                        i21 = iZzg;
                        iZzn = i18;
                        str6 = str3;
                    } else {
                        i18 = i18;
                        iZzd = iZzd2;
                        i19 = -1;
                    }
                    if (iZzd != i19) {
                        zzaiqVarZzj = zzj(zzfpVar3, iZzd);
                        str4 = zzaiqVarZzj.zza;
                        bArr = zzaiqVarZzj.zzb;
                        if (bArr != null) {
                            i21 = iZzg;
                        } else if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                            zzfpVar2 = new zzfp(bArr);
                            zzfpVar2.zzL(1);
                            i22 = 0;
                            while (zzfpVar2.zzb() > 0) {
                                zzfpVar2.zzL(1);
                                i22 += 255;
                            }
                            int iZzm7 = i22 + zzfpVar2.zzm();
                            i23 = 0;
                            while (true) {
                                if (zzfpVar2.zzb() > 0) {
                                    i21 = iZzg;
                                    break;
                                }
                                i21 = iZzg;
                                if (zzfpVar2.zzf() == 255) {
                                    break;
                                    break;
                                } else {
                                    zzfpVar2.zzL(1);
                                    i23 += 255;
                                    iZzg = i21;
                                }
                            }
                            int iZzm8 = i23 + zzfpVar2.zzm();
                            byte[] bArr9 = new byte[iZzm7];
                            int iZzd4 = zzfpVar2.zzd();
                            System.arraycopy(bArr, iZzd4, bArr9, 0, iZzm7);
                            int i311 = iZzd4 + iZzm7 + iZzm8;
                            int length2 = bArr.length - i311;
                            byte[] bArr10 = new byte[length2];
                            System.arraycopy(bArr, i311, bArr10, 0, length2);
                            listZzm = zzgaa.zzn(bArr9, bArr10);
                        } else {
                            i21 = iZzg;
                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                zzabr zzabrVarZza2 = zzabs.zza(bArr);
                                iZzn = zzabrVarZza2.zza;
                                iZzp = zzabrVarZza2.zzb;
                                str5 = zzabrVarZza2.zzc;
                            } else {
                                str5 = str3;
                                iZzn = i18;
                            }
                            listZzm = zzgaa.zzm(bArr);
                            str6 = str5;
                            str2 = str4;
                        }
                        str2 = str4;
                    } else {
                        i21 = iZzg;
                    }
                    iZzn = i18;
                    str6 = str3;
                }
                iZzd2 += iZzg2;
                zzfpVar3 = zzfpVar;
                i26 = i12;
                str3 = str6;
                str8 = str8;
                iZzg = i21;
                i27 = i13;
            }
            iZzn = i18;
            i21 = iZzg;
            iZzd2 += iZzg2;
            zzfpVar3 = zzfpVar;
            i26 = i12;
            str3 = str6;
            str8 = str8;
            iZzg = i21;
            i27 = i13;
        }
        int i312 = iZzn;
        if (zzaisVar.zzb == null) {
        }
    }
}
