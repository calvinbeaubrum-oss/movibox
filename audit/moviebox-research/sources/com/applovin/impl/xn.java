package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class xn {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f24364d = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ib f24365e = ib.a("auto", DevicePublicKeyStringDef.NONE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ib f24366f = ib.a("dot", "sesame", "circle");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ib f24367g = ib.a("filled", "open");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ib f24368h = ib.a("after", "before", "outside");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24371c;

    private xn(int i11, int i12, int i13) {
        this.f24369a = i11;
        this.f24370b = i12;
        this.f24371c = i13;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:55:0x00da  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:69:0x0100  */
    /* JADX WARN: Code duplicated, block: B:71:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0105  */
    /* JADX WARN: Code duplicated, block: B:73:0x0107  */
    private static xn a(ib ibVar) {
        byte b11;
        int i11;
        String str;
        int iHashCode;
        String str2 = (String) wb.a(rj.a((Set) f24368h, (Set) ibVar), "outside");
        int iHashCode2 = str2.hashCode();
        int i12 = 2;
        byte b12 = 0;
        int i13 = -1;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str2.equals("after")) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
            } else if (str2.equals("outside")) {
                b11 = 1;
            } else {
                b11 = -1;
            }
        } else if (str2.equals("before")) {
            b11 = 2;
        } else {
            b11 = -1;
        }
        if (b11 != 0) {
            i11 = b11 != 1 ? 1 : -2;
        } else {
            i11 = 2;
        }
        rj.c cVarA = rj.a((Set) f24365e, (Set) ibVar);
        if (!cVarA.isEmpty()) {
            String str3 = (String) cVarA.iterator().next();
            int iHashCode3 = str3.hashCode();
            if (iHashCode3 == 3005871) {
                str3.equals("auto");
            } else if (iHashCode3 == 3387192 && str3.equals(DevicePublicKeyStringDef.NONE)) {
                i13 = 0;
            }
            return new xn(i13, 0, i11);
        }
        rj.c cVarA2 = rj.a((Set) f24367g, (Set) ibVar);
        rj.c cVarA3 = rj.a((Set) f24366f, (Set) ibVar);
        if (cVarA2.isEmpty() && cVarA3.isEmpty()) {
            return new xn(-1, 0, i11);
        }
        String str4 = (String) wb.a(cVarA2, "filled");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1274499742) {
            int i14 = (iHashCode4 == 3417674 && str4.equals("open")) ? 2 : 1;
            str = (String) wb.a(cVarA3, "circle");
            iHashCode = str.hashCode();
            if (iHashCode != -1360216880) {
                if (iHashCode != -905816648) {
                    if (iHashCode == 99657 || !str.equals("dot")) {
                        b12 = -1;
                    }
                } else if (str.equals("sesame")) {
                    b12 = 1;
                } else {
                    b12 = -1;
                }
            } else if (str.equals("circle")) {
                b12 = 2;
            } else {
                b12 = -1;
            }
            if (b12 != 0) {
                if (b12 != 1) {
                    i12 = 1;
                } else {
                    i12 = 3;
                }
            }
            return new xn(i12, i14, i11);
        }
        str4.equals("filled");
        str = (String) wb.a(cVarA3, "circle");
        iHashCode = str.hashCode();
        if (iHashCode != -1360216880) {
            if (iHashCode != -905816648) {
                if (iHashCode == 99657) {
                    b12 = -1;
                } else {
                    b12 = -1;
                }
            } else if (str.equals("sesame")) {
                b12 = 1;
            } else {
                b12 = -1;
            }
        } else if (str.equals("circle")) {
            b12 = 2;
        } else {
            b12 = -1;
        }
        if (b12 != 0) {
            if (b12 != 1) {
                i12 = 1;
            } else {
                i12 = 3;
            }
        }
        return new xn(i12, i14, i11);
    }

    public static xn a(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return a(ib.a((Object[]) TextUtils.split(lowerCase, f24364d)));
    }
}
