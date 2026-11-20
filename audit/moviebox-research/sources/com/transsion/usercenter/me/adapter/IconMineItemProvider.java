package com.transsion.usercenter.me.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.utils.i;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import com.transsion.usercenter.profile.bean.IconItemInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class IconMineItemProvider extends BaseItemProvider<MeItemInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59440f = LazyKt__LazyJVMKt.b(new Function0<IMovieDetailService>() { // from class: com.transsion.usercenter.me.adapter.IconMineItemProvider$mMovieDetailService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IMovieDetailService invoke() {
            return (IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f59441g = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.me.adapter.IconMineItemProvider$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi x() {
        Object value = this.f59441g.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMovieDetailService y() {
        return (IMovieDetailService) this.f59440f.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 5;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_icon_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        final IconItemInfo iconItemInfo = data instanceof IconItemInfo ? (IconItemInfo) data : null;
        if (iconItemInfo == null) {
            return;
        }
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.IconMineItemProvider$convert$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                if (iconItemInfo.getCheckLogin() && !this.x().N()) {
                    this.x().w0(this.g());
                    return;
                }
                String moduleName = iconItemInfo.getModuleName();
                if (moduleName != null) {
                    com.transsion.usercenter.me.b.f59452a.b(moduleName);
                }
                String deepLink = iconItemInfo.getDeepLink();
                if (!Intrinsics.b(deepLink, "post_list_type") && !Intrinsics.b(deepLink, "like_list_type")) {
                    String deepLink2 = iconItemInfo.getDeepLink();
                    if (deepLink2 != null) {
                        i.e(deepLink2, null, 1, null);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("source", !Intrinsics.b(iconItemInfo.getDeepLink(), "post_list_type") ? 1 : 0);
                UserInfo userInfoP = this.x().P();
                bundle.putString("userId", userInfoP != null ? userInfoP.getUserId() : null);
                this.y().l(this.g(), bundle, ProfileSubjectListViewModel.class, iconItemInfo.getTitle());
            }
        }, 1, null);
        ((TextView) helper.getView(R$id.titleTv)).setText(iconItemInfo.getTitle());
        ((TextView) helper.getView(R$id.desTv)).setText(iconItemInfo.getDes());
        helper.getView(R$id.divider).setVisibility(iconItemInfo.getDivider() ? 0 : 8);
        helper.getView(R$id.bgView).setBackgroundResource(iconItemInfo.getBgRes());
        ((ImageView) helper.getView(R$id.icIV)).setImageResource(iconItemInfo.getIconRes());
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = iconItemInfo.getTop();
        }
    }
}
