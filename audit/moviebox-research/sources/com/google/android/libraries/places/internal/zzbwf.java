package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SourceDebugExtension
public class zzbwf implements Serializable, Comparable {
    public static final zzbwe zza = new zzbwe(null);

    @JvmField
    public static final zzbwf zzb = new zzbwf(new byte[0]);
    private final byte[] zzc;
    private transient int zzd;
    private transient String zze;

    public zzbwf(byte[] data) {
        Intrinsics.g(data, "data");
        this.zzc = data;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002b A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzbwf other = (zzbwf) obj;
        Intrinsics.g(other, "other");
        int iZzc = zzc();
        int iZzc2 = other.zzc();
        int iMin = Math.min(iZzc, iZzc2);
        for (int i11 = 0; i11 < iMin; i11++) {
            int iZza = zza(i11) & 255;
            int iZza2 = other.zza(i11) & 255;
            if (iZza != iZza2) {
                if (iZza >= iZza2) {
                    return 1;
                }
                return -1;
            }
        }
        if (iZzc == iZzc2) {
            return 0;
        }
        if (iZzc >= iZzc2) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbwf) {
            zzbwf zzbwfVar = (zzbwf) obj;
            int iZzc = zzbwfVar.zzc();
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (iZzc == length && zzbwfVar.zzl(0, bArr, 0, length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i11 = this.zzd;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = Arrays.hashCode(this.zzc);
        this.zzd = iHashCode;
        return iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002c A[EDGE_INSN: B:17:0x002c->B:125:0x0149 BREAK  A[LOOP:0: B:6:0x0010->B:33:0x0050]] */
    public String toString() {
        int i11;
        byte[] bArr = this.zzc;
        int length = bArr.length;
        if (length == 0) {
            return "[size=0]";
        }
        int i12 = zzbwy.zza;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        loop0: while (i13 < length) {
            byte b11 = bArr[i13];
            if (b11 < 0) {
                if ((b11 >> 5) != -2) {
                    if ((b11 >> 4) != -2) {
                        if ((b11 >> 3) != -2) {
                            if (i14 == 64) {
                                break;
                            }
                            i15 = -1;
                            break;
                        }
                        int i16 = i13 + 3;
                        if (length > i16) {
                            byte b12 = bArr[i13 + 1];
                            if ((b12 & 192) != 128) {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                            byte b13 = bArr[i13 + 2];
                            if ((b13 & 192) != 128) {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                            byte b14 = bArr[i16];
                            if ((b14 & 192) != 128) {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                            int i17 = (((b14 ^ 3678080) ^ (b13 << 6)) ^ (b12 << Ascii.FF)) ^ (b11 << Ascii.DC2);
                            if (i17 <= 1114111) {
                                if (i17 >= 55296 && i17 < 57344) {
                                    if (i14 == 64) {
                                        break;
                                    }
                                    i15 = -1;
                                    break;
                                }
                                if (i17 >= 65536) {
                                    i11 = i14 + 1;
                                    if (i14 == 64) {
                                        break;
                                    }
                                    i15 += 2;
                                    Unit unit = Unit.f68710a;
                                    i13 += 4;
                                    i14 = i11;
                                } else {
                                    if (i14 == 64) {
                                        break;
                                    }
                                    i15 = -1;
                                    break;
                                }
                            } else {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                        } else {
                            if (i14 == 64) {
                                break;
                            }
                            i15 = -1;
                            break;
                        }
                    } else {
                        int i18 = i13 + 2;
                        if (length > i18) {
                            byte b15 = bArr[i13 + 1];
                            if ((b15 & 192) != 128) {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                            byte b16 = bArr[i18];
                            if ((b16 & 192) != 128) {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                            int i19 = ((b16 ^ (-123008)) ^ (b15 << 6)) ^ (b11 << Ascii.FF);
                            if (i19 >= 2048) {
                                if (i19 >= 55296 && i19 < 57344) {
                                    if (i14 == 64) {
                                        break;
                                    }
                                    i15 = -1;
                                    break;
                                }
                                i11 = i14 + 1;
                                if (i14 == 64) {
                                    break;
                                }
                                if (i19 == 65533) {
                                    i15 = -1;
                                    break;
                                }
                                i13 += 3;
                                i15 += i19 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.f68710a;
                                i14 = i11;
                            } else {
                                if (i14 == 64) {
                                    break;
                                }
                                i15 = -1;
                                break;
                            }
                        } else {
                            if (i14 == 64) {
                                break;
                            }
                            i15 = -1;
                            break;
                        }
                    }
                } else {
                    int i21 = i13 + 1;
                    if (length > i21) {
                        byte b17 = bArr[i21];
                        if ((b17 & 192) != 128) {
                            if (i14 == 64) {
                                break;
                            }
                            i15 = -1;
                            break;
                        }
                        int i22 = (b11 << 6) ^ (b17 ^ 3968);
                        if (i22 >= 128) {
                            i11 = i14 + 1;
                            if (i14 != 64) {
                                if (i22 < 160 || i22 == 65533) {
                                    i15 = -1;
                                    break;
                                }
                                i13 += 2;
                                i15 += i22 < 65536 ? 1 : 2;
                                Unit unit3 = Unit.f68710a;
                                i14 = i11;
                            } else {
                                break;
                            }
                        } else {
                            if (i14 == 64) {
                                break;
                            }
                            i15 = -1;
                            break;
                        }
                    } else {
                        if (i14 == 64) {
                            break;
                        }
                        i15 = -1;
                        break;
                    }
                }
            } else {
                i11 = i14 + 1;
                if (i14 == 64) {
                    break;
                }
                if (b11 == 10 || b11 == 13 || (b11 >= 32 && b11 < 127)) {
                    i15++;
                    i13++;
                    while (true) {
                        if (i13 >= length) {
                            continue;
                        } else {
                            byte b18 = bArr[i13];
                            if (b18 >= 0) {
                                i13++;
                                int i23 = i11 + 1;
                                if (i11 == 64) {
                                    break loop0;
                                }
                                if (b18 == 10 || b18 == 13 || (b18 >= 32 && b18 < 127)) {
                                    i15++;
                                    i11 = i23;
                                }
                            } else {
                                continue;
                            }
                        }
                        i14 = i11;
                    }
                }
                i15 = -1;
                break;
            }
        }
        if (i15 != -1) {
            String strZzf = zzf();
            String strSubstring = strZzf.substring(0, i15);
            Intrinsics.f(strSubstring, "substring(...)");
            String strF = l.F(l.F(l.F(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (i15 >= strZzf.length()) {
                return "[text=" + strF + "]";
            }
            return "[size=" + this.zzc.length + " text=" + strF + "…]";
        }
        int length2 = this.zzc.length;
        if (length2 <= 64) {
            return "[hex=" + zze() + "]";
        }
        Intrinsics.g(this, "<this>");
        byte[] bArr2 = this.zzc;
        int length3 = bArr2.length;
        if (length3 < 64) {
            throw new IllegalArgumentException("endIndex > length(" + length3 + ")");
        }
        return "[size=" + length2 + " hex=" + (length3 != 64 ? new zzbwf(ArraysKt___ArraysJvmKt.q(bArr2, 0, 64)) : this).zze() + "…]";
    }

    public byte zza(int i11) {
        return this.zzc[i11];
    }

    public final int zzb() {
        return this.zzd;
    }

    public int zzc() {
        return this.zzc.length;
    }

    public final String zzd() {
        return zzbvu.zza(this.zzc, null, 1, null);
    }

    public String zze() {
        byte[] bArr = this.zzc;
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i11 = 0;
        for (byte b11 : bArr) {
            cArr[i11] = zzbwy.zza()[(b11 >> 4) & 15];
            cArr[i11 + 1] = zzbwy.zza()[b11 & Ascii.SI];
            i11 += 2;
        }
        return l.r(cArr);
    }

    public final String zzf() {
        String str = this.zze;
        if (str != null) {
            return str;
        }
        String strZza = zzbww.zza(zzo());
        this.zze = strZza;
        return strZza;
    }

    public zzbwf zzg() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (i11 >= length) {
                return this;
            }
            int i12 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 >= 65 && b11 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, length);
                Intrinsics.f(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i11] = (byte) (b11 + 32);
                while (i12 < bArrCopyOf.length) {
                    int i13 = i12 + 1;
                    byte b12 = bArrCopyOf[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        bArrCopyOf[i12] = (byte) (b12 + 32);
                    }
                    i12 = i13;
                }
                return new zzbwf(bArrCopyOf);
            }
            i11 = i12;
        }
    }

    public final void zzh(int i11) {
        this.zzd = i11;
    }

    public final void zzi(String str) {
        this.zze = str;
    }

    public void zzj(zzbwb buffer, int i11, int i12) {
        Intrinsics.g(buffer, "buffer");
        int i13 = zzbwy.zza;
        Intrinsics.g(this, "<this>");
        Intrinsics.g(buffer, "buffer");
        buffer.zzl(this.zzc, 0, i12);
    }

    public boolean zzk(int i11, zzbwf other, int i12, int i13) {
        Intrinsics.g(other, "other");
        return other.zzl(0, this.zzc, 0, i13);
    }

    public boolean zzl(int i11, byte[] other, int i12, int i13) {
        Intrinsics.g(other, "other");
        if (i11 < 0) {
            return false;
        }
        byte[] bArr = this.zzc;
        return i11 <= bArr.length - i13 && i12 >= 0 && i12 <= other.length - i13 && zzbvv.zzc(bArr, i11, other, i12, i13);
    }

    public final boolean zzm(zzbwf prefix) {
        Intrinsics.g(prefix, "prefix");
        return zzk(0, prefix, 0, prefix.zzc.length);
    }

    public final byte[] zzn() {
        return this.zzc;
    }

    public byte[] zzo() {
        return this.zzc;
    }

    public byte[] zzp() {
        byte[] bArr = this.zzc;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.f(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
