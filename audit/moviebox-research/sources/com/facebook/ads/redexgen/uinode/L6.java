package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class L6 {
    public static int A00;
    public static byte[] A01;
    public static String[] A02 = {"W5GQ1A2ylrhjGcW6pMhO2KpBuuMbjdB5", "Zx6aawmOn04orHuEArp9Y", "DMoITyb3L57ZarlqFv80uTh", "nsJ3", "1RYBeERStpTg7BOn5NhEUzstvZKMnlwS", "VuYSQW8JaBTDlxPB8JxFHKy", "", "NX"};
    public static final AtomicReference<Boolean> A03;
    public static volatile L5 A04;

    static {
        A07();
        A00 = -1;
        A04 = L5.A04;
        A03 = new AtomicReference<>(null);
    }

    public static int A01(Context context) {
        if (A04 == L5.A04) {
            A08(context);
        }
        return A00;
    }

    public static int A02(Context context) {
        try {
            return A05(context.getAssets().openXmlResourceParser(A06(0, 19, 71)));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int A03(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).minSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static int A05(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(A06(76, 8, 53))) {
                for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                    if (xmlPullParser.getAttributeName(i11).equals(A06(45, 13, 26))) {
                        return Integer.parseInt(xmlPullParser.getAttributeValue(i11));
                    }
                }
            }
        }
        return 0;
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{60, 19, Ascii.EM, Ascii.SI, Ascii.DC2, Ascii.DC4, Ascii.EM, 48, Ascii.FS, 19, Ascii.DC4, Ascii.ESC, Ascii.CAN, Ascii.SO, 9, 83, 5, Ascii.DLE, 17, 123, 121, 110, 115, 108, 115, 110, 99, Ascii.SYN, 7, 7, Ascii.ESC, Ascii.RS, Ascii.DC4, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, Ascii.CAN, Ascii.SUB, 17, Ascii.SUB, Ascii.CR, Ascii.SYN, Ascii.FS, 77, 73, 78, 115, 68, 75, 118, 69, 82, 83, 73, 79, 78, 17, 6, Ascii.DLE, 10, Ascii.EM, 6, 2, 1, Ascii.SI, 6, 34, 0, Ascii.ETB, 10, Ascii.NAK, 10, Ascii.ETB, Ascii.SUB, 122, 124, 106, 124, 34, 124, 107, 100};
    }

    public static void A08(Context context) {
        if (A0B()) {
            return;
        }
        A09(context);
    }

    public static void A09(Context context) {
        if (A04 != L5.A04) {
            return;
        }
        A04 = L5.A03;
        Executors.newSingleThreadExecutor().execute(new C1692Uk(context));
    }

    public static void A0A(C11237f c11237f, Throwable th2) {
        c11237f.A07().A9a(A06(38, 7, 69), C8A.A1c, new C8B(th2));
    }

    public static boolean A0B() {
        return A04 == L5.A02;
    }

    public static boolean A0C(C11237f c11237f) {
        Boolean bool = A03.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        XmlResourceParser xmlResourceParserOpenXmlResourceParser = null;
        boolean z11 = true;
        try {
            xmlResourceParserOpenXmlResourceParser = c11237f.getAssets().openXmlResourceParser(A06(0, 19, 71));
            loop0: while (xmlResourceParserOpenXmlResourceParser.next() != 1) {
                if (xmlResourceParserOpenXmlResourceParser.getEventType() == 2 && (xmlResourceParserOpenXmlResourceParser.getName().equals(A06(27, 11, 77)) || xmlResourceParserOpenXmlResourceParser.getName().equals(A06(19, 8, 32)))) {
                    for (int i11 = 0; i11 < xmlResourceParserOpenXmlResourceParser.getAttributeCount(); i11++) {
                        if (xmlResourceParserOpenXmlResourceParser.getAttributeName(i11).equals(A06(58, 18, 89)) && !Boolean.parseBoolean(xmlResourceParserOpenXmlResourceParser.getAttributeValue(i11))) {
                            z11 = false;
                            break loop0;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            A0A(c11237f, th2);
            String[] strArr = A02;
            if (strArr[5].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A02[0] = "eeMQW8Hjee4jIvBA7BhrF0CVQhVUWKRk";
            if (xmlResourceParserOpenXmlResourceParser != null) {
                try {
                    xmlResourceParserOpenXmlResourceParser.close();
                } catch (Exception e11) {
                    A0A(c11237f, e11);
                }
            }
        }
        A03.set(Boolean.valueOf(z11));
        return z11;
    }
}
