package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final s0 f65811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65813d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TnTextView f65814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TnTextView f65815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TnTextView f65816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TnTextView f65818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TnTextView f65819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TnTextView f65820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TnTextView f65821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f65822n;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull s0 s0Var, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull TnTextView tnTextView, @NonNull TnTextView tnTextView2, @NonNull TnTextView tnTextView3, @NonNull AppCompatTextView appCompatTextView, @NonNull TnTextView tnTextView4, @NonNull TnTextView tnTextView5, @NonNull TnTextView tnTextView6, @NonNull TnTextView tnTextView7, @NonNull View view) {
        this.f65810a = constraintLayout;
        this.f65811b = s0Var;
        this.f65812c = constraintLayout2;
        this.f65813d = appCompatImageView;
        this.f65814f = tnTextView;
        this.f65815g = tnTextView2;
        this.f65816h = tnTextView3;
        this.f65817i = appCompatTextView;
        this.f65818j = tnTextView4;
        this.f65819k = tnTextView5;
        this.f65820l = tnTextView6;
        this.f65821m = tnTextView7;
        this.f65822n = view;
    }

    @NonNull
    public static e a(@NonNull View view) {
        View viewA;
        int i11 = R$id.card_cover;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null) {
            s0 s0VarA = s0.a(viewA2);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.iv_more;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tv_btn;
                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                if (tnTextView != null) {
                    i11 = R$id.tv_ep;
                    TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                    if (tnTextView2 != null) {
                        i11 = R$id.tv_file_size;
                        TnTextView tnTextView3 = (TnTextView) n6.b.a(view, i11);
                        if (tnTextView3 != null) {
                            i11 = R$id.tv_name;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_read_progress;
                                TnTextView tnTextView4 = (TnTextView) n6.b.a(view, i11);
                                if (tnTextView4 != null) {
                                    i11 = R$id.tv_save_file_name;
                                    TnTextView tnTextView5 = (TnTextView) n6.b.a(view, i11);
                                    if (tnTextView5 != null) {
                                        i11 = R$id.tv_save_to;
                                        TnTextView tnTextView6 = (TnTextView) n6.b.a(view, i11);
                                        if (tnTextView6 != null) {
                                            i11 = R$id.tv_series_count;
                                            TnTextView tnTextView7 = (TnTextView) n6.b.a(view, i11);
                                            if (tnTextView7 != null && (viewA = n6.b.a(view, (i11 = R$id.tv_series_line))) != null) {
                                                return new e(constraintLayout, s0VarA, constraintLayout, appCompatImageView, tnTextView, tnTextView2, tnTextView3, appCompatTextView, tnTextView4, tnTextView5, tnTextView6, tnTextView7, viewA);
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

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.adapter_downloaded_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65810a;
    }
}
