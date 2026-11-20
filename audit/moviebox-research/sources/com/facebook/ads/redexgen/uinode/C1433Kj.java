package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.mvel2.ast.ASTNode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1433Kj {
    public static byte[] A00;
    public static String[] A01 = {"R2O7PMYP6nkOeNui3I4WlXx4fu7rpRKA", "y", "n9RLgUbY6qPVyxnn4C2MCNq6tOX6tKMu", "KtI8XvYnNiAs4lVQz", "VIjGruAAxxfbDEfj8", "jnPluIPOifq7BY1vqnqKLiUetY3DHsfM", "J5aiTqmsNT2689NKU", "zCaDldCe0EtEl2h3W"};
    public static final Package A02;
    public static final String A03;
    public static final String A04;
    public static final String A05;
    public static final Set<C1795Yn> A06;
    public static final AtomicReference<InterfaceC1440Ks> A07;
    public static final AtomicReference<InterfaceC1442Ku> A08;

    static {
        A07();
        Package r11 = C1433Kj.class.getPackage();
        A02 = r11;
        A04 = r11 + A06(40, 22, 38);
        A03 = r11 + A06(0, 19, 81);
        A05 = r11 + A06(19, 21, 124);
        A06 = Collections.newSetFromMap(new WeakHashMap());
        A07 = new AtomicReference<>();
        A08 = new AtomicReference<>();
    }

    public static Intent A00(Intent intent) {
        Intent intentCloneFilter = intent.cloneFilter();
        intentCloneFilter.setFlags(intent.getFlags());
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(intent.getExtras());
        intentCloneFilter.putExtra(A05, parcelObtain.marshall());
        parcelObtain.recycle();
        return intentCloneFilter;
    }

    public static Intent A01(Intent intent, ClassLoader classLoader) {
        Intent intentCloneFilter = intent.cloneFilter();
        intentCloneFilter.setFlags(intent.getFlags());
        Bundle bundle = new Bundle();
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArrayExtra = intent.getByteArrayExtra(A05);
        if (byteArrayExtra != null) {
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            bundle = parcelObtain.readBundle(classLoader);
            parcelObtain.recycle();
        }
        intentCloneFilter.putExtras(bundle);
        return intentCloneFilter;
    }

    public static Bundle A02(Bundle bundle, ClassLoader classLoader) {
        Parcel parcelObtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A04);
        if (byteArray == null) {
            throw new IllegalStateException(A06(62, 28, 98));
        }
        parcelObtain.unmarshall(byteArray, 0, byteArray.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle2 = parcelObtain.readBundle(classLoader);
        parcelObtain.recycle();
        String[] strArr = A01;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "08vXapB5qdF8q1e2g";
        strArr2[3] = "bPV7EQI3jYdBWJzP2";
        return bundle2;
    }

    public static C1795Yn A03(Intent intent) {
        String stringExtra = intent.getStringExtra(A03);
        if (stringExtra == null) {
            return null;
        }
        for (C1795Yn c1795Yn : A06) {
            if (stringExtra.equals(c1795Yn.A0E().getId())) {
                return c1795Yn;
            }
        }
        return null;
    }

    public static AdActivityIntent A04(C1795Yn c1795Yn) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(c1795Yn.getApplicationContext(), A05());
        adActivityIntent.putExtra(A03, c1795Yn.A0E().getId());
        A06.add(c1795Yn);
        return adActivityIntent;
    }

    public static Class A05() {
        boolean zIsRemoteRenderingProcess = ProcessUtils.isRemoteRenderingProcess();
        if (A01[1].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "4NnM5dRGBMW0KGxzs";
        strArr[3] = "N6FCbEqQMIqNBYuck";
        if (!zIsRemoteRenderingProcess) {
            return AudienceNetworkActivity.class;
        }
        try {
            return Class.forName(A06(113, 59, 59));
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-111, -92, -89, -79, -70, -62, -92, -89, -62, -78, -91, -83, -62, -84, -89, -62, -82, -88, -68, -68, -49, -46, -36, -27, -19, -35, -32, -41, -43, -41, -36, -49, -38, -19, -45, -26, -30, -32, -49, -31, 102, 121, 124, -122, -113, -105, -117, 121, -114, 125, 124, -105, -117, -116, 121, -116, 125, -105, 124, 121, -116, 121, -57, -43, -22, -39, -40, -108, -25, -24, -43, -24, -39, -108, -42, -23, -30, -40, -32, -39, -108, -35, -25, -108, -39, -31, -28, -24, -19, -107, -19, -17, 0, -21, 1, 0, -11, -8, -77, -64, -79, -75, -66, -69, -73, -64, -58, -79, -58, -63, -67, -73, -64, -80, -68, -70, 123, -77, -82, -80, -78, -81, -68, -68, -72, 123, -82, -79, -64, 123, -74, -69, -63, -78, -65, -69, -82, -71, 123, -74, -67, -80, 123, -114, -62, -79, -74, -78, -69, -80, -78, -101, -78, -63, -60, -68, -65, -72, -97, -78, -70, -68, -63, -78, -114, -80, -63, -74, -61, -74, -63, -58, -30, -37, -24, -34, -26, -33, -49, -20, -29, -64, -23, -20, -52, -33, -19, -17, -26, -18, -92, -91, -110, -93, -91, 114, -108, -91, -102, -89, -102, -91, -86, -53, -52, -71, -54, -52, -103, -69, -52, -63, -50, -63, -52, -47, -98, -57, -54, -86, -67, -53, -51, -60, -52};
    }

    public static void A08(Activity activity, Intent intent) throws C1431Kh {
        try {
            activity.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e11) {
            throw new C1431Kh(e11);
        }
    }

    public static void A09(Bundle bundle, Bundle bundle2) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle2);
        bundle.putByteArray(A04, parcelObtain.marshall());
        parcelObtain.recycle();
    }

    public static void A0A(C1795Yn c1795Yn, AdActivityIntent adActivityIntent) throws C1431Kh {
        Activity activityA0D;
        Context applicationContext = c1795Yn.getApplicationContext();
        if (C1384Ih.A25(c1795Yn) && (activityA0D = c1795Yn.A0D()) != null) {
            applicationContext = activityA0D;
            if ((adActivityIntent.getFlags() & ASTNode.DEOP) == 268435456) {
                adActivityIntent.setFlags(adActivityIntent.getFlags() ^ ASTNode.DEOP);
            }
        }
        try {
            if (!ProcessUtils.isRemoteRenderingProcess()) {
                applicationContext.startActivity(A00(adActivityIntent));
            } else {
                if (A0J(c1795Yn, adActivityIntent)) {
                    return;
                }
                c1795Yn.A0E().AF0();
            }
        } catch (ActivityNotFoundException e11) {
            throw new C1431Kh(e11);
        }
    }

    public static boolean A0B(Intent intent, Set<String> set) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String string = data.toString();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (string.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0C(C1795Yn c1795Yn, Intent intent) throws C1431Kh {
        A07.get();
        return A0G(c1795Yn, intent, null);
    }

    public static boolean A0D(C1795Yn c1795Yn, Intent intent) throws C1431Kh {
        A07.get();
        if (0 == 0 || c1795Yn.A0D() == null) {
            return false;
        }
        c1795Yn.A0B();
        try {
            c1795Yn.A0D();
            throw new NullPointerException(A06(203, 22, 70));
        } catch (ActivityNotFoundException e11) {
            throw new C1431Kh(e11);
        } catch (Exception e12) {
            c1795Yn.A07().A9a(A06(90, 8, 122), C8A.A07, new C8B(e12));
            return false;
        }
    }

    public static boolean A0E(C1795Yn c1795Yn, Intent intent) throws C1431Kh {
        return A0F(c1795Yn, A00(intent), -1);
    }

    public static boolean A0F(C1795Yn c1795Yn, Intent intent, int i11) throws C1431Kh {
        try {
            Activity activityA00 = ActivityUtils.A00();
            if (activityA00 == null) {
                activityA00 = c1795Yn.A0D();
            }
            if (activityA00 == null) {
                return false;
            }
            if (i11 >= 0) {
                activityA00.startActivityForResult(intent, i11);
                return true;
            }
            activityA00.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e11) {
            throw new C1431Kh(e11);
        }
    }

    public static boolean A0G(C1795Yn c1795Yn, Intent intent, InterfaceC1440Ks interfaceC1440Ks) throws C1431Kh {
        if (A0B(intent, C1384Ih.A0V(c1795Yn))) {
            return false;
        }
        Activity activity = c1795Yn;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A01[1] = "W";
        Activity activityA0D = c1795Yn.A0D();
        if (activityA0D != null) {
            activity = activityA0D;
        } else {
            intent.addFlags(ASTNode.DEOP);
        }
        if (interfaceC1440Ks == null || A0B(intent, C1384Ih.A0X(c1795Yn))) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e11) {
                throw new C1431Kh(e11);
            }
        }
        c1795Yn.A0B();
        try {
            throw new NullPointerException(A06(190, 13, 31));
        } catch (ActivityNotFoundException e12) {
            throw new C1431Kh(e12);
        } catch (Exception e13) {
            c1795Yn.A07().A9a(A06(90, 8, 122), C8A.A08, new C8B(e13));
            return false;
        }
    }

    public static boolean A0H(C1795Yn c1795Yn, Uri uri, String str) throws ActivityNotFoundException {
        A08.get();
        return A0I(c1795Yn, uri, str, null);
    }

    public static boolean A0I(C1795Yn c1795Yn, Uri uri, String str, InterfaceC1442Ku interfaceC1442Ku) throws ActivityNotFoundException {
        if (interfaceC1442Ku == null || c1795Yn.A0D() == null) {
            return false;
        }
        new Bundle().putString(A06(98, 15, 64), str);
        uri.toString();
        c1795Yn.A0D();
        throw new NullPointerException(A06(172, 18, 104));
    }

    public static boolean A0J(C1795Yn c1795Yn, AdActivityIntent adActivityIntent) throws C1431Kh {
        return A0F(c1795Yn, A00(adActivityIntent), 0);
    }
}
