package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public abstract class a<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f3346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f3347b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f3348c;

    public a(T t11) {
        this.f3346a = t11;
        this.f3348c = t11;
    }

    @Override // androidx.compose.runtime.f
    public T a() {
        return this.f3348c;
    }

    @Override // androidx.compose.runtime.f
    public final void clear() {
        this.f3347b.clear();
        l(this.f3346a);
        k();
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void e() {
        e.b(this);
    }

    @Override // androidx.compose.runtime.f
    public void g(T t11) {
        this.f3347b.add(a());
        l(t11);
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void h() {
        e.a(this);
    }

    @Override // androidx.compose.runtime.f
    public void i() {
        if (!(!this.f3347b.isEmpty())) {
            o1.b("empty stack");
        }
        List<T> list = this.f3347b;
        l(list.remove(list.size() - 1));
    }

    public final T j() {
        return this.f3346a;
    }

    public abstract void k();

    public void l(T t11) {
        this.f3348c = t11;
    }
}
