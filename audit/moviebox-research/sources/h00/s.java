package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class s implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final NativeWrapperAdView f66009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CardView f66010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66011d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f66013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final BLTextView f66014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66018l;

    public s(@NonNull ConstraintLayout constraintLayout, @NonNull NativeWrapperAdView nativeWrapperAdView, @NonNull CardView cardView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull BLTextView bLTextView, @NonNull BLTextView bLTextView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4) {
        this.f66008a = constraintLayout;
        this.f66009b = nativeWrapperAdView;
        this.f66010c = cardView;
        this.f66011d = appCompatImageView;
        this.f66012f = appCompatImageView2;
        this.f66013g = bLTextView;
        this.f66014h = bLTextView2;
        this.f66015i = appCompatTextView;
        this.f66016j = appCompatTextView2;
        this.f66017k = appCompatTextView3;
        this.f66018l = appCompatTextView4;
    }

    @NonNull
    public static s a(@NonNull View view) {
        int i11 = R$id.adContainer;
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) n6.b.a(view, i11);
        if (nativeWrapperAdView != null) {
            i11 = R$id.card_native_ad;
            CardView cardView = (CardView) n6.b.a(view, i11);
            if (cardView != null) {
                i11 = R$id.ivClose;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivDownload;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.tvBtnDetails;
                        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.tvBtnPlayNow;
                            BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                            if (bLTextView2 != null) {
                                i11 = R$id.tvDes;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvFileSize;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvTitle;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tvTitleCopy;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView4 != null) {
                                                return new s((ConstraintLayout) view, nativeWrapperAdView, cardView, appCompatImageView, appCompatImageView2, bLTextView, bLTextView2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                            }
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
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66008a;
    }
}
