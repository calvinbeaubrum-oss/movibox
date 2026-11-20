package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KTypeParameter;
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
@SourceDebugExtension
public final class TypeParameterReference implements KTypeParameter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f68913d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f68914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVariance f68916c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f68917a;

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
                f68917a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(KTypeParameter typeParameter) {
            Intrinsics.g(typeParameter, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i11 = WhenMappings.f68917a[typeParameter.a().ordinal()];
            if (i11 == 2) {
                sb2.append("in ");
            } else if (i11 == 3) {
                sb2.append("out ");
            }
            sb2.append(typeParameter.getName());
            String string = sb2.toString();
            Intrinsics.f(string, "toString(...)");
            return string;
        }
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance a() {
        return this.f68916c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
            if (Intrinsics.b(this.f68914a, typeParameterReference.f68914a) && Intrinsics.b(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.f68915b;
    }

    public int hashCode() {
        Object obj = this.f68914a;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    public String toString() {
        return f68913d.a(this);
    }
}
