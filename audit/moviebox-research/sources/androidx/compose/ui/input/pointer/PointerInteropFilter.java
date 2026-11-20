package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PointerInteropFilter implements g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f4640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n0 f4641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0 f4643e = new PointerInteropFilter$pointerInputFilter$1(this);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum DispatchToViewState {
        Unknown,
        Dispatching,
        NotDispatching
    }

    public final boolean a() {
        return this.f4642d;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.input.pointer.g0
    public f0 j() {
        return this.f4643e;
    }

    public final Function1<MotionEvent, Boolean> o() {
        Function1 function1 = this.f4640b;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.y("onTouchEvent");
        return null;
    }

    public final void p(boolean z11) {
        this.f4642d = z11;
    }

    public final void q(Function1<? super MotionEvent, Boolean> function1) {
        this.f4640b = function1;
    }

    public final void r(n0 n0Var) {
        n0 n0Var2 = this.f4641c;
        if (n0Var2 != null) {
            n0Var2.b(null);
        }
        this.f4641c = n0Var;
        if (n0Var == null) {
            return;
        }
        n0Var.b(this);
    }
}
