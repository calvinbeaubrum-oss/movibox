package androidx.compose.material;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.a3;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.r;
import androidx.compose.ui.input.pointer.z;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

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
@DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {992}, m = "invokeSuspend")
public final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<h0, Continuation<? super Unit>, Object> {
    final /* synthetic */ o1.i $endInteractionSource;
    final /* synthetic */ a3<Function1<Boolean, Unit>> $gestureEndAction;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ float $maxPx;
    final /* synthetic */ a3<Function2<Boolean, Float, Unit>> $onDrag;
    final /* synthetic */ a3<Float> $rawOffsetEnd;
    final /* synthetic */ a3<Float> $rawOffsetStart;
    final /* synthetic */ o1.i $startInteractionSource;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {993}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ h0 $$this$pointerInput;
        final /* synthetic */ a3<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ a3<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
        final /* synthetic */ a3<Float> $rawOffsetEnd;
        final /* synthetic */ a3<Float> $rawOffsetStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {994, 1004, 1023}, m = "invokeSuspend")
        public static final class C00461 extends RestrictedSuspendLambda implements Function2<androidx.compose.ui.input.pointer.e, Continuation<? super Unit>, Object> {
            final /* synthetic */ k0 $$this$coroutineScope;
            final /* synthetic */ a3<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ a3<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ a3<Float> $rawOffsetEnd;
            final /* synthetic */ a3<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", l = {1040}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.BooleanRef $draggingStart;
                final /* synthetic */ o1.a $finishInteraction;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, o1.a aVar, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$draggingStart = booleanRef;
                    this.$finishInteraction = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
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
                        o1.i iVarA = this.$rangeSliderLogic.a(this.$draggingStart.element);
                        o1.a aVar = this.$finishInteraction;
                        this.label = 1;
                        if (iVarA.b(aVar, this) == objE) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00461(boolean z11, float f11, RangeSliderLogic rangeSliderLogic, a3<Float> a3Var, k0 k0Var, a3<? extends Function1<? super Boolean, Unit>> a3Var2, a3<Float> a3Var3, a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var4, Continuation<? super C00461> continuation) {
                super(2, continuation);
                this.$isRtl = z11;
                this.$maxPx = f11;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = a3Var;
                this.$$this$coroutineScope = k0Var;
                this.$gestureEndAction = a3Var2;
                this.$rawOffsetEnd = a3Var3;
                this.$onDrag = a3Var4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00461 c00461 = new C00461(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                c00461.L$0 = obj;
                return c00461;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(androidx.compose.ui.input.pointer.e eVar, Continuation<? super Unit> continuation) {
                return ((C00461) create(eVar, continuation)).invokeSuspend(Unit.f68710a);
            }

            /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
            /* JADX WARN: Code duplicated, block: B:53:0x017a A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:56:0x0183 A[Catch: CancellationException -> 0x0189, TryCatch #1 {CancellationException -> 0x0189, blocks: (B:54:0x017b, B:56:0x0183, B:58:0x018b, B:51:0x015b), top: B:66:0x015b }] */
            /* JADX WARN: Code duplicated, block: B:58:0x018b A[Catch: CancellationException -> 0x0189, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x0189, blocks: (B:54:0x017b, B:56:0x0183, B:58:0x018b, B:51:0x015b), top: B:66:0x015b }] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE;
                androidx.compose.ui.input.pointer.e eVar;
                Ref.FloatRef floatRef;
                Object objR;
                o1.a.b bVar;
                final Ref.BooleanRef booleanRef;
                androidx.compose.ui.input.pointer.e eVar2;
                z zVar;
                Pair pair;
                o1.a.b bVar2;
                Object objF;
                a3<Float> a3Var;
                boolean z11;
                float fC;
                o1.a c0776a;
                Object objE2 = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    androidx.compose.ui.input.pointer.e eVar3 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    this.L$0 = eVar3;
                    this.label = 1;
                    objE = TapGestureDetectorKt.e(eVar3, false, null, this, 2, null);
                    if (objE == objE2) {
                        return objE2;
                    }
                    eVar = eVar3;
                } else {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            booleanRef = (Ref.BooleanRef) this.L$1;
                            bVar2 = (o1.a.b) this.L$0;
                            try {
                                ResultKt.b(obj);
                                bVar = bVar2;
                                objF = obj;
                                if (((Boolean) objF).booleanValue()) {
                                    c0776a = new o1.a.c(bVar);
                                } else {
                                    c0776a = new o1.a.C0776a(bVar);
                                }
                            } catch (CancellationException unused) {
                                c0776a = new o1.a.C0776a(bVar2);
                            }
                            this.$gestureEndAction.getValue().invoke(Boxing.a(booleanRef.element));
                            kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef, c0776a, null), 3, null);
                            return Unit.f68710a;
                        }
                        booleanRef = (Ref.BooleanRef) this.L$4;
                        floatRef = (Ref.FloatRef) this.L$3;
                        o1.a.b bVar3 = (o1.a.b) this.L$2;
                        z zVar2 = (z) this.L$1;
                        androidx.compose.ui.input.pointer.e eVar4 = (androidx.compose.ui.input.pointer.e) this.L$0;
                        ResultKt.b(obj);
                        eVar2 = eVar4;
                        zVar = zVar2;
                        bVar = bVar3;
                        objR = obj;
                        pair = (Pair) objR;
                        if (pair != null) {
                            a3Var = this.$rawOffsetEnd;
                            a3<Float> a3Var2 = this.$rawOffsetStart;
                            z11 = this.$isRtl;
                            fC = DragGestureDetectorCopyKt.c(eVar2.getViewConfiguration(), zVar.n());
                            if (Math.abs(a3Var.getValue().floatValue() - floatRef.element) < fC && Math.abs(a3Var2.getValue().floatValue() - floatRef.element) < fC) {
                                float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                booleanRef.element = z11 ? fFloatValue < 0.0f : fFloatValue >= 0.0f;
                                floatRef.element += y1.g.m(r.g((z) pair.getFirst()));
                            }
                        }
                        this.$rangeSliderLogic.b(booleanRef.element, floatRef.element, bVar, this.$$this$coroutineScope);
                        try {
                            long jF = zVar.f();
                            final a3<Function2<Boolean, Float, Unit>> a3Var3 = this.$onDrag;
                            final boolean z12 = this.$isRtl;
                            Function1<z, Unit> function1 = new Function1<z, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(z zVar3) {
                                    invoke2(zVar3);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(z zVar3) {
                                    float fM = y1.g.m(r.g(zVar3));
                                    Function2<Boolean, Float, Unit> value = a3Var3.getValue();
                                    Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                                    if (z12) {
                                        fM = -fM;
                                    }
                                    value.invoke(boolValueOf, Float.valueOf(fM));
                                }
                            };
                            this.L$0 = bVar;
                            this.L$1 = booleanRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 3;
                            objF = DragGestureDetectorKt.f(eVar2, jF, function1, this);
                            if (objF == objE2) {
                                return objE2;
                            }
                            if (((Boolean) objF).booleanValue()) {
                                c0776a = new o1.a.c(bVar);
                            } else {
                                c0776a = new o1.a.C0776a(bVar);
                            }
                        } catch (CancellationException unused2) {
                            bVar2 = bVar;
                            c0776a = new o1.a.C0776a(bVar2);
                        }
                        this.$gestureEndAction.getValue().invoke(Boxing.a(booleanRef.element));
                        kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef, c0776a, null), 3, null);
                        return Unit.f68710a;
                    }
                    androidx.compose.ui.input.pointer.e eVar5 = (androidx.compose.ui.input.pointer.e) this.L$0;
                    ResultKt.b(obj);
                    eVar = eVar5;
                    objE = obj;
                }
                z zVar3 = (z) objE;
                o1.a.b bVar4 = new o1.a.b();
                floatRef = new Ref.FloatRef();
                float fM = this.$isRtl ? this.$maxPx - y1.g.m(zVar3.h()) : y1.g.m(zVar3.h());
                floatRef.element = fM;
                int iC = this.$rangeSliderLogic.c(fM);
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                booleanRef2.element = iC == 0 ? this.$rawOffsetStart.getValue().floatValue() > floatRef.element : iC < 0;
                long jF2 = zVar3.f();
                int iN = zVar3.n();
                this.L$0 = eVar;
                this.L$1 = zVar3;
                this.L$2 = bVar4;
                this.L$3 = floatRef;
                this.L$4 = booleanRef2;
                this.label = 2;
                objR = SliderKt.r(eVar, jF2, iN, this);
                if (objR == objE2) {
                    return objE2;
                }
                bVar = bVar4;
                booleanRef = booleanRef2;
                eVar2 = eVar;
                zVar = zVar3;
                pair = (Pair) objR;
                if (pair != null) {
                    a3Var = this.$rawOffsetEnd;
                    a3<Float> a3Var4 = this.$rawOffsetStart;
                    z11 = this.$isRtl;
                    fC = DragGestureDetectorCopyKt.c(eVar2.getViewConfiguration(), zVar.n());
                    if (Math.abs(a3Var.getValue().floatValue() - floatRef.element) < fC) {
                        float fFloatValue2 = ((Number) pair.getSecond()).floatValue();
                        booleanRef.element = z11 ? fFloatValue2 < 0.0f : fFloatValue2 >= 0.0f;
                        floatRef.element += y1.g.m(r.g((z) pair.getFirst()));
                    }
                }
                this.$rangeSliderLogic.b(booleanRef.element, floatRef.element, bVar, this.$$this$coroutineScope);
                long jF3 = zVar.f();
                final a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var5 = this.$onDrag;
                final boolean z13 = this.$isRtl;
                Function1<z, Unit> function2 = new Function1<z, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(z zVar4) {
                        invoke2(zVar4);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(z zVar4) {
                        float fM2 = y1.g.m(r.g(zVar4));
                        Function2<Boolean, Float, Unit> value = a3Var5.getValue();
                        Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                        if (z13) {
                            fM2 = -fM2;
                        }
                        value.invoke(boolValueOf, Float.valueOf(fM2));
                    }
                };
                this.L$0 = bVar;
                this.L$1 = booleanRef;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                objF = DragGestureDetectorKt.f(eVar2, jF3, function2, this);
                if (objF == objE2) {
                    return objE2;
                }
                if (((Boolean) objF).booleanValue()) {
                    c0776a = new o1.a.c(bVar);
                } else {
                    c0776a = new o1.a.C0776a(bVar);
                }
                this.$gestureEndAction.getValue().invoke(Boxing.a(booleanRef.element));
                kotlinx.coroutines.j.d(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef, c0776a, null), 3, null);
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(h0 h0Var, boolean z11, float f11, RangeSliderLogic rangeSliderLogic, a3<Float> a3Var, a3<? extends Function1<? super Boolean, Unit>> a3Var2, a3<Float> a3Var3, a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = h0Var;
            this.$isRtl = z11;
            this.$maxPx = f11;
            this.$rangeSliderLogic = rangeSliderLogic;
            this.$rawOffsetStart = a3Var;
            this.$gestureEndAction = a3Var2;
            this.$rawOffsetEnd = a3Var3;
            this.$onDrag = a3Var4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                k0 k0Var = (k0) this.L$0;
                h0 h0Var = this.$$this$pointerInput;
                C00461 c00461 = new C00461(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, k0Var, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                this.label = 1;
                if (ForEachGestureKt.c(h0Var, c00461, this) == objE) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$rangeSliderPressDragModifier$1(o1.i iVar, o1.i iVar2, a3<Float> a3Var, a3<Float> a3Var2, a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var3, boolean z11, float f11, a3<? extends Function1<? super Boolean, Unit>> a3Var4, Continuation<? super SliderKt$rangeSliderPressDragModifier$1> continuation) {
        super(2, continuation);
        this.$startInteractionSource = iVar;
        this.$endInteractionSource = iVar2;
        this.$rawOffsetStart = a3Var;
        this.$rawOffsetEnd = a3Var2;
        this.$onDrag = a3Var3;
        this.$isRtl = z11;
        this.$maxPx = f11;
        this.$gestureEndAction = a3Var4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SliderKt$rangeSliderPressDragModifier$1 sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
        sliderKt$rangeSliderPressDragModifier$1.L$0 = obj;
        return sliderKt$rangeSliderPressDragModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(h0 h0Var, Continuation<? super Unit> continuation) {
        return ((SliderKt$rangeSliderPressDragModifier$1) create(h0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((h0) this.L$0, this.$isRtl, this.$maxPx, new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag), this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
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
