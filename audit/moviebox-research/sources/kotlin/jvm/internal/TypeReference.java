package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

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
@SinceKotlin
@Metadata
public final class TypeReference implements KType {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f68918f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClassifier f68919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<KTypeProjection> f68920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KType f68921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68922d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f68923a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f68923a = iArr;
        }
    }

    public final String c(KTypeProjection kTypeProjection) {
        String strValueOf;
        if (kTypeProjection.b() == null) {
            return "*";
        }
        KType kTypeA = kTypeProjection.a();
        TypeReference typeReference = kTypeA instanceof TypeReference ? (TypeReference) kTypeA : null;
        if (typeReference == null || (strValueOf = typeReference.f(true)) == null) {
            strValueOf = String.valueOf(kTypeProjection.a());
        }
        int i11 = WhenMappings.f68923a[kTypeProjection.b().ordinal()];
        if (i11 == 1) {
            return strValueOf;
        }
        if (i11 == 2) {
            return "in " + strValueOf;
        }
        if (i11 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.b(i(), typeReference.i()) && Intrinsics.b(g(), typeReference.g()) && Intrinsics.b(this.f68921c, typeReference.f68921c) && this.f68922d == typeReference.f68922d) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z11) {
        String name;
        KClassifier kClassifierI = i();
        KClass kClass = kClassifierI instanceof KClass ? (KClass) kClassifierI : null;
        Class<?> clsA = kClass != null ? JvmClassMappingKt.a(kClass) : null;
        if (clsA == null) {
            name = i().toString();
        } else if ((this.f68922d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsA.isArray()) {
            name = h(clsA);
        } else if (z11 && clsA.isPrimitive()) {
            KClassifier kClassifierI2 = i();
            Intrinsics.e(kClassifierI2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.b((KClass) kClassifierI2).getName();
        } else {
            name = clsA.getName();
        }
        String str = name + (g().isEmpty() ? "" : CollectionsKt___CollectionsKt.o0(g(), ", ", "<", ">", 0, null, new Function1<KTypeProjection, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(KTypeProjection it) {
                Intrinsics.g(it, "it");
                return this.this$0.c(it);
            }
        }, 24, null)) + (j() ? "?" : "");
        KType kType = this.f68921c;
        if (!(kType instanceof TypeReference)) {
            return str;
        }
        String strF = ((TypeReference) kType).f(true);
        if (Intrinsics.b(strF, str)) {
            return str;
        }
        if (Intrinsics.b(strF, str + '?')) {
            return str + '!';
        }
        return '(' + str + ".." + strF + ')';
    }

    public List<KTypeProjection> g() {
        return this.f68920b;
    }

    public final String h(Class<?> cls) {
        if (Intrinsics.b(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.b(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.b(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.b(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.b(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.b(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.b(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return Intrinsics.b(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + g().hashCode()) * 31) + this.f68922d;
    }

    public KClassifier i() {
        return this.f68919a;
    }

    public boolean j() {
        return (this.f68922d & 1) != 0;
    }

    public String toString() {
        return f(false) + " (Kotlin reflection is not available)";
    }
}
