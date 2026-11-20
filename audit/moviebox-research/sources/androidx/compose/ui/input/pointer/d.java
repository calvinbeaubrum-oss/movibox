package androidx.compose.ui.input.pointer;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ Object a(e eVar, PointerEventPass pointerEventPass, Continuation continuation, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
        if ((i11 & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return eVar.v0(pointerEventPass, continuation);
    }
}
