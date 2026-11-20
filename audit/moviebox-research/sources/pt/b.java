package pt;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.n;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.m;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.fragment.provider.HomeNovelIconBean;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74055b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f74056c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f74057a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(ImageView ivNovelIcon) {
        Intrinsics.g(ivNovelIcon, "ivNovelIcon");
        this.f74057a = ivNovelIcon;
        b();
    }

    public static final void c(b this$0, HomeNovelIconBean homeNovelIconBean, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.e();
        i.e(homeNovelIconBean.getDeeplink(), null, 1, null);
    }

    public final void b() {
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_novel_icon_config", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0) {
            c.g(this.f74057a);
            return;
        }
        try {
            final HomeNovelIconBean homeNovelIconBean = (HomeNovelIconBean) n.d(value, HomeNovelIconBean.class);
            String deeplink = homeNovelIconBean.getDeeplink();
            if (deeplink != null && deeplink.length() != 0) {
                String icUrl = homeNovelIconBean.getIcUrl();
                if (icUrl != null) {
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    Context context = this.f74057a.getContext();
                    Intrinsics.f(context, "ivNovelIcon.context");
                    companion.o(context, this.f74057a, icUrl, (32704 & 8) != 0 ? R$color.skeleton : R$color.transparent, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
                }
                c.k(this.f74057a);
                d();
                this.f74057a.setOnClickListener(new View.OnClickListener() { // from class: pt.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.c(this.f74053a, homeNovelIconBean, view);
                    }
                });
                return;
            }
            c.g(this.f74057a);
        } catch (Throwable unused) {
            c.g(this.f74057a);
        }
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", RewardPlus.ICON);
        linkedHashMap.put("item_type", "novel");
        m.f51277a.t(HomeTabType.TAB_CODE_TRENDING, "browse", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", RewardPlus.ICON);
        linkedHashMap.put("item_type", "novel");
        m.f51277a.m(HomeTabType.TAB_CODE_TRENDING, "click", linkedHashMap);
    }
}
