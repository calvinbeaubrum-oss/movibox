package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f14460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f14461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f14462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14463d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f14464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f14465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f14466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f14468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f14469k;

    public d(@NonNull RelativeLayout relativeLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f14460a = relativeLayout;
        this.f14461b = editText;
        this.f14462c = imageView;
        this.f14463d = appCompatImageView;
        this.f14464f = linearLayout;
        this.f14465g = progressBar;
        this.f14466h = relativeLayout2;
        this.f14467i = recyclerView;
        this.f14468j = textView;
        this.f14469k = textView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.comment_input_edit_text;
        EditText editText = (EditText) n6.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.iv_cancel;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_clear;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_top;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.load_view;
                        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                        if (progressBar != null) {
                            i11 = R$id.rl_tips;
                            RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
                            if (relativeLayout != null) {
                                i11 = R$id.f57421rv;
                                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tv_clear;
                                    TextView textView = (TextView) n6.b.a(view, i11);
                                    if (textView != null) {
                                        i11 = R$id.tv_search;
                                        TextView textView2 = (TextView) n6.b.a(view, i11);
                                        if (textView2 != null) {
                                            return new d((RelativeLayout) view, editText, imageView, appCompatImageView, linearLayout, progressBar, relativeLayout, recyclerView, textView, textView2);
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_publish_search, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f14460a;
    }
}
