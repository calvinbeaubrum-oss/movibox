package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@JvmInline
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f69253b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f69254c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f69255a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Throwable f69256a;

        public a(Throwable th2) {
            this.f69256a = th2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics.b(this.f69256a, ((a) obj).f69256a);
        }

        public int hashCode() {
            Throwable th2 = this.f69256a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.e.c
        public String toString() {
            return "Closed(" + this.f69256a + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E> Object a(Throwable th2) {
            return e.c(new a(th2));
        }

        public final <E> Object b() {
            return e.c(e.f69254c);
        }

        public final <E> Object c(E e11) {
            return e.c(e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    @PublishedApi
    public /* synthetic */ e(Object obj) {
        this.f69255a = obj;
    }

    public static final /* synthetic */ e b(Object obj) {
        return new e(obj);
    }

    @PublishedApi
    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof e) && Intrinsics.b(obj, ((e) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f69256a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f69255a, obj);
    }

    public int hashCode() {
        return g(this.f69255a);
    }

    public final /* synthetic */ Object k() {
        return this.f69255a;
    }

    public String toString() {
        return j(this.f69255a);
    }
}
