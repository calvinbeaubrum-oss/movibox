package vm;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hm.b f79004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f79005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f79006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f79007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f79008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f79009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f79010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f79012i;

    public c(hm.b bVar, k kVar, k kVar2, k kVar3, k kVar4) throws NotFoundException {
        boolean z11 = kVar == null || kVar2 == null;
        boolean z12 = kVar3 == null || kVar4 == null;
        if (z11 && z12) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z11) {
            kVar = new k(0.0f, kVar3.d());
            kVar2 = new k(0.0f, kVar4.d());
        } else if (z12) {
            kVar3 = new k(bVar.n() - 1, kVar.d());
            kVar4 = new k(bVar.n() - 1, kVar2.d());
        }
        this.f79004a = bVar;
        this.f79005b = kVar;
        this.f79006c = kVar2;
        this.f79007d = kVar3;
        this.f79008e = kVar4;
        this.f79009f = (int) Math.min(kVar.c(), kVar2.c());
        this.f79010g = (int) Math.max(kVar3.c(), kVar4.c());
        this.f79011h = (int) Math.min(kVar.d(), kVar3.d());
        this.f79012i = (int) Math.max(kVar2.d(), kVar4.d());
    }

    public c(c cVar) {
        this.f79004a = cVar.f79004a;
        this.f79005b = cVar.f79005b;
        this.f79006c = cVar.f79006c;
        this.f79007d = cVar.f79007d;
        this.f79008e = cVar.f79008e;
        this.f79009f = cVar.f79009f;
        this.f79010g = cVar.f79010g;
        this.f79011h = cVar.f79011h;
        this.f79012i = cVar.f79012i;
    }

    public static c j(c cVar, c cVar2) throws NotFoundException {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.f79004a, cVar.f79005b, cVar.f79006c, cVar2.f79007d, cVar2.f79008e);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    public c a(int i11, int i12, boolean z11) throws NotFoundException {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        int iD;
        k kVar6;
        k kVar7 = this.f79005b;
        k kVar8 = this.f79006c;
        k kVar9 = this.f79007d;
        k kVar10 = this.f79008e;
        if (i11 > 0) {
            k kVar11 = z11 ? kVar7 : kVar9;
            int iD2 = ((int) kVar11.d()) - i11;
            if (iD2 < 0) {
                iD2 = 0;
            }
            k kVar12 = new k(kVar11.c(), iD2);
            if (z11) {
                kVar = kVar12;
            } else {
                kVar2 = kVar12;
                kVar = kVar7;
            }
            if (i12 > 0) {
                if (z11) {
                    kVar5 = this.f79006c;
                } else {
                    kVar5 = this.f79008e;
                }
                iD = ((int) kVar5.d()) + i12;
                if (iD >= this.f79004a.k()) {
                    iD = this.f79004a.k() - 1;
                }
                kVar6 = new k(kVar5.c(), iD);
                if (z11) {
                    kVar3 = kVar6;
                } else {
                    kVar4 = kVar6;
                    kVar3 = kVar8;
                }
                return new c(this.f79004a, kVar, kVar3, kVar2, kVar4);
            }
            kVar3 = kVar8;
            kVar4 = kVar10;
            return new c(this.f79004a, kVar, kVar3, kVar2, kVar4);
        }
        kVar = kVar7;
        kVar2 = kVar9;
        if (i12 > 0) {
            if (z11) {
                kVar5 = this.f79006c;
            } else {
                kVar5 = this.f79008e;
            }
            iD = ((int) kVar5.d()) + i12;
            if (iD >= this.f79004a.k()) {
                iD = this.f79004a.k() - 1;
            }
            kVar6 = new k(kVar5.c(), iD);
            if (z11) {
                kVar3 = kVar6;
            } else {
                kVar4 = kVar6;
                kVar3 = kVar8;
            }
            return new c(this.f79004a, kVar, kVar3, kVar2, kVar4);
        }
        kVar3 = kVar8;
        kVar4 = kVar10;
        return new c(this.f79004a, kVar, kVar3, kVar2, kVar4);
    }

    public k b() {
        return this.f79006c;
    }

    public k c() {
        return this.f79008e;
    }

    public int d() {
        return this.f79010g;
    }

    public int e() {
        return this.f79012i;
    }

    public int f() {
        return this.f79009f;
    }

    public int g() {
        return this.f79011h;
    }

    public k h() {
        return this.f79005b;
    }

    public k i() {
        return this.f79007d;
    }
}
