package fs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.R$id;
import com.transsion.baseui.widget.DrawableCenterTextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f65280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLTextView f65281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f65282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final DrawableCenterTextView f65283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f65284g;

    public f(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull BLTextView bLTextView, @NonNull TextView textView2, @NonNull DrawableCenterTextView drawableCenterTextView, @NonNull TextView textView3) {
        this.f65279a = frameLayout;
        this.f65280b = textView;
        this.f65281c = bLTextView;
        this.f65282d = textView2;
        this.f65283f = drawableCenterTextView;
        this.f65284g = textView3;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.card_detail;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.card_tip;
            BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.card_title;
                TextView textView2 = (TextView) n6.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.iv_centerView;
                    DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) n6.b.a(view, i11);
                    if (drawableCenterTextView != null) {
                        i11 = R$id.numText;
                        TextView textView3 = (TextView) n6.b.a(view, i11);
                        if (textView3 != null) {
                            return new f((FrameLayout) view, textView, bLTextView, textView2, drawableCenterTextView, textView3);
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
        return this.f65279a;
    }
}
