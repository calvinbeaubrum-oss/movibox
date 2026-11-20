package m5;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.io.IOException;
import java.util.Arrays;
import u4.t;
import u4.v;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f70814a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f70815b = new c0(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70816c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f70818e;

    public final int a(int i11) {
        int i12;
        int i13 = 0;
        this.f70817d = 0;
        do {
            int i14 = this.f70817d;
            int i15 = i11 + i14;
            f fVar = this.f70814a;
            if (i15 >= fVar.f70825g) {
                break;
            }
            int[] iArr = fVar.f70828j;
            this.f70817d = i14 + 1;
            i12 = iArr[i14 + i11];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public f b() {
        return this.f70814a;
    }

    public c0 c() {
        return this.f70815b;
    }

    public boolean d(t tVar) throws IOException {
        int i11;
        z3.a.g(tVar != null);
        if (this.f70818e) {
            this.f70818e = false;
            this.f70815b.Q(0);
        }
        while (!this.f70818e) {
            if (this.f70816c < 0) {
                if (!this.f70814a.c(tVar) || !this.f70814a.a(tVar, true)) {
                    return false;
                }
                f fVar = this.f70814a;
                int iA = fVar.f70826h;
                if ((fVar.f70820b & 1) == 1 && this.f70815b.g() == 0) {
                    iA += a(0);
                    i11 = this.f70817d;
                } else {
                    i11 = 0;
                }
                if (!v.e(tVar, iA)) {
                    return false;
                }
                this.f70816c = i11;
            }
            int iA2 = a(this.f70816c);
            int i12 = this.f70816c + this.f70817d;
            if (iA2 > 0) {
                c0 c0Var = this.f70815b;
                c0Var.c(c0Var.g() + iA2);
                if (!v.d(tVar, this.f70815b.e(), this.f70815b.g(), iA2)) {
                    return false;
                }
                c0 c0Var2 = this.f70815b;
                c0Var2.T(c0Var2.g() + iA2);
                this.f70818e = this.f70814a.f70828j[i12 + (-1)] != 255;
            }
            if (i12 == this.f70814a.f70825g) {
                i12 = -1;
            }
            this.f70816c = i12;
        }
        return true;
    }

    public void e() {
        this.f70814a.b();
        this.f70815b.Q(0);
        this.f70816c = -1;
        this.f70818e = false;
    }

    public void f() {
        if (this.f70815b.e().length == 65025) {
            return;
        }
        c0 c0Var = this.f70815b;
        c0Var.S(Arrays.copyOf(c0Var.e(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f70815b.g())), this.f70815b.g());
    }
}
