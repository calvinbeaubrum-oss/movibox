package androidx.compose.ui.text;

import kotlin.Metadata;
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
public abstract class f {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0 f5780b;

        public a(String str, b0 b0Var, g gVar) {
            super(null);
            this.f5779a = str;
            this.f5780b = b0Var;
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public b0 b() {
            return this.f5780b;
        }

        public final String c() {
            return this.f5779a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Intrinsics.b(this.f5779a, aVar.f5779a) || !Intrinsics.b(b(), aVar.b())) {
                return false;
            }
            a();
            aVar.a();
            return Intrinsics.b(null, null);
        }

        public int hashCode() {
            int iHashCode = this.f5779a.hashCode() * 31;
            b0 b0VarB = b();
            int iHashCode2 = (iHashCode + (b0VarB != null ? b0VarB.hashCode() : 0)) * 31;
            a();
            return iHashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.f5779a + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0 f5782b;

        public b(String str, b0 b0Var, g gVar) {
            super(null);
            this.f5781a = str;
            this.f5782b = b0Var;
        }

        public /* synthetic */ b(String str, b0 b0Var, g gVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : b0Var, (i11 & 4) != 0 ? null : gVar);
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public b0 b() {
            return this.f5782b;
        }

        public final String c() {
            return this.f5781a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!Intrinsics.b(this.f5781a, bVar.f5781a) || !Intrinsics.b(b(), bVar.b())) {
                return false;
            }
            a();
            bVar.a();
            return Intrinsics.b(null, null);
        }

        public int hashCode() {
            int iHashCode = this.f5781a.hashCode() * 31;
            b0 b0VarB = b();
            int iHashCode2 = (iHashCode + (b0VarB != null ? b0VarB.hashCode() : 0)) * 31;
            a();
            return iHashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.f5781a + ')';
        }
    }

    public f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract g a();
}
