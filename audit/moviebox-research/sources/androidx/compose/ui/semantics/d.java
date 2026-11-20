package androidx.compose.ui.semantics;

import androidx.compose.ui.node.i1;
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
public final class d extends androidx.compose.ui.f.c implements i1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super q, Unit> f5637q;

    public d(boolean z11, boolean z12, Function1<? super q, Unit> function1) {
        this.f5635o = z11;
        this.f5636p = z12;
        this.f5637q = function1;
    }

    public final void H1(boolean z11) {
        this.f5635o = z11;
    }

    public final void I1(Function1<? super q, Unit> function1) {
        this.f5637q = function1;
    }

    @Override // androidx.compose.ui.node.i1
    public boolean V() {
        return this.f5636p;
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(q qVar) {
        this.f5637q.invoke(qVar);
    }

    @Override // androidx.compose.ui.node.i1
    public boolean Z0() {
        return this.f5635o;
    }
}
