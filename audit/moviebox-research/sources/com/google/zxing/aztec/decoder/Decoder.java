package com.google.zxing.aztec.decoder;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import hm.d;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import jm.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Decoder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f41462b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f41463c = {"CTRL_PS", " ", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "e", "f", "g", "h", "i", "j", CampaignEx.JSON_KEY_AD_K, "l", "m", "n", "o", TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_Q, CampaignEx.JSON_KEY_AD_R, "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f41464d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f41465e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", Utils.SEPARATOR, "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", InstructionFileId.DOT, "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f41466f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, ",", InstructionFileId.DOT, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f41467g = StandardCharsets.ISO_8859_1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dm.a f41468a;

    /* JADX INFO: compiled from: source.java */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41469a;

        static {
            int[] iArr = new int[Table.values().length];
            f41469a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41469a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41469a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41469a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41469a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f41470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41472c;

        public b(boolean[] zArr, int i11, int i12) {
            this.f41470a = zArr;
            this.f41471b = i11;
            this.f41472c = i12;
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = h(zArr, i11 * 8);
        }
        return bArr;
    }

    public static String e(Table table, int i11) {
        int i12 = a.f41469a[table.ordinal()];
        if (i12 == 1) {
            return f41462b[i11];
        }
        if (i12 == 2) {
            return f41463c[i11];
        }
        if (i12 == 3) {
            return f41464d[i11];
        }
        if (i12 == 4) {
            return f41465e[i11];
        }
        if (i12 == 5) {
            return f41466f[i11];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String f(boolean[] zArr) throws FormatException {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb2 = new StringBuilder((zArr.length - 5) / 4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = f41467g;
        int i11 = 0;
        Table tableG = table;
        while (i11 < length) {
            if (table != Table.BINARY) {
                int i12 = table == Table.DIGIT ? 4 : 5;
                if (length - i11 < i12) {
                    break;
                }
                int i13 = i(zArr, i11, i12);
                i11 += i12;
                String strE = e(table, i13);
                if ("FLG(n)".equals(strE)) {
                    if (length - i11 < 3) {
                        break;
                    }
                    int i14 = i(zArr, i11, 3);
                    i11 += 3;
                    try {
                        sb2.append(byteArrayOutputStream.toString(charset.name()));
                        byteArrayOutputStream.reset();
                        if (i14 == 0) {
                            sb2.append((char) 29);
                        } else {
                            if (i14 == 7) {
                                throw FormatException.getFormatInstance();
                            }
                            if (length - i11 >= i14 * 4) {
                                int i15 = 0;
                                while (true) {
                                    int i16 = i14 - 1;
                                    if (i14 <= 0) {
                                        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i15);
                                        if (characterSetECIByValue == null) {
                                            throw FormatException.getFormatInstance();
                                        }
                                        charset = characterSetECIByValue.getCharset();
                                        break;
                                    }
                                    int i17 = i(zArr, i11, 4);
                                    i11 += 4;
                                    if (i17 < 2 || i17 > 11) {
                                        throw FormatException.getFormatInstance();
                                    }
                                    i15 = (i15 * 10) + (i17 - 2);
                                    i14 = i16;
                                }
                            }
                        }
                    } catch (UnsupportedEncodingException e11) {
                        throw new IllegalStateException(e11);
                    }
                } else if (strE.startsWith("CTRL_")) {
                    tableG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        tableG = table;
                        table = tableG;
                    }
                } else {
                    byte[] bytes = strE.getBytes(StandardCharsets.US_ASCII);
                    byteArrayOutputStream.write(bytes, 0, bytes.length);
                }
                table = tableG;
            } else {
                if (length - i11 < 5) {
                    break;
                }
                int i18 = i(zArr, i11, 5);
                int i19 = i11 + 5;
                if (i18 == 0) {
                    if (length - i19 < 11) {
                        break;
                    }
                    i18 = i(zArr, i19, 11) + 31;
                    i19 = i11 + 16;
                }
                int i21 = 0;
                while (true) {
                    if (i21 >= i18) {
                        i11 = i19;
                        break;
                    }
                    if (length - i19 < 8) {
                        i11 = length;
                        break;
                    }
                    byteArrayOutputStream.write((byte) i(zArr, i19, 8));
                    i19 += 8;
                    i21++;
                }
                table = tableG;
            }
        }
        try {
            sb2.append(byteArrayOutputStream.toString(charset.name()));
            return sb2.toString();
        } catch (UnsupportedEncodingException e12) {
            throw new IllegalStateException(e12);
        }
    }

    public static Table g(char c11) {
        if (c11 == 'B') {
            return Table.BINARY;
        }
        if (c11 == 'D') {
            return Table.DIGIT;
        }
        if (c11 == 'P') {
            return Table.PUNCT;
        }
        if (c11 != 'L') {
            return c11 != 'M' ? Table.UPPER : Table.MIXED;
        }
        return Table.LOWER;
    }

    public static byte h(boolean[] zArr, int i11) {
        int length = zArr.length - i11;
        return (byte) (length >= 8 ? i(zArr, i11, 8) : i(zArr, i11, length) << (8 - length));
    }

    public static int i(boolean[] zArr, int i11, int i12) {
        int i13 = 0;
        for (int i14 = i11; i14 < i11 + i12; i14++) {
            i13 <<= 1;
            if (zArr[i14]) {
                i13 |= 1;
            }
        }
        return i13;
    }

    public static int j(int i11, boolean z11) {
        return ((z11 ? 88 : 112) + (i11 * 16)) * i11;
    }

    public final b b(boolean[] zArr) throws FormatException {
        int i11;
        jm.a aVar;
        if (this.f41468a.e() <= 2) {
            aVar = jm.a.f68085j;
            i11 = 6;
        } else {
            i11 = 8;
            if (this.f41468a.e() <= 8) {
                aVar = jm.a.f68089n;
            } else if (this.f41468a.e() <= 22) {
                aVar = jm.a.f68084i;
                i11 = 10;
            } else {
                aVar = jm.a.f68083h;
                i11 = 12;
            }
        }
        int iD = this.f41468a.d();
        int length = zArr.length / i11;
        if (length < iD) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i11;
        int[] iArr = new int[length];
        int i12 = 0;
        while (i12 < length) {
            iArr[i12] = i(zArr, length2, i11);
            i12++;
            length2 += i11;
        }
        try {
            c cVar = new c(aVar);
            int i13 = length - iD;
            int iA = cVar.a(iArr, i13);
            int i14 = 1 << i11;
            int i15 = i14 - 1;
            int i16 = 0;
            for (int i17 = 0; i17 < iD; i17++) {
                int i18 = iArr[i17];
                if (i18 == 0 || i18 == i15) {
                    throw FormatException.getFormatInstance();
                }
                if (i18 == 1 || i18 == i14 - 2) {
                    i16++;
                }
            }
            boolean[] zArr2 = new boolean[(iD * i11) - i16];
            int i19 = 0;
            for (int i21 = 0; i21 < iD; i21++) {
                int i22 = iArr[i21];
                if (i22 == 1 || i22 == i14 - 2) {
                    Arrays.fill(zArr2, i19, (i19 + i11) - 1, i22 > 1);
                    i19 += i11 - 1;
                } else {
                    int i23 = i11 - 1;
                    while (i23 >= 0) {
                        int i24 = i19 + 1;
                        zArr2[i19] = (i22 & (1 << i23)) != 0;
                        i23--;
                        i19 = i24;
                    }
                }
            }
            return new b(zArr2, iA, (i13 * 100) / length);
        } catch (ReedSolomonException e11) {
            throw FormatException.getFormatInstance(e11);
        }
    }

    public d c(dm.a aVar) throws FormatException {
        this.f41468a = aVar;
        b bVarB = b(d(aVar.a()));
        d dVar = new d(a(bVarB.f41470a), f(bVarB.f41470a), null, String.format("%d%%", Integer.valueOf(bVarB.f41472c)));
        dVar.o(bVarB.f41470a.length);
        dVar.n(Integer.valueOf(bVarB.f41471b));
        return dVar;
    }

    public final boolean[] d(hm.b bVar) {
        boolean zF = this.f41468a.f();
        int iE = this.f41468a.e();
        int i11 = (zF ? 11 : 14) + (iE * 4);
        int[] iArr = new int[i11];
        boolean[] zArr = new boolean[j(iE, zF)];
        int i12 = 2;
        if (zF) {
            for (int i13 = 0; i13 < i11; i13++) {
                iArr[i13] = i13;
            }
        } else {
            int i14 = i11 / 2;
            int i15 = ((i11 + 1) + (((i14 - 1) / 15) * 2)) / 2;
            for (int i16 = 0; i16 < i14; i16++) {
                int i17 = (i16 / 15) + i16;
                iArr[(i14 - i16) - 1] = (i15 - i17) - 1;
                iArr[i14 + i16] = i17 + i15 + 1;
            }
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < iE) {
            int i21 = ((iE - i18) * 4) + (zF ? 9 : 12);
            int i22 = i18 * 2;
            int i23 = (i11 - 1) - i22;
            int i24 = 0;
            while (i24 < i21) {
                int i25 = i24 * 2;
                int i26 = 0;
                while (i26 < i12) {
                    int i27 = i22 + i26;
                    int i28 = i22 + i24;
                    zArr[i19 + i25 + i26] = bVar.g(iArr[i27], iArr[i28]);
                    int i29 = iArr[i28];
                    int i31 = i23 - i26;
                    zArr[(i21 * 2) + i19 + i25 + i26] = bVar.g(i29, iArr[i31]);
                    int i32 = i23 - i24;
                    zArr[(i21 * 4) + i19 + i25 + i26] = bVar.g(iArr[i31], iArr[i32]);
                    zArr[(i21 * 6) + i19 + i25 + i26] = bVar.g(iArr[i32], iArr[i27]);
                    i26++;
                    iE = iE;
                    zF = zF;
                    i12 = 2;
                }
                i24++;
                i12 = 2;
            }
            i19 += i21 * 8;
            i18++;
            i12 = 2;
        }
        return zArr;
    }
}
