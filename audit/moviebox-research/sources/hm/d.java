package hm;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f66505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f66507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<byte[]> f66508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f66509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f66510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f66511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f66512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f66513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f66514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f66515k;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i11) {
        this(bArr, str, list, str2, -1, -1, i11);
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i11, int i12, int i13) {
        this.f66505a = bArr;
        this.f66506b = bArr == null ? 0 : bArr.length * 8;
        this.f66507c = str;
        this.f66508d = list;
        this.f66509e = str2;
        this.f66513i = i12;
        this.f66514j = i11;
        this.f66515k = i13;
    }

    public List<byte[]> a() {
        return this.f66508d;
    }

    public String b() {
        return this.f66509e;
    }

    public Integer c() {
        return this.f66511g;
    }

    public Integer d() {
        return this.f66510f;
    }

    public int e() {
        return this.f66506b;
    }

    public Object f() {
        return this.f66512h;
    }

    public byte[] g() {
        return this.f66505a;
    }

    public int h() {
        return this.f66513i;
    }

    public int i() {
        return this.f66514j;
    }

    public int j() {
        return this.f66515k;
    }

    public String k() {
        return this.f66507c;
    }

    public boolean l() {
        return this.f66513i >= 0 && this.f66514j >= 0;
    }

    public void m(Integer num) {
        this.f66511g = num;
    }

    public void n(Integer num) {
        this.f66510f = num;
    }

    public void o(int i11) {
        this.f66506b = i11;
    }

    public void p(Object obj) {
        this.f66512h = obj;
    }
}
