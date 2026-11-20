package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h0;

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
public final class l<E> extends b<E> implements m<E> {
    public l(CoroutineContext coroutineContext, a<E> aVar) {
        super(coroutineContext, aVar, true, true);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.q1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    public void onCancelled(Throwable th2, boolean z11) {
        if (s().p(th2) || z11) {
            return;
        }
        h0.a(getContext(), th2);
    }

    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onCompleted(Unit unit) {
        p.a.a(s(), null, 1, null);
    }
}
