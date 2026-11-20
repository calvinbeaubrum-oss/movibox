package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.UserMessageActivity;
import com.transsion.usercenter.profile.NoticeMessageViewModel;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

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
public final class MessageItemProvider extends BaseItemProvider<MeItemInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NoticeMessageViewModel f59442f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59443a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59443a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59443a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59443a.invoke(obj);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 6;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_icon_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void r(BaseViewHolder viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
        super.r(viewHolder, i11);
        TextView textView = (TextView) viewHolder.getView(R$id.desTv);
        textView.setTextSize(11.0f);
        textView.setPadding(gs.a.a(4), gs.a.a(1), gs.a.a(4), gs.a.a(1));
        textView.setTextColor(g().getResources().getColor(R$color.white));
        textView.setBackgroundResource(R$drawable.bg_red_r7);
        viewHolder.getView(R$id.bgView).setBackgroundResource(R$drawable.bg_radius_bottom_6_color_white_6p);
        ((ImageView) viewHolder.getView(R$id.icIV)).setImageResource(com.transsion.usercenter.R$drawable.ic_mine_message);
        Context contextG = g();
        BaseActivity baseActivity = contextG instanceof BaseActivity ? (BaseActivity) contextG : null;
        if (baseActivity != null) {
            this.f59442f = (NoticeMessageViewModel) new v0(baseActivity).a(NoticeMessageViewModel.class);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        c0<Integer> c0VarG;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Context contextG = g();
        BaseActivity baseActivity = contextG instanceof BaseActivity ? (BaseActivity) contextG : null;
        if (baseActivity != null) {
            final TextView textView = (TextView) helper.getView(R$id.desTv);
            NoticeMessageViewModel noticeMessageViewModel = this.f59442f;
            if (noticeMessageViewModel != null && (c0VarG = noticeMessageViewModel.g()) != null) {
                c0VarG.j(baseActivity, new a(new Function1<Integer, Unit>() { // from class: com.transsion.usercenter.me.adapter.MessageItemProvider$convert$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer newMessageCount) {
                        TextView textView2 = textView;
                        Intrinsics.f(newMessageCount, "newMessageCount");
                        textView2.setVisibility(newMessageCount.intValue() > 0 ? 0 : 8);
                        textView.setText(String.valueOf(newMessageCount));
                    }
                }));
            }
        }
        ((TextView) helper.getView(R$id.titleTv)).setText(g().getString(R$string.messages_title_name));
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.MessageItemProvider$convert$2
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
                com.transsion.usercenter.me.b.f59452a.b("notice");
                this.this$0.g().startActivity(new Intent(this.this$0.g(), (Class<?>) UserMessageActivity.class));
                NoticeMessageViewModel noticeMessageViewModel2 = this.this$0.f59442f;
                if (noticeMessageViewModel2 != null) {
                    noticeMessageViewModel2.d();
                }
            }
        }, 1, null);
    }
}
