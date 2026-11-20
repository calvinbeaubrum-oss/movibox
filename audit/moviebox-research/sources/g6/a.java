package g6;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class a implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0682a f65409c = new C0682a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f65411b;

    /* JADX INFO: renamed from: g6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0682a {
        public C0682a() {
        }

        public /* synthetic */ C0682a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(i iVar, int i11, Object obj) {
            if (obj == null) {
                iVar.m0(i11);
                return;
            }
            if (obj instanceof byte[]) {
                iVar.c0(i11, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                iVar.f(i11, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                iVar.f(i11, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                iVar.V(i11, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                iVar.V(i11, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                iVar.V(i11, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                iVar.V(i11, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                iVar.s(i11, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                iVar.V(i11, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i11 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        public final void b(i statement, Object[] objArr) {
            Intrinsics.g(statement, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i11 = 0;
            while (i11 < length) {
                Object obj = objArr[i11];
                i11++;
                a(statement, i11, obj);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String query) {
        this(query, null);
        Intrinsics.g(query, "query");
    }

    public a(String query, Object[] objArr) {
        Intrinsics.g(query, "query");
        this.f65410a = query;
        this.f65411b = objArr;
    }

    @Override // g6.j
    public String a() {
        return this.f65410a;
    }

    @Override // g6.j
    public void b(i statement) {
        Intrinsics.g(statement, "statement");
        f65409c.b(statement, this.f65411b);
    }
}
