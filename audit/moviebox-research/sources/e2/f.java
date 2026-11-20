package e2;

import android.view.KeyEvent;
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
public final class f extends androidx.compose.ui.f.c implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super b, Boolean> f63786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super b, Boolean> f63787p;

    public f(Function1<? super b, Boolean> function1, Function1<? super b, Boolean> function2) {
        this.f63786o = function1;
        this.f63787p = function2;
    }

    @Override // e2.e
    public boolean B0(KeyEvent keyEvent) {
        Function1<? super b, Boolean> function1 = this.f63786o;
        if (function1 != null) {
            return function1.invoke(b.a(keyEvent)).booleanValue();
        }
        return false;
    }

    public final void H1(Function1<? super b, Boolean> function1) {
        this.f63786o = function1;
    }

    public final void I1(Function1<? super b, Boolean> function1) {
        this.f63787p = function1;
    }

    @Override // e2.e
    public boolean t0(KeyEvent keyEvent) {
        Function1<? super b, Boolean> function1 = this.f63787p;
        if (function1 != null) {
            return function1.invoke(b.a(keyEvent)).booleanValue();
        }
        return false;
    }
}
