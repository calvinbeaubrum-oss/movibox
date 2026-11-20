package org.jsoup.parser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f73169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73170b;

    public c(int i11, String str) {
        this.f73169a = i11;
        this.f73170b = str;
    }

    public c(int i11, String str, Object... objArr) {
        this.f73170b = String.format(str, objArr);
        this.f73169a = i11;
    }

    public String toString() {
        return this.f73169a + ": " + this.f73170b;
    }
}
