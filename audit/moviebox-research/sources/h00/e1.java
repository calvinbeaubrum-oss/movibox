package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e1 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f65826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65828d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f65830g;

    public e1(@NonNull View view, @NonNull BLFrameLayout bLFrameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView, @NonNull View view2) {
        this.f65825a = view;
        this.f65826b = bLFrameLayout;
        this.f65827c = appCompatImageView;
        this.f65828d = recyclerView;
        this.f65829f = appCompatTextView;
        this.f65830g = view2;
    }

    @NonNull
    public static e1 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.fl_content;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null && (viewA = n6.b.a(view, (i11 = R$id.v_top_bg))) != null) {
                        return new e1(view, bLFrameLayout, appCompatImageView, recyclerView, appCompatTextView, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65825a;
    }
}
