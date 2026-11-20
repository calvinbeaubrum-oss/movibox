package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;

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
@PublishedApi
public class s1 extends JobSupport implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f69520a;

    public s1(q1 q1Var) {
        super(true);
        initParentJob(q1Var);
        this.f69520a = s();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.f69520a;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlinx.coroutines.z
    public boolean i(Throwable th2) {
        return makeCompleting$kotlinx_coroutines_core(new b0(th2, false, 2, null));
    }

    public final boolean s() {
        JobSupport jobSupportU;
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        u uVar = parentHandle$kotlinx_coroutines_core instanceof u ? (u) parentHandle$kotlinx_coroutines_core : null;
        if (uVar != null && (jobSupportU = uVar.u()) != null) {
            while (!jobSupportU.getHandlesException$kotlinx_coroutines_core()) {
                t parentHandle$kotlinx_coroutines_core2 = jobSupportU.getParentHandle$kotlinx_coroutines_core();
                u uVar2 = parentHandle$kotlinx_coroutines_core2 instanceof u ? (u) parentHandle$kotlinx_coroutines_core2 : null;
                if (uVar2 == null || (jobSupportU = uVar2.u()) == null) {
                }
            }
            return true;
        }
        return false;
    }
}
