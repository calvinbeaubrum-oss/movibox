package f0;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.cloud.tmc.miniapp.R$color;
import kotlin.jvm.internal.Intrinsics;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements o0.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0.a f64475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f64476b;

    public c(o0.a type, boolean z11) {
        Intrinsics.g(type, "type");
        this.f64475a = type;
        this.f64476b = z11;
    }

    @Override // o0.c
    public o0.a OooO00o() {
        return this.f64475a;
    }

    @Override // o0.c
    public int a() {
        return 0;
    }

    @Override // o0.c
    public float b() {
        return 0.0f;
    }

    @Override // o0.c
    public float c() {
        return 0.0f;
    }

    @Override // o0.c
    public int d() {
        return 0;
    }

    @Override // o0.c
    public int e() {
        return 17;
    }

    @Override // o0.c
    public View f(Context context) {
        Intrinsics.g(context, "context");
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        linearLayoutCompat.setId(R.id.content);
        linearLayoutCompat.setOrientation(1);
        linearLayoutCompat.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xb.a.b(120), xb.a.b(120));
        linearLayoutCompat.setPaddingRelative(xb.a.b(12), xb.a.b(26), xb.a.b(12), 0);
        linearLayoutCompat.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(z2.a.getColor(context, R$color.mini_black70));
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
        linearLayoutCompat.setBackground(gradientDrawable);
        Intrinsics.g(context, "context");
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setId(R.id.icon);
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(xb.a.b(44), xb.a.b(44)));
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayoutCompat.addView(appCompatImageView);
        Intrinsics.g(context, "context");
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setGravity(17);
        textView.setTextColor(z2.a.getColor(context, R$color.mini_color_white));
        Resources resources = context.getResources();
        textView.setTextSize(0, TypedValue.applyDimension(2, 12.0f, resources != null ? resources.getDisplayMetrics() : null));
        textView.setMaxLines(1);
        textView.setMaxEms(7);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        textView.setPaddingRelative(0, xb.a.b(8), 0, 0);
        textView.setLayoutParams(layoutParams2);
        i.f(textView, this.f64476b);
        linearLayoutCompat.addView(textView);
        return linearLayoutCompat;
    }
}
