package org.jsoup.parser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f73171c = new d(false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f73172d = new d(true, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f73173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f73174b;

    public d(boolean z11, boolean z12) {
        this.f73173a = z11;
        this.f73174b = z12;
    }

    public org.jsoup.nodes.b a(org.jsoup.nodes.b bVar) {
        if (!this.f73174b) {
            bVar.F();
        }
        return bVar;
    }

    public String b(String str) {
        String strTrim = str.trim();
        return !this.f73173a ? e30.b.a(strTrim) : strTrim;
    }
}
