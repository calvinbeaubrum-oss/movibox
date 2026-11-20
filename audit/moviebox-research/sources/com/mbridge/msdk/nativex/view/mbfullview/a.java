package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.v;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f45948b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f45949a;

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f45953a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            f45953a = iArr;
            try {
                iArr[BaseView.a.FULL_TOP_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45953a[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0502a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<MBridgeTopFullView> f45955b;

        public C0502a(MBridgeTopFullView mBridgeTopFullView) {
            this.f45955b = new WeakReference<>(mBridgeTopFullView);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            WeakReference<MBridgeTopFullView> weakReference = this.f45955b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f45955b.get().getMBridgeFullViewDisplayIcon().setImageBitmap(a.a(a.this, bitmap, 25));
        }
    }

    private a(Context context) {
        this.f45949a = new WeakReference<>(context);
    }

    private float a(boolean z11) {
        try {
            Context context = this.f45949a.get();
            if (context == null) {
                return 0.0f;
            }
            float fH = ai.h(context);
            return z11 ? fH + ai.c(context) : fH;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public static /* synthetic */ Bitmap a(a aVar, Bitmap bitmap, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        bitmap.getWidth();
        float f11 = i11;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static a a(Context context) {
        if (f45948b == null) {
            synchronized (a.class) {
                try {
                    if (f45948b == null) {
                        f45948b = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f45948b;
    }

    public static /* synthetic */ void a(a aVar, View view) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(800L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(1);
        view.startAnimation(alphaAnimation);
    }

    public final void a(View view, BaseView baseView) {
        if (view == null || baseView == null) {
            return;
        }
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        baseView.f45940i.addView(view);
    }

    public final void a(BaseView.a aVar, CampaignEx campaignEx, BaseView baseView) {
        int i11 = AnonymousClass2.f45953a[aVar.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                return;
            }
            baseView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            return;
        }
        MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
        if (mBridgeTopFullView != null) {
            Context context = this.f45949a.get();
            if (context != null) {
                b.a(context).a(campaignEx.getIconUrl(), new C0502a(mBridgeTopFullView));
            }
            mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setText(campaignEx.getAppName());
            mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setText(campaignEx.getAppDesc());
            mBridgeTopFullView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
            mBridgeTopFullView.getStarLevelLayoutView().setRating((int) campaignEx.getRating());
        }
    }

    public final void a(BaseView baseView, boolean z11) {
        if (baseView != null) {
            baseView.setSystemUiVisibility(z11 ? 0 : InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    public final void a(boolean z11, BaseView baseView, int i11) {
        RelativeLayout.LayoutParams layoutParams;
        Context context = this.f45949a.get();
        if (context != null) {
            if (z11) {
                layoutParams = new RelativeLayout.LayoutParams((int) (a(z11) / 3.0f), ai.a(context, 45.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = ai.a(context, 10.0f);
                layoutParams.rightMargin = (d.a(context) && i11 == 0) ? ai.c(context) + ai.a(context, 8.0f) : ai.a(context, 8.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, ai.a(context, 45.0f));
                layoutParams.addRule(12);
            }
            baseView.getmAnimationContent().setLayoutParams(layoutParams);
        }
    }

    public final void a(final boolean z11, boolean z12, final BaseView baseView) {
        int color = Color.parseColor("#ff264870");
        baseView.getmAnimationPlayer().setBackgroundColor(color);
        Context context = this.f45949a.get();
        if (z11) {
            if (baseView.style == BaseView.a.FULL_TOP_VIEW && context != null) {
                baseView.getmAnimationContent().setBackgroundResource(v.a(context, "mbridge_nativex_fullview_background", "drawable"));
                baseView.getmAnimationPlayer().setBackgroundColor(color);
            }
            if (z12) {
                baseView.getmAnimationPlayer().getBackground().setAlpha(80);
            } else {
                baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                baseView.getmAnimationPlayer().getBackground().setAlpha(200);
            }
        } else if (baseView.style != BaseView.a.FULL_MIDDLE_VIEW) {
            if (context != null) {
                baseView.getmAnimationContent().setBackgroundResource(v.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                baseView.getmAnimationPlayer().setBackgroundResource(v.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                return;
            }
            return;
        }
        if (z12) {
            new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.nativex.view.mbfullview.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                    baseView.getmAnimationPlayer().getBackground().setAlpha(z11 ? 200 : 255);
                    a.a(a.this, baseView.getmAnimationPlayer());
                }
            }, 1000L);
        }
    }
}
