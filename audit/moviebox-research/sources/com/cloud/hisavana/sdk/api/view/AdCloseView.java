package com.cloud.hisavana.sdk.api.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$color;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.sdk.commonutil.util.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class AdCloseView extends ImageView {

    /* JADX INFO: compiled from: source.java */
    public enum CloseImageType {
        CLOSE,
        EXPAND
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f29136b;

        static {
            int[] iArr = new int[CloseImageType.values().length];
            f29136b = iArr;
            try {
                iArr[CloseImageType.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29136b[CloseImageType.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Constants.AdDisplayRule.values().length];
            f29135a = iArr2;
            try {
                iArr2[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29135a[Constants.AdDisplayRule.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AdCloseView(Context context) {
        super(context);
        b();
    }

    public AdCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdCloseView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final Drawable a(CloseImageType closeImageType) {
        Context context;
        int i11;
        int i12 = a.f29136b[closeImageType.ordinal()];
        if (i12 == 1) {
            context = getContext();
            i11 = R$drawable.ad_close;
        } else {
            if (i12 != 2) {
                return null;
            }
            context = getContext();
            i11 = R$drawable.ad_expand;
        }
        return z2.a.getDrawable(context, i11);
    }

    public final void b() {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iA = j.a(2.5f);
        setPadding(iA, iA, iA, iA);
        setBackgroundColor(z2.a.getColor(getContext(), R$color.ad_badge_bg));
        setDisplayStyle(Constants.AdDisplayRule.UNIVERSAL, CloseImageType.CLOSE);
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, CloseImageType closeImageType) {
        Drawable drawableA;
        int i11 = a.f29135a[adDisplayRule.ordinal()];
        if (i11 == 1) {
            drawableA = a(closeImageType);
        } else if (i11 != 2) {
            return;
        } else {
            drawableA = a(CloseImageType.EXPAND);
        }
        setImageDrawable(drawableA);
    }
}
