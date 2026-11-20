package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.CustomHeader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ProgressBar f64396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f64397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64398d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CustomHeader f64400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f64401h;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CustomHeader customHeader, @NonNull TextView textView) {
        this.f64395a = constraintLayout;
        this.f64396b = progressBar;
        this.f64397c = recyclerView;
        this.f64398d = linearLayout;
        this.f64399f = linearLayout2;
        this.f64400g = customHeader;
        this.f64401h = textView;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.select_video_loading;
        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
        if (progressBar != null) {
            i11 = R$id.select_video_recycler;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.sv_lock_view;
                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.sv_no_content_view;
                    LinearLayout linearLayout2 = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout2 != null) {
                        i11 = R$id.sv_title_bar;
                        CustomHeader customHeader = (CustomHeader) n6.b.a(view, i11);
                        if (customHeader != null) {
                            i11 = R$id.sv_tv_grant;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                return new f((ConstraintLayout) view, progressBar, recyclerView, linearLayout, linearLayout2, customHeader, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_select_music, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64395a;
    }
}
