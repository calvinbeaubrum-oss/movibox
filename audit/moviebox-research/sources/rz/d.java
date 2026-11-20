package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75792d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f75794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f75795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f75796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final BLTextView f75797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final BLTextView f75798k;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull BLTextView bLTextView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull BLTextView bLTextView2, @NonNull BLTextView bLTextView3) {
        this.f75789a = constraintLayout;
        this.f75790b = appCompatImageView;
        this.f75791c = appCompatTextView;
        this.f75792d = appCompatTextView2;
        this.f75793f = appCompatTextView3;
        this.f75794g = bLTextView;
        this.f75795h = linearLayout;
        this.f75796i = recyclerView;
        this.f75797j = bLTextView2;
        this.f75798k = bLTextView3;
    }

    @NonNull
    public static d a(@NonNull View view) {
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
                                i11 = R$id.resourceRv;
                                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tvLanguage;
                                    BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                                    if (bLTextView2 != null) {
                                        i11 = R$id.tv_more;
                                        BLTextView bLTextView3 = (BLTextView) n6.b.a(view, i11);
                                        if (bLTextView3 != null) {
                                            return new d((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView, linearLayout, recyclerView, bLTextView2, bLTextView3);
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
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_episode, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75789a;
    }
}
