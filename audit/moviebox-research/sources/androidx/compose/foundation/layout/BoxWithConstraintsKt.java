package androidx.compose.foundation.layout;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.s0;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class BoxWithConstraintsKt {
    public static final void a(androidx.compose.ui.f fVar, androidx.compose.ui.b bVar, boolean z11, final Function3<? super g, ? super androidx.compose.runtime.i, ? super Integer, Unit> function3, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(1781813501);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i15 = i12 & 2;
        if (i15 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= iVarG.Q(bVar) ? 32 : 16;
        }
        int i16 = i12 & 4;
        if (i16 != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            i13 |= iVarG.a(z11) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= 3072;
        } else if ((i11 & 3072) == 0) {
            i13 |= iVarG.A(function3) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && iVarG.h()) {
            iVarG.H();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f3863a;
            }
            if (i15 != 0) {
                bVar = androidx.compose.ui.b.f3770a.m();
            }
            if (i16 != 0) {
                z11 = false;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(1781813501, i13, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:64)");
            }
            final androidx.compose.ui.layout.u uVarH = BoxKt.h(bVar, z11);
            boolean zQ = ((i13 & 7168) == 2048) | iVarG.Q(uVarH);
            Object objY = iVarG.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function2<s0, q2.b, androidx.compose.ui.layout.w>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ androidx.compose.ui.layout.w invoke(s0 s0Var, q2.b bVar2) {
                        return m25invoke0kLqBqw(s0Var, bVar2.r());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final androidx.compose.ui.layout.w m25invoke0kLqBqw(s0 s0Var, long j11) {
                        final h hVar = new h(s0Var, j11, null);
                        Unit unit = Unit.f68710a;
                        final Function3<g, androidx.compose.runtime.i, Integer, Unit> function4 = function3;
                        return uVarH.c(s0Var, s0Var.J(unit, androidx.compose.runtime.internal.b.c(-1945019079, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1
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

                            public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                                if ((i17 & 3) == 2 && iVar2.h()) {
                                    iVar2.H();
                                    return;
                                }
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-1945019079, i17, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:68)");
                                }
                                function4.invoke(hVar, iVar2, 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                            }
                        })), j11);
                    }
                };
                iVarG.p(objY);
            }
            SubcomposeLayoutKt.a(fVar, (Function2) objY, iVarG, i13 & 14, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        final androidx.compose.ui.b bVar2 = bVar;
        final boolean z12 = z11;
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                    BoxWithConstraintsKt.a(fVar2, bVar2, z12, function3, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
