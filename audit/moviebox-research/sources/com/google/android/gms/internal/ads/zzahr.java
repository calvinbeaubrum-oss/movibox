package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzahr implements zzaht {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzaia zzc = new zzaia();
    private zzahs zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzacv zzacvVar, int i11) throws IOException {
        ((zzack) zzacvVar).zzn(this.zza, 0, i11, false);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.zza[i12] & 255));
        }
        return j11;
    }

    @Override // com.google.android.gms.internal.ads.zzaht
    public final void zza(zzahs zzahsVar) {
        this.zzd = zzahsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaht
    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b4 A[LOOP:0: B:3:0x0005->B:37:0x00b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:57:0x0133  */
    /* JADX WARN: Code duplicated, block: B:59:0x0136  */
    /* JADX WARN: Code duplicated, block: B:60:0x0139  */
    /* JADX WARN: Code duplicated, block: B:62:0x0142  */
    /* JADX WARN: Code duplicated, block: B:64:0x0148 A[LOOP:2: B:61:0x0140->B:64:0x0148, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0157  */
    /* JADX WARN: Code duplicated, block: B:72:0x0173  */
    /* JADX WARN: Code duplicated, block: B:74:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x016d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x014a A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x0157, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x0180, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzaht
    public final boolean zzc(zzacv zzacvVar) throws IOException {
        int i11;
        zzahw zzahwVar;
        zzahy zzahyVar;
        long j11;
        long j12;
        int i12;
        byte[] bArr;
        String str;
        int i13;
        long j13;
        int i14;
        long jZzd;
        double dLongBitsToDouble;
        zzack zzackVar;
        int iZzb;
        int iZzc;
        zzek.zzb(this.zzd);
        while (true) {
            zzahq zzahqVar = (zzahq) this.zzb.peek();
            if (zzahqVar != null && zzacvVar.zzf() >= zzahqVar.zzb) {
                ((zzahw) this.zzd).zza.zzh(((zzahq) this.zzb.pop()).zza);
                return true;
            }
            int i15 = this.zze;
            if (i15 != 0) {
                if (i15 == 1) {
                }
                zzahs zzahsVar = this.zzd;
                i11 = this.zzf;
                zzahwVar = (zzahw) zzahsVar;
                zzahyVar = zzahwVar.zza;
                switch (i11) {
                    case 131:
                    case 136:
                    case 155:
                    case 159:
                    case 176:
                    case 179:
                    case 186:
                    case 215:
                    case 231:
                    case 238:
                    case 241:
                    case 251:
                    case 16871:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21432:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 21930:
                    case 21938:
                    case 21945:
                    case 21946:
                    case 21947:
                    case 21948:
                    case 21949:
                    case 21998:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 30114:
                    case 30321:
                    case 2352003:
                    case 2807729:
                        j11 = this.zzg;
                        if (j11 <= 8) {
                            zzahwVar.zza.zzj(i11, zzd(zzacvVar, (int) j11));
                            this.zze = 0;
                            return true;
                        }
                        throw zzcc.zza("Invalid integer size: " + j11, null);
                    case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                    case 17026:
                    case 21358:
                    case 2274716:
                        j12 = this.zzg;
                        if (j12 <= 2147483647L) {
                            throw zzcc.zza("String element size: " + j12, null);
                        }
                        i12 = (int) j12;
                        if (i12 == 0) {
                            str = "";
                        } else {
                            bArr = new byte[i12];
                            ((zzack) zzacvVar).zzn(bArr, 0, i12, false);
                            while (i12 > 0) {
                                i13 = i12 - 1;
                                if (bArr[i13] == 0) {
                                    i12 = i13;
                                } else {
                                    str = new String(bArr, 0, i12);
                                }
                            }
                            str = new String(bArr, 0, i12);
                        }
                        zzahwVar.zza.zzl(i11, str);
                        this.zze = 0;
                        return true;
                    case 160:
                    case 166:
                    case 174:
                    case 183:
                    case 187:
                    case 224:
                    case 225:
                    case 16868:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 21936:
                    case 21968:
                    case 25152:
                    case 28032:
                    case 30113:
                    case 30320:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        long jZzf = zzacvVar.zzf();
                        this.zzb.push(new zzahq(i11, this.zzg + jZzf, null));
                        ((zzahw) this.zzd).zza.zzk(this.zzf, jZzf, this.zzg);
                        this.zze = 0;
                        return true;
                    case 161:
                    case 163:
                    case 165:
                    case 16877:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                    case 30322:
                        zzahyVar.zzg(i11, (int) this.zzg, zzacvVar);
                        this.zze = 0;
                        return true;
                    case 181:
                    case 17545:
                    case 21969:
                    case 21970:
                    case 21971:
                    case 21972:
                    case 21973:
                    case 21974:
                    case 21975:
                    case 21976:
                    case 21977:
                    case 21978:
                    case 30323:
                    case 30324:
                    case 30325:
                        j13 = this.zzg;
                        if (j13 == 4 && j13 != 8) {
                            throw zzcc.zza("Invalid float size: " + j13, null);
                        }
                        i14 = (int) j13;
                        jZzd = zzd(zzacvVar, i14);
                        if (i14 == 4) {
                            dLongBitsToDouble = Float.intBitsToFloat((int) jZzd);
                        } else {
                            dLongBitsToDouble = Double.longBitsToDouble(jZzd);
                        }
                        zzahwVar.zza.zzi(i11, dLongBitsToDouble);
                        this.zze = 0;
                        return true;
                    default:
                        ((zzack) zzacvVar).zzo((int) this.zzg, false);
                        this.zze = 0;
                        break;
                }
            } else {
                long jZzd2 = this.zzc.zzd(zzacvVar, true, false, 4);
                if (jZzd2 == -2) {
                    zzacvVar.zzj();
                    while (true) {
                        zzackVar = (zzack) zzacvVar;
                        zzackVar.zzm(this.zza, 0, 4, false);
                        iZzb = zzaia.zzb(this.zza[0]);
                        if (iZzb != -1 && iZzb <= 4) {
                            iZzc = (int) zzaia.zzc(this.zza, iZzb, false);
                            zzahy zzahyVar2 = ((zzahw) this.zzd).zza;
                            if (iZzc != 357149030 && iZzc != 524531317 && iZzc != 475249515) {
                                if (iZzc == 374648427) {
                                    iZzc = 374648427;
                                }
                            }
                        }
                        zzackVar.zzo(1, false);
                    }
                    zzackVar.zzo(iZzb, false);
                    jZzd2 = iZzc;
                }
                if (jZzd2 == -1) {
                    return false;
                }
                this.zzf = (int) jZzd2;
                this.zze = 1;
            }
            this.zzg = this.zzc.zzd(zzacvVar, false, true, 8);
            this.zze = 2;
            zzahs zzahsVar2 = this.zzd;
            i11 = this.zzf;
            zzahwVar = (zzahw) zzahsVar2;
            zzahyVar = zzahwVar.zza;
            switch (i11) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 238:
                case 241:
                case 251:
                case 16871:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21938:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 21998:
                case 22186:
                case 22203:
                case 25188:
                case 30114:
                case 30321:
                case 2352003:
                case 2807729:
                    j11 = this.zzg;
                    if (j11 <= 8) {
                        zzahwVar.zza.zzj(i11, zzd(zzacvVar, (int) j11));
                        this.zze = 0;
                        return true;
                    }
                    throw zzcc.zza("Invalid integer size: " + j11, null);
                case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                case 17026:
                case 21358:
                case 2274716:
                    j12 = this.zzg;
                    if (j12 <= 2147483647L) {
                        throw zzcc.zza("String element size: " + j12, null);
                    }
                    i12 = (int) j12;
                    if (i12 == 0) {
                        str = "";
                    } else {
                        bArr = new byte[i12];
                        ((zzack) zzacvVar).zzn(bArr, 0, i12, false);
                        while (i12 > 0) {
                            i13 = i12 - 1;
                            if (bArr[i13] == 0) {
                                i12 = i13;
                            } else {
                                str = new String(bArr, 0, i12);
                            }
                        }
                        str = new String(bArr, 0, i12);
                    }
                    zzahwVar.zza.zzl(i11, str);
                    this.zze = 0;
                    return true;
                case 160:
                case 166:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 16868:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30113:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    long jZzf2 = zzacvVar.zzf();
                    this.zzb.push(new zzahq(i11, this.zzg + jZzf2, null));
                    ((zzahw) this.zzd).zza.zzk(this.zzf, jZzf2, this.zzg);
                    this.zze = 0;
                    return true;
                case 161:
                case 163:
                case 165:
                case 16877:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    zzahyVar.zzg(i11, (int) this.zzg, zzacvVar);
                    this.zze = 0;
                    return true;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                case 30323:
                case 30324:
                case 30325:
                    j13 = this.zzg;
                    if (j13 == 4) {
                        break;
                    }
                    i14 = (int) j13;
                    jZzd = zzd(zzacvVar, i14);
                    if (i14 == 4) {
                        dLongBitsToDouble = Float.intBitsToFloat((int) jZzd);
                    } else {
                        dLongBitsToDouble = Double.longBitsToDouble(jZzd);
                    }
                    zzahwVar.zza.zzi(i11, dLongBitsToDouble);
                    this.zze = 0;
                    return true;
                default:
                    ((zzack) zzacvVar).zzo((int) this.zzg, false);
                    this.zze = 0;
                    break;
            }
        }
    }
}
