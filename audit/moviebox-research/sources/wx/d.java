package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f79677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f79679d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f79681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f79682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f79683i;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f79676a = constraintLayout;
        this.f79677b = editTextWithClear;
        this.f79678c = appCompatImageView;
        this.f79679d = imageView;
        this.f79680f = linearLayoutCompat;
        this.f79681g = textView;
        this.f79682h = textView2;
        this.f79683i = textView3;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.et_search_keyword;
        EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
        if (editTextWithClear != null) {
            i11 = R$id.iv_search_keyword;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_select;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ll_select;
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                    if (linearLayoutCompat != null) {
                        i11 = R$id.tv_download;
                        TextView textView = (TextView) n6.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tv_tips;
                            TextView textView2 = (TextView) n6.b.a(view, i11);
                            if (textView2 != null) {
                                i11 = R$id.tv_title;
                                TextView textView3 = (TextView) n6.b.a(view, i11);
                                if (textView3 != null) {
                                    return new d((ConstraintLayout) view, editTextWithClear, appCompatImageView, imageView, linearLayoutCompat, textView, textView2, textView3);
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_no_subtitle_tips, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79676a;
    }
}
