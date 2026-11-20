package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f65708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f65709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65710d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65714i;

    public a0(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull ProgressBar progressBar) {
        this.f65707a = frameLayout;
        this.f65708b = linearLayout;
        this.f65709c = linearLayout2;
        this.f65710d = recyclerView;
        this.f65711f = appCompatTextView;
        this.f65712g = appCompatTextView2;
        this.f65713h = appCompatTextView3;
        this.f65714i = progressBar;
    }

    @NonNull
    public static a0 a(@NonNull View view) {
        int i11 = R$id.ll_loading;
        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.ll_not_net;
            LinearLayout linearLayout2 = (LinearLayout) n6.b.a(view, i11);
            if (linearLayout2 != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_loading;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_no_network_content;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_retry;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                i11 = R$id.view_load;
                                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                if (progressBar != null) {
                                    return new a0((FrameLayout) view, linearLayout, linearLayout2, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, progressBar);
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
    public static a0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_group, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65707a;
    }
}
