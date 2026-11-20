package com.facebook.ads.redexgen.uinode;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EP extends AbstractC1791Yj<String> {
    public static byte[] A08;
    public static String[] A09 = {"l", "T0JdG9ZEnLfTeCeftC9G7d8cUsVG3XZb", "aLcPLzyPnyiGnlL0eBnocVG2Im", "W3EwFUE7CvVeZV", "t2q4fu0Y0bIBimY2SigNyotMmunbmEsF", "TUpEXXUjgi8xLksArOVlucAVZCM", "AqOn5F5Mae0spU5kh0gbanyLcs", "chqW8UrgIl8Ef4OOKimE4h"};
    public final /* synthetic */ double A00;
    public final /* synthetic */ double A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ C11297o A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ String A05;
    public final /* synthetic */ String A06;
    public final /* synthetic */ Map A07;

    static {
        A02();
    }

    public EP(C11297o c11297o, String str, String str2, int i11, double d11, double d12, String str3, Map map) {
        this.A03 = c11297o;
        this.A06 = str;
        this.A05 = str2;
        this.A02 = i11;
        this.A01 = d11;
        this.A00 = d12;
        this.A04 = str3;
        this.A07 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11317r
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final String A03() {
        String strA01 = A01(0, 8, 12);
        this.A03.A01.A07().A8l(this.A06);
        if (TextUtils.isEmpty(this.A05)) {
            return null;
        }
        C11297o.A08.lock();
        String[] strArr = A09;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[1] = "mqnyRlomjFPPGlBu5iJ3A4HRnrnsorAH";
        strArr2[4] = "vLAqNnzkqKgbXCY8NZfbbPBhHyGRm9s6";
        SQLiteDatabase sQLiteDatabaseA0E = null;
        try {
            sQLiteDatabaseA0E = this.A03.A0E();
            sQLiteDatabaseA0E.beginTransaction();
            String strA0E = this.A03.A02.A0E(this.A03.A03.A0C(this.A05), this.A02, this.A06, this.A01, this.A00, this.A04, this.A07);
            sQLiteDatabaseA0E.setTransactionSuccessful();
            return strA0E;
        } catch (Exception e11) {
            A01(C7q.A06);
            this.A03.A01.A07().A9a(strA01, C8A.A0y, new C8B(e11));
            return null;
        } finally {
            if (sQLiteDatabaseA0E != null && sQLiteDatabaseA0E.isOpen()) {
                try {
                    if (sQLiteDatabaseA0E.inTransaction()) {
                        sQLiteDatabaseA0E.endTransaction();
                    }
                } catch (Exception e12) {
                    this.A03.A01.A07().A9a(strA01, C8A.A0z, new C8B(e12));
                }
            }
            C11297o.A08.unlock();
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{-112, -115, -96, -115, -114, -115, -97, -111};
    }
}
