package iq;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Request;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f67653a = new h();

    public final void a(Interceptor.Chain chain, Request buildRequest, int i11) {
        Intrinsics.g(chain, "chain");
        Intrinsics.g(buildRequest, "buildRequest");
        i iVarB = b(chain);
        if (iVarB != null) {
            iVarB.b(buildRequest, i11);
        }
    }

    public final i b(Interceptor.Chain chain) {
        m mVar = m.f67663a;
        Call call = chain.call();
        Intrinsics.f(call, "chain.call()");
        Object objA = mVar.a(call, "eventListener");
        if (objA instanceof i) {
            return (i) objA;
        }
        return null;
    }

    public final void c(Interceptor.Chain chain, Request buildRequest) {
        Intrinsics.g(chain, "chain");
        Intrinsics.g(buildRequest, "buildRequest");
        i iVarB = b(chain);
        if (iVarB != null) {
            iVarB.a(buildRequest);
        }
    }
}
