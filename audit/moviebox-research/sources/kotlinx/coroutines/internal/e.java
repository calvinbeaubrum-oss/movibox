package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.e;

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
public abstract class e<N extends e<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69459a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69460b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public e(N n11) {
        this._prev$volatile = n11;
    }

    public final void b() {
        f69460b.set(this, null);
    }

    public final N c() {
        N n11 = (N) g();
        while (n11 != null && n11.j()) {
            n11 = (N) f69460b.get(n11);
        }
        return n11;
    }

    public final N d() {
        e eVarE;
        N n11 = (N) e();
        Intrinsics.d(n11);
        while (n11.j() && (eVarE = n11.e()) != null) {
            n11 = (N) eVarE;
        }
        return n11;
    }

    public final N e() {
        Object objF = f();
        if (objF == d.f69458a) {
            return null;
        }
        return (N) objF;
    }

    public final Object f() {
        return f69459a.get(this);
    }

    public final N g() {
        return (N) f69460b.get(this);
    }

    public abstract boolean j();

    public final boolean k() {
        return e() == null;
    }

    public final boolean l() {
        return androidx.concurrent.futures.a.a(f69459a, this, null, d.f69458a);
    }

    public final void m() {
        Object obj;
        if (k()) {
            return;
        }
        while (true) {
            e eVarC = c();
            e eVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69460b;
            do {
                obj = atomicReferenceFieldUpdater.get(eVarD);
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, eVarD, obj, ((e) obj) == null ? null : eVarC));
            if (eVarC != null) {
                f69459a.set(eVarC, eVarD);
            }
            if (!eVarD.j() || eVarD.k()) {
                if (eVarC == null || !eVarC.j()) {
                    return;
                }
            }
        }
    }

    public final boolean n(N n11) {
        return androidx.concurrent.futures.a.a(f69459a, this, null, n11);
    }
}
