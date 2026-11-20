package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f80834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80836d;

    public j0(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull LinearLayout linearLayout2, @NonNull AppCompatTextView appCompatTextView) {
        this.f80833a = linearLayout;
        this.f80834b = appCompatImageButton;
        this.f80835c = linearLayout2;
        this.f80836d = appCompatTextView;
    }

    @NonNull
    public static j0 a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.rlContent;
            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
            if (linearLayout != null) {
                i11 = R$id.tv_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new j0((LinearLayout) view, appCompatImageButton, linearLayout, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static j0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.use_activity_webview_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80833a;
    }
}
