package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class q<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f69480e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69481f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69482g = AtomicLongFieldUpdater.newUpdater(q.class, "_state$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final c0 f69483h = new c0("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f69485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f69486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f69487d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j11) {
            return (j11 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j11, int i11) {
            return d(j11, 1073741823L) | ((long) i11);
        }

        public final long c(long j11, int i11) {
            return d(j11, 1152921503533105152L) | (((long) i11) << 30);
        }

        public final long d(long j11, long j12) {
            return j11 & (~j12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final int f69488a;

        public b(int i11) {
            this.f69488a = i11;
        }
    }

    public q(int i11, boolean z11) {
        this.f69484a = i11;
        this.f69485b = z11;
        int i12 = i11 - 1;
        this.f69486c = i12;
        this.f69487d = new AtomicReferenceArray(i11);
        if (i12 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i11 & i12) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final int a(E e11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69482g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j11) != 0) {
                return f69480e.a(j11);
            }
            int i11 = (int) (1073741823 & j11);
            int i12 = (int) ((1152921503533105152L & j11) >> 30);
            int i13 = this.f69486c;
            if (((i12 + 2) & i13) == (i11 & i13)) {
                return 1;
            }
            if (!this.f69485b && f().get(i12 & i13) != null) {
                int i14 = this.f69484a;
                if (i14 < 1024 || ((i12 - i11) & 1073741823) > (i14 >> 1)) {
                    return 1;
                }
            } else if (f69482g.compareAndSet(this, j11, f69480e.c(j11, (i12 + 1) & 1073741823))) {
                f().set(i12 & i13, e11);
                q<E> qVarE = this;
                while ((f69482g.get(qVarE) & 1152921504606846976L) != 0 && (qVarE = qVarE.l().e(i12, e11)) != null) {
                }
                return 0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<E> b(long j11) {
        q<E> qVar = new q<>(this.f69484a * 2, this.f69485b);
        int i11 = (int) (1073741823 & j11);
        int i12 = (int) ((1152921503533105152L & j11) >> 30);
        while (true) {
            int i13 = this.f69486c;
            if ((i11 & i13) == (i13 & i12)) {
                f69482g.set(qVar, f69480e.d(j11, 1152921504606846976L));
                return qVar;
            }
            Object bVar = f().get(this.f69486c & i11);
            if (bVar == null) {
                bVar = new b(i11);
            }
            qVar.f().set(qVar.f69486c & i11, bVar);
            i11++;
        }
    }

    public final q<E> c(long j11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69481f;
        while (true) {
            q<E> qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar != null) {
                return qVar;
            }
            androidx.concurrent.futures.a.a(f69481f, this, null, b(j11));
        }
    }

    public final boolean d() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69482g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j11) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j11 | 2305843009213693952L));
        return true;
    }

    public final q<E> e(int i11, E e11) {
        Object obj = f().get(this.f69486c & i11);
        if (!(obj instanceof b) || ((b) obj).f69488a != i11) {
            return null;
        }
        f().set(i11 & this.f69486c, e11);
        return this;
    }

    public final /* synthetic */ AtomicReferenceArray f() {
        return this.f69487d;
    }

    public final int g() {
        long j11 = f69482g.get(this);
        return 1073741823 & (((int) ((j11 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j11)));
    }

    public final boolean j() {
        long j11 = f69482g.get(this);
        return ((int) (1073741823 & j11)) == ((int) ((j11 & 1152921503533105152L) >> 30));
    }

    public final long k() {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69482g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 1152921504606846976L) != 0) {
                return j11;
            }
            j12 = j11 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j12));
        return j12;
    }

    public final q<E> l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69482g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j11) != 0) {
                return f69483h;
            }
            int i11 = (int) (1073741823 & j11);
            int i12 = (int) ((1152921503533105152L & j11) >> 30);
            int i13 = this.f69486c;
            if ((i12 & i13) == (i13 & i11)) {
                return null;
            }
            Object obj = f().get(this.f69486c & i11);
            if (obj == null) {
                if (this.f69485b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i14 = (i11 + 1) & 1073741823;
                if (f69482g.compareAndSet(this, j11, f69480e.b(j11, i14))) {
                    f().set(this.f69486c & i11, null);
                    return obj;
                }
                if (this.f69485b) {
                    q<E> qVarN = this;
                    do {
                        qVarN = qVarN.n(i11, i14);
                    } while (qVarN != null);
                    return obj;
                }
            }
        }
    }

    public final q<E> n(int i11, int i12) {
        long j11;
        int i13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69482g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            i13 = (int) (1073741823 & j11);
            if ((1152921504606846976L & j11) != 0) {
                return l();
            }
        } while (!f69482g.compareAndSet(this, j11, f69480e.b(j11, i12)));
        f().set(this.f69486c & i13, null);
        return null;
    }
}
