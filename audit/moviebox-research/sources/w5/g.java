package w5;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import java.util.ArrayList;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f79337a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f79338b = new b();

    public static int e(c0 c0Var) {
        int i11 = -1;
        int iF = 0;
        while (i11 == -1) {
            iF = c0Var.f();
            String strS = c0Var.s();
            if (strS == null) {
                i11 = 0;
            } else if ("STYLE".equals(strS)) {
                i11 = 2;
            } else {
                i11 = strS.startsWith("NOTE") ? 1 : 3;
            }
        }
        c0Var.U(iF);
        return i11;
    }

    public static void f(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.s())) {
        }
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, z3.h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.b(this, bArr, i11, i12);
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, z3.h<o5.e> hVar) {
        d dVarN;
        this.f79337a.S(bArr, i12 + i11);
        this.f79337a.U(i11);
        ArrayList arrayList = new ArrayList();
        try {
            h.e(this.f79337a);
            while (!TextUtils.isEmpty(this.f79337a.s())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iE = e(this.f79337a);
                if (iE == 0) {
                    o5.i.c(new j(arrayList2), bVar, hVar);
                    return;
                }
                if (iE == 1) {
                    f(this.f79337a);
                } else if (iE == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.f79337a.s();
                    arrayList.addAll(this.f79338b.d(this.f79337a));
                } else if (iE == 3 && (dVarN = e.n(this.f79337a, arrayList)) != null) {
                    arrayList2.add(dVarN);
                }
            }
        } catch (ParserException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @Override // o5.s
    public int d() {
        return 1;
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
