package z20;

import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g[] f81747d = {new g("", 0, ""), new g("", 0, " "), new g(" ", 0, " "), new g("", 12, ""), new g("", 10, " "), new g("", 0, " the "), new g(" ", 0, ""), new g("s ", 0, " "), new g("", 0, " of "), new g("", 10, ""), new g("", 0, " and "), new g("", 13, ""), new g("", 1, ""), new g(", ", 0, " "), new g("", 0, ", "), new g(" ", 10, " "), new g("", 0, " in "), new g("", 0, " to "), new g("e ", 0, " "), new g("", 0, "\""), new g("", 0, InstructionFileId.DOT), new g("", 0, "\">"), new g("", 0, "\n"), new g("", 3, ""), new g("", 0, "]"), new g("", 0, " for "), new g("", 14, ""), new g("", 2, ""), new g("", 0, " a "), new g("", 0, " that "), new g(" ", 10, ""), new g("", 0, ". "), new g(InstructionFileId.DOT, 0, ""), new g(" ", 0, ", "), new g("", 15, ""), new g("", 0, " with "), new g("", 0, "'"), new g("", 0, " from "), new g("", 0, " by "), new g("", 16, ""), new g("", 17, ""), new g(" the ", 0, ""), new g("", 4, ""), new g("", 0, ". The "), new g("", 11, ""), new g("", 0, " on "), new g("", 0, " as "), new g("", 0, " is "), new g("", 7, ""), new g("", 1, "ing "), new g("", 0, "\n\t"), new g("", 0, ":"), new g(" ", 0, ". "), new g("", 0, "ed "), new g("", 20, ""), new g("", 18, ""), new g("", 6, ""), new g("", 0, "("), new g("", 10, ", "), new g("", 8, ""), new g("", 0, " at "), new g("", 0, "ly "), new g(" the ", 0, " of "), new g("", 5, ""), new g("", 9, ""), new g(" ", 10, ", "), new g("", 10, "\""), new g(InstructionFileId.DOT, 0, "("), new g("", 11, " "), new g("", 10, "\">"), new g("", 0, "=\""), new g(" ", 0, InstructionFileId.DOT), new g(".com/", 0, ""), new g(" the ", 0, " of the "), new g("", 10, "'"), new g("", 0, ". This "), new g("", 0, ","), new g(InstructionFileId.DOT, 0, " "), new g("", 10, "("), new g("", 10, InstructionFileId.DOT), new g("", 0, " not "), new g(" ", 0, "=\""), new g("", 0, "er "), new g(" ", 11, " "), new g("", 0, "al "), new g(" ", 11, ""), new g("", 0, "='"), new g("", 11, "\""), new g("", 10, ". "), new g(" ", 0, "("), new g("", 0, "ful "), new g(" ", 10, ". "), new g("", 0, "ive "), new g("", 0, "less "), new g("", 11, "'"), new g("", 0, "est "), new g(" ", 10, InstructionFileId.DOT), new g("", 11, "\">"), new g(" ", 0, "='"), new g("", 10, ","), new g("", 0, "ize "), new g("", 11, InstructionFileId.DOT), new g("Â ", 0, ""), new g(" ", 0, ","), new g("", 10, "=\""), new g("", 11, "=\""), new g("", 0, "ous "), new g("", 11, ", "), new g("", 10, "='"), new g(" ", 10, ","), new g(" ", 11, "=\""), new g(" ", 11, ", "), new g("", 11, ","), new g("", 11, "("), new g("", 11, ". "), new g(" ", 11, InstructionFileId.DOT), new g("", 11, "='"), new g(" ", 11, ". "), new g(" ", 10, "=\""), new g(" ", 11, "='"), new g(" ", 10, "='")};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f81748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f81750c;

    public g(String str, int i11, String str2) {
        this.f81748a = a(str);
        this.f81749b = i11;
        this.f81750c = a(str2);
    }

    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) str.charAt(i11);
        }
        return bArr;
    }

    public static int b(byte[] bArr, int i11, byte[] bArr2, int i12, int i13, g gVar) {
        int i14 = i11;
        for (byte b11 : gVar.f81748a) {
            bArr[i14] = b11;
            i14++;
        }
        int i15 = gVar.f81749b;
        int iA = i.a(i15);
        if (iA > i13) {
            iA = i13;
        }
        int i16 = i12 + iA;
        int iB = (i13 - iA) - i.b(i15);
        int i17 = iB;
        while (i17 > 0) {
            bArr[i14] = bArr2[i16];
            i17--;
            i14++;
            i16++;
        }
        if (i15 == 11 || i15 == 10) {
            int i18 = i14 - iB;
            if (i15 == 10) {
                iB = 1;
            }
            while (iB > 0) {
                byte b12 = bArr[i18];
                int i19 = b12 & 255;
                if (i19 < 192) {
                    if (i19 >= 97 && i19 <= 122) {
                        bArr[i18] = (byte) (b12 ^ 32);
                    }
                    i18++;
                    iB--;
                } else if (i19 < 224) {
                    int i21 = i18 + 1;
                    bArr[i21] = (byte) (bArr[i21] ^ 32);
                    i18 += 2;
                    iB -= 2;
                } else {
                    int i22 = i18 + 2;
                    bArr[i22] = (byte) (bArr[i22] ^ 5);
                    i18 += 3;
                    iB -= 3;
                }
            }
        }
        for (byte b13 : gVar.f81750c) {
            bArr[i14] = b13;
            i14++;
        }
        return i14 - i11;
    }
}
