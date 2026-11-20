package zp;

import android.app.Application;
import com.tn.lib.widget.toast.impl.ToastUtilImpl;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f82110a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static zp.a f82111b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (b.f82111b == null) {
                b.f82111b = b();
            }
        }

        public final zp.a b() {
            return ToastUtilImpl.f50041a.a();
        }

        public final void c(Application application) {
            Intrinsics.g(application, "application");
            ToastUtilImpl.f50041a.b(application);
        }

        public final void d(int i11) {
            a();
            zp.a aVar = b.f82111b;
            if (aVar != null) {
                aVar.a(i11);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            zp.a aVar = b.f82111b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }

        public final void f(CharSequence charSequence, int i11) {
            a();
            zp.a aVar = b.f82111b;
            if (aVar != null) {
                aVar.c(charSequence, i11);
            }
        }

        public final void g(int i11, CharSequence text, int i12, int i13, int i14) {
            Intrinsics.g(text, "text");
            a();
            zp.a aVar = b.f82111b;
            if (aVar != null) {
                aVar.d(i11, text, i12, i13, i14);
            }
        }
    }
}
