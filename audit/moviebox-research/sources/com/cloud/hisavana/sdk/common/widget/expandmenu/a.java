package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.widget.expandmenu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ViewTreeObserverOnGlobalLayoutListenerC0327a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdExpandMenuContentView f29547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f29548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f29549c;

        public ViewTreeObserverOnGlobalLayoutListenerC0327a(AdExpandMenuContentView adExpandMenuContentView, View view, boolean z11) {
            this.f29547a = adExpandMenuContentView;
            this.f29548b = view;
            this.f29549c = z11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.d(this.f29547a, this.f29548b, this.f29549c);
            this.f29547a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static void d(AdExpandMenuContentView adExpandMenuContentView, View view, boolean z11) {
        View viewFindViewById = adExpandMenuContentView.findViewById(R$id.arrow_up);
        View viewFindViewById2 = adExpandMenuContentView.findViewById(R$id.arrow_down);
        int[] iArr = new int[2];
        adExpandMenuContentView.getLocationInWindow(iArr);
        int i11 = iArr[0];
        view.getLocationInWindow(iArr);
        int i12 = iArr[0];
        int iA = j.a(210.0f);
        int iA2 = j.a(11.0f);
        int iA3 = j.a(8.0f);
        int iMin = Math.min((iA - iA2) - iA3, Math.max(iA3, ((i12 - i11) + (view.getWidth() / 2)) - (viewFindViewById.getWidth() / 2)));
        ((RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams()).setMarginStart(iMin);
        ((RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams()).setMarginStart(iMin);
        viewFindViewById.setVisibility(z11 ? 8 : 0);
        viewFindViewById2.setVisibility(z11 ? 0 : 8);
        adExpandMenuContentView.requestLayout();
    }

    public static int[] e(View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int iG = j.g();
        int iF = j.f();
        int i11 = 0;
        int iMin = Math.min((iG - view2.getMeasuredWidth()) - j.a(4.0f), Math.max(j.a(4.0f), ((iArr[0] + view.getWidth()) - view2.getMeasuredWidth()) + j.a(8.0f)));
        int height = iArr[1] + view.getHeight();
        if (view2.getMeasuredHeight() + height + j.a(20.0f) > iF) {
            height = iArr[1] - view2.getMeasuredHeight();
            i11 = 1;
        }
        return new int[]{iMin, height, i11};
    }

    public static void f(PopupWindow popupWindow) {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public static /* synthetic */ void h(PopupWindow popupWindow, AdExpandMenuContentView.d dVar, AdExpandMenuItemView.Type type) {
        f(popupWindow);
        if (dVar != null) {
            dVar.a(type);
        }
    }

    public static PopupWindow i(View view, String str, final AdExpandMenuContentView.d dVar) {
        if (view == null) {
            return null;
        }
        try {
            FrameLayout frameLayout = new FrameLayout(f.a());
            frameLayout.setBackgroundColor(Color.parseColor("#33000000"));
            AdExpandMenuContentView adExpandMenuContentView = new AdExpandMenuContentView(f.a());
            adExpandMenuContentView.setAdvertiserName(str);
            adExpandMenuContentView.measure(View.MeasureSpec.makeMeasureSpec(j.a(210.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            frameLayout.addView(adExpandMenuContentView, new FrameLayout.LayoutParams(adExpandMenuContentView.getMeasuredWidth(), adExpandMenuContentView.getMeasuredHeight()));
            final PopupWindow popupWindow = new PopupWindow((View) frameLayout, -1, -1, false);
            popupWindow.setBackgroundDrawable(new ColorDrawable());
            popupWindow.setAnimationStyle(R$style.Animation_AppCompat_Dialog);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setClippingEnabled(true);
            if (Build.VERSION.SDK_INT >= 29) {
                popupWindow.setIsClippedToScreen(true);
            }
            popupWindow.update();
            int[] iArrE = e(view, adExpandMenuContentView);
            boolean z11 = iArrE[2] == 1;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: z9.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.cloud.hisavana.sdk.common.widget.expandmenu.a.f(popupWindow);
                }
            });
            adExpandMenuContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0327a(adExpandMenuContentView, view, z11));
            adExpandMenuContentView.setListener(new AdExpandMenuContentView.d() { // from class: z9.b
                @Override // com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView.d
                public final void a(AdExpandMenuItemView.Type type) {
                    com.cloud.hisavana.sdk.common.widget.expandmenu.a.h(popupWindow, dVar, type);
                }
            });
            int i11 = iArrE[0];
            int i12 = iArrE[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adExpandMenuContentView.getLayoutParams();
            layoutParams.setMarginStart(i11);
            layoutParams.topMargin = i12;
            adExpandMenuContentView.setLayoutParams(layoutParams);
            popupWindow.showAtLocation(view, 0, 0, 0);
            return popupWindow;
        } catch (Exception unused) {
            z.a().w("AdExpandMenu", "Failed to show adexpandmenu.");
            return null;
        }
    }
}
