package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class CompositionLocalKt {
    public static final void a(final t1<?> t1Var, final Function2<? super i, ? super Integer, Unit> function2, i iVar, final int i11) {
        i iVarG = iVar.g(-1350970552);
        if (k.J()) {
            k.S(-1350970552, i11, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:398)");
        }
        iVarG.E(t1Var);
        function2.invoke(iVarG, Integer.valueOf((i11 >> 3) & 14));
        iVarG.q();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    CompositionLocalKt.a(t1Var, function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public static final void b(final t1<?>[] t1VarArr, final Function2<? super i, ? super Integer, Unit> function2, i iVar, final int i11) {
        i iVarG = iVar.g(-1390796515);
        if (k.J()) {
            k.S(-1390796515, i11, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:377)");
        }
        iVarG.S(t1VarArr);
        function2.invoke(iVarG, Integer.valueOf((i11 >> 3) & 14));
        iVarG.I();
        if (k.J()) {
            k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    t1<?>[] t1VarArr2 = t1VarArr;
                    CompositionLocalKt.b((t1[]) Arrays.copyOf(t1VarArr2, t1VarArr2.length), function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public static final <T> s1<T> c(q2<T> q2Var, Function0<? extends T> function0) {
        return new e0(q2Var, function0);
    }

    public static /* synthetic */ s1 d(q2 q2Var, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            q2Var = r2.j();
        }
        return c(q2Var, function0);
    }

    public static final <T> s1<T> e(Function1<? super r, ? extends T> function1) {
        return new ComputedProvidableCompositionLocal(function1);
    }

    public static final <T> s1<T> f(Function0<? extends T> function0) {
        return new b3(function0);
    }
}
