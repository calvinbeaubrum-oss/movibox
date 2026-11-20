package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.r0;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.p1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.v;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.k0;

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
@SourceDebugExtension
public final class SliderKt$RangeSlider$2 extends Lambda implements Function3<androidx.compose.foundation.layout.g, androidx.compose.runtime.i, Integer, Unit> {
    final /* synthetic */ j $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ o1.i $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ a3<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ o1.i $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, List<Float> list, Function0<Unit> function0, a3<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> a3Var, o1.i iVar, o1.i iVar2, boolean z11, int i11, j jVar) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$tickFractions = list;
        this.$onValueChangeFinished = function0;
        this.$onValueChangeState = a3Var;
        this.$startInteractionSource = iVar;
        this.$endInteractionSource = iVar2;
        this.$enabled = z11;
        this.$steps = i11;
        this.$colors = jVar;
    }

    public static final float a(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f11) {
        return SliderKt.v(closedFloatingPointRange.j().floatValue(), closedFloatingPointRange.f().floatValue(), f11, floatRef.element, floatRef2.element);
    }

    public static final ClosedFloatingPointRange<Float> b(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return SliderKt.w(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.j().floatValue(), closedFloatingPointRange.f().floatValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.g gVar, androidx.compose.runtime.i iVar, Integer num) {
        invoke(gVar, iVar, num.intValue());
        return Unit.f68710a;
    }

    public final void invoke(androidx.compose.foundation.layout.g gVar, androidx.compose.runtime.i iVar, int i11) {
        int i12;
        if ((i11 & 6) == 0) {
            i12 = i11 | (iVar.Q(gVar) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 19) == 18 && iVar.h()) {
            iVar.H();
            return;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(652589923, i12, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:320)");
        }
        boolean z11 = iVar.l(CompositionLocalsKt.g()) == LayoutDirection.Rtl;
        float fL = q2.b.l(gVar.a());
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        q2.e eVar = (q2.e) iVar.l(CompositionLocalsKt.c());
        floatRef.element = fL - eVar.N0(SliderKt.t());
        floatRef2.element = eVar.N0(SliderKt.t());
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
        Object objY = iVar.y();
        androidx.compose.runtime.i.a aVar = androidx.compose.runtime.i.f3413a;
        if (objY == aVar.a()) {
            objY = p1.a(a(closedFloatingPointRange2, floatRef2, floatRef, closedFloatingPointRange.j().floatValue()));
            iVar.p(objY);
        }
        final c1 c1Var = (c1) objY;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
        Object objY2 = iVar.y();
        if (objY2 == aVar.a()) {
            objY2 = p1.a(a(closedFloatingPointRange4, floatRef2, floatRef, closedFloatingPointRange3.f().floatValue()));
            iVar.p(objY2);
        }
        final c1 c1Var2 = (c1) objY2;
        boolean zQ = iVar.Q(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element);
        ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
        Object objY3 = iVar.y();
        if (zQ || objY3 == aVar.a()) {
            objY3 = new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange5, floatRef2, floatRef);
            iVar.p(objY3);
        }
        SliderKt.a((Function1) ((KFunction) objY3), this.$valueRange, b20.c.b(floatRef2.element, floatRef.element), c1Var, this.$value.j().floatValue(), iVar, 3072);
        boolean zQ2 = iVar.Q(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element);
        ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$valueRange;
        Object objY4 = iVar.y();
        if (zQ2 || objY4 == aVar.a()) {
            objY4 = new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange6, floatRef2, floatRef);
            iVar.p(objY4);
        }
        SliderKt.a((Function1) ((KFunction) objY4), this.$valueRange, b20.c.b(floatRef2.element, floatRef.element), c1Var2, this.$value.f().floatValue(), iVar, 3072);
        Object objY5 = iVar.y();
        if (objY5 == aVar.a()) {
            Object vVar = new v(g0.g(EmptyCoroutineContext.INSTANCE, iVar));
            iVar.p(vVar);
            objY5 = vVar;
        }
        final k0 k0VarA = ((v) objY5).a();
        boolean zA = iVar.A(this.$tickFractions) | iVar.b(floatRef2.element) | iVar.b(floatRef.element) | iVar.Q(this.$onValueChangeFinished) | iVar.A(k0VarA) | iVar.Q(this.$onValueChangeState) | iVar.Q(this.$valueRange);
        final List<Float> list = this.$tickFractions;
        final Function0<Unit> function0 = this.$onValueChangeFinished;
        final a3<Function1<ClosedFloatingPointRange<Float>, Unit>> a3Var = this.$onValueChangeState;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$valueRange;
        Object objY6 = iVar.y();
        if (zA || objY6 == aVar.a()) {
            objY6 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1", f = "Slider.kt", l = {366}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ boolean $isStart;
                    final /* synthetic */ Ref.FloatRef $maxPx;
                    final /* synthetic */ Ref.FloatRef $minPx;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ a3<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                    final /* synthetic */ c1 $rawOffsetEnd;
                    final /* synthetic */ c1 $rawOffsetStart;
                    final /* synthetic */ float $target;
                    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(float f11, float f12, Function0<Unit> function0, boolean z11, c1 c1Var, c1 c1Var2, a3<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> a3Var, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$current = f11;
                        this.$target = f12;
                        this.$onValueChangeFinished = function0;
                        this.$isStart = z11;
                        this.$rawOffsetStart = c1Var;
                        this.$rawOffsetEnd = c1Var2;
                        this.$onValueChangeState = a3Var;
                        this.$minPx = floatRef;
                        this.$maxPx = floatRef2;
                        this.$valueRange = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
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
                            Animatable animatableB = androidx.compose.animation.core.a.b(this.$current, 0.0f, 2, null);
                            Float fC = Boxing.c(this.$target);
                            r0 r0Var = SliderKt.f3060i;
                            Float fC2 = Boxing.c(0.0f);
                            final boolean z11 = this.$isStart;
                            final c1 c1Var = this.$rawOffsetStart;
                            final c1 c1Var2 = this.$rawOffsetEnd;
                            final a3<Function1<ClosedFloatingPointRange<Float>, Unit>> a3Var = this.$onValueChangeState;
                            final Ref.FloatRef floatRef = this.$minPx;
                            final Ref.FloatRef floatRef2 = this.$maxPx;
                            final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                            Function1<Animatable<Float, androidx.compose.animation.core.k>, Unit> function1 = new Function1<Animatable<Float, androidx.compose.animation.core.k>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, androidx.compose.animation.core.k> animatable) {
                                    invoke2(animatable);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Animatable<Float, androidx.compose.animation.core.k> animatable) {
                                    (z11 ? c1Var : c1Var2).setFloatValue(animatable.k().floatValue());
                                    a3Var.getValue().invoke(SliderKt$RangeSlider$2.b(floatRef, floatRef2, closedFloatingPointRange, b20.c.b(c1Var.getFloatValue(), c1Var2.getFloatValue())));
                                }
                            };
                            this.label = 1;
                            if (animatableB.e(fC, r0Var, fC2, function1, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z12) {
                    float floatValue = (z12 ? c1Var : c1Var2).getFloatValue();
                    float fY = SliderKt.y(floatValue, list, floatRef2.element, floatRef.element);
                    if (floatValue != fY) {
                        kotlinx.coroutines.j.d(k0VarA, null, null, new AnonymousClass1(floatValue, fY, function0, z12, c1Var, c1Var2, a3Var, floatRef2, floatRef, closedFloatingPointRange7, null), 3, null);
                        return;
                    }
                    Function0<Unit> function1 = function0;
                    if (function1 != null) {
                        function1.invoke();
                    }
                }
            };
            iVar.p(objY6);
        }
        a3 a3VarI = r2.i((Function1) objY6, iVar, 0);
        boolean zQ3 = iVar.Q(this.$valueRange) | iVar.b(floatRef2.element) | iVar.b(floatRef.element) | iVar.Q(this.$value) | iVar.Q(this.$onValueChangeState);
        final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = this.$value;
        final a3<Function1<ClosedFloatingPointRange<Float>, Unit>> a3Var2 = this.$onValueChangeState;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange9 = this.$valueRange;
        Object objY7 = iVar.y();
        if (zQ3 || objY7 == aVar.a()) {
            objY7 = new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f11) {
                    invoke(bool.booleanValue(), f11.floatValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z12, float f11) {
                    ClosedFloatingPointRange closedFloatingPointRangeB;
                    if (z12) {
                        c1 c1Var3 = c1Var;
                        c1Var3.setFloatValue(c1Var3.getFloatValue() + f11);
                        c1Var2.setFloatValue(SliderKt$RangeSlider$2.a(closedFloatingPointRange9, floatRef2, floatRef, closedFloatingPointRange8.f().floatValue()));
                        float floatValue = c1Var2.getFloatValue();
                        closedFloatingPointRangeB = b20.c.b(kotlin.ranges.a.j(c1Var.getFloatValue(), floatRef2.element, floatValue), floatValue);
                    } else {
                        c1 c1Var4 = c1Var2;
                        c1Var4.setFloatValue(c1Var4.getFloatValue() + f11);
                        c1Var.setFloatValue(SliderKt$RangeSlider$2.a(closedFloatingPointRange9, floatRef2, floatRef, closedFloatingPointRange8.j().floatValue()));
                        float floatValue2 = c1Var.getFloatValue();
                        closedFloatingPointRangeB = b20.c.b(floatValue2, kotlin.ranges.a.j(c1Var2.getFloatValue(), floatValue2, floatRef.element));
                    }
                    a3Var2.getValue().invoke(SliderKt$RangeSlider$2.b(floatRef2, floatRef, closedFloatingPointRange9, closedFloatingPointRangeB));
                }
            };
            iVar.p(objY7);
        }
        a3 a3VarI2 = r2.i((Function2) objY7, iVar, 0);
        androidx.compose.ui.f.a aVar2 = androidx.compose.ui.f.f3863a;
        androidx.compose.ui.f fVarU = SliderKt.u(aVar2, this.$startInteractionSource, this.$endInteractionSource, c1Var, c1Var2, this.$enabled, z11, fL, this.$valueRange, a3VarI, a3VarI2);
        final float fJ = kotlin.ranges.a.j(this.$value.j().floatValue(), this.$valueRange.j().floatValue(), this.$value.f().floatValue());
        final float fJ2 = kotlin.ranges.a.j(this.$value.f().floatValue(), this.$value.j().floatValue(), this.$valueRange.f().floatValue());
        float fS = SliderKt.s(this.$valueRange.j().floatValue(), this.$valueRange.f().floatValue(), fJ);
        float fS2 = SliderKt.s(this.$valueRange.j().floatValue(), this.$valueRange.f().floatValue(), fJ2);
        int iFloor = (int) Math.floor(this.$steps * fS2);
        int iFloor2 = (int) Math.floor(this.$steps * (1.0f - fS));
        boolean z12 = this.$enabled;
        boolean zQ4 = iVar.Q(this.$onValueChangeState) | iVar.b(fJ2);
        final a3<Function1<ClosedFloatingPointRange<Float>, Unit>> a3Var3 = this.$onValueChangeState;
        Object objY8 = iVar.y();
        if (zQ4 || objY8 == aVar.a()) {
            objY8 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                    invoke(f11.floatValue());
                    return Unit.f68710a;
                }

                public final void invoke(float f11) {
                    a3Var3.getValue().invoke(b20.c.b(f11, fJ2));
                }
            };
            iVar.p(objY8);
        }
        androidx.compose.ui.f fVarX = SliderKt.x(aVar2, fJ, z12, (Function1) objY8, this.$onValueChangeFinished, b20.c.b(this.$valueRange.j().floatValue(), fJ2), iFloor);
        boolean z13 = this.$enabled;
        boolean zQ5 = iVar.Q(this.$onValueChangeState) | iVar.b(fJ);
        final a3<Function1<ClosedFloatingPointRange<Float>, Unit>> a3Var4 = this.$onValueChangeState;
        Object objY9 = iVar.y();
        if (zQ5 || objY9 == aVar.a()) {
            objY9 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                    invoke(f11.floatValue());
                    return Unit.f68710a;
                }

                public final void invoke(float f11) {
                    a3Var4.getValue().invoke(b20.c.b(fJ, f11));
                }
            };
            iVar.p(objY9);
        }
        SliderKt.c(this.$enabled, fS, fS2, this.$tickFractions, this.$colors, floatRef.element - floatRef2.element, this.$startInteractionSource, this.$endInteractionSource, fVarU, fVarX, SliderKt.x(aVar2, fJ2, z13, (Function1) objY9, this.$onValueChangeFinished, b20.c.b(fJ, this.$valueRange.f().floatValue()), iFloor2), iVar, 14155776, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
    }
}
