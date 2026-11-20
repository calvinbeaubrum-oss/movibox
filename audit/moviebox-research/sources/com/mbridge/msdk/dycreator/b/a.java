package com.mbridge.msdk.dycreator.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f43295b;

    public a(int i11, String str) {
        this.f43294a = i11;
        this.f43295b = str;
    }

    public a(b bVar) {
        if (bVar != null) {
            this.f43294a = bVar.a();
            this.f43295b = bVar.b();
        }
    }

    public final String toString() {
        return "DyError{errorCode=" + this.f43294a + '}';
    }
}
