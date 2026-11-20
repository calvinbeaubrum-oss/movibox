package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class xl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final qo f24345a;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends dh {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    public xl(qo qoVar) {
        this.f24345a = qoVar;
    }

    public abstract boolean a(bh bhVar);

    public final boolean a(bh bhVar, long j11) {
        return a(bhVar) && b(bhVar, j11);
    }

    public abstract boolean b(bh bhVar, long j11);
}
