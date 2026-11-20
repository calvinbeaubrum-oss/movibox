package androidx.compose.runtime;

import android.os.Looper;
import android.util.Log;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class ActualAndroid_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3226a = LazyKt__LazyJVMKt.b(new Function0<u0>() { // from class: androidx.compose.runtime.ActualAndroid_androidKt$DefaultMonotonicFrameClock$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final u0 invoke() {
            return Looper.getMainLooper() != null ? DefaultChoreographerFrameClock.f3275a : SdkStubsFallbackFrameClock.f3340a;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3227b;

    static {
        long id2;
        try {
            id2 = Looper.getMainLooper().getThread().getId();
        } catch (Exception unused) {
            id2 = -1;
        }
        f3227b = id2;
    }

    public static final c1 a(float f11) {
        return new ParcelableSnapshotMutableFloatState(f11);
    }

    public static final e1 b(int i11) {
        return new ParcelableSnapshotMutableIntState(i11);
    }

    public static final <T> androidx.compose.runtime.snapshots.r<T> c(T t11, q2<T> q2Var) {
        return new ParcelableSnapshotMutableState(t11, q2Var);
    }

    public static final long d() {
        return f3227b;
    }

    public static final void e(String str, Throwable th2) {
        Log.e("ComposeInternal", str, th2);
    }
}
