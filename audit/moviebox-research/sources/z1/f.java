package z1;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.x1;
import java.util.List;
import q2.p;
import q2.u;
import y1.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f {
    static {
        g.a aVar = g.f81712v8;
    }

    public static long a(g gVar) {
        return n.b(gVar.Q0().i());
    }

    public static long b(g gVar) {
        return gVar.Q0().i();
    }

    public static long c(g gVar, long j11, long j12) {
        return n.a(y1.m.i(j11) - y1.g.m(j12), y1.m.g(j11) - y1.g.n(j12));
    }

    public static /* synthetic */ void d(g gVar, long j11, float f11, long j12, float f12, h hVar, x1 x1Var, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        gVar.I0(j11, (i12 & 2) != 0 ? y1.m.h(gVar.i()) / 2.0f : f11, (i12 & 4) != 0 ? gVar.T0() : j12, (i12 & 8) != 0 ? 1.0f : f12, (i12 & 16) != 0 ? l.f81716a : hVar, (i12 & 32) != 0 ? null : x1Var, (i12 & 64) != 0 ? g.f81712v8.a() : i11);
    }

    public static /* synthetic */ void e(g gVar, g4 g4Var, long j11, long j12, long j13, long j14, float f11, h hVar, x1 x1Var, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long jA = (i13 & 2) != 0 ? p.f74244b.a() : j11;
        long jA2 = (i13 & 4) != 0 ? u.a(g4Var.getWidth(), g4Var.getHeight()) : j12;
        gVar.c1(g4Var, jA, jA2, (i13 & 8) != 0 ? p.f74244b.a() : j13, (i13 & 16) != 0 ? jA2 : j14, (i13 & 32) != 0 ? 1.0f : f11, (i13 & 64) != 0 ? l.f81716a : hVar, (i13 & 128) != 0 ? null : x1Var, (i13 & 256) != 0 ? g.f81712v8.a() : i11, (i13 & 512) != 0 ? g.f81712v8.b() : i12);
    }

    public static /* synthetic */ void f(g gVar, long j11, long j12, long j13, float f11, int i11, r4 r4Var, float f12, x1 x1Var, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        gVar.z0(j11, j12, j13, (i13 & 8) != 0 ? 0.0f : f11, (i13 & 16) != 0 ? m.f81717f.a() : i11, (i13 & 32) != 0 ? null : r4Var, (i13 & 64) != 0 ? 1.0f : f12, (i13 & 128) != 0 ? null : x1Var, (i13 & 256) != 0 ? g.f81712v8.a() : i12);
    }

    public static /* synthetic */ void g(g gVar, Path path, l1 l1Var, float f11, h hVar, x1 x1Var, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        float f12 = (i12 & 4) != 0 ? 1.0f : f11;
        if ((i12 & 8) != 0) {
            hVar = l.f81716a;
        }
        h hVar2 = hVar;
        if ((i12 & 16) != 0) {
            x1Var = null;
        }
        x1 x1Var2 = x1Var;
        if ((i12 & 32) != 0) {
            i11 = g.f81712v8.a();
        }
        gVar.N(path, l1Var, f12, hVar2, x1Var2, i11);
    }

    public static /* synthetic */ void h(g gVar, List list, int i11, long j11, float f11, int i12, r4 r4Var, float f12, x1 x1Var, int i13, int i14, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }
        gVar.P0(list, i11, j11, (i14 & 8) != 0 ? 0.0f : f11, (i14 & 16) != 0 ? e5.f4128a.a() : i12, (i14 & 32) != 0 ? null : r4Var, (i14 & 64) != 0 ? 1.0f : f12, (i14 & 128) != 0 ? null : x1Var, (i14 & 256) != 0 ? g.f81712v8.a() : i13);
    }

    public static /* synthetic */ void i(g gVar, l1 l1Var, long j11, long j12, float f11, h hVar, x1 x1Var, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long jC = (i12 & 2) != 0 ? y1.g.f81070b.c() : j11;
        gVar.G0(l1Var, jC, (i12 & 4) != 0 ? c(gVar, gVar.i(), jC) : j12, (i12 & 8) != 0 ? 1.0f : f11, (i12 & 16) != 0 ? l.f81716a : hVar, (i12 & 32) != 0 ? null : x1Var, (i12 & 64) != 0 ? g.f81712v8.a() : i11);
    }

    public static /* synthetic */ void j(g gVar, long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long jC = (i12 & 2) != 0 ? y1.g.f81070b.c() : j12;
        gVar.C0(j11, jC, (i12 & 4) != 0 ? c(gVar, gVar.i(), jC) : j13, (i12 & 8) != 0 ? 1.0f : f11, (i12 & 16) != 0 ? l.f81716a : hVar, (i12 & 32) != 0 ? null : x1Var, (i12 & 64) != 0 ? g.f81712v8.a() : i11);
    }

    public static /* synthetic */ void k(g gVar, l1 l1Var, long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long jC = (i12 & 2) != 0 ? y1.g.f81070b.c() : j11;
        gVar.P(l1Var, jC, (i12 & 4) != 0 ? c(gVar, gVar.i(), jC) : j12, (i12 & 8) != 0 ? y1.a.f81064a.a() : j13, (i12 & 16) != 0 ? 1.0f : f11, (i12 & 32) != 0 ? l.f81716a : hVar, (i12 & 64) != 0 ? null : x1Var, (i12 & 128) != 0 ? g.f81712v8.a() : i11);
    }
}
