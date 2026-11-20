package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final InfoExtendView f77501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77503d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f77507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77508j;

    public i(@NonNull ConstraintLayout constraintLayout, @NonNull InfoExtendView infoExtendView, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView2, @NonNull BLLinearLayout bLLinearLayout, @NonNull AppCompatTextView appCompatTextView3) {
        this.f77500a = constraintLayout;
        this.f77501b = infoExtendView;
        this.f77502c = shapeableImageView;
        this.f77503d = appCompatImageView;
        this.f77504f = appCompatTextView;
        this.f77505g = linearLayoutCompat;
        this.f77506h = appCompatTextView2;
        this.f77507i = bLLinearLayout;
        this.f77508j = appCompatTextView3;
    }

    @NonNull
    public static i a(@NonNull View view) {
        int i11 = R$id.infoExtendView;
        InfoExtendView infoExtendView = (InfoExtendView) n6.b.a(view, i11);
        if (infoExtendView != null) {
            i11 = R$id.ivAvatar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.tv_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.tvDes;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_header_toolbar;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                        if (linearLayoutCompat != null) {
                            i11 = R$id.tvMovieTitle;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tv_music_avatar;
                                BLLinearLayout bLLinearLayout = (BLLinearLayout) n6.b.a(view, i11);
                                if (bLLinearLayout != null) {
                                    i11 = R$id.tvTag;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        return new i((ConstraintLayout) view, infoExtendView, shapeableImageView, appCompatImageView, appCompatTextView, linearLayoutCompat, appCompatTextView2, bLLinearLayout, appCompatTextView3);
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
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_music_info_dialog, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77500a;
    }
}
