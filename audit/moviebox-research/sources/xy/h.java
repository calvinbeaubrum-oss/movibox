package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f80812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f80813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f80814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80815d;

    public h(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull ProgressBar progressBar, @NonNull TitleLayout titleLayout) {
        this.f80812a = relativeLayout;
        this.f80813b = frameLayout;
        this.f80814c = progressBar;
        this.f80815d = titleLayout;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i11 = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.load_view;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.toolbar;
                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                if (titleLayout != null) {
                    return new h((RelativeLayout) view, frameLayout, progressBar, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_profile_center_edit, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f80812a;
    }
}
