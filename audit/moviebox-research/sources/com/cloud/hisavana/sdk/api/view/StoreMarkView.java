package com.cloud.hisavana.sdk.api.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$mipmap;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class StoreMarkView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f29146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f29147b;

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            StoreMarkView.this.setVisibility(8);
            z.a().e("PsMarkView", "attachStoreIcon download store icon error," + taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            z.a().d("PsMarkView", "attachInfo onRequestSuccess");
            if (adImage != null) {
                StoreMarkView.this.f29147b.setImageDrawable(adImage.getDrawable());
            }
        }
    }

    public StoreMarkView(Context context) {
        this(context, null);
    }

    public StoreMarkView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreMarkView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (isInEditMode()) {
            return;
        }
        b();
    }

    public void attachInfo(AdsDTO adsDTO) {
        if (adsDTO == null || this.f29147b == null) {
            z.a().e("PsMarkView", "attachInfo,ads or view is null");
            return;
        }
        if (adsDTO.getExt() == null || (adsDTO.getSource() != 4 && TextUtils.isEmpty(adsDTO.getExt().getStoreImageurl()))) {
            z.a().e("PsMarkView", "attachInfo,ext or imageUrl is null");
            setVisibility(8);
            return;
        }
        setText(adsDTO.getExt().getStoreTitle());
        if (adsDTO.getSource() == 4) {
            this.f29147b.setImageResource(R$mipmap.ps_icon);
        } else {
            DownLoadRequest.p(adsDTO.getExt().getStoreImageurl(), adsDTO, 6, new a(), this.f29147b);
        }
    }

    public final void b() {
        setOrientation(0);
        this.f29147b = new ImageView(getContext());
        this.f29146a = new TextView(getContext());
        addView(this.f29147b, new LinearLayout.LayoutParams(j.a(10.0f), j.a(10.0f)));
        this.f29146a.setTextSize(8.0f);
        this.f29146a.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(6);
        addView(this.f29146a, layoutParams);
        setGravity(16);
        setVisibility(8);
    }

    public ImageView getLogo() {
        return this.f29147b;
    }

    public void setDrawable(Drawable drawable) {
        ImageView imageView = this.f29147b;
        if (imageView == null || drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public void setText(String str) {
        if (this.f29146a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f29146a.setText(str);
    }

    public void setTextColor(int i11) {
        TextView textView = this.f29146a;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i11);
    }

    public void setTextSize(float f11) {
        TextView textView = this.f29146a;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }
}
