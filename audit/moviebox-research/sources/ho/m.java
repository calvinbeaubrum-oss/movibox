package ho;

import android.util.SparseBooleanArray;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseBooleanArray f66725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f66726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f66728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f66729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f66730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f66731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f66732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f66733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f66734j;

    public m() {
    }

    public m(e eVar) {
        this.f66725a = eVar.e();
        this.f66726b = eVar.d();
        this.f66727c = eVar.f();
        this.f66728d = eVar.n();
        this.f66729e = eVar.j();
        this.f66730f = eVar.g();
        this.f66731g = eVar.c();
        this.f66732h = eVar.i();
        this.f66733i = eVar.h();
        this.f66734j = (byte) 7;
    }

    @Override // ho.e.a
    public final byte a() {
        if ((this.f66734j & 1) != 0) {
            return this.f66726b;
        }
        throw new IllegalStateException("Property \"capabilities\" has not been set");
    }

    @Override // ho.e.a
    public final m b(byte b11) {
        this.f66726b = b11;
        this.f66734j = (byte) (this.f66734j | 1);
        return this;
    }

    @Override // ho.e.a
    public final m c(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray == null) {
            throw new NullPointerException("Null connectionTypes");
        }
        this.f66725a = sparseBooleanArray;
        return this;
    }

    @Override // ho.e.a
    public final SparseBooleanArray d() {
        SparseBooleanArray sparseBooleanArray = this.f66725a;
        if (sparseBooleanArray != null) {
            return sparseBooleanArray;
        }
        throw new IllegalStateException("Property \"connectionTypes\" has not been set");
    }

    @Override // ho.e.a
    public final e.a e(String str) {
        if (str == null) {
            throw new NullPointerException("Null bssid");
        }
        this.f66731g = str;
        return this;
    }

    @Override // ho.e.a
    public final e f() {
        SparseBooleanArray sparseBooleanArray;
        List list;
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f66734j == 7 && (sparseBooleanArray = this.f66725a) != null && (list = this.f66729e) != null && (str = this.f66730f) != null && (str2 = this.f66731g) != null && (str3 = this.f66732h) != null && (str4 = this.f66733i) != null) {
            return new e(sparseBooleanArray, this.f66726b, this.f66727c, this.f66728d, list, str, str2, str3, str4);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f66725a == null) {
            sb2.append(" connectionTypes");
        }
        if ((this.f66734j & 1) == 0) {
            sb2.append(" capabilities");
        }
        if ((this.f66734j & 2) == 0) {
            sb2.append(" downstreamKbps");
        }
        if ((this.f66734j & 4) == 0) {
            sb2.append(" upstreamKbps");
        }
        if (this.f66729e == null) {
            sb2.append(" linkNames");
        }
        if (this.f66730f == null) {
            sb2.append(" httpProxyHost");
        }
        if (this.f66731g == null) {
            sb2.append(" bssid");
        }
        if (this.f66732h == null) {
            sb2.append(" interfaceName");
        }
        if (this.f66733i == null) {
            sb2.append(" interfaceAddress");
        }
        throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
    }

    @Override // ho.e.a
    public final e.a i(int i11) {
        this.f66727c = i11;
        this.f66734j = (byte) (this.f66734j | 2);
        return this;
    }

    @Override // ho.e.a
    public final e.a j(String str) {
        if (str == null) {
            throw new NullPointerException("Null httpProxyHost");
        }
        this.f66730f = str;
        return this;
    }

    @Override // ho.e.a
    public final e.a k(String str) {
        if (str == null) {
            throw new NullPointerException("Null interfaceAddress");
        }
        this.f66733i = str;
        return this;
    }

    @Override // ho.e.a
    public final e.a l(String str) {
        if (str == null) {
            throw new NullPointerException("Null interfaceName");
        }
        this.f66732h = str;
        return this;
    }

    @Override // ho.e.a
    public final e.a m(List list) {
        if (list == null) {
            throw new NullPointerException("Null linkNames");
        }
        this.f66729e = list;
        return this;
    }

    @Override // ho.e.a
    public final e.a n(int i11) {
        this.f66728d = i11;
        this.f66734j = (byte) (this.f66734j | 4);
        return this;
    }
}
