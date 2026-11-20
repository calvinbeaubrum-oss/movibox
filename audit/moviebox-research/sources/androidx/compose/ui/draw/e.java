package androidx.compose.ui.draw;

import androidx.compose.ui.node.n;
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
public final class e extends androidx.compose.ui.f.c implements n {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super z1.g, Unit> f3855o;

    public e(Function1<? super z1.g, Unit> function1) {
        this.f3855o = function1;
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        this.f3855o.invoke(cVar);
        cVar.a1();
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        androidx.compose.ui.node.m.a(this);
    }

    public final void H1(Function1<? super z1.g, Unit> function1) {
        this.f3855o = function1;
    }
}
