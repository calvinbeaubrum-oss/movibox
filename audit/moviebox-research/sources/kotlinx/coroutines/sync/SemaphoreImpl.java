package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.selects.g;

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
public class SemaphoreImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69589c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69590d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69591e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69592f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69593g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f69595b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public SemaphoreImpl(int i11, int i12) {
        this.f69594a = i11;
        if (i11 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i11).toString());
        }
        if (i12 < 0 || i12 > i11) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i11).toString());
        }
        d dVar = new d(0L, null, 2);
        this.head$volatile = dVar;
        this.tail$volatile = dVar;
        this._availablePermits$volatile = i11 - i12;
        this.f69595b = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                this.this$0.l();
            }
        };
    }

    public final void b(n<? super Unit> nVar) {
        while (e() <= 0) {
            Intrinsics.e(nVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (c((s2) nVar)) {
                return;
            }
        }
        nVar.resume(Unit.f68710a, this.f69595b);
    }

    public final boolean c(s2 s2Var) {
        Object objC;
        d dVar = (d) f69591e.get(this);
        long andIncrement = f69592f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69591e;
        long j11 = andIncrement / ((long) c.f69603f);
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(dVar, j11, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!a0.c(objC)) {
                z zVarB = a0.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f69497c >= zVarB.f69497c) {
                        break loop0;
                    }
                    if (!zVarB.t()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, zVarB)) {
                        if (!zVar.o()) {
                            break loop0;
                        }
                        zVar.m();
                        break loop0;
                    }
                    if (zVarB.o()) {
                        zVarB.m();
                    }
                }
            } else {
                break;
            }
        }
        d dVar2 = (d) a0.b(objC);
        int i11 = (int) (andIncrement % ((long) c.f69603f));
        if (f.a(dVar2.u(), i11, null, s2Var)) {
            s2Var.invokeOnCancellation(dVar2, i11);
            return true;
        }
        if (!f.a(dVar2.u(), i11, c.f69599b, c.f69600c)) {
            return false;
        }
        if (s2Var instanceof n) {
            Intrinsics.e(s2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((n) s2Var).resume(Unit.f68710a, this.f69595b);
        } else {
            if (!(s2Var instanceof g)) {
                throw new IllegalStateException(("unexpected: " + s2Var).toString());
            }
            ((g) s2Var).a(Unit.f68710a);
        }
        return true;
    }

    public final void d() {
        int i11;
        do {
            i11 = f69593g.get(this);
            if (i11 <= this.f69594a) {
                return;
            }
        } while (!f69593g.compareAndSet(this, i11, this.f69594a));
    }

    public final int e() {
        int andDecrement;
        do {
            andDecrement = f69593g.getAndDecrement(this);
        } while (andDecrement > this.f69594a);
        return andDecrement;
    }

    public int f() {
        return Math.max(f69593g.get(this), 0);
    }

    public void l() {
        do {
            int andIncrement = f69593g.getAndIncrement(this);
            if (andIncrement >= this.f69594a) {
                d();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f69594a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!o());
    }

    public boolean m() {
        while (true) {
            int i11 = f69593g.get(this);
            if (i11 > this.f69594a) {
                d();
            } else {
                if (i11 <= 0) {
                    return false;
                }
                if (f69593g.compareAndSet(this, i11, i11 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean n(Object obj) {
        if (!(obj instanceof n)) {
            if (obj instanceof g) {
                return ((g) obj).c(this, Unit.f68710a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n nVar = (n) obj;
        Object objTryResume = nVar.tryResume(Unit.f68710a, null, this.f69595b);
        if (objTryResume == null) {
            return false;
        }
        nVar.completeResume(objTryResume);
        return true;
    }

    public final boolean o() {
        Object objC;
        d dVar = (d) f69589c.get(this);
        long andIncrement = f69590d.getAndIncrement(this);
        long j11 = andIncrement / ((long) c.f69603f);
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69589c;
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(dVar, j11, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (a0.c(objC)) {
                break;
            }
            z zVarB = a0.b(objC);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f69497c >= zVarB.f69497c) {
                    break loop0;
                }
                if (!zVarB.t()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, zVarB)) {
                    if (!zVar.o()) {
                        break loop0;
                    }
                    zVar.m();
                    break loop0;
                }
                if (zVarB.o()) {
                    zVarB.m();
                }
            }
        }
        d dVar2 = (d) a0.b(objC);
        dVar2.b();
        if (dVar2.f69497c > j11) {
            return false;
        }
        int i11 = (int) (andIncrement % ((long) c.f69603f));
        Object andSet = dVar2.u().getAndSet(i11, c.f69599b);
        if (andSet != null) {
            if (andSet == c.f69602e) {
                return false;
            }
            return n(andSet);
        }
        int i12 = c.f69598a;
        for (int i13 = 0; i13 < i12; i13++) {
            if (dVar2.u().get(i11) == c.f69600c) {
                return true;
            }
        }
        return !f.a(dVar2.u(), i11, c.f69599b, c.f69601d);
    }
}
