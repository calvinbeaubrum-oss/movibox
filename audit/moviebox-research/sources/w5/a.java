package w5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f79288a = new c0();

    public static y3.a e(c0 c0Var, int i11) {
        CharSequence charSequenceQ = null;
        y3.a.b bVarO = null;
        while (i11 > 0) {
            z3.a.b(i11 >= 8, "Incomplete vtt cue box header found.");
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            int i12 = iQ - 8;
            String strI = u0.I(c0Var.e(), c0Var.f(), i12);
            c0Var.V(i12);
            i11 = (i11 - 8) - i12;
            if (iQ2 == 1937011815) {
                bVarO = e.o(strI);
            } else if (iQ2 == 1885436268) {
                charSequenceQ = e.q(null, strI.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return bVarO != null ? bVarO.o(charSequenceQ).a() : e.l(charSequenceQ);
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
        this.f79288a.S(bArr, i12 + i11);
        this.f79288a.U(i11);
        ArrayList arrayList = new ArrayList();
        while (this.f79288a.a() > 0) {
            z3.a.b(this.f79288a.a() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iQ = this.f79288a.q();
            if (this.f79288a.q() == 1987343459) {
                arrayList.add(e(this.f79288a, iQ - 8));
            } else {
                this.f79288a.V(iQ - 8);
            }
        }
        hVar.accept(new o5.e(arrayList, C.TIME_UNSET, C.TIME_UNSET));
    }

    @Override // o5.s
    public int d() {
        return 2;
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
