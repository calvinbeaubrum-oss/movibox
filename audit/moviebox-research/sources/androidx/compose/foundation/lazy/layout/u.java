package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class u implements a3<IntRange> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f2736f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f2739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2740d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange b(int i11, int i12, int i13) {
            int i14 = (i11 / i12) * i12;
            return kotlin.ranges.a.r(Math.max(i14 - i13, 0), i14 + i12 + i13);
        }
    }

    public u(int i11, int i12, int i13) {
        this.f2737a = i12;
        this.f2738b = i13;
        this.f2739c = r2.e(f2736f.b(i11, i12, i13), r2.j());
        this.f2740d = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.a3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public IntRange getValue() {
        return (IntRange) this.f2739c.getValue();
    }

    public final void b(IntRange intRange) {
        this.f2739c.setValue(intRange);
    }

    public final void e(int i11) {
        if (i11 != this.f2740d) {
            this.f2740d = i11;
            b(f2736f.b(i11, this.f2737a, this.f2738b));
        }
    }
}
