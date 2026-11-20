package k6;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {
        public static <T, V> ObjectAnimator a(T t11, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t11, property, (TypeConverter) null, path);
        }
    }

    public static <T> ObjectAnimator a(T t11, Property<T, PointF> property, Path path) {
        return a.a(t11, property, path);
    }
}
