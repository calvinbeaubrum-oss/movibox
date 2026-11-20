package tv;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f77732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f77734d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f77735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f77736g;

    public f(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f77731a = frameLayout;
        this.f77732b = imageView;
        this.f77733c = linearLayoutCompat;
        this.f77734d = textView;
        this.f77735f = textView2;
        this.f77736g = textView3;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.ivSelect;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.llSelect;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.tvBtnCancel;
                TextView textView = (TextView) n6.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvBtnDownload;
                    TextView textView2 = (TextView) n6.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvTip;
                        TextView textView3 = (TextView) n6.b.a(view, i11);
                        if (textView3 != null) {
                            return new f((FrameLayout) view, imageView, linearLayoutCompat, textView, textView2, textView3);
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
        return this.f77731a;
    }
}
