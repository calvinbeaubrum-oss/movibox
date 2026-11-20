package androidx.window.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
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
public final class d<T> extends SpecificationComputer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f13139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f13142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f13143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WindowStrictModeException f13144g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13145a;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            f13145a = iArr;
        }
    }

    public d(T value, String tag, String message, e logger, SpecificationComputer.VerificationMode verificationMode) {
        Intrinsics.g(value, "value");
        Intrinsics.g(tag, "tag");
        Intrinsics.g(message, "message");
        Intrinsics.g(logger, "logger");
        Intrinsics.g(verificationMode, "verificationMode");
        this.f13139b = value;
        this.f13140c = tag;
        this.f13141d = message;
        this.f13142e = logger;
        this.f13143f = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        Intrinsics.f(stackTrace, "stackTrace");
        Object[] array = kotlin.collections.d.L(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.f13144g = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T a() throws WindowStrictModeException {
        int i11 = a.f13145a[this.f13143f.ordinal()];
        if (i11 == 1) {
            throw this.f13144g;
        }
        if (i11 == 2) {
            this.f13142e.debug(this.f13140c, b(this.f13139b, this.f13141d));
            return null;
        }
        if (i11 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> c(String message, Function1<? super T, Boolean> condition) {
        Intrinsics.g(message, "message");
        Intrinsics.g(condition, "condition");
        return this;
    }
}
