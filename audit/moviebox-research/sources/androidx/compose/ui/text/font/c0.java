package androidx.compose.ui.text.font;

import kotlin.Metadata;

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
public interface c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5818a = a.f5819a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5819a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c0 f5820b = new C0063a();

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0063a implements c0 {
            @Override // androidx.compose.ui.text.font.c0
            public /* synthetic */ u a(u uVar) {
                return b0.d(this, uVar);
            }

            @Override // androidx.compose.ui.text.font.c0
            public /* synthetic */ int b(int i11) {
                return b0.b(this, i11);
            }

            @Override // androidx.compose.ui.text.font.c0
            public /* synthetic */ int c(int i11) {
                return b0.c(this, i11);
            }

            @Override // androidx.compose.ui.text.font.c0
            public /* synthetic */ i d(i iVar) {
                return b0.a(this, iVar);
            }
        }

        public final c0 a() {
            return f5820b;
        }
    }

    u a(u uVar);

    int b(int i11);

    int c(int i11);

    i d(i iVar);
}
