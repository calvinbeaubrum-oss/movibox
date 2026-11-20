package f0;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements o0.c<View> {
    @Override // o0.c
    public o0.a OooO00o() {
        return o0.a.c.f72241b;
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
    @SuppressLint({"ObsoleteSdkInt"})
    public View f(Context context) {
        Resources resources;
        Intrinsics.g(context, "context");
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setGravity(17);
        Intrinsics.g(context, "context");
        textView.setTextColor(z2.a.getColor(context, R$color.mini_color_white));
        textView.setTextSize(0, TypedValue.applyDimension(2, 14.0f, (context == null || (resources = context.getResources()) == null) ? null : resources.getDisplayMetrics()));
        textView.setMaxLines(2);
        textView.setMinWidth(xb.a.b(120));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        Intrinsics.g(context, "context");
        int iApplyDimension = (int) TypedValue.applyDimension(1, 12.0f, context.getResources().getDisplayMetrics());
        Intrinsics.g(context, "context");
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
        textView.setPaddingRelative(iApplyDimension, iApplyDimension2, iApplyDimension, iApplyDimension2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMarginStart(xb.a.b(36));
        marginLayoutParams.setMarginEnd(xb.a.b(36));
        textView.setLayoutParams(marginLayoutParams);
        Intrinsics.g(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(z2.a.getColor(context, R$color.mini_black70));
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
        textView.setBackground(gradientDrawable);
        Intrinsics.g(context, "context");
        textView.setZ(TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics()));
        return textView;
    }
}
