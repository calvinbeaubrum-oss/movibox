package com.bytedance.sdk.component.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Qj implements Comparable<Qj>, Runnable {
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26555sc;

    public Qj(String str) {
        this.f26555sc = 5;
        this.pFF = str;
    }

    public Qj(String str, int i11) {
        this.f26555sc = 0;
        this.f26555sc = i11 == 0 ? 5 : i11;
        this.pFF = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Qj qj2) {
        if (getPriority() < qj2.getPriority()) {
            return 1;
        }
        return getPriority() >= qj2.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.pFF;
    }

    public int getPriority() {
        return this.f26555sc;
    }

    public void setPriority(int i11) {
        this.f26555sc = i11;
    }
}
