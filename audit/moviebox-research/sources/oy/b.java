package oy;

import androidx.lifecycle.c0;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class b<T> extends c0<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList<T> f73448l = new LinkedList<>();

    @Override // androidx.lifecycle.c0, androidx.lifecycle.LiveData
    public void n(T t11) {
        synchronized (this.f73448l) {
            try {
                this.f73448l.add(t11);
                if (this.f73448l.size() == 1) {
                    super.n(t11);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.lifecycle.c0, androidx.lifecycle.LiveData
    public void q(T t11) {
        super.q(t11);
        synchronized (this.f73448l) {
            this.f73448l.pollFirst();
            T tPeekFirst = this.f73448l.peekFirst();
            if (tPeekFirst != null) {
                super.n(tPeekFirst);
                Unit unit = Unit.f68710a;
            }
        }
    }
}
