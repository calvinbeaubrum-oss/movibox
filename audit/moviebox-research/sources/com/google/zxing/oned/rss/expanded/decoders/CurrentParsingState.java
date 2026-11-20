package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class CurrentParsingState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41547a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f41548b = State.NUMERIC;

    /* JADX INFO: compiled from: source.java */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f41547a;
    }

    public void b(int i11) {
        this.f41547a += i11;
    }

    public boolean c() {
        return this.f41548b == State.ALPHA;
    }

    public boolean d() {
        return this.f41548b == State.ISO_IEC_646;
    }

    public void e() {
        this.f41548b = State.ALPHA;
    }

    public void f() {
        this.f41548b = State.ISO_IEC_646;
    }

    public void g() {
        this.f41548b = State.NUMERIC;
    }

    public void h(int i11) {
        this.f41547a = i11;
    }
}
