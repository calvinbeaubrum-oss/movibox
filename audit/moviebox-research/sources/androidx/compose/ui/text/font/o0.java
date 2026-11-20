package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public interface o0 extends a3<Object> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements o0, a3<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AsyncFontListLoader f5847a;

        public a(AsyncFontListLoader asyncFontListLoader) {
            this.f5847a = asyncFontListLoader;
        }

        @Override // androidx.compose.ui.text.font.o0
        public boolean c() {
            return this.f5847a.b();
        }

        @Override // androidx.compose.runtime.a3
        public Object getValue() {
            return this.f5847a.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5849b;

        public b(Object obj, boolean z11) {
            this.f5848a = obj;
            this.f5849b = z11;
        }

        public /* synthetic */ b(Object obj, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i11 & 2) != 0 ? true : z11);
        }

        @Override // androidx.compose.ui.text.font.o0
        public boolean c() {
            return this.f5849b;
        }

        @Override // androidx.compose.runtime.a3
        public Object getValue() {
            return this.f5848a;
        }
    }

    boolean c();
}
