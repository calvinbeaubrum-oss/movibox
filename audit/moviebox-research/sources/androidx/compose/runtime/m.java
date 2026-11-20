package androidx.compose.runtime;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

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
public abstract class m {
    public abstract void a(y yVar, Function2<? super i, ? super Integer, Unit> function2);

    public abstract void b(y0 y0Var);

    public void c() {
    }

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public n1 g() {
        return n.f3512a;
    }

    public abstract int h();

    public abstract CoroutineContext i();

    public u j() {
        return null;
    }

    public abstract void k(y0 y0Var);

    public abstract void l(y yVar);

    public abstract void m(y0 y0Var, x0 x0Var);

    public x0 n(y0 y0Var) {
        return null;
    }

    public void o(Set<w1.a> set) {
    }

    public void p(i iVar) {
    }

    public abstract void q(y yVar);

    public void r() {
    }

    public void s(i iVar) {
    }

    public abstract void t(y yVar);
}
