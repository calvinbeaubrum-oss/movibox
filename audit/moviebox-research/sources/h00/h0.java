package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadPathEntranceView;
import com.transsnet.downloader.widget.DownloadView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final o0 f65888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f65889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f65890d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f65891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final DownloadView f65892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f65894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final DownloadPathEntranceView f65895j;

    public h0(@NonNull FrameLayout frameLayout, @NonNull o0 o0Var, @NonNull ImageView imageView, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull DownloadView downloadView, @NonNull AppCompatTextView appCompatTextView, @NonNull View view2, @NonNull DownloadPathEntranceView downloadPathEntranceView) {
        this.f65887a = frameLayout;
        this.f65888b = o0Var;
        this.f65889c = imageView;
        this.f65890d = view;
        this.f65891f = linearLayoutCompat;
        this.f65892g = downloadView;
        this.f65893h = appCompatTextView;
        this.f65894i = view2;
        this.f65895j = downloadPathEntranceView;
    }

    @NonNull
    public static h0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.included_content;
        View viewA3 = n6.b.a(view, i11);
        if (viewA3 != null) {
            o0 o0VarA = o0.a(viewA3);
            i11 = R$id.iv_close;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.ll_content;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.tv_download;
                    DownloadView downloadView = (DownloadView) n6.b.a(view, i11);
                    if (downloadView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_bottom))) != null) {
                            i11 = R$id.v_path_entrance;
                            DownloadPathEntranceView downloadPathEntranceView = (DownloadPathEntranceView) n6.b.a(view, i11);
                            if (downloadPathEntranceView != null) {
                                return new h0((FrameLayout) view, o0VarA, imageView, viewA, linearLayoutCompat, downloadView, appCompatTextView, viewA2, downloadPathEntranceView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static h0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_single_res, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65887a;
    }
}
