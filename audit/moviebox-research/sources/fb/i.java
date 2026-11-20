package fb;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class i extends BitmapTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f64815c;

    public i() {
        this(0, 1, null);
    }

    public i(int i11) {
        this.f64813a = i11;
        this.f64814b = "com.bumptech.glide.load.resource.bitmap.RoundedCornerCenterCrop";
        Charset CHARSET = Key.CHARSET;
        Intrinsics.f(CHARSET, "CHARSET");
        byte[] bytes = "com.bumptech.glide.load.resource.bitmap.RoundedCornerCenterCrop".getBytes(CHARSET);
        Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
        this.f64815c = bytes;
    }

    public /* synthetic */ i(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof i) && this.f64813a == ((i) obj).f64813a;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f64814b.hashCode(), Util.hashCode(this.f64813a));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool pool, Bitmap toTransform, int i11, int i12) {
        Intrinsics.g(pool, "pool");
        Intrinsics.g(toTransform, "toTransform");
        Bitmap bitmapRoundedCorners = TransformationUtils.roundedCorners(pool, TransformationUtils.centerCrop(pool, toTransform, i11, i12), this.f64813a);
        Intrinsics.f(bitmapRoundedCorners, "roundedCorners(pool, bitmap, roundingRadius)");
        return bitmapRoundedCorners;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.g(messageDigest, "messageDigest");
        messageDigest.update(this.f64815c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f64813a).array());
    }
}
