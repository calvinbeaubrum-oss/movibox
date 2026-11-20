package ja;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b extends BitmapTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f67969a = b.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float[] f67970b;

    public b(float f11, float f12, float f13, float f14) {
        this.f67970b = new Float[]{Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13), Float.valueOf(f14)};
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return Arrays.equals(this.f67970b, ((b) obj).f67970b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.f67969a.hashCode(), Arrays.hashCode(this.f67970b));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap source, int i11, int i12) {
        Intrinsics.g(pool, "pool");
        Intrinsics.g(source, "source");
        Bitmap bitmap = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.f(bitmap, "pool[source.width, sourc… Bitmap.Config.ARGB_8888]");
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(source, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        Float f11 = this.f67970b[0];
        canvas.save();
        canvas.clipRect(0, 0, canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.drawRoundRect(rectF, f11 != null ? f11.floatValue() : 0.0f, f11 != null ? f11.floatValue() : 0.0f, paint);
        canvas.restore();
        Float f12 = this.f67970b[1];
        canvas.save();
        canvas.clipRect(canvas.getWidth() / 2, 0, canvas.getWidth(), canvas.getHeight() / 2);
        canvas.drawRoundRect(rectF, f12 != null ? f12.floatValue() : 0.0f, f12 != null ? f12.floatValue() : 0.0f, paint);
        canvas.restore();
        Float f13 = this.f67970b[2];
        canvas.save();
        canvas.clipRect(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(rectF, f13 != null ? f13.floatValue() : 0.0f, f13 != null ? f13.floatValue() : 0.0f, paint);
        canvas.restore();
        Float f14 = this.f67970b[3];
        canvas.save();
        canvas.clipRect(0, canvas.getHeight() / 2, canvas.getWidth() / 2, canvas.getHeight());
        canvas.drawRoundRect(rectF, f14 != null ? f14.floatValue() : 0.0f, f14 != null ? f14.floatValue() : 0.0f, paint);
        canvas.restore();
        return bitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.g(messageDigest, "messageDigest");
        String ID = this.f67969a;
        Intrinsics.f(ID, "ID");
        Charset CHARSET = Key.CHARSET;
        Intrinsics.f(CHARSET, "CHARSET");
        byte[] bytes = ID.getBytes(CHARSET);
        Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] bArrArray = ByteBuffer.allocate(4).putInt(Arrays.hashCode(this.f67970b)).array();
        Intrinsics.f(bArrArray, "allocate(4).putInt(Array…hashCode(radius)).array()");
        messageDigest.update(bArrArray);
    }
}
