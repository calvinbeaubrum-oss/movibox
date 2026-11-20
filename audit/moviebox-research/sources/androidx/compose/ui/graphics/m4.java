package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public abstract class m4 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f4311a;

        public a(Path path) {
            super(null);
            this.f4311a = path;
        }

        @Override // androidx.compose.ui.graphics.m4
        public y1.i a() {
            return this.f4311a.getBounds();
        }

        public final Path b() {
            return this.f4311a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y1.i f4312a;

        public b(y1.i iVar) {
            super(null);
            this.f4312a = iVar;
        }

        @Override // androidx.compose.ui.graphics.m4
        public y1.i a() {
            return this.f4312a;
        }

        public final y1.i b() {
            return this.f4312a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.b(this.f4312a, ((b) obj).f4312a);
        }

        public int hashCode() {
            return this.f4312a.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c extends m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y1.k f4313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f4314b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(y1.k kVar) {
            super(0 == true ? 1 : 0);
            Path path = null;
            this.f4313a = kVar;
            if (!y1.l.e(kVar)) {
                Path pathA = z0.a();
                q4.b(pathA, kVar, null, 2, null);
                path = pathA;
            }
            this.f4314b = path;
        }

        @Override // androidx.compose.ui.graphics.m4
        public y1.i a() {
            return y1.l.d(this.f4313a);
        }

        public final y1.k b() {
            return this.f4313a;
        }

        public final Path c() {
            return this.f4314b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.b(this.f4313a, ((c) obj).f4313a);
        }

        public int hashCode() {
            return this.f4313a.hashCode();
        }
    }

    public m4() {
    }

    public /* synthetic */ m4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract y1.i a();
}
