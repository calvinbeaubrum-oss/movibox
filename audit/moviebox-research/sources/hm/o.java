package hm;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f66544a = Charset.defaultCharset();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f66545b = Charset.forName("SJIS");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f66546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f66547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f66548e;

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f66546c = charsetForName;
        Charset charsetForName2 = Charset.forName("EUC_JP");
        f66547d = charsetForName2;
        Charset charset = f66545b;
        Charset charset2 = f66544a;
        f66548e = charset.equals(charset2) || charsetForName2.equals(charset2);
    }

    /* JADX WARN: Code duplicated, block: B:83:0x00d6  */
    public static Charset a(byte[] bArr, Map<DecodeHintType, ?> map) {
        int i11;
        byte b11;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return Charset.forName(map.get(decodeHintType).toString());
            }
        }
        boolean z11 = true;
        int i12 = 0;
        if (bArr2.length > 2 && (((b11 = bArr2[0]) == -2 && bArr2[1] == -1) || (b11 == -1 && bArr2[1] == -2))) {
            return StandardCharsets.UTF_16;
        }
        int length = bArr2.length;
        boolean z12 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i13 = 0;
        boolean z13 = true;
        boolean z14 = true;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i14 < length && (z11 || z13 || z14)) {
            byte b12 = bArr2[i14];
            int i25 = b12 & 255;
            if (z14) {
                if (i15 <= 0) {
                    i11 = length;
                    if ((b12 & 128) != 0) {
                        if ((b12 & 64) != 0) {
                            int i26 = i15 + 1;
                            if ((b12 & 32) == 0) {
                                i17++;
                            } else {
                                i26 = i15 + 2;
                                if ((b12 & Ascii.DLE) == 0) {
                                    i18++;
                                } else {
                                    i15 += 3;
                                    if ((b12 & 8) == 0) {
                                        i19++;
                                    }
                                }
                            }
                            i15 = i26;
                        }
                    }
                } else if ((b12 & 128) == 0) {
                    i11 = length;
                } else {
                    i15--;
                    i11 = length;
                }
                z14 = false;
            } else {
                i11 = length;
            }
            if (z11) {
                if (i25 > 127 && i25 < 160) {
                    z11 = false;
                } else if (i25 > 159 && (i25 < 192 || i25 == 215 || i25 == 247)) {
                    i22++;
                }
            }
            if (z13) {
                if (i16 > 0) {
                    if (i25 < 64 || i25 == 127 || i25 > 252) {
                        z13 = false;
                    } else {
                        i16--;
                    }
                } else if (i25 == 128 || i25 == 160 || i25 > 239) {
                    z13 = false;
                } else if (i25 <= 160 || i25 >= 224) {
                    if (i25 > 127) {
                        i16++;
                        int i27 = i23 + 1;
                        if (i27 > i12) {
                            i12 = i27;
                            i23 = i12;
                        } else {
                            i23 = i27;
                        }
                    } else {
                        i23 = 0;
                    }
                    i24 = 0;
                } else {
                    i13++;
                    int i28 = i24 + 1;
                    if (i28 > i21) {
                        i21 = i28;
                        i24 = i21;
                    } else {
                        i24 = i28;
                    }
                    i23 = 0;
                }
            }
            i14++;
            bArr2 = bArr;
            length = i11;
        }
        int i29 = length;
        if (z14 && i15 > 0) {
            z14 = false;
        }
        if (z13 && i16 > 0) {
            z13 = false;
        }
        if (z14 && (z12 || i17 + i18 + i19 > 0)) {
            return StandardCharsets.UTF_8;
        }
        if (z13 && (f66548e || i21 >= 3 || i12 >= 3)) {
            return f66545b;
        }
        if (z11 && z13) {
            return (!(i21 == 2 && i13 == 2) && i22 * 10 < i29) ? StandardCharsets.ISO_8859_1 : f66545b;
        }
        if (z11) {
            return StandardCharsets.ISO_8859_1;
        }
        if (z13) {
            return f66545b;
        }
        return z14 ? StandardCharsets.UTF_8 : f66544a;
    }
}
