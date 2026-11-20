package com.transsion.json;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class u implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f52993a;

    public u(StringBuilder sb2) {
        this.f52993a = sb2;
    }

    @Override // com.transsion.json.q
    public int a(String str, int i11, int i12) {
        this.f52993a.append((CharSequence) str, i11, i12);
        return i12;
    }

    @Override // com.transsion.json.q
    public q a(String str) {
        this.f52993a.append(str);
        return this;
    }

    @Override // com.transsion.json.q
    public int b(String str, int i11, int i12, String str2) {
        this.f52993a.append((CharSequence) str, i11, i12);
        this.f52993a.append(str2);
        return i12 + 1;
    }

    public String toString() {
        return this.f52993a.toString();
    }
}
