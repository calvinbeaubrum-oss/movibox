package s30;

import r30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f75957a;

    public a(StringBuilder sb2) {
        this.f75957a = sb2;
    }

    @Override // r30.c
    public c append(CharSequence charSequence) {
        this.f75957a.append(charSequence);
        return this;
    }

    public String toString() {
        return this.f75957a.toString();
    }
}
