package androidx.compose.ui.text.style;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class TextForegroundStyle$CC {
    public static l a(final l lVar, l lVar2) {
        boolean z11 = lVar2 instanceof b;
        if (z11 && (lVar instanceof b)) {
            return new b(((b) lVar2).e(), k.c(lVar2.getAlpha(), new Function0<Float>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(lVar.getAlpha());
                }
            }));
        }
        if (!z11 || (lVar instanceof b)) {
            return (z11 || !(lVar instanceof b)) ? lVar2.b(new Function0<l>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final l invoke() {
                    return lVar;
                }
            }) : lVar;
        }
        return lVar2;
    }

    public static l b(l lVar, Function0 function0) {
        return !Intrinsics.b(lVar, l.b.f6125b) ? lVar : (l) function0.invoke();
    }
}
