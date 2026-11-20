package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.s0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class LazyLayoutKt {
    public static final void a(final Function0<? extends m> function0, final androidx.compose.ui.f fVar, final x xVar, final Function2<? super q, ? super q2.b, ? extends androidx.compose.ui.layout.w> function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(2002163445);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (iVarG.A(function0) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i14 = i12 & 2;
        if (i14 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= iVarG.Q(fVar) ? 32 : 16;
        }
        int i15 = i12 & 4;
        if (i15 != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            i13 |= iVarG.Q(xVar) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= 3072;
        } else if ((i11 & 3072) == 0) {
            i13 |= iVarG.A(function2) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && iVarG.h()) {
            iVarG.H();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f3863a;
            }
            if (i15 != 0) {
                xVar = null;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(2002163445, i13, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:78)");
            }
            final a3 a3VarI = r2.i(function0, iVarG, i13 & 14);
            LazySaveableStateHolderKt.a(androidx.compose.runtime.internal.b.e(-1488997347, true, new Function3<androidx.compose.runtime.saveable.a, androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.saveable.a aVar, androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(aVar, iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.saveable.a aVar, androidx.compose.runtime.i iVar2, int i16) {
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-1488997347, i16, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:82)");
                    }
                    final a3<Function0<m>> a3Var = a3VarI;
                    Object objY = iVar2.y();
                    androidx.compose.runtime.i.a aVar2 = androidx.compose.runtime.i.f3413a;
                    if (objY == aVar2.a()) {
                        objY = new LazyLayoutItemContentFactory(aVar, new Function0<m>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final m invoke() {
                                return a3Var.getValue().invoke();
                            }
                        });
                        iVar2.p(objY);
                    }
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objY;
                    Object objY2 = iVar2.y();
                    if (objY2 == aVar2.a()) {
                        objY2 = new SubcomposeLayoutState(new o(lazyLayoutItemContentFactory));
                        iVar2.p(objY2);
                    }
                    final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objY2;
                    if (xVar != null) {
                        iVar2.R(205264983);
                        final i0 i0VarD = xVar.d();
                        if (i0VarD == null) {
                            iVar2.R(6622915);
                            i0VarD = j0.a(iVar2, 0);
                        } else {
                            iVar2.R(6621830);
                        }
                        iVar2.L();
                        Object[] objArr = {xVar, lazyLayoutItemContentFactory, subcomposeLayoutState, i0VarD};
                        boolean zQ = iVar2.Q(xVar) | iVar2.A(lazyLayoutItemContentFactory) | iVar2.A(subcomposeLayoutState) | iVar2.A(i0VarD);
                        final x xVar2 = xVar;
                        Object objY3 = iVar2.y();
                        if (zQ || objY3 == aVar2.a()) {
                            objY3 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$1$1

                                /* JADX INFO: compiled from: source.java */
                                @Metadata
                                @SourceDebugExtension
                                public static final class a implements androidx.compose.runtime.c0 {

                                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                                    public final /* synthetic */ x f2650a;

                                    public a(x xVar) {
                                        this.f2650a = xVar;
                                    }

                                    @Override // androidx.compose.runtime.c0
                                    public void dispose() {
                                        this.f2650a.f(null);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                                    xVar2.f(new PrefetchHandleProvider(lazyLayoutItemContentFactory, subcomposeLayoutState, i0VarD));
                                    return new a(xVar2);
                                }
                            };
                            iVar2.p(objY3);
                        }
                        androidx.compose.runtime.g0.b(objArr, (Function1) objY3, iVar2, 0);
                        iVar2.L();
                    } else {
                        iVar2.R(205858881);
                        iVar2.L();
                    }
                    androidx.compose.ui.f fVarB = y.b(fVar, xVar);
                    boolean zQ2 = iVar2.Q(lazyLayoutItemContentFactory) | iVar2.Q(function2);
                    final Function2<q, q2.b, androidx.compose.ui.layout.w> function3 = function2;
                    Object objY4 = iVar2.y();
                    if (zQ2 || objY4 == aVar2.a()) {
                        objY4 = new Function2<s0, q2.b, androidx.compose.ui.layout.w>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ androidx.compose.ui.layout.w invoke(s0 s0Var, q2.b bVar) {
                                return m34invoke0kLqBqw(s0Var, bVar.r());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final androidx.compose.ui.layout.w m34invoke0kLqBqw(s0 s0Var, long j11) {
                                return function3.invoke(new r(lazyLayoutItemContentFactory, s0Var), q2.b.a(j11));
                            }
                        };
                        iVar2.p(objY4);
                    }
                    SubcomposeLayoutKt.b(subcomposeLayoutState, fVarB, (Function2) objY4, iVar2, SubcomposeLayoutState.f4844f, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            }, iVarG, 54), iVarG, 6);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        final x xVar2 = xVar;
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$4
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i16) {
                    LazyLayoutKt.a(function0, fVar2, xVar2, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
