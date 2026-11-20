package com.cloud.hisavana.sdk.api.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class AdDisclaimerView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f29137a;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29138a;

        static {
            int[] iArr = new int[Constants.AdDisplayRule.values().length];
            f29138a = iArr;
            try {
                iArr[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29138a[Constants.AdDisplayRule.RU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(String str, String str2, String str3);
    }

    public AdDisclaimerView(Context context) {
        super(context);
        b();
    }

    public AdDisclaimerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdDisclaimerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final void b() {
        setBackground(z2.a.getDrawable(getContext(), R$drawable.ad_disclaimer_gradient_drawable));
        setAlpha(0.4f);
        setTextColor(Color.parseColor("#DDDDDD"));
        setTextSize(11.0f);
        setLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setPadding(j.a(4.0f), 0, 0, 0);
        setOnClickListener(new View.OnClickListener() { // from class: u9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f78497a.c(view);
            }
        });
    }

    public final /* synthetic */ void c(View view) {
        b bVar = this.f29137a;
        if (bVar != null) {
            bVar.a(getContext().getString(R$string.disclaimer), getText().toString(), getContext().getString(R$string.f29083ok));
        }
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, String str) {
        int i11 = a.f29138a[adDisplayRule.ordinal()];
        if (i11 == 1) {
            setVisibility(8);
            setText("");
        } else {
            if (i11 != 2) {
                return;
            }
            setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            setText(str);
        }
    }

    public void setDisplayStyle(Constants.AdDisplayRule adDisplayRule, String str, String str2, int i11) {
        setDisplayStyle(adDisplayRule, str);
        updateHeightWith(str2, i11);
    }

    public void setListener(b bVar) {
        this.f29137a = bVar;
    }

    public void updateHeightWith(String str, int i11) {
        int i12;
        if (getVisibility() == 8) {
            return;
        }
        try {
            i12 = Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            z.a().e(e11.getLocalizedMessage());
            i12 = 0;
        }
        if (i12 == 0) {
            setVisibility(8);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.ad_disclaimer_height);
        int iMax = Math.max((int) (i11 * (Math.min(i12, 15) / 100.0f)), dimensionPixelOffset);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = iMax;
        setLayoutParams(layoutParams);
        setTextSize(iMax * (11.0f / dimensionPixelOffset));
    }
}
