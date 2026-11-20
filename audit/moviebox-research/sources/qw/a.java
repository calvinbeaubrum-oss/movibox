package qw;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.core.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {
    public static final void a(ImageView imageView, Uri uri, float f11) {
        Intrinsics.g(imageView, "<this>");
        if (uri == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = imageView.getContext();
        Intrinsics.f(context, "context");
        String string = uri.toString();
        Intrinsics.f(string, "uri.toString()");
        companion.o(context, imageView, string, (32704 & 8) != 0 ? R$color.skeleton : 0, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : e.a(f11), (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    public static final void b(ImageView imageView, String url, float f11) {
        Intrinsics.g(imageView, "<this>");
        Intrinsics.g(url, "url");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = imageView.getContext();
        Intrinsics.f(context, "context");
        companion.o(context, imageView, url, (32704 & 8) != 0 ? R$color.skeleton : 0, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : e.a(f11), (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    public static /* synthetic */ void c(ImageView imageView, String str, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        b(imageView, str, f11);
    }
}
