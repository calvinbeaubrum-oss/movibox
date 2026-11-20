package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class SpecificationComputer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13121a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SpecificationComputer b(a aVar, Object obj, String str, VerificationMode verificationMode, e eVar, int i11, Object obj2) {
            if ((i11 & 2) != 0) {
                verificationMode = c.f13137a.a();
            }
            if ((i11 & 4) != 0) {
                eVar = androidx.window.core.a.f13132a;
            }
            return aVar.a(obj, str, verificationMode, eVar);
        }

        public final <T> SpecificationComputer<T> a(T t11, String tag, VerificationMode verificationMode, e logger) {
            Intrinsics.g(t11, "<this>");
            Intrinsics.g(tag, "tag");
            Intrinsics.g(verificationMode, "verificationMode");
            Intrinsics.g(logger, "logger");
            return new f(t11, tag, verificationMode, logger);
        }
    }

    public abstract T a();

    public final String b(Object value, String message) {
        Intrinsics.g(value, "value");
        Intrinsics.g(message, "message");
        return message + " value: " + value;
    }

    public abstract SpecificationComputer<T> c(String str, Function1<? super T, Boolean> function1);
}
