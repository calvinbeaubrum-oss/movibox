package com.cloud.hisavana.sdk.api.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.ad.template.TemplateRenderEnum;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.j;
import com.cloud.sdk.commonutil.util.l;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import w9.v;
import w9.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TNativeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaView f29149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f29150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdChoicesView f29151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdCloseView f29152d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView.ScaleType f29153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StoreMarkView f29154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdBadgeView f29156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AdDisclaimerView f29157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f29158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y9.d f29159l;

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f29160b;

        public a(TaNativeInfo taNativeInfo) {
            this.f29160b = taNativeInfo;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("ssp", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            TemplateRenderEnum templateRenderEnumFindStrategyByCode;
            if (!this.f29160b.isMaterialStyleValid() || (templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f29160b.getMaterialStyle())) == null) {
                return;
            }
            templateRenderEnumFindStrategyByCode.renderRadius(TNativeView.this.f29149a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f29162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f29163c;

        public b(TaNativeInfo taNativeInfo, ImageView imageView) {
            this.f29162b = taNativeInfo;
            this.f29163c = imageView;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("TNativeView", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.getDrawable() != null) {
                z.a().d("TNativeView", "download Image Success.");
                AdImage iconImage = this.f29162b.getIconImage();
                if (iconImage != null) {
                    iconImage.setDrawable(adImage.getDrawable());
                } else {
                    this.f29162b.setImage(adImage);
                }
            }
            if (this.f29162b.isMaterialStyleValid() && (this.f29163c instanceof TranCircleImageView)) {
                TemplateRenderEnum templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f29162b.getMaterialStyle());
                if (templateRenderEnumFindStrategyByCode != null) {
                    templateRenderEnumFindStrategyByCode.scaleWidthOrTextSize(this.f29163c);
                }
                ((TranCircleImageView) this.f29163c).setCircle(true);
                ((TranCircleImageView) this.f29163c).setRadius(j.a(TextUtils.equals(this.f29162b.getMaterialStyle(), "L91601") ? 16.0f : 4.0f));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29165a;

        public c(AdsDTO adsDTO) {
            this.f29165a = adsDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e1.g(com.cloud.sdk.commonutil.util.f.a(), this.f29165a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29167a;

        public d(AdsDTO adsDTO) {
            this.f29167a = adsDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e1.g(com.cloud.sdk.commonutil.util.f.a(), this.f29167a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f29169a;

        public e(TaNativeInfo taNativeInfo) {
            this.f29169a = taNativeInfo;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (TNativeView.this.f29149a.getHeight() != 0) {
                TNativeView.this.f29149a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                TNativeView.this.f29158k = null;
                TNativeView.this.f29157j.updateHeightWith(v.e(this.f29169a.getAdItem()), TNativeView.this.f29149a.getHeight());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f29171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView.ScaleType f29172c;

        public f(TaNativeInfo taNativeInfo, ImageView.ScaleType scaleType) {
            this.f29171b = taNativeInfo;
            this.f29172c = scaleType;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().d("ssp", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            TemplateRenderEnum templateRenderEnumFindStrategyByCode;
            if (adImage == null || adImage.getDrawable() == null) {
                return;
            }
            z.a().d("ssp", "download Image Success.");
            AdImage image = this.f29171b.getImage();
            if (image != null) {
                image.setDrawable(adImage.getDrawable());
            } else {
                this.f29171b.setImage(adImage);
            }
            TNativeView.this.f29149a.setMediaView(adImage, this.f29172c, this.f29171b.isMaterialStyleValid());
            if (!this.f29171b.isMaterialStyleValid() || (templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f29171b.getMaterialStyle())) == null) {
                return;
            }
            templateRenderEnumFindStrategyByCode.renderRadius(TNativeView.this.f29149a);
        }
    }

    public TNativeView(@NonNull Context context) {
        this(context, null);
    }

    public TNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29153f = null;
        this.f29155h = false;
    }

    private void setDefaultImgMedia(TaNativeInfo taNativeInfo) {
        AdImage image = taNativeInfo.getImage();
        if (image == null) {
            return;
        }
        this.f29149a.init(image.getMime());
        ImageView.ScaleType scaleType = this.f29153f;
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        ImageView imageView = (ImageView) this.f29149a.findViewById(R$id.native_mediaview_iv_id);
        if (imageView == null) {
            return;
        }
        boolean zIsMaterialStyleValid = taNativeInfo.isMaterialStyleValid();
        imageView.setAdjustViewBounds(true);
        if (zIsMaterialStyleValid) {
            imageView.setMaxWidth(ca.d.k());
            imageView.setMaxHeight(ca.d.j());
        } else {
            imageView.setScaleType(scaleType);
        }
        DownLoadRequest.o(image.getImgUrl(), taNativeInfo.getAdItem(), new a(taNativeInfo), imageView);
    }

    private void setDefaultLogo(TaNativeInfo taNativeInfo) {
        AdImage iconImage = taNativeInfo.getIconImage();
        if (iconImage == null) {
            return;
        }
        if (taNativeInfo.isMaterialStyleValid() && (this.f29150b instanceof TranCircleImageView)) {
            TemplateRenderEnum templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle());
            if (templateRenderEnumFindStrategyByCode != null) {
                templateRenderEnumFindStrategyByCode.scaleWidthOrTextSize(this.f29150b);
            }
            ((TranCircleImageView) this.f29150b).setCircle(true);
            ((TranCircleImageView) this.f29150b).setRadius(j.a(TextUtils.equals(taNativeInfo.getMaterialStyle(), "L91601") ? 16.0f : 4.0f));
        }
        DownLoadRequest.o(iconImage.getImgUrl(), taNativeInfo.getAdItem(), null, this.f29150b);
    }

    private void setImgMedia(TaNativeInfo taNativeInfo) {
        TemplateRenderEnum templateRenderEnumFindStrategyByCode;
        z.a().d("TNativeView", "start to set img media");
        if (taNativeInfo == null) {
            return;
        }
        AdImage image = taNativeInfo.getImage();
        ImageView.ScaleType scaleType = this.f29153f;
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            image.setNeedBlurBackground(true);
        }
        if (image != null) {
            this.f29149a.init(image.getMime());
            if (image.isAdImageRecycled()) {
                if (TextUtils.isEmpty(image.getImgUrl())) {
                    return;
                }
                DownLoadRequest.p(image.getImgUrl(), taNativeInfo.getAdItem(), 2, new f(taNativeInfo, scaleType), (ImageView) this.f29149a.findViewById(R$id.native_mediaview_iv_id));
            } else {
                if (taNativeInfo.isMaterialStyleValid() && (templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle())) != null) {
                    templateRenderEnumFindStrategyByCode.renderRadius(this.f29149a);
                }
                this.f29149a.setMediaView(image, scaleType, taNativeInfo.isMaterialStyleValid());
            }
        }
    }

    private void setVideoMedia(TaNativeInfo taNativeInfo) {
        z.a().d("TNativeView", "setVideoMedia() ----> start to set video media");
        if (taNativeInfo == null) {
            return;
        }
        String strA = w9.a.f79345a.a(taNativeInfo.getAdItem());
        if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getSource() == 4 && !taNativeInfo.getAdItem().isFromLocal()) {
            strA = DiskLruCacheUtil.e(strA, 4);
        }
        String str = strA;
        z.a().d("TNativeView", "setVideoMedia() ----> mainUrl = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29149a.init(3);
        this.f29149a.setVideoView(str, taNativeInfo.isMaterialStyleValid(), taNativeInfo.getMaterialStyle(), taNativeInfo.getAdItem(), this.f29155h);
    }

    public final void d(TaNativeInfo taNativeInfo) {
        AdBadgeView adBadgeView;
        if (taNativeInfo == null || (adBadgeView = this.f29156i) == null) {
            return;
        }
        adBadgeView.setDisplayStyle(taNativeInfo.getAdItem().getDisplayRule(), v.c(taNativeInfo.getAdItem()));
    }

    public void destroy() {
        MediaView mediaView = this.f29149a;
        if (mediaView != null) {
            if (this.f29158k != null) {
                mediaView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f29158k);
                this.f29158k = null;
            }
            this.f29149a.destroy();
        }
        l.a(this.f29150b);
        l.a(this.f29151c);
        y9.d dVar = this.f29159l;
        if (dVar != null) {
            dVar.f();
            this.f29159l = null;
        }
        removeAllViews();
    }

    public final /* synthetic */ void e(String str, String str2, String str3) {
        y9.d dVarI = new y9.d(this).j(str).h(str2).i(str3, null);
        this.f29159l = dVarI;
        dVarI.k();
    }

    public final void g(TaNativeInfo taNativeInfo) {
        AdsDTO adsDTOC;
        if (taNativeInfo == null || this.f29151c == null || (adsDTOC = e1.c(taNativeInfo)) == null) {
            return;
        }
        String adChoiceImageUrl = adsDTOC.getAdChoiceImageUrl();
        if (adsDTOC.getSource() == 4) {
            DownLoadRequest.o(adChoiceImageUrl, adsDTOC, null, this.f29151c);
            this.f29151c.setOnClickListener(new c(adsDTOC));
        } else {
            if (adsDTOC.getACReady() == null || !adsDTOC.getACReady().booleanValue()) {
                return;
            }
            DownLoadRequest.p(adChoiceImageUrl, adsDTOC, 3, null, this.f29151c);
            this.f29151c.setOnClickListener(new d(adsDTOC));
        }
    }

    public View getIconView() {
        return this.f29150b;
    }

    public MediaView getMediaView() {
        return this.f29149a;
    }

    public com.cloud.hisavana.sdk.ad.template.a getTemplateStyle() {
        return null;
    }

    public final void h(TaNativeInfo taNativeInfo) {
        AdsDTO adsDTOC;
        if (taNativeInfo == null || (adsDTOC = e1.c(taNativeInfo)) == null || this.f29152d == null) {
            return;
        }
        AdCloseView.CloseImageType closeImageType = AdCloseView.CloseImageType.CLOSE;
        TemplateRenderEnum templateEnum = taNativeInfo.getTemplateEnum();
        if (templateEnum != null) {
            closeImageType = templateEnum.getCloseImageType();
        }
        this.f29152d.setDisplayStyle(adsDTOC.getDisplayRule(), closeImageType);
        this.f29152d.setVisibility(0);
    }

    public final void i(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null || taNativeInfo.getAdItem() == null || this.f29157j == null || this.f29149a == null) {
            return;
        }
        if (taNativeInfo.getAdItem().getDisplayRule() != Constants.AdDisplayRule.RU) {
            if (this.f29157j.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f29157j.getParent()).removeView(this.f29157j);
                return;
            }
            return;
        }
        this.f29157j.setDisplayStyle(taNativeInfo.getAdItem().getDisplayRule(), v.f(taNativeInfo.getAdItem()));
        this.f29157j.setListener(new AdDisclaimerView.b() { // from class: u9.b
            @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
            public final void a(String str, String str2, String str3) {
                this.f78498a.e(str, str2, str3);
            }
        });
        if (this.f29158k != null) {
            this.f29149a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f29158k);
            this.f29158k = null;
        }
        this.f29158k = new e(taNativeInfo);
        this.f29149a.getViewTreeObserver().addOnGlobalLayoutListener(this.f29158k);
    }

    public void inflateAdChoiceView(TaNativeInfo taNativeInfo) {
        g(taNativeInfo);
    }

    public void inflateIconView(TaNativeInfo taNativeInfo) {
        j(taNativeInfo);
    }

    public void inflateMediaView(TaNativeInfo taNativeInfo) {
        k(taNativeInfo);
    }

    public final void j(TaNativeInfo taNativeInfo) {
        if (this.f29150b == null || taNativeInfo == null) {
            return;
        }
        if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getSource() == 4) {
            setDefaultLogo(taNativeInfo);
            return;
        }
        ImageView imageView = this.f29150b;
        AdImage iconImage = taNativeInfo.getIconImage();
        if (iconImage != null) {
            if (iconImage.isAdImageRecycled()) {
                if (TextUtils.isEmpty(iconImage.getImgUrl())) {
                    return;
                }
                DownLoadRequest.p(iconImage.getImgUrl(), taNativeInfo.getAdItem(), 1, new b(taNativeInfo, imageView), imageView);
                return;
            }
            imageView.setImageDrawable(iconImage.getDrawable());
            if (taNativeInfo.isMaterialStyleValid() && (imageView instanceof TranCircleImageView)) {
                TemplateRenderEnum templateRenderEnumFindStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle());
                if (templateRenderEnumFindStrategyByCode != null) {
                    templateRenderEnumFindStrategyByCode.scaleWidthOrTextSize(imageView);
                }
                TranCircleImageView tranCircleImageView = (TranCircleImageView) imageView;
                tranCircleImageView.setCircle(true);
                tranCircleImageView.setRadius(j.a(4.0f));
            }
        }
    }

    public final void k(TaNativeInfo taNativeInfo) {
        if (this.f29149a == null || taNativeInfo == null) {
            return;
        }
        int iB = w9.a.f79345a.b(taNativeInfo.getAdItem());
        if (iB == -1) {
            z.a().e("TNativeView", "setMediaView（）----> adType = -1");
            return;
        }
        if (iB != 1) {
            if (taNativeInfo.getAdItem() == null || taNativeInfo.getAdItem().getSource() != 4) {
                setImgMedia(taNativeInfo);
                return;
            } else if (taNativeInfo.getAdItem().getDefaultMaterialType() == 1) {
                setDefaultImgMedia(taNativeInfo);
                return;
            }
        }
        setVideoMedia(taNativeInfo);
    }

    public final void l(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null || this.f29154g == null) {
            return;
        }
        AdsDTO adItem = taNativeInfo.getAdItem();
        this.f29154g.setVisibility(x.a(adItem) ? 0 : 8);
        this.f29154g.setTextColor(TextUtils.equals(adItem.getMaterialStyle(), "L91601") ? -1 : -8882056);
        this.f29154g.setTextSize(6.0f);
        this.f29154g.attachInfo(adItem);
    }

    public void setAdBagdeView(AdBadgeView adBadgeView) {
        this.f29156i = adBadgeView;
    }

    public void setAdChoiceView(AdChoicesView adChoicesView) {
        if (adChoicesView == null) {
            return;
        }
        this.f29151c = adChoicesView;
    }

    public void setAdCloseView(AdCloseView adCloseView) {
        if (adCloseView == null) {
            return;
        }
        this.f29152d = adCloseView;
    }

    public void setAdDisclaimerView(AdDisclaimerView adDisclaimerView) {
        this.f29157j = adDisclaimerView;
    }

    public final void setIconView(ImageView imageView) {
        this.f29150b = imageView;
    }

    public void setMediaView(MediaView mediaView) {
        setMediaView(mediaView, null);
    }

    public void setMediaView(MediaView mediaView, ImageView.ScaleType scaleType) {
        this.f29149a = mediaView;
        this.f29153f = scaleType;
    }

    public void setPsMarkView(StoreMarkView storeMarkView) {
        if (storeMarkView == null) {
            return;
        }
        this.f29154g = storeMarkView;
    }

    public void setTemplateStyle(com.cloud.hisavana.sdk.ad.template.a aVar) {
    }

    public void setUseListMode(boolean z11) {
        this.f29155h = z11;
    }

    public final void setupViews(TaNativeInfo taNativeInfo) {
        k(taNativeInfo);
        j(taNativeInfo);
        g(taNativeInfo);
        h(taNativeInfo);
        l(taNativeInfo);
        d(taNativeInfo);
        i(taNativeInfo);
    }
}
