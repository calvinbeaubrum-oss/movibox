package com.facebook.ads.redexgen.uinode;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1309Fg extends AbstractC1928bZ {
    public static byte[] A04;
    public static String[] A05 = {"eZwrQOnpnpQE2xbRo0zNjy7tlobdqdqH", "SFt7WwZUn", "NjRPf9lXQVcUlHZaPZ2tHyzwDKEOZm5m", "vsw9aGbGyLBdbL44W3z8tEYPUFR7w9", "bZApvv", "GYK1wV", "jBSwIULngy0dc0IzE6SbgF9ev3BAFzHy", "9HFC3JFq8"};
    public static final String A06;
    public OG A00;
    public final Uri A01;
    public final C1U A02;
    public final Map<String, String> A03;

    static {
        A07();
        A06 = C1309Fg.class.getSimpleName();
    }

    public C1309Fg(C1795Yn c1795Yn, J2 j11, String str, Uri uri, Map<String, String> map, C09580o c09580o, boolean z11, C1U c1u) {
        super(c1795Yn, j11, str, c09580o, z11);
        this.A01 = uri;
        this.A03 = map;
        this.A02 = c1u;
    }

    private Intent A00(C09570m c09570m) {
        if (TextUtils.isEmpty(c09570m.A05())) {
            return null;
        }
        String strA03 = c09570m.A03();
        if (!LM.A04(((AbstractC09520h) this).A00, c09570m.A05()) && !A09(((AbstractC09520h) this).A00, strA03)) {
            return null;
        }
        if (!TextUtils.isEmpty(strA03) && (strA03.startsWith(A04(250, 4, 23)) || strA03.startsWith(A04(254, 10, 41)))) {
            return new Intent(A04(62, 26, 24), AbstractC1446Ky.A00(strA03));
        }
        PackageManager packageManager = ((AbstractC09520h) this).A00.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        if (TextUtils.isEmpty(c09570m.A04()) && TextUtils.isEmpty(strA03)) {
            return packageManager.getLaunchIntentForPackage(c09570m.A05());
        }
        Intent intentA01 = A01(c09570m);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intentA01, 65536);
        if (intentA01.getComponent() == null) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                String[] strArr = A05;
                if (strArr[5].length() == strArr[4].length()) {
                    String[] strArr2 = A05;
                    strArr2[7] = "mdy3DwQER";
                    strArr2[1] = "z4eGZXaiq";
                    if (!zHasNext) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo.packageName.equals(c09570m.A05())) {
                        intentA01.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                        break;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        if (listQueryIntentActivities.isEmpty() || intentA01.getComponent() == null) {
            if (!A09(((AbstractC09520h) this).A00, strA03)) {
                return null;
            }
            String strA05 = c09570m.A05();
            String[] strArr3 = A05;
            if (strArr3[5].length() != strArr3[4].length()) {
                throw new RuntimeException();
            }
            A05[2] = "8xekkGfEbM0UNtDVsVek4v0mq2iI8UOu";
            intentA01.setPackage(strA05);
        }
        return intentA01;
    }

    private Intent A01(C09570m c09570m) {
        Intent intent = new Intent(A04(88, 26, 38));
        intent.addFlags(ASTNode.DEOP);
        if (!TextUtils.isEmpty(c09570m.A05()) && !TextUtils.isEmpty(c09570m.A04())) {
            intent.setComponent(new ComponentName(c09570m.A05(), c09570m.A04()));
        }
        if (!TextUtils.isEmpty(c09570m.A03())) {
            intent.setData(AbstractC1446Ky.A00(c09570m.A03()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A01.getQueryParameter(A04(219, 9, 104));
        if (!TextUtils.isEmpty(queryParameter)) {
            return AbstractC1446Ky.A00(queryParameter);
        }
        return AbstractC1446Ky.A00(String.format(Locale.US, A04(WebSocketProtocol.PAYLOAD_SHORT, 22, 117), this.A01.getQueryParameter(A04(211, 8, 63))));
    }

    private EnumC09510g A03() throws C1431Kh {
        C1443Kv c1443Kv = new C1443Kv();
        try {
            return C1443Kv.A05(c1443Kv, ((AbstractC09520h) this).A00, A02(), ((AbstractC09520h) this).A02, this.A03);
        } catch (C1431Kh unused) {
            String str = A04(26, 27, 35) + this.A01.toString();
            String queryParameter = this.A01.getQueryParameter(A04(228, 22, 18));
            if (queryParameter != null && queryParameter.length() > 0) {
                C1443Kv.A0D(c1443Kv, ((AbstractC09520h) this).A00, AbstractC1446Ky.A00(queryParameter), ((AbstractC09520h) this).A02);
            }
            return EnumC09510g.A08;
        }
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = (bArrCopyOfRange[i14] - i13) - 27;
            String[] strArr = A05;
            if (strArr[6].charAt(23) == strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A05[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
            bArrCopyOfRange[i14] = (byte) i15;
        }
        return new String(bArrCopyOfRange);
    }

    private List<C09570m> A05() {
        String queryParameter = this.A01.getQueryParameter(A04(114, 12, 124));
        if (TextUtils.isEmpty(queryParameter) || A04(53, 2, 109).equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(queryParameter).optJSONArray(A04(55, 7, 127));
            if (jSONArrayOptJSONArray != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    C09570m c09570mA00 = C09570m.A00(jSONArrayOptJSONArray.optJSONObject(i11));
                    if (c09570mA00 != null) {
                        arrayList.add(c09570mA00);
                    }
                }
            }
        } catch (JSONException e11) {
            ((AbstractC09520h) this).A00.A07().A9a(A04(204, 7, 47), C8A.A24, new C8B(e11));
            Log.w(A06, A04(0, 26, 10), e11);
        }
        return arrayList;
    }

    private final List<Intent> A06() {
        List<C09570m> listA05 = A05();
        ArrayList arrayList = new ArrayList();
        if (listA05 != null) {
            Iterator<C09570m> it = listA05.iterator();
            while (it.hasNext()) {
                Intent intentA00 = A00(it.next());
                if (intentA00 != null) {
                    arrayList.add(intentA00);
                }
            }
        }
        return arrayList;
    }

    public static void A07() {
        A04 = new byte[]{106, -105, -105, -108, -105, 69, -107, -122, -105, -104, -114, -109, -116, 69, -122, -107, -107, -104, -114, -103, -118, -124, -119, -122, -103, -122, -124, -97, -89, -86, -93, -94, 94, -78, -83, 94, -83, -82, -93, -84, 94, -85, -97, -80, -87, -93, -78, 94, -77, -80, -86, 120, 94, -29, -27, -5, 8, -2, Ascii.FF, 9, 3, -2, -108, -95, -105, -91, -94, -100, -105, 97, -100, -95, -89, -104, -95, -89, 97, -108, -106, -89, -100, -94, -95, 97, 119, 124, 116, Ascii.DEL, -94, -81, -91, -77, -80, -86, -91, 111, -86, -81, -75, -90, -81, -75, 111, -94, -92, -75, -86, -80, -81, 111, -105, -118, -122, -104, -8, 7, 7, 10, 0, Ascii.VT, -4, -10, -5, -8, Ascii.VT, -8, -3, -15, 2, -5, -11, 4, -54, -65, -65, -12, -11, 4, -15, -7, -4, 3, -49, -7, -12, -51, -75, 3, -26, -25, -36, -27, -36, -37, -42, -37, -36, -36, -25, -29, -32, -27, -30, -108, -107, -118, -109, -118, -119, -124, -104, -103, -108, -105, -118, -124, -117, -122, -111, -111, -121, -122, -120, -112, -124, -102, -105, -111, -38, -37, -48, -39, -48, -49, -54, -34, -33, -38, -35, -48, -54, -32, -35, -41, -70, -85, -68, -67, -77, -72, -79, -51, -50, -55, -52, -65, -71, -61, -66, -10, -9, -14, -11, -24, -30, -8, -11, -17, -96, -95, -100, -97, -110, -116, -94, -97, -103, -116, -92, -110, -113, -116, -109, -114, -103, -103, -113, -114, -112, -104, -90, -105, -98, 108, -72, -87, -80, -76, -74, -77, -79, -76, -72, 126, -61, -63, -77, -64, -83, -80, -61, -76, -76, -77, -64, -77, -78, -83, -60, -73, -78, -77, -67, -83, -79, -70, -73, -79, -71};
    }

    private boolean A08() {
        List<Intent> listA06 = A06();
        if (listA06 == null) {
            return false;
        }
        Iterator<Intent> it = listA06.iterator();
        while (it.hasNext()) {
            try {
                if (C1433Kj.A0C(((AbstractC09520h) this).A00, it.next())) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean A09(C1795Yn c1795Yn, String str) {
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            boolean zA1g = C1384Ih.A1g(c1795Yn);
            if (A05[3].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "1LqNNd92i";
            strArr[1] = "QkgxMECyk";
            if (zA1g) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1928bZ
    public final EnumC09510g A0D() {
        OG og2;
        EnumC09510g enumC09510gA0G = EnumC09510g.A08;
        if (((AbstractC1928bZ) this).A02) {
            enumC09510gA0G = A0G();
        } else {
            this.A03.put(A04(188, 16, 80), String.valueOf(true));
        }
        if (AbstractC1462Lo.A0e(((AbstractC09520h) this).A00, enumC09510gA0G, this.A03)) {
            EnumC09510g enumC09510g = EnumC09510g.A07;
            if (A05[2].charAt(11) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "cFM2nXNzq";
            strArr[1] = "5qRqyCpR9";
            if (enumC09510gA0G != enumC09510g && (og2 = this.A00) != null) {
                og2.A0B(A04(264, 25, 51), this.A02, ((AbstractC09520h) this).A02);
            }
        } else {
            A0E(this.A03, enumC09510gA0G);
            C1U.A06(this.A02, ((AbstractC09520h) this).A00);
        }
        return enumC09510gA0G;
    }

    public final EnumC09510g A0G() {
        EnumC09510g enumC09510gA03 = EnumC09510g.A08;
        String strA04 = A04(148, 15, 92);
        boolean zA0F = A0F(this.A01);
        if (!zA0F) {
            zA0F = A08();
        }
        if (!zA0F) {
            try {
                enumC09510gA03 = A03();
                strA04 = enumC09510gA03 != EnumC09510g.A08 ? A04(188, 16, 80) : A04(163, 25, 10);
            } catch (Exception unused) {
                enumC09510gA03 = EnumC09510g.A03;
            }
        }
        this.A03.put(strA04, String.valueOf(true));
        return enumC09510gA03;
    }

    public final void A0H(OG og2) {
        this.A00 = og2;
    }
}
