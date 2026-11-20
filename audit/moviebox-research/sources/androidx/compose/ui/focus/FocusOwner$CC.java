package androidx.compose.ui.focus;

import android.view.KeyEvent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.compose.ui.focus.FocusOwner$-CC, reason: invalid class name */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class FocusOwner$CC {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean a(k kVar, KeyEvent keyEvent, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i11 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return kVar.h(keyEvent, function0);
    }
}
