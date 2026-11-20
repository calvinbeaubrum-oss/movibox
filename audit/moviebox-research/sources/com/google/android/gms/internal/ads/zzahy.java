package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahy implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzahu
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzahy(0)};
        }
    };
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;

    @Nullable
    private zzahx zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;

    @Nullable
    private zzfg zzJ;

    @Nullable
    private zzfg zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzacx zzai;
    private final zzaht zzh;
    private final zzaia zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzfp zzl;
    private final zzfp zzm;
    private final zzfp zzn;
    private final zzfp zzo;
    private final zzfp zzp;
    private final zzfp zzq;
    private final zzfp zzr;
    private final zzfp zzs;
    private final zzfp zzt;
    private final zzfp zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i11 = zzfy.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfwq.zzc);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    public zzahy() {
        this(0);
    }

    public zzahy(int i11) {
        zzahr zzahrVar = new zzahr();
        this.zzx = -1L;
        this.zzy = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzA = C.TIME_UNSET;
        this.zzG = -1L;
        this.zzH = -1L;
        this.zzI = C.TIME_UNSET;
        this.zzh = zzahrVar;
        zzahrVar.zza(new zzahw(this, null));
        this.zzk = true;
        this.zzi = new zzaia();
        this.zzj = new SparseArray();
        this.zzn = new zzfp(4);
        this.zzo = new zzfp(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzfp(4);
        this.zzl = new zzfp(zzgm.zza);
        this.zzm = new zzfp(4);
        this.zzq = new zzfp();
        this.zzr = new zzfp();
        this.zzs = new zzfp(8);
        this.zzt = new zzfp();
        this.zzu = new zzfp();
        this.zzS = new int[1];
    }

    private final int zzn(zzacv zzacvVar, zzahx zzahxVar, int i11, boolean z11) throws IOException {
        int i12;
        if ("S_TEXT/UTF8".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zzb, i11);
            int i13 = this.zzaa;
            zzu();
            return i13;
        }
        if ("S_TEXT/ASS".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zzd, i11);
            int i14 = this.zzaa;
            zzu();
            return i14;
        }
        if ("S_TEXT/WEBVTT".equals(zzahxVar.zzb)) {
            zzv(zzacvVar, zze, i11);
            int i15 = this.zzaa;
            zzu();
            return i15;
        }
        zzaea zzaeaVar = zzahxVar.zzW;
        if (!this.zzac) {
            if (zzahxVar.zzg) {
                this.zzV &= -1073741825;
                if (!this.zzad) {
                    ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, 1, false);
                    this.zzZ++;
                    if ((this.zzn.zzM()[0] & 128) == 128) {
                        throw zzcc.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzag = this.zzn.zzM()[0];
                    this.zzad = true;
                }
                byte b11 = this.zzag;
                if ((b11 & 1) == 1) {
                    int i16 = b11 & 2;
                    this.zzV |= 1073741824;
                    if (!this.zzah) {
                        ((zzack) zzacvVar).zzn(this.zzs.zzM(), 0, 8, false);
                        this.zzZ += 8;
                        this.zzah = true;
                        this.zzn.zzM()[0] = (byte) ((i16 != 2 ? 0 : 128) | 8);
                        this.zzn.zzK(0);
                        zzaeaVar.zzs(this.zzn, 1, 1);
                        this.zzaa++;
                        this.zzs.zzK(0);
                        zzaeaVar.zzs(this.zzs, 8, 1);
                        this.zzaa += 8;
                    }
                    if (i16 == 2) {
                        if (!this.zzae) {
                            ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, 1, false);
                            this.zzZ++;
                            this.zzn.zzK(0);
                            this.zzaf = this.zzn.zzm();
                            this.zzae = true;
                        }
                        int i17 = this.zzaf * 4;
                        this.zzn.zzH(i17);
                        ((zzack) zzacvVar).zzn(this.zzn.zzM(), 0, i17, false);
                        this.zzZ += i17;
                        int i18 = (this.zzaf >> 1) + 1;
                        int i19 = (i18 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i19) {
                            this.zzv = ByteBuffer.allocate(i19);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i18);
                        int i21 = 0;
                        int i22 = 0;
                        while (true) {
                            i12 = this.zzaf;
                            if (i21 >= i12) {
                                break;
                            }
                            int iZzp = this.zzn.zzp();
                            int i23 = iZzp - i22;
                            if (i21 % 2 == 0) {
                                this.zzv.putShort((short) i23);
                            } else {
                                this.zzv.putInt(i23);
                            }
                            i21++;
                            i22 = iZzp;
                        }
                        int i24 = (i11 - this.zzZ) - i22;
                        if ((i12 & 1) == 1) {
                            this.zzv.putInt(i24);
                        } else {
                            this.zzv.putShort((short) i24);
                            this.zzv.putInt(0);
                        }
                        this.zzt.zzI(this.zzv.array(), i19);
                        zzaeaVar.zzs(this.zzt, i19, 1);
                        this.zzaa += i19;
                    }
                }
            } else {
                byte[] bArr = zzahxVar.zzh;
                if (bArr != null) {
                    this.zzq.zzI(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahxVar.zzb) ? zzahxVar.zzf > 0 : z11) {
                this.zzV |= ASTNode.DEOP;
                this.zzu.zzH(0);
                int iZze = (this.zzq.zze() + i11) - this.zzZ;
                this.zzn.zzH(4);
                this.zzn.zzM()[0] = (byte) ((iZze >> 24) & 255);
                this.zzn.zzM()[1] = (byte) ((iZze >> 16) & 255);
                this.zzn.zzM()[2] = (byte) ((iZze >> 8) & 255);
                this.zzn.zzM()[3] = (byte) (iZze & 255);
                zzaeaVar.zzs(this.zzn, 4, 2);
                this.zzaa += 4;
            }
            this.zzac = true;
        }
        int iZze2 = i11 + this.zzq.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzahxVar.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzahxVar.zzb)) {
            if (zzahxVar.zzT != null) {
                zzek.zzf(this.zzq.zze() == 0);
                zzahxVar.zzT.zzd(zzacvVar);
            }
            while (true) {
                int i25 = this.zzZ;
                if (i25 >= iZze2) {
                    break;
                }
                int iZzo = zzo(zzacvVar, zzaeaVar, iZze2 - i25);
                this.zzZ += iZzo;
                this.zzaa += iZzo;
            }
        } else {
            byte[] bArrZzM = this.zzm.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i26 = zzahxVar.zzX;
            int i27 = 4 - i26;
            while (this.zzZ < iZze2) {
                int i28 = this.zzab;
                if (i28 == 0) {
                    int iMin = Math.min(i26, this.zzq.zzb());
                    ((zzack) zzacvVar).zzn(bArrZzM, i27 + iMin, i26 - iMin, false);
                    if (iMin > 0) {
                        this.zzq.zzG(bArrZzM, i27, iMin);
                    }
                    this.zzZ += i26;
                    this.zzm.zzK(0);
                    this.zzab = this.zzm.zzp();
                    this.zzl.zzK(0);
                    zzady.zzb(zzaeaVar, this.zzl, 4);
                    this.zzaa += 4;
                } else {
                    int iZzo2 = zzo(zzacvVar, zzaeaVar, i28);
                    this.zzZ += iZzo2;
                    this.zzaa += iZzo2;
                    this.zzab -= iZzo2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahxVar.zzb)) {
            this.zzo.zzK(0);
            zzady.zzb(zzaeaVar, this.zzo, 4);
            this.zzaa += 4;
        }
        int i29 = this.zzaa;
        zzu();
        return i29;
    }

    private final int zzo(zzacv zzacvVar, zzaea zzaeaVar, int i11) throws IOException {
        int iZzb = this.zzq.zzb();
        if (iZzb <= 0) {
            return zzady.zza(zzaeaVar, zzacvVar, i11, false);
        }
        int iMin = Math.min(i11, iZzb);
        zzady.zzb(zzaeaVar, this.zzq, iMin);
        return iMin;
    }

    private final long zzp(long j11) throws zzcc {
        long j12 = this.zzy;
        if (j12 != C.TIME_UNSET) {
            return zzfy.zzs(j11, j12, 1000L, RoundingMode.FLOOR);
        }
        throw zzcc.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private final void zzq(int i11) throws zzcc {
        if (this.zzJ == null || this.zzK == null) {
            throw zzcc.zza("Element " + i11 + " must be in a Cues", null);
        }
    }

    private final void zzr(int i11) throws zzcc {
        if (this.zzB != null) {
            return;
        }
        throw zzcc.zza("Element " + i11 + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    private final void zzs(zzahx zzahxVar, long j11, int i11, int i12, int i13) {
        byte b11;
        byte[] bArrZzw;
        int i14;
        int iZze;
        zzaeb zzaebVar = zzahxVar.zzT;
        if (zzaebVar != null) {
            zzaebVar.zzc(zzahxVar.zzW, j11, i11, i12, i13, zzahxVar.zzi);
        } else {
            if ("S_TEXT/UTF8".equals(zzahxVar.zzb) || "S_TEXT/ASS".equals(zzahxVar.zzb) || "S_TEXT/WEBVTT".equals(zzahxVar.zzb)) {
                if (this.zzR > 1) {
                    zzff.zzf("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.zzP;
                    if (j12 == C.TIME_UNSET) {
                        zzff.zzf("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = zzahxVar.zzb;
                        byte[] bArrZzM = this.zzr.zzM();
                        int iHashCode = str.hashCode();
                        if (iHashCode != 738597099) {
                            if (iHashCode != 1045209816) {
                                if (iHashCode == 1422270023 && str.equals("S_TEXT/UTF8")) {
                                    b11 = 0;
                                } else {
                                    b11 = -1;
                                }
                            } else if (str.equals("S_TEXT/WEBVTT")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                        } else if (str.equals("S_TEXT/ASS")) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                        if (b11 == 0) {
                            bArrZzw = zzw(j12, "%02d:%02d:%02d,%03d", 1000L);
                            i14 = 19;
                        } else if (b11 == 1) {
                            bArrZzw = zzw(j12, "%01d:%02d:%02d:%02d", 10000L);
                            i14 = 21;
                        } else {
                            if (b11 != 2) {
                                throw new IllegalArgumentException();
                            }
                            bArrZzw = zzw(j12, "%02d:%02d:%02d.%03d", 1000L);
                            i14 = 25;
                        }
                        System.arraycopy(bArrZzw, 0, bArrZzM, i14, bArrZzw.length);
                        for (int iZzd = this.zzr.zzd(); iZzd < this.zzr.zze(); iZzd++) {
                            if (this.zzr.zzM()[iZzd] == 0) {
                                this.zzr.zzJ(iZzd);
                                break;
                            }
                        }
                        zzaea zzaeaVar = zzahxVar.zzW;
                        zzfp zzfpVar = this.zzr;
                        zzady.zzb(zzaeaVar, zzfpVar, zzfpVar.zze());
                        iZze = i12 + this.zzr.zze();
                    }
                }
                iZze = i12;
            } else {
                iZze = i12;
            }
            if ((i11 & ASTNode.DEOP) != 0) {
                if (this.zzR > 1) {
                    this.zzu.zzH(0);
                } else {
                    int iZze2 = this.zzu.zze();
                    zzahxVar.zzW.zzs(this.zzu, iZze2, 2);
                    iZze += iZze2;
                }
            }
            zzahxVar.zzW.zzt(j11, i11, iZze, i13, zzahxVar.zzi);
        }
        this.zzM = true;
    }

    private final void zzt(zzacv zzacvVar, int i11) throws IOException {
        if (this.zzn.zze() >= i11) {
            return;
        }
        if (this.zzn.zzc() < i11) {
            zzfp zzfpVar = this.zzn;
            int iZzc = zzfpVar.zzc();
            zzfpVar.zzE(Math.max(iZzc + iZzc, i11));
        }
        zzfp zzfpVar2 = this.zzn;
        ((zzack) zzacvVar).zzn(zzfpVar2.zzM(), zzfpVar2.zze(), i11 - zzfpVar2.zze(), false);
        this.zzn.zzJ(i11);
    }

    private final void zzu() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = (byte) 0;
        this.zzah = false;
        this.zzq.zzH(0);
    }

    private final void zzv(zzacv zzacvVar, byte[] bArr, int i11) throws IOException {
        int length = bArr.length;
        int i12 = length + i11;
        if (this.zzr.zzc() < i12) {
            zzfp zzfpVar = this.zzr;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i12 + i11);
            zzfpVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzM(), 0, length);
        }
        ((zzack) zzacvVar).zzn(this.zzr.zzM(), length, i11, false);
        this.zzr.zzK(0);
        this.zzr.zzJ(i12);
    }

    private static byte[] zzw(long j11, String str, long j12) {
        zzek.zzd(j11 != C.TIME_UNSET);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) i11) * 3600000000L);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) i12) * 60000000);
        int i13 = (int) (j14 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12)));
        int i14 = zzfy.zza;
        return str2.getBytes(zzfwq.zzc);
    }

    private static int[] zzx(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        int length = iArr.length;
        return length >= i11 ? iArr : new int[Math.max(length + length, i11)];
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (!this.zzh.zzc(zzacvVar)) {
                for (int i11 = 0; i11 < this.zzj.size(); i11++) {
                    zzahx zzahxVar = (zzahx) this.zzj.valueAt(i11);
                    zzahxVar.zzW.getClass();
                    zzaeb zzaebVar = zzahxVar.zzT;
                    if (zzaebVar != null) {
                        zzaebVar.zza(zzahxVar.zzW, zzahxVar.zzi);
                    }
                }
                return -1;
            }
            long jZzf = zzacvVar.zzf();
            if (this.zzF) {
                this.zzH = jZzf;
                zzadrVar.zza = this.zzG;
                this.zzF = false;
                return 1;
            }
            if (this.zzC) {
                long j11 = this.zzH;
                if (j11 != -1) {
                    zzadrVar.zza = j11;
                    this.zzH = -1L;
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzai = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    @CallSuper
    public final void zzd(long j11, long j12) {
        this.zzI = C.TIME_UNSET;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzu();
        for (int i11 = 0; i11 < this.zzj.size(); i11++) {
            zzaeb zzaebVar = ((zzahx) this.zzj.valueAt(i11)).zzT;
            if (zzaebVar != null) {
                zzaebVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return new zzahz().zza(zzacvVar);
    }

    @CallSuper
    public final void zzg(int i11, int i12, zzacv zzacvVar) throws IOException {
        long j11;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        Throwable th2 = null;
        int i19 = 1;
        if (i18 != 161 && i18 != 163) {
            if (i18 == 165) {
                if (this.zzN != 2) {
                    return;
                }
                zzahx zzahxVar = (zzahx) this.zzj.get(this.zzT);
                if (this.zzW != 4 || !"V_VP9".equals(zzahxVar.zzb)) {
                    ((zzack) zzacvVar).zzo(i12, false);
                    return;
                }
                this.zzu.zzH(i12);
                ((zzack) zzacvVar).zzn(this.zzu.zzM(), 0, i12, false);
                return;
            }
            if (i18 == 16877) {
                zzr(i11);
                zzahx zzahxVar2 = this.zzB;
                if (zzahxVar2.zzY != 1685485123 && zzahxVar2.zzY != 1685480259) {
                    ((zzack) zzacvVar).zzo(i12, false);
                    return;
                }
                byte[] bArr = new byte[i12];
                zzahxVar2.zzN = bArr;
                ((zzack) zzacvVar).zzn(bArr, 0, i12, false);
                return;
            }
            if (i18 == 16981) {
                zzr(i11);
                byte[] bArr2 = new byte[i12];
                this.zzB.zzh = bArr2;
                ((zzack) zzacvVar).zzn(bArr2, 0, i12, false);
                return;
            }
            if (i18 == 18402) {
                byte[] bArr3 = new byte[i12];
                ((zzack) zzacvVar).zzn(bArr3, 0, i12, false);
                zzr(i11);
                this.zzB.zzi = new zzadz(1, bArr3, 0, 0);
                return;
            }
            if (i18 == 21419) {
                Arrays.fill(this.zzp.zzM(), (byte) 0);
                ((zzack) zzacvVar).zzn(this.zzp.zzM(), 4 - i12, i12, false);
                this.zzp.zzK(0);
                this.zzD = (int) this.zzp.zzu();
                return;
            }
            if (i18 == 25506) {
                zzr(i11);
                byte[] bArr4 = new byte[i12];
                this.zzB.zzj = bArr4;
                ((zzack) zzacvVar).zzn(bArr4, 0, i12, false);
                return;
            }
            if (i18 != 30322) {
                throw zzcc.zza("Unexpected id: " + i18, null);
            }
            zzr(i11);
            byte[] bArr5 = new byte[i12];
            this.zzB.zzv = bArr5;
            ((zzack) zzacvVar).zzn(bArr5, 0, i12, false);
            return;
        }
        if (this.zzN == 0) {
            this.zzT = (int) this.zzi.zzd(zzacvVar, false, true, 8);
            this.zzU = this.zzi.zza();
            this.zzP = C.TIME_UNSET;
            this.zzN = 1;
            this.zzn.zzH(0);
        }
        zzahx zzahxVar3 = (zzahx) this.zzj.get(this.zzT);
        if (zzahxVar3 == null) {
            ((zzack) zzacvVar).zzo(i12 - this.zzU, false);
            this.zzN = 0;
            return;
        }
        zzahxVar3.zzW.getClass();
        if (this.zzN == 1) {
            zzt(zzacvVar, 3);
            int i21 = (this.zzn.zzM()[2] & 6) >> 1;
            byte b11 = 255;
            if (i21 == 0) {
                this.zzR = 1;
                int[] iArrZzx = zzx(this.zzS, 1);
                this.zzS = iArrZzx;
                iArrZzx[0] = (i12 - this.zzU) - 3;
            } else {
                zzt(zzacvVar, 4);
                int i22 = (this.zzn.zzM()[3] & 255) + 1;
                this.zzR = i22;
                int[] iArrZzx2 = zzx(this.zzS, i22);
                this.zzS = iArrZzx2;
                if (i21 == 2) {
                    int i23 = (i12 - this.zzU) - 4;
                    int i24 = this.zzR;
                    Arrays.fill(iArrZzx2, 0, i24, i23 / i24);
                } else if (i21 == 1) {
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 4;
                    while (true) {
                        i14 = this.zzR - 1;
                        if (i25 >= i14) {
                            break;
                        }
                        this.zzS[i25] = 0;
                        while (true) {
                            i15 = i27 + 1;
                            zzt(zzacvVar, i15);
                            int i28 = this.zzn.zzM()[i27] & 255;
                            int[] iArr = this.zzS;
                            i16 = iArr[i25] + i28;
                            iArr[i25] = i16;
                            if (i28 != 255) {
                                break;
                            } else {
                                i27 = i15;
                            }
                        }
                        i26 += i16;
                        i25++;
                        i27 = i15;
                    }
                    this.zzS[i14] = ((i12 - this.zzU) - i27) - i26;
                } else {
                    if (i21 != 3) {
                        throw zzcc.zza("Unexpected lacing value: 2", null);
                    }
                    int i29 = 0;
                    int i31 = 4;
                    int i32 = 0;
                    while (true) {
                        int i33 = this.zzR - 1;
                        if (i29 >= i33) {
                            this.zzS[i33] = ((i12 - this.zzU) - i31) - i32;
                            break;
                        }
                        this.zzS[i29] = 0;
                        int i34 = i31 + 1;
                        zzt(zzacvVar, i34);
                        if (this.zzn.zzM()[i31] == 0) {
                            throw zzcc.zza("No valid varint length mask found", th2);
                        }
                        int i35 = 0;
                        while (true) {
                            if (i35 >= 8) {
                                j11 = 0;
                                i13 = i34;
                                break;
                            }
                            int i36 = i19 << (7 - i35);
                            if ((this.zzn.zzM()[i31] & i36) != 0) {
                                int i37 = i34 + i35;
                                zzt(zzacvVar, i37);
                                j11 = this.zzn.zzM()[i31] & b11 & (~i36);
                                int i38 = i31 + 1;
                                while (i38 < i37) {
                                    j11 = (j11 << 8) | ((long) (this.zzn.zzM()[i38] & b11));
                                    i38++;
                                    i37 = i37;
                                    b11 = 255;
                                }
                                i13 = i37;
                                if (i29 <= 0) {
                                    break;
                                }
                                j11 -= (1 << ((i35 * 7) + 6)) - 1;
                                break;
                            }
                            i35++;
                            i19 = 1;
                            b11 = 255;
                        }
                        if (j11 < -2147483648L || j11 > 2147483647L) {
                            throw zzcc.zza("EBML lacing sample size out of range.", null);
                        }
                        int[] iArr2 = this.zzS;
                        int i39 = (int) j11;
                        if (i29 != 0) {
                            i39 += iArr2[i29 - 1];
                        }
                        iArr2[i29] = i39;
                        i32 += i39;
                        i29++;
                        i31 = i13;
                        th2 = null;
                        i19 = 1;
                        b11 = 255;
                    }
                }
            }
            this.zzO = this.zzI + zzp((this.zzn.zzM()[0] << 8) | (this.zzn.zzM()[1] & 255));
            if (zzahxVar3.zzd == 2) {
                i17 = 1;
            } else {
                if (i18 == 163) {
                    if ((this.zzn.zzM()[2] & 128) == 128) {
                        i18 = 163;
                        i17 = 1;
                    } else {
                        i18 = 163;
                    }
                }
                i17 = 0;
            }
            this.zzV = i17;
            this.zzN = 2;
            this.zzQ = 0;
        }
        if (i18 == 163) {
            while (true) {
                int i40 = this.zzQ;
                if (i40 >= this.zzR) {
                    this.zzN = 0;
                    return;
                }
                zzs(zzahxVar3, ((long) ((this.zzQ * zzahxVar3.zze) / 1000)) + this.zzO, this.zzV, zzn(zzacvVar, zzahxVar3, this.zzS[i40], false), 0);
                this.zzQ++;
            }
        } else {
            while (true) {
                int i41 = this.zzQ;
                if (i41 >= this.zzR) {
                    return;
                }
                int[] iArr3 = this.zzS;
                iArr3[i41] = zzn(zzacvVar, zzahxVar3, iArr3[i41], true);
                this.zzQ++;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:187:0x0316  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @CallSuper
    public final void zzh(int i11) throws zzcc {
        int i12;
        int i13;
        zzadu zzadtVar;
        int i14;
        zzek.zzb(this.zzai);
        byte b11 = 2;
        if (i11 == 160) {
            if (this.zzN == 2) {
                zzahx zzahxVar = (zzahx) this.zzj.get(this.zzT);
                zzahxVar.zzW.getClass();
                if (this.zzY > 0 && "A_OPUS".equals(zzahxVar.zzb)) {
                    zzfp zzfpVar = this.zzu;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzY).array();
                    zzfpVar.zzI(bArrArray, bArrArray.length);
                }
                int i15 = 0;
                for (int i16 = 0; i16 < this.zzR; i16++) {
                    i15 += this.zzS[i16];
                }
                int i17 = 0;
                while (i17 < this.zzR) {
                    long j11 = this.zzO + ((long) ((zzahxVar.zze * i17) / 1000));
                    int i18 = this.zzV;
                    if (i17 == 0) {
                        if (!this.zzX) {
                            i18 |= 1;
                        }
                        i13 = i18;
                        i12 = 0;
                    } else {
                        i12 = i17;
                        i13 = i18;
                    }
                    int i19 = this.zzS[i12];
                    int i21 = i15 - i19;
                    zzs(zzahxVar, j11, i13, i19, i21);
                    i17 = i12 + 1;
                    i15 = i21;
                }
                this.zzN = 0;
                return;
            }
            return;
        }
        if (i11 != 174) {
            if (i11 == 19899) {
                int i22 = this.zzD;
                if (i22 != -1) {
                    long j12 = this.zzE;
                    if (j12 != -1) {
                        if (i22 == 475249515) {
                            this.zzG = j12;
                            return;
                        }
                        return;
                    }
                }
                throw zzcc.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i11 == 25152) {
                zzr(i11);
                zzahx zzahxVar2 = this.zzB;
                if (zzahxVar2.zzg) {
                    if (zzahxVar2.zzi == null) {
                        throw zzcc.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahxVar2.zzk = new zzae(null, new zzad(zzo.zza, null, MimeTypes.VIDEO_WEBM, this.zzB.zzi.zzb));
                    return;
                }
                return;
            }
            if (i11 == 28032) {
                zzr(i11);
                zzahx zzahxVar3 = this.zzB;
                if (zzahxVar3.zzg && zzahxVar3.zzh != null) {
                    throw zzcc.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i11 == 357149030) {
                if (this.zzy == C.TIME_UNSET) {
                    this.zzy = 1000000L;
                }
                long j13 = this.zzz;
                if (j13 != C.TIME_UNSET) {
                    this.zzA = zzp(j13);
                    return;
                }
                return;
            }
            if (i11 == 374648427) {
                if (this.zzj.size() == 0) {
                    throw zzcc.zza("No valid tracks were found", null);
                }
                this.zzai.zzD();
                return;
            }
            if (i11 != 475249515) {
                return;
            }
            if (!this.zzC) {
                zzacx zzacxVar = this.zzai;
                zzfg zzfgVar = this.zzJ;
                zzfg zzfgVar2 = this.zzK;
                if (this.zzx == -1 || this.zzA == C.TIME_UNSET || zzfgVar == null || zzfgVar.zza() == 0 || zzfgVar2 == null || zzfgVar2.zza() != zzfgVar.zza()) {
                    zzadtVar = new zzadt(this.zzA, 0L);
                } else {
                    int iZza = zzfgVar.zza();
                    int[] iArrCopyOf = new int[iZza];
                    long[] jArrCopyOf = new long[iZza];
                    long[] jArrCopyOf2 = new long[iZza];
                    long[] jArrCopyOf3 = new long[iZza];
                    for (int i23 = 0; i23 < iZza; i23++) {
                        jArrCopyOf3[i23] = zzfgVar.zzb(i23);
                        jArrCopyOf[i23] = this.zzx + zzfgVar2.zzb(i23);
                    }
                    int i24 = 0;
                    while (true) {
                        i14 = iZza - 1;
                        if (i24 >= i14) {
                            break;
                        }
                        int i25 = i24 + 1;
                        iArrCopyOf[i24] = (int) (jArrCopyOf[i25] - jArrCopyOf[i24]);
                        jArrCopyOf2[i24] = jArrCopyOf3[i25] - jArrCopyOf3[i24];
                        i24 = i25;
                    }
                    iArrCopyOf[i14] = (int) ((this.zzx + this.zzw) - jArrCopyOf[i14]);
                    long j14 = this.zzA - jArrCopyOf3[i14];
                    jArrCopyOf2[i14] = j14;
                    if (j14 <= 0) {
                        zzff.zzf("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j14);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i14);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i14);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i14);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i14);
                    }
                    zzadtVar = new zzaci(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                zzacxVar.zzO(zzadtVar);
                this.zzC = true;
            }
            this.zzJ = null;
            this.zzK = null;
            return;
        }
        zzahx zzahxVar4 = this.zzB;
        zzek.zzb(zzahxVar4);
        String str = zzahxVar4.zzb;
        if (str == null) {
            throw zzcc.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b11 = 6;
                } else {
                    b11 = -1;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b11 = 4;
                } else {
                    b11 = -1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b11 = Ascii.ETB;
                } else {
                    b11 = -1;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b11 = Ascii.DC2;
                } else {
                    b11 = -1;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b11 = Ascii.FF;
                } else {
                    b11 = -1;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b11 = Ascii.SO;
                } else {
                    b11 = -1;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b11 = Ascii.SI;
                } else {
                    b11 = -1;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b11 = 9;
                } else {
                    b11 = -1;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b11 = 32;
                } else {
                    b11 = -1;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b11 = 5;
                } else {
                    b11 = -1;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b11 = 7;
                } else {
                    b11 = -1;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b11 = Ascii.RS;
                } else {
                    b11 = -1;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b11 = Ascii.NAK;
                } else {
                    b11 = -1;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b11 = Ascii.CR;
                } else {
                    b11 = -1;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b11 = Ascii.DLE;
                } else {
                    b11 = -1;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b11 = 19;
                } else {
                    b11 = -1;
                }
                break;
            case 82318131:
                if (!str.equals("V_AV1")) {
                    b11 = -1;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b11 = Ascii.US;
                } else {
                    b11 = -1;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b11 = 10;
                } else {
                    b11 = -1;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b11 = Ascii.DC4;
                } else {
                    b11 = -1;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b11 = Ascii.SUB;
                } else {
                    b11 = -1;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b11 = Ascii.EM;
                } else {
                    b11 = -1;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b11 = Ascii.CAN;
                } else {
                    b11 = -1;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b11 = Ascii.FS;
                } else {
                    b11 = -1;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b11 = 8;
                } else {
                    b11 = -1;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b11 = Ascii.GS;
                } else {
                    b11 = -1;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b11 = Ascii.ESC;
                } else {
                    b11 = -1;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b11 = 3;
                } else {
                    b11 = -1;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b11 = 17;
                } else {
                    b11 = -1;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b11 = Ascii.SYN;
                } else {
                    b11 = -1;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b11 = Ascii.VT;
                } else {
                    b11 = -1;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 30:
            case VungleException.WEB_CRASH /* 31 */:
            case 32:
                zzahxVar4.zze(this.zzai, zzahxVar4.zzc);
                this.zzj.put(zzahxVar4.zzc, zzahxVar4);
                break;
        }
        this.zzB = null;
    }

    @CallSuper
    public final void zzi(int i11, double d11) throws zzcc {
        if (i11 == 181) {
            zzr(i11);
            this.zzB.zzQ = (int) d11;
            return;
        }
        if (i11 == 17545) {
            this.zzz = (long) d11;
            return;
        }
        switch (i11) {
            case 21969:
                zzr(i11);
                this.zzB.zzD = (float) d11;
                break;
            case 21970:
                zzr(i11);
                this.zzB.zzE = (float) d11;
                break;
            case 21971:
                zzr(i11);
                this.zzB.zzF = (float) d11;
                break;
            case 21972:
                zzr(i11);
                this.zzB.zzG = (float) d11;
                break;
            case 21973:
                zzr(i11);
                this.zzB.zzH = (float) d11;
                break;
            case 21974:
                zzr(i11);
                this.zzB.zzI = (float) d11;
                break;
            case 21975:
                zzr(i11);
                this.zzB.zzJ = (float) d11;
                break;
            case 21976:
                zzr(i11);
                this.zzB.zzK = (float) d11;
                break;
            case 21977:
                zzr(i11);
                this.zzB.zzL = (float) d11;
                break;
            case 21978:
                zzr(i11);
                this.zzB.zzM = (float) d11;
                break;
            default:
                switch (i11) {
                    case 30323:
                        zzr(i11);
                        this.zzB.zzs = (float) d11;
                        break;
                    case 30324:
                        zzr(i11);
                        this.zzB.zzt = (float) d11;
                        break;
                    case 30325:
                        zzr(i11);
                        this.zzB.zzu = (float) d11;
                        break;
                }
                break;
        }
    }

    @CallSuper
    public final void zzj(int i11, long j11) throws zzcc {
        boolean z11;
        if (i11 == 20529) {
            if (j11 == 0) {
                return;
            }
            throw zzcc.zza("ContentEncodingOrder " + j11 + " not supported", null);
        }
        if (i11 == 20530) {
            if (j11 == 1) {
                return;
            }
            throw zzcc.zza("ContentEncodingScope " + j11 + " not supported", null);
        }
        switch (i11) {
            case 131:
                zzr(i11);
                this.zzB.zzd = (int) j11;
                return;
            case 136:
                z11 = j11 == 1;
                zzr(i11);
                this.zzB.zzV = z11;
                return;
            case 155:
                this.zzP = zzp(j11);
                return;
            case 159:
                zzr(i11);
                this.zzB.zzO = (int) j11;
                return;
            case 176:
                zzr(i11);
                this.zzB.zzl = (int) j11;
                return;
            case 179:
                zzq(i11);
                this.zzJ.zzc(zzp(j11));
                return;
            case 186:
                zzr(i11);
                this.zzB.zzm = (int) j11;
                return;
            case 215:
                zzr(i11);
                this.zzB.zzc = (int) j11;
                return;
            case 231:
                this.zzI = zzp(j11);
                return;
            case 238:
                this.zzW = (int) j11;
                return;
            case 241:
                if (this.zzL) {
                    return;
                }
                zzq(i11);
                this.zzK.zzc(j11);
                this.zzL = true;
                return;
            case 251:
                this.zzX = true;
                return;
            case 16871:
                zzr(i11);
                this.zzB.zzY = (int) j11;
                return;
            case 16980:
                if (j11 == 3) {
                    return;
                }
                throw zzcc.zza("ContentCompAlgo " + j11 + " not supported", null);
            case 17029:
                if (j11 < 1 || j11 > 2) {
                    throw zzcc.zza("DocTypeReadVersion " + j11 + " not supported", null);
                }
                return;
            case 17143:
                if (j11 == 1) {
                    return;
                }
                throw zzcc.zza("EBMLReadVersion " + j11 + " not supported", null);
            case 18401:
                if (j11 == 5) {
                    return;
                }
                throw zzcc.zza("ContentEncAlgo " + j11 + " not supported", null);
            case 18408:
                if (j11 == 1) {
                    return;
                }
                throw zzcc.zza("AESSettingsCipherMode " + j11 + " not supported", null);
            case 21420:
                this.zzE = j11 + this.zzx;
                return;
            case 21432:
                int i12 = (int) j11;
                zzr(i11);
                if (i12 == 0) {
                    this.zzB.zzw = 0;
                    return;
                }
                if (i12 == 1) {
                    this.zzB.zzw = 2;
                    return;
                } else if (i12 == 3) {
                    this.zzB.zzw = 1;
                    return;
                } else {
                    if (i12 != 15) {
                        return;
                    }
                    this.zzB.zzw = 3;
                    return;
                }
            case 21680:
                zzr(i11);
                this.zzB.zzo = (int) j11;
                return;
            case 21682:
                zzr(i11);
                this.zzB.zzq = (int) j11;
                return;
            case 21690:
                zzr(i11);
                this.zzB.zzp = (int) j11;
                return;
            case 21930:
                z11 = j11 == 1;
                zzr(i11);
                this.zzB.zzU = z11;
                return;
            case 21938:
                zzr(i11);
                zzahx zzahxVar = this.zzB;
                zzahxVar.zzx = true;
                zzahxVar.zzn = (int) j11;
                return;
            case 21998:
                zzr(i11);
                this.zzB.zzf = (int) j11;
                return;
            case 22186:
                zzr(i11);
                this.zzB.zzR = j11;
                return;
            case 22203:
                zzr(i11);
                this.zzB.zzS = j11;
                return;
            case 25188:
                zzr(i11);
                this.zzB.zzP = (int) j11;
                return;
            case 30114:
                this.zzY = j11;
                return;
            case 30321:
                int i13 = (int) j11;
                zzr(i11);
                if (i13 == 0) {
                    this.zzB.zzr = 0;
                    return;
                }
                if (i13 == 1) {
                    this.zzB.zzr = 1;
                    return;
                } else if (i13 == 2) {
                    this.zzB.zzr = 2;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.zzB.zzr = 3;
                    return;
                }
            case 2352003:
                zzr(i11);
                this.zzB.zze = (int) j11;
                return;
            case 2807729:
                this.zzy = j11;
                return;
            default:
                switch (i11) {
                    case 21945:
                        int i14 = (int) j11;
                        zzr(i11);
                        if (i14 == 1) {
                            this.zzB.zzA = 2;
                            return;
                        } else {
                            if (i14 != 2) {
                                return;
                            }
                            this.zzB.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzr(i11);
                        int iZzb = zzt.zzb((int) j11);
                        if (iZzb != -1) {
                            this.zzB.zzz = iZzb;
                            return;
                        }
                        return;
                    case 21947:
                        zzr(i11);
                        this.zzB.zzx = true;
                        int iZza = zzt.zza((int) j11);
                        if (iZza != -1) {
                            this.zzB.zzy = iZza;
                            return;
                        }
                        return;
                    case 21948:
                        zzr(i11);
                        this.zzB.zzB = (int) j11;
                        return;
                    case 21949:
                        zzr(i11);
                        this.zzB.zzC = (int) j11;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public final void zzk(int i11, long j11, long j12) throws zzcc {
        zzek.zzb(this.zzai);
        if (i11 == 160) {
            this.zzX = false;
            this.zzY = 0L;
            return;
        }
        if (i11 == 174) {
            this.zzB = new zzahx();
            return;
        }
        if (i11 == 187) {
            this.zzL = false;
            return;
        }
        if (i11 == 19899) {
            this.zzD = -1;
            this.zzE = -1L;
            return;
        }
        if (i11 == 20533) {
            zzr(i11);
            this.zzB.zzg = true;
            return;
        }
        if (i11 == 21968) {
            zzr(i11);
            this.zzB.zzx = true;
            return;
        }
        if (i11 == 408125543) {
            long j13 = this.zzx;
            if (j13 != -1 && j13 != j11) {
                throw zzcc.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j11;
            this.zzw = j12;
            return;
        }
        if (i11 == 475249515) {
            this.zzJ = new zzfg(32);
            this.zzK = new zzfg(32);
        } else if (i11 == 524531317 && !this.zzC) {
            if (this.zzk && this.zzG != -1) {
                this.zzF = true;
            } else {
                this.zzai.zzO(new zzadt(this.zzA, 0L));
                this.zzC = true;
            }
        }
    }

    @CallSuper
    public final void zzl(int i11, String str) throws zzcc {
        if (i11 == 134) {
            zzr(i11);
            this.zzB.zzb = str;
            return;
        }
        if (i11 == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw zzcc.zza("DocType " + str + " not supported", null);
        }
        if (i11 == 21358) {
            zzr(i11);
            this.zzB.zza = str;
        } else {
            if (i11 != 2274716) {
                return;
            }
            zzr(i11);
            this.zzB.zzZ = str;
        }
    }
}
