package androidx.compose.ui.input.pointer;

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
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4737a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4738b = h(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4739c = h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4740d = h(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4741e = h(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4742f = h(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4743g = h(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4744h = h(6);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return s.f4742f;
        }

        public final int b() {
            return s.f4743g;
        }

        public final int c() {
            return s.f4741e;
        }

        public final int d() {
            return s.f4739c;
        }

        public final int e() {
            return s.f4740d;
        }

        public final int f() {
            return s.f4744h;
        }

        public final int g() {
            return s.f4738b;
        }
    }

    public static int h(int i11) {
        return i11;
    }

    public static final boolean i(int i11, int i12) {
        return i11 == i12;
    }
}
