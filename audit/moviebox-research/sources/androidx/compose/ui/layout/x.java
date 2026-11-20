package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class x {
    public static w a(y yVar, int i11, int i12, Map map, Function1 function1) {
        return yVar.S0(i11, i12, map, null, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ w b(y yVar, int i11, int i12, Map map, Function1 function1, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i13 & 4) != 0) {
            map = kotlin.collections.s.h();
        }
        return yVar.y0(i11, i12, map, function1);
    }
}
