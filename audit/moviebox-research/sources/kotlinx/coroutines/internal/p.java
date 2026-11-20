package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

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
public class p<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69479a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public p(boolean z11) {
        this._cur$volatile = new q(8, z11);
    }

    public final boolean a(E e11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69479a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            int iA = qVar.a(e11);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                androidx.concurrent.futures.a.a(f69479a, this, qVar, qVar.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69479a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(f69479a, this, qVar, qVar.l());
            }
        }
    }

    public final int c() {
        return ((q) f69479a.get(this)).g();
    }

    public final E e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69479a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            E e11 = (E) qVar.m();
            if (e11 != q.f69483h) {
                return e11;
            }
            androidx.concurrent.futures.a.a(f69479a, this, qVar, qVar.l());
        }
    }
}
