package com.cloud.tmc.miniapp.widget.popupview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.widget.popupview.MsgBubblePopUpWindowView;
import com.cloud.tmc.miniutils.util.y;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tc.a;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MsgBubblePopUpWindowView extends LinearLayout {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public boolean OooO0OO;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<AppCompatImageView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) MsgBubblePopUpWindowView.this.findViewById(R$id.iv_msg_jump);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) MsgBubblePopUpWindowView.this.findViewById(R$id.tv_msg_toast);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooO00o());
        this.OooO0OO = true;
        LayoutInflater.from(context).inflate(R$layout.mini_msg_notice_popwindow_layout, this);
        setTranslationY(getTranslationY() + e0.a());
        boolean zB = MiniAppConfigHelper.f30370a.b("miniMsgBubbleEnable", true);
        this.OooO0OO = zB;
        if (zB) {
            AppCompatImageView mIvMsgJump = getMIvMsgJump();
            if (mIvMsgJump != null) {
                i.e(mIvMsgJump);
            }
        } else {
            AppCompatImageView mIvMsgJump2 = getMIvMsgJump();
            if (mIvMsgJump2 != null) {
                i.d(mIvMsgJump2);
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: td.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgBubblePopUpWindowView.OooO00o(this.f76964a, view);
            }
        });
    }

    public /* synthetic */ MsgBubblePopUpWindowView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static final void OooO00o(MsgBubblePopUpWindowView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.OooO0OO) {
            Context context = this$0.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("page", "pages/notification/notification");
            bundle.putString("query", "entrance%3DBubble");
            Unit unit = Unit.f68710a;
            ByteAppManager.launchMiniAppForId(context, "1000886706715795456", "", bundle);
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) a.a(PerformanceAnalyseProxy.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("jump_confi", this$0.OooO0OO ? "0" : "1");
        Unit unit2 = Unit.f68710a;
        performanceAnalyseProxy.recordForCommon(null, "Bubble_click", bundle2);
    }

    private final AppCompatImageView getMIvMsgJump() {
        return (AppCompatImageView) this.OooO0O0.getValue();
    }

    private final TextView getMTvMsgToast() {
        return (TextView) this.OooO00o.getValue();
    }

    public final void OooO00o(String str) {
        if (str != null) {
            try {
                TextView mTvMsgToast = getMTvMsgToast();
                if (mTvMsgToast == null) {
                    return;
                }
                mTvMsgToast.setText(y.b(y.c(R$string.mini_toast_msg_bubble_tips), str));
            } catch (Throwable th2) {
                TmcLogger.h("MsgBubblePopUpWindowView", th2);
            }
        }
    }
}
