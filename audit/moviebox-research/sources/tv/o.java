package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TnTextView f77881g;

    public o(@NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout, @NonNull TnTextView tnTextView) {
        this.f77876a = frameLayout;
        this.f77877b = appCompatImageView;
        this.f77878c = progressBar;
        this.f77879d = recyclerView;
        this.f77880f = constraintLayout;
        this.f77881g = tnTextView;
    }

    @NonNull
    public static o a(@NonNull View view) {
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tool_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                    if (constraintLayout != null) {
                        i11 = R$id.tv_title;
                        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView != null) {
                            return new o((FrameLayout) view, appCompatImageView, progressBar, recyclerView, constraintLayout, tnTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static o c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static o d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_post_immersion_video_detail, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f77876a;
    }
}
