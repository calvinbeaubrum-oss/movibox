package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import androidx.compose.ui.unit.LayoutDirection;
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
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2503a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f2504b = a.f2507e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f2505c = e.f2510e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f2506d = c.f2508e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends m {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f2507e = new a();

        public a() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, k0 k0Var, int i12) {
            return i11 / 2;
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

        public final m a(androidx.compose.ui.b.InterfaceC0052b interfaceC0052b) {
            return new d(interfaceC0052b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends m {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f2508e = new c();

        public c() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, k0 k0Var, int i12) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return i11;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends m {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final androidx.compose.ui.b.InterfaceC0052b f2509e;

        public d(androidx.compose.ui.b.InterfaceC0052b interfaceC0052b) {
            super(null);
            this.f2509e = interfaceC0052b;
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, k0 k0Var, int i12) {
            return this.f2509e.a(0, i11, layoutDirection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.b(this.f2509e, ((d) obj).f2509e);
        }

        public int hashCode() {
            return this.f2509e.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.f2509e + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends m {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f2510e = new e();

        public e() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.m
        public int a(int i11, LayoutDirection layoutDirection, k0 k0Var, int i12) {
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return i11;
        }
    }

    public m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int a(int i11, LayoutDirection layoutDirection, k0 k0Var, int i12);

    public Integer b(k0 k0Var) {
        return null;
    }

    public boolean c() {
        return false;
    }
}
