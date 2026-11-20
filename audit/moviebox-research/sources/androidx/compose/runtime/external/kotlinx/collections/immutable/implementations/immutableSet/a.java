package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import v1.e;

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
@SourceDebugExtension
public final class a<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0049a f3402d = new C0049a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3403e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3404f = new a(0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f3406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f3407c;

    /* JADX INFO: renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0049a {
        public C0049a() {
        }

        public /* synthetic */ C0049a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f3404f;
        }
    }

    public a(int i11, Object[] objArr) {
        this(i11, objArr, null);
    }

    public a(int i11, Object[] objArr, e eVar) {
        this.f3405a = i11;
        this.f3406b = objArr;
        this.f3407c = eVar;
    }
}
