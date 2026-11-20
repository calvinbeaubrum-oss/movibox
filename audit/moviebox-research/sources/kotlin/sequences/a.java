package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a<T, K> extends AbstractIterator<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator<T> f69078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<T, K> f69079d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<K> f69080f;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Iterator<? extends T> source, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.g(source, "source");
        Intrinsics.g(keySelector, "keySelector");
        this.f69078c = source;
        this.f69079d = keySelector;
        this.f69080f = new HashSet<>();
    }

    @Override // kotlin.collections.AbstractIterator
    public void a() {
        while (this.f69078c.hasNext()) {
            T next = this.f69078c.next();
            if (this.f69080f.add(this.f69079d.invoke(next))) {
                d(next);
                return;
            }
        }
        c();
    }
}
