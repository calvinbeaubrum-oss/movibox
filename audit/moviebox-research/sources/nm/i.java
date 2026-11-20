package nm;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f72078a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f72079b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, Worker.WHAT_QUIT, 61}, new int[]{175, TsExtractor.TS_STREAM_TYPE_DTS, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, PsExtractor.AUDIO_STREAM, 252, 95, 9, 157, 119, TsExtractor.TS_STREAM_TYPE_DTS, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, TsExtractor.TS_STREAM_TYPE_AC3, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, Worker.WHAT_SYNC_DATA, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, TsExtractor.TS_STREAM_TYPE_DTS, Worker.WHAT_QUIT, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, TsExtractor.TS_STREAM_TYPE_DTS, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, PsExtractor.AUDIO_STREAM, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, PsExtractor.PRIVATE_STREAM_1, 143, 108, 196, 37, 185, 112, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, Worker.WHAT_SYNC_DATA, 82, 186}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f72080c = new int[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f72081d = new int[255];

    static {
        int i11 = 1;
        for (int i12 = 0; i12 < 255; i12++) {
            f72081d[i12] = i11;
            f72080c[i11] = i12;
            i11 *= 2;
            if (i11 >= 256) {
                i11 ^= 301;
            }
        }
    }

    public static String a(CharSequence charSequence, int i11) {
        int i12;
        int i13;
        int i14 = 0;
        while (true) {
            int[] iArr = f72078a;
            if (i14 >= iArr.length) {
                i14 = -1;
                break;
            }
            if (iArr[i14] == i11) {
                break;
            }
            i14++;
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i11);
        }
        int[] iArr2 = f72079b[i14];
        char[] cArr = new char[i11];
        for (int i15 = 0; i15 < i11; i15++) {
            cArr[i15] = 0;
        }
        for (int i16 = 0; i16 < charSequence.length(); i16++) {
            int i17 = i11 - 1;
            int iCharAt = cArr[i17] ^ charSequence.charAt(i16);
            while (i17 > 0) {
                if (iCharAt == 0 || (i13 = iArr2[i17]) == 0) {
                    cArr[i17] = cArr[i17 - 1];
                } else {
                    char c11 = cArr[i17 - 1];
                    int[] iArr3 = f72081d;
                    int[] iArr4 = f72080c;
                    cArr[i17] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i13]) % 255] ^ c11);
                }
                i17--;
            }
            if (iCharAt == 0 || (i12 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = f72081d;
                int[] iArr6 = f72080c;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i12]) % 255];
            }
        }
        char[] cArr2 = new char[i11];
        for (int i18 = 0; i18 < i11; i18++) {
            cArr2[i18] = cArr[(i11 - i18) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String b(String str, k kVar) {
        if (str.length() != kVar.a()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb2 = new StringBuilder(kVar.a() + kVar.c());
        sb2.append(str);
        int iF = kVar.f();
        if (iF == 1) {
            sb2.append(a(str, kVar.c()));
        } else {
            sb2.setLength(sb2.capacity());
            int[] iArr = new int[iF];
            int[] iArr2 = new int[iF];
            int i11 = 0;
            while (i11 < iF) {
                int i12 = i11 + 1;
                iArr[i11] = kVar.b(i12);
                iArr2[i11] = kVar.d(i12);
                i11 = i12;
            }
            for (int i13 = 0; i13 < iF; i13++) {
                StringBuilder sb3 = new StringBuilder(iArr[i13]);
                for (int i14 = i13; i14 < kVar.a(); i14 += iF) {
                    sb3.append(str.charAt(i14));
                }
                String strA = a(sb3.toString(), iArr2[i13]);
                int i15 = i13;
                int i16 = 0;
                while (i15 < iArr2[i13] * iF) {
                    sb2.setCharAt(kVar.a() + i15, strA.charAt(i16));
                    i15 += iF;
                    i16++;
                }
            }
        }
        return sb2.toString();
    }
}
