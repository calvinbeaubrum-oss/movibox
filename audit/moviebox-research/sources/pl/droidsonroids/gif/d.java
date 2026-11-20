package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f73921a = Arrays.asList("raw", "drawable", "mipmap");

    /* JADX INFO: compiled from: source.java */
    public static class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f73922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f73923d;

        public a() {
            this.f73922c = 0;
            this.f73923d = 0;
        }

        public a(ImageView imageView, AttributeSet attributeSet, int i11, int i12) {
            super(imageView, attributeSet, i11, i12);
            this.f73922c = a(imageView, attributeSet, true);
            this.f73923d = a(imageView, attributeSet, false);
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z11) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z11 ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (d.f73921a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !d.e(imageView, z11, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f73924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73925b;

        public b() {
            this.f73924a = false;
            this.f73925b = -1;
        }

        public b(View view, AttributeSet attributeSet, int i11, int i12) {
            TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.GifView, i11, i12);
            this.f73924a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GifView_freezesAnimation, false);
            this.f73925b = typedArrayObtainStyledAttributes.getInt(R$styleable.GifView_loopCount, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static void a(int i11, Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).h(i11);
        }
    }

    public static float b(@NonNull Resources resources, int i11) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i11, typedValue, true);
        int i12 = typedValue.density;
        if (i12 == 0) {
            i12 = 160;
        } else if (i12 == 65535) {
            i12 = 0;
        }
        int i13 = resources.getDisplayMetrics().densityDpi;
        if (i12 <= 0 || i13 <= 0) {
            return 1.0f;
        }
        return i13 / i12;
    }

    public static a c(ImageView imageView, AttributeSet attributeSet, int i11, int i12) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i11, i12);
        int i13 = aVar.f73925b;
        if (i13 >= 0) {
            a(i13, imageView.getDrawable());
            a(i13, imageView.getBackground());
        }
        return aVar;
    }

    public static boolean d(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean e(ImageView imageView, boolean z11, int i11) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f73921a.contains(resources.getResourceTypeName(i11))) {
                    return false;
                }
                GifDrawable gifDrawable = new GifDrawable(resources, i11);
                if (z11) {
                    imageView.setImageDrawable(gifDrawable);
                    return true;
                }
                imageView.setBackground(gifDrawable);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }
}
