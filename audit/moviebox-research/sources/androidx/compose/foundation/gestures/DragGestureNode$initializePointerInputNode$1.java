package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.r2;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import q2.a0;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", l = {524}, m = "invokeSuspend")
public final class DragGestureNode$initializePointerInputNode$1 extends SuspendLambda implements Function2<h0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", l = {526}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ h0 $$this$SuspendingPointerInputModifierNode;
        final /* synthetic */ Function2<z, y1.g, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<z, Unit> $onDragEnd;
        final /* synthetic */ Function3<z, z, y1.g, Unit> $onDragStart;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DragGestureNode dragGestureNode, h0 h0Var, Function3<? super z, ? super z, ? super y1.g, Unit> function3, Function1<? super z, Unit> function1, Function0<Unit> function0, Function0<Boolean> function2, Function2<? super z, ? super y1.g, Unit> function4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = dragGestureNode;
            this.$$this$SuspendingPointerInputModifierNode = h0Var;
            this.$onDragStart = function3;
            this.$onDragEnd = function1;
            this.$onDragCancel = function0;
            this.$shouldAwaitTouchSlop = function2;
            this.$onDrag = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        /* JADX WARN: Code duplicated, block: B:25:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            k0 k0Var;
            CancellationException e11;
            kotlinx.coroutines.channels.a aVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                k0 k0Var2 = (k0) this.L$0;
                try {
                    Orientation orientation = this.this$0.f2305q;
                    h0 h0Var = this.$$this$SuspendingPointerInputModifierNode;
                    Function3<z, z, y1.g, Unit> function3 = this.$onDragStart;
                    Function1<z, Unit> function1 = this.$onDragEnd;
                    Function0<Unit> function0 = this.$onDragCancel;
                    Function0<Boolean> function2 = this.$shouldAwaitTouchSlop;
                    Function2<z, y1.g, Unit> function4 = this.$onDrag;
                    this.L$0 = k0Var2;
                    this.label = 1;
                    if (DragGestureDetectorKt.d(h0Var, function3, function1, function0, function2, orientation, function4, this) == objE) {
                        return objE;
                    }
                } catch (CancellationException e12) {
                    k0Var = k0Var2;
                    e11 = e12;
                    aVar = this.this$0.f2310v;
                    if (aVar != null) {
                        kotlinx.coroutines.channels.e.b(aVar.f(e.a.f2362a));
                    }
                    if (!l0.f(k0Var)) {
                        throw e11;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k0Var = (k0) this.L$0;
                try {
                    ResultKt.b(obj);
                } catch (CancellationException e13) {
                    e11 = e13;
                    aVar = this.this$0.f2310v;
                    if (aVar != null) {
                        kotlinx.coroutines.channels.e.b(aVar.f(e.a.f2362a));
                    }
                    if (!l0.f(k0Var)) {
                        throw e11;
                    }
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$initializePointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$initializePointerInputNode$1 dragGestureNode$initializePointerInputNode$1 = new DragGestureNode$initializePointerInputNode$1(this.this$0, continuation);
        dragGestureNode$initializePointerInputNode$1.L$0 = obj;
        return dragGestureNode$initializePointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(h0 h0Var, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$initializePointerInputNode$1) create(h0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            h0 h0Var = (h0) this.L$0;
            final androidx.compose.ui.input.pointer.util.a aVar = new androidx.compose.ui.input.pointer.util.a();
            final DragGestureNode dragGestureNode = this.this$0;
            Function3<z, z, y1.g, Unit> function3 = new Function3<z, z, y1.g, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(z zVar, z zVar2, y1.g gVar) {
                    m19invoke0AR0LA0(zVar, zVar2, gVar.v());
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke-0AR0LA0, reason: not valid java name */
                public final void m19invoke0AR0LA0(z zVar, z zVar2, long j11) {
                    if (dragGestureNode.X1().invoke(zVar).booleanValue()) {
                        if (!dragGestureNode.f2312x) {
                            if (dragGestureNode.f2310v == null) {
                                dragGestureNode.f2310v = kotlinx.coroutines.channels.d.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
                            }
                            dragGestureNode.g2();
                        }
                        f2.c.c(aVar, zVar);
                        long jQ = y1.g.q(zVar2.h(), j11);
                        kotlinx.coroutines.channels.a aVar2 = dragGestureNode.f2310v;
                        if (aVar2 != null) {
                            kotlinx.coroutines.channels.e.b(aVar2.f(new e.c(jQ, null)));
                        }
                    }
                }
            };
            final DragGestureNode dragGestureNode2 = this.this$0;
            Function1<z, Unit> function1 = new Function1<z, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(z zVar) {
                    invoke2(zVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(z zVar) {
                    f2.c.c(aVar, zVar);
                    float fE = ((r2) androidx.compose.ui.node.e.a(dragGestureNode2, CompositionLocalsKt.k())).e();
                    long jB = aVar.b(a0.a(fE, fE));
                    aVar.e();
                    kotlinx.coroutines.channels.a aVar2 = dragGestureNode2.f2310v;
                    if (aVar2 != null) {
                        kotlinx.coroutines.channels.e.b(aVar2.f(new e.d(DraggableKt.b(jB), null)));
                    }
                }
            };
            final DragGestureNode dragGestureNode3 = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    kotlinx.coroutines.channels.a aVar2 = dragGestureNode3.f2310v;
                    if (aVar2 != null) {
                        kotlinx.coroutines.channels.e.b(aVar2.f(e.a.f2362a));
                    }
                }
            };
            final DragGestureNode dragGestureNode4 = this.this$0;
            Function0<Boolean> function2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(!dragGestureNode4.f2());
                }
            };
            final DragGestureNode dragGestureNode5 = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, h0Var, function3, function1, function0, function2, new Function2<z, y1.g, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(z zVar, y1.g gVar) {
                    m18invokeUv8p0NA(zVar, gVar.v());
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m18invokeUv8p0NA(z zVar, long j11) {
                    f2.c.c(aVar, zVar);
                    kotlinx.coroutines.channels.a aVar2 = dragGestureNode5.f2310v;
                    if (aVar2 != null) {
                        kotlinx.coroutines.channels.e.b(aVar2.f(new e.b(j11, null)));
                    }
                }
            }, null);
            this.label = 1;
            if (l0.e(anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
