package h;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.a f65677c;

    public g(int i11, int i12, rb.a aVar) {
        super(0);
        this.f65675a = i11;
        this.f65676b = i12;
        this.f65677c = aVar;
        if ((i11 & i12) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values".toString());
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat animation) {
        Intrinsics.g(animation, "animation");
        rb.a aVar = this.f65677c;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnims) {
        Intrinsics.g(insets, "insets");
        Intrinsics.g(runningAnims, "runningAnims");
        c3.c insets2 = insets.getInsets(this.f65676b);
        Intrinsics.f(insets2, "insets.getInsets(deferredInsetTypes)");
        c3.c insets3 = insets.getInsets(this.f65675a);
        Intrinsics.f(insets3, "insets.getInsets(persistentInsetTypes)");
        c3.c cVarA = c3.c.a(c3.c.d(insets2, insets3), c3.c.f14553e);
        Intrinsics.f(cVarA, "subtract(typesInset, oth…t, Insets.NONE)\n        }");
        rb.a aVar = this.f65677c;
        if (aVar != null) {
            aVar.a(cVarA.f14557d);
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.g(animation, "animation");
        Intrinsics.g(bounds, "bounds");
        rb.a aVar = this.f65677c;
        if (aVar != null) {
            aVar.b();
        }
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        Intrinsics.f(boundsCompatOnStart, "super.onStart(animation, bounds)");
        return boundsCompatOnStart;
    }
}
