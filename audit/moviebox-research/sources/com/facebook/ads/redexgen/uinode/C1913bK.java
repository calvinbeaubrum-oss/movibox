package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1913bK implements InterfaceC09550k, InterfaceC09590p {
    public static byte[] A0C;
    public static String[] A0D = {"OTBhn", "woE0GsYsDC", "jJJsRhZ6eh", "RbmDZKGZyk", "MbYnCV2deeCvNEpfUSPgn7RvJuamywdV", "va4Mi1JJiq4w08mNkhVxy34L1bzftr4W", "QQZqW8pW387BdDH3gcXSwYVoWAeaIxNz", "E72k8"};
    public static final String A0E;
    public int A00;
    public AnonymousClass14 A01;
    public AnonymousClass15 A02;
    public AnonymousClass16 A03;
    public JO A04;
    public List<V2> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C1795Yn A0A;
    public final String A0B;

    static {
        A04();
        A0E = C1913bK.class.getSimpleName();
    }

    public C1913bK(C1795Yn c1795Yn) {
        this(c1795Yn, new AnonymousClass14());
    }

    public C1913bK(C1795Yn c1795Yn, AnonymousClass14 anonymousClass14) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = anonymousClass14;
        this.A0A = c1795Yn;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap map2 = new HashMap();
        String strA02 = A02(156, 4, 66);
        if (map.containsKey(strA02)) {
            map2.put(strA02, map.get(strA02));
        }
        String strA03 = A02(140, 8, 86);
        if (map.containsKey(strA03)) {
            map2.put(strA03, map.get(strA03));
        }
        return map2;
    }

    public static void A04() {
        A0C = new byte[]{124, 89, 92, 77, 73, 88, 79, Ascii.GS, 92, 81, 79, 88, 92, 89, 68, Ascii.GS, 81, 82, 92, 89, 88, 89, Ascii.GS, 89, 92, 73, 92, 93, 114, 119, 125, 117, 62, 118, Ascii.DEL, 110, 110, 123, 112, 123, 122, 62, 113, 112, 62, 114, 113, 125, 117, 109, 125, 108, 123, 123, 112, 62, Ascii.DEL, 122, 104, 71, 66, 72, 64, Ascii.VT, 71, 68, 76, 76, 78, 79, Ascii.VT, 9, 4, 4, Ascii.CR, Ascii.SUB, 60, 17, Ascii.CAN, Ascii.CR, 64, 66, 81, 71, 64, 77, 87, 54, 52, 39, 49, 60, 59, 49, 92, 75, 37, 42, 47, 55, 38, 49, 38, 39, Ascii.FS, 32, 47, 42, 32, 40, Ascii.FS, 39, 38, 47, 34, 58, Ascii.FS, 46, 48, 93, 71, 107, 87, 70, 81, 85, 64, 93, 66, 81, 107, 85, 71, 107, 87, 64, 85, 107, 66, 6, 79, 82, 93, 76, 79, 84, 83, 72, Ascii.ETB, Ascii.FF, Ascii.VT, 19, Ascii.ETB, 7, 43, 6, 94, 65, 77, 95};
    }

    private void A05(AnonymousClass14 anonymousClass14) {
        if (this.A06) {
            throw new IllegalStateException(A02(0, 27, 87));
        }
        this.A01 = anonymousClass14;
        List<AnonymousClass14> listA0f = anonymousClass14.A0f();
        if (listA0f != null && listA0f.size() > 0) {
            int size = listA0f.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                C1913bK c1913bK = new C1913bK(this.A0A);
                c1913bK.A05(listA0f.get(i11));
                arrayList.add(new V2(this.A0A, c1913bK, (C8T) null, this.A04));
            }
            this.A05 = arrayList;
        }
        this.A06 = true;
        this.A07 = A07();
    }

    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C1914bL(this, map2, A03(map)), this.A01.A07() * 1000);
        } catch (Exception unused) {
        }
    }

    private boolean A07() {
        if (((!this.A01.A0h() && !TextUtils.isEmpty(this.A01.A0W())) || (!TextUtils.isEmpty(this.A01.A0T()) && this.A01.A0h())) && (this.A01.A0G() != null || this.A01.A0h())) {
            JP jpA0F = this.A01.A0F();
            if (A0D[2].length() != 10) {
                throw new RuntimeException();
            }
            A0D[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            if (jpA0F != null || A7e() == AdPlacementType.NATIVE_BANNER) {
                return true;
            }
        }
        return false;
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int iA06 = this.A01.A06();
        if (iA06 < 0 || iA06 > 100) {
            return 0;
        }
        return iA06;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A08();
    }

    public final int A0D() {
        return this.A01.A09();
    }

    public final AnonymousClass14 A0E() {
        return this.A01;
    }

    public final AnonymousClass15 A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0a();
    }

    public final List<V2> A0H() {
        if (A0R()) {
            return this.A05;
        }
        return null;
    }

    public final void A0I() {
        if (this.A09) {
            return;
        }
        String strA0b = A0E().A0b();
        if (A0D[2].length() != 10) {
            throw new RuntimeException();
        }
        A0D[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
        if (strA0b != null) {
            this.A0A.A09().AE1(strA0b);
        }
        this.A09 = true;
    }

    public final void A0J() {
        Iterator<V2> it;
        List<V2> list = this.A05;
        if (list == null) {
            return;
        }
        boolean zIsEmpty = list.isEmpty();
        if (A0D[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        A0D[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
        if (zIsEmpty) {
            return;
        }
        List<V2> list2 = this.A05;
        if (A0D[2].length() != 10) {
            it = list2.iterator();
        } else {
            A0D[2] = "wGXHpE1nya";
            it = list2.iterator();
        }
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0D[2].length() != 10) {
                A0D[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                if (!zHasNext) {
                    return;
                }
            } else {
                A0D[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                if (!zHasNext) {
                    return;
                }
            }
            it.next().unregisterView();
        }
    }

    public final void A0K(AnonymousClass15 anonymousClass15) {
        this.A02 = anonymousClass15;
    }

    public final void A0L(C1795Yn c1795Yn, AnonymousClass15 anonymousClass15, J2 j11, C09911v c09911v, JO jo2) {
        this.A02 = anonymousClass15;
        this.A04 = jo2;
        JSONObject jSONObjectA03 = c09911v.A03();
        C8T c8tA01 = c09911v.A01();
        this.A00 = c8tA01 != null ? c8tA01.A06() : 200;
        A05(AnonymousClass17.A00(c1795Yn, jSONObjectA03, LJ.A02(jSONObjectA03, A02(94, 2, 85))));
        if (AbstractC09560l.A06(c1795Yn, this, j11)) {
            c1795Yn.A0E().A4K();
            anonymousClass15.ACQ(this, C1401Jb.A00(AdErrorType.NO_FILL));
            return;
        }
        if (anonymousClass15 != null) {
            anonymousClass15.ACN(this);
        }
        AnonymousClass16 anonymousClass16 = new AnonymousClass16(c1795Yn, this.A0B, this, anonymousClass15);
        this.A03 = anonymousClass16;
        anonymousClass16.A02();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0123  */
    /* JADX WARN: Code duplicated, block: B:45:0x014b  */
    public final void A0M(Map<String, String> map) {
        boolean z11;
        if (A0R()) {
            if (C1384Ih.A1d(this.A0A) && C1463Lp.A03(map)) {
                String str = A0E;
                if (A0D[4].charAt(15) != 'f') {
                    throw new RuntimeException();
                }
                A0D[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
                Log.e(str, A02(27, 31, 116));
                return;
            }
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.putAll(map);
            }
            if (this.A01.A0h()) {
                map2.put(A02(87, 7, 63), String.valueOf(A0E().A04()));
                map2.put(A02(80, 7, 73), String.valueOf(A0E().A03()));
            }
            map2.put(A02(70, 10, 2), AdPlacementType.NATIVE.name());
            map2.put(A02(148, 8, 8), this.A0B);
            if (this.A01.A0D() != null) {
                map2.put(A02(119, 21, 94), String.valueOf(this.A01.A0D().A0l()));
                map2.put(A02(96, 23, 41), String.valueOf(this.A01.A0D().A0H()));
            }
            C1795Yn c1795Yn = this.A0A;
            AbstractC09520h abstractC09520hA00 = C09530i.A00(c1795Yn, c1795Yn.A09(), this.A01.A0Y(), this.A01.A0B(), map2, null);
            EnumC09510g enumC09510gA0C = EnumC09510g.A08;
            if (abstractC09520hA00 != null) {
                enumC09510gA0C = abstractC09520hA00.A0C();
            }
            if ((abstractC09520hA00 instanceof C1307Fe) || (abstractC09520hA00 instanceof C1309Fg)) {
                boolean zA0e = AbstractC1462Lo.A0e(this.A0A, enumC09510gA0C, map2);
                String[] strArr = A0D;
                if (strArr[0].length() == strArr[7].length()) {
                    A0D[2] = "05GUJTBpuf";
                    if (zA0e) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (zA0e) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            if (z11 || enumC09510gA0C == EnumC09510g.A05) {
                return;
            }
            L4.A02(this.A0A, A02(58, 12, 65));
            AnonymousClass15 anonymousClass15 = this.A02;
            if (anonymousClass15 != null) {
                anonymousClass15.ACM(this);
            }
        }
    }

    public final void A0N(Map<String, String> map) {
        this.A0A.A09().A9W(this.A01.A0Y(), map);
    }

    public final void A0O(Map<String, String> map) {
        if (A0R() && !this.A08) {
            AnonymousClass15 anonymousClass15 = this.A02;
            if (anonymousClass15 != null) {
                anonymousClass15.ACO(this);
            }
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.putAll(map);
            }
            if (this.A01.A0h()) {
                map2.put(A02(87, 7, 63), String.valueOf(A0E().A04()));
                map2.put(A02(80, 7, 73), String.valueOf(A0E().A03()));
            }
            if (!TextUtils.isEmpty(A6T())) {
                if (!this.A01.A0h()) {
                    this.A0A.A0E().A2k();
                    C2O.A00(this.A01.A0Z());
                }
                this.A0A.A09().A9g(A6T(), map2);
            }
            if (A0T() || A0U()) {
                A06(map, map2);
            }
            this.A08 = true;
        }
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0B() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0g();
    }

    public final boolean A0T() {
        if (C1384Ih.A1B(this.A0A) && A0R()) {
            boolean zA0i = this.A01.A0i();
            if (A0D[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            A0D[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            if (zA0i) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0U() {
        if (C1384Ih.A1B(this.A0A) && A0R()) {
            boolean zA0j = this.A01.A0j();
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0D[2] = "qputmJyOXU";
            if (zA0j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final String A6T() {
        return this.A01.A0Y();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final Collection<String> A6n() {
        return A0E().A0e();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final EnumC09540j A7E() {
        return A0E().A0C();
    }

    public AdPlacementType A7e() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final boolean AGd() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final void onDestroy() {
        AnonymousClass16 anonymousClass16 = this.A03;
        if (anonymousClass16 != null) {
            anonymousClass16.A03();
        }
    }
}
