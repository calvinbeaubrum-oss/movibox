package qo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends BitmapTransformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f74866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f74867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f74868c;

    public a() {
        this(25, 1);
    }

    public a(int i11, int i12) {
        this.f74868c = false;
        this.f74866a = i11;
        this.f74867b = i12;
    }

    public a(int i11, int i12, boolean z11) {
        this.f74866a = i11;
        this.f74867b = i12;
        this.f74868c = z11;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.f74866a == this.f74866a && aVar.f74867b == this.f74867b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 589067571 + (this.f74866a * 1000) + (this.f74867b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f74866a + ", sampling=" + this.f74867b + ")";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = this.f74867b;
        Bitmap bitmap2 = bitmapPool.get(width / i13, height / i13, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i14 = this.f74867b;
        canvas.scale(1.0f / i14, 1.0f / i14);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return this.f74868c ? b.a(bitmap2, this.f74866a, true) : ImageUtils.a(bitmap2, 1.0f, this.f74866a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("BlurTransformation.1" + this.f74866a + this.f74867b).getBytes(Key.CHARSET));
    }
}
