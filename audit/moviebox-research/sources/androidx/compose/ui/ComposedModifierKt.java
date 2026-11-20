package androidx.compose.ui;

import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class ComposedModifierKt {
    public static final f b(f fVar, Function1<? super e1, Unit> function1, Function3<? super f, ? super androidx.compose.runtime.i, ? super Integer, ? extends f> function3) {
        return fVar.f(new d(function1, function3));
    }

    public static /* synthetic */ f c(f fVar, Function1 function1, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = InspectableValueKt.a();
        }
        return b(fVar, function1, function3);
    }

    public static final f d(final androidx.compose.runtime.i iVar, f fVar) {
        if (fVar.d(new Function1<f.b, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(f.b bVar) {
                return Boolean.valueOf(!(bVar instanceof d));
            }
        })) {
            return fVar;
        }
        iVar.x(1219399079);
        f fVar2 = (f) fVar.c(f.f3863a, new Function2<f, f.b, f>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$result$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final f invoke(f fVar3, f.b bVar) {
                boolean z11 = bVar instanceof d;
                f fVarD = bVar;
                if (z11) {
                    Function3<f, androidx.compose.runtime.i, Integer, f> function3A = ((d) bVar).a();
                    Intrinsics.e(function3A, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    fVarD = ComposedModifierKt.d(iVar, (f) ((Function3) TypeIntrinsics.e(function3A, 3)).invoke(f.f3863a, iVar, 0));
                }
                return fVar3.f(fVarD);
            }
        });
        iVar.P();
        return fVar2;
    }

    @JvmName
    public static final f e(androidx.compose.runtime.i iVar, f fVar) {
        iVar.R(439770924);
        f fVarD = d(iVar, fVar);
        iVar.L();
        return fVarD;
    }
}
