package ci;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.e0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f14854d = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ImmutableSet<String> f14855e = ImmutableSet.of("auto", DevicePublicKeyStringDef.NONE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImmutableSet<String> f14856f = ImmutableSet.of("dot", "sesame", "circle");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ImmutableSet<String> f14857g = ImmutableSet.of("filled", "open");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ImmutableSet<String> f14858h = ImmutableSet.of("after", "before", "outside");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14861c;

    public b(int i11, int i12, int i13) {
        this.f14859a = i11;
        this.f14860b = i12;
        this.f14861c = i13;
    }

    @Nullable
    public static b a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strE = com.google.common.base.a.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(strE, f14854d)));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:68:0x0100  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102  */
    /* JADX WARN: Code duplicated, block: B:71:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:73:0x0109  */
    public static b b(ImmutableSet<String> immutableSet) {
        byte b11;
        int i11;
        String str;
        int iHashCode;
        String str2 = (String) e0.f(Sets.e(f14858h, immutableSet), "outside");
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
        Sets.e eVarE = Sets.e(f14855e, immutableSet);
        if (!eVarE.isEmpty()) {
            String str3 = (String) eVarE.iterator().next();
            int iHashCode3 = str3.hashCode();
            if (iHashCode3 == 3005871) {
                str3.equals("auto");
            } else if (iHashCode3 == 3387192 && str3.equals(DevicePublicKeyStringDef.NONE)) {
                i13 = 0;
            }
            return new b(i13, 0, i11);
        }
        Sets.e eVarE2 = Sets.e(f14857g, immutableSet);
        Sets.e eVarE3 = Sets.e(f14856f, immutableSet);
        if (eVarE2.isEmpty() && eVarE3.isEmpty()) {
            return new b(-1, 0, i11);
        }
        String str4 = (String) e0.f(eVarE2, "filled");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1274499742) {
            int i14 = (iHashCode4 == 3417674 && str4.equals("open")) ? 2 : 1;
            str = (String) e0.f(eVarE3, "circle");
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
            return new b(i12, i14, i11);
        }
        str4.equals("filled");
        str = (String) e0.f(eVarE3, "circle");
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
        return new b(i12, i14, i11);
    }
}
