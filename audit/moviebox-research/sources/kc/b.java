package kc;

import dd.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f68523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f68524b;

    public b(String str, String str2) {
        this.f68523a = str;
        this.f68524b = str2;
    }

    @Override // dd.f
    public String authority() {
        return this.f68523a;
    }

    public String toString() {
        return "authority=" + this.f68523a + ",description=" + this.f68524b;
    }
}
