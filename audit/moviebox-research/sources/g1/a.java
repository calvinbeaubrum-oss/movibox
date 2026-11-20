package g1;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f65313a;

    public a(Context context) {
        this.f65313a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f65313a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f65313a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f65313a.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i11 > 600) {
            return 5;
        }
        if (i11 > 960 && i12 > 720) {
            return 5;
        }
        if (i11 > 720 && i12 > 960) {
            return 5;
        }
        if (i11 >= 500) {
            return 4;
        }
        if (i11 > 640 && i12 > 480) {
            return 4;
        }
        if (i11 <= 480 || i12 <= 640) {
            return i11 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f65313a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f65313a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = this.f65313a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f65313a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        return true;
    }
}
