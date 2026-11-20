package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", l = {431, 433, 435, 442, 444, 447}, m = "invokeSuspend")
public final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", l = {438}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super e.b, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<e> $event;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref.ObjectRef<e> objectRef, DragGestureNode dragGestureNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = objectRef;
            this.this$0 = dragGestureNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Function1<? super e.b, ? extends Unit> function1, Continuation<? super Unit> continuation) {
            return invoke2((Function1<? super e.b, Unit>) function1, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Function1<? super e.b, Unit> function1, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0034  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:26:0x006a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0063). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1 function1;
            AnonymousClass1 anonymousClass1;
            e eVar;
            T t11;
            Ref.ObjectRef<e> objectRef;
            AnonymousClass1 anonymousClass2;
            Function1 function2;
            Ref.ObjectRef<e> objectRef2;
            Object obj2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                function1 = (Function1) this.L$0;
                anonymousClass1 = this;
                eVar = anonymousClass1.$event.element;
                if (!(eVar instanceof e.d) || (eVar instanceof e.a)) {
                    return Unit.f68710a;
                }
                t11 = 0;
                e.b bVar = eVar instanceof e.b ? (e.b) eVar : null;
                if (bVar != null) {
                    function1.invoke(bVar);
                }
                objectRef = anonymousClass1.$event;
                kotlinx.coroutines.channels.a aVar = anonymousClass1.this$0.f2310v;
                if (aVar != null) {
                    anonymousClass1.L$0 = function1;
                    anonymousClass1.L$1 = objectRef;
                    anonymousClass1.label = 1;
                    Object objO = aVar.o(anonymousClass1);
                    if (objO == objE) {
                        return objE;
                    }
                    Object obj3 = objE;
                    anonymousClass2 = anonymousClass1;
                    obj = objO;
                    function2 = function1;
                    objectRef2 = objectRef;
                    obj2 = obj3;
                }
                objectRef.element = t11;
                eVar = anonymousClass1.$event.element;
                if (eVar instanceof e.d) {
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef<e> objectRef3 = (Ref.ObjectRef) this.L$1;
            Function1 function3 = (Function1) this.L$0;
            ResultKt.b(obj);
            function2 = function3;
            objectRef2 = objectRef3;
            obj2 = objE;
            anonymousClass2 = this;
            e eVar2 = (e) obj;
            anonymousClass1 = anonymousClass2;
            objE = obj2;
            objectRef = objectRef2;
            function1 = function2;
            t11 = eVar2;
            objectRef.element = t11;
            eVar = anonymousClass1.$event.element;
            if (eVar instanceof e.d) {
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$startListeningForEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.this$0, continuation);
        dragGestureNode$startListeningForEvents$1.L$0 = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$startListeningForEvents$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x0093 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:36:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e0 A[Catch: CancellationException -> 0x00f7, TryCatch #3 {CancellationException -> 0x00f7, blocks: (B:42:0x00da, B:44:0x00e0, B:48:0x00fb, B:50:0x00ff), top: B:67:0x00da }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb A[Catch: CancellationException -> 0x00f7, TryCatch #3 {CancellationException -> 0x00f7, blocks: (B:42:0x00da, B:44:0x00e0, B:48:0x00fb, B:50:0x00ff), top: B:67:0x00da }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ff A[Catch: CancellationException -> 0x00f7, TRY_LEAVE, TryCatch #3 {CancellationException -> 0x00f7, blocks: (B:42:0x00da, B:44:0x00e0, B:48:0x00fb, B:50:0x00ff), top: B:67:0x00da }] */
    /* JADX WARN: Code duplicated, block: B:52:0x010e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0125  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f4 -> B:22:0x0071). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00fd -> B:22:0x0071). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x010c -> B:22:0x0071). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0121 -> B:22:0x0071). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0125 -> B:22:0x0071). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:29:0x0094
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
