package com.transsion.publish.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.publish.PublishManager;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.bean.PublishResult;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class PublishStateView extends BaseFloatView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PublishResult f56651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f56652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CircleProgressBar f56653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f56654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f56655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelativeLayout f56656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f56658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f56659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f56660o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f56661p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f56662q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f56663r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f56664s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f56665t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f56666u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f56667v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56652g = PublishManager.TAG;
        this.f56657l = 2;
        this.f56658m = "";
        this.f56659n = "";
        this.f56660o = "";
        this.f56661p = "";
        this.f56662q = "";
        this.f56663r = "";
        this.f56664s = "";
        this.f56665t = true;
        this.f56667v = LazyKt__LazyJVMKt.b(PublishStateView$publishedApi$2.INSTANCE);
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f56652g = PublishManager.TAG;
        this.f56657l = 2;
        this.f56658m = "";
        this.f56659n = "";
        this.f56660o = "";
        this.f56661p = "";
        this.f56662q = "";
        this.f56663r = "";
        this.f56664s = "";
        this.f56665t = true;
        this.f56667v = LazyKt__LazyJVMKt.b(PublishStateView$publishedApi$2.INSTANCE);
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishStateView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56652g = PublishManager.TAG;
        this.f56657l = 2;
        this.f56658m = "";
        this.f56659n = "";
        this.f56660o = "";
        this.f56661p = "";
        this.f56662q = "";
        this.f56663r = "";
        this.f56664s = "";
        this.f56665t = true;
        this.f56667v = LazyKt__LazyJVMKt.b(PublishStateView$publishedApi$2.INSTANCE);
        g(context);
    }

    private final void g(final Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_publish_state, this);
        this.f56653h = (CircleProgressBar) findViewById(R$id.circles_bar);
        this.f56654i = (ImageView) findViewById(R$id.iv_btn);
        TextView textView = (TextView) findViewById(R$id.tvContent);
        this.f56655j = textView;
        if (textView != null) {
            textView.setVisibility(this.f56665t ? 0 : 8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_layout);
        this.f56656k = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishStateView.h(this.f56766a, context, view);
                }
            });
        }
        i();
        CircleProgressBar circleProgressBar = this.f56653h;
        if (circleProgressBar != null) {
            circleProgressBar.setProgress(0);
        }
    }

    private final IPublishApi getPublishedApi() {
        return (IPublishApi) this.f56667v.getValue();
    }

    public static final void h(PublishStateView this$0, Context context, View view) {
        IPublishApi publishedApi;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        if (com.transsion.baseui.util.c.f51452a.a(R$id.rl_layout, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        IPublishApi publishedApi2 = this$0.getPublishedApi();
        if (publishedApi2 != null && publishedApi2.a0() && com.tn.lib.util.networkinfo.f.f49475a.e() && (publishedApi = this$0.getPublishedApi()) != null && !publishedApi.n0()) {
            this$0.k(context);
            return;
        }
        IPublishApi publishedApi3 = this$0.getPublishedApi();
        if (publishedApi3 != null) {
            publishedApi3.Q();
        }
        int i11 = this$0.f56657l;
        if (i11 == 2) {
            IPublishApi publishedApi4 = this$0.getPublishedApi();
            if (publishedApi4 != null) {
                publishedApi4.K(context);
            }
            uo.b.a.f(uo.b.f78622a, this$0.f56652g, "click type_post_publish", false, 4, null);
            return;
        }
        if (i11 == 1) {
            IPublishApi publishedApi5 = this$0.getPublishedApi();
            if (publishedApi5 != null) {
                publishedApi5.D0(context, this$0.f56658m, this$0.f56659n, this$0.f56660o, this$0.f56661p, this$0.f56657l);
            }
            uo.b.a.f(uo.b.f78622a, this$0.f56652g, "click type_star_publish", false, 4, null);
            return;
        }
        if (i11 == 3) {
            IPublishApi publishedApi6 = this$0.getPublishedApi();
            if (publishedApi6 != null) {
                publishedApi6.k0(context, this$0.f56658m, this$0.f56659n, this$0.f56660o, this$0.f56661p, this$0.f56657l);
            }
            com.transsion.baselib.helper.a.f51183a.g("subjectdetail", "post", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
            uo.b.a.f(uo.b.f78622a, this$0.f56652g, "click type_post_detail", false, 4, null);
            return;
        }
        if (i11 == 4) {
            IPublishApi publishedApi7 = this$0.getPublishedApi();
            if (publishedApi7 != null) {
                publishedApi7.x(context, this$0.f56663r, this$0.f56662q, this$0.f56664s);
            }
            com.transsion.baselib.helper.a.f51183a.g("roomdetail", "post", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
            uo.b.a.f(uo.b.f78622a, this$0.f56652g, "click type_room_detail", false, 4, null);
        }
    }

    private final void i() {
        Object context = getContext();
        if (context instanceof ComponentActivity) {
            Function1<PublishResult, Unit> function1 = new Function1<PublishResult, Unit>() { // from class: com.transsion.publish.view.PublishStateView$observer$1
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
            flowEventBus.observeEvent((u) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        }
    }

    public static final void j(PublishStateView this$0) {
        Intrinsics.g(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.f(context, "context");
        this$0.k(context);
    }

    private final void k(Context context) {
        UploadView uploadView = new UploadView(context);
        if (!uploadView.isShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity activityB = com.blankj.utilcode.util.a.b();
            if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
                activityB = com.blankj.utilcode.util.a.b();
            }
            if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
                return;
            } else {
                uploadView.show(activityB);
            }
        }
        uploadView.showFloatView(this.f56651f);
    }

    public final void publishSource(int i11, String subjectId, String cover, String title, String description, String groupId, String groupName, String groupImage, boolean z11) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(cover, "cover");
        Intrinsics.g(title, "title");
        Intrinsics.g(description, "description");
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(groupName, "groupName");
        Intrinsics.g(groupImage, "groupImage");
        this.f56657l = i11;
        this.f56658m = subjectId;
        this.f56659n = cover;
        this.f56660o = title;
        this.f56661p = description;
        this.f56663r = groupId;
        this.f56662q = groupName;
        this.f56664s = groupImage;
        this.f56665t = z11;
        TextView textView = this.f56655j;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z11 ? 0 : 8);
    }

    public final void setImageResource(int i11) {
        this.f56666u = Integer.valueOf(i11);
        ImageView imageView = this.f56654i;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }

    public final void setProgressColor(int i11) {
        CircleProgressBar circleProgressBar = this.f56653h;
        if (circleProgressBar != null) {
            circleProgressBar.setRingColor(i11);
        }
    }

    public final void showFloatView(PublishResult publishResult) {
        CircleProgressBar circleProgressBar;
        this.f56651f = publishResult;
        Integer numValueOf = publishResult != null ? Integer.valueOf(publishResult.getState()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            CircleProgressBar circleProgressBar2 = this.f56653h;
            if (circleProgressBar2 != null) {
                circleProgressBar2.setVisibility(8);
            }
            ImageView imageView = this.f56654i;
            if (imageView != null) {
                Integer num = this.f56666u;
                imageView.setImageResource(num != null ? num.intValue() : R$drawable.ic_floating_state_comm);
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            CircleProgressBar circleProgressBar3 = this.f56653h;
            if (circleProgressBar3 != null) {
                circleProgressBar3.setVisibility(8);
            }
            CircleProgressBar circleProgressBar4 = this.f56653h;
            if (circleProgressBar4 != null) {
                circleProgressBar4.setProgress(0);
            }
            ImageView imageView2 = this.f56654i;
            if (imageView2 != null) {
                Integer num2 = this.f56666u;
                imageView2.setImageResource(num2 != null ? num2.intValue() : R$drawable.ic_floating_state_comm);
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            CircleProgressBar circleProgressBar5 = this.f56653h;
            if (circleProgressBar5 == null || circleProgressBar5.getVisibility() != 0) {
                CircleProgressBar circleProgressBar6 = this.f56653h;
                if (circleProgressBar6 != null) {
                    circleProgressBar6.setVisibility(0);
                }
                CircleProgressBar circleProgressBar7 = this.f56653h;
                if (circleProgressBar7 != null) {
                    circleProgressBar7.setProgress(0);
                }
            }
            ImageView imageView3 = this.f56654i;
            if (imageView3 != null) {
                Integer num3 = this.f56666u;
                imageView3.setImageResource(num3 != null ? num3.intValue() : R$drawable.ic_floating_state_ing);
            }
            ImageView imageView4 = this.f56654i;
            if (imageView4 != null) {
                imageView4.postDelayed(new Runnable() { // from class: com.transsion.publish.view.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishStateView.j(this.f56765a);
                    }
                }, 1500L);
                return;
            }
            return;
        }
        if (numValueOf == null || numValueOf.intValue() != 3) {
            if (numValueOf != null && numValueOf.intValue() == 4) {
                CircleProgressBar circleProgressBar8 = this.f56653h;
                if (circleProgressBar8 != null) {
                    circleProgressBar8.setVisibility(8);
                }
                ImageView imageView5 = this.f56654i;
                if (imageView5 != null) {
                    Integer num4 = this.f56666u;
                    imageView5.setImageResource(num4 != null ? num4.intValue() : R$drawable.ic_floating_state_comm);
                    return;
                }
                return;
            }
            return;
        }
        CircleProgressBar circleProgressBar9 = this.f56653h;
        if ((circleProgressBar9 == null || circleProgressBar9.getVisibility() != 0) && (circleProgressBar = this.f56653h) != null) {
            circleProgressBar.setVisibility(0);
        }
        CircleProgressBar circleProgressBar10 = this.f56653h;
        if (circleProgressBar10 != null) {
            circleProgressBar10.setProgress(publishResult.getProgress());
        }
        ImageView imageView6 = this.f56654i;
        if (imageView6 != null) {
            Integer num5 = this.f56666u;
            imageView6.setImageResource(num5 != null ? num5.intValue() : R$drawable.ic_floating_state_ing);
        }
    }
}
