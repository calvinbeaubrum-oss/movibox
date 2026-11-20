package fi;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class z implements com.google.android.exoplayer2.g {
    public static final z B;

    @Deprecated
    public static final z C;

    @Deprecated
    public static final com.google.android.exoplayer2.g.a<z> D;
    public final ImmutableSet<Integer> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f65060d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f65061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f65062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f65063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f65064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f65065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f65066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f65067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImmutableList<String> f65068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f65069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImmutableList<String> f65070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f65071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f65072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f65073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImmutableList<String> f65074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImmutableList<String> f65075t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f65076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f65077v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f65078w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f65079x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f65080y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImmutableMap<i0, x> f65081z;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f65082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f65083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f65084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f65085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f65086e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f65087f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f65088g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f65089h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f65090i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f65091j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f65092k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ImmutableList<String> f65093l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f65094m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ImmutableList<String> f65095n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f65096o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f65097p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f65098q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public ImmutableList<String> f65099r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ImmutableList<String> f65100s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f65101t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f65102u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f65103v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f65104w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f65105x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public HashMap<i0, x> f65106y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public HashSet<Integer> f65107z;

        @Deprecated
        public a() {
            this.f65082a = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65083b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65084c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65085d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65090i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65091j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65092k = true;
            this.f65093l = ImmutableList.of();
            this.f65094m = 0;
            this.f65095n = ImmutableList.of();
            this.f65096o = 0;
            this.f65097p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65098q = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f65099r = ImmutableList.of();
            this.f65100s = ImmutableList.of();
            this.f65101t = 0;
            this.f65102u = 0;
            this.f65103v = false;
            this.f65104w = false;
            this.f65105x = false;
            this.f65106y = new HashMap<>();
            this.f65107z = new HashSet<>();
        }

        public a(Context context) {
            this();
            H(context);
            L(context, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Bundle bundle) {
            String strC = z.c(6);
            z zVar = z.B;
            this.f65082a = bundle.getInt(strC, zVar.f65057a);
            this.f65083b = bundle.getInt(z.c(7), zVar.f65058b);
            this.f65084c = bundle.getInt(z.c(8), zVar.f65059c);
            this.f65085d = bundle.getInt(z.c(9), zVar.f65060d);
            this.f65086e = bundle.getInt(z.c(10), zVar.f65061f);
            this.f65087f = bundle.getInt(z.c(11), zVar.f65062g);
            this.f65088g = bundle.getInt(z.c(12), zVar.f65063h);
            this.f65089h = bundle.getInt(z.c(13), zVar.f65064i);
            this.f65090i = bundle.getInt(z.c(14), zVar.f65065j);
            this.f65091j = bundle.getInt(z.c(15), zVar.f65066k);
            this.f65092k = bundle.getBoolean(z.c(16), zVar.f65067l);
            this.f65093l = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(17)), new String[0]));
            this.f65094m = bundle.getInt(z.c(25), zVar.f65069n);
            this.f65095n = D((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(1)), new String[0]));
            this.f65096o = bundle.getInt(z.c(2), zVar.f65071p);
            this.f65097p = bundle.getInt(z.c(18), zVar.f65072q);
            this.f65098q = bundle.getInt(z.c(19), zVar.f65073r);
            this.f65099r = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(20)), new String[0]));
            this.f65100s = D((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(3)), new String[0]));
            this.f65101t = bundle.getInt(z.c(4), zVar.f65076u);
            this.f65102u = bundle.getInt(z.c(26), zVar.f65077v);
            this.f65103v = bundle.getBoolean(z.c(5), zVar.f65078w);
            this.f65104w = bundle.getBoolean(z.c(21), zVar.f65079x);
            this.f65105x = bundle.getBoolean(z.c(22), zVar.f65080y);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(23));
            ImmutableList immutableListOf = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(x.f65054c, parcelableArrayList);
            this.f65106y = new HashMap<>();
            for (int i11 = 0; i11 < immutableListOf.size(); i11++) {
                x xVar = (x) immutableListOf.get(i11);
                this.f65106y.put(xVar.f65055a, xVar);
            }
            int[] iArr = (int[]) com.google.common.base.h.a(bundle.getIntArray(z.c(24)), new int[0]);
            this.f65107z = new HashSet<>();
            for (int i12 : iArr) {
                this.f65107z.add(Integer.valueOf(i12));
            }
        }

        public a(z zVar) {
            C(zVar);
        }

        public static ImmutableList<String> D(String[] strArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (String str : (String[]) com.google.android.exoplayer2.util.a.e(strArr)) {
                aVarBuilder.a(o0.E0((String) com.google.android.exoplayer2.util.a.e(str)));
            }
            return aVarBuilder.m();
        }

        public z A() {
            return new z(this);
        }

        public a B(int i11) {
            Iterator<x> it = this.f65106y.values().iterator();
            while (it.hasNext()) {
                if (it.next().b() == i11) {
                    it.remove();
                }
            }
            return this;
        }

        public final void C(z zVar) {
            this.f65082a = zVar.f65057a;
            this.f65083b = zVar.f65058b;
            this.f65084c = zVar.f65059c;
            this.f65085d = zVar.f65060d;
            this.f65086e = zVar.f65061f;
            this.f65087f = zVar.f65062g;
            this.f65088g = zVar.f65063h;
            this.f65089h = zVar.f65064i;
            this.f65090i = zVar.f65065j;
            this.f65091j = zVar.f65066k;
            this.f65092k = zVar.f65067l;
            this.f65093l = zVar.f65068m;
            this.f65094m = zVar.f65069n;
            this.f65095n = zVar.f65070o;
            this.f65096o = zVar.f65071p;
            this.f65097p = zVar.f65072q;
            this.f65098q = zVar.f65073r;
            this.f65099r = zVar.f65074s;
            this.f65100s = zVar.f65075t;
            this.f65101t = zVar.f65076u;
            this.f65102u = zVar.f65077v;
            this.f65103v = zVar.f65078w;
            this.f65104w = zVar.f65079x;
            this.f65105x = zVar.f65080y;
            this.f65107z = new HashSet<>(zVar.A);
            this.f65106y = new HashMap<>(zVar.f65081z);
        }

        public a E(z zVar) {
            C(zVar);
            return this;
        }

        public a F(int i11) {
            this.f65102u = i11;
            return this;
        }

        public a G(x xVar) {
            B(xVar.b());
            this.f65106y.put(xVar.f65055a, xVar);
            return this;
        }

        public a H(Context context) {
            if (o0.f35608a >= 19) {
                I(context);
            }
            return this;
        }

        @RequiresApi(19)
        public final void I(Context context) {
            CaptioningManager captioningManager;
            if ((o0.f35608a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f65101t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f65100s = ImmutableList.of(o0.Y(locale));
                }
            }
        }

        public a J(int i11, boolean z11) {
            if (z11) {
                this.f65107z.add(Integer.valueOf(i11));
            } else {
                this.f65107z.remove(Integer.valueOf(i11));
            }
            return this;
        }

        public a K(int i11, int i12, boolean z11) {
            this.f65090i = i11;
            this.f65091j = i12;
            this.f65092k = z11;
            return this;
        }

        public a L(Context context, boolean z11) {
            Point pointO = o0.O(context);
            return K(pointO.x, pointO.y, z11);
        }
    }

    static {
        z zVarA = new a().A();
        B = zVarA;
        C = zVarA;
        D = new com.google.android.exoplayer2.g.a() { // from class: fi.y
            @Override // com.google.android.exoplayer2.g.a
            public final com.google.android.exoplayer2.g a(Bundle bundle) {
                return z.b(bundle);
            }
        };
    }

    public z(a aVar) {
        this.f65057a = aVar.f65082a;
        this.f65058b = aVar.f65083b;
        this.f65059c = aVar.f65084c;
        this.f65060d = aVar.f65085d;
        this.f65061f = aVar.f65086e;
        this.f65062g = aVar.f65087f;
        this.f65063h = aVar.f65088g;
        this.f65064i = aVar.f65089h;
        this.f65065j = aVar.f65090i;
        this.f65066k = aVar.f65091j;
        this.f65067l = aVar.f65092k;
        this.f65068m = aVar.f65093l;
        this.f65069n = aVar.f65094m;
        this.f65070o = aVar.f65095n;
        this.f65071p = aVar.f65096o;
        this.f65072q = aVar.f65097p;
        this.f65073r = aVar.f65098q;
        this.f65074s = aVar.f65099r;
        this.f65075t = aVar.f65100s;
        this.f65076u = aVar.f65101t;
        this.f65077v = aVar.f65102u;
        this.f65078w = aVar.f65103v;
        this.f65079x = aVar.f65104w;
        this.f65080y = aVar.f65105x;
        this.f65081z = ImmutableMap.copyOf((Map) aVar.f65106y);
        this.A = ImmutableSet.copyOf((Collection) aVar.f65107z);
    }

    public static z b(Bundle bundle) {
        return new a(bundle).A();
    }

    public static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public a a() {
        return new a(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f65057a == zVar.f65057a && this.f65058b == zVar.f65058b && this.f65059c == zVar.f65059c && this.f65060d == zVar.f65060d && this.f65061f == zVar.f65061f && this.f65062g == zVar.f65062g && this.f65063h == zVar.f65063h && this.f65064i == zVar.f65064i && this.f65067l == zVar.f65067l && this.f65065j == zVar.f65065j && this.f65066k == zVar.f65066k && this.f65068m.equals(zVar.f65068m) && this.f65069n == zVar.f65069n && this.f65070o.equals(zVar.f65070o) && this.f65071p == zVar.f65071p && this.f65072q == zVar.f65072q && this.f65073r == zVar.f65073r && this.f65074s.equals(zVar.f65074s) && this.f65075t.equals(zVar.f65075t) && this.f65076u == zVar.f65076u && this.f65077v == zVar.f65077v && this.f65078w == zVar.f65078w && this.f65079x == zVar.f65079x && this.f65080y == zVar.f65080y && this.f65081z.equals(zVar.f65081z) && this.A.equals(zVar.A);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f65057a + 31) * 31) + this.f65058b) * 31) + this.f65059c) * 31) + this.f65060d) * 31) + this.f65061f) * 31) + this.f65062g) * 31) + this.f65063h) * 31) + this.f65064i) * 31) + (this.f65067l ? 1 : 0)) * 31) + this.f65065j) * 31) + this.f65066k) * 31) + this.f65068m.hashCode()) * 31) + this.f65069n) * 31) + this.f65070o.hashCode()) * 31) + this.f65071p) * 31) + this.f65072q) * 31) + this.f65073r) * 31) + this.f65074s.hashCode()) * 31) + this.f65075t.hashCode()) * 31) + this.f65076u) * 31) + this.f65077v) * 31) + (this.f65078w ? 1 : 0)) * 31) + (this.f65079x ? 1 : 0)) * 31) + (this.f65080y ? 1 : 0)) * 31) + this.f65081z.hashCode()) * 31) + this.A.hashCode();
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(6), this.f65057a);
        bundle.putInt(c(7), this.f65058b);
        bundle.putInt(c(8), this.f65059c);
        bundle.putInt(c(9), this.f65060d);
        bundle.putInt(c(10), this.f65061f);
        bundle.putInt(c(11), this.f65062g);
        bundle.putInt(c(12), this.f65063h);
        bundle.putInt(c(13), this.f65064i);
        bundle.putInt(c(14), this.f65065j);
        bundle.putInt(c(15), this.f65066k);
        bundle.putBoolean(c(16), this.f65067l);
        bundle.putStringArray(c(17), (String[]) this.f65068m.toArray(new String[0]));
        bundle.putInt(c(25), this.f65069n);
        bundle.putStringArray(c(1), (String[]) this.f65070o.toArray(new String[0]));
        bundle.putInt(c(2), this.f65071p);
        bundle.putInt(c(18), this.f65072q);
        bundle.putInt(c(19), this.f65073r);
        bundle.putStringArray(c(20), (String[]) this.f65074s.toArray(new String[0]));
        bundle.putStringArray(c(3), (String[]) this.f65075t.toArray(new String[0]));
        bundle.putInt(c(4), this.f65076u);
        bundle.putInt(c(26), this.f65077v);
        bundle.putBoolean(c(5), this.f65078w);
        bundle.putBoolean(c(21), this.f65079x);
        bundle.putBoolean(c(22), this.f65080y);
        bundle.putParcelableArrayList(c(23), com.google.android.exoplayer2.util.d.d(this.f65081z.values()));
        bundle.putIntArray(c(24), Ints.m(this.A));
        return bundle;
    }
}
