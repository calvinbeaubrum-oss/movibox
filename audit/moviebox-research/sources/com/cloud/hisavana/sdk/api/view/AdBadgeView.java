package com.cloud.hisavana.sdk.api.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$color;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.sdk.commonutil.util.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class AdBadgeView extends TextView {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29133a;

        static {
            int[] iArr = new int[Constants.AdDisplayRule.values().length];
            f29133a = iArr;
            try {
                iArr[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29133a[Constants.AdDisplayRule.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AdBadgeView(Context context) {
        super(context);
        b();
    }

    public AdBadgeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdBadgeView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final String a(int i11) {
        String string = getResources().getText(R$string.ad_icon).toString();
        if (i11 <= 0) {
            return string;
        }
        return string + " " + i11 + "+";
    }

    public final void b() {
        setGravity(17);
        setMaxWidth(j.a(80.0f));
        setTextSize(9.0f);
        setTypeface(Typeface.create("sans-serif-regular", 0));
        setLines(1);
        int iA = j.a(2.2f);
        setPadding(iA, 0, iA, 0);
        setTextColor(z2.a.getColor(getContext(), R$color.ad_badge_text));
        setBackgroundColor(z2.a.getColor(getContext(), R$color.ad_badge_bg));
        setDisplayStyle(Constants.AdDisplayRule.UNIVERSAL, 0);
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, int i11) {
        int i12 = a.f29133a[adDisplayRule.ordinal()];
        if (i12 == 1) {
            setText(R$string.ad_icon);
        } else {
            if (i12 != 2) {
                return;
            }
            setText(a(i11));
        }
    }
}
