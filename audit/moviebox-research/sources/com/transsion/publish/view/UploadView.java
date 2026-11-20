package com.transsion.publish.view;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import androidx.lifecycle.w;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baseui.R$drawable;
import com.transsion.publish.PublishManager;
import com.transsion.publish.R$color;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.bean.PublishResult;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
public final class UploadView extends BaseFloatView implements u {
    public static final int failed = 3;
    public static final int posting = 1;
    public static final int success = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PublishResult f56669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f56670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f56671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f56672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f56673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f56674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f56675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RelativeLayout f56676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public w f56677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f56678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f56679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f56680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f56681r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f56682s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f56683t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f56684u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f56685v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f56686w;
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f56668x = "UploadView";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return UploadView.f56668x;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            UploadView.this.f56680q = 0L;
            UploadView.this.clearAnimation();
            UploadView.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.tn.lib.util.networkinfo.g {
        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            uo.b.a.f(uo.b.f78622a, PublishManager.TAG, "uploadview retry", false, 4, null);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56670g = 5000L;
        this.f56678o = "";
        w wVar = new w(this);
        this.f56677n = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.f56683t = new Runnable() { // from class: com.transsion.publish.view.n
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.x(this.f56768a);
            }
        };
        this.f56684u = new Runnable() { // from class: com.transsion.publish.view.o
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.u(this.f56769a);
            }
        };
        this.f56685v = new Runnable() { // from class: com.transsion.publish.view.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.k(this.f56799a);
            }
        };
        this.f56686w = new c();
        q(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f56670g = 5000L;
        this.f56678o = "";
        w wVar = new w(this);
        this.f56677n = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.f56683t = new Runnable() { // from class: com.transsion.publish.view.n
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.x(this.f56768a);
            }
        };
        this.f56684u = new Runnable() { // from class: com.transsion.publish.view.o
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.u(this.f56769a);
            }
        };
        this.f56685v = new Runnable() { // from class: com.transsion.publish.view.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.k(this.f56799a);
            }
        };
        this.f56686w = new c();
        q(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56670g = 5000L;
        this.f56678o = "";
        w wVar = new w(this);
        this.f56677n = wVar;
        wVar.n(Lifecycle.State.CREATED);
        this.f56683t = new Runnable() { // from class: com.transsion.publish.view.n
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.x(this.f56768a);
            }
        };
        this.f56684u = new Runnable() { // from class: com.transsion.publish.view.o
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.u(this.f56769a);
            }
        };
        this.f56685v = new Runnable() { // from class: com.transsion.publish.view.p
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.k(this.f56799a);
            }
        };
        this.f56686w = new c();
        q(context);
    }

    public static final void B(UploadView this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isShow()) {
            this$0.f56680q = 0L;
            this$0.clearAnimation();
            this$0.dismiss();
        }
    }

    public static final void k(UploadView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View view) {
    }

    public static final void s(UploadView this$0, Context context, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.f51452a;
        TextView textView = this$0.f56675l;
        if (cVar.a(textView != null ? textView.getId() : 0, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        TextView textView2 = this$0.f56675l;
        CharSequence text = textView2 != null ? textView2.getText() : null;
        if (TextUtils.equals(text, context.getString(R$string.postint_state_cancel))) {
            PublishManager.Companion.a().cancel();
            this$0.p();
            uo.b.a.f(uo.b.f78622a, f56668x, "click cancel", false, 4, null);
        } else if (TextUtils.equals(text, context.getString(R$string.postint_state_retry))) {
            this$0.w();
            this$0.p();
            uo.b.a.f(uo.b.f78622a, f56668x, "click retry", false, 4, null);
        } else if (TextUtils.equals(text, context.getString(com.tn.lib.widget.R$string.View))) {
            uo.b.a.f(uo.b.f78622a, f56668x, "click view now", false, 4, null);
            this$0.f56680q = 0L;
            this$0.clearAnimation();
            this$0.dismiss();
            if (TextUtils.isEmpty(this$0.f56678o)) {
                return;
            }
            com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, this$0.f56671h).withString("id", this$0.f56678o).navigation();
        }
    }

    public static final void u(UploadView this$0) {
        Intrinsics.g(this$0, "this$0");
        com.tn.lib.util.networkinfo.f.f49475a.m(this$0.f56686w);
    }

    private final void v() {
        Function1<PublishResult, Unit> function1 = new Function1<PublishResult, Unit>() { // from class: com.transsion.publish.view.UploadView$observer$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishResult publishResult) {
                invoke2(publishResult);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishResult it) {
                Intrinsics.g(it, "it");
                this.this$0.showFloatView(it);
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishResult.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public static final void x(UploadView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.o(true);
    }

    public final void A() {
        if (this.f56680q != 0 && System.currentTimeMillis() - this.f56680q <= 3000) {
            clearAnimation();
            dismiss();
            return;
        }
        m();
        this.f56681r = false;
        this.f56682s = false;
        TextView textView = this.f56672i;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f56673j;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.f56673j;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        if (this.f56679p == 1) {
            TextView textView4 = this.f56675l;
            if (textView4 != null) {
                textView4.setText("");
            }
        } else {
            TextView textView5 = this.f56675l;
            if (textView5 != null) {
                textView5.setText(com.tn.lib.widget.R$string.View);
                Unit unit = Unit.f68710a;
            }
        }
        TextView textView6 = this.f56675l;
        if (textView6 != null) {
            textView6.setTextColor(com.blankj.utilcode.util.h.a(R$color.color_191F2B));
        }
        TextView textView7 = this.f56675l;
        if (textView7 != null) {
            textView7.setBackgroundResource(R$drawable.bg_btn_01_radius_4);
        }
        o(false);
        getH().removeCallbacks(this.f56683t);
        getH().removeCallbacks(this.f56685v);
        getH().postDelayed(this.f56685v, this.f56670g);
        getH().postDelayed(new Runnable() { // from class: com.transsion.publish.view.q
            @Override // java.lang.Runnable
            public final void run() {
                UploadView.B(this.f56800a);
            }
        }, this.f56670g + ((long) 1000));
        this.f56680q = System.currentTimeMillis();
    }

    public final void C(Integer num) {
        l();
        uo.b.a.f(uo.b.f78622a, f56668x, "uploading:" + num, false, 4, null);
        TextView textView = this.f56672i;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f56673j;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.f56673j;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        TextView textView4 = this.f56675l;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_cancel);
        }
        String str = num + "%";
        TextView textView5 = this.f56672i;
        if (textView5 == null) {
            return;
        }
        textView5.setText(str);
    }

    @Override // androidx.lifecycle.u
    public Lifecycle getLifecycle() {
        w wVar = this.f56677n;
        Intrinsics.d(wVar);
        return wVar;
    }

    public final void l() {
        if (this.f56682s) {
            return;
        }
        getH().removeCallbacks(this.f56683t);
        getH().postDelayed(this.f56683t, 3000L);
        this.f56682s = true;
    }

    public final void m() {
    }

    public final void n() {
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        if (fVar.e()) {
            return;
        }
        fVar.l(this.f56686w);
        getH().removeCallbacks(this.f56684u);
        getH().postDelayed(this.f56684u, 3600000L);
    }

    public final void o(boolean z11) {
        if (z11) {
            RelativeLayout relativeLayout = this.f56676m;
            if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
                t();
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, t() ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(500L);
                RelativeLayout relativeLayout2 = this.f56676m;
                if (relativeLayout2 != null) {
                    relativeLayout2.startAnimation(translateAnimation);
                }
                RelativeLayout relativeLayout3 = this.f56676m;
                if (relativeLayout3 == null) {
                    return;
                }
                relativeLayout3.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout4 = this.f56676m;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            float f11 = t() ? 1.0f : -1.0f;
            t();
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, f11, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(500L);
            RelativeLayout relativeLayout5 = this.f56676m;
            if (relativeLayout5 != null) {
                relativeLayout5.startAnimation(translateAnimation2);
            }
            RelativeLayout relativeLayout6 = this.f56676m;
            if (relativeLayout6 == null) {
                return;
            }
            relativeLayout6.setVisibility(0);
        }
    }

    public final void p() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -(iArr[1] + getHeight()));
        translateAnimation.setDuration(700L);
        translateAnimation.setAnimationListener(new b());
        startAnimation(translateAnimation);
    }

    public final void q(final Context context) {
        LayoutInflater.from(context).inflate(R$layout.upload_float_view, this);
        this.f56673j = (TextView) findViewById(R$id.ufv_tv_status);
        this.f56672i = (TextView) findViewById(R$id.ufv_tv_progress);
        this.f56674k = (ImageView) findViewById(R$id.ufv_iv_retry);
        this.f56675l = (TextView) findViewById(R$id.right_state);
        this.f56676m = (RelativeLayout) findViewById(R$id.ufv_view2);
        setLayoutParams(new ConstraintLayout.b(-1, -2));
        int iC = com.blankj.utilcode.util.d.c();
        if (iC == 0) {
            ConstraintLayout.b layoutParams = getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = f0.a(68.0f);
            }
        } else {
            ConstraintLayout.b layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = iC + f0.a(48.0f);
            }
        }
        ConstraintLayout.b layoutParams3 = getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.setMarginStart(f0.a(16.0f));
        }
        ConstraintLayout.b layoutParams4 = getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.setMarginEnd(f0.a(16.0f));
        }
        ImageView imageView = this.f56674k;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadView.r(view);
                }
            });
        }
        TextView textView = this.f56675l;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadView.s(this.f56801a, context, view);
                }
            });
        }
        TextView textView2 = this.f56672i;
        if (textView2 != null) {
            textView2.setText("");
        }
        v();
    }

    public final void setPageName(String str) {
        this.f56671h = str;
    }

    public final void showFloatView(PublishResult publishResult) {
        this.f56669f = publishResult;
        Integer numValueOf = publishResult != null ? Integer.valueOf(publishResult.getState()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            y();
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            this.f56678o = publishResult.getPostId();
            this.f56679p = publishResult.getSource();
            A();
        } else if (numValueOf != null && numValueOf.intValue() == 0) {
            this.f56678o = "";
            z();
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            C(Integer.valueOf(publishResult.getProgress()));
        } else if (numValueOf != null && numValueOf.intValue() == 4) {
            this.f56678o = "";
            dismiss();
        }
    }

    public final boolean t() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final void w() {
        PublishManager.Companion.a().retry();
    }

    public final void y() {
        n();
        this.f56681r = false;
        this.f56682s = false;
        TextView textView = this.f56672i;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f56673j;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        o(false);
        TextView textView3 = this.f56673j;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_fail);
        }
        TextView textView4 = this.f56675l;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_retry);
        }
        TextView textView5 = this.f56675l;
        if (textView5 != null) {
            textView5.setTextColor(com.blankj.utilcode.util.h.a(com.tn.lib.widget.R$color.cl01));
        }
        getH().removeCallbacks(this.f56683t);
        getH().removeCallbacks(this.f56685v);
        getH().postDelayed(this.f56685v, this.f56670g * ((long) 2));
    }

    public final void z() {
        l();
        TextView textView = this.f56672i;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f56673j;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.f56673j;
        if (textView3 != null) {
            textView3.setText(R$string.postint_state_posted);
        }
        TextView textView4 = this.f56675l;
        if (textView4 != null) {
            textView4.setText(R$string.postint_state_cancel);
        }
        TextView textView5 = this.f56672i;
        if (textView5 == null) {
            return;
        }
        textView5.setText("0%");
    }
}
