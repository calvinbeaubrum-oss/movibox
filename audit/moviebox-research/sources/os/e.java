package os;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.commercialization.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f73386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73389d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f73393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f73394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final f f73395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final RecyclerView f73396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f73397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f73398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f73399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f73400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f73401q;

    public e(@NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull f fVar, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f73386a = linearLayout;
        this.f73387b = constraintLayout;
        this.f73388c = constraintLayout2;
        this.f73389d = appCompatImageView;
        this.f73390f = appCompatImageView2;
        this.f73391g = appCompatTextView;
        this.f73392h = appCompatImageView3;
        this.f73393i = linearLayoutCompat;
        this.f73394j = linearLayoutCompat2;
        this.f73395k = fVar;
        this.f73396l = recyclerView;
        this.f73397m = textView;
        this.f73398n = textView2;
        this.f73399o = textView3;
        this.f73400p = textView4;
        this.f73401q = textView5;
    }

    @NonNull
    public static e a(@NonNull View view) {
        View viewA;
        int i11 = R$id.adGroup;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.cl2MemberInfo;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout2 != null) {
                i11 = R$id.ivClose;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivIcon;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.ivPremium;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.ivRefresh;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView3 != null) {
                                i11 = R$id.llContent;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                if (linearLayoutCompat != null) {
                                    i11 = R$id.llLine;
                                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) n6.b.a(view, i11);
                                    if (linearLayoutCompat2 != null && (viewA = n6.b.a(view, (i11 = R$id.rewarded_layout))) != null) {
                                        f fVarA = f.a(viewA);
                                        i11 = R$id.f51603rv;
                                        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                        if (recyclerView != null) {
                                            i11 = R$id.tvGetAd;
                                            TextView textView = (TextView) n6.b.a(view, i11);
                                            if (textView != null) {
                                                i11 = R$id.tvGetAdSec;
                                                TextView textView2 = (TextView) n6.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.tvTips;
                                                    TextView textView3 = (TextView) n6.b.a(view, i11);
                                                    if (textView3 != null) {
                                                        i11 = R$id.tvTipsSec;
                                                        TextView textView4 = (TextView) n6.b.a(view, i11);
                                                        if (textView4 != null) {
                                                            i11 = R$id.tvTryMore;
                                                            TextView textView5 = (TextView) n6.b.a(view, i11);
                                                            if (textView5 != null) {
                                                                return new e((LinearLayout) view, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatImageView3, linearLayoutCompat, linearLayoutCompat2, fVarA, recyclerView, textView, textView2, textView3, textView4, textView5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f73386a;
    }
}
