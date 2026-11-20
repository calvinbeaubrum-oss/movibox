package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.browser.R$dimen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1809b;

    public BrowserActionsFallbackMenuView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1808a = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_min_padding);
        this.f1809b = getResources().getDimensionPixelOffset(R$dimen.browser_actions_context_menu_max_width);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f1808a * 2), this.f1809b), 1073741824), i12);
    }
}
