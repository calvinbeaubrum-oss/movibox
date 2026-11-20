package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$mipmap;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.profile.bean.MeItemInfo;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class VipMineItemProvider extends BaseItemProvider<MeItemInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f59445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f59446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f59447h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f59448a;

        static {
            int[] iArr = new int[MembershipDetailType.values().length];
            try {
                iArr[MembershipDetailType.TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MembershipDetailType.SUBSCRIPTION_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MembershipDetailType.FINANCIAL_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MembershipDetailType.EXPIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f59448a = iArr;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_vip_layout;
    }

    public final void u(MemberInfo memberInfo) {
        Integer daysLeft;
        uo.b.a.g(uo.b.f78622a, "member detail is " + memberInfo, false, 2, null);
        int point = memberInfo != null ? memberInfo.getPoint() : 0;
        int iIntValue = (memberInfo == null || (daysLeft = memberInfo.getDaysLeft()) == null) ? 0 : daysLeft.intValue();
        int i11 = a.f59448a[(memberInfo != null ? MembershipDetailType.Companion.a(memberInfo) : MembershipDetailType.GUEST).ordinal()];
        if (i11 == 1) {
            TextView textView = this.f59445f;
            if (textView != null) {
                textView.setText(g().getString(R$string.user_premium_free_trial));
            }
            TextView textView2 = this.f59446g;
            if (textView2 != null) {
                textView2.setText(g().getString(R$string.user_days_left, Integer.valueOf(iIntValue)));
            }
            w(point);
            return;
        }
        if (i11 == 2 || i11 == 3) {
            TextView textView3 = this.f59445f;
            if (textView3 != null) {
                textView3.setText(g().getString(R$string.user_premium));
            }
            TextView textView4 = this.f59446g;
            if (textView4 != null) {
                Context contextG = g();
                int i12 = R$string.user_date_left;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(iIntValue);
                objArr[1] = memberInfo != null ? memberInfo.getExpiryDate() : null;
                textView4.setText(contextG.getString(i12, objArr));
            }
            w(point);
            return;
        }
        if (i11 == 4) {
            TextView textView5 = this.f59445f;
            if (textView5 != null) {
                textView5.setText(g().getString(R$string.user_premium_get));
            }
            TextView textView6 = this.f59446g;
            if (textView6 != null) {
                textView6.setText(g().getString(R$string.user_premium_redeem_tips));
            }
            w(point);
            return;
        }
        TextView textView7 = this.f59445f;
        if (textView7 != null) {
            textView7.setText(g().getString(R$string.user_premium_get));
        }
        if (point > 0) {
            TextView textView8 = this.f59446g;
            if (textView8 != null) {
                textView8.setText(g().getString(R$string.user_premium_redeem_tips));
            }
            w(point);
            return;
        }
        TextView textView9 = this.f59446g;
        if (textView9 != null) {
            textView9.setText(g().getString(R$string.user_premium_purchase_tips));
        }
        w(-1);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        MemberInfo memberInfo = data instanceof MemberInfo ? (MemberInfo) data : null;
        if (memberInfo == null) {
            return;
        }
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.VipMineItemProvider$convert$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                com.transsion.usercenter.me.b.f59452a.b("member");
                com.alibaba.android.arouter.launcher.a.d().b("/member/MemberActivity").navigation();
            }
        }, 1, null);
        ((ImageView) helper.getView(R$id.icIV)).setImageResource(R$mipmap.ic_vip_20);
        this.f59445f = (TextView) helper.getView(R$id.titleTv);
        this.f59446g = (TextView) helper.getView(R$id.desTv);
        this.f59447h = (TextView) helper.getView(R$id.btnTv);
        u(memberInfo);
    }

    public final void w(int i11) {
        TextView textView = this.f59447h;
        if (textView != null) {
            if (i11 > 0) {
                textView.setText(i11 > 999 ? "999+" : String.valueOf(i11));
                textView.setCompoundDrawablesWithIntrinsicBounds(R$mipmap.ic_poins_new, 0, 0, 0);
            }
            textView.setVisibility(i11 > 0 ? 0 : 8);
        }
    }
}
