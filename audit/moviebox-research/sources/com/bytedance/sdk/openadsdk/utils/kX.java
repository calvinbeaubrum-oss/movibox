package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class kX {
    private static int ExN = -1;
    private static float Ol = -1.0f;
    private static int Qj = -1;
    private static WindowManager TRI = null;
    private static boolean Tf = true;
    private static final Object UFX = new Object();
    private static Boolean WH = null;
    private static int We = -1;
    private static int pFF = -1;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static ViewConfiguration f28772qr = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static float f28773sc = -1.0f;
    private static float zY = -1.0f;

    public static boolean BT(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static float ExN(Context context) {
        sc(context, true);
        return f28773sc;
    }

    public static void ExN(View view) {
        if (view == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.kX.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    kX.sc(view2, 8);
                    view2.setAlpha(1.0f);
                }
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static int Ol(Context context) {
        return ((Integer) Qj(context).second).intValue();
    }

    public static Pair<Integer, Integer> Qj(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.Xc.sc();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static boolean Ql(Context context) {
        String str = Build.MODEL;
        return str.equals("IN2010") || str.equals("IN2020") || str.equals("KB2000") || str.startsWith("ONEPLUS");
    }

    public static boolean SR(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            return (string == null || TextUtils.isEmpty(string)) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static float TRI(Context context) {
        sc(context);
        return zY;
    }

    public static void TRI(View view) {
        if (view == null) {
            return;
        }
        sc(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.kX.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static boolean Tf(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean UFX(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static int WH(Context context) {
        return ((Integer) Qj(context).first).intValue();
    }

    public static int We(Context context) {
        sc(context);
        return ExN;
    }

    public static int We(Context context, float f11) {
        sc(context, true);
        float fExN = ExN(context);
        if (fExN <= 0.0f) {
            fExN = 1.0f;
        }
        return (int) ((f11 / fExN) + 0.5f);
    }

    public static boolean We(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
                Tf = false;
            } else {
                displayCutout = null;
            }
            return displayCutout != null;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e11.getMessage());
            return false;
        }
    }

    public static boolean We(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int pFF(Context context, float f11) {
        sc(context);
        float fTRI = TRI(context);
        if (fTRI <= 0.0f) {
            fTRI = 1.0f;
        }
        return (int) ((f11 / fTRI) + 0.5f);
    }

    private static Bitmap pFF(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(we2.getWidth(), we2.getHeight(), Bitmap.Config.RGB_565);
            we2.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static ArrayList<Integer> pFF(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i11 = width * height;
            int[] iArr = new int[i11];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = iArr[i12];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i13) >> 16, (65280 & i13) >> 8, i13 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void pFF(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static void pFF(View view, final float f11) {
        if (view != null && f11 > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.utils.kX.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f11);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static boolean pFF() {
        return Tf && Build.VERSION.SDK_INT >= 28;
    }

    public static int[] pFF(Context context) {
        if (context == null) {
            return null;
        }
        if (TRI == null) {
            TRI = (WindowManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = TRI;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i11 = displayMetrics.widthPixels;
            int i12 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i11 = point.x;
                i12 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i11;
            iArr[1] = i12;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] pFF(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int qr(Context context) {
        sc(context);
        return pFF;
    }

    public static void qr(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static float sc() {
        float f11 = Ol;
        if (f11 > 0.0f) {
            return f11;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.Xc.sc().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        Ol = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static float sc(Context context, float f11) {
        sc(context);
        return f11 * TRI(context);
    }

    public static float sc(Context context, float f11, boolean z11) {
        sc(context);
        return (f11 * ExN(context)) + (z11 ? 0.5f : 0.0f);
    }

    public static int sc(Bitmap bitmap) {
        try {
            ArrayList<Integer> arrayListPFF = pFF(bitmap);
            if (arrayListPFF == null) {
                return -1;
            }
            HashMap map = new HashMap();
            for (Integer num : arrayListPFF) {
                if (map.containsKey(num)) {
                    Integer numValueOf = Integer.valueOf(((Integer) map.get(num)).intValue() + 1);
                    map.remove(num);
                    map.put(num, numValueOf);
                } else {
                    map.put(num, 1);
                }
            }
            int iIntValue = 0;
            int i11 = 0;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (i11 < iIntValue2) {
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    i11 = iIntValue2;
                }
            }
            if (iIntValue == 0) {
                return -1;
            }
            return (int) ((i11 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int sc(String str, Activity activity) {
        if (!WP.ExN()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), 0)).intValue();
        } catch (ClassNotFoundException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e11.getMessage());
            return 0;
        } catch (IllegalAccessException e12) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e12.getMessage());
            return 0;
        } catch (IllegalArgumentException e13) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e13.getMessage());
            return 0;
        } catch (NoSuchMethodException e14) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e14.getMessage());
            return 0;
        } catch (InvocationTargetException e15) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e15.getMessage());
            return 0;
        }
    }

    private static Bitmap sc(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", th2.getMessage());
            return bitmapCreateBitmap;
        }
    }

    public static Bitmap sc(com.bytedance.sdk.component.Ol.We we2) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = we2.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap bitmapPFF = pFF(we2);
        if (bitmapPFF == null) {
            bitmapPFF = sc(webView);
        }
        webView.setLayerType(layerType, null);
        if (bitmapPFF == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.We.sc(bitmapPFF, bitmapPFF.getWidth() / 6, bitmapPFF.getHeight() / 6);
    }

    public static void sc(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            activity.getWindow().addFlags(1792);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("UIUtils", e11.getMessage());
        }
    }

    public static void sc(Context context) {
        sc(context, false);
    }

    public static void sc(Context context, boolean z11) {
        Context contextSc = context == null ? com.bytedance.sdk.openadsdk.core.Xc.sc() : context;
        if (contextSc == null) {
            return;
        }
        TRI = (WindowManager) contextSc.getSystemService("window");
        if (zY() || z11) {
            DisplayMetrics displayMetrics = contextSc.getResources().getDisplayMetrics();
            f28773sc = displayMetrics.density;
            pFF = displayMetrics.densityDpi;
            zY = displayMetrics.scaledDensity;
            We = displayMetrics.widthPixels;
            ExN = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i11 = We;
            int i12 = ExN;
            if (i11 > i12) {
                We = i12;
                ExN = i11;
                return;
            }
            return;
        }
        int i13 = We;
        int i14 = ExN;
        if (i13 < i14) {
            We = i14;
            ExN = i13;
        }
    }

    public static void sc(View view, float f11) {
        if (view == null) {
            return;
        }
        view.setAlpha(f11);
    }

    public static void sc(View view, int i11) {
        if (view == null || view.getVisibility() == i11 || !sc(i11)) {
            return;
        }
        view.setVisibility(i11);
    }

    public static void sc(View view, int i11, int i12, int i13, int i14) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        sc(view, (ViewGroup.MarginLayoutParams) layoutParams, i11, i12, i13, i14);
    }

    public static void sc(View view, View.OnClickListener onClickListener, String str) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        com.bytedance.sdk.component.utils.Tf.sc("OnclickListener ", str + " is null , can not set OnClickListener !!!");
    }

    public static void sc(View view, View.OnTouchListener onTouchListener, String str) {
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
            return;
        }
        com.bytedance.sdk.component.utils.Tf.sc("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
    }

    private static void sc(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, int i13, int i14) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i11 && marginLayoutParams.topMargin == i12 && marginLayoutParams.rightMargin == i13 && marginLayoutParams.bottomMargin == i14) {
            return;
        }
        if (i11 != -3) {
            marginLayoutParams.leftMargin = i11;
        }
        if (i12 != -3) {
            marginLayoutParams.topMargin = i12;
        }
        if (i13 != -3) {
            marginLayoutParams.rightMargin = i13;
        }
        if (i14 != -3) {
            marginLayoutParams.bottomMargin = i14;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static void sc(TextView textView, com.bytedance.sdk.openadsdk.core.widget.dE dEVar, double d11, int i11) {
        if (d11 == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            dEVar.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d11)));
            }
            sc(dEVar, d11, i11);
        }
    }

    public static void sc(TextView textView, com.bytedance.sdk.openadsdk.core.widget.dE dEVar, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        sc(textView, dEVar, sfl, 14);
    }

    public static void sc(TextView textView, com.bytedance.sdk.openadsdk.core.widget.dE dEVar, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        sc(textView, dEVar, (sfl == null || sfl.NP() == null) ? -1.0d : sfl.NP().We(), i11);
    }

    public static void sc(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void sc(final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final String str, final String str2, final Bitmap bitmap, final String str3, final long j11) {
        Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.kX.3
            @Override // java.lang.Runnable
            public void run() {
                kX.zY(sfl, str, str2, bitmap, str3, j11);
            }
        }, 10);
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.widget.dE dEVar, double d11, int i11) {
        if (d11 < 0.0d) {
            dEVar.setVisibility(8);
        } else {
            dEVar.setVisibility(0);
            dEVar.sc(d11, i11);
        }
    }

    public static void sc(boolean z11) {
        WH = Boolean.valueOf(z11);
    }

    public static boolean sc(float f11, float f12, Context context) {
        if (f11 != -1.0f && f12 != -1.0f) {
            if (f28772qr == null) {
                f28772qr = ViewConfiguration.get(context);
            }
            if (Qj == -1) {
                Qj = f28772qr.getScaledTouchSlop();
            }
            if (f11 - f12 > Qj) {
                return true;
            }
        }
        return false;
    }

    private static boolean sc(int i11) {
        return i11 == 0 || i11 == 8 || i11 == 4;
    }

    @Nullable
    public static int[] sc(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int zY(Context context) {
        sc(context);
        return We;
    }

    public static int zY(Context context, float f11) {
        return Float.valueOf(sc(context, f11, true)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY(final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, String str2, final Bitmap bitmap, final String str3, final long j11) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.utils.kX.4
                        @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                        public JSONObject sc() {
                            try {
                                int iSc = kX.sc(bitmap);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str3);
                                long j12 = j11;
                                if (j12 != -1) {
                                    jSONObject.put("page_id", j12);
                                }
                                jSONObject.put("render_type", "h5");
                                jSONObject.put("render_type_2", 0);
                                jSONObject.put("is_blank", iSc == 100 ? 1 : 0);
                                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(sfl) ? 1 : 0);
                                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sfl) ? 1 : 0);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                    return jSONObject2;
                                } catch (JSONException unused) {
                                    return jSONObject2;
                                }
                            } catch (JSONException unused2) {
                                return null;
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>".concat(String.valueOf(th2)));
            }
        }
    }

    private static boolean zY() {
        return f28773sc < 0.0f || pFF < 0 || zY < 0.0f || We < 0 || ExN < 0;
    }

    public static boolean zY(Activity activity) {
        if (WH == null) {
            synchronized (UFX) {
                try {
                    if (WH == null) {
                        String strSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("cutout_devices", "");
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(strSc) && !TextUtils.isEmpty(str)) {
                            try {
                                JSONArray jSONArray = new JSONArray(strSc);
                                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                    if (str.equals(jSONArray.getString(i11))) {
                                        WH = Boolean.TRUE;
                                        return true;
                                    }
                                }
                            } catch (Exception e11) {
                                Dl.pFF("UIUtils", e11.getMessage());
                            }
                        }
                        WH = Boolean.valueOf(We(activity) || sc("ro.miui.notch", activity) == 1 || UFX(activity) || BT(activity) || Tf(activity) || Ql(activity) || SR(activity));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return WH.booleanValue();
    }

    @Nullable
    public static int[] zY(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }
}
