package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f69458a = new c0("CLOSED");

    public static final <N extends e<N>> N b(N n11) {
        while (true) {
            Object objF = n11.f();
            if (objF == f69458a) {
                return n11;
            }
            e eVar = (e) objF;
            if (eVar != null) {
                n11 = (N) eVar;
            } else if (n11.l()) {
                return n11;
            }
        }
    }

    public static final <S extends z<S>> Object c(S s11, long j11, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s11.f69497c >= j11 && !s11.j()) {
                return a0.a(s11);
            }
            Object objF = s11.f();
            if (objF == f69458a) {
                return a0.a(f69458a);
            }
            S sInvoke = (S) ((e) objF);
            if (sInvoke == null) {
                sInvoke = function2.invoke(Long.valueOf(s11.f69497c + 1), s11);
                if (s11.n(sInvoke)) {
                    if (s11.j()) {
                        s11.m();
                    }
                }
            }
            s11 = (Object) sInvoke;
        }
    }
}
