package com.transsion.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.i;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.f;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$string;
import h20.c;
import h20.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lt.g;
import net.lucode.hackware.magicindicator.MagicIndicator;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b extends h20.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f52003b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f52005g;

        public a(int i11) {
            this.f52005g = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            MagicIndicator magicIndicator;
            ViewPager2 viewPager2;
            g gVar = b.this.f52003b;
            if (gVar != null && (viewPager2 = gVar.f70440l) != null) {
                viewPager2.setCurrentItem(this.f52005g, true);
            }
            g gVar2 = b.this.f52003b;
            if (gVar2 == null || (magicIndicator = gVar2.f70437i) == null) {
                return;
            }
            magicIndicator.onPageScrolled(this.f52005g, 0.0f, 0);
        }
    }

    public b(g gVar) {
        this.f52003b = gVar;
    }

    @Override // h20.a
    public int a() {
        return 2;
    }

    @Override // h20.a
    public c b(Context context) {
        Intrinsics.g(context, "context");
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(2);
        gradientLinePagerIndicator.setLineHeight(i.e(3.0f));
        gradientLinePagerIndicator.setLineWidth(i.e(24.0f));
        gradientLinePagerIndicator.setRoundRadius(i.e(1.5f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = z2.a.getColor(context, R$color.transparent);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    @Override // h20.a
    public d c(Context context, int i11) {
        String string;
        Intrinsics.g(context, "context");
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, f0.a(10.0f));
        if (i11 != 0) {
            string = i11 != 1 ? TmcEngineFactory.ENGINE_TYPE_DEFAULT : context.getResources().getString(R$string.music_tab_liked_music);
        } else {
            string = context.getResources().getString(R$string.music_tab_discover);
        }
        customPagerTitleView.setText(string);
        customPagerTitleView.setTextSize(18.0f);
        customPagerTitleView.setOnClickListener(new a(i11));
        return customPagerTitleView;
    }
}
