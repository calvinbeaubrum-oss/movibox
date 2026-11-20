package tv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f78037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f78038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78040d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f78041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f78042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f78043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f78044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final BLTextView f78046k;

    public z(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull ShapeableImageView shapeableImageView, @NonNull BLLinearLayout bLLinearLayout, @NonNull BLLinearLayout bLLinearLayout2, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView3, @NonNull BLTextView bLTextView) {
        this.f78037a = view;
        this.f78038b = appCompatImageView;
        this.f78039c = appCompatTextView;
        this.f78040d = appCompatTextView2;
        this.f78041f = shapeableImageView;
        this.f78042g = bLLinearLayout;
        this.f78043h = bLLinearLayout2;
        this.f78044i = recyclerView;
        this.f78045j = appCompatTextView3;
        this.f78046k = bLTextView;
    }

    @NonNull
    public static z a(@NonNull View view) {
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.iv_cover;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.ll_detail;
                        BLLinearLayout bLLinearLayout = (BLLinearLayout) n6.b.a(view, i11);
                        if (bLLinearLayout != null) {
                            i11 = R$id.ll_download;
                            BLLinearLayout bLLinearLayout2 = (BLLinearLayout) n6.b.a(view, i11);
                            if (bLLinearLayout2 != null) {
                                i11 = R$id.recycler_view_ep;
                                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tv_ep_title;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_more;
                                        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                                        if (bLTextView != null) {
                                            return new z(view, appCompatImageView, appCompatTextView, appCompatTextView2, shapeableImageView, bLLinearLayout, bLLinearLayout2, recyclerView, appCompatTextView3, bLTextView);
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
        return this.f78037a;
    }
}
