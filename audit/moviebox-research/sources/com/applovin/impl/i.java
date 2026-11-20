package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements k8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o8 f19554d = new o8() { // from class: com.applovin.impl.jy
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return i.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f19555a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19556b = new bh(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19557c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new i()};
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        int iA = l8Var.a(this.f19556b.c(), 0, 2786);
        if (iA == -1) {
            return -1;
        }
        this.f19556b.f(0);
        this.f19556b.e(iA);
        if (!this.f19557c) {
            this.f19555a.a(0L, 4);
            this.f19557c = true;
        }
        this.f19555a.a(this.f19556b);
        return 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f19557c = false;
        this.f19555a.a();
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f19555a.a(m8Var, new dp.d(0, 1));
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
                l8Var.c(bhVar.c(), 0, 6);
                bhVar.f(0);
                if (bhVar.C() != 2935) {
                    break;
                }
                i13++;
                if (i13 >= 4) {
                    return true;
                }
                int iA = k.a(bhVar.c());
                if (iA == -1) {
                    return false;
                }
                l8Var.c(iA - 6);
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
