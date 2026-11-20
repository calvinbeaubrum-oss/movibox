package androidx.compose.foundation;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.graphics.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class BorderKt {
    public static final androidx.compose.ui.f e(androidx.compose.ui.f fVar, float f11, long j11, c5 c5Var) {
        return f(fVar, f11, new d5(j11, null), c5Var);
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, float f11, l1 l1Var, c5 c5Var) {
        return fVar.f(new BorderModifierNodeElement(f11, l1Var, c5Var, null));
    }

    public static final y1.k g(float f11, y1.k kVar) {
        return new y1.k(f11, f11, kVar.j() - f11, kVar.d() - f11, k(kVar.h(), f11), k(kVar.i(), f11), k(kVar.c(), f11), k(kVar.b(), f11), null);
    }

    public static final Path h(Path path, y1.k kVar, float f11, boolean z11) {
        path.reset();
        q4.b(path, kVar, null, 2, null);
        if (!z11) {
            Path pathA = z0.a();
            q4.b(pathA, g(f11, kVar), null, 2, null);
            path.l(path, pathA, u4.f4354a.a());
        }
        return path;
    }

    public static final androidx.compose.ui.draw.i i(androidx.compose.ui.draw.c cVar) {
        return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar2) {
                invoke2(cVar2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.c cVar2) {
                cVar2.a1();
            }
        });
    }

    public static final androidx.compose.ui.draw.i j(androidx.compose.ui.draw.c cVar, final l1 l1Var, long j11, long j12, boolean z11, float f11) {
        final long jC = z11 ? y1.g.f81070b.c() : j11;
        final long jI = z11 ? cVar.i() : j12;
        final z1.h mVar = z11 ? z1.l.f81716a : new z1.m(f11, 0.0f, 0, 0, null, 30, null);
        return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar2) {
                invoke2(cVar2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.c cVar2) {
                cVar2.a1();
                z1.f.i(cVar2, l1Var, jC, jI, 0.0f, mVar, null, 0, 104, null);
            }
        });
    }

    public static final long k(long j11, float f11) {
        return y1.b.a(Math.max(0.0f, y1.a.d(j11) - f11), Math.max(0.0f, y1.a.e(j11) - f11));
    }
}
