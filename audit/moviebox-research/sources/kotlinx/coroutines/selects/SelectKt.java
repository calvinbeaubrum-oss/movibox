package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.n;

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
public final class SelectKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3<Object, Object, Object, Object> f69558a = new Function3() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // kotlin.jvm.functions.Function3
        public final Void invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f69559b = new c0("STATE_REG");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f69560c = new c0("STATE_COMPLETED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f69561d = new c0("STATE_CANCELLED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f69562e = new c0("NO_RESULT");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f69563f = new c0("PARAM_CLAUSE_0");

    public static final TrySelectDetailedResult a(int i11) {
        if (i11 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i11 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i11 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i11 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i11).toString());
    }

    public static final boolean i(n<? super Unit> nVar, Function1<? super Throwable, Unit> function1) {
        Object objTryResume = nVar.tryResume(Unit.f68710a, null, function1);
        if (objTryResume == null) {
            return false;
        }
        nVar.completeResume(objTryResume);
        return true;
    }
}
