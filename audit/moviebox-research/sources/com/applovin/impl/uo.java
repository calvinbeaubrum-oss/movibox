package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.applovin.exoplayer2.common.base.MoreObjects;
import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uo implements o2 {
    public static final o2.a A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final uo f23650y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final uo f23651z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f23656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f23657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f23658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f23659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f23660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f23661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f23662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final eb f23663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final eb f23664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f23665o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f23666p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f23667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final eb f23668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final eb f23669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f23670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f23671u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f23672v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f23673w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ib f23674x;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f23675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f23676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f23677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f23678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f23679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f23680f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f23681g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f23682h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f23683i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23684j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f23685k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private eb f23686l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private eb f23687m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f23688n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f23689o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f23690p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private eb f23691q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private eb f23692r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f23693s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f23694t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f23695u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private boolean f23696v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private ib f23697w;

        public a() {
            this.f23675a = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23676b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23677c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23678d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23683i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23684j = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23685k = true;
            this.f23686l = eb.h();
            this.f23687m = eb.h();
            this.f23688n = 0;
            this.f23689o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23690p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f23691q = eb.h();
            this.f23692r = eb.h();
            this.f23693s = 0;
            this.f23694t = false;
            this.f23695u = false;
            this.f23696v = false;
            this.f23697w = ib.h();
        }

        public a(Context context) {
            this();
            a(context);
            a(context, true);
        }

        public a(Bundle bundle) {
            String strB = uo.b(6);
            uo uoVar = uo.f23650y;
            this.f23675a = bundle.getInt(strB, uoVar.f23652a);
            this.f23676b = bundle.getInt(uo.b(7), uoVar.f23653b);
            this.f23677c = bundle.getInt(uo.b(8), uoVar.f23654c);
            this.f23678d = bundle.getInt(uo.b(9), uoVar.f23655d);
            this.f23679e = bundle.getInt(uo.b(10), uoVar.f23656f);
            this.f23680f = bundle.getInt(uo.b(11), uoVar.f23657g);
            this.f23681g = bundle.getInt(uo.b(12), uoVar.f23658h);
            this.f23682h = bundle.getInt(uo.b(13), uoVar.f23659i);
            this.f23683i = bundle.getInt(uo.b(14), uoVar.f23660j);
            this.f23684j = bundle.getInt(uo.b(15), uoVar.f23661k);
            this.f23685k = bundle.getBoolean(uo.b(16), uoVar.f23662l);
            this.f23686l = eb.c((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(17)), new String[0]));
            this.f23687m = a((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(1)), new String[0]));
            this.f23688n = bundle.getInt(uo.b(2), uoVar.f23665o);
            this.f23689o = bundle.getInt(uo.b(18), uoVar.f23666p);
            this.f23690p = bundle.getInt(uo.b(19), uoVar.f23667q);
            this.f23691q = eb.c((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(20)), new String[0]));
            this.f23692r = a((String[]) MoreObjects.firstNonNull(bundle.getStringArray(uo.b(3)), new String[0]));
            this.f23693s = bundle.getInt(uo.b(4), uoVar.f23670t);
            this.f23694t = bundle.getBoolean(uo.b(5), uoVar.f23671u);
            this.f23695u = bundle.getBoolean(uo.b(21), uoVar.f23672v);
            this.f23696v = bundle.getBoolean(uo.b(22), uoVar.f23673w);
            this.f23697w = ib.a((Collection) ub.a((int[]) MoreObjects.firstNonNull(bundle.getIntArray(uo.b(23)), new int[0])));
        }

        private static eb a(String[] strArr) {
            eb.a aVarF = eb.f();
            for (String str : (String[]) b1.a(strArr)) {
                aVarF.b(xp.f((String) b1.a((Object) str)));
            }
            return aVarF.a();
        }

        private void b(Context context) {
            CaptioningManager captioningManager;
            if ((xp.f24372a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f23693s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f23692r = eb.a(xp.a(locale));
                }
            }
        }

        public a a(int i11, int i12, boolean z11) {
            this.f23683i = i11;
            this.f23684j = i12;
            this.f23685k = z11;
            return this;
        }

        public a a(Context context) {
            if (xp.f24372a >= 19) {
                b(context);
            }
            return this;
        }

        public a a(Context context, boolean z11) {
            Point pointC = xp.c(context);
            return a(pointC.x, pointC.y, z11);
        }

        public uo a() {
            return new uo(this);
        }
    }

    static {
        uo uoVarA = new a().a();
        f23650y = uoVarA;
        f23651z = uoVarA;
        A = new o2.a() { // from class: com.applovin.impl.d70
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return uo.a(bundle);
            }
        };
    }

    public uo(a aVar) {
        this.f23652a = aVar.f23675a;
        this.f23653b = aVar.f23676b;
        this.f23654c = aVar.f23677c;
        this.f23655d = aVar.f23678d;
        this.f23656f = aVar.f23679e;
        this.f23657g = aVar.f23680f;
        this.f23658h = aVar.f23681g;
        this.f23659i = aVar.f23682h;
        this.f23660j = aVar.f23683i;
        this.f23661k = aVar.f23684j;
        this.f23662l = aVar.f23685k;
        this.f23663m = aVar.f23686l;
        this.f23664n = aVar.f23687m;
        this.f23665o = aVar.f23688n;
        this.f23666p = aVar.f23689o;
        this.f23667q = aVar.f23690p;
        this.f23668r = aVar.f23691q;
        this.f23669s = aVar.f23692r;
        this.f23670t = aVar.f23693s;
        this.f23671u = aVar.f23694t;
        this.f23672v = aVar.f23695u;
        this.f23673w = aVar.f23696v;
        this.f23674x = aVar.f23697w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ uo a(Bundle bundle) {
        return new a(bundle).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        uo uoVar = (uo) obj;
        return this.f23652a == uoVar.f23652a && this.f23653b == uoVar.f23653b && this.f23654c == uoVar.f23654c && this.f23655d == uoVar.f23655d && this.f23656f == uoVar.f23656f && this.f23657g == uoVar.f23657g && this.f23658h == uoVar.f23658h && this.f23659i == uoVar.f23659i && this.f23662l == uoVar.f23662l && this.f23660j == uoVar.f23660j && this.f23661k == uoVar.f23661k && this.f23663m.equals(uoVar.f23663m) && this.f23664n.equals(uoVar.f23664n) && this.f23665o == uoVar.f23665o && this.f23666p == uoVar.f23666p && this.f23667q == uoVar.f23667q && this.f23668r.equals(uoVar.f23668r) && this.f23669s.equals(uoVar.f23669s) && this.f23670t == uoVar.f23670t && this.f23671u == uoVar.f23671u && this.f23672v == uoVar.f23672v && this.f23673w == uoVar.f23673w && this.f23674x.equals(uoVar.f23674x);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((this.f23652a + 31) * 31) + this.f23653b) * 31) + this.f23654c) * 31) + this.f23655d) * 31) + this.f23656f) * 31) + this.f23657g) * 31) + this.f23658h) * 31) + this.f23659i) * 31) + (this.f23662l ? 1 : 0)) * 31) + this.f23660j) * 31) + this.f23661k) * 31) + this.f23663m.hashCode()) * 31) + this.f23664n.hashCode()) * 31) + this.f23665o) * 31) + this.f23666p) * 31) + this.f23667q) * 31) + this.f23668r.hashCode()) * 31) + this.f23669s.hashCode()) * 31) + this.f23670t) * 31) + (this.f23671u ? 1 : 0)) * 31) + (this.f23672v ? 1 : 0)) * 31) + (this.f23673w ? 1 : 0)) * 31) + this.f23674x.hashCode();
    }
}
