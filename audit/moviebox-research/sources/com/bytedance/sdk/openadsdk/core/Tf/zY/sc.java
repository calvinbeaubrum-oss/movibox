package com.bytedance.sdk.openadsdk.core.Tf.zY;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Set<String> f28245sc = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Tf.zY.sc.1
        {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> pFF = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Tf.zY.sc.2
        {
            add("application/x-javascript");
        }
    };

    /* JADX INFO: compiled from: source.java */
    public enum pFF {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Tf.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public enum EnumC0293sc {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    @NonNull
    public static Point sc(Context context, int i11, int i12, pFF pff) {
        if (context == null) {
            context = Xc.sc();
        }
        Point point = new Point(i11, i12);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int iZY = kX.zY(context, i11);
        int iZY2 = kX.zY(context, i12);
        if (iZY <= width && iZY2 <= height) {
            return point;
        }
        Point point2 = new Point();
        if (pFF.HTML_RESOURCE == pff) {
            point2.x = Math.min(width, iZY);
            point2.y = Math.min(height, iZY2);
        } else {
            float f11 = iZY;
            float f12 = f11 / width;
            float f13 = iZY2;
            float f14 = f13 / height;
            if (f12 >= f14) {
                point2.x = width;
                point2.y = (int) (f13 / f12);
            } else {
                point2.x = (int) (f11 / f14);
                point2.y = height;
            }
        }
        int i13 = point2.x;
        if (i13 < 0 || point2.y < 0) {
            return point;
        }
        point2.x = kX.We(context, i13);
        point2.y = kX.We(context, point2.y);
        return point2;
    }
}
