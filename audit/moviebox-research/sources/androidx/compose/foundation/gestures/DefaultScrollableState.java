package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultScrollableState implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Float, Float> f2295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f2296b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutatorMutex f2297c = new MutatorMutex();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1<Boolean> f2298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1<Boolean> f2299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1<Boolean> f2300f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements k {
        public a() {
        }

        @Override // androidx.compose.foundation.gestures.k
        public float a(float f11) {
            if (Float.isNaN(f11)) {
                return 0.0f;
            }
            float fFloatValue = DefaultScrollableState.this.k().invoke(Float.valueOf(f11)).floatValue();
            DefaultScrollableState.this.f2299e.setValue(Boolean.valueOf(fFloatValue > 0.0f));
            DefaultScrollableState.this.f2300f.setValue(Boolean.valueOf(fFloatValue < 0.0f));
            return fFloatValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultScrollableState(Function1<? super Float, Float> function1) {
        this.f2295a = function1;
        Boolean bool = Boolean.FALSE;
        this.f2298d = u2.c(bool, null, 2, null);
        this.f2299e = u2.c(bool, null, 2, null);
        this.f2300f = u2.c(bool, null, 2, null);
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean a() {
        return this.f2298d.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.o
    public /* synthetic */ boolean b() {
        return n.a(this);
    }

    @Override // androidx.compose.foundation.gestures.o
    public Object c(MutatePriority mutatePriority, Function2<? super k, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new DefaultScrollableState$scroll$2(this, mutatePriority, function2, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    @Override // androidx.compose.foundation.gestures.o
    public /* synthetic */ boolean d() {
        return n.b(this);
    }

    @Override // androidx.compose.foundation.gestures.o
    public float e(float f11) {
        return this.f2295a.invoke(Float.valueOf(f11)).floatValue();
    }

    public final Function1<Float, Float> k() {
        return this.f2295a;
    }
}
