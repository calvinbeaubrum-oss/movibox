package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f1786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f1787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f1788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f1789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f1790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f1791g;

    public w0(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1788d = layoutParams;
        this.f1789e = new Rect();
        this.f1790f = new int[2];
        this.f1791g = new int[2];
        this.f1785a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f1786b = viewInflate;
        this.f1787c = (TextView) viewInflate.findViewById(R$id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public final void a(View view, int i11, int i12, boolean z11, WindowManager.LayoutParams layoutParams) {
        int height;
        int i13;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1785a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i11 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1785a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            height = i12 + dimensionPixelOffset2;
            i13 = i12 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i13 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1785a.getResources().getDimensionPixelOffset(z11 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f1789e);
        Rect rect = this.f1789e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1785a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1789e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f1791g);
        view.getLocationOnScreen(this.f1790f);
        int[] iArr = this.f1790f;
        int i14 = iArr[0];
        int[] iArr2 = this.f1791g;
        int i15 = i14 - iArr2[0];
        iArr[0] = i15;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i15 + i11) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1786b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1786b.getMeasuredHeight();
        int i16 = this.f1790f[1];
        int i17 = ((i13 + i16) - dimensionPixelOffset3) - measuredHeight;
        int i18 = i16 + height + dimensionPixelOffset3;
        if (z11) {
            if (i17 >= 0) {
                layoutParams.y = i17;
                return;
            } else {
                layoutParams.y = i18;
                return;
            }
        }
        if (measuredHeight + i18 <= this.f1789e.height()) {
            layoutParams.y = i18;
        } else {
            layoutParams.y = i17;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f1785a.getSystemService("window")).removeView(this.f1786b);
        }
    }

    public boolean d() {
        return this.f1786b.getParent() != null;
    }

    public void e(View view, int i11, int i12, boolean z11, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1787c.setText(charSequence);
        a(view, i11, i12, z11, this.f1788d);
        ((WindowManager) this.f1785a.getSystemService("window")).addView(this.f1786b, this.f1788d);
    }
}
