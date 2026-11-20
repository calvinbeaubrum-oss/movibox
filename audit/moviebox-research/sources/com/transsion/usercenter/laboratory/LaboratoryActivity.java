package com.transsion.usercenter.laboratory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.ad.test.TestAdActivity;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.push.PushTestActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
public final class LaboratoryActivity extends BaseActivity<xy.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f59360a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void f0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void g0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabLaneDialog().j0(this$0, "lane");
    }

    public static final void h0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabWebTestDialog().j0(this$0, "webTest");
    }

    public static final void i0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) PushTestActivity.class));
    }

    public static final void j0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabLocationDialog().j0(this$0, RequestParameters.SUBRESOURCE_LOCATION);
    }

    public static final void k0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) LabMiniAppSDKTestActivity.class));
    }

    public static final void l0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabFpsDialog().j0(this$0, "fps");
    }

    public static final void m0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TestAdActivity.f50611b.a(this$0);
    }

    public static final void n0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabPhoneBrandDialog().j0(this$0, "brand");
    }

    public static final void o0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabInfoDialog().j0(this$0, "info");
    }

    public static final void p0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) MccActivity.class));
    }

    public static final void q0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabChannelDialog().j0(this$0, "channel");
    }

    public static final void r0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabStreamingDialog().j0(this$0, "stream");
    }

    public static final void s0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        new LabHttpHostDialog().j0(this$0, "host");
    }

    public static final void t0(LaboratoryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.tn.lib.widget.toast.core.h.f50034a.l("Cold start coming");
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this$0), null, null, new LaboratoryActivity$onCreate$9$1(this$0, null), 3, null);
    }

    public static final void u0(View view) {
        com.tn.lib.widget.toast.core.h.f50034a.l("js调试ON 当次进程有效");
        WebView.setWebContentsDebuggingEnabled(true);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public xy.e getViewBinding() {
        xy.e eVarC = xy.e.c(getLayoutInflater());
        Intrinsics.f(eVarC, "inflate(layoutInflater)");
        return eVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((xy.e) getMViewBinding()).f80773b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.f0(this.f59381a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80781k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.g0(this.f59408a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80785o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.n0(this.f59410a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80774c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.o0(this.f59412a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80779i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.p0(this.f59383a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80775d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.q0(this.f59385a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80786p.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.r0(this.f59387a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80778h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.s0(this.f59388a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80780j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.t0(this.f59390a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80776f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.u0(view);
            }
        });
        ((xy.e) getMViewBinding()).f80788r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.h0(this.f59394a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80784n.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.i0(this.f59396a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80782l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.j0(this.f59399a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80783m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.k0(this.f59401a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80777g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.l0(this.f59404a, view);
            }
        });
        ((xy.e) getMViewBinding()).f80787q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.m0(this.f59406a, view);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object v0(Context context, Continuation<? super Unit> continuation) throws Throwable {
        LaboratoryActivity$restartApp$1 laboratoryActivity$restartApp$1;
        if (continuation instanceof LaboratoryActivity$restartApp$1) {
            laboratoryActivity$restartApp$1 = (LaboratoryActivity$restartApp$1) continuation;
            int i11 = laboratoryActivity$restartApp$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                laboratoryActivity$restartApp$1.label = i11 - Integer.MIN_VALUE;
            } else {
                laboratoryActivity$restartApp$1 = new LaboratoryActivity$restartApp$1(this, continuation);
            }
        } else {
            laboratoryActivity$restartApp$1 = new LaboratoryActivity$restartApp$1(this, continuation);
        }
        Object obj = laboratoryActivity$restartApp$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = laboratoryActivity$restartApp$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            laboratoryActivity$restartApp$1.L$0 = context;
            laboratoryActivity$restartApp$1.label = 1;
            if (kotlinx.coroutines.r0.a(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, laboratoryActivity$restartApp$1) == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            context = (Context) laboratoryActivity$restartApp$1.L$0;
            ResultKt.b(obj);
        }
        RoomActivityLifecycleCallbacks.f51239a.d();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        Intrinsics.d(launchIntentForPackage);
        launchIntentForPackage.addFlags(ASTNode.DEOP);
        context.startActivity(launchIntentForPackage);
        Process.killProcess(Process.myPid());
        System.exit(0);
        return Unit.f68710a;
    }
}
