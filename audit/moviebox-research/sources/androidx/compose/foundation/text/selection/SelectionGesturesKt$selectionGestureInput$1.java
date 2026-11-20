package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.q;
import androidx.compose.ui.input.pointer.t;
import androidx.compose.ui.input.pointer.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1", f = "SelectionGestures.kt", l = {104}, m = "invokeSuspend")
public final class SelectionGesturesKt$selectionGestureInput$1 extends SuspendLambda implements Function2<h0, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $mouseSelectionObserver;
    final /* synthetic */ androidx.compose.foundation.text.c $textDragObserver;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", l = {105, 111, 113}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $clicksCounter;
        final /* synthetic */ b $mouseSelectionObserver;
        final /* synthetic */ androidx.compose.foundation.text.c $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(b bVar, a aVar, androidx.compose.foundation.text.c cVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mouseSelectionObserver = bVar;
            this.$clicksCounter = aVar;
            this.$textDragObserver = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x007d  */
        /* JADX WARN: Code duplicated, block: B:32:0x0089 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            androidx.compose.ui.input.pointer.e eVar;
            androidx.compose.foundation.text.c cVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    eVar = (androidx.compose.ui.input.pointer.e) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            eVar = (androidx.compose.ui.input.pointer.e) this.L$0;
            this.L$0 = eVar;
            this.label = 1;
            obj = SelectionGesturesKt.e(eVar, this);
            if (obj == objE) {
                return objE;
            }
            q qVar = (q) obj;
            if (SelectionGesturesKt.g(qVar) && t.b(qVar.b())) {
                List<z> listC = qVar.c();
                int size = listC.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size) {
                        b bVar = this.$mouseSelectionObserver;
                        a aVar = this.$clicksCounter;
                        this.L$0 = null;
                        this.label = 2;
                        if (SelectionGesturesKt.h(eVar, bVar, aVar, qVar, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (!(!listC.get(i12).p())) {
                            break;
                        }
                        i12++;
                    }
                }
                if (!SelectionGesturesKt.g(qVar)) {
                    cVar = this.$textDragObserver;
                    this.L$0 = null;
                    this.label = 3;
                    if (SelectionGesturesKt.j(eVar, cVar, qVar, this) == objE) {
                        return objE;
                    }
                }
            } else if (!SelectionGesturesKt.g(qVar)) {
                cVar = this.$textDragObserver;
                this.L$0 = null;
                this.label = 3;
                if (SelectionGesturesKt.j(eVar, cVar, qVar, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionGesturesKt$selectionGestureInput$1(b bVar, androidx.compose.foundation.text.c cVar, Continuation<? super SelectionGesturesKt$selectionGestureInput$1> continuation) {
        super(2, continuation);
        this.$mouseSelectionObserver = bVar;
        this.$textDragObserver = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionGesturesKt$selectionGestureInput$1 selectionGesturesKt$selectionGestureInput$1 = new SelectionGesturesKt$selectionGestureInput$1(this.$mouseSelectionObserver, this.$textDragObserver, continuation);
        selectionGesturesKt$selectionGestureInput$1.L$0 = obj;
        return selectionGesturesKt$selectionGestureInput$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(h0 h0Var, Continuation<? super Unit> continuation) {
        return ((SelectionGesturesKt$selectionGestureInput$1) create(h0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            h0 h0Var = (h0) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, new a(h0Var.getViewConfiguration()), this.$textDragObserver, null);
            this.label = 1;
            if (ForEachGestureKt.c(h0Var, anonymousClass1, this) == objE) {
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
