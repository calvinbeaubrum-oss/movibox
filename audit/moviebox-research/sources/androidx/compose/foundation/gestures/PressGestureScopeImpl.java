package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

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
public final class PressGestureScopeImpl implements i, q2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q2.e f2316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f2319d = kotlinx.coroutines.sync.b.a(false);

    public PressGestureScopeImpl(q2.e eVar) {
        this.f2316a = eVar;
    }

    @Override // q2.e
    public float H0(float f11) {
        return this.f2316a.H0(f11);
    }

    @Override // q2.n
    public long M(float f11) {
        return this.f2316a.M(f11);
    }

    @Override // q2.n
    public float M0() {
        return this.f2316a.M0();
    }

    @Override // q2.e
    public float N0(float f11) {
        return this.f2316a.N0(f11);
    }

    @Override // q2.n
    public float O(long j11) {
        return this.f2316a.O(j11);
    }

    @Override // q2.e
    public long V0(long j11) {
        return this.f2316a.V0(j11);
    }

    @Override // q2.e
    public long X(float f11) {
        return this.f2316a.X(f11);
    }

    @Override // q2.e
    public float getDensity() {
        return this.f2316a.getDensity();
    }

    public final void k() {
        this.f2318c = true;
        kotlinx.coroutines.sync.a.C0744a.b(this.f2319d, null, 1, null);
    }

    @Override // q2.e
    public int k0(float f11) {
        return this.f2316a.k0(f11);
    }

    public final void l() {
        this.f2317b = true;
        kotlinx.coroutines.sync.a.C0744a.b(this.f2319d, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m(Continuation<? super Unit> continuation) throws Throwable {
        PressGestureScopeImpl$reset$1 pressGestureScopeImpl$reset$1;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$reset$1) {
            pressGestureScopeImpl$reset$1 = (PressGestureScopeImpl$reset$1) continuation;
            int i11 = pressGestureScopeImpl$reset$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$reset$1.label = i11 - Integer.MIN_VALUE;
            } else {
                pressGestureScopeImpl$reset$1 = new PressGestureScopeImpl$reset$1(this, continuation);
            }
        } else {
            pressGestureScopeImpl$reset$1 = new PressGestureScopeImpl$reset$1(this, continuation);
        }
        Object obj = pressGestureScopeImpl$reset$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = pressGestureScopeImpl$reset$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.sync.a aVar = this.f2319d;
            pressGestureScopeImpl$reset$1.L$0 = this;
            pressGestureScopeImpl$reset$1.label = 1;
            if (kotlinx.coroutines.sync.a.C0744a.a(aVar, null, pressGestureScopeImpl$reset$1, 1, null) == objE) {
                return objE;
            }
            pressGestureScopeImpl = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$reset$1.L$0;
            ResultKt.b(obj);
        }
        pressGestureScopeImpl.f2317b = false;
        pressGestureScopeImpl.f2318c = false;
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.i
    public Object n0(Continuation<? super Boolean> continuation) throws Throwable {
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$1;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$tryAwaitRelease$1) {
            pressGestureScopeImpl$tryAwaitRelease$1 = (PressGestureScopeImpl$tryAwaitRelease$1) continuation;
            int i11 = pressGestureScopeImpl$tryAwaitRelease$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$tryAwaitRelease$1.label = i11 - Integer.MIN_VALUE;
            } else {
                pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
            }
        } else {
            pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
        }
        Object obj = pressGestureScopeImpl$tryAwaitRelease$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = pressGestureScopeImpl$tryAwaitRelease$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (this.f2317b || this.f2318c) {
                pressGestureScopeImpl = this;
            } else {
                kotlinx.coroutines.sync.a aVar = this.f2319d;
                pressGestureScopeImpl$tryAwaitRelease$1.L$0 = this;
                pressGestureScopeImpl$tryAwaitRelease$1.label = 1;
                if (kotlinx.coroutines.sync.a.C0744a.a(aVar, null, pressGestureScopeImpl$tryAwaitRelease$1, 1, null) == objE) {
                    return objE;
                }
                pressGestureScopeImpl = this;
            }
            return Boxing.a(pressGestureScopeImpl.f2317b);
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$tryAwaitRelease$1.L$0;
        ResultKt.b(obj);
        kotlinx.coroutines.sync.a.C0744a.b(pressGestureScopeImpl.f2319d, null, 1, null);
        return Boxing.a(pressGestureScopeImpl.f2317b);
    }

    @Override // q2.e
    public float p0(long j11) {
        return this.f2316a.p0(j11);
    }
}
