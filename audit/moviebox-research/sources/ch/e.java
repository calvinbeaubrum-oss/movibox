package ch;

import com.google.android.exoplayer2.util.c0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.io.IOException;
import java.util.Arrays;
import tg.m;
import tg.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14810a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f14811b = new c0(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14812c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14814e;

    public final int a(int i11) {
        int i12;
        int i13 = 0;
        this.f14813d = 0;
        do {
            int i14 = this.f14813d;
            int i15 = i11 + i14;
            f fVar = this.f14810a;
            if (i15 >= fVar.f14821g) {
                break;
            }
            int[] iArr = fVar.f14824j;
            this.f14813d = i14 + 1;
            i12 = iArr[i14 + i11];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public f b() {
        return this.f14810a;
    }

    public c0 c() {
        return this.f14811b;
    }

    public boolean d(m mVar) throws IOException {
        int i11;
        com.google.android.exoplayer2.util.a.g(mVar != null);
        if (this.f14814e) {
            this.f14814e = false;
            this.f14811b.L(0);
        }
        while (!this.f14814e) {
            if (this.f14812c < 0) {
                if (!this.f14810a.c(mVar) || !this.f14810a.a(mVar, true)) {
                    return false;
                }
                f fVar = this.f14810a;
                int iA = fVar.f14822h;
                if ((fVar.f14816b & 1) == 1 && this.f14811b.f() == 0) {
                    iA += a(0);
                    i11 = this.f14813d;
                } else {
                    i11 = 0;
                }
                if (!o.e(mVar, iA)) {
                    return false;
                }
                this.f14812c = i11;
            }
            int iA2 = a(this.f14812c);
            int i12 = this.f14812c + this.f14813d;
            if (iA2 > 0) {
                c0 c0Var = this.f14811b;
                c0Var.c(c0Var.f() + iA2);
                if (!o.d(mVar, this.f14811b.d(), this.f14811b.f(), iA2)) {
                    return false;
                }
                c0 c0Var2 = this.f14811b;
                c0Var2.O(c0Var2.f() + iA2);
                this.f14814e = this.f14810a.f14824j[i12 + (-1)] != 255;
            }
            if (i12 == this.f14810a.f14821g) {
                i12 = -1;
            }
            this.f14812c = i12;
        }
        return true;
    }

    public void e() {
        this.f14810a.b();
        this.f14811b.L(0);
        this.f14812c = -1;
        this.f14814e = false;
    }

    public void f() {
        if (this.f14811b.d().length == 65025) {
            return;
        }
        c0 c0Var = this.f14811b;
        c0Var.N(Arrays.copyOf(c0Var.d(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f14811b.f())), this.f14811b.f());
    }
}
