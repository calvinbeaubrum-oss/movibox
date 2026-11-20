package kotlinx.coroutines.channels;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class d {
    public static final <E> a<E> a(int i11, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        a<E> bufferedChannel;
        if (i11 == -2) {
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(a.f69249k8.a(), function1) : new j<>(1, bufferOverflow, function1);
        } else {
            if (i11 == -1) {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new j(1, BufferOverflow.DROP_OLDEST, function1);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i11 != 0) {
                if (i11 != Integer.MAX_VALUE) {
                    return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i11, function1) : new j(i11, bufferOverflow, function1);
                }
                return new BufferedChannel(Api.BaseClientBuilder.API_PRIORITY_OTHER, function1);
            }
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(0, function1) : new j<>(1, bufferOverflow, function1);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ a b(int i11, BufferOverflow bufferOverflow, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        if ((i12 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i12 & 4) != 0) {
            function1 = null;
        }
        return a(i11, bufferOverflow, function1);
    }
}
