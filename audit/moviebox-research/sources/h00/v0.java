package h00;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class v0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f66055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66058d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f66060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f66061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f66062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final BLTextView f66063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final Space f66064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f66065l;

    public v0(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull BLTextView bLTextView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull BLTextView bLTextView2, @NonNull Space space, @NonNull View view2) {
        this.f66055a = view;
        this.f66056b = appCompatImageView;
        this.f66057c = appCompatTextView;
        this.f66058d = appCompatTextView2;
        this.f66059f = appCompatTextView3;
        this.f66060g = bLTextView;
        this.f66061h = linearLayout;
        this.f66062i = recyclerView;
        this.f66063j = bLTextView2;
        this.f66064k = space;
        this.f66065l = view2;
    }

    @NonNull
    public static v0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.innerTvTitle;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.iv_seasons;
                        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.llLanguage;
                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.quality_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tvLanguage;
                                    BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                                    if (bLTextView2 != null) {
                                        i11 = R$id.v_bottom_space;
                                        Space space = (Space) n6.b.a(view, i11);
                                        if (space != null && (viewA = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                                            return new v0(view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView, linearLayout, recyclerView, bLTextView2, space, viewA);
                                        }
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

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f66055a;
    }
}
