package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import b7.j;
import b7.k;
import b7.n;
import c7.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f15206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f15207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayerType f15210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f15212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Mask> f15213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f15214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f15215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f15216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f15217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f15218m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f15219n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f15220o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f15221p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final j f15222q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final k f15223r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final b7.b f15224s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<h7.a<Float>> f15225t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MatteType f15226u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f15227v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final c7.a f15228w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final f7.j f15229x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LBlendMode f15230y;

    /* JADX INFO: compiled from: source.java */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: source.java */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<c> list, h hVar, String str, long j11, LayerType layerType, long j12, @Nullable String str2, List<Mask> list2, n nVar, int i11, int i12, int i13, float f11, float f12, float f13, float f14, @Nullable j jVar, @Nullable k kVar, List<h7.a<Float>> list3, MatteType matteType, @Nullable b7.b bVar, boolean z11, @Nullable c7.a aVar, @Nullable f7.j jVar2, LBlendMode lBlendMode) {
        this.f15206a = list;
        this.f15207b = hVar;
        this.f15208c = str;
        this.f15209d = j11;
        this.f15210e = layerType;
        this.f15211f = j12;
        this.f15212g = str2;
        this.f15213h = list2;
        this.f15214i = nVar;
        this.f15215j = i11;
        this.f15216k = i12;
        this.f15217l = i13;
        this.f15218m = f11;
        this.f15219n = f12;
        this.f15220o = f13;
        this.f15221p = f14;
        this.f15222q = jVar;
        this.f15223r = kVar;
        this.f15225t = list3;
        this.f15226u = matteType;
        this.f15224s = bVar;
        this.f15227v = z11;
        this.f15228w = aVar;
        this.f15229x = jVar2;
        this.f15230y = lBlendMode;
    }

    @Nullable
    public LBlendMode a() {
        return this.f15230y;
    }

    @Nullable
    public c7.a b() {
        return this.f15228w;
    }

    public h c() {
        return this.f15207b;
    }

    @Nullable
    public f7.j d() {
        return this.f15229x;
    }

    public long e() {
        return this.f15209d;
    }

    public List<h7.a<Float>> f() {
        return this.f15225t;
    }

    public LayerType g() {
        return this.f15210e;
    }

    public List<Mask> h() {
        return this.f15213h;
    }

    public MatteType i() {
        return this.f15226u;
    }

    public String j() {
        return this.f15208c;
    }

    public long k() {
        return this.f15211f;
    }

    public float l() {
        return this.f15221p;
    }

    public float m() {
        return this.f15220o;
    }

    @Nullable
    public String n() {
        return this.f15212g;
    }

    public List<c> o() {
        return this.f15206a;
    }

    public int p() {
        return this.f15217l;
    }

    public int q() {
        return this.f15216k;
    }

    public int r() {
        return this.f15215j;
    }

    public float s() {
        return this.f15219n / this.f15207b.e();
    }

    @Nullable
    public j t() {
        return this.f15222q;
    }

    public String toString() {
        return z("");
    }

    @Nullable
    public k u() {
        return this.f15223r;
    }

    @Nullable
    public b7.b v() {
        return this.f15224s;
    }

    public float w() {
        return this.f15218m;
    }

    public n x() {
        return this.f15214i;
    }

    public boolean y() {
        return this.f15227v;
    }

    public String z(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(j());
        sb2.append("\n");
        Layer layerT = this.f15207b.t(k());
        if (layerT != null) {
            sb2.append("\t\tParents: ");
            sb2.append(layerT.j());
            Layer layerT2 = this.f15207b.t(layerT.k());
            while (layerT2 != null) {
                sb2.append("->");
                sb2.append(layerT2.j());
                layerT2 = this.f15207b.t(layerT2.k());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!h().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(h().size());
            sb2.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.f15206a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (c cVar : this.f15206a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(cVar);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
