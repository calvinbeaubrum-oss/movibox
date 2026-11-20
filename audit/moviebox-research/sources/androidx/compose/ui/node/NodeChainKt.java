package androidx.compose.ui.node;

import androidx.compose.ui.CombinedModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class NodeChainKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5043a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.compose.ui.f.c {
        public String toString() {
            return "<Head>";
        }
    }

    static {
        a aVar = new a();
        aVar.x1(-1);
        f5043a = aVar;
    }

    public static final int d(androidx.compose.ui.f.b bVar, androidx.compose.ui.f.b bVar2) {
        if (Intrinsics.b(bVar, bVar2)) {
            return 2;
        }
        return androidx.compose.ui.a.a(bVar, bVar2) ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> e(androidx.compose.ui.f fVar, final androidx.compose.runtime.collection.b<androidx.compose.ui.f.b> bVar) {
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f[kotlin.ranges.a.d(bVar.r(), 16)], 0);
        bVar2.b(fVar);
        Function1<androidx.compose.ui.f.b, Boolean> function1 = null;
        while (bVar2.u()) {
            androidx.compose.ui.f fVar2 = (androidx.compose.ui.f) bVar2.z(bVar2.r() - 1);
            if (fVar2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) fVar2;
                bVar2.b(combinedModifier.a());
                bVar2.b(combinedModifier.o());
            } else if (fVar2 instanceof androidx.compose.ui.f.b) {
                bVar.b(fVar2);
            } else {
                if (function1 == null) {
                    function1 = new Function1<androidx.compose.ui.f.b, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt$fillVector$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(androidx.compose.ui.f.b bVar3) {
                            bVar.b(bVar3);
                            return Boolean.TRUE;
                        }
                    };
                }
                fVar2.d(function1);
                function1 = function1;
            }
        }
        return bVar;
    }

    public static final <T extends androidx.compose.ui.f.c> void f(l0<T> l0Var, androidx.compose.ui.f.c cVar) {
        Intrinsics.e(cVar, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        l0Var.o(cVar);
    }
}
