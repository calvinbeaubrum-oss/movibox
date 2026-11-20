package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements k8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o8 f20294d = new o8() { // from class: com.applovin.impl.jz
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return l.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f20295a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f20296b = new bh(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20297c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new l()};
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        int iA = l8Var.a(this.f20296b.c(), 0, 16384);
        if (iA == -1) {
            return -1;
        }
        this.f20296b.f(0);
        this.f20296b.e(iA);
        if (!this.f20297c) {
            this.f20295a.a(0L, 4);
            this.f20297c = true;
        }
        this.f20295a.a(this.f20296b);
        return 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f20297c = false;
        this.f20295a.a();
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f20295a.a(m8Var, new dp.d(0, 1));
        m8Var.c();
        m8Var.a(new ij.b(C.TIME_UNSET));
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        bh bhVar = new bh(10);
        int i11 = 0;
        while (true) {
            l8Var.c(bhVar.c(), 0, 10);
            bhVar.f(0);
            if (bhVar.z() != 4801587) {
                break;
            }
            bhVar.g(3);
            int iV = bhVar.v();
            i11 += iV + 10;
            l8Var.c(iV);
        }
        l8Var.b();
        l8Var.c(i11);
        int i12 = i11;
        while (true) {
            int i13 = 0;
            while (true) {
                l8Var.c(bhVar.c(), 0, 7);
                bhVar.f(0);
                int iC = bhVar.C();
                if (iC == 44096 || iC == 44097) {
                    i13++;
                    if (i13 >= 4) {
                        return true;
                    }
                    int iA = n.a(bhVar.c(), iC);
                    if (iA == -1) {
                        return false;
                    }
                    l8Var.c(iA - 7);
                }
            }
            l8Var.b();
            i12++;
            if (i12 - i11 >= 8192) {
                return false;
            }
            l8Var.c(i12);
        }
    }
}
