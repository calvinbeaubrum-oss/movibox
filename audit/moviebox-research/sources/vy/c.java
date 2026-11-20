package vy;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79125a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Context context, String str, b callback) {
            Intrinsics.g(context, "context");
            Intrinsics.g(callback, "callback");
            try {
                Bitmap bitmap = (Bitmap) Glide.with(context).asBitmap().load2(str).diskCacheStrategy(DiskCacheStrategy.ALL).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                File cacheDir = context.getCacheDir();
                qp.a.C0819a c0819a = qp.a.f74869a;
                if (str == null) {
                    str = "";
                }
                File file = new File(cacheDir, "pic" + c0819a.a(str) + ".jpg");
                if (!file.exists()) {
                    vy.a.c(bitmap, file, 100);
                }
                String absolutePath = file.getAbsolutePath();
                Intrinsics.f(absolutePath, "mThumbnailFile.absolutePath");
                callback.a(absolutePath);
            } catch (Exception unused) {
                callback.a("");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a(String str);
    }
}
