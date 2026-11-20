package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q4 {
    static {
        Path.a aVar = Path.f3960a;
    }

    public static /* synthetic */ void a(Path path, y1.i iVar, Path.Direction direction, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i11 & 2) != 0) {
            direction = Path.Direction.CounterClockwise;
        }
        path.h(iVar, direction);
    }

    public static /* synthetic */ void b(Path path, y1.k kVar, Path.Direction direction, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i11 & 2) != 0) {
            direction = Path.Direction.CounterClockwise;
        }
        path.g(kVar, direction);
    }
}
