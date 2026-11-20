package com.google.firebase.remoteconfig.internal;

import yl.g;
import yl.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f41103c;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f41106c;

        public b() {
        }

        public d a() {
            return new d(this.f41104a, this.f41105b, this.f41106c);
        }

        public b b(h hVar) {
            this.f41106c = hVar;
            return this;
        }

        public b c(int i11) {
            this.f41105b = i11;
            return this;
        }

        public b d(long j11) {
            this.f41104a = j11;
            return this;
        }
    }

    public d(long j11, int i11, h hVar) {
        this.f41101a = j11;
        this.f41102b = i11;
        this.f41103c = hVar;
    }

    public static b b() {
        return new b();
    }

    @Override // yl.g
    public int a() {
        return this.f41102b;
    }
}
