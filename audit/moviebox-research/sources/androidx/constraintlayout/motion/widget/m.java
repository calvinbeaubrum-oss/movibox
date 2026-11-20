package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    public HashMap<String, x2.f> B;
    public HashMap<String, x2.d> C;
    public HashMap<String, x2.c> D;
    public k[] E;
    public int F;
    public int G;
    public View H;
    public int I;
    public float J;
    public Interpolator K;
    public boolean L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6994c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6996e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.b[] f7002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.b f7003l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f7007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f7008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f7009r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f7010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double[] f7011t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String[] f7012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f7013v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f6992a = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6995d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6997f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f6998g = new o();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f6999h = new o();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f7000i = new l();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f7001j = new l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7004m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7005n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f7006o = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7014w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float[] f7015x = new float[4];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<o> f7016y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f7017z = new float[1];
    public ArrayList<d> A = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7018a;

        public a(androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7018a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7018a.a(f11);
        }
    }

    public m(View view) {
        int i11 = d.f6866f;
        this.F = i11;
        this.G = i11;
        this.H = null;
        this.I = i11;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    public static Interpolator p(Context context, int i11, String str, int i12) {
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, i12);
        }
        if (i11 == -1) {
            return new a(androidx.constraintlayout.core.motion.utils.c.c(str));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    public void A(Rect rect, Rect rect2, int i11, int i12, int i13) {
        if (i11 == 1) {
            int i14 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i13 - ((i14 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 == 2) {
            int i15 = rect.left + rect.right;
            rect2.left = i12 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i15 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 == 3) {
            int i16 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i16 / 2);
            rect2.top = i13 - ((i16 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 != 4) {
            return;
        }
        int i17 = rect.left + rect.right;
        rect2.left = i12 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i17 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    public void B(View view) {
        o oVar = this.f6998g;
        oVar.f7022c = 0.0f;
        oVar.f7023d = 0.0f;
        this.L = true;
        oVar.r(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f6999h.r(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f7000i.l(view);
        this.f7001j.l(view);
    }

    public void C(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        int i13 = bVar.f7373d;
        if (i13 != 0) {
            A(rect, this.f6992a, i13, i11, i12);
            rect = this.f6992a;
        }
        o oVar = this.f6999h;
        oVar.f7022c = 1.0f;
        oVar.f7023d = 1.0f;
        y(oVar);
        this.f6999h.r(rect.left, rect.top, rect.width(), rect.height());
        this.f6999h.a(bVar.A(this.f6994c));
        this.f7001j.k(rect, bVar, i13, this.f6994c);
    }

    public void D(int i11) {
        this.F = i11;
    }

    public void E(View view) {
        o oVar = this.f6998g;
        oVar.f7022c = 0.0f;
        oVar.f7023d = 0.0f;
        oVar.r(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f7000i.l(view);
    }

    public void F(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        int i13 = bVar.f7373d;
        if (i13 != 0) {
            A(rect, this.f6992a, i13, i11, i12);
        }
        o oVar = this.f6998g;
        oVar.f7022c = 0.0f;
        oVar.f7023d = 0.0f;
        y(oVar);
        this.f6998g.r(rect.left, rect.top, rect.width(), rect.height());
        androidx.constraintlayout.widget.b.a aVarA = bVar.A(this.f6994c);
        this.f6998g.a(aVarA);
        this.f7004m = aVarA.f7380d.f7448g;
        this.f7000i.k(rect, bVar, i13, this.f6994c);
        this.G = aVarA.f7382f.f7470i;
        androidx.constraintlayout.widget.b.c cVar = aVarA.f7380d;
        this.I = cVar.f7452k;
        this.J = cVar.f7451j;
        Context context = this.f6993b.getContext();
        androidx.constraintlayout.widget.b.c cVar2 = aVarA.f7380d;
        this.K = p(context, cVar2.f7454m, cVar2.f7453l, cVar2.f7455n);
    }

    public void G(x2.e eVar, View view, int i11, int i12, int i13) {
        o oVar = this.f6998g;
        oVar.f7022c = 0.0f;
        oVar.f7023d = 0.0f;
        Rect rect = new Rect();
        if (i11 == 1) {
            int i14 = eVar.f79851b + eVar.f79853d;
            rect.left = ((eVar.f79852c + eVar.f79854e) - eVar.c()) / 2;
            rect.top = i12 - ((i14 + eVar.b()) / 2);
            rect.right = rect.left + eVar.c();
            rect.bottom = rect.top + eVar.b();
        } else if (i11 == 2) {
            int i15 = eVar.f79851b + eVar.f79853d;
            rect.left = i13 - (((eVar.f79852c + eVar.f79854e) + eVar.c()) / 2);
            rect.top = (i15 - eVar.b()) / 2;
            rect.right = rect.left + eVar.c();
            rect.bottom = rect.top + eVar.b();
        }
        this.f6998g.r(rect.left, rect.top, rect.width(), rect.height());
        this.f7000i.j(rect, view, i11, eVar.f79850a);
    }

    public void H(View view) {
        this.f6993b = view;
        this.f6994c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f6996e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void I(int i11, int i12, float f11, long j11) {
        ArrayList arrayList;
        String[] strArr;
        ConstraintAttribute constraintAttribute;
        x2.f fVarH;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        x2.d dVarG;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i13 = this.F;
        if (i13 != d.f6866f) {
            this.f6998g.f7030l = i13;
        }
        this.f7000i.h(this.f7001j, hashSet2);
        ArrayList<d> arrayList2 = this.A;
        if (arrayList2 != null) {
            arrayList = null;
            for (d dVar : arrayList2) {
                if (dVar instanceof h) {
                    h hVar = (h) dVar;
                    w(new o(i11, i12, hVar, this.f6998g, this.f6999h));
                    int i14 = hVar.f6926g;
                    if (i14 != d.f6866f) {
                        this.f6997f = i14;
                    }
                } else if (dVar instanceof f) {
                    dVar.d(hashSet3);
                } else if (dVar instanceof j) {
                    dVar.d(hashSet);
                } else if (dVar instanceof k) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((k) dVar);
                } else {
                    dVar.h(map);
                    dVar.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.E = (k[]) arrayList.toArray(new k[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    for (d dVar2 : this.A) {
                        HashMap<String, ConstraintAttribute> map2 = dVar2.f6871e;
                        if (map2 != null && (constraintAttribute3 = map2.get(str2)) != null) {
                            sparseArray.append(dVar2.f6867a, constraintAttribute3);
                        }
                    }
                    dVarG = x2.d.f(str, sparseArray);
                } else {
                    dVarG = x2.d.g(str);
                }
                if (dVarG != null) {
                    dVarG.d(str);
                    this.C.put(str, dVarG);
                }
            }
            ArrayList<d> arrayList3 = this.A;
            if (arrayList3 != null) {
                for (d dVar3 : arrayList3) {
                    if (dVar3 instanceof e) {
                        dVar3.a(this.C);
                    }
                }
            }
            this.f7000i.a(this.C, 0);
            this.f7001j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                x2.d dVar4 = this.C.get(str3);
                if (dVar4 != null) {
                    dVar4.e(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        for (d dVar5 : this.A) {
                            HashMap<String, ConstraintAttribute> map3 = dVar5.f6871e;
                            if (map3 != null && (constraintAttribute2 = map3.get(str5)) != null) {
                                sparseArray2.append(dVar5.f6867a, constraintAttribute2);
                            }
                        }
                        fVarH = x2.f.g(str4, sparseArray2);
                    } else {
                        fVarH = x2.f.h(str4, j11);
                    }
                    if (fVarH != null) {
                        fVarH.d(str4);
                        this.B.put(str4, fVarH);
                    }
                }
            }
            ArrayList<d> arrayList4 = this.A;
            if (arrayList4 != null) {
                for (d dVar6 : arrayList4) {
                    if (dVar6 instanceof j) {
                        ((j) dVar6).U(this.B);
                    }
                }
            }
            for (String str6 : this.B.keySet()) {
                this.B.get(str6).e(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int size = this.f7016y.size();
        int i15 = size + 2;
        o[] oVarArr = new o[i15];
        oVarArr[0] = this.f6998g;
        oVarArr[size + 1] = this.f6999h;
        if (this.f7016y.size() > 0 && this.f6997f == -1) {
            this.f6997f = 0;
        }
        Iterator<o> it = this.f7016y.iterator();
        int i16 = 1;
        while (it.hasNext()) {
            oVarArr[i16] = it.next();
            i16++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f6999h.f7034p.keySet()) {
            if (this.f6998g.f7034p.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f7012u = strArr2;
        this.f7013v = new int[strArr2.length];
        int i17 = 0;
        while (true) {
            strArr = this.f7012u;
            if (i17 >= strArr.length) {
                break;
            }
            String str8 = strArr[i17];
            this.f7013v[i17] = 0;
            for (int i18 = 0; i18 < i15; i18++) {
                if (oVarArr[i18].f7034p.containsKey(str8) && (constraintAttribute = oVarArr[i18].f7034p.get(str8)) != null) {
                    int[] iArr = this.f7013v;
                    iArr[i17] = iArr[i17] + constraintAttribute.h();
                    break;
                }
            }
            i17++;
        }
        boolean z11 = oVarArr[0].f7030l != d.f6866f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i19 = 1; i19 < i15; i19++) {
            oVarArr[i19].d(oVarArr[i19 - 1], zArr, this.f7012u, z11);
        }
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                i21++;
            }
        }
        this.f7009r = new int[i21];
        int iMax = Math.max(2, i21);
        this.f7010s = new double[iMax];
        this.f7011t = new double[iMax];
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                this.f7009r[i23] = i24;
                i23++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, this.f7009r.length);
        double[] dArr2 = new double[i15];
        for (int i25 = 0; i25 < i15; i25++) {
            oVarArr[i25].e(dArr[i25], this.f7009r);
            dArr2[i25] = oVarArr[i25].f7022c;
        }
        int i26 = 0;
        while (true) {
            int[] iArr2 = this.f7009r;
            if (i26 >= iArr2.length) {
                break;
            }
            if (iArr2[i26] < o.f7019u.length) {
                String str9 = o.f7019u[this.f7009r[i26]] + " [";
                for (int i27 = 0; i27 < i15; i27++) {
                    str9 = str9 + dArr[i27][i26];
                }
            }
            i26++;
        }
        this.f7002k = new androidx.constraintlayout.core.motion.utils.b[this.f7012u.length + 1];
        int i28 = 0;
        while (true) {
            String[] strArr3 = this.f7012u;
            if (i28 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i28];
            int i29 = 0;
            double[] dArr3 = null;
            int i31 = 0;
            double[][] dArr4 = null;
            while (i29 < i15) {
                if (oVarArr[i29].m(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i15];
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, oVarArr[i29].k(str10));
                    }
                    o oVar = oVarArr[i29];
                    dArr3[i31] = oVar.f7022c;
                    oVar.j(str10, dArr4[i31], 0);
                    i31++;
                }
                i29++;
                dArr = dArr;
            }
            i28++;
            this.f7002k[i28] = androidx.constraintlayout.core.motion.utils.b.a(this.f6997f, Arrays.copyOf(dArr3, i31), (double[][]) Arrays.copyOf(dArr4, i31));
            dArr = dArr;
        }
        this.f7002k[0] = androidx.constraintlayout.core.motion.utils.b.a(this.f6997f, dArr2, dArr);
        if (oVarArr[0].f7030l != d.f6866f) {
            int[] iArr3 = new int[i15];
            double[] dArr5 = new double[i15];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, 2);
            for (int i32 = 0; i32 < i15; i32++) {
                o oVar2 = oVarArr[i32];
                iArr3[i32] = oVar2.f7030l;
                dArr5[i32] = oVar2.f7022c;
                double[] dArr7 = dArr6[i32];
                dArr7[0] = oVar2.f7024f;
                dArr7[1] = oVar2.f7025g;
            }
            this.f7003l = androidx.constraintlayout.core.motion.utils.b.b(iArr3, dArr5, dArr6);
        }
        this.D = new HashMap<>();
        if (this.A != null) {
            float fS = Float.NaN;
            for (String str11 : hashSet3) {
                x2.c cVarI = x2.c.i(str11);
                if (cVarI != null) {
                    if (cVarI.h() && Float.isNaN(fS)) {
                        fS = s();
                    }
                    cVarI.f(str11);
                    this.D.put(str11, cVarI);
                }
            }
            for (d dVar7 : this.A) {
                if (dVar7 instanceof f) {
                    ((f) dVar7).Y(this.D);
                }
            }
            Iterator<x2.c> it2 = this.D.values().iterator();
            while (it2.hasNext()) {
                it2.next().g(fS);
            }
        }
    }

    public void J(m mVar) {
        this.f6998g.u(mVar, mVar.f6998g);
        this.f6999h.u(mVar, mVar.f6999h);
    }

    public void a(d dVar) {
        this.A.add(dVar);
    }

    public void b(ArrayList<d> arrayList) {
        this.A.addAll(arrayList);
    }

    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f7002k[0].h();
        if (iArr != null) {
            Iterator<o> it = this.f7016y.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                iArr[i11] = it.next().f7035q;
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < dArrH.length; i13++) {
            this.f7002k[0].d(dArrH[i13], this.f7010s);
            this.f6998g.h(dArrH[i13], this.f7009r, this.f7010s, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void d(float[] fArr, int i11) {
        double dA;
        float f11 = 1.0f;
        float f12 = 1.0f / (i11 - 1);
        HashMap<String, x2.d> map = this.C;
        x2.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, x2.d> map2 = this.C;
        x2.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, x2.c> map3 = this.D;
        x2.c cVar = map3 == null ? null : map3.get("translationX");
        HashMap<String, x2.c> map4 = this.D;
        x2.c cVar2 = map4 != null ? map4.get("translationY") : null;
        int i12 = 0;
        while (i12 < i11) {
            float fMin = i12 * f12;
            float f13 = this.f7006o;
            float f14 = 0.0f;
            if (f13 != f11) {
                float f15 = this.f7005n;
                if (fMin < f15) {
                    fMin = 0.0f;
                }
                if (fMin > f15 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f15) * f13, f11);
                }
            }
            float f16 = fMin;
            double d11 = f16;
            androidx.constraintlayout.core.motion.utils.c cVar3 = this.f6998g.f7020a;
            float f17 = Float.NaN;
            for (o oVar : this.f7016y) {
                androidx.constraintlayout.core.motion.utils.c cVar4 = oVar.f7020a;
                double d12 = d11;
                if (cVar4 != null) {
                    float f18 = oVar.f7022c;
                    if (f18 < f16) {
                        f14 = f18;
                        cVar3 = cVar4;
                    } else if (Float.isNaN(f17)) {
                        f17 = oVar.f7022c;
                    }
                }
                d11 = d12;
            }
            double d13 = d11;
            if (cVar3 != null) {
                if (Float.isNaN(f17)) {
                    f17 = 1.0f;
                }
                float f19 = f17 - f14;
                dA = (((float) cVar3.a((f16 - f14) / f19)) * f19) + f14;
            } else {
                dA = d13;
            }
            this.f7002k[0].d(dA, this.f7010s);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f7003l;
            if (bVar != null) {
                double[] dArr = this.f7010s;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            int i13 = i12 * 2;
            int i14 = i12;
            this.f6998g.h(dA, this.f7009r, this.f7010s, fArr, i13);
            if (cVar != null) {
                fArr[i13] = fArr[i13] + cVar.a(f16);
            } else if (dVar != null) {
                fArr[i13] = fArr[i13] + dVar.a(f16);
            }
            if (cVar2 != null) {
                int i15 = i13 + 1;
                fArr[i15] = fArr[i15] + cVar2.a(f16);
            } else if (dVar2 != null) {
                int i16 = i13 + 1;
                fArr[i16] = fArr[i16] + dVar2.a(f16);
            }
            i12 = i14 + 1;
            f11 = 1.0f;
        }
    }

    public void e(float f11, float[] fArr, int i11) {
        this.f7002k[0].d(g(f11, null), this.f7010s);
        this.f6998g.l(this.f7009r, this.f7010s, fArr, i11);
    }

    public void f(boolean z11) {
        if (!"button".equals(androidx.constraintlayout.motion.widget.a.d(this.f6993b)) || this.E == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            k[] kVarArr = this.E;
            if (i11 >= kVarArr.length) {
                return;
            }
            kVarArr[i11].y(z11 ? -100.0f : 100.0f, this.f6993b);
            i11++;
        }
    }

    public final float g(float f11, float[] fArr) {
        float f12 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f7006o;
            if (f13 != 1.0d) {
                float f14 = this.f7005n;
                if (f11 < f14) {
                    f11 = 0.0f;
                }
                if (f11 > f14 && f11 < 1.0d) {
                    f11 = Math.min((f11 - f14) * f13, 1.0f);
                }
            }
        }
        androidx.constraintlayout.core.motion.utils.c cVar = this.f6998g.f7020a;
        float f15 = Float.NaN;
        for (o oVar : this.f7016y) {
            androidx.constraintlayout.core.motion.utils.c cVar2 = oVar.f7020a;
            if (cVar2 != null) {
                float f16 = oVar.f7022c;
                if (f16 < f11) {
                    cVar = cVar2;
                    f12 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = oVar.f7022c;
                }
            }
        }
        if (cVar != null) {
            float f17 = (Float.isNaN(f15) ? 1.0f : f15) - f12;
            double d11 = (f11 - f12) / f17;
            f11 = (((float) cVar.a(d11)) * f17) + f12;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d11);
            }
        }
        return f11;
    }

    public int h() {
        return this.f6998g.f7031m;
    }

    public void i(double d11, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f7002k[0].d(d11, dArr);
        this.f7002k[0].g(d11, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f6998g.i(d11, this.f7009r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f7007p;
    }

    public float k() {
        return this.f7008q;
    }

    public void l(float f11, float f12, float f13, float[] fArr) {
        double[] dArr;
        float fG = g(f11, this.f7017z);
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f7002k;
        int i11 = 0;
        if (bVarArr == null) {
            o oVar = this.f6999h;
            float f14 = oVar.f7024f;
            o oVar2 = this.f6998g;
            float f15 = f14 - oVar2.f7024f;
            float f16 = oVar.f7025g - oVar2.f7025g;
            float f17 = (oVar.f7026h - oVar2.f7026h) + f15;
            float f18 = (oVar.f7027i - oVar2.f7027i) + f16;
            fArr[0] = (f15 * (1.0f - f12)) + (f17 * f12);
            fArr[1] = (f16 * (1.0f - f13)) + (f18 * f13);
            return;
        }
        double d11 = fG;
        bVarArr[0].g(d11, this.f7011t);
        this.f7002k[0].d(d11, this.f7010s);
        float f19 = this.f7017z[0];
        while (true) {
            dArr = this.f7011t;
            if (i11 >= dArr.length) {
                break;
            }
            dArr[i11] = dArr[i11] * ((double) f19);
            i11++;
        }
        androidx.constraintlayout.core.motion.utils.b bVar = this.f7003l;
        if (bVar == null) {
            this.f6998g.s(f12, f13, fArr, this.f7009r, dArr, this.f7010s);
            return;
        }
        double[] dArr2 = this.f7010s;
        if (dArr2.length > 0) {
            bVar.d(d11, dArr2);
            this.f7003l.g(d11, this.f7011t);
            this.f6998g.s(f12, f13, fArr, this.f7009r, this.f7011t, this.f7010s);
        }
    }

    public int m() {
        int iMax = this.f6998g.f7021b;
        Iterator<o> it = this.f7016y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f7021b);
        }
        return Math.max(iMax, this.f6999h.f7021b);
    }

    public float n() {
        return this.f6999h.f7024f;
    }

    public float o() {
        return this.f6999h.f7025g;
    }

    public o q(int i11) {
        return this.f7016y.get(i11);
    }

    public void r(float f11, int i11, int i12, float f12, float f13, float[] fArr) {
        float fG = g(f11, this.f7017z);
        HashMap<String, x2.d> map = this.C;
        x2.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, x2.d> map2 = this.C;
        x2.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, x2.d> map3 = this.C;
        x2.d dVar3 = map3 == null ? null : map3.get("rotation");
        HashMap<String, x2.d> map4 = this.C;
        x2.d dVar4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, x2.d> map5 = this.C;
        x2.d dVar5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, x2.c> map6 = this.D;
        x2.c cVar = map6 == null ? null : map6.get("translationX");
        HashMap<String, x2.c> map7 = this.D;
        x2.c cVar2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, x2.c> map8 = this.D;
        x2.c cVar3 = map8 == null ? null : map8.get("rotation");
        HashMap<String, x2.c> map9 = this.D;
        x2.c cVar4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, x2.c> map10 = this.D;
        x2.c cVar5 = map10 != null ? map10.get("scaleY") : null;
        androidx.constraintlayout.core.motion.utils.o oVar = new androidx.constraintlayout.core.motion.utils.o();
        oVar.b();
        oVar.d(dVar3, fG);
        oVar.h(dVar, dVar2, fG);
        oVar.f(dVar4, dVar5, fG);
        oVar.c(cVar3, fG);
        oVar.g(cVar, cVar2, fG);
        oVar.e(cVar4, cVar5, fG);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f7003l;
        if (bVar != null) {
            double[] dArr = this.f7010s;
            if (dArr.length > 0) {
                double d11 = fG;
                bVar.d(d11, dArr);
                this.f7003l.g(d11, this.f7011t);
                this.f6998g.s(f12, f13, fArr, this.f7009r, this.f7011t, this.f7010s);
            }
            oVar.a(f12, f13, i11, i12, fArr);
            return;
        }
        int i13 = 0;
        if (this.f7002k == null) {
            o oVar2 = this.f6999h;
            float f14 = oVar2.f7024f;
            o oVar3 = this.f6998g;
            float f15 = f14 - oVar3.f7024f;
            x2.c cVar6 = cVar5;
            float f16 = oVar2.f7025g - oVar3.f7025g;
            x2.c cVar7 = cVar4;
            float f17 = (oVar2.f7026h - oVar3.f7026h) + f15;
            float f18 = (oVar2.f7027i - oVar3.f7027i) + f16;
            fArr[0] = (f15 * (1.0f - f12)) + (f17 * f12);
            fArr[1] = (f16 * (1.0f - f13)) + (f18 * f13);
            oVar.b();
            oVar.d(dVar3, fG);
            oVar.h(dVar, dVar2, fG);
            oVar.f(dVar4, dVar5, fG);
            oVar.c(cVar3, fG);
            oVar.g(cVar, cVar2, fG);
            oVar.e(cVar7, cVar6, fG);
            oVar.a(f12, f13, i11, i12, fArr);
            return;
        }
        double dG = g(fG, this.f7017z);
        this.f7002k[0].g(dG, this.f7011t);
        this.f7002k[0].d(dG, this.f7010s);
        float f19 = this.f7017z[0];
        while (true) {
            double[] dArr2 = this.f7011t;
            if (i13 >= dArr2.length) {
                this.f6998g.s(f12, f13, fArr, this.f7009r, dArr2, this.f7010s);
                oVar.a(f12, f13, i11, i12, fArr);
                return;
            } else {
                dArr2[i13] = dArr2[i13] * ((double) f19);
                i13++;
            }
        }
    }

    public final float s() {
        char c11;
        float fHypot;
        float[] fArr = new float[2];
        float f11 = 1.0f / 99;
        double d11 = 0.0d;
        double d12 = 0.0d;
        float f12 = 0.0f;
        int i11 = 0;
        while (i11 < 100) {
            float f13 = i11 * f11;
            double dA = f13;
            androidx.constraintlayout.core.motion.utils.c cVar = this.f6998g.f7020a;
            float f14 = Float.NaN;
            float f15 = 0.0f;
            for (o oVar : this.f7016y) {
                androidx.constraintlayout.core.motion.utils.c cVar2 = oVar.f7020a;
                if (cVar2 != null) {
                    float f16 = oVar.f7022c;
                    if (f16 < f13) {
                        cVar = cVar2;
                        f15 = f16;
                    } else if (Float.isNaN(f14)) {
                        f14 = oVar.f7022c;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                float f17 = f14 - f15;
                dA = (((float) cVar.a((f13 - f15) / f17)) * f17) + f15;
            }
            this.f7002k[0].d(dA, this.f7010s);
            float f18 = f12;
            int i12 = i11;
            this.f6998g.h(dA, this.f7009r, this.f7010s, fArr, 0);
            if (i12 > 0) {
                c11 = 0;
                fHypot = (float) (((double) f18) + Math.hypot(d12 - ((double) fArr[1]), d11 - ((double) fArr[0])));
            } else {
                c11 = 0;
                fHypot = f18;
            }
            d11 = fArr[c11];
            i11 = i12 + 1;
            f12 = fHypot;
            d12 = fArr[1];
        }
        return f12;
    }

    public float t() {
        return this.f6998g.f7024f;
    }

    public String toString() {
        return " start: x: " + this.f6998g.f7024f + " y: " + this.f6998g.f7025g + " end: x: " + this.f6999h.f7024f + " y: " + this.f6999h.f7025g;
    }

    public float u() {
        return this.f6998g.f7025g;
    }

    public View v() {
        return this.f6993b;
    }

    public final void w(o oVar) {
        int iBinarySearch = Collections.binarySearch(this.f7016y, oVar);
        if (iBinarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + oVar.f7023d + "\" outside of range");
        }
        this.f7016y.add((-iBinarySearch) - 1, oVar);
    }

    public boolean x(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
        x2.f.d dVar2;
        boolean zJ;
        char c11;
        float fG = g(f11, null);
        int i11 = this.I;
        if (i11 != d.f6866f) {
            float f12 = 1.0f / i11;
            float fFloor = ((float) Math.floor(fG / f12)) * f12;
            float f13 = (fG % f12) / f12;
            if (!Float.isNaN(this.J)) {
                f13 = (f13 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            fG = ((interpolator != null ? interpolator.getInterpolation(f13) : ((double) f13) > 0.5d ? 1.0f : 0.0f) * f12) + fFloor;
        }
        float f14 = fG;
        HashMap<String, x2.d> map = this.C;
        if (map != null) {
            Iterator<x2.d> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().h(view, f14);
            }
        }
        HashMap<String, x2.f> map2 = this.B;
        if (map2 != null) {
            x2.f.d dVar3 = null;
            boolean zI = false;
            for (x2.f fVar : map2.values()) {
                if (fVar instanceof x2.f.d) {
                    dVar3 = (x2.f.d) fVar;
                } else {
                    zI |= fVar.i(view, f14, j11, dVar);
                }
            }
            zJ = zI;
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            zJ = false;
        }
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f7002k;
        if (bVarArr != null) {
            double d11 = f14;
            bVarArr[0].d(d11, this.f7010s);
            this.f7002k[0].g(d11, this.f7011t);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f7003l;
            if (bVar != null) {
                double[] dArr = this.f7010s;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                    this.f7003l.g(d11, this.f7011t);
                }
            }
            if (!this.L) {
                this.f6998g.t(f14, view, this.f7009r, this.f7010s, this.f7011t, null, this.f6995d);
                this.f6995d = false;
            }
            if (this.G != d.f6866f) {
                if (this.H == null) {
                    this.H = ((View) view.getParent()).findViewById(this.G);
                }
                View view2 = this.H;
                if (view2 != null) {
                    float top = (view2.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        float left2 = left - view.getLeft();
                        float top2 = top - view.getTop();
                        view.setPivotX(left2);
                        view.setPivotY(top2);
                    }
                }
            }
            HashMap<String, x2.d> map3 = this.C;
            if (map3 != null) {
                for (x2.d dVar4 : map3.values()) {
                    if (dVar4 instanceof x2.d.C0898d) {
                        double[] dArr2 = this.f7011t;
                        if (dArr2.length > 1) {
                            ((x2.d.C0898d) dVar4).i(view, f14, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (dVar2 != null) {
                double[] dArr3 = this.f7011t;
                c11 = 1;
                zJ |= dVar2.j(view, dVar, f14, j11, dArr3[0], dArr3[1]);
            } else {
                c11 = 1;
            }
            int i12 = 1;
            while (true) {
                androidx.constraintlayout.core.motion.utils.b[] bVarArr2 = this.f7002k;
                if (i12 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i12].e(d11, this.f7015x);
                x2.a.b(this.f6998g.f7034p.get(this.f7012u[i12 - 1]), view, this.f7015x);
                i12++;
            }
            l lVar = this.f7000i;
            if (lVar.f6968b == 0) {
                if (f14 <= 0.0f) {
                    view.setVisibility(lVar.f6969c);
                } else if (f14 >= 1.0f) {
                    view.setVisibility(this.f7001j.f6969c);
                } else if (this.f7001j.f6969c != lVar.f6969c) {
                    view.setVisibility(0);
                }
            }
            if (this.E != null) {
                int i13 = 0;
                while (true) {
                    k[] kVarArr = this.E;
                    if (i13 >= kVarArr.length) {
                        break;
                    }
                    kVarArr[i13].y(f14, view);
                    i13++;
                }
            }
        } else {
            c11 = 1;
            o oVar = this.f6998g;
            float f15 = oVar.f7024f;
            o oVar2 = this.f6999h;
            float f16 = f15 + ((oVar2.f7024f - f15) * f14);
            float f17 = oVar.f7025g;
            float f18 = f17 + ((oVar2.f7025g - f17) * f14);
            float f19 = oVar.f7026h;
            float f21 = oVar2.f7026h;
            float f22 = oVar.f7027i;
            float f23 = oVar2.f7027i;
            float f24 = f16 + 0.5f;
            int i14 = (int) f24;
            float f25 = f18 + 0.5f;
            int i15 = (int) f25;
            int i16 = (int) (f24 + ((f21 - f19) * f14) + f19);
            int i17 = (int) (f25 + ((f23 - f22) * f14) + f22);
            int i18 = i16 - i14;
            int i19 = i17 - i15;
            if (f21 != f19 || f23 != f22 || this.f6995d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                this.f6995d = false;
            }
            view.layout(i14, i15, i16, i17);
        }
        HashMap<String, x2.c> map4 = this.D;
        if (map4 != null) {
            for (x2.c cVar : map4.values()) {
                if (cVar instanceof x2.c.d) {
                    double[] dArr4 = this.f7011t;
                    ((x2.c.d) cVar).k(view, f14, dArr4[0], dArr4[c11]);
                } else {
                    cVar.j(view, f14);
                }
            }
        }
        return zJ;
    }

    public final void y(o oVar) {
        oVar.r((int) this.f6993b.getX(), (int) this.f6993b.getY(), this.f6993b.getWidth(), this.f6993b.getHeight());
    }

    public void z() {
        this.f6995d = true;
    }
}
