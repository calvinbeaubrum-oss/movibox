package androidx.compose.material;

import androidx.compose.animation.core.r0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.v;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.v4;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.input.pointer.o0;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import org.mvel2.ast.ASTNode;

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
public final class SliderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f3052a = q2.i.h(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f3053b = q2.i.h(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f3054c = q2.i.h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f3055d = q2.i.h(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f3056e = q2.i.h(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f3057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f3058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final androidx.compose.ui.f f3059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final r0<Float> f3060i;

    static {
        float fH = q2.i.h(48);
        f3057f = fH;
        float fH2 = q2.i.h(144);
        f3058g = fH2;
        f3059h = SizeKt.g(SizeKt.n(androidx.compose.ui.f.f3863a, fH2, 0.0f, 2, null), 0.0f, fH, 1, null);
        f3060i = new r0<>(100, 0, null, 6, null);
    }

    public static final void a(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final i1<Float> i1Var, final float f11, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(-743965752);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(function1) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= iVarG.Q(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= iVarG.Q(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= iVarG.Q(i1Var) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= iVarG.b(f11) ? 16384 : 8192;
        }
        if ((i12 & 9363) == 9362 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-743965752, i12, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:847)");
            }
            boolean z11 = ((i12 & 112) == 32) | ((i12 & 14) == 4) | ((57344 & i12) == 16384) | ((i12 & 7168) == 2048) | ((i12 & 896) == 256);
            Object objY = iVarG.y();
            if (z11 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        float fFloatValue = (closedFloatingPointRange.f().floatValue() - closedFloatingPointRange.j().floatValue()) / 1000;
                        float fFloatValue2 = function1.invoke(Float.valueOf(f11)).floatValue();
                        if (Math.abs(fFloatValue2 - i1Var.getValue().floatValue()) <= fFloatValue || !closedFloatingPointRange2.e(i1Var.getValue())) {
                            return;
                        }
                        i1Var.setValue(Float.valueOf(fFloatValue2));
                    }
                };
                iVarG.p(objY);
            }
            g0.e((Function0) objY, iVarG, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    SliderKt.a(function1, closedFloatingPointRange, closedFloatingPointRange2, i1Var, f11, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0136 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:110:0x013f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0144  */
    /* JADX WARN: Code duplicated, block: B:114:0x014e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0151  */
    /* JADX WARN: Code duplicated, block: B:117:0x0154  */
    /* JADX WARN: Code duplicated, block: B:119:0x0158  */
    /* JADX WARN: Code duplicated, block: B:122:0x015d  */
    /* JADX WARN: Code duplicated, block: B:125:0x018e  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:140:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:145:0x0253  */
    /* JADX WARN: Code duplicated, block: B:149:0x0263  */
    /* JADX WARN: Code duplicated, block: B:151:0x0275  */
    /* JADX WARN: Code duplicated, block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:40:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:93:0x010b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    public static final void b(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, androidx.compose.ui.f fVar, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i11, Function0<Unit> function0, j jVar, androidx.compose.runtime.i iVar, final int i12, final int i13) {
        int i14;
        androidx.compose.ui.f fVar2;
        int i15;
        boolean z12;
        int i16;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i17;
        int i18;
        int i19;
        int i21;
        Function0<Unit> function2;
        int i22;
        j jVarA;
        boolean z13;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeB;
        int i23;
        Object objY;
        androidx.compose.runtime.i.a aVar;
        o1.i iVar2;
        Object objY2;
        o1.i iVar3;
        boolean z14;
        Object objY3;
        final androidx.compose.ui.f fVar3;
        final int i24;
        final j jVar2;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final Function0<Unit> function3;
        final boolean z15;
        g2 g2VarJ;
        androidx.compose.runtime.i iVarG = iVar.g(-1556183027);
        if ((i13 & 1) != 0) {
            i14 = i12 | 6;
        } else if ((i12 & 6) == 0) {
            i14 = (iVarG.Q(closedFloatingPointRange) ? 4 : 2) | i12;
        } else {
            i14 = i12;
        }
        if ((i13 & 2) != 0) {
            i14 |= 48;
        } else if ((i12 & 48) == 0) {
            i14 |= iVarG.A(function1) ? 32 : 16;
        }
        int i25 = i13 & 4;
        if (i25 == 0) {
            if ((i12 & 384) == 0) {
                fVar2 = fVar;
                i14 |= iVarG.Q(fVar2) ? 256 : 128;
            }
            i15 = i13 & 8;
            if (i15 != 0) {
                if ((i12 & 3072) == 0) {
                    z12 = z11;
                    if (iVarG.a(z12)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i14 |= i16;
                }
                if ((i12 & 24576) == 0) {
                    if ((i13 & 16) == 0) {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        int i26 = iVarG.Q(closedFloatingPointRange3) ? 16384 : 8192;
                        i14 |= i26;
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i14 |= i26;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i17 = i13 & 32;
                if (i17 != 0) {
                    i14 |= 196608;
                    i18 = i11;
                } else {
                    i18 = i11;
                    if ((i12 & 196608) == 0) {
                        if (iVarG.c(i18)) {
                            i19 = 131072;
                        } else {
                            i19 = 65536;
                        }
                        i14 |= i19;
                    }
                }
                i21 = i13 & 64;
                if (i21 != 0) {
                    i14 |= 1572864;
                    function2 = function0;
                } else {
                    function2 = function0;
                    if ((i12 & 1572864) == 0) {
                        if (iVarG.A(function2)) {
                            i22 = 1048576;
                        } else {
                            i22 = 524288;
                        }
                        i14 |= i22;
                    }
                }
                if ((i12 & 12582912) == 0) {
                    if ((i13 & 128) == 0) {
                        jVarA = jVar;
                        int i27 = iVarG.Q(jVarA) ? 8388608 : 4194304;
                        i14 |= i27;
                    } else {
                        jVarA = jVar;
                    }
                    i14 |= i27;
                } else {
                    jVarA = jVar;
                }
                if ((i14 & 4793491) == 4793490 || !iVarG.h()) {
                    iVarG.B();
                    if ((i12 & 1) != 0 || iVarG.J()) {
                        if (i25 != 0) {
                            fVar2 = androidx.compose.ui.f.f3863a;
                        }
                        if (i15 != 0) {
                            z13 = true;
                        } else {
                            z13 = z12;
                        }
                        if ((i13 & 16) != 0) {
                            closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                            i14 &= -57345;
                        } else {
                            closedFloatingPointRangeB = closedFloatingPointRange3;
                        }
                        if (i17 != 0) {
                            i23 = 0;
                        } else {
                            i23 = i18;
                        }
                        if (i21 != 0) {
                            function2 = null;
                        }
                        if ((i13 & 128) != 0) {
                            i14 &= -29360129;
                            jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                        }
                    } else {
                        iVarG.H();
                        if ((i13 & 16) != 0) {
                            i14 &= -57345;
                        }
                        if ((i13 & 128) != 0) {
                            i14 &= -29360129;
                        }
                        z13 = z12;
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                        i23 = i18;
                    }
                    iVarG.s();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                    }
                    objY = iVarG.y();
                    aVar = androidx.compose.runtime.i.f3413a;
                    if (objY == aVar.a()) {
                        objY = o1.h.a();
                        iVarG.p(objY);
                    }
                    iVar2 = (o1.i) objY;
                    objY2 = iVarG.y();
                    if (objY2 == aVar.a()) {
                        objY2 = o1.h.a();
                        iVarG.p(objY2);
                    }
                    iVar3 = (o1.i) objY2;
                    if (i23 < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    a3 a3VarI = r2.i(function1, iVarG, (i14 >> 3) & 14);
                    if ((i14 & 458752) == 131072) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objY3 = iVarG.y();
                    if (z14 || objY3 == aVar.a()) {
                        objY3 = z(i23);
                        iVarG.p(objY3);
                    }
                    List list = (List) objY3;
                    androidx.compose.ui.f fVarC = InteractiveComponentSizeKt.c(fVar2);
                    float f11 = f3052a;
                    BoxWithConstraintsKt.a(SizeKt.i(fVarC, q2.i.h(4 * f11), q2.i.h(f11 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list, function2, a3VarI, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    fVar3 = fVar2;
                    i24 = i23;
                    jVar2 = jVarA;
                    closedFloatingPointRange4 = closedFloatingPointRangeB;
                    function3 = function2;
                    z15 = z13;
                } else {
                    iVarG.H();
                    function3 = function2;
                    fVar3 = fVar2;
                    z15 = z12;
                    i24 = i18;
                    jVar2 = jVarA;
                    closedFloatingPointRange4 = closedFloatingPointRange3;
                }
                g2VarJ = iVarG.j();
                if (g2VarJ != null) {
                    g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar4, Integer num) {
                            invoke(iVar4, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar4, int i28) {
                            SliderKt.b(closedFloatingPointRange, function1, fVar3, z15, closedFloatingPointRange4, i24, function3, jVar2, iVar4, v1.a(i12 | 1), i13);
                        }
                    });
                }
            }
            i14 |= 3072;
            z12 = z11;
            if ((i12 & 24576) == 0) {
                if ((i13 & 16) == 0) {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    if (iVarG.Q(closedFloatingPointRange3)) {
                    }
                    i14 |= i26;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i14 |= i26;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i17 = i13 & 32;
            if (i17 != 0) {
                i14 |= 196608;
                i18 = i11;
            } else {
                i18 = i11;
                if ((i12 & 196608) == 0) {
                    if (iVarG.c(i18)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i14 |= i19;
                }
            }
            i21 = i13 & 64;
            if (i21 != 0) {
                i14 |= 1572864;
                function2 = function0;
            } else {
                function2 = function0;
                if ((i12 & 1572864) == 0) {
                    if (iVarG.A(function2)) {
                        i22 = 1048576;
                    } else {
                        i22 = 524288;
                    }
                    i14 |= i22;
                }
            }
            if ((i12 & 12582912) == 0) {
                if ((i13 & 128) == 0) {
                    jVarA = jVar;
                    if (iVarG.Q(jVarA)) {
                    }
                    i14 |= i27;
                } else {
                    jVarA = jVar;
                }
                i14 |= i27;
            } else {
                jVarA = jVar;
            }
            if ((i14 & 4793491) == 4793490) {
                iVarG.B();
                if ((i12 & 1) != 0) {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                } else {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                }
                objY = iVarG.y();
                aVar = androidx.compose.runtime.i.f3413a;
                if (objY == aVar.a()) {
                    objY = o1.h.a();
                    iVarG.p(objY);
                }
                iVar2 = (o1.i) objY;
                objY2 = iVarG.y();
                if (objY2 == aVar.a()) {
                    objY2 = o1.h.a();
                    iVarG.p(objY2);
                }
                iVar3 = (o1.i) objY2;
                if (i23 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                a3 a3VarI2 = r2.i(function1, iVarG, (i14 >> 3) & 14);
                if ((i14 & 458752) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objY3 = iVarG.y();
                if (z14) {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                } else {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                }
                List list2 = (List) objY3;
                androidx.compose.ui.f fVarC2 = InteractiveComponentSizeKt.c(fVar2);
                float f12 = f3052a;
                BoxWithConstraintsKt.a(SizeKt.i(fVarC2, q2.i.h(4 * f12), q2.i.h(f12 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list2, function2, a3VarI2, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                fVar3 = fVar2;
                i24 = i23;
                jVar2 = jVarA;
                closedFloatingPointRange4 = closedFloatingPointRangeB;
                function3 = function2;
                z15 = z13;
            } else {
                iVarG.B();
                if ((i12 & 1) != 0) {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                } else {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                }
                objY = iVarG.y();
                aVar = androidx.compose.runtime.i.f3413a;
                if (objY == aVar.a()) {
                    objY = o1.h.a();
                    iVarG.p(objY);
                }
                iVar2 = (o1.i) objY;
                objY2 = iVarG.y();
                if (objY2 == aVar.a()) {
                    objY2 = o1.h.a();
                    iVarG.p(objY2);
                }
                iVar3 = (o1.i) objY2;
                if (i23 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                a3 a3VarI3 = r2.i(function1, iVarG, (i14 >> 3) & 14);
                if ((i14 & 458752) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objY3 = iVarG.y();
                if (z14) {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                } else {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                }
                List list3 = (List) objY3;
                androidx.compose.ui.f fVarC3 = InteractiveComponentSizeKt.c(fVar2);
                float f13 = f3052a;
                BoxWithConstraintsKt.a(SizeKt.i(fVarC3, q2.i.h(4 * f13), q2.i.h(f13 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list3, function2, a3VarI3, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                fVar3 = fVar2;
                i24 = i23;
                jVar2 = jVarA;
                closedFloatingPointRange4 = closedFloatingPointRangeB;
                function3 = function2;
                z15 = z13;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar4, Integer num) {
                        invoke(iVar4, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar4, int i28) {
                        SliderKt.b(closedFloatingPointRange, function1, fVar3, z15, closedFloatingPointRange4, i24, function3, jVar2, iVar4, v1.a(i12 | 1), i13);
                    }
                });
            }
        }
        i14 |= 384;
        fVar2 = fVar;
        i15 = i13 & 8;
        if (i15 != 0) {
            if ((i12 & 3072) == 0) {
                z12 = z11;
                if (iVarG.a(z12)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i14 |= i16;
            }
            if ((i12 & 24576) == 0) {
                if ((i13 & 16) == 0) {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    if (iVarG.Q(closedFloatingPointRange3)) {
                    }
                    i14 |= i26;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i14 |= i26;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i17 = i13 & 32;
            if (i17 != 0) {
                i14 |= 196608;
                i18 = i11;
            } else {
                i18 = i11;
                if ((i12 & 196608) == 0) {
                    if (iVarG.c(i18)) {
                        i19 = 131072;
                    } else {
                        i19 = 65536;
                    }
                    i14 |= i19;
                }
            }
            i21 = i13 & 64;
            if (i21 != 0) {
                i14 |= 1572864;
                function2 = function0;
            } else {
                function2 = function0;
                if ((i12 & 1572864) == 0) {
                    if (iVarG.A(function2)) {
                        i22 = 1048576;
                    } else {
                        i22 = 524288;
                    }
                    i14 |= i22;
                }
            }
            if ((i12 & 12582912) == 0) {
                if ((i13 & 128) == 0) {
                    jVarA = jVar;
                    if (iVarG.Q(jVarA)) {
                    }
                    i14 |= i27;
                } else {
                    jVarA = jVar;
                }
                i14 |= i27;
            } else {
                jVarA = jVar;
            }
            if ((i14 & 4793491) == 4793490) {
                iVarG.B();
                if ((i12 & 1) != 0) {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                } else {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                }
                objY = iVarG.y();
                aVar = androidx.compose.runtime.i.f3413a;
                if (objY == aVar.a()) {
                    objY = o1.h.a();
                    iVarG.p(objY);
                }
                iVar2 = (o1.i) objY;
                objY2 = iVarG.y();
                if (objY2 == aVar.a()) {
                    objY2 = o1.h.a();
                    iVarG.p(objY2);
                }
                iVar3 = (o1.i) objY2;
                if (i23 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                a3 a3VarI4 = r2.i(function1, iVarG, (i14 >> 3) & 14);
                if ((i14 & 458752) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objY3 = iVarG.y();
                if (z14) {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                } else {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                }
                List list4 = (List) objY3;
                androidx.compose.ui.f fVarC4 = InteractiveComponentSizeKt.c(fVar2);
                float f14 = f3052a;
                BoxWithConstraintsKt.a(SizeKt.i(fVarC4, q2.i.h(4 * f14), q2.i.h(f14 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list4, function2, a3VarI4, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                fVar3 = fVar2;
                i24 = i23;
                jVar2 = jVarA;
                closedFloatingPointRange4 = closedFloatingPointRangeB;
                function3 = function2;
                z15 = z13;
            } else {
                iVarG.B();
                if ((i12 & 1) != 0) {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                } else {
                    if (i25 != 0) {
                        fVar2 = androidx.compose.ui.f.f3863a;
                    }
                    if (i15 != 0) {
                        z13 = true;
                    } else {
                        z13 = z12;
                    }
                    if ((i13 & 16) != 0) {
                        closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                        i14 &= -57345;
                    } else {
                        closedFloatingPointRangeB = closedFloatingPointRange3;
                    }
                    if (i17 != 0) {
                        i23 = 0;
                    } else {
                        i23 = i18;
                    }
                    if (i21 != 0) {
                        function2 = null;
                    }
                    if ((i13 & 128) != 0) {
                        i14 &= -29360129;
                        jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                    }
                }
                iVarG.s();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                }
                objY = iVarG.y();
                aVar = androidx.compose.runtime.i.f3413a;
                if (objY == aVar.a()) {
                    objY = o1.h.a();
                    iVarG.p(objY);
                }
                iVar2 = (o1.i) objY;
                objY2 = iVarG.y();
                if (objY2 == aVar.a()) {
                    objY2 = o1.h.a();
                    iVarG.p(objY2);
                }
                iVar3 = (o1.i) objY2;
                if (i23 < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                a3 a3VarI5 = r2.i(function1, iVarG, (i14 >> 3) & 14);
                if ((i14 & 458752) == 131072) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objY3 = iVarG.y();
                if (z14) {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                } else {
                    objY3 = z(i23);
                    iVarG.p(objY3);
                }
                List list5 = (List) objY3;
                androidx.compose.ui.f fVarC5 = InteractiveComponentSizeKt.c(fVar2);
                float f15 = f3052a;
                BoxWithConstraintsKt.a(SizeKt.i(fVarC5, q2.i.h(4 * f15), q2.i.h(f15 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list5, function2, a3VarI5, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                fVar3 = fVar2;
                i24 = i23;
                jVar2 = jVarA;
                closedFloatingPointRange4 = closedFloatingPointRangeB;
                function3 = function2;
                z15 = z13;
            }
            g2VarJ = iVarG.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar4, Integer num) {
                        invoke(iVar4, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar4, int i28) {
                        SliderKt.b(closedFloatingPointRange, function1, fVar3, z15, closedFloatingPointRange4, i24, function3, jVar2, iVar4, v1.a(i12 | 1), i13);
                    }
                });
            }
        }
        i14 |= 3072;
        z12 = z11;
        if ((i12 & 24576) == 0) {
            if ((i13 & 16) == 0) {
                closedFloatingPointRange3 = closedFloatingPointRange2;
                if (iVarG.Q(closedFloatingPointRange3)) {
                }
                i14 |= i26;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i14 |= i26;
        } else {
            closedFloatingPointRange3 = closedFloatingPointRange2;
        }
        i17 = i13 & 32;
        if (i17 != 0) {
            i14 |= 196608;
            i18 = i11;
        } else {
            i18 = i11;
            if ((i12 & 196608) == 0) {
                if (iVarG.c(i18)) {
                    i19 = 131072;
                } else {
                    i19 = 65536;
                }
                i14 |= i19;
            }
        }
        i21 = i13 & 64;
        if (i21 != 0) {
            i14 |= 1572864;
            function2 = function0;
        } else {
            function2 = function0;
            if ((i12 & 1572864) == 0) {
                if (iVarG.A(function2)) {
                    i22 = 1048576;
                } else {
                    i22 = 524288;
                }
                i14 |= i22;
            }
        }
        if ((i12 & 12582912) == 0) {
            if ((i13 & 128) == 0) {
                jVarA = jVar;
                if (iVarG.Q(jVarA)) {
                }
                i14 |= i27;
            } else {
                jVarA = jVar;
            }
            i14 |= i27;
        } else {
            jVarA = jVar;
        }
        if ((i14 & 4793491) == 4793490) {
            iVarG.B();
            if ((i12 & 1) != 0) {
                if (i25 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                }
                if (i15 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if ((i13 & 16) != 0) {
                    closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                    i14 &= -57345;
                } else {
                    closedFloatingPointRangeB = closedFloatingPointRange3;
                }
                if (i17 != 0) {
                    i23 = 0;
                } else {
                    i23 = i18;
                }
                if (i21 != 0) {
                    function2 = null;
                }
                if ((i13 & 128) != 0) {
                    i14 &= -29360129;
                    jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                }
            } else {
                if (i25 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                }
                if (i15 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if ((i13 & 16) != 0) {
                    closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                    i14 &= -57345;
                } else {
                    closedFloatingPointRangeB = closedFloatingPointRange3;
                }
                if (i17 != 0) {
                    i23 = 0;
                } else {
                    i23 = i18;
                }
                if (i21 != 0) {
                    function2 = null;
                }
                if ((i13 & 128) != 0) {
                    i14 &= -29360129;
                    jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
            }
            objY = iVarG.y();
            aVar = androidx.compose.runtime.i.f3413a;
            if (objY == aVar.a()) {
                objY = o1.h.a();
                iVarG.p(objY);
            }
            iVar2 = (o1.i) objY;
            objY2 = iVarG.y();
            if (objY2 == aVar.a()) {
                objY2 = o1.h.a();
                iVarG.p(objY2);
            }
            iVar3 = (o1.i) objY2;
            if (i23 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            a3 a3VarI6 = r2.i(function1, iVarG, (i14 >> 3) & 14);
            if ((i14 & 458752) == 131072) {
                z14 = true;
            } else {
                z14 = false;
            }
            objY3 = iVarG.y();
            if (z14) {
                objY3 = z(i23);
                iVarG.p(objY3);
            } else {
                objY3 = z(i23);
                iVarG.p(objY3);
            }
            List list6 = (List) objY3;
            androidx.compose.ui.f fVarC6 = InteractiveComponentSizeKt.c(fVar2);
            float f16 = f3052a;
            BoxWithConstraintsKt.a(SizeKt.i(fVarC6, q2.i.h(4 * f16), q2.i.h(f16 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list6, function2, a3VarI6, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            fVar3 = fVar2;
            i24 = i23;
            jVar2 = jVarA;
            closedFloatingPointRange4 = closedFloatingPointRangeB;
            function3 = function2;
            z15 = z13;
        } else {
            iVarG.B();
            if ((i12 & 1) != 0) {
                if (i25 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                }
                if (i15 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if ((i13 & 16) != 0) {
                    closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                    i14 &= -57345;
                } else {
                    closedFloatingPointRangeB = closedFloatingPointRange3;
                }
                if (i17 != 0) {
                    i23 = 0;
                } else {
                    i23 = i18;
                }
                if (i21 != 0) {
                    function2 = null;
                }
                if ((i13 & 128) != 0) {
                    i14 &= -29360129;
                    jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                }
            } else {
                if (i25 != 0) {
                    fVar2 = androidx.compose.ui.f.f3863a;
                }
                if (i15 != 0) {
                    z13 = true;
                } else {
                    z13 = z12;
                }
                if ((i13 & 16) != 0) {
                    closedFloatingPointRangeB = b20.c.b(0.0f, 1.0f);
                    i14 &= -57345;
                } else {
                    closedFloatingPointRangeB = closedFloatingPointRange3;
                }
                if (i17 != 0) {
                    i23 = 0;
                } else {
                    i23 = i18;
                }
                if (i21 != 0) {
                    function2 = null;
                }
                if ((i13 & 128) != 0) {
                    i14 &= -29360129;
                    jVarA = k.f3095a.a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, iVarG, 0, 6, 1023);
                }
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1556183027, i14, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
            }
            objY = iVarG.y();
            aVar = androidx.compose.runtime.i.f3413a;
            if (objY == aVar.a()) {
                objY = o1.h.a();
                iVarG.p(objY);
            }
            iVar2 = (o1.i) objY;
            objY2 = iVarG.y();
            if (objY2 == aVar.a()) {
                objY2 = o1.h.a();
                iVarG.p(objY2);
            }
            iVar3 = (o1.i) objY2;
            if (i23 < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            a3 a3VarI7 = r2.i(function1, iVarG, (i14 >> 3) & 14);
            if ((i14 & 458752) == 131072) {
                z14 = true;
            } else {
                z14 = false;
            }
            objY3 = iVarG.y();
            if (z14) {
                objY3 = z(i23);
                iVarG.p(objY3);
            } else {
                objY3 = z(i23);
                iVarG.p(objY3);
            }
            List list7 = (List) objY3;
            androidx.compose.ui.f fVarC7 = InteractiveComponentSizeKt.c(fVar2);
            float f17 = f3052a;
            BoxWithConstraintsKt.a(SizeKt.i(fVarC7, q2.i.h(4 * f17), q2.i.h(f17 * 2), 0.0f, 0.0f, 12, null), null, false, androidx.compose.runtime.internal.b.e(652589923, true, new SliderKt$RangeSlider$2(closedFloatingPointRangeB, closedFloatingPointRange, list7, function2, a3VarI7, iVar2, iVar3, z13, i23, jVarA), iVarG, 54), iVarG, 3072, 6);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            fVar3 = fVar2;
            i24 = i23;
            jVar2 = jVarA;
            closedFloatingPointRange4 = closedFloatingPointRangeB;
            function3 = function2;
            z15 = z13;
        }
        g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar4, Integer num) {
                    invoke(iVar4, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar4, int i28) {
                    SliderKt.b(closedFloatingPointRange, function1, fVar3, z15, closedFloatingPointRange4, i24, function3, jVar2, iVar4, v1.a(i12 | 1), i13);
                }
            });
        }
    }

    public static final void c(final boolean z11, final float f11, final float f12, final List<Float> list, final j jVar, final float f13, final o1.i iVar, final o1.i iVar2, final androidx.compose.ui.f fVar, final androidx.compose.ui.f fVar2, final androidx.compose.ui.f fVar3, androidx.compose.runtime.i iVar3, final int i11, final int i12) {
        int i13;
        int i14;
        androidx.compose.runtime.i iVar4;
        androidx.compose.runtime.i iVarG = iVar3.g(-278895713);
        if ((i11 & 6) == 0) {
            i13 = (iVarG.a(z11) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= iVarG.b(f11) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i13 |= iVarG.b(f12) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= iVarG.A(list) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= iVarG.Q(jVar) ? 16384 : 8192;
        }
        if ((i11 & 196608) == 0) {
            i13 |= iVarG.b(f13) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i13 |= iVarG.Q(iVar) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            i13 |= iVarG.Q(iVar2) ? 8388608 : 4194304;
        }
        if ((i11 & 100663296) == 0) {
            i13 |= iVarG.Q(fVar) ? 67108864 : ASTNode.PCTX_STORED;
        }
        if ((i11 & 805306368) == 0) {
            i13 |= iVarG.Q(fVar2) ? ASTNode.DISCARD : ASTNode.DEOP;
        }
        if ((i12 & 6) == 0) {
            i14 = i12 | (iVarG.Q(fVar3) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if ((i13 & 306783379) == 306783378 && (i14 & 3) == 2 && iVarG.h()) {
            iVarG.H();
            iVar4 = iVarG;
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-278895713, i13, i14, "androidx.compose.material.RangeSliderImpl (Slider.kt:633)");
            }
            l.a aVar = l.f3097a;
            final String strA = m.a(aVar.g(), iVarG, 6);
            final String strA2 = m.a(aVar.f(), iVarG, 6);
            androidx.compose.ui.f fVarF = fVar.f(f3059h);
            androidx.compose.ui.b.a aVar2 = androidx.compose.ui.b.f3770a;
            u uVarH = BoxKt.h(aVar2.m(), false);
            int iA = androidx.compose.runtime.g.a(iVarG, 0);
            s sVarN = iVarG.n();
            androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVarG, fVarF);
            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
            Function0<ComposeUiNode> function0A = companion.a();
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA = f3.a(iVarG);
            f3.b(iVarA, uVarH, companion.c());
            f3.b(iVarA, sVarN, companion.e());
            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                iVarA.p(Integer.valueOf(iA));
                iVarA.k(Integer.valueOf(iA), function2B);
            }
            f3.b(iVarA, fVarE, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2386a;
            q2.e eVar = (q2.e) iVarG.l(CompositionLocalsKt.c());
            float fN0 = eVar.N0(f3056e);
            float f14 = f3052a;
            float fN1 = eVar.N0(f14);
            float fH0 = eVar.H0(f13);
            float fH = q2.i.h(f14 * 2);
            float fH2 = q2.i.h(fH0 * f11);
            float fH3 = q2.i.h(fH0 * f12);
            androidx.compose.ui.f.a aVar3 = androidx.compose.ui.f.f3863a;
            androidx.compose.ui.f fVarB = SizeKt.b(boxScopeInstance.b(aVar3, aVar2.g()), 0.0f, 1, null);
            int i15 = i13 >> 9;
            int i16 = i13 << 6;
            int i17 = i13;
            e(fVarB, jVar, z11, f11, f12, list, fN1, fN0, iVarG, (i16 & 896) | (i15 & 112) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752));
            iVar4 = iVarG;
            boolean zQ = iVar4.Q(strA);
            Object objY = iVar4.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function1<androidx.compose.ui.semantics.q, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.semantics.q qVar) {
                        invoke2(qVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.compose.ui.semantics.q qVar) {
                        SemanticsPropertiesKt.v(qVar, strA);
                    }
                };
                iVar4.p(objY);
            }
            int i18 = i17 & 57344;
            int i19 = (i17 << 15) & 458752;
            d(boxScopeInstance, FocusableKt.a(androidx.compose.ui.semantics.n.b(aVar3, true, (Function1) objY), true, iVar).f(fVar2), fH2, iVar, jVar, z11, fH, iVar4, (i15 & 7168) | 1572870 | i18 | i19);
            boolean zQ2 = iVar4.Q(strA2);
            Object objY2 = iVar4.y();
            if (zQ2 || objY2 == androidx.compose.runtime.i.f3413a.a()) {
                objY2 = new Function1<androidx.compose.ui.semantics.q, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.semantics.q qVar) {
                        invoke2(qVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.compose.ui.semantics.q qVar) {
                        SemanticsPropertiesKt.v(qVar, strA2);
                    }
                };
                iVar4.p(objY2);
            }
            d(boxScopeInstance, FocusableKt.a(androidx.compose.ui.semantics.n.b(aVar3, true, (Function1) objY2), true, iVar2).f(fVar3), fH3, iVar2, jVar, z11, fH, iVar4, ((i17 >> 12) & 7168) | 1572870 | i18 | i19);
            iVar4.r();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVar4.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar5, Integer num) {
                    invoke(iVar5, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar5, int i21) {
                    SliderKt.c(z11, f11, f12, list, jVar, f13, iVar, iVar2, fVar, fVar2, fVar3, iVar5, v1.a(i11 | 1), v1.a(i12));
                }
            });
        }
    }

    public static final void d(final androidx.compose.foundation.layout.f fVar, final androidx.compose.ui.f fVar2, final float f11, final o1.i iVar, final j jVar, final boolean z11, final float f12, androidx.compose.runtime.i iVar2, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar2.g(428907178);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= iVarG.Q(fVar2) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= iVarG.b(f11) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= iVarG.Q(iVar) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= iVarG.Q(jVar) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= iVarG.a(z11) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= iVarG.b(f12) ? 1048576 : 524288;
        }
        int i13 = i12;
        if ((599187 & i13) == 599186 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(428907178, i13, -1, "androidx.compose.material.SliderThumb (Slider.kt:696)");
            }
            androidx.compose.ui.f fVarI = PaddingKt.i(androidx.compose.ui.f.f3863a, f11, 0.0f, 0.0f, 0.0f, 14, null);
            androidx.compose.ui.b.a aVar = androidx.compose.ui.b.f3770a;
            androidx.compose.ui.f fVarB = fVar.b(fVarI, aVar.g());
            u uVarH = BoxKt.h(aVar.m(), false);
            int iA = androidx.compose.runtime.g.a(iVarG, 0);
            s sVarN = iVarG.n();
            androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVarG, fVarB);
            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
            Function0<ComposeUiNode> function0A = companion.a();
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA = f3.a(iVarG);
            f3.b(iVarA, uVarH, companion.c());
            f3.b(iVarA, sVarN, companion.e());
            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                iVarA.p(Integer.valueOf(iA));
                iVarA.k(Integer.valueOf(iA), function2B);
            }
            f3.b(iVarA, fVarE, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2386a;
            Object objY = iVarG.y();
            androidx.compose.runtime.i.a aVar2 = androidx.compose.runtime.i.f3413a;
            if (objY == aVar2.a()) {
                objY = r2.d();
                iVarG.p(objY);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objY;
            boolean z12 = (i13 & 7168) == 2048;
            Object objY2 = iVarG.y();
            if (z12 || objY2 == aVar2.a()) {
                objY2 = new SliderKt$SliderThumb$1$1$1(iVar, snapshotStateList, null);
                iVarG.p(objY2);
            }
            int i14 = i13 >> 9;
            g0.d(iVar, (Function2) objY2, iVarG, i14 & 14);
            e0.a(BackgroundKt.a(androidx.compose.ui.draw.m.b(v.b(IndicationKt.b(SizeKt.k(fVar2, f12, f12), iVar, RippleKt.f(false, f3053b, 0L, iVarG, 54, 4)), iVar, false, 2, null), z11 ? snapshotStateList.isEmpty() ^ true ? f3055d : f3054c : q2.i.h(0), p1.g.e(), false, 0L, 0L, 24, null), jVar.c(z11, iVarG, ((i13 >> 15) & 14) | (i14 & 112)).getValue().u(), p1.g.e()), iVarG, 0);
            iVarG.r();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                    invoke(iVar3, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar3, int i15) {
                    SliderKt.d(fVar, fVar2, f11, iVar, jVar, z11, f12, iVar3, v1.a(i11 | 1));
                }
            });
        }
    }

    public static final void e(final androidx.compose.ui.f fVar, final j jVar, final boolean z11, final float f11, final float f12, final List<Float> list, final float f13, final float f14, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i iVarG = iVar.g(1833126050);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= iVarG.Q(jVar) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= iVarG.a(z11) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= iVarG.b(f11) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= iVarG.b(f12) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= iVarG.A(list) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= iVarG.b(f13) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= iVarG.b(f14) ? 8388608 : 4194304;
        }
        if ((i12 & 4793491) == 4793490 && iVarG.h()) {
            iVarG.H();
            iVar2 = iVarG;
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(1833126050, i12, -1, "androidx.compose.material.Track (Slider.kt:747)");
            }
            int i13 = ((i12 >> 6) & 14) | 48 | ((i12 << 3) & 896);
            final a3<w1> a3VarB = jVar.b(z11, false, iVarG, i13);
            final a3<w1> a3VarB2 = jVar.b(z11, true, iVarG, i13);
            final a3<w1> a3VarA = jVar.a(z11, false, iVarG, i13);
            final a3<w1> a3VarA2 = jVar.a(z11, true, iVarG, i13);
            boolean zQ = ((29360128 & i12) == 8388608) | ((i12 & 3670016) == 1048576) | iVarG.Q(a3VarB) | ((57344 & i12) == 16384) | ((i12 & 7168) == 2048) | iVarG.Q(a3VarB2) | iVarG.A(list) | iVarG.Q(a3VarA) | iVarG.Q(a3VarA2);
            Object objY = iVarG.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                iVar2 = iVarG;
                Object obj = new Function1<z1.g, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
                        invoke2(gVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(z1.g gVar) {
                        boolean z12 = gVar.getLayoutDirection() == LayoutDirection.Rtl;
                        long jA = y1.h.a(f13, y1.g.n(gVar.T0()));
                        long jA2 = y1.h.a(y1.m.i(gVar.i()) - f13, y1.g.n(gVar.T0()));
                        long j11 = z12 ? jA2 : jA;
                        if (!z12) {
                            jA = jA2;
                        }
                        long jU = a3VarB.getValue().u();
                        float f15 = f14;
                        e5.a aVar = e5.f4128a;
                        long j12 = j11;
                        z1.f.f(gVar, jU, j11, jA, f15, aVar.b(), null, 0.0f, null, 0, 480, null);
                        z1.f.f(gVar, a3VarB2.getValue().u(), y1.h.a(y1.g.m(j12) + ((y1.g.m(jA) - y1.g.m(j12)) * f11), y1.g.n(gVar.T0())), y1.h.a(y1.g.m(j12) + ((y1.g.m(jA) - y1.g.m(j12)) * f12), y1.g.n(gVar.T0())), f14, aVar.b(), null, 0.0f, null, 0, 480, null);
                        List<Float> list2 = list;
                        float f16 = f12;
                        float f17 = f11;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Object obj2 : list2) {
                            float fFloatValue = ((Number) obj2).floatValue();
                            Boolean boolValueOf = Boolean.valueOf(fFloatValue > f16 || fFloatValue < f17);
                            Object arrayList = linkedHashMap.get(boolValueOf);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                linkedHashMap.put(boolValueOf, arrayList);
                            }
                            ((List) arrayList).add(obj2);
                        }
                        a3<w1> a3Var = a3VarA;
                        a3<w1> a3Var2 = a3VarA2;
                        float f18 = f14;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                            List list3 = (List) entry.getValue();
                            ArrayList arrayList2 = new ArrayList(list3.size());
                            int size = list3.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                arrayList2.add(y1.g.d(y1.h.a(y1.g.m(y1.h.e(j12, jA, ((Number) list3.get(i14)).floatValue())), y1.g.n(gVar.T0()))));
                            }
                            z1.f.h(gVar, arrayList2, v4.f4365a.b(), (zBooleanValue ? a3Var : a3Var2).getValue().u(), f18, e5.f4128a.b(), null, 0.0f, null, 0, 480, null);
                        }
                    }
                };
                iVar2.p(obj);
                objY = obj;
            } else {
                iVar2 = iVarG;
            }
            CanvasKt.a(fVar, (Function1) objY, iVar2, i12 & 14);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVar2.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Track$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar3, Integer num) {
                    invoke(iVar3, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar3, int i14) {
                    SliderKt.e(fVar, jVar, z11, f11, f12, list, f13, f14, iVar3, v1.a(i11 | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object r(androidx.compose.ui.input.pointer.e eVar, long j11, int i11, Continuation<? super Pair<z, Float>> continuation) throws Throwable {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            int i12 = sliderKt$awaitSlop$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label = i12 - Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        } else {
            sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$2 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = sliderKt$awaitSlop$2.label;
        if (i13 == 0) {
            ResultKt.b(obj);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Function2<z, Float, Unit> function2 = new Function2<z, Float, Unit>() { // from class: androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(z zVar, Float f11) {
                    invoke(zVar, f11.floatValue());
                    return Unit.f68710a;
                }

                public final void invoke(z zVar, float f11) {
                    zVar.a();
                    floatRef2.element = f11;
                }
            };
            sliderKt$awaitSlop$2.L$0 = floatRef2;
            sliderKt$awaitSlop$2.label = 1;
            Object objA = DragGestureDetectorCopyKt.a(eVar, j11, i11, function2, sliderKt$awaitSlop$2);
            if (objA == objE) {
                return objE;
            }
            obj = objA;
            floatRef = floatRef2;
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sliderKt$awaitSlop$2.L$0;
            ResultKt.b(obj);
        }
        z zVar = (z) obj;
        if (zVar != null) {
            return TuplesKt.a(zVar, Boxing.c(floatRef.element));
        }
        return null;
    }

    public static final float s(float f11, float f12, float f13) {
        float f14 = f12 - f11;
        float f15 = f14 == 0.0f ? 0.0f : (f13 - f11) / f14;
        float f16 = f15 >= 0.0f ? f15 : 0.0f;
        if (f16 > 1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public static final float t() {
        return f3052a;
    }

    public static final androidx.compose.ui.f u(androidx.compose.ui.f fVar, o1.i iVar, o1.i iVar2, a3<Float> a3Var, a3<Float> a3Var2, boolean z11, boolean z12, float f11, ClosedFloatingPointRange<Float> closedFloatingPointRange, a3<? extends Function1<? super Boolean, Unit>> a3Var3, a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var4) {
        return z11 ? o0.e(fVar, new Object[]{iVar, iVar2, Float.valueOf(f11), Boolean.valueOf(z12), closedFloatingPointRange}, new SliderKt$rangeSliderPressDragModifier$1(iVar, iVar2, a3Var, a3Var2, a3Var4, z12, f11, a3Var3, null)) : fVar;
    }

    public static final float v(float f11, float f12, float f13, float f14, float f15) {
        return s2.b.b(f14, f15, s(f11, f12, f13));
    }

    public static final ClosedFloatingPointRange<Float> w(float f11, float f12, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f13, float f14) {
        return b20.c.b(v(f11, f12, closedFloatingPointRange.j().floatValue(), f13, f14), v(f11, f12, closedFloatingPointRange.f().floatValue(), f13, f14));
    }

    public static final androidx.compose.ui.f x(androidx.compose.ui.f fVar, float f11, final boolean z11, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i11) {
        final float fJ = kotlin.ranges.a.j(f11, closedFloatingPointRange.j().floatValue(), closedFloatingPointRange.f().floatValue());
        return ProgressSemanticsKt.a(androidx.compose.ui.semantics.n.c(fVar, false, new Function1<androidx.compose.ui.semantics.q, Unit>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.semantics.q qVar) {
                invoke2(qVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.semantics.q qVar) {
                if (!z11) {
                    SemanticsPropertiesKt.f(qVar);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i12 = i11;
                final float f12 = fJ;
                final Function1<Float, Unit> function2 = function1;
                final Function0<Unit> function3 = function0;
                SemanticsPropertiesKt.z(qVar, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Boolean invoke(float f13) {
                        int i13;
                        float fJ2 = kotlin.ranges.a.j(f13, closedFloatingPointRange2.j().floatValue(), closedFloatingPointRange2.f().floatValue());
                        int i14 = i12;
                        boolean z12 = false;
                        if (i14 > 0 && (i13 = i14 + 1) >= 0) {
                            float fAbs = fJ2;
                            float f14 = fAbs;
                            int i15 = 0;
                            while (true) {
                                float fB = s2.b.b(closedFloatingPointRange2.j().floatValue(), closedFloatingPointRange2.f().floatValue(), i15 / (i12 + 1));
                                float f15 = fB - fJ2;
                                if (Math.abs(f15) <= fAbs) {
                                    fAbs = Math.abs(f15);
                                    f14 = fB;
                                }
                                if (i15 == i13) {
                                    break;
                                }
                                i15++;
                            }
                            fJ2 = f14;
                        }
                        if (fJ2 != f12) {
                            function2.invoke(Float.valueOf(fJ2));
                            Function0<Unit> function4 = function3;
                            if (function4 != null) {
                                function4.invoke();
                            }
                            z12 = true;
                        }
                        return Boolean.valueOf(z12);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f13) {
                        return invoke(f13.floatValue());
                    }
                }, 1, null);
            }
        }, 1, null), f11, closedFloatingPointRange, i11);
    }

    public static final float y(float f11, List<Float> list, float f12, float f13) {
        Float f14;
        if (list.isEmpty()) {
            f14 = null;
        } else {
            Float f15 = list.get(0);
            float fAbs = Math.abs(s2.b.b(f12, f13, f15.floatValue()) - f11);
            int iN = kotlin.collections.g.n(list);
            int i11 = 1;
            if (1 <= iN) {
                while (true) {
                    Float f16 = list.get(i11);
                    float fAbs2 = Math.abs(s2.b.b(f12, f13, f16.floatValue()) - f11);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f15 = f16;
                        fAbs = fAbs2;
                    }
                    if (i11 == iN) {
                        break;
                    }
                    i11++;
                }
            }
            f14 = f15;
        }
        Float f17 = f14;
        return f17 != null ? s2.b.b(f12, f13, f17.floatValue()) : f11;
    }

    public static final List<Float> z(int i11) {
        if (i11 == 0) {
            return kotlin.collections.g.l();
        }
        int i12 = i11 + 2;
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(Float.valueOf(i13 / (i11 + 1)));
        }
        return arrayList;
    }
}
