package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tn.lib.view.TitleLayout;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f64393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleLayout f64394c;

    public e(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TitleLayout titleLayout) {
        this.f64392a = linearLayout;
        this.f64393b = frameLayout;
        this.f64394c = titleLayout;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
            if (titleLayout != null) {
                return new e((LinearLayout) view, frameLayout, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_select_location, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f64392a;
    }
}
