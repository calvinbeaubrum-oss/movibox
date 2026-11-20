package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.q;
import q2.t;

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
public final class c implements androidx.compose.ui.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3788c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements androidx.compose.ui.b.InterfaceC0052b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f3789a;

        public a(float f11) {
            this.f3789a = f11;
        }

        @Override // androidx.compose.ui.b.InterfaceC0052b
        public int a(int i11, int i12, LayoutDirection layoutDirection) {
            return Math.round(((i12 - i11) / 2.0f) * (1 + (layoutDirection == LayoutDirection.Ltr ? this.f3789a : (-1) * this.f3789a)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.f3789a, ((a) obj).f3789a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3789a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.f3789a + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements androidx.compose.ui.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f3790a;

        public b(float f11) {
            this.f3790a = f11;
        }

        @Override // androidx.compose.ui.b.c
        public int a(int i11, int i12) {
            return Math.round(((i12 - i11) / 2.0f) * (1 + this.f3790a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Float.compare(this.f3790a, ((b) obj).f3790a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3790a);
        }

        public String toString() {
            return "Vertical(bias=" + this.f3790a + ')';
        }
    }

    public c(float f11, float f12) {
        this.f3787b = f11;
        this.f3788c = f12;
    }

    @Override // androidx.compose.ui.b
    public long a(long j11, long j12, LayoutDirection layoutDirection) {
        float fG = (t.g(j12) - t.g(j11)) / 2.0f;
        float f11 = (t.f(j12) - t.f(j11)) / 2.0f;
        float f12 = 1;
        return q.a(Math.round(fG * ((layoutDirection == LayoutDirection.Ltr ? this.f3787b : (-1) * this.f3787b) + f12)), Math.round(f11 * (f12 + this.f3788c)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f3787b, cVar.f3787b) == 0 && Float.compare(this.f3788c, cVar.f3788c) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f3787b) * 31) + Float.floatToIntBits(this.f3788c);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.f3787b + ", verticalBias=" + this.f3788c + ')';
    }
}
