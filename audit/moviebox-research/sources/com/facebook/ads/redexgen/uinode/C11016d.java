package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11016d {
    public static byte[] A02;
    public static String[] A03 = {"xEW9LSpkxtcMkiVkCjWXuTu5CJHPJiyq", "tTP", "A", "dhAFlm3SiPB0s9864OvgcmZEVzRtwwmX", "mnE9bSEHBlleLkXo6La2W5bpkmZqSUyN", "0jwmHWkFqK", "xBcWrb6s57BN1yke0uYkFqIHC7aAgPEb", "dL0KwaEpZdlIbw3ka3MpOkzONR5qkJY2"};
    public static final String A04;
    public static volatile C11016d A05;
    public final C1794Ym A00;
    public final Map<String, C10986a> A01 = Collections.synchronizedMap(new HashMap());

    static {
        A09();
        A04 = C11016d.class.getSimpleName();
    }

    public C11016d(C1794Ym c1794Ym) {
        this.A00 = c1794Ym;
    }

    private int A00(String str, Bitmap bitmap) {
        String strA08 = A08(0, 2, 17);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    int size = byteArrayOutputStream.size();
                    if (size >= C1384Ih.A0F(this.A00)) {
                        A0B(new Throwable(A08(35, 42, 1) + size));
                        A0A(byteArrayOutputStream);
                        A0A(null);
                        return 0;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    A0A(byteArrayOutputStream);
                    if (A03[7].charAt(22) != 'z') {
                        throw new RuntimeException();
                    }
                    A03[4] = "r6vsbyQxsbBUkJdqjFKv7NMRisOUwCFh";
                    A0A(fileOutputStream);
                    return size;
                } catch (OutOfMemoryError e11) {
                    A0B(e11);
                    Log.e(A04, A08(184, 39, 92), e11);
                    A0A(null);
                    A0A(null);
                    return 0;
                }
            } catch (FileNotFoundException e12) {
                Log.e(A04, A08(6, 29, 95) + file.getPath() + strA08, e12);
                A0B(e12);
                A0A(null);
                A0A(null);
                return 0;
            } catch (IOException e13) {
                A0B(e13);
                Log.e(A04, A08(148, 36, 57) + str + strA08, e13);
                A0A(null);
                A0A(null);
                return 0;
            }
        } catch (Throwable th2) {
            A0A(null);
            A0A(null);
            throw th2;
        }
    }

    private final Bitmap A01(C11237f c11237f, C10986a c10986a, int i11, int i12, String str) {
        if (C11036f.A06(c11237f) && A08(266, 4, 53).equals(str)) {
            Map<String, C10986a> map = this.A01;
            if (A03[4].charAt(4) != 'b') {
                throw new RuntimeException();
            }
            A03[1] = "FHlvPh";
            map.put(c10986a.A07, c10986a);
        }
        String str2 = c10986a.A07;
        C11026e c11026e = new C11026e(c10986a.A05, c10986a.A06, A08(261, 5, 43), str, str2);
        File file = new File(A07(this.A00), str2.hashCode() + A08(2, 4, 85));
        if (!file.exists()) {
            C11036f.A04(c11237f, c11026e, false);
            return (!str2.startsWith(A08(232, 7, 0)) || str2.startsWith(A08(239, 22, 123))) ? A02(c11237f, c10986a, str) : A04(str2, i12, i11);
        }
        C11036f.A04(c11237f, c11026e, true);
        try {
            return A0C(i12, i11) ? AbstractC11056h.A02(file.getCanonicalPath(), i12, i11, this.A00) : BitmapFactory.decodeFile(file.getCanonicalPath());
        } catch (IOException e11) {
            A0B(e11);
            return null;
        }
    }

    private Bitmap A02(C11237f c11237f, C10986a c10986a, String str) throws Throwable {
        Bitmap bitmapA01;
        String str2 = c10986a.A07;
        int i11 = c10986a.A03;
        int i12 = c10986a.A04;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOException e11 = null;
        String strA08 = A08(223, 9, 70);
        boolean zStartsWith = str2.startsWith(strA08);
        String strA09 = A08(239, 22, 123);
        if (zStartsWith || str2.startsWith(strA09)) {
            String strSubstring = str2.startsWith(strA08) ? str2.substring(strA08.length()) : str2.substring(strA09.length());
            InputStream inputStreamOpen = null;
            try {
                try {
                    inputStreamOpen = this.A00.getAssets().open(strSubstring);
                    if (A0C(i11, i12)) {
                        try {
                            bitmapA01 = AbstractC11056h.A01(inputStreamOpen, i11, i12);
                        } catch (IOException e12) {
                            e = e12;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (OutOfMemoryError e13) {
                            e = e13;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            throw th;
                        }
                    } else {
                        bitmapA01 = BitmapFactory.decodeStream(inputStreamOpen);
                    }
                    if (inputStreamOpen != null) {
                        A0A(inputStreamOpen);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e14) {
                e = e14;
            } catch (OutOfMemoryError e15) {
                e = e15;
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            boolean zA0C = A0C(i11, i12);
            if (A03[2].length() == 5) {
                throw new RuntimeException();
            }
            A03[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
            if (zA0C) {
                try {
                    bitmapA01 = A05(str2, i11, i12);
                } catch (IOException e16) {
                    e11 = e16;
                    A0B(e11);
                    bitmapA01 = A03(str2);
                }
            } else {
                bitmapA01 = A03(str2);
            }
        }
        String string = e11 != null ? e11.toString() : null;
        if (bitmapA01 == null) {
            C11036f.A03(c11237f, c10986a, str, C11036f.A03, string, null, null);
            return null;
        }
        long jA00 = A00(str2, bitmapA01);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA00 > 0) {
            C11036f.A03(c11237f, c10986a, str, C11036f.A02, string, Long.valueOf(jA00), Long.valueOf(jCurrentTimeMillis2));
            return bitmapA01;
        }
        C11036f.A03(c11237f, c10986a, str, C11036f.A01, string, null, null);
        if (C1384Ih.A0t(c11237f)) {
            return null;
        }
        return bitmapA01;
    }

    private Bitmap A03(String str) {
        byte[] bArrA68;
        RJ rjADy = C1606Rc.A00(this.A00).ADy(str, new RY());
        if (rjADy == null || (bArrA68 = rjADy.A68()) == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArrA68, 0, bArrA68.length);
    }

    private Bitmap A04(String str, int i11, int i12) {
        try {
            boolean zA0C = A0C(i11, i12);
            String strA08 = A08(232, 7, 0);
            Bitmap bitmapA02 = zA0C ? AbstractC11056h.A02(str.substring(strA08.length()), i11, i12, this.A00) : BitmapFactory.decodeStream(new FileInputStream(str.substring(strA08.length())), null, null);
            int iA00 = A00(str, bitmapA02);
            if (!C1384Ih.A0t(this.A00) || iA00 > 0) {
                return bitmapA02;
            }
            return null;
        } catch (IOException e11) {
            Log.e(A04, A08(105, 43, 38) + str + A08(0, 2, 17), e11);
        }
    }

    private Bitmap A05(String str, int i11, int i12) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap bitmapA01 = AbstractC11056h.A01(inputStream, i11, i12);
        A0A(inputStream);
        return bitmapA01;
    }

    public static C11016d A06(C1794Ym c1794Ym) {
        if (A05 == null) {
            synchronized (C11016d.class) {
                if (A05 == null) {
                    A05 = new C11016d(c1794Ym);
                }
            }
        }
        return A05;
    }

    public static File A07(C11237f c11237f) {
        return c11237f.getCacheDir();
    }

    public static String A08(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{97, 102, 34, 124, 98, 107, 68, 103, 98, 38, 105, 115, 114, 118, 115, 114, 38, 98, 99, 117, 114, 111, 104, 103, 114, 111, 105, 104, 38, 46, 96, 111, 106, 99, 59, Ascii.SUB, 49, 44, 53, 57, 40, 120, 43, 49, 34, 61, 120, 61, 32, 59, 61, 61, 60, 43, 120, 53, 57, 32, 120, 43, 49, 34, 61, 120, 62, 55, 42, 120, 43, 44, 55, 42, 57, Utf8.REPLACEMENT_BYTE, 61, 98, 120, 103, 69, 71, 76, 65, 4, 65, 86, 86, 75, 86, 10, 4, 102, 77, 80, 73, 69, 84, 4, 77, 87, 4, 74, 81, 72, 72, 10, 57, Ascii.RS, Ascii.SYN, 19, Ascii.SUB, Ascii.ESC, 95, Ascii.VT, Ascii.DLE, 95, Ascii.FS, Ascii.DLE, Ascii.SI, 6, 95, 19, Ascii.DLE, Ascii.FS, Ascii.RS, 19, 95, Ascii.SYN, Ascii.DC2, Ascii.RS, Ascii.CAN, Ascii.SUB, 95, Ascii.SYN, 17, Ascii.VT, Ascii.DLE, 95, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.ETB, Ascii.SUB, 95, 87, 10, Ascii.CR, 19, 66, 53, Ascii.SO, 1, 2, Ascii.FF, 5, 64, Ascii.DC4, Ascii.SI, 64, Ascii.ETB, Ascii.DC2, 9, Ascii.DC4, 5, 64, 2, 9, Ascii.DC4, Ascii.CR, 1, Ascii.DLE, 64, Ascii.DC4, Ascii.SI, 64, 6, 9, Ascii.FF, 5, 64, 72, Ascii.NAK, Ascii.DC2, Ascii.FF, 93, 80, 107, 100, 103, 105, 96, 37, 113, 106, 37, 114, 119, 108, 113, 96, 37, 103, 108, 113, 104, 100, 117, 37, 113, 106, 37, 106, 112, 113, 117, 112, 113, 37, 118, 113, 119, 96, 100, 104, 126, 108, 108, 122, 107, 37, 48, 48, 48, Utf8.REPLACEMENT_BYTE, 48, 53, 60, 99, 118, 118, 68, 75, 78, 71, Ascii.CAN, Ascii.CR, Ascii.CR, Ascii.CR, 67, 76, 70, 80, 77, 75, 70, 125, 67, 81, 81, 71, 86, Ascii.CR, Ascii.ESC, Ascii.US, 19, Ascii.NAK, Ascii.ETB, 0, 3, Ascii.CR, 8, 77, 86, 83, 86, 87, 79, 86};
    }

    public static void A0A(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(Throwable th2) {
        String strA08 = A08(261, 5, 43);
        if (th2 != null) {
            this.A00.A07().A9a(strA08, C8A.A1f, new C8B(th2));
        } else {
            this.A00.A07().A9a(strA08, C8A.A1f, new C8B(A08(77, 28, 125)));
        }
    }

    private boolean A0C(int i11, int i12) {
        return i11 > 0 && i12 > 0 && C1384Ih.A1A(this.A00);
    }

    public final Bitmap A0D(C10986a c10986a) {
        return A01(this.A00, c10986a, c10986a.A04, c10986a.A03, c10986a.A01);
    }

    public final Bitmap A0E(C11237f c11237f, String str, int i11, int i12, String str2) {
        C10986a c10986a = this.A01.get(str);
        return (!C11036f.A06(c11237f) || c10986a == null) ? A01(c11237f, new C10986a(str, i11, i12, A08(270, 7, 97), A08(270, 7, 97)), i12, i11, str2) : A01(c11237f, c10986a, i12, i11, str2);
    }

    public final File A0F(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0G(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        return file.exists() ? file.getPath() : str;
    }
}
