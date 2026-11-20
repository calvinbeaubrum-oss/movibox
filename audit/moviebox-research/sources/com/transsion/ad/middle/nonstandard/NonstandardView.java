package com.transsion.ad.middle.nonstandard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.strategy.MeasureManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import uq.b;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NonstandardView extends FrameLayout implements MeasureManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdPlans f50494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdMaterialList f50495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f50496d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50497f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonstandardView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonstandardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonstandardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    public static final void b(NonstandardView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.c();
    }

    private final void c() {
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        AdMaterialList adMaterialList = this.f50495c;
        String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
        AdMaterialList adMaterialList2 = this.f50495c;
        aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, this.f50494b);
        com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
        String simpleName = NonstandardView.class.getSimpleName();
        String str = this.f50493a;
        b.a aVar3 = b.f78633a;
        aVar2.I(simpleName + " --> 广告点击了 --> sceneId = " + str + " --> isAdShowFinal = " + aVar3.a(this.f50494b), false);
        vq.b bVar = vq.b.f79053a;
        String str2 = this.f50493a;
        AdPlans adPlans = this.f50494b;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList3 = this.f50495c;
        bVar.a((128 & 1) != 0 ? "" : null, str2, id2, 104, adMaterialList3 != null ? adMaterialList3.getId() : null, 7, (128 & 64) != 0 ? false : aVar3.a(this.f50494b), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50494b), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }

    private final void d() {
        f();
    }

    private final void e() {
        if (this.f50496d == 0) {
            this.f50496d = System.currentTimeMillis();
        }
        if (this.f50497f) {
            return;
        }
        this.f50497f = true;
        vq.b bVar = vq.b.f79053a;
        String str = this.f50493a;
        AdPlans adPlans = this.f50494b;
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialList = this.f50495c;
        String id3 = adMaterialList != null ? adMaterialList.getId() : null;
        b.a aVar = b.f78633a;
        bVar.f((128 & 1) != 0 ? "" : null, str, id2, 104, id3, 7, (128 & 64) != 0 ? false : aVar.a(this.f50494b), (128 & 128) != 0 ? s.h() : null, AdPlanUtil.f50541a.c(this.f50494b), (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        com.transsion.ad.a.f50276a.I(NonstandardView.class.getSimpleName() + " --> 广告展示 --> sceneId = " + this.f50493a + " --> isAdShowFinal = " + aVar.a(this.f50494b), false);
        NonAdShowedTimesManager.f50524a.c(this.f50494b);
    }

    private final void f() {
        if (this.f50496d > 0) {
            vq.b bVar = vq.b.f79053a;
            String str = this.f50493a;
            AdPlans adPlans = this.f50494b;
            String id2 = adPlans != null ? adPlans.getId() : null;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50496d;
            AdMaterialList adMaterialList = this.f50495c;
            bVar.c((1 & 1) != 0 ? "" : null, str, id2, jCurrentTimeMillis, adMaterialList != null ? adMaterialList.getId() : null, 7, (1 & 64) != 0 ? false : b.f78633a.a(this.f50494b));
            this.f50496d = 0L;
        }
    }

    public final void bindNonstandardView(String str, AdPlans adPlans) {
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        List<AdMaterialList> adMaterialList;
        this.f50493a = str;
        String path = null;
        this.f50495c = (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null) ? null : adMaterialList.get(0);
        this.f50494b = adPlans;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        AdMaterialList adMaterialList2 = this.f50495c;
        if (TextUtils.isEmpty((adMaterialList2 == null || (image3 = adMaterialList2.getImage()) == null) ? null : image3.getPath())) {
            RequestManager requestManagerWith = Glide.with(getContext());
            AdMaterialList adMaterialList3 = this.f50495c;
            if (adMaterialList3 != null && (image2 = adMaterialList3.getImage()) != null) {
                path = image2.getUrl();
            }
            requestManagerWith.load2(path).into(imageView);
        } else {
            RequestManager requestManagerWith2 = Glide.with(getContext());
            AdMaterialList adMaterialList4 = this.f50495c;
            if (adMaterialList4 != null && (image = adMaterialList4.getImage()) != null) {
                path = image.getPath();
            }
            requestManagerWith2.load2(path).into(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.nonstandard.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonstandardView.b(this.f50503a, view);
            }
        });
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        MeasureManager.f50573a.g(this);
    }

    public final void destroy() {
        com.transsion.ad.a.f50276a.I(NonstandardView.class.getSimpleName() + " --> destroy() --> sceneId = " + this.f50493a + " --> isAdShowFinal = " + b.f78633a.a(this.f50494b), false);
        removeAllViews();
        MeasureManager.f50573a.p(this);
        f();
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return 10.0d;
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return this;
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        if (z11) {
            e();
        } else {
            d();
        }
    }
}
