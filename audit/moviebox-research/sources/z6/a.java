package z6;

import a7.h;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import g7.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetManager f81880d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<String> f81877a = new h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<h<String>, Typeface> f81878b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f81879c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f81881e = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.a aVar) {
        if (callback instanceof View) {
            this.f81880d = ((View) callback).getContext().getAssets();
        } else {
            f.c("LottieDrawable must be inside of a view for images to work.");
            this.f81880d = null;
        }
    }

    public final Typeface a(a7.b bVar) {
        String strA = bVar.a();
        Typeface typeface = this.f81879c.get(strA);
        if (typeface != null) {
            return typeface;
        }
        bVar.c();
        bVar.b();
        if (bVar.d() != null) {
            return bVar.d();
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.f81880d, "fonts/" + strA + this.f81881e);
        this.f81879c.put(strA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public Typeface b(a7.b bVar) {
        this.f81877a.b(bVar.a(), bVar.c());
        Typeface typeface = this.f81878b.get(this.f81877a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(bVar), bVar.c());
        this.f81878b.put(this.f81877a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.f81881e = str;
    }

    public void d(@Nullable com.airbnb.lottie.a aVar) {
    }

    public final Typeface e(Typeface typeface, String str) {
        int i11;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i11 = 3;
        } else if (zContains) {
            i11 = 2;
        } else {
            i11 = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i11 ? typeface : Typeface.create(typeface, i11);
    }
}
