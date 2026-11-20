package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@JvmInline
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4627a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4633g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f4629c;
        }

        public final int b() {
            return e.f4628b;
        }
    }

    static {
        int iC = c(1);
        f4628b = iC;
        int iC2 = c(2);
        f4629c = iC2;
        f4630d = iC;
        f4631e = iC2;
        f4632f = c(3);
        f4633g = iC;
    }

    public static int c(int i11) {
        return i11;
    }

    public static final boolean d(int i11, int i12) {
        return i11 == i12;
    }
}
