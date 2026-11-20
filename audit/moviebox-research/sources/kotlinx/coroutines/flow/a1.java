package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;

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
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final kotlinx.coroutines.internal.c0 f69376a = new kotlinx.coroutines.internal.c0("NO_VALUE");

    public static final <T> u0<T> a(int i11, int i12, BufferOverflow bufferOverflow) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i11).toString());
        }
        if (i12 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i12).toString());
        }
        if (i11 > 0 || i12 > 0 || bufferOverflow == BufferOverflow.SUSPEND) {
            int i13 = i12 + i11;
            if (i13 < 0) {
                i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return new SharedFlowImpl(i11, i13, bufferOverflow);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
    }

    public static /* synthetic */ u0 b(int i11, int i12, BufferOverflow bufferOverflow, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        if ((i13 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i11, i12, bufferOverflow);
    }

    public static final <T> a<T> e(z0<? extends T> z0Var, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return ((i11 == 0 || i11 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? z0Var : new kotlinx.coroutines.flow.internal.e(z0Var, coroutineContext, i11, bufferOverflow);
    }

    public static final Object f(Object[] objArr, long j11) {
        return objArr[(objArr.length - 1) & ((int) j11)];
    }

    public static final void g(Object[] objArr, long j11, Object obj) {
        objArr[(objArr.length - 1) & ((int) j11)] = obj;
    }
}
