package com.transsion.usercenter.me.adapter;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.edit.ProfileEditCenterActivity;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class UserMineItemProvider extends BaseItemProvider<MeItemInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UserInfo f59444f;

    private final boolean v() {
        UserInfo userInfo = this.f59444f;
        return userInfo == null || (userInfo != null && userInfo.getUserType() == 0);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_header_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        UserInfo userInfo = data instanceof UserInfo ? (UserInfo) data : null;
        this.f59444f = userInfo;
        com.transsion.usercenter.me.b.f59452a.d(userInfo != null ? userInfo.getUserId() : null);
        if (v()) {
            x(helper, this.f59444f);
        } else {
            w(helper, this.f59444f);
        }
    }

    public final void w(BaseViewHolder baseViewHolder, final UserInfo userInfo) {
        int i11;
        baseViewHolder.getView(R$id.loginTv).setVisibility(8);
        baseViewHolder.getView(R$id.avatarIV).setVisibility(0);
        View view = baseViewHolder.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.UserMineItemProvider$showUser$1
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
                com.transsion.usercenter.me.b.f59452a.b("editinfo");
                ProfileEditCenterActivity.f59299b.a(this.this$0.g(), userInfo);
            }
        }, 1, null);
        if (userInfo == null) {
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.nameTv);
        textView.setText(userInfo.getNickname());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$mipmap.ic_arrow_right, 0);
        boolean z11 = true;
        ((TextView) baseViewHolder.getView(R$id.idTv)).setText(Utils.a().getResources().getString(R$string.user_id_show, userInfo.getUsername()));
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.genderTv);
        if (userInfo.getGender() == 0) {
            i11 = 0;
        } else {
            i11 = userInfo.getGender() == 1 ? com.transsion.usercenter.R$mipmap.profile_man : com.transsion.usercenter.R$mipmap.profile_female;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(i11, 0, 0, 0);
        if (userInfo.getAge() <= 0) {
            textView2.setText("");
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            com.transsion.moviedetailapi.helper.a.f53896a.b(spannableStringBuilder);
            spannableStringBuilder.append((CharSequence) String.valueOf(userInfo.getAge()));
            textView2.setText(spannableStringBuilder);
        }
        if (userInfo.getGender() == 0 && userInfo.getAge() <= 0) {
            z11 = false;
        }
        textView2.setVisibility(z11 ? 0 : 8);
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.avatarIV);
        ImageHelper.f51371a.h(imageView, imageView, userInfo.getAvatar(), (112 & 8) != 0 ? R$color.cl37 : R$mipmap.profile_default_avatar, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
    }

    public final void x(BaseViewHolder baseViewHolder, UserInfo userInfo) {
        baseViewHolder.getView(R$id.genderTv).setVisibility(8);
        baseViewHolder.getView(R$id.avatarIV).setVisibility(8);
        TextView textView = (TextView) baseViewHolder.getView(R$id.loginTv);
        textView.setVisibility(0);
        textView.setText(R$string.user_login);
        so.c.c(textView, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.UserMineItemProvider$showVisitor$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                com.transsion.usercenter.me.b.f59452a.b(AppLovinEventTypes.USER_LOGGED_IN);
                ((ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class)).w0(this.this$0.g());
            }
        }, 1, null);
        baseViewHolder.itemView.setOnClickListener(null);
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.nameTv);
        textView2.setText(R$string.user_login_title);
        textView2.setCompoundDrawables(null, null, null, null);
        TextView textView3 = (TextView) baseViewHolder.getView(R$id.idTv);
        Resources resources = Utils.a().getResources();
        int i11 = R$string.user_id_show;
        Object[] objArr = new Object[1];
        objArr[0] = userInfo != null ? userInfo.getUsername() : null;
        textView3.setText(resources.getString(i11, objArr));
    }
}
