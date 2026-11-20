package qu;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f74901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f74902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74904d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RecyclerView f74907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f74908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f74909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f74910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final View f74911l;

    public c(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view2) {
        this.f74901a = frameLayout;
        this.f74902b = view;
        this.f74903c = constraintLayout;
        this.f74904d = constraintLayout2;
        this.f74905f = appCompatImageView;
        this.f74906g = appCompatImageView2;
        this.f74907h = recyclerView;
        this.f74908i = textView;
        this.f74909j = textView2;
        this.f74910k = textView3;
        this.f74911l = view2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        View viewA;
        int i11 = R$id.MeBg1;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null) {
            i11 = R$id.MeBg2;
            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.clRoot;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivPremium;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.rvMemberRights;
                            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.tvGetAd;
                                TextView textView = (TextView) n6.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.tvPay;
                                    TextView textView2 = (TextView) n6.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.tvTitle;
                                        TextView textView3 = (TextView) n6.b.a(view, i11);
                                        if (textView3 != null && (viewA = n6.b.a(view, (i11 = R$id.viewBtnBg))) != null) {
                                            return new c((FrameLayout) view, viewA2, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, recyclerView, textView, textView2, textView3, viewA);
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
    public FrameLayout getRoot() {
        return this.f74901a;
    }
}
