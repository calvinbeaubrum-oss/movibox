package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n1 {
    public static void a(o1 o1Var, y1.i iVar, int i11) {
        o1Var.a(iVar.f(), iVar.i(), iVar.g(), iVar.c(), i11);
    }

    public static void b(o1 o1Var, y1.i iVar, o4 o4Var) {
        o1Var.f(iVar.f(), iVar.i(), iVar.g(), iVar.c(), o4Var);
    }

    public static /* synthetic */ void c(o1 o1Var, Path path, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i12 & 2) != 0) {
            i11 = v1.f4361a.b();
        }
        o1Var.b(path, i11);
    }

    public static /* synthetic */ void d(o1 o1Var, float f11, float f12, float f13, float f14, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i12 & 16) != 0) {
            i11 = v1.f4361a.b();
        }
        o1Var.a(f11, f12, f13, f14, i11);
    }

    public static /* synthetic */ void e(o1 o1Var, y1.i iVar, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i12 & 2) != 0) {
            i11 = v1.f4361a.b();
        }
        o1Var.i(iVar, i11);
    }
}
