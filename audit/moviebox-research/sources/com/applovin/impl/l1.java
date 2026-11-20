package com.applovin.impl;

import android.media.AudioAttributes;
import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l1 f20312g = new b().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o2.a f20313h = new o2.a() { // from class: com.applovin.impl.kz
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return l1.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20317d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioAttributes f20318f;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f20319a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20320b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20321c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20322d = 1;

        public b a(int i11) {
            this.f20322d = i11;
            return this;
        }

        public l1 a() {
            return new l1(this.f20319a, this.f20320b, this.f20321c, this.f20322d);
        }

        public b b(int i11) {
            this.f20319a = i11;
            return this;
        }

        public b c(int i11) {
            this.f20320b = i11;
            return this;
        }

        public b d(int i11) {
            this.f20321c = i11;
            return this;
        }
    }

    private l1(int i11, int i12, int i13, int i14) {
        this.f20314a = i11;
        this.f20315b = i12;
        this.f20316c = i13;
        this.f20317d = i14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l1 a(Bundle bundle) {
        b bVar = new b();
        if (bundle.containsKey(a(0))) {
            bVar.b(bundle.getInt(a(0)));
        }
        if (bundle.containsKey(a(1))) {
            bVar.c(bundle.getInt(a(1)));
        }
        if (bundle.containsKey(a(2))) {
            bVar.d(bundle.getInt(a(2)));
        }
        if (bundle.containsKey(a(3))) {
            bVar.a(bundle.getInt(a(3)));
        }
        return bVar.a();
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public AudioAttributes a() {
        if (this.f20318f == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f20314a).setFlags(this.f20315b).setUsage(this.f20316c);
            if (xp.f24372a >= 29) {
                usage.setAllowedCapturePolicy(this.f20317d);
            }
            this.f20318f = usage.build();
        }
        return this.f20318f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l1.class != obj.getClass()) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f20314a == l1Var.f20314a && this.f20315b == l1Var.f20315b && this.f20316c == l1Var.f20316c && this.f20317d == l1Var.f20317d;
    }

    public int hashCode() {
        return ((((((this.f20314a + 527) * 31) + this.f20315b) * 31) + this.f20316c) * 31) + this.f20317d;
    }
}
