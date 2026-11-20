package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.LoadingAnimView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BubbleTextView f64420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f64421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f64422d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f64423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f64424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f64425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f64426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final LoadingAnimView f64429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final OperationVerticalBarView f64430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final OperationBarView f64431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final RatingBar f64432o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64433p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64435r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final RecyclerView f64436s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final RecyclerView f64437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final ObservableScrollView f64438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final TextView f64439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final TextView f64440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final TextView f64441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final View f64442y;

    public h(@NonNull RelativeLayout relativeLayout, @NonNull BubbleTextView bubbleTextView, @NonNull EditText editText, @NonNull EditText editText2, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull LoadingAnimView loadingAnimView, @NonNull OperationVerticalBarView operationVerticalBarView, @NonNull OperationBarView operationBarView, @NonNull RatingBar ratingBar, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull ObservableScrollView observableScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view) {
        this.f64419a = relativeLayout;
        this.f64420b = bubbleTextView;
        this.f64421c = editText;
        this.f64422d = editText2;
        this.f64423f = frameLayout;
        this.f64424g = frameLayout2;
        this.f64425h = imageView;
        this.f64426i = imageView2;
        this.f64427j = relativeLayout2;
        this.f64428k = linearLayout;
        this.f64429l = loadingAnimView;
        this.f64430m = operationVerticalBarView;
        this.f64431n = operationBarView;
        this.f64432o = ratingBar;
        this.f64433p = relativeLayout3;
        this.f64434q = relativeLayout4;
        this.f64435r = relativeLayout5;
        this.f64436s = recyclerView;
        this.f64437t = recyclerView2;
        this.f64438u = observableScrollView;
        this.f64439v = textView;
        this.f64440w = textView2;
        this.f64441x = textView3;
        this.f64442y = view;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        int i11 = R$id.activity_tip;
        BubbleTextView bubbleTextView = (BubbleTextView) n6.b.a(view, i11);
        if (bubbleTextView != null) {
            i11 = R$id.et_des;
            EditText editText = (EditText) n6.b.a(view, i11);
            if (editText != null) {
                i11 = R$id.et_title;
                EditText editText2 = (EditText) n6.b.a(view, i11);
                if (editText2 != null) {
                    i11 = R$id.fl_top;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.fr_title;
                        FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout2 != null) {
                            i11 = R$id.iv_cover;
                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.iv_cover_ic;
                                ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                                if (imageView2 != null) {
                                    i11 = R$id.ll_list;
                                    RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
                                    if (relativeLayout != null) {
                                        i11 = R$id.ll_top;
                                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                        if (linearLayout != null) {
                                            i11 = R$id.loading_view;
                                            LoadingAnimView loadingAnimView = (LoadingAnimView) n6.b.a(view, i11);
                                            if (loadingAnimView != null) {
                                                i11 = R$id.oper_vertical_view;
                                                OperationVerticalBarView operationVerticalBarView = (OperationVerticalBarView) n6.b.a(view, i11);
                                                if (operationVerticalBarView != null) {
                                                    i11 = R$id.oper_view;
                                                    OperationBarView operationBarView = (OperationBarView) n6.b.a(view, i11);
                                                    if (operationBarView != null) {
                                                        i11 = R$id.rb_star;
                                                        RatingBar ratingBar = (RatingBar) n6.b.a(view, i11);
                                                        if (ratingBar != null) {
                                                            i11 = R$id.rl_add_cover;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) n6.b.a(view, i11);
                                                            if (relativeLayout2 != null) {
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                                                i11 = R$id.rl_star;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) n6.b.a(view, i11);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R$id.rv_link;
                                                                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                                                    if (recyclerView != null) {
                                                                        i11 = R$id.rv_select;
                                                                        RecyclerView recyclerView2 = (RecyclerView) n6.b.a(view, i11);
                                                                        if (recyclerView2 != null) {
                                                                            i11 = R$id.scrollView;
                                                                            ObservableScrollView observableScrollView = (ObservableScrollView) n6.b.a(view, i11);
                                                                            if (observableScrollView != null) {
                                                                                i11 = R$id.tv_click_stars;
                                                                                TextView textView = (TextView) n6.b.a(view, i11);
                                                                                if (textView != null) {
                                                                                    i11 = R$id.tv_star_tips;
                                                                                    TextView textView2 = (TextView) n6.b.a(view, i11);
                                                                                    if (textView2 != null) {
                                                                                        i11 = R$id.tv_title_tips;
                                                                                        TextView textView3 = (TextView) n6.b.a(view, i11);
                                                                                        if (textView3 != null && (viewA = n6.b.a(view, (i11 = R$id.view_line2))) != null) {
                                                                                            return new h(relativeLayout3, bubbleTextView, editText, editText2, frameLayout, frameLayout2, imageView, imageView2, relativeLayout, linearLayout, loadingAnimView, operationVerticalBarView, operationBarView, ratingBar, relativeLayout2, relativeLayout3, relativeLayout4, recyclerView, recyclerView2, observableScrollView, textView, textView2, textView3, viewA);
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
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_film_review, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f64419a;
    }
}
