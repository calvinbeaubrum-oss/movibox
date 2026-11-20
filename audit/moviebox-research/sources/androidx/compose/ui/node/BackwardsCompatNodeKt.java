package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class BackwardsCompatNodeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4916a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function1<BackwardsCompatNode, Unit> f4917b = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$onDrawCacheReadsChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BackwardsCompatNode backwardsCompatNode) {
            invoke2(backwardsCompatNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.L1();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function1<BackwardsCompatNode, Unit> f4918c = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BackwardsCompatNode backwardsCompatNode) {
            invoke2(backwardsCompatNode);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.P1();
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.ui.modifier.k {
        @Override // androidx.compose.ui.modifier.k
        public <T> T W(androidx.compose.ui.modifier.c<T> cVar) {
            return cVar.a().invoke();
        }
    }

    public static final boolean e(BackwardsCompatNode backwardsCompatNode) {
        androidx.compose.ui.f.c cVarO = g.m(backwardsCompatNode).e0().o();
        Intrinsics.e(cVarO, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((l1) cVarO).H1();
    }
}
