package d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.transsion.push.R$dimen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Bitmap f62840a;

    public static int a(int i11, int i12, int i13) {
        return i12 != i13 ? (i11 * i13) / i12 : i11;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        return c(bitmap, a(context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_icon_corner_large), context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_large_icon_size), bitmap.getWidth()));
    }

    public static Bitmap c(Bitmap bitmap, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f11 = i11;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawRoundRect(rectF, f11, f11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap d(Context context, Bitmap bitmap) {
        Bitmap bitmap2 = f62840a;
        if (bitmap2 != null) {
            return bitmap2;
        }
        Bitmap bitmapC = c(bitmap, a(context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_icon_corner_small), context.getResources().getDimensionPixelSize(R$dimen.tpush_notification_small_icon_size), bitmap.getWidth()));
        f62840a = bitmapC;
        return bitmapC;
    }
}
