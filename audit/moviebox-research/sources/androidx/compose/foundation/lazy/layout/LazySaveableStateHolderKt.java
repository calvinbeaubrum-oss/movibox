package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.t1;
import androidx.compose.runtime.v1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class LazySaveableStateHolderKt {
    public static final void a(final Function3<? super androidx.compose.runtime.saveable.a, ? super androidx.compose.runtime.i, ? super Integer, Unit> function3, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(674185128);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(function3) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(674185128, i12, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)");
            }
            final androidx.compose.runtime.saveable.b bVar = (androidx.compose.runtime.saveable.b) iVarG.l(SaveableStateRegistryKt.d());
            Object[] objArr = {bVar};
            androidx.compose.runtime.saveable.d<LazySaveableStateHolder, Map<String, List<Object>>> dVarA = LazySaveableStateHolder.f2665d.a(bVar);
            boolean zA = iVarG.A(bVar);
            Object objY = iVarG.y();
            if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function0<LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LazySaveableStateHolder invoke() {
                        return new LazySaveableStateHolder(bVar, kotlin.collections.s.h());
                    }
                };
                iVarG.p(objY);
            }
            final LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) RememberSaveableKt.c(objArr, dVarA, null, (Function0) objY, iVarG, 0, 4);
            CompositionLocalKt.a(SaveableStateRegistryKt.d().d(lazySaveableStateHolder), androidx.compose.runtime.internal.b.e(1863926504, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1
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
                    if ((i13 & 3) == 2 && iVar2.h()) {
                        iVar2.H();
                        return;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(1863926504, i13, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:49)");
                    }
                    lazySaveableStateHolder.i(SaveableStateHolderKt.a(iVar2, 0));
                    function3.invoke(lazySaveableStateHolder, iVar2, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            }, iVarG, 54), iVarG, t1.f3721i | 48);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2
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
                    LazySaveableStateHolderKt.a(function3, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }
}
