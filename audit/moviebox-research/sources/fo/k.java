package fo;

import android.graphics.Point;
import android.util.SparseBooleanArray;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f65193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f65195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f65196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f65197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseBooleanArray f65198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f65199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f65200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f65201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f65202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Point f65203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f65204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f65205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte f65206n;

    public k() {
    }

    public k(d dVar) {
        this.f65193a = dVar.n();
        this.f65194b = dVar.p();
        this.f65195c = dVar.j();
        this.f65196d = dVar.d();
        this.f65197e = dVar.c();
        this.f65198f = dVar.e();
        this.f65199g = dVar.f();
        this.f65200h = dVar.q();
        this.f65201i = dVar.h();
        this.f65202j = dVar.g();
        this.f65203k = dVar.m();
        this.f65204l = dVar.l();
        this.f65205m = dVar.r();
        this.f65206n = Ascii.SI;
    }

    @Override // fo.d.a
    public final d a() {
        String str;
        b bVar;
        a aVar;
        SparseBooleanArray sparseBooleanArray;
        List list;
        String str2;
        String str3;
        List list2;
        Point point;
        if (this.f65206n == 15 && (str = this.f65195c) != null && (bVar = this.f65196d) != null && (aVar = this.f65197e) != null && (sparseBooleanArray = this.f65198f) != null && (list = this.f65199g) != null && (str2 = this.f65200h) != null && (str3 = this.f65201i) != null && (list2 = this.f65202j) != null && (point = this.f65203k) != null) {
            return new d(this.f65193a, this.f65194b, str, bVar, aVar, sparseBooleanArray, list, str2, str3, list2, point, this.f65204l, this.f65205m);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f65206n & 1) == 0) {
            sb2.append(" timestampSeconds");
        }
        if ((this.f65206n & 2) == 0) {
            sb2.append(" type");
        }
        if (this.f65195c == null) {
            sb2.append(" name");
        }
        if (this.f65196d == null) {
            sb2.append(" build");
        }
        if (this.f65197e == null) {
            sb2.append(" boot");
        }
        if (this.f65198f == null) {
            sb2.append(" capabilities");
        }
        if (this.f65199g == null) {
            sb2.append(" ids");
        }
        if (this.f65200h == null) {
            sb2.append(" userAgent");
        }
        if (this.f65201i == null) {
            sb2.append(" locale");
        }
        if (this.f65202j == null) {
            sb2.append(" inputLocales");
        }
        if (this.f65203k == null) {
            sb2.append(" screenSizeDips");
        }
        if ((this.f65206n & 4) == 0) {
            sb2.append(" screenPixelRatio");
        }
        if ((this.f65206n & 8) == 0) {
            sb2.append(" utcOffsetSeconds");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // fo.d.a
    public final k b(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray == null) {
            throw new NullPointerException("Null capabilities");
        }
        this.f65198f = sparseBooleanArray;
        return this;
    }

    @Override // fo.d.a
    public final SparseBooleanArray c() {
        SparseBooleanArray sparseBooleanArray = this.f65198f;
        if (sparseBooleanArray != null) {
            return sparseBooleanArray;
        }
        throw new IllegalStateException("Property \"capabilities\" has not been set");
    }

    @Override // fo.d.a
    public final d.a d(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Null boot");
        }
        this.f65197e = aVar;
        return this;
    }

    @Override // fo.d.a
    public final d.a e(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Null build");
        }
        this.f65196d = bVar;
        return this;
    }

    @Override // fo.d.a
    public final d.a h(List list) {
        if (list == null) {
            throw new NullPointerException("Null ids");
        }
        this.f65199g = list;
        return this;
    }

    @Override // fo.d.a
    public final d.a i(List list) {
        if (list == null) {
            throw new NullPointerException("Null inputLocales");
        }
        this.f65202j = list;
        return this;
    }

    @Override // fo.d.a
    public final d.a j(String str) {
        if (str == null) {
            throw new NullPointerException("Null locale");
        }
        this.f65201i = str;
        return this;
    }

    @Override // fo.d.a
    public final d.a k(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f65195c = str;
        return this;
    }

    @Override // fo.d.a
    public final d.a l(float f11) {
        this.f65204l = f11;
        this.f65206n = (byte) (this.f65206n | 4);
        return this;
    }

    @Override // fo.d.a
    public final d.a m(Point point) {
        if (point == null) {
            throw new NullPointerException("Null screenSizeDips");
        }
        this.f65203k = point;
        return this;
    }

    @Override // fo.d.a
    public final d.a n(long j11) {
        this.f65193a = j11;
        this.f65206n = (byte) (this.f65206n | 1);
        return this;
    }

    @Override // fo.d.a
    public final d.a o(int i11) {
        this.f65194b = i11;
        this.f65206n = (byte) (this.f65206n | 2);
        return this;
    }

    @Override // fo.d.a
    public final d.a p(int i11) {
        this.f65205m = i11;
        this.f65206n = (byte) (this.f65206n | 8);
        return this;
    }

    public final d.a q(String str) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f65200h = str;
        return this;
    }
}
