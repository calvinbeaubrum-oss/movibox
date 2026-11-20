package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: compiled from: source.java */
    public static class sc implements View.OnLayoutChangeListener {
        private int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Drawable f28788sc;
        private int zY;

        public sc(Drawable drawable) {
            this.f28788sc = drawable;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            int i19 = i13 - i11;
            int i21 = i14 - i12;
            if (i19 == this.pFF && i21 == this.zY) {
                return;
            }
            this.pFF = i19;
            this.zY = i21;
            this.f28788sc.setBounds(0, 0, i19, i21);
        }
    }

    @Nullable
    private static Drawable sc(Resources resources, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        try {
            String strCoa = sfl.coa();
            if (TextUtils.isEmpty(strCoa)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(strCoa, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void sc(Activity activity, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (activity == null || sfl == null || TextUtils.isEmpty(sfl.coa())) {
            return;
        }
        try {
            View decorView = activity.getWindow().getDecorView();
            int i11 = SR.uPZ;
            if (decorView.getTag(i11) != null) {
                return;
            }
            activity.getWindow().getDecorView().setTag(i11, Integer.valueOf(i11));
            Drawable drawableSc = sc(activity.getResources(), sfl);
            if (drawableSc == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setForeground(drawableSc);
            } else {
                activity.getWindow().getDecorView().getOverlay().add(drawableSc);
                activity.getWindow().getDecorView().addOnLayoutChangeListener(new sc(drawableSc));
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("add overlay fail", th2.getMessage());
        }
    }

    public static void sc(ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (viewGroup == null || sfl == null || TextUtils.isEmpty(sfl.coa())) {
            return;
        }
        try {
            int i11 = SR.uPZ;
            if (viewGroup.getTag(i11) != null) {
                return;
            }
            viewGroup.setTag(i11, Integer.valueOf(i11));
            Drawable drawableSc = sc(viewGroup.getResources(), sfl);
            if (drawableSc == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                viewGroup.setForeground(drawableSc);
            } else {
                viewGroup.getOverlay().add(drawableSc);
                viewGroup.addOnLayoutChangeListener(new sc(drawableSc));
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("add overlay fail", th2.getMessage());
        }
    }
}
