package com.bytedance.sdk.component.pFF.sc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UFX implements Cloneable {
    public TimeUnit ExN;
    public long TRI;
    public long We;
    public long pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public TimeUnit f26934qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public List<Qj> f26935sc;
    public TimeUnit zY;

    /* JADX INFO: compiled from: source.java */
    public static final class sc {
        public TimeUnit ExN;
        public long TRI;
        public long We;
        public long pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        public TimeUnit f26936qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final List<Qj> f26937sc;
        public TimeUnit zY;

        public sc() {
            this.f26937sc = new ArrayList();
            this.pFF = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.zY = timeUnit;
            this.We = 10000L;
            this.ExN = timeUnit;
            this.TRI = 10000L;
            this.f26936qr = timeUnit;
        }

        public sc(UFX ufx) {
            this.f26937sc = new ArrayList();
            this.pFF = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.zY = timeUnit;
            this.We = 10000L;
            this.ExN = timeUnit;
            this.TRI = 10000L;
            this.f26936qr = timeUnit;
            this.pFF = ufx.pFF;
            this.zY = ufx.zY;
            this.We = ufx.We;
            this.ExN = ufx.ExN;
            this.TRI = ufx.TRI;
            this.f26936qr = ufx.f26934qr;
        }

        public sc(String str) {
            this.f26937sc = new ArrayList();
            this.pFF = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.zY = timeUnit;
            this.We = 10000L;
            this.ExN = timeUnit;
            this.TRI = 10000L;
            this.f26936qr = timeUnit;
        }

        public sc pFF(long j11, TimeUnit timeUnit) {
            this.We = j11;
            this.ExN = timeUnit;
            return this;
        }

        public sc sc(long j11, TimeUnit timeUnit) {
            this.pFF = j11;
            this.zY = timeUnit;
            return this;
        }

        public sc sc(Qj qj2) {
            this.f26937sc.add(qj2);
            return this;
        }

        public UFX sc() {
            return com.bytedance.sdk.component.pFF.sc.sc.sc.sc(this);
        }

        public sc zY(long j11, TimeUnit timeUnit) {
            this.TRI = j11;
            this.f26936qr = timeUnit;
            return this;
        }
    }

    public UFX(sc scVar) {
        this.pFF = scVar.pFF;
        this.We = scVar.We;
        this.TRI = scVar.TRI;
        List<Qj> list = scVar.f26937sc;
        this.zY = scVar.zY;
        this.ExN = scVar.ExN;
        this.f26934qr = scVar.f26936qr;
        this.f26935sc = list;
    }

    public sc pFF() {
        return new sc(this);
    }

    public abstract We sc();

    public abstract pFF sc(Ql ql2);
}
