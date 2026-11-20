package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SourceDebugExtension
public final class zzbwb implements Cloneable, ByteChannel, zzbwd, zzbwc {

    @JvmField
    public zzbwn zza;
    private long zzb;

    public final /* synthetic */ Object clone() {
        zzbwb zzbwbVar = new zzbwb();
        if (this.zzb != 0) {
            zzbwn zzbwnVar = this.zza;
            Intrinsics.d(zzbwnVar);
            zzbwn zzbwnVarZzc = zzbwnVar.zzc();
            zzbwbVar.zza = zzbwnVarZzc;
            zzbwnVarZzc.zzh = zzbwnVarZzc;
            zzbwnVarZzc.zzg = zzbwnVarZzc;
            for (zzbwn zzbwnVar2 = zzbwnVar.zzg; zzbwnVar2 != zzbwnVar; zzbwnVar2 = zzbwnVar2.zzg) {
                zzbwn zzbwnVar3 = zzbwnVarZzc.zzh;
                Intrinsics.d(zzbwnVar3);
                Intrinsics.d(zzbwnVar2);
                zzbwnVar3.zzb(zzbwnVar2.zzc());
            }
            zzbwbVar.zzb = this.zzb;
        }
        return zzbwbVar;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbws
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbwb) {
            long j11 = this.zzb;
            zzbwb zzbwbVar = (zzbwb) obj;
            if (j11 == zzbwbVar.zzb) {
                if (j11 == 0) {
                    return true;
                }
                zzbwn zzbwnVar = this.zza;
                Intrinsics.d(zzbwnVar);
                zzbwn zzbwnVar2 = zzbwbVar.zza;
                Intrinsics.d(zzbwnVar2);
                int i11 = zzbwnVar.zzc;
                int i12 = zzbwnVar2.zzc;
                long j12 = 0;
                while (j12 < this.zzb) {
                    long jMin = Math.min(zzbwnVar.zzd - i11, zzbwnVar2.zzd - i12);
                    long j13 = 0;
                    while (j13 < jMin) {
                        int i13 = i11 + 1;
                        int i14 = i12 + 1;
                        if (zzbwnVar.zzb[i11] == zzbwnVar2.zzb[i12]) {
                            j13++;
                            i11 = i13;
                            i12 = i14;
                        }
                    }
                    if (i11 == zzbwnVar.zzd) {
                        zzbwnVar = zzbwnVar.zzg;
                        Intrinsics.d(zzbwnVar);
                        i11 = zzbwnVar.zzc;
                    }
                    if (i12 == zzbwnVar2.zzd) {
                        zzbwnVar2 = zzbwnVar2.zzg;
                        Intrinsics.d(zzbwnVar2);
                        i12 = zzbwnVar2.zzc;
                    }
                    j12 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc, com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() {
    }

    public final int hashCode() {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = zzbwnVar.zzd;
            for (int i13 = zzbwnVar.zzc; i13 < i12; i13++) {
                i11 = (i11 * 31) + zzbwnVar.zzb[i13];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.d(zzbwnVar);
        } while (zzbwnVar != this.zza);
        return i11;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) throws IOException {
        Intrinsics.g(sink, "sink");
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), zzbwnVar.zzd - zzbwnVar.zzc);
        sink.put(zzbwnVar.zzb, zzbwnVar.zzc, iMin);
        int i11 = zzbwnVar.zzc + iMin;
        zzbwnVar.zzc = i11;
        this.zzb -= (long) iMin;
        if (i11 == zzbwnVar.zzd) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return iMin;
    }

    public final String toString() {
        return zzz().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.g(source, "source");
        int iRemaining = source.remaining();
        int i11 = iRemaining;
        while (i11 > 0) {
            zzbwn zzbwnVarZzB = zzB(1);
            int iMin = Math.min(i11, 8192 - zzbwnVarZzB.zzd);
            source.get(zzbwnVarZzB.zzb, zzbwnVarZzB.zzd, iMin);
            i11 -= iMin;
            zzbwnVarZzB.zzd += iMin;
        }
        this.zzb += (long) iRemaining;
        return iRemaining;
    }

    public final zzbwf zzA(int i11) {
        if (i11 == 0) {
            return zzbwf.zzb;
        }
        zzbvv.zzb(this.zzb, 0L, i11);
        zzbwn zzbwnVar = this.zza;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Intrinsics.d(zzbwnVar);
            int i15 = zzbwnVar.zzd;
            int i16 = zzbwnVar.zzc;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            zzbwnVar = zzbwnVar.zzg;
        }
        byte[][] bArr = new byte[i14][];
        int[] iArr = new int[i14 + i14];
        zzbwn zzbwnVar2 = this.zza;
        int i17 = 0;
        while (i12 < i11) {
            Intrinsics.d(zzbwnVar2);
            bArr[i17] = zzbwnVar2.zzb;
            i12 += zzbwnVar2.zzd - zzbwnVar2.zzc;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = zzbwnVar2.zzc;
            zzbwnVar2.zze = true;
            i17++;
            zzbwnVar2 = zzbwnVar2.zzg;
        }
        return new zzbwp(bArr, iArr);
    }

    public final zzbwn zzB(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            zzbwn zzbwnVarZza = zzbwo.zza();
            this.zza = zzbwnVarZza;
            zzbwnVarZza.zzh = zzbwnVarZza;
            zzbwnVarZza.zzg = zzbwnVarZza;
            return zzbwnVarZza;
        }
        Intrinsics.d(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.d(zzbwnVar2);
        if (zzbwnVar2.zzd + i11 <= 8192 && zzbwnVar2.zzf) {
            return zzbwnVar2;
        }
        zzbwn zzbwnVarZza2 = zzbwo.zza();
        zzbwnVar2.zzb(zzbwnVarZza2);
        return zzbwnVarZza2;
    }

    public final short zzC() throws EOFException {
        int iZzc;
        if (this.zzb < 2) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.d(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        if (i12 - i11 < 2) {
            iZzc = ((zzc() & 255) << 8) | (zzc() & 255);
        } else {
            byte[] bArr = zzbwnVar.zzb;
            int i13 = (bArr[i11] & 255) << 8;
            int i14 = bArr[i11 + 1] & 255;
            this.zzb -= 2;
            int i15 = i11 + 2;
            if (i15 == i12) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            } else {
                zzbwnVar.zzc = i15;
            }
            iZzc = i13 | i14;
        }
        return (short) iZzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzD(long j11) throws EOFException {
        throw null;
    }

    public final void zzE(long j11) {
        this.zzb = j11;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzF(long j11) throws EOFException {
        while (j11 > 0) {
            zzbwn zzbwnVar = this.zza;
            if (zzbwnVar == null) {
                throw new EOFException(null);
            }
            int iMin = (int) Math.min(j11, zzbwnVar.zzd - zzbwnVar.zzc);
            long j12 = iMin;
            this.zzb -= j12;
            j11 -= j12;
            int i11 = zzbwnVar.zzc + iMin;
            zzbwnVar.zzc = i11;
            if (i11 == zzbwnVar.zzd) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            }
        }
    }

    public final boolean zzG() {
        return this.zzb == 0;
    }

    public final byte[] zzH(long j11) throws EOFException {
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException(null);
        }
        int i11 = (int) j11;
        byte[] sink = new byte[i11];
        Intrinsics.g(sink, "sink");
        int i12 = 0;
        while (i12 < i11) {
            int iZzd = zzd(sink, i12, i11 - i12);
            if (iZzd == -1) {
                throw new EOFException(null);
            }
            i12 += iZzd;
        }
        return sink;
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j11) {
        Intrinsics.g(sink, "sink");
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        long j12 = this.zzb;
        if (j12 == 0) {
            return -1L;
        }
        if (j11 > j12) {
            j11 = j12;
        }
        sink.zzn(this, j11);
        return j11;
    }

    @JvmName
    public final byte zzb(long j11) {
        zzbvv.zzb(this.zzb, j11, 1L);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            Intrinsics.d(null);
            throw null;
        }
        long j12 = this.zzb;
        if (j12 - j11 < j11) {
            while (j12 > j11) {
                zzbwnVar = zzbwnVar.zzh;
                Intrinsics.d(zzbwnVar);
                j12 -= (long) (zzbwnVar.zzd - zzbwnVar.zzc);
            }
            Intrinsics.d(zzbwnVar);
            return zzbwnVar.zzb[(int) ((((long) zzbwnVar.zzc) + j11) - j12)];
        }
        long j13 = 0;
        while (true) {
            long j14 = ((long) (zzbwnVar.zzd - zzbwnVar.zzc)) + j13;
            if (j14 > j11) {
                Intrinsics.d(zzbwnVar);
                return zzbwnVar.zzb[(int) ((((long) zzbwnVar.zzc) + j11) - j13)];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.d(zzbwnVar);
            j13 = j14;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final byte zzc() throws EOFException {
        if (this.zzb == 0) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.d(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        int i13 = i11 + 1;
        byte b11 = zzbwnVar.zzb[i11];
        this.zzb--;
        if (i13 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        } else {
            zzbwnVar.zzc = i13;
        }
        return b11;
    }

    public final int zzd(byte[] sink, int i11, int i12) {
        Intrinsics.g(sink, "sink");
        zzbvv.zzb(sink.length, i11, i12);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int iMin = Math.min(i12, zzbwnVar.zzd - zzbwnVar.zzc);
        int i13 = zzbwnVar.zzc;
        ArraysKt___ArraysJvmKt.h(zzbwnVar.zzb, sink, i11, i13, i13 + iMin);
        int i14 = zzbwnVar.zzc + iMin;
        zzbwnVar.zzc = i14;
        this.zzb -= (long) iMin;
        if (i14 != zzbwnVar.zzd) {
            return iMin;
        }
        this.zza = zzbwnVar.zza();
        zzbwo.zzb(zzbwnVar);
        return iMin;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final int zze() throws EOFException {
        if (this.zzb < 4) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.d(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        if (i12 - i11 < 4) {
            return ((zzc() & 255) << 24) | ((zzc() & 255) << 16) | ((zzc() & 255) << 8) | (zzc() & 255);
        }
        byte[] bArr = zzbwnVar.zzb;
        int i13 = (bArr[i11] & 255) << 24;
        int i14 = (bArr[i11 + 1] & 255) << 16;
        int i15 = (bArr[i11 + 2] & 255) << 8;
        int i16 = bArr[i11 + 3] & 255;
        this.zzb -= 4;
        int i17 = i16 | i14 | i13 | i15;
        int i18 = i11 + 4;
        if (i18 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        } else {
            zzbwnVar.zzc = i18;
        }
        return i17;
    }

    public final long zzf() {
        long j11 = this.zzb;
        if (j11 == 0) {
            return 0L;
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.d(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.d(zzbwnVar2);
        int i11 = zzbwnVar2.zzd;
        if (i11 < 8192 && zzbwnVar2.zzf) {
            j11 -= (long) (i11 - zzbwnVar2.zzc);
        }
        return j11;
    }

    @JvmName
    public final long zzg() {
        return this.zzb;
    }

    public final String zzh(long j11, Charset charset) throws EOFException {
        Intrinsics.g(charset, "charset");
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException();
        }
        if (j11 == 0) {
            return "";
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.d(zzbwnVar);
        int i11 = zzbwnVar.zzc;
        int i12 = zzbwnVar.zzd;
        if (((long) i11) + j11 > i12) {
            return new String(zzH(j11), charset);
        }
        int i13 = (int) j11;
        String str = new String(zzbwnVar.zzb, i11, i13, charset);
        int i14 = i11 + i13;
        zzbwnVar.zzc = i14;
        this.zzb -= j11;
        if (i14 == i12) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return str;
    }

    public final String zzi() {
        return zzh(this.zzb, Charsets.f69091b);
    }

    public final String zzj(long j11) throws EOFException {
        zzbwn zzbwnVar;
        int i11;
        long j12;
        long j13;
        long j14 = this.zzb;
        long j15 = j14 < Long.MAX_VALUE ? j14 : Long.MAX_VALUE;
        if (j15 == 0 || (zzbwnVar = this.zza) == null) {
            j13 = -1;
            j12 = -1;
        } else if (j14 < 0) {
            while (j14 > 0) {
                zzbwnVar = zzbwnVar.zzh;
                Intrinsics.d(zzbwnVar);
                j14 -= (long) (zzbwnVar.zzd - zzbwnVar.zzc);
            }
            long j16 = 0;
            while (true) {
                if (j14 < j15) {
                    byte[] bArr = zzbwnVar.zzb;
                    int iMin = (int) Math.min(zzbwnVar.zzd, (((long) zzbwnVar.zzc) + j15) - j14);
                    i11 = (int) ((((long) zzbwnVar.zzc) + j16) - j14);
                    while (true) {
                        if (i11 >= iMin) {
                            j16 = j14 + ((long) (zzbwnVar.zzd - zzbwnVar.zzc));
                            zzbwnVar = zzbwnVar.zzg;
                            Intrinsics.d(zzbwnVar);
                            j14 = j16;
                        } else if (bArr[i11] == 10) {
                            j12 = ((long) (i11 - zzbwnVar.zzc)) + j14;
                            j13 = -1;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    j13 = -1;
                    j12 = -1;
                }
            }
        } else {
            j14 = 0;
            while (true) {
                long j17 = ((long) (zzbwnVar.zzd - zzbwnVar.zzc)) + j14;
                if (j17 > 0) {
                    break;
                }
                zzbwnVar = zzbwnVar.zzg;
                Intrinsics.d(zzbwnVar);
                j14 = j17;
            }
            long j18 = 0;
            while (true) {
                if (j14 < j15) {
                    byte[] bArr2 = zzbwnVar.zzb;
                    int iMin2 = (int) Math.min(zzbwnVar.zzd, (((long) zzbwnVar.zzc) + j15) - j14);
                    i11 = (int) ((((long) zzbwnVar.zzc) + j18) - j14);
                    while (true) {
                        if (i11 >= iMin2) {
                            j18 = ((long) (zzbwnVar.zzd - zzbwnVar.zzc)) + j14;
                            zzbwnVar = zzbwnVar.zzg;
                            Intrinsics.d(zzbwnVar);
                            j14 = j18;
                        } else if (bArr2[i11] == 10) {
                            j12 = ((long) (i11 - zzbwnVar.zzc)) + j14;
                            j13 = -1;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    j13 = -1;
                    j12 = -1;
                }
            }
        }
        if (j12 != j13) {
            int i12 = zzbwx.zza;
            Intrinsics.g(this, "<this>");
            if (j12 > 0) {
                long j19 = j12 + j13;
                if (zzb(j19) == 13) {
                    String strZzh = zzh(j19, Charsets.f69091b);
                    zzF(2L);
                    return strZzh;
                }
            }
            String strZzh2 = zzh(j12, Charsets.f69091b);
            zzF(1L);
            return strZzh2;
        }
        zzbwb out = new zzbwb();
        long jMin = Math.min(32L, this.zzb);
        Intrinsics.g(out, "out");
        zzbvv.zzb(this.zzb, 0L, jMin);
        if (jMin != 0) {
            out.zzb += jMin;
            zzbwn zzbwnVar2 = this.zza;
            long j21 = 0;
            while (true) {
                Intrinsics.d(zzbwnVar2);
                long j22 = zzbwnVar2.zzd - zzbwnVar2.zzc;
                if (j21 < j22) {
                    break;
                }
                zzbwnVar2 = zzbwnVar2.zzg;
                j21 -= j22;
            }
            long j23 = j21;
            while (jMin > 0) {
                Intrinsics.d(zzbwnVar2);
                zzbwn zzbwnVarZzc = zzbwnVar2.zzc();
                int i13 = zzbwnVarZzc.zzc + ((int) j23);
                zzbwnVarZzc.zzc = i13;
                zzbwnVarZzc.zzd = Math.min(i13 + ((int) jMin), zzbwnVarZzc.zzd);
                zzbwn zzbwnVar3 = out.zza;
                if (zzbwnVar3 == null) {
                    zzbwnVarZzc.zzh = zzbwnVarZzc;
                    zzbwnVarZzc.zzg = zzbwnVarZzc;
                    out.zza = zzbwnVarZzc;
                } else {
                    Intrinsics.d(zzbwnVar3);
                    zzbwn zzbwnVar4 = zzbwnVar3.zzh;
                    Intrinsics.d(zzbwnVar4);
                    zzbwnVar4.zzb(zzbwnVarZzc);
                }
                jMin -= (long) (zzbwnVarZzc.zzd - zzbwnVarZzc.zzc);
                zzbwnVar2 = zzbwnVar2.zzg;
                j23 = 0;
            }
        }
        throw new EOFException("\\n not found: limit=" + Math.min(this.zzb, Long.MAX_VALUE) + " content=" + out.zzy(out.zzb).zze() + "…");
    }

    public final zzbwb zzk(zzbwf byteString) {
        Intrinsics.g(byteString, "byteString");
        byteString.zzj(this, 0, byteString.zzc());
        return this;
    }

    public final zzbwb zzl(byte[] source, int i11, int i12) {
        Intrinsics.g(source, "source");
        long j11 = i12;
        zzbvv.zzb(source.length, i11, j11);
        int i13 = i11;
        while (true) {
            int i14 = i11 + i12;
            if (i13 >= i14) {
                this.zzb += j11;
                return this;
            }
            zzbwn zzbwnVarZzB = zzB(1);
            int iMin = Math.min(i14 - i13, 8192 - zzbwnVarZzB.zzd);
            int i15 = i13 + iMin;
            ArraysKt___ArraysJvmKt.h(source, zzbwnVarZzB.zzb, zzbwnVarZzB.zzd, i13, i15);
            zzbwnVarZzB.zzd += iMin;
            i13 = i15;
        }
    }

    public final zzbwb zzm(int i11) {
        zzbwn zzbwnVarZzB = zzB(1);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i12 = zzbwnVarZzB.zzd;
        zzbwnVarZzB.zzd = i12 + 1;
        bArr[i12] = (byte) i11;
        this.zzb++;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb source, long j11) {
        zzbwn zzbwnVar;
        Intrinsics.g(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        zzbvv.zzb(source.zzb, 0L, j11);
        while (j11 > 0) {
            zzbwn zzbwnVar2 = source.zza;
            Intrinsics.d(zzbwnVar2);
            int i11 = zzbwnVar2.zzd;
            zzbwn zzbwnVar3 = source.zza;
            Intrinsics.d(zzbwnVar3);
            int i12 = 0;
            if (j11 < i11 - zzbwnVar3.zzc) {
                zzbwn zzbwnVar4 = this.zza;
                if (zzbwnVar4 != null) {
                    Intrinsics.d(zzbwnVar4);
                    zzbwnVar = zzbwnVar4.zzh;
                } else {
                    zzbwnVar = null;
                }
                int i13 = (int) j11;
                if (zzbwnVar != null && zzbwnVar.zzf) {
                    if ((((long) zzbwnVar.zzd) + j11) - ((long) (zzbwnVar.zze ? 0 : zzbwnVar.zzc)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        zzbwn zzbwnVar5 = source.zza;
                        Intrinsics.d(zzbwnVar5);
                        zzbwnVar5.zze(zzbwnVar, i13);
                        source.zzb -= j11;
                        this.zzb += j11;
                        return;
                    }
                }
                zzbwn zzbwnVar6 = source.zza;
                Intrinsics.d(zzbwnVar6);
                source.zza = zzbwnVar6.zzd(i13);
            }
            zzbwn zzbwnVar7 = source.zza;
            Intrinsics.d(zzbwnVar7);
            int i14 = zzbwnVar7.zzd - zzbwnVar7.zzc;
            source.zza = zzbwnVar7.zza();
            zzbwn zzbwnVar8 = this.zza;
            if (zzbwnVar8 == null) {
                this.zza = zzbwnVar7;
                zzbwnVar7.zzh = zzbwnVar7;
                zzbwnVar7.zzg = zzbwnVar7;
            } else {
                Intrinsics.d(zzbwnVar8);
                zzbwn zzbwnVar9 = zzbwnVar8.zzh;
                Intrinsics.d(zzbwnVar9);
                zzbwnVar9.zzb(zzbwnVar7);
                zzbwn zzbwnVar10 = zzbwnVar7.zzh;
                if (zzbwnVar10 == zzbwnVar7) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.d(zzbwnVar10);
                if (zzbwnVar10.zzf) {
                    int i15 = zzbwnVar7.zzd - zzbwnVar7.zzc;
                    zzbwn zzbwnVar11 = zzbwnVar7.zzh;
                    Intrinsics.d(zzbwnVar11);
                    int i16 = 8192 - zzbwnVar11.zzd;
                    zzbwn zzbwnVar12 = zzbwnVar7.zzh;
                    Intrinsics.d(zzbwnVar12);
                    if (!zzbwnVar12.zze) {
                        zzbwn zzbwnVar13 = zzbwnVar7.zzh;
                        Intrinsics.d(zzbwnVar13);
                        i12 = zzbwnVar13.zzc;
                    }
                    if (i15 <= i16 + i12) {
                        zzbwn zzbwnVar14 = zzbwnVar7.zzh;
                        Intrinsics.d(zzbwnVar14);
                        zzbwnVar7.zze(zzbwnVar14, i15);
                        zzbwnVar7.zza();
                        zzbwo.zzb(zzbwnVar7);
                    }
                }
            }
            long j12 = i14;
            source.zzb -= j12;
            this.zzb += j12;
            j11 -= j12;
        }
    }

    public final zzbwb zzo(long j11) {
        if (j11 == 0) {
            zzm(48);
        } else {
            long j12 = (j11 >>> 1) | j11;
            long j13 = j12 | (j12 >>> 2);
            long j14 = j13 | (j13 >>> 4);
            long j15 = j14 | (j14 >>> 8);
            long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
            long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
            long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
            long j19 = j18 + (j18 >>> 8);
            long j21 = j19 + (j19 >>> 16);
            int i11 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) >> 2);
            zzbwn zzbwnVarZzB = zzB(i11);
            byte[] bArr = zzbwnVarZzB.zzb;
            int i12 = zzbwnVarZzB.zzd;
            int i13 = i12 + i11;
            while (true) {
                i13--;
                if (i13 < i12) {
                    break;
                }
                bArr[i13] = zzbwx.zza()[(int) (15 & j11)];
                j11 >>>= 4;
            }
            zzbwnVarZzB.zzd += i11;
            this.zzb += (long) i11;
        }
        return this;
    }

    public final zzbwb zzp(int i11) {
        zzbwn zzbwnVarZzB = zzB(4);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i12 = zzbwnVarZzB.zzd;
        bArr[i12] = (byte) (i11 >> 24);
        bArr[i12 + 1] = (byte) ((i11 >>> 16) & 255);
        bArr[i12 + 2] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 3] = (byte) (i11 & 255);
        zzbwnVarZzB.zzd = i12 + 4;
        this.zzb += 4;
        return this;
    }

    public final zzbwb zzq(int i11) {
        zzbwn zzbwnVarZzB = zzB(2);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i12 = zzbwnVarZzB.zzd;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i12 + 1] = (byte) (i11 & 255);
        zzbwnVarZzB.zzd = i12 + 2;
        this.zzb += 2;
        return this;
    }

    @JvmOverloads
    public final zzbwb zzr(OutputStream out, long j11) throws IOException {
        Intrinsics.g(out, "out");
        zzbvv.zzb(this.zzb, 0L, j11);
        zzbwn zzbwnVar = this.zza;
        while (j11 > 0) {
            Intrinsics.d(zzbwnVar);
            int iMin = (int) Math.min(j11, zzbwnVar.zzd - zzbwnVar.zzc);
            out.write(zzbwnVar.zzb, zzbwnVar.zzc, iMin);
            int i11 = zzbwnVar.zzc + iMin;
            zzbwnVar.zzc = i11;
            long j12 = iMin;
            this.zzb -= j12;
            j11 -= j12;
            if (i11 == zzbwnVar.zzd) {
                zzbwn zzbwnVarZza = zzbwnVar.zza();
                this.zza = zzbwnVarZza;
                zzbwo.zzb(zzbwnVar);
                zzbwnVar = zzbwnVarZza;
            }
        }
        return this;
    }

    public final zzbwb zzs(String string) {
        Intrinsics.g(string, "string");
        zzt(string, 0, string.length());
        return this;
    }

    public final zzbwb zzt(String string, int i11, int i12) {
        Intrinsics.g(string, "string");
        if (i12 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < 0");
        }
        if (i12 > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + string.length());
        }
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i13 + 1;
            char cCharAt = string.charAt(i13);
            if (cCharAt < 128) {
                zzbwn zzbwnVarZzB = zzB(1);
                byte[] bArr = zzbwnVarZzB.zzb;
                int i15 = zzbwnVarZzB.zzd - i13;
                int iMin = Math.min(i12, 8192 - i15);
                bArr[i13 + i15] = (byte) cCharAt;
                i13 = i14;
                while (i13 < iMin) {
                    char cCharAt2 = string.charAt(i13);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i13 + i15] = (byte) cCharAt2;
                    i13++;
                }
                int i16 = zzbwnVarZzB.zzd;
                int i17 = (i15 + i13) - i16;
                zzbwnVarZzB.zzd = i16 + i17;
                this.zzb += (long) i17;
            } else {
                if (cCharAt < 2048) {
                    zzbwn zzbwnVarZzB2 = zzB(2);
                    byte[] bArr2 = zzbwnVarZzB2.zzb;
                    int i18 = zzbwnVarZzB2.zzd;
                    bArr2[i18] = (byte) ((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i18 + 1] = (byte) ((cCharAt & '?') | 128);
                    zzbwnVarZzB2.zzd = i18 + 2;
                    this.zzb += 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    zzbwn zzbwnVarZzB3 = zzB(3);
                    byte[] bArr3 = zzbwnVarZzB3.zzb;
                    int i19 = zzbwnVarZzB3.zzd;
                    bArr3[i19] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i19 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i19 + 2] = (byte) ((cCharAt & '?') | 128);
                    zzbwnVarZzB3.zzd = i19 + 3;
                    this.zzb += 3;
                } else {
                    char cCharAt3 = i14 < i12 ? string.charAt(i14) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 >= 57344) {
                        zzm(63);
                    } else {
                        zzbwn zzbwnVarZzB4 = zzB(4);
                        byte[] bArr4 = zzbwnVarZzB4.zzb;
                        int i21 = zzbwnVarZzB4.zzd;
                        int i22 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        bArr4[i21] = (byte) ((i22 >> 18) | 240);
                        bArr4[i21 + 1] = (byte) (((i22 >> 12) & 63) | 128);
                        bArr4[i21 + 2] = (byte) (((i22 >> 6) & 63) | 128);
                        bArr4[i21 + 3] = (byte) ((i22 & 63) | 128);
                        zzbwnVarZzB4.zzd = i21 + 4;
                        this.zzb += 4;
                        i13 += 2;
                    }
                }
                i13 = i14;
            }
        }
        return this;
    }

    public final zzbwb zzu(int i11) {
        if (i11 < 128) {
            zzm(i11);
        } else if (i11 < 2048) {
            zzbwn zzbwnVarZzB = zzB(2);
            byte[] bArr = zzbwnVarZzB.zzb;
            int i12 = zzbwnVarZzB.zzd;
            bArr[i12] = (byte) ((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            zzbwnVarZzB.zzd = i12 + 2;
            this.zzb += 2;
        } else if (i11 >= 55296 && i11 < 57344) {
            zzm(63);
        } else if (i11 < 65536) {
            zzbwn zzbwnVarZzB2 = zzB(3);
            byte[] bArr2 = zzbwnVarZzB2.zzb;
            int i13 = zzbwnVarZzB2.zzd;
            bArr2[i13] = (byte) ((i11 >> 12) | 224);
            bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
            bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
            zzbwnVarZzB2.zzd = i13 + 3;
            this.zzb += 3;
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x".concat(String.valueOf(zzbvv.zza(i11))));
            }
            zzbwn zzbwnVarZzB3 = zzB(4);
            byte[] bArr3 = zzbwnVarZzB3.zzb;
            int i14 = zzbwnVarZzB3.zzd;
            bArr3[i14] = (byte) ((i11 >> 18) | 240);
            bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
            bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
            bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
            zzbwnVarZzB3.zzd = i14 + 4;
            this.zzb += 4;
        }
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzv(int i11) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzw(int i11) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzx(String str) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final zzbwf zzy(long j11) throws EOFException {
        if (j11 < 0 || j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j11);
        }
        if (this.zzb < j11) {
            throw new EOFException(null);
        }
        if (j11 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new zzbwf(zzH(j11));
        }
        zzbwf zzbwfVarZzA = zzA((int) j11);
        zzF(j11);
        return zzbwfVarZzA;
    }

    public final zzbwf zzz() {
        long j11 = this.zzb;
        if (j11 <= 2147483647L) {
            return zzA((int) j11);
        }
        throw new IllegalStateException("size > Int.MAX_VALUE: " + j11);
    }
}
