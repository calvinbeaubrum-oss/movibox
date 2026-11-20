package t10;

import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f76721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f76722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f76724d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f76725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f76726g;

    public b(a aVar, h hVar, int i11) {
        this.f76722b = null;
        this.f76724d = null;
        this.f76721a = i11;
        InputStream inputStream = aVar.f76716g;
        if (inputStream == null) {
            this.f76722b = aVar.f76714e;
            this.f76723c = aVar.f76715f;
        }
        this.f76724d = inputStream;
        this.f76725f = hVar.b();
        this.f76726g = hVar.a();
    }

    public b(a aVar, h hVar, int i11, String str, String str2) {
        this.f76722b = null;
        this.f76724d = null;
        this.f76721a = i11;
        InputStream inputStream = aVar.f76716g;
        if (inputStream == null) {
            this.f76722b = aVar.f76714e;
            this.f76723c = aVar.f76715f;
        }
        this.f76724d = inputStream;
        this.f76725f = str;
        this.f76726g = str2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        int i11 = this.f76721a;
        int i12 = bVar.f76721a;
        if (i11 > i12) {
            return 1;
        }
        return i11 < i12 ? -1 : 0;
    }

    public String b() {
        return this.f76725f;
    }
}
