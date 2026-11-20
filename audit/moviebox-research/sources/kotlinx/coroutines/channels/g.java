package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.s2;

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
public final class g<E> extends z<g<E>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedChannel<E> f69257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f69258g;

    public g(long j11, g<E> gVar, BufferedChannel<E> bufferedChannel, int i11) {
        super(j11, gVar, i11);
        this.f69257f = bufferedChannel;
        this.f69258g = new AtomicReferenceArray(BufferedChannelKt.f69231b * 2);
    }

    public final Object A(int i11) {
        return y().get((i11 * 2) + 1);
    }

    public final void B(int i11, boolean z11) {
        if (z11) {
            x().T0((this.f69497c * ((long) BufferedChannelKt.f69231b)) + ((long) i11));
        }
        s();
    }

    public final E C(int i11) {
        E eZ = z(i11);
        v(i11);
        return eZ;
    }

    public final void D(int i11, Object obj) {
        y().set(i11 * 2, obj);
    }

    public final void E(int i11, Object obj) {
        y().set((i11 * 2) + 1, obj);
    }

    public final void F(int i11, E e11) {
        D(i11, e11);
    }

    @Override // kotlinx.coroutines.internal.z
    public int q() {
        return BufferedChannelKt.f69231b;
    }

    @Override // kotlinx.coroutines.internal.z
    public void r(int i11, Throwable th2, CoroutineContext coroutineContext) {
        Function1<E, Unit> function1;
        Function1<E, Unit> function2;
        int i12 = BufferedChannelKt.f69231b;
        boolean z11 = i11 >= i12;
        if (z11) {
            i11 -= i12;
        }
        E eZ = z(i11);
        while (true) {
            Object objA = A(i11);
            if ((objA instanceof s2) || (objA instanceof q)) {
                if (u(i11, objA, z11 ? BufferedChannelKt.f69239j : BufferedChannelKt.f69240k)) {
                    v(i11);
                    B(i11, !z11);
                    if (!z11 || (function1 = x().f69223b) == null) {
                        return;
                    }
                    OnUndeliveredElementKt.b(function1, eZ, coroutineContext);
                    return;
                }
            } else {
                if (objA == BufferedChannelKt.f69239j || objA == BufferedChannelKt.f69240k) {
                    break;
                }
                if (objA != BufferedChannelKt.f69236g && objA != BufferedChannelKt.f69235f) {
                    if (objA == BufferedChannelKt.f69238i || objA == BufferedChannelKt.f69233d || objA == BufferedChannelKt.z()) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + objA).toString());
                }
            }
        }
        v(i11);
        if (!z11 || (function2 = x().f69223b) == null) {
            return;
        }
        OnUndeliveredElementKt.b(function2, eZ, coroutineContext);
    }

    public final boolean u(int i11, Object obj, Object obj2) {
        return f.a(y(), (i11 * 2) + 1, obj, obj2);
    }

    public final void v(int i11) {
        D(i11, null);
    }

    public final Object w(int i11, Object obj) {
        return y().getAndSet((i11 * 2) + 1, obj);
    }

    public final BufferedChannel<E> x() {
        BufferedChannel<E> bufferedChannel = this.f69257f;
        Intrinsics.d(bufferedChannel);
        return bufferedChannel;
    }

    public final /* synthetic */ AtomicReferenceArray y() {
        return this.f69258g;
    }

    public final E z(int i11) {
        return (E) y().get(i11 * 2);
    }
}
