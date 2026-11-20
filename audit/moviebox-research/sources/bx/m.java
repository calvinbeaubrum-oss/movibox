package bx;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.search.R$id;
import com.transsnet.downloader.widget.DownloadView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class m implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f14512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f14513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CornerTextView f14514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f14515d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final DownloadView f14516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f14518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14521k;

    public m(@NonNull View view, @NonNull ShapeableImageView shapeableImageView, @NonNull CornerTextView cornerTextView, @NonNull View view2, @NonNull DownloadView downloadView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f14512a = view;
        this.f14513b = shapeableImageView;
        this.f14514c = cornerTextView;
        this.f14515d = view2;
        this.f14516f = downloadView;
        this.f14517g = recyclerView;
        this.f14518h = linearLayout;
        this.f14519i = appCompatTextView;
        this.f14520j = appCompatTextView2;
        this.f14521k = appCompatTextView3;
    }

    @NonNull
    public static m a(@NonNull View view) {
        View viewA;
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivSearchCorner;
            CornerTextView cornerTextView = (CornerTextView) n6.b.a(view, i11);
            if (cornerTextView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.llDownload;
                DownloadView downloadView = (DownloadView) n6.b.a(view, i11);
                if (downloadView != null) {
                    i11 = R$id.rvSeasons;
                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tagContentLL;
                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.tvSubject;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tvSubjectScore;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tvSubjectYear;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        return new m(view, shapeableImageView, cornerTextView, viewA, downloadView, recyclerView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        return this.f14512a;
    }
}
