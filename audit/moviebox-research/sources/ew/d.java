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
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f64384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f64385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f64386d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f64387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CustomHeader f64390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f64391j;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CustomHeader customHeader, @NonNull TextView textView3) {
        this.f64383a = constraintLayout;
        this.f64384b = textView;
        this.f64385c = textView2;
        this.f64386d = progressBar;
        this.f64387f = recyclerView;
        this.f64388g = linearLayout;
        this.f64389h = linearLayout2;
        this.f64390i = customHeader;
        this.f64391j = textView3;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.confirmTV;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.selectNumTV;
            TextView textView2 = (TextView) n6.b.a(view, i11);
            if (textView2 != null) {
                i11 = R$id.select_video_loading;
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
                                    TextView textView3 = (TextView) n6.b.a(view, i11);
                                    if (textView3 != null) {
                                        return new d((ConstraintLayout) view, textView, textView2, progressBar, recyclerView, linearLayout, linearLayout2, customHeader, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_select_image, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64383a;
    }
}
