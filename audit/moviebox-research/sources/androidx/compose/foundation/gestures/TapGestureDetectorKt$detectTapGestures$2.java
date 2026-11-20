package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.z;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", l = {99}, m = "invokeSuspend")
public final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<y1.g, Unit> $onDoubleTap;
    final /* synthetic */ Function1<y1.g, Unit> $onLongPress;
    final /* synthetic */ Function3<i, y1.g, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<y1.g, Unit> $onTap;
    final /* synthetic */ h0 $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", l = {100, 114, TsExtractor.TS_STREAM_TYPE_AC3, 141, 156, 178}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ k0 $$this$coroutineScope;
        final /* synthetic */ Function1<y1.g, Unit> $onDoubleTap;
        final /* synthetic */ Function1<y1.g, Unit> $onLongPress;
        final /* synthetic */ Function3<i, y1.g, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<y1.g, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", l = {Worker.WHAT_SYNC_DATA}, m = "invokeSuspend")
        public static final class C00391 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00391(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00391> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00391(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C00391) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    this.label = 1;
                    if (pressGestureScopeImpl.m(this) == objE) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass10 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass10(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass10> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass10(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass10) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$pressScope.l();
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", l = {106}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ z $down;
            final /* synthetic */ Function3<i, y1.g, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, z zVar, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$down = zVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$onPress, this.$pressScope, this.$down, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    Function3<i, y1.g, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    y1.g gVarD = y1.g.d(this.$down.h());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, gVarD, this) == objE) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", l = {115}, m = "invokeSuspend")
        public static final class AnonymousClass3 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super z>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super z> continuation) {
                return ((AnonymousClass3) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    androidx.compose.ui.input.pointer.e eVar = (androidx.compose.ui.input.pointer.e) this.L$0;
                    this.label = 1;
                    obj = TapGestureDetectorKt.k(eVar, null, this, 1, null);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return obj;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$pressScope.k();
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$pressScope.l();
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass6(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$pressScope.l();
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", l = {148}, m = "invokeSuspend")
        public static final class AnonymousClass7 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass7(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass7) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    this.label = 1;
                    if (pressGestureScopeImpl.m(this) == objE) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", l = {151}, m = "invokeSuspend")
        public static final class AnonymousClass8 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<i, y1.g, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ z $secondDown;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass8(Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, z zVar, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$secondDown = zVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass8(this.$onPress, this.$pressScope, this.$secondDown, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass8) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    Function3<i, y1.g, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    y1.g gVarD = y1.g.d(this.$secondDown.h());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, gVarD, this) == objE) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9", f = "TapGestureDetector.kt", l = {157}, m = "invokeSuspend")
        public static final class AnonymousClass9 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> {
            final /* synthetic */ k0 $$this$coroutineScope;
            final /* synthetic */ Function1<y1.g, Unit> $onDoubleTap;
            final /* synthetic */ Function1<y1.g, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ Ref.ObjectRef<z> $upOrCancel;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class C00401 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00401(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00401> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00401(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((C00401) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    this.$pressScope.l();
                    return Unit.f68710a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    this.$pressScope.k();
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass9(k0 k0Var, Function1<? super y1.g, Unit> function1, Function1<? super y1.g, Unit> function2, Ref.ObjectRef<z> objectRef, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = k0Var;
                this.$onDoubleTap = function1;
                this.$onTap = function2;
                this.$upOrCancel = objectRef;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, this.$pressScope, continuation);
                anonymousClass9.L$0 = obj;
                return anonymousClass9;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super Unit> continuation) {
                return ((AnonymousClass9) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    androidx.compose.ui.input.pointer.e eVar = (androidx.compose.ui.input.pointer.e) this.L$0;
                    this.label = 1;
                    obj = TapGestureDetectorKt.k(eVar, null, this, 1, null);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                z zVar = (z) obj;
                if (zVar != null) {
                    zVar.a();
                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new C00401(this.$pressScope, null), 3, null);
                    this.$onDoubleTap.invoke(y1.g.d(zVar.h()));
                    return Unit.f68710a;
                }
                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$pressScope, null), 3, null);
                Function1<y1.g, Unit> function1 = this.$onTap;
                if (function1 == null) {
                    return null;
                }
                function1.invoke(y1.g.d(this.$upOrCancel.element.h()));
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(k0 k0Var, Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super y1.g, Unit> function1, Function1<? super y1.g, Unit> function2, Function1<? super y1.g, Unit> function4, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$coroutineScope = k0Var;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function2;
            this.$onTap = function4;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:28:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:33:0x00f5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:37:0x00ff A[Catch: PointerEventTimeoutCancellationException -> 0x0110, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x0110, blocks: (B:35:0x00f9, B:37:0x00ff, B:39:0x0115), top: B:93:0x00f9 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0115 A[Catch: PointerEventTimeoutCancellationException -> 0x0110, TRY_LEAVE, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x0110, blocks: (B:35:0x00f9, B:37:0x00ff, B:39:0x0115), top: B:93:0x00f9 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0132  */
        /* JADX WARN: Code duplicated, block: B:47:0x0150 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:51:0x0167  */
        /* JADX WARN: Code duplicated, block: B:53:0x016b  */
        /* JADX WARN: Code duplicated, block: B:55:0x016f  */
        /* JADX WARN: Code duplicated, block: B:56:0x017e  */
        /* JADX WARN: Code duplicated, block: B:58:0x0193 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x0194  */
        /* JADX WARN: Code duplicated, block: B:62:0x0199  */
        /* JADX WARN: Code duplicated, block: B:64:0x019d  */
        /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
        /* JADX WARN: Code duplicated, block: B:70:0x01f7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:74:0x0200  */
        /* JADX WARN: Code duplicated, block: B:77:0x0213  */
        /* JADX WARN: Code duplicated, block: B:80:0x022d A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE;
            androidx.compose.ui.input.pointer.e eVar;
            z zVar;
            long jC;
            Ref.ObjectRef objectRef;
            Object objM0;
            androidx.compose.ui.input.pointer.e eVar2;
            z zVar2;
            Ref.ObjectRef objectRef2;
            androidx.compose.ui.input.pointer.e eVar3;
            Function1<y1.g, Unit> function1;
            T t11;
            T t12;
            T t13;
            Object objF;
            androidx.compose.ui.input.pointer.e eVar4;
            Function1<y1.g, Unit> function2;
            z zVar3;
            z zVar4;
            androidx.compose.ui.input.pointer.e eVar5;
            Ref.ObjectRef objectRef3;
            AnonymousClass9 anonymousClass9;
            Function1<y1.g, Unit> function3;
            Function1<y1.g, Unit> function4;
            Function1<y1.g, Unit> function5;
            Object objE2 = kotlin.coroutines.intrinsics.a.e();
            switch (this.label) {
                case 0:
                    ResultKt.b(obj);
                    androidx.compose.ui.input.pointer.e eVar6 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    this.L$0 = eVar6;
                    this.label = 1;
                    objE = TapGestureDetectorKt.e(eVar6, false, null, this, 3, null);
                    if (objE == objE2) {
                        return objE2;
                    }
                    eVar = eVar6;
                    zVar = (z) objE;
                    zVar.a();
                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new C00391(this.$pressScope, null), 3, null);
                    if (this.$onPress != TapGestureDetectorKt.f2348a) {
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$onPress, this.$pressScope, zVar, null), 3, null);
                    }
                    if (this.$onLongPress != null) {
                        jC = eVar.getViewConfiguration().c();
                    } else {
                        jC = 4611686018427387903L;
                    }
                    objectRef = new Ref.ObjectRef();
                    try {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
                        this.L$0 = eVar;
                        this.L$1 = zVar;
                        this.L$2 = objectRef;
                        this.L$3 = objectRef;
                        this.J$0 = jC;
                        this.label = 2;
                        objM0 = eVar.m0(jC, anonymousClass3, this);
                        if (objM0 == objE2) {
                            return objE2;
                        }
                        eVar2 = eVar;
                        zVar2 = zVar;
                        objectRef2 = objectRef;
                        t11 = objM0;
                        try {
                            objectRef.element = t11;
                            t12 = objectRef2.element;
                            if (t12 == 0) {
                                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                            } else {
                                ((z) t12).a();
                                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                            }
                            break;
                        } catch (PointerEventTimeoutCancellationException unused) {
                            objectRef = objectRef2;
                            zVar = zVar2;
                            eVar3 = eVar2;
                            function1 = this.$onLongPress;
                            if (function1 != null) {
                                function1.invoke(y1.g.d(zVar.h()));
                            }
                            this.L$0 = eVar3;
                            this.L$1 = objectRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = jC;
                            this.label = 3;
                            if (TapGestureDetectorKt.g(eVar3, this) == objE2) {
                                return objE2;
                            }
                            kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                            objectRef2 = objectRef;
                            eVar2 = eVar3;
                        }
                        t13 = objectRef2.element;
                        if (t13 != 0) {
                            if (this.$onDoubleTap == null) {
                                function2 = this.$onTap;
                                if (function2 != null) {
                                    function2.invoke(y1.g.d(((z) t13).h()));
                                }
                            } else {
                                this.L$0 = eVar2;
                                this.L$1 = objectRef2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = jC;
                                this.label = 4;
                                objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                                if (objF == objE2) {
                                    return objE2;
                                }
                                eVar4 = eVar2;
                                zVar3 = (z) objF;
                                if (zVar3 == null) {
                                    function3 = this.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                    }
                                } else {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                    }
                                    try {
                                        anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                        this.L$0 = eVar4;
                                        this.L$1 = objectRef2;
                                        this.L$2 = zVar3;
                                        this.label = 5;
                                        if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                            return objE2;
                                        }
                                    } catch (PointerEventTimeoutCancellationException unused2) {
                                        zVar4 = zVar3;
                                        eVar5 = eVar4;
                                        objectRef3 = objectRef2;
                                        function4 = this.$onTap;
                                        if (function4 != null) {
                                            function4.invoke(y1.g.d(((z) objectRef3.element).h()));
                                        }
                                        function5 = this.$onLongPress;
                                        if (function5 != null) {
                                            function5.invoke(y1.g.d(zVar4.h()));
                                        }
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = 6;
                                        if (TapGestureDetectorKt.g(eVar5, this) == objE2) {
                                            return objE2;
                                        }
                                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                                    }
                                }
                            }
                        }
                        return Unit.f68710a;
                    } catch (PointerEventTimeoutCancellationException unused3) {
                        eVar3 = eVar;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                            function1.invoke(y1.g.d(zVar.h()));
                        }
                        this.L$0 = eVar3;
                        this.L$1 = objectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = jC;
                        this.label = 3;
                        if (TapGestureDetectorKt.g(eVar3, this) == objE2) {
                            return objE2;
                        }
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        objectRef2 = objectRef;
                        eVar2 = eVar3;
                        t13 = objectRef2.element;
                        if (t13 != 0) {
                            if (this.$onDoubleTap == null) {
                                function2 = this.$onTap;
                                if (function2 != null) {
                                    function2.invoke(y1.g.d(((z) t13).h()));
                                }
                            } else {
                                this.L$0 = eVar2;
                                this.L$1 = objectRef2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = jC;
                                this.label = 4;
                                objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                                if (objF == objE2) {
                                    return objE2;
                                }
                                eVar4 = eVar2;
                                zVar3 = (z) objF;
                                if (zVar3 == null) {
                                    function3 = this.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                    }
                                } else {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                    }
                                    anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                    this.L$0 = eVar4;
                                    this.L$1 = objectRef2;
                                    this.L$2 = zVar3;
                                    this.label = 5;
                                    if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                        return objE2;
                                    }
                                }
                            }
                        }
                        return Unit.f68710a;
                    }
                case 1:
                    androidx.compose.ui.input.pointer.e eVar7 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    ResultKt.b(obj);
                    eVar = eVar7;
                    objE = obj;
                    zVar = (z) objE;
                    zVar.a();
                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new C00391(this.$pressScope, null), 3, null);
                    if (this.$onPress != TapGestureDetectorKt.f2348a) {
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$onPress, this.$pressScope, zVar, null), 3, null);
                    }
                    if (this.$onLongPress != null) {
                        jC = eVar.getViewConfiguration().c();
                    } else {
                        jC = 4611686018427387903L;
                    }
                    objectRef = new Ref.ObjectRef();
                    AnonymousClass3 anonymousClass4 = new AnonymousClass3(null);
                    this.L$0 = eVar;
                    this.L$1 = zVar;
                    this.L$2 = objectRef;
                    this.L$3 = objectRef;
                    this.J$0 = jC;
                    this.label = 2;
                    objM0 = eVar.m0(jC, anonymousClass4, this);
                    if (objM0 == objE2) {
                        return objE2;
                    }
                    eVar2 = eVar;
                    zVar2 = zVar;
                    objectRef2 = objectRef;
                    t11 = objM0;
                    objectRef.element = t11;
                    t12 = objectRef2.element;
                    if (t12 == 0) {
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                    } else {
                        ((z) t12).a();
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                    }
                    t13 = objectRef2.element;
                    if (t13 != 0) {
                        if (this.$onDoubleTap == null) {
                            function2 = this.$onTap;
                            if (function2 != null) {
                                function2.invoke(y1.g.d(((z) t13).h()));
                            }
                        } else {
                            this.L$0 = eVar2;
                            this.L$1 = objectRef2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = jC;
                            this.label = 4;
                            objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                            if (objF == objE2) {
                                return objE2;
                            }
                            eVar4 = eVar2;
                            zVar3 = (z) objF;
                            if (zVar3 == null) {
                                function3 = this.$onTap;
                                if (function3 != null) {
                                    function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                }
                            } else {
                                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                }
                                anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                this.L$0 = eVar4;
                                this.L$1 = objectRef2;
                                this.L$2 = zVar3;
                                this.label = 5;
                                if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                    return objE2;
                                }
                            }
                        }
                    }
                    return Unit.f68710a;
                case 2:
                    jC = this.J$0;
                    objectRef = (Ref.ObjectRef) this.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.L$2;
                    zVar = (z) this.L$1;
                    eVar = (androidx.compose.ui.input.pointer.e) this.L$0;
                    try {
                        ResultKt.b(obj);
                        eVar2 = eVar;
                        zVar2 = zVar;
                        objectRef2 = objectRef4;
                        t11 = obj;
                        objectRef.element = t11;
                        t12 = objectRef2.element;
                        if (t12 == 0) {
                            kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                        } else {
                            ((z) t12).a();
                            kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                        }
                        break;
                    } catch (PointerEventTimeoutCancellationException unused4) {
                        objectRef = objectRef4;
                        eVar3 = eVar;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                            function1.invoke(y1.g.d(zVar.h()));
                        }
                        this.L$0 = eVar3;
                        this.L$1 = objectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = jC;
                        this.label = 3;
                        if (TapGestureDetectorKt.g(eVar3, this) == objE2) {
                            return objE2;
                        }
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        objectRef2 = objectRef;
                        eVar2 = eVar3;
                        t13 = objectRef2.element;
                        if (t13 != 0) {
                            if (this.$onDoubleTap == null) {
                                function2 = this.$onTap;
                                if (function2 != null) {
                                    function2.invoke(y1.g.d(((z) t13).h()));
                                }
                            } else {
                                this.L$0 = eVar2;
                                this.L$1 = objectRef2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = jC;
                                this.label = 4;
                                objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                                if (objF == objE2) {
                                    return objE2;
                                }
                                eVar4 = eVar2;
                                zVar3 = (z) objF;
                                if (zVar3 == null) {
                                    function3 = this.$onTap;
                                    if (function3 != null) {
                                        function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                    }
                                } else {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                    }
                                    anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                    this.L$0 = eVar4;
                                    this.L$1 = objectRef2;
                                    this.L$2 = zVar3;
                                    this.label = 5;
                                    if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                        return objE2;
                                    }
                                }
                            }
                        }
                        return Unit.f68710a;
                    }
                    t13 = objectRef2.element;
                    if (t13 != 0) {
                        if (this.$onDoubleTap == null) {
                            function2 = this.$onTap;
                            if (function2 != null) {
                                function2.invoke(y1.g.d(((z) t13).h()));
                            }
                        } else {
                            this.L$0 = eVar2;
                            this.L$1 = objectRef2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = jC;
                            this.label = 4;
                            objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                            if (objF == objE2) {
                                return objE2;
                            }
                            eVar4 = eVar2;
                            zVar3 = (z) objF;
                            if (zVar3 == null) {
                                function3 = this.$onTap;
                                if (function3 != null) {
                                    function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                }
                            } else {
                                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                }
                                anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                this.L$0 = eVar4;
                                this.L$1 = objectRef2;
                                this.L$2 = zVar3;
                                this.label = 5;
                                if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                    return objE2;
                                }
                            }
                        }
                    }
                    return Unit.f68710a;
                case 3:
                    jC = this.J$0;
                    objectRef = (Ref.ObjectRef) this.L$1;
                    eVar3 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    ResultKt.b(obj);
                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                    objectRef2 = objectRef;
                    eVar2 = eVar3;
                    t13 = objectRef2.element;
                    if (t13 != 0) {
                        if (this.$onDoubleTap == null) {
                            function2 = this.$onTap;
                            if (function2 != null) {
                                function2.invoke(y1.g.d(((z) t13).h()));
                            }
                        } else {
                            this.L$0 = eVar2;
                            this.L$1 = objectRef2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = jC;
                            this.label = 4;
                            objF = TapGestureDetectorKt.f(eVar2, (z) t13, this);
                            if (objF == objE2) {
                                return objE2;
                            }
                            eVar4 = eVar2;
                            zVar3 = (z) objF;
                            if (zVar3 == null) {
                                function3 = this.$onTap;
                                if (function3 != null) {
                                    function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                                }
                            } else {
                                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                if (this.$onPress != TapGestureDetectorKt.f2348a) {
                                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                                }
                                anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                                this.L$0 = eVar4;
                                this.L$1 = objectRef2;
                                this.L$2 = zVar3;
                                this.label = 5;
                                if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                                    return objE2;
                                }
                            }
                        }
                    }
                    return Unit.f68710a;
                case 4:
                    jC = this.J$0;
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$1;
                    eVar4 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    ResultKt.b(obj);
                    objectRef2 = objectRef5;
                    objF = obj;
                    zVar3 = (z) objF;
                    if (zVar3 == null) {
                        function3 = this.$onTap;
                        if (function3 != null) {
                            function3.invoke(y1.g.d(((z) objectRef2.element).h()));
                        }
                    } else {
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                        if (this.$onPress != TapGestureDetectorKt.f2348a) {
                            kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, zVar3, null), 3, null);
                        }
                        anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, objectRef2, this.$pressScope, null);
                        this.L$0 = eVar4;
                        this.L$1 = objectRef2;
                        this.L$2 = zVar3;
                        this.label = 5;
                        if (eVar4.m0(jC, anonymousClass9, this) == objE2) {
                            return objE2;
                        }
                    }
                    return Unit.f68710a;
                case 5:
                    zVar4 = (z) this.L$2;
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    eVar5 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    try {
                        ResultKt.b(obj);
                        break;
                    } catch (PointerEventTimeoutCancellationException unused5) {
                        function4 = this.$onTap;
                        if (function4 != null) {
                            function4.invoke(y1.g.d(((z) objectRef3.element).h()));
                        }
                        function5 = this.$onLongPress;
                        if (function5 != null) {
                            function5.invoke(y1.g.d(zVar4.h()));
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 6;
                        if (TapGestureDetectorKt.g(eVar5, this) == objE2) {
                            return objE2;
                        }
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                    }
                    return Unit.f68710a;
                case 6:
                    ResultKt.b(obj);
                    kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                    return Unit.f68710a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TapGestureDetectorKt$detectTapGestures$2(h0 h0Var, Function3<? super i, ? super y1.g, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super y1.g, Unit> function1, Function1<? super y1.g, Unit> function2, Function1<? super y1.g, Unit> function4, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = h0Var;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function2;
        this.$onTap = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            k0 k0Var = (k0) this.L$0;
            PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            h0 h0Var = this.$this_detectTapGestures;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(k0Var, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null);
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
