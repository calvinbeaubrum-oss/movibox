package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CombinedClickableNodeImpl extends AbstractClickableNode {
    public String K;
    public Function0<Unit> L;
    public Function0<Unit> M;

    public CombinedClickableNodeImpl(Function0<Unit> function0, String str, Function0<Unit> function1, Function0<Unit> function2, o1.i iVar, b0 b0Var, boolean z11, String str2, androidx.compose.ui.semantics.i iVar2) {
        super(iVar, b0Var, z11, str2, iVar2, function0, null);
        this.K = str;
        this.L = function1;
        this.M = function2;
    }

    public /* synthetic */ CombinedClickableNodeImpl(Function0 function0, String str, Function0 function1, Function0 function2, o1.i iVar, b0 b0Var, boolean z11, String str2, androidx.compose.ui.semantics.i iVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function1, function2, iVar, b0Var, z11, str2, iVar2);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void T1(androidx.compose.ui.semantics.q qVar) {
        if (this.L != null) {
            SemanticsPropertiesKt.m(qVar, this.K, new Function0<Boolean>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$applyAdditionalSemantics$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0 function0 = this.this$0.L;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object U1(androidx.compose.ui.input.pointer.h0 h0Var, Continuation<? super Unit> continuation) {
        Object objI = TapGestureDetectorKt.i(h0Var, (!Z1() || this.M == null) ? null : new Function1<y1.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y1.g gVar) {
                m14invokek4lQ0M(gVar.v());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m14invokek4lQ0M(long j11) {
                Function0 function0 = this.this$0.M;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, (!Z1() || this.L == null) ? null : new Function1<y1.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y1.g gVar) {
                m15invokek4lQ0M(gVar.v());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m15invokek4lQ0M(long j11) {
                Function0 function0 = this.this$0.L;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, new CombinedClickableNodeImpl$clickPointerInput$4(this, null), new Function1<y1.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y1.g gVar) {
                m17invokek4lQ0M(gVar.v());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m17invokek4lQ0M(long j11) {
                if (this.this$0.Z1()) {
                    this.this$0.a2().invoke();
                }
            }
        }, continuation);
        return objI == kotlin.coroutines.intrinsics.a.e() ? objI : Unit.f68710a;
    }

    public void i2(Function0<Unit> function0, String str, Function0<Unit> function1, Function0<Unit> function2, o1.i iVar, b0 b0Var, boolean z11, String str2, androidx.compose.ui.semantics.i iVar2) {
        boolean z12;
        if (!Intrinsics.b(this.K, str)) {
            this.K = str;
            j1.b(this);
        }
        if ((this.L == null) != (function1 == null)) {
            W1();
            j1.b(this);
            z12 = true;
        } else {
            z12 = false;
        }
        this.L = function1;
        if ((this.M == null) != (function2 == null)) {
            z12 = true;
        }
        this.M = function2;
        boolean z13 = Z1() != z11 ? true : z12;
        f2(iVar, b0Var, z11, str2, iVar2, function0);
        if (z13) {
            d2();
        }
    }
}
