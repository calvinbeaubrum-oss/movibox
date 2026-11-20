package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C09530i {
    public static byte[] A00;
    public static String[] A01 = {"88AoqknPZ4rnlocmRSd1iIvU160OI6Up", "Xa", "c0t0ITAkOrWkNbi2AOUUle7x7Lv9c02n", "B7XNNyfmW5R2wceLmJkXAkDES3fZG3Pt", "MUV", "NALjFYAH0tlSEiNw3RaQSfKZY5jyxbRm", "XF7p93xq3OHri6co5HggQunfVTz3vEaG", "n2FdIZz9zx79PfKUryB9rXi8CBHMM9xX"};
    public static final String A02;

    static {
        A03();
        A02 = C09530i.class.getSimpleName();
    }

    public static AbstractC09520h A00(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, C1U c1u) {
        return A01(c1795Yn, j11, str, uri, map, true, false, c1u);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:44:0x010c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0114  */
    /* JADX WARN: Code duplicated, block: B:49:0x011a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0123  */
    public static AbstractC09520h A01(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, boolean z11, boolean z12, C1U c1u) {
        C09580o c09580oA00;
        byte b11;
        if (uri == null || uri.getAuthority() == null) {
            return null;
        }
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter(A02(113, 9, 44));
        String queryParameter2 = uri.getQueryParameter(A02(45, 4, 86));
        if (queryParameter2 != null) {
            boolean zIsEmpty = TextUtils.isEmpty(queryParameter2);
            if (A01[2].charAt(25) != 'L') {
                throw new RuntimeException();
            }
            A01[2] = "ISDJ842CIGTTmPHzT0dMVnvZcLrwzpZ1";
            if (!zIsEmpty) {
                try {
                    JSONObject jSONObject = new JSONObject(queryParameter2);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            map.put(next, jSONObject.getString(next));
                        } catch (JSONException e11) {
                            e = e11;
                            c1795Yn.A07().A9a(A02(64, 7, 51), C8A.A23, new C8B(e));
                            Log.w(A02, A02(0, 45, 27), e);
                            c09580oA00 = C09580o.A00(j11, ActivityUtils.A00());
                            switch (authority.hashCode()) {
                                case -1458789996:
                                    if (authority.equals(A02(71, 11, 74))) {
                                        b11 = -1;
                                    } else {
                                        b11 = 2;
                                    }
                                    break;
                                case 109770977:
                                    if (authority.equals(A02(82, 5, 117))) {
                                        b11 = -1;
                                    } else {
                                        b11 = 0;
                                    }
                                    break;
                                case 1546100943:
                                    if (authority.equals(A02(55, 9, 15))) {
                                        b11 = -1;
                                    } else {
                                        b11 = 1;
                                    }
                                    break;
                                default:
                                    b11 = -1;
                                    break;
                            }
                            switch (b11) {
                                case 0:
                                    if (queryParameter != null) {
                                        return null;
                                    }
                                    if (z12) {
                                    }
                                    break;
                                case 1:
                                    if (A02(109, 4, 100).equals(uri.getQueryParameter(A02(49, 6, 28)))) {
                                        return new C1306Fd(c1795Yn, j11, str, uri, map, c09580oA00, z11);
                                    }
                                    return z12 ? new C1308Ff(c1795Yn, j11, str, uri, map) : new C1307Fe(c1795Yn, j11, str, uri, map, c09580oA00, z11);
                                case 2:
                                    return new C1927bY(c1795Yn, j11, str, uri, map);
                                default:
                                    return new C1926bX(c1795Yn, j11, str, uri);
                            }
                        }
                    }
                } catch (JSONException e12) {
                    e = e12;
                }
            }
        }
        c09580oA00 = C09580o.A00(j11, ActivityUtils.A00());
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals(A02(71, 11, 74))) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 109770977:
                if (authority.equals(A02(82, 5, 117))) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 1546100943:
                if (authority.equals(A02(55, 9, 15))) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                if (queryParameter != null) {
                    return null;
                }
                return (z12 || TextUtils.isEmpty(uri.getQueryParameter(A02(87, 22, 122)))) ? new C1309Fg(c1795Yn, j11, str, uri, map, c09580oA00, z11, c1u) : new C1308Ff(c1795Yn, j11, str, uri, map, true);
            case 1:
                if (A02(109, 4, 100).equals(uri.getQueryParameter(A02(49, 6, 28)))) {
                    return new C1306Fd(c1795Yn, j11, str, uri, map, c09580oA00, z11);
                }
                if (z12) {
                }
            case 2:
                return new C1927bY(c1795Yn, j11, str, uri, map);
            default:
                return new C1926bX(c1795Yn, j11, str, uri);
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, Ascii.SUB, 78, 85, Ascii.SUB, 74, 91, 72, 73, 95, Ascii.SUB, 80, 73, 85, 84, Ascii.SUB, 94, 91, 78, 91, Ascii.SUB, 83, 84, Ascii.SUB, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, Ascii.DC4, 19, Ascii.SYN, 3, Ascii.SYN, 82, 83, 78, 84, 73, 88, 65, 94, 75, 64, 113, 66, 71, 64, 69, 98, 115, 96, 97, 123, 124, 117, Ascii.ESC, 10, Ascii.CAN, Ascii.CAN, Ascii.US, 3, Ascii.EM, 4, Ascii.RS, Ascii.FF, 3, 39, 32, 59, 38, 49, 40, 47, 52, 41, 62, 4, 46, 41, 55, 4, 44, 62, 57, 4, 61, 58, 55, 55, 57, 58, 56, 48, 49, 55, 48, 32, 123, 100, 105, 104, 98, 82, 120, Ascii.DEL, 97};
    }

    public static boolean A04(String str) {
        return A02(82, 5, 117).equalsIgnoreCase(str) || A02(55, 9, 15).equalsIgnoreCase(str);
    }
}
