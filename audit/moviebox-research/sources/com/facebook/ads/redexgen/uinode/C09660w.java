package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0w, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09660w {
    public static C09660w A08;
    public static byte[] A09;
    public static String[] A0A = {"TOlR5WIHpQxnCrBDCJGIvboS5c1GP2eb", "1A072KPTjzB", "BhIKZU0mEosMUOfZes2VT64q11XJ2Uhn", "3eQHzZddeWPmYl0bNsvnb2WjxREMTE8a", "x", "3ukMDhdDleVgfGP2GHVzNRiRwZbG92ZS", "tXOxwX9vQ8QECIpzr41AiGeD6LbiHgO3", "feL0RS1gsJrC9VyxtC"};
    public static final String A0B;
    public boolean A01;
    public final C11237f A03;
    public final String A04;
    public final Executor A07;
    public final CountDownLatch A05 = new CountDownLatch(1);
    public final CountDownLatch A06 = new CountDownLatch(1);
    public final C09650v A02 = new C09650v();
    public String A00 = null;

    static {
        A09();
        A0B = C09660w.class.getSimpleName();
    }

    public C09660w(C11237f c11237f, boolean z11, Executor executor, String str) {
        this.A03 = c11237f.A01();
        this.A04 = str;
        this.A07 = executor;
        if (z11) {
            A0A();
        }
    }

    public static synchronized C09660w A01(C11237f c11237f) {
        if (A08 == null) {
            A08 = new C09660w(c11237f, true, ExecutorC1467Lt.A06, A03(0, 0, Worker.WHAT_SYNC_DATA));
        }
        return A08;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 69);
        }
        return new String(bArrCopyOfRange);
    }

    private String A04(String str) {
        String strA03 = A03(0, 0, Worker.WHAT_SYNC_DATA);
        try {
            synchronized (this) {
                File file = new File(this.A03.getFilesDir(), str);
                if (file.exists() && file.length() > 0) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    strA03 = new String(bArr, A03(0, 5, 98));
                }
            }
        } catch (FileNotFoundException e11) {
            this.A03.A07().A9a(A03(36, 17, 6), C8A.A17, new C8B(e11));
        } catch (IOException e12) {
            this.A03.A07().A9a(A03(36, 17, 6), C8A.A19, new C8B(e12));
        }
        return strA03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        String strA03 = A03(36, 17, 6);
        try {
            this.A02.A08(A04(this.A04 + A03(23, 13, 39)));
            this.A02.A0A(A04(A03(5, 18, 101)));
        } catch (C8B e11) {
            A0M();
            this.A03.A07().A9a(strA03, C8A.A18, e11);
        } catch (JSONException e12) {
            A0M();
            this.A03.A07().A9a(strA03, C8A.A1A, new C8B(e12));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08() {
        String string;
        synchronized (this.A02) {
            string = this.A02.A05().toString();
        }
        A0G(A0K(), string);
    }

    public static void A09() {
        byte[] bArr = {114, 115, 97, 10, Ascii.US, 65, 68, 83, 99, 65, 80, 80, 73, 78, 71, 105, 78, 70, 79, Ascii.SO, 84, 88, 84, 1, 3, Ascii.DC2, Ascii.DC2, 7, 6, 35, 6, 17, 76, Ascii.SYN, Ascii.SUB, Ascii.SYN, 37, 49, 38, 50, 54, 38, 45, 32, 58, Ascii.FS, 32, 34, 51, 51, 42, 45, 36};
        if (A0A[0].charAt(25) == 's') {
            throw new RuntimeException();
        }
        A0A[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
        A09 = bArr;
    }

    private final void A0A() {
        this.A07.execute(new C1925bW(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A0E(C1T c1t, String str, boolean z11) {
        c1t.A07(z11);
        if (c1t.A08() || c1t.A09()) {
            this.A02.A07(str);
        } else {
            this.A02.A09(str);
        }
    }

    private void A0F(String str) {
        File file = new File(this.A03.getFilesDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    private final synchronized void A0G(String str, String str2) {
        A0H(this.A04 + A03(23, 13, 39), str.getBytes());
        A0H(A03(5, 18, 101), str2.getBytes());
    }

    private void A0H(String str, byte[] bArr) {
        try {
            synchronized (this) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.A03.getFilesDir(), str));
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (FileNotFoundException e11) {
            this.A03.A07().A9a(A03(36, 17, 6), C8A.A17, new C8B(e11));
        } catch (IOException e12) {
            this.A03.A07().A9a(A03(36, 17, 6), C8A.A19, new C8B(e12));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0J(String str) {
        boolean z11 = false;
        try {
            synchronized (this.A02) {
                z11 = this.A02.A05().get(str) instanceof C1T;
            }
        } catch (JSONException e11) {
            this.A03.A07().A9a(A03(36, 17, 6), C8A.A1A, new C8B(e11));
        }
        return z11;
    }

    public final String A0K() {
        return this.A02.A04();
    }

    public final void A0L() {
        if (!this.A01 || this.A00 == null) {
            return;
        }
        this.A07.execute(new C1922bT(this, this.A00));
    }

    public final synchronized void A0M() {
        A0F(this.A04 + A03(5, 18, 101));
        A0F(this.A04 + A03(23, 13, 39));
    }

    public final void A0N(String str) {
        if (this.A01) {
            this.A00 = str;
            this.A07.execute(new C1923bU(this, str));
        }
    }

    public final void A0O(JSONObject jSONObject) {
        boolean zA13 = C1384Ih.A13(this.A03);
        this.A01 = zA13;
        if (zA13) {
            this.A07.execute(new C1924bV(this, jSONObject));
        }
    }
}
