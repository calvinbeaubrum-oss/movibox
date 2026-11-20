package g2;

import androidx.compose.ui.f;
import kotlin.Metadata;
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
public final class b extends f.c implements a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super c, Boolean> f65382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super c, Boolean> f65383p;

    public b(Function1<? super c, Boolean> function1, Function1<? super c, Boolean> function2) {
        this.f65382o = function1;
        this.f65383p = function2;
    }

    @Override // g2.a
    public boolean F(c cVar) {
        Function1<? super c, Boolean> function1 = this.f65382o;
        if (function1 != null) {
            return function1.invoke(cVar).booleanValue();
        }
        return false;
    }

    public final void H1(Function1<? super c, Boolean> function1) {
        this.f65382o = function1;
    }

    public final void I1(Function1<? super c, Boolean> function1) {
        this.f65383p = function1;
    }

    @Override // g2.a
    public boolean Y0(c cVar) {
        Function1<? super c, Boolean> function1 = this.f65383p;
        if (function1 != null) {
            return function1.invoke(cVar).booleanValue();
        }
        return false;
    }
}
