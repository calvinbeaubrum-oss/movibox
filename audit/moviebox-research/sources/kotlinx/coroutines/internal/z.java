package kotlinx.coroutines.internal;

import com.tn.lib.view.FlowLayout;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.internal.z;

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
@SourceDebugExtension
public abstract class z<S extends z<S>> extends e<S> implements e2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69496d = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final long f69497c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public z(long j11, S s11, int i11) {
        super(s11);
        this.f69497c = j11;
        this.cleanedAndPointers$volatile = i11 << 16;
    }

    @Override // kotlinx.coroutines.internal.e
    public boolean j() {
        return f69496d.get(this) == q() && !k();
    }

    public final boolean o() {
        return f69496d.addAndGet(this, FlowLayout.SPACING_AUTO) == q() && !k();
    }

    public abstract int q();

    public abstract void r(int i11, Throwable th2, CoroutineContext coroutineContext);

    public final void s() {
        if (f69496d.incrementAndGet(this) == q()) {
            m();
        }
    }

    public final boolean t() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f69496d;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 == q() && !k()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, 65536 + i11));
        return true;
    }
}
