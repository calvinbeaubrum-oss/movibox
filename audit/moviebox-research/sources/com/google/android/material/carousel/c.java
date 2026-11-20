package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import li.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f36509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f36510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f36511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f36512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f36513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f36514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f36515g;

    public c(@NonNull b bVar, List<b> list, List<b> list2) {
        this.f36509a = bVar;
        this.f36510b = Collections.unmodifiableList(list);
        this.f36511c = Collections.unmodifiableList(list2);
        float f11 = list.get(list.size() - 1).c().f36501a - bVar.c().f36501a;
        this.f36514f = f11;
        float f12 = bVar.j().f36501a - list2.get(list2.size() - 1).j().f36501a;
        this.f36515g = f12;
        this.f36512d = m(f11, list, true);
        this.f36513e = m(f12, list2, false);
    }

    public static int b(b bVar, float f11) {
        for (int i11 = bVar.i(); i11 < bVar.g().size(); i11++) {
            if (f11 == bVar.g().get(i11).f36503c) {
                return i11;
            }
        }
        return bVar.g().size() - 1;
    }

    public static int c(b bVar) {
        for (int i11 = 0; i11 < bVar.g().size(); i11++) {
            if (!bVar.g().get(i11).f36505e) {
                return i11;
            }
        }
        return -1;
    }

    public static int d(b bVar, float f11) {
        for (int iB = bVar.b() - 1; iB >= 0; iB--) {
            if (f11 == bVar.g().get(iB).f36503c) {
                return iB;
            }
        }
        return 0;
    }

    public static int e(b bVar) {
        for (int size = bVar.g().size() - 1; size >= 0; size--) {
            if (!bVar.g().get(size).f36505e) {
                return size;
            }
        }
        return -1;
    }

    public static c f(li.b bVar, b bVar2, float f11, float f12, float f13) {
        return new c(bVar2, p(bVar, bVar2, f11, f12), n(bVar, bVar2, f11, f13));
    }

    public static float[] m(float f11, List<b> list, boolean z11) {
        int size = list.size();
        float[] fArr = new float[size];
        int i11 = 1;
        while (i11 < size) {
            int i12 = i11 - 1;
            b bVar = list.get(i12);
            b bVar2 = list.get(i11);
            fArr[i11] = i11 == size + (-1) ? 1.0f : fArr[i12] + ((z11 ? bVar2.c().f36501a - bVar.c().f36501a : bVar.j().f36501a - bVar2.j().f36501a) / f11);
            i11++;
        }
        return fArr;
    }

    public static List<b> n(li.b bVar, b bVar2, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int iE = e(bVar2);
        float fA = bVar.d() ? bVar.a() : bVar.b();
        if (r(bVar, bVar2) || iE == -1) {
            if (f12 > 0.0f) {
                arrayList.add(u(bVar2, f12, fA, false, f11));
            }
            return arrayList;
        }
        int i11 = iE - bVar2.i();
        float f13 = bVar2.c().f36502b - (bVar2.c().f36504d / 2.0f);
        if (i11 <= 0 && bVar2.h().f36506f > 0.0f) {
            arrayList.add(v(bVar2, f13 - bVar2.h().f36506f, fA));
            return arrayList;
        }
        float f14 = 0.0f;
        int i12 = 0;
        while (i12 < i11) {
            b bVar3 = (b) arrayList.get(arrayList.size() - 1);
            int i13 = iE - i12;
            float f15 = f14 + bVar2.g().get(i13).f36506f;
            int i14 = i13 + 1;
            int i15 = i12;
            b bVarT = t(bVar3, iE, i14 < bVar2.g().size() ? d(bVar3, bVar2.g().get(i14).f36503c) + 1 : 0, f13 - f15, bVar2.b() + i12 + 1, bVar2.i() + i12 + 1, fA);
            if (i15 == i11 - 1 && f12 > 0.0f) {
                bVarT = u(bVarT, f12, fA, false, f11);
            }
            arrayList.add(bVarT);
            i12 = i15 + 1;
            f14 = f15;
        }
        return arrayList;
    }

    public static float[] o(List<b> list, float f11, float[] fArr) {
        int size = list.size();
        float f12 = fArr[0];
        int i11 = 1;
        while (i11 < size) {
            float f13 = fArr[i11];
            if (f11 <= f13) {
                return new float[]{ii.b.b(0.0f, 1.0f, f12, f13, f11), i11 - 1, i11};
            }
            i11++;
            f12 = f13;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static List<b> p(li.b bVar, b bVar2, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int iC = c(bVar2);
        float fA = bVar.d() ? bVar.a() : bVar.b();
        int i11 = 1;
        if (q(bVar2) || iC == -1) {
            if (f12 > 0.0f) {
                arrayList.add(u(bVar2, f12, fA, true, f11));
            }
            return arrayList;
        }
        int iB = bVar2.b() - iC;
        float f13 = bVar2.c().f36502b - (bVar2.c().f36504d / 2.0f);
        if (iB <= 0 && bVar2.a().f36506f > 0.0f) {
            arrayList.add(v(bVar2, f13 + bVar2.a().f36506f, fA));
            return arrayList;
        }
        float f14 = 0.0f;
        int i12 = 0;
        while (i12 < iB) {
            b bVar3 = (b) arrayList.get(arrayList.size() - i11);
            int i13 = iC + i12;
            int size = bVar2.g().size() - i11;
            float f15 = f14 + bVar2.g().get(i13).f36506f;
            int i14 = i13 - i11;
            int iB2 = i14 >= 0 ? b(bVar3, bVar2.g().get(i14).f36503c) - i11 : size;
            int i15 = i12;
            b bVarT = t(bVar3, iC, iB2, f13 + f15, (bVar2.b() - i12) - 1, (bVar2.i() - i12) - 1, fA);
            if (i15 == iB - 1 && f12 > 0.0f) {
                bVarT = u(bVarT, f12, fA, true, f11);
            }
            arrayList.add(bVarT);
            i12 = i15 + 1;
            f14 = f15;
            i11 = 1;
        }
        return arrayList;
    }

    public static boolean q(b bVar) {
        return bVar.a().f36502b - (bVar.a().f36504d / 2.0f) >= 0.0f && bVar.a() == bVar.d();
    }

    public static boolean r(li.b bVar, b bVar2) {
        int iB = bVar.b();
        if (bVar.d()) {
            iB = bVar.a();
        }
        return bVar2.h().f36502b + (bVar2.h().f36504d / 2.0f) <= ((float) iB) && bVar2.h() == bVar2.k();
    }

    public static b s(List<b> list, float f11, float[] fArr) {
        float[] fArrO = o(list, f11, fArr);
        return b.m(list.get((int) fArrO[1]), list.get((int) fArrO[2]), fArrO[0]);
    }

    public static b t(b bVar, int i11, int i12, float f11, int i13, int i14, float f12) {
        ArrayList arrayList = new ArrayList(bVar.g());
        arrayList.add(i12, (b.c) arrayList.remove(i11));
        b.C0379b c0379b = new b.C0379b(bVar.f(), f12);
        int i15 = 0;
        while (i15 < arrayList.size()) {
            b.c cVar = (b.c) arrayList.get(i15);
            float f13 = cVar.f36504d;
            c0379b.e(f11 + (f13 / 2.0f), cVar.f36503c, f13, i15 >= i13 && i15 <= i14, cVar.f36505e, cVar.f36506f);
            f11 += cVar.f36504d;
            i15++;
        }
        return c0379b.i();
    }

    public static b u(b bVar, float f11, float f12, boolean z11, float f13) {
        ArrayList arrayList = new ArrayList(bVar.g());
        b.C0379b c0379b = new b.C0379b(bVar.f(), f12);
        float fL = f11 / bVar.l();
        float f14 = z11 ? f11 : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            b.c cVar = (b.c) arrayList.get(i11);
            if (cVar.f36505e) {
                c0379b.e(cVar.f36502b, cVar.f36503c, cVar.f36504d, false, true, cVar.f36506f);
            } else {
                boolean z12 = i11 >= bVar.b() && i11 <= bVar.i();
                float f15 = cVar.f36504d - fL;
                float fB = f.b(f15, bVar.f(), f13);
                float f16 = (f15 / 2.0f) + f14;
                float f17 = f16 - cVar.f36502b;
                c0379b.f(f16, fB, f15, z12, false, cVar.f36506f, z11 ? f17 : 0.0f, z11 ? 0.0f : f17);
                f14 += f15;
            }
            i11++;
        }
        return c0379b.i();
    }

    public static b v(b bVar, float f11, float f12) {
        return t(bVar, 0, 0, f11, bVar.b(), bVar.i(), f12);
    }

    public final b a(List<b> list, float f11, float[] fArr) {
        float[] fArrO = o(list, f11, fArr);
        return fArrO[0] >= 0.5f ? list.get((int) fArrO[2]) : list.get((int) fArrO[1]);
    }

    public b g() {
        return this.f36509a;
    }

    public b h() {
        List<b> list = this.f36511c;
        return list.get(list.size() - 1);
    }

    public Map<Integer, b> i(int i11, int i12, int i13, boolean z11) {
        float f11 = this.f36509a.f();
        HashMap map = new HashMap();
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i14 >= i11) {
                break;
            }
            int i16 = z11 ? (i11 - i14) - 1 : i14;
            if (i16 * f11 * (z11 ? -1 : 1) > i13 - this.f36515g || i14 >= i11 - this.f36511c.size()) {
                Integer numValueOf = Integer.valueOf(i16);
                List<b> list = this.f36511c;
                map.put(numValueOf, list.get(g3.a.b(i15, 0, list.size() - 1)));
                i15++;
            }
            i14++;
        }
        int i17 = 0;
        for (int i18 = i11 - 1; i18 >= 0; i18--) {
            int i19 = z11 ? (i11 - i18) - 1 : i18;
            if (i19 * f11 * (z11 ? -1 : 1) < i12 + this.f36514f || i18 < this.f36510b.size()) {
                Integer numValueOf2 = Integer.valueOf(i19);
                List<b> list2 = this.f36510b;
                map.put(numValueOf2, list2.get(g3.a.b(i17, 0, list2.size() - 1)));
                i17++;
            }
        }
        return map;
    }

    public b j(float f11, float f12, float f13) {
        return k(f11, f12, f13, false);
    }

    public b k(float f11, float f12, float f13, boolean z11) {
        float fB;
        List<b> list;
        float[] fArr;
        float f14 = this.f36514f + f12;
        float f15 = f13 - this.f36515g;
        float f16 = l().a().f36507g;
        float f17 = h().h().f36508h;
        if (this.f36514f == f16) {
            f14 += f16;
        }
        if (this.f36515g == f17) {
            f15 -= f17;
        }
        if (f11 < f14) {
            fB = ii.b.b(1.0f, 0.0f, f12, f14, f11);
            list = this.f36510b;
            fArr = this.f36512d;
        } else {
            if (f11 <= f15) {
                return this.f36509a;
            }
            fB = ii.b.b(0.0f, 1.0f, f15, f13, f11);
            list = this.f36511c;
            fArr = this.f36513e;
        }
        return z11 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    public b l() {
        List<b> list = this.f36510b;
        return list.get(list.size() - 1);
    }
}
