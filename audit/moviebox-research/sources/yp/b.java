package yp;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f81576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f81577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleLayout f81578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f81579d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f81580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f81581g;

    public b(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatImageView appCompatImageView, @NonNull TitleLayout titleLayout, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f81576a = linearLayoutCompat;
        this.f81577b = appCompatImageView;
        this.f81578c = titleLayout;
        this.f81579d = linearLayoutCompat2;
        this.f81580f = textView;
        this.f81581g = textView2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.ivDefaultImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.llTitle;
            TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
            if (titleLayout != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i11 = R$id.tvDesc;
                TextView textView = (TextView) n6.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tv_retry;
                    TextView textView2 = (TextView) n6.b.a(view, i11);
                    if (textView2 != null) {
                        return new b(linearLayoutCompat, appCompatImageView, titleLayout, linearLayoutCompat, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f81576a;
    }
}
