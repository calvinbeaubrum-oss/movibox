package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class v2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<androidx.compose.runtime.internal.g> f3735a = new AtomicReference<>(androidx.compose.runtime.internal.h.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3736b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f3737c;

    public final T a() {
        long id2 = Thread.currentThread().getId();
        return id2 == ActualAndroid_androidKt.d() ? this.f3737c : (T) this.f3735a.get().b(id2);
    }

    public final void b(T t11) {
        long id2 = Thread.currentThread().getId();
        if (id2 == ActualAndroid_androidKt.d()) {
            this.f3737c = t11;
            return;
        }
        synchronized (this.f3736b) {
            androidx.compose.runtime.internal.g gVar = this.f3735a.get();
            if (gVar.d(id2, t11)) {
                return;
            }
            this.f3735a.set(gVar.c(id2, t11));
            Unit unit = Unit.f68710a;
        }
    }
}
