package lf;

import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements of.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public of.b f70223a;

    public a(of.b bVar) {
        this.f70223a = bVar;
    }

    @Override // of.a
    public int a() {
        return 1;
    }

    @Override // of.b
    public boolean b(File file) {
        return this.f70223a.b(file);
    }

    @Override // of.a
    public String c(String str, int i11) {
        return str + ".bak";
    }
}
