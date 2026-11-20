package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1727Vu implements I1<String> {
    public static byte[] A00;
    public static String[] A01 = {"", "vlIuDSzGbyZPSOo9NvS3Fgy2A3aK70Ro", "3dVIdsQUspyQ", "UTSvinwo0cRMStWYFPA8OYJwOxvnVwXs", "RE5EMThjSVpoLeDJX1cgkycsZ0xzbqtm", "RpzVhDU", "goToTGvZMCWAKhVB", "BfTI1em2yqq329uW9D4CSUzGh8lnadBe"};

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        String[] strArr = A01;
        if (strArr[7].charAt(27) != strArr[3].charAt(27)) {
            throw new RuntimeException();
        }
        A01[6] = "DusCHERYjWvkKwCYEIDEH2";
        A00 = new byte[]{8, Ascii.DC4, Ascii.CR, Ascii.FF, Ascii.DEL, 110, 115, Ascii.DEL, 119, 102, 123, 119, 44, 117, 119, 119, 105, 124, 125};
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.I1
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final boolean A5b(String str) {
        String strA0M = IF.A0M(str);
        return (TextUtils.isEmpty(strA0M) || (strA0M.contains(A00(4, 4, 69)) && !strA0M.contains(A00(8, 8, 77))) || strA0M.contains(A00(0, 4, 46)) || strA0M.contains(A00(16, 3, 95))) ? false : true;
    }
}
