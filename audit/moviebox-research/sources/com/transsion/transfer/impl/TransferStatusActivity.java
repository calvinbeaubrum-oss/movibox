package com.transsion.transfer.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.activity.p;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.downloadapi.IDownloadApiProvider;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$mipmap;
import com.transsion.transfer.R$string;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.server.TransferServer;
import com.transsion.transfer.impl.view.TabTitleView;
import com.transsion.transfer.wifi.connect.WifiConnectionManager;
import com.transsion.transfer.wifi.create.WifiCreateManager;
import com.transsion.transfer.wifi.ui.TransferDisconnectTipsDialog;
import com.transsion.transfer.wifi.util.WifiUtils;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

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
@Route(path = "/transfer/status")
@Metadata
public final class TransferStatusActivity extends BaseActivity<ky.b> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f58946m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f58947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f58948o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TransferReceivedFragment f58949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TransferSentFragment f58950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public my.a f58951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58952d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58953f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f58958k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f58954g = LazyKt__LazyJVMKt.b(new Function0<my.a>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$transferSelectFragment$2
        @Override // kotlin.jvm.functions.Function0
        public final my.a invoke() {
            u uVarS = ((IDownloadApiProvider) com.alibaba.android.arouter.launcher.a.d().h(IDownloadApiProvider.class)).s();
            Intrinsics.e(uVarS, "null cannot be cast to non-null type com.transsion.transfer.impl.listener.ITransferSelectView");
            return (my.a) uVarS;
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f58955h = LazyKt__LazyJVMKt.b(new Function0<TransferStatusActivity$serverFileHandler$2.a>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$serverFileHandler$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TransferStatusActivity f58968a;

            public a(TransferStatusActivity transferStatusActivity) {
                this.f58968a = transferStatusActivity;
            }

            public static final void d(TransferStatusActivity this$0, String clientDeviceName) {
                Intrinsics.g(this$0, "this$0");
                Intrinsics.g(clientDeviceName, "$clientDeviceName");
                TransferStatusActivity.f58946m.a();
                this$0.n0(true, clientDeviceName);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.transfer.impl.c
            public void a(String clientIp, final String clientDeviceName) {
                Intrinsics.g(clientIp, "clientIp");
                Intrinsics.g(clientDeviceName, "clientDeviceName");
                ConstraintLayout root = ((ky.b) this.f58968a.getMViewBinding()).getRoot();
                final TransferStatusActivity transferStatusActivity = this.f58968a;
                root.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE 
                      (r3v5 'root' androidx.constraintlayout.widget.ConstraintLayout)
                      (wrap java.lang.Runnable:0x001a: CONSTRUCTOR 
                      (r0v1 'transferStatusActivity' com.transsion.transfer.impl.TransferStatusActivity A[DONT_INLINE])
                      (r4v0 'clientDeviceName' java.lang.String A[DONT_INLINE])
                     A[MD:(com.transsion.transfer.impl.TransferStatusActivity, java.lang.String):void (m), WRAPPED] call: com.transsion.transfer.impl.m.<init>(com.transsion.transfer.impl.TransferStatusActivity, java.lang.String):void type: CONSTRUCTOR)
                     VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] in method: com.transsion.transfer.impl.TransferStatusActivity$serverFileHandler$2.a.a(java.lang.String, java.lang.String):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.transsion.transfer.impl.m, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "clientIp"
                    kotlin.jvm.internal.Intrinsics.g(r3, r0)
                    java.lang.String r3 = "clientDeviceName"
                    kotlin.jvm.internal.Intrinsics.g(r4, r3)
                    com.transsion.transfer.impl.TransferStatusActivity r3 = r2.f58968a
                    n6.a r3 = r3.getMViewBinding()
                    ky.b r3 = (ky.b) r3
                    androidx.constraintlayout.widget.ConstraintLayout r3 = r3.getRoot()
                    com.transsion.transfer.impl.TransferStatusActivity r0 = r2.f58968a
                    com.transsion.transfer.impl.m r1 = new com.transsion.transfer.impl.m
                    r1.<init>(r0, r4)
                    r3.post(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.impl.TransferStatusActivity$serverFileHandler$2.a.a(java.lang.String, java.lang.String):void");
            }

            @Override // com.transsion.transfer.impl.c
            public String b() {
                String MODEL = Build.MODEL;
                Intrinsics.f(MODEL, "MODEL");
                return MODEL;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a(this.this$0);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f58956i = LazyKt__LazyJVMKt.b(new Function0<com.transsion.transfer.impl.g>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$serverViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final g invoke() {
            g gVar = (g) new v0(this.this$0).a(g.class);
            gVar.B(this.this$0.p0());
            gVar.z(1);
            return gVar;
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f58957j = LazyKt__LazyJVMKt.b(new Function0<ClientViewModel>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$clientViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClientViewModel invoke() {
            return (ClientViewModel) new v0(this.this$0).a(ClientViewModel.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer[] f58959l = {Integer.valueOf(R$string.transfer_tab_received), Integer.valueOf(R$string.transfer_tab_sent)};

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return TransferStatusActivity.f58947n;
        }

        public final void b(Context context) {
            Intrinsics.g(context, "context");
            TransferStatusActivity.f58948o = false;
            context.startActivity(new Intent(context, (Class<?>) TransferStatusActivity.class));
        }

        public final void c(Context context) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) TransferStatusActivity.class);
            TransferStatusActivity.f58948o = true;
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            ((ky.b) TransferStatusActivity.this.getMViewBinding()).f69658g.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            ((ky.b) TransferStatusActivity.this.getMViewBinding()).f69658g.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ((ky.b) TransferStatusActivity.this.getMViewBinding()).f69658g.onPageSelected(i11);
            TransferStatusActivity.this.f58958k = i11;
            if (i11 == 0) {
                TransferReceivedFragment transferReceivedFragment = TransferStatusActivity.this.f58949a;
                if (transferReceivedFragment != null) {
                    transferReceivedFragment.q0();
                    return;
                }
                return;
            }
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.f58950b;
            if (transferSentFragment != null) {
                transferSentFragment.n0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends h20.a {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ TransferStatusActivity f58962f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f58963g;

            public a(TransferStatusActivity transferStatusActivity, int i11) {
                this.f58962f = transferStatusActivity;
                this.f58963g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ((ky.b) this.f58962f.getMViewBinding()).f69665n.setCurrentItem(this.f58963g, true);
            }
        }

        public c() {
        }

        @Override // h20.a
        public int a() {
            return TransferStatusActivity.this.f58959l.length;
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(2.0f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator.setColors(z2.a.getColor(context, R$color.main_gradient_start), z2.a.getColor(context, R$color.main_gradient_center), z2.a.getColor(context, R$color.main_gradient_end));
            return gradientLinePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            Intrinsics.g(context, "context");
            TabTitleView tabTitleView = new TabTitleView(context);
            TransferStatusActivity transferStatusActivity = TransferStatusActivity.this;
            tabTitleView.setTextById(transferStatusActivity.f58959l[i11].intValue());
            tabTitleView.setOnClickListener(new a(transferStatusActivity, i11));
            return tabTitleView;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d extends FragmentStateAdapter {
        public d() {
            super(TransferStatusActivity.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            if (i11 == 0) {
                TransferReceivedFragment transferReceivedFragmentA = TransferReceivedFragment.f58936d.a();
                TransferStatusActivity.this.f58949a = transferReceivedFragmentA;
                return transferReceivedFragmentA;
            }
            if (i11 != 1) {
                TransferSentFragment transferSentFragmentA = TransferSentFragment.f58941d.a();
                TransferStatusActivity.this.f58950b = transferSentFragmentA;
                return transferSentFragmentA;
            }
            TransferSentFragment transferSentFragmentA2 = TransferSentFragment.f58941d.a();
            TransferStatusActivity.this.f58950b = transferSentFragmentA2;
            return transferSentFragmentA2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TransferStatusActivity.this.f58959l.length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends p {
        public e() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (TransferStatusActivity.this.f58952d) {
                TransferStatusActivity.this.t0();
            } else if (TransferStatusActivity.this.q0().j() || TransferStatusActivity.this.o0().s()) {
                TransferStatusActivity.this.z0();
            } else {
                TransferStatusActivity.this.y0();
                TransferStatusActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58966a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58966a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58966a;
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
            this.f58966a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements my.b {
        public g() {
        }

        @Override // my.b
        public void a() {
            TransferStatusActivity.this.z0();
        }

        @Override // my.b
        public void b() {
            TransferStatusActivity.this.t0();
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.f58950b;
            if (transferSentFragment != null) {
                transferSentFragment.n0();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // my.b
        public void c() {
            TransferStatusActivity.this.t0();
            TransferStatusActivity.this.q0().z(1);
            ((ky.b) TransferStatusActivity.this.getMViewBinding()).f69665n.setCurrentItem(1, true);
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.f58950b;
            if (transferSentFragment != null) {
                transferSentFragment.n0();
            }
        }
    }

    static {
        String name = TransferStatusActivity.class.getName();
        Intrinsics.f(name, "TransferStatusActivity::class.java.name");
        f58947n = name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void initData() {
        v0();
        u0();
        ((ky.b) getMViewBinding()).f69665n.setCurrentItem(f58948o ? 1 : 0);
        if (f58948o) {
            List<String> listL = q0().l();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initData: clientIps:");
            sb2.append(listL);
            List<String> listM = q0().m();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("initData: clientNames:");
            sb3.append(listM);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ky.b) getMViewBinding()).f69665n.setAdapter(new d());
        m0();
        ((ky.b) getMViewBinding()).f69659h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.impl.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferStatusActivity.w0(this.f59059a, view);
            }
        });
        ((ky.b) getMViewBinding()).f69661j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.impl.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferStatusActivity.x0(this.f59060a, view);
            }
        });
    }

    public static final void w0(TransferStatusActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (f58948o) {
            if (this$0.q0().j()) {
                py.b.f74066a.u(this$0.q0().t());
                this$0.A0();
                return;
            } else {
                this$0.y0();
                this$0.finish();
                return;
            }
        }
        if (!this$0.o0().s()) {
            this$0.y0();
            this$0.finish();
            return;
        }
        if (!this$0.q0().y()) {
            this$0.q0().A();
        }
        if (this$0.q0().m().isEmpty()) {
            this$0.o0().u(new TransferStatusActivity$initView$1$1(this$0));
        } else {
            this$0.A0();
        }
    }

    public static final void x0(TransferStatusActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        ry.b.f75768a.b();
        ry.a.f75766a.b();
        q0().C();
        TransferServer.f59075s.a();
        ey.a aVar = ey.a.f64470a;
        aVar.j();
        aVar.i();
        o0().v(new Function0<Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$release$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WifiCreateManager.f59169a.j();
                ey.a aVar2 = ey.a.f64470a;
                aVar2.f();
                WifiConnectionManager.f59120a.s();
                aVar2.e();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("TransferSelectFragment");
        if (fragmentFindFragmentByTag == null) {
            my.a aVarR0 = r0();
            if (aVarR0 != 0) {
                aVarR0.F(new g());
            }
            Intrinsics.e(aVarR0, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            fragmentFindFragmentByTag = (Fragment) aVarR0;
        }
        my.a aVar = (my.a) fragmentFindFragmentByTag;
        this.f58951c = aVar;
        if (aVar != null) {
            aVar.Z(o0().r() + q0().w(), o0().n() + q0().s());
        }
        this.f58952d = true;
        if (fragmentFindFragmentByTag.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getSupportFragmentManager().beginTransaction().add(R$id.fl_select_page_container, fragmentFindFragmentByTag, "TransferSelectFragment").commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        initView();
        initData();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdapter(new c());
        ((ky.b) getMViewBinding()).f69658g.setNavigator(commonNavigator);
        ((ky.b) getMViewBinding()).f69665n.registerOnPageChangeCallback(new b());
        ((ky.b) getMViewBinding()).f69665n.setCurrentItem(this.f58958k, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0(boolean z11, String str) {
        if (z11) {
            my.a aVar = this.f58951c;
            if (aVar != null) {
                aVar.W();
            }
            ((ky.b) getMViewBinding()).f69663l.setImageResource(R$mipmap.transfer_ic_link);
            ((ky.b) getMViewBinding()).f69661j.setText(getString(R$string.transfer_disconnect));
            ((ky.b) getMViewBinding()).f69662k.setText(getString(R$string.transfer_state_connect_tips, ((ky.b) getMViewBinding()).f69662k.getTag() == null ? str : ((ky.b) getMViewBinding()).f69662k.getTag().toString()));
            if (str.length() > 0) {
                ((ky.b) getMViewBinding()).f69662k.setTag(str);
                return;
            }
            return;
        }
        my.a aVar2 = this.f58951c;
        if (aVar2 != null) {
            aVar2.a();
        }
        ((ky.b) getMViewBinding()).f69663l.setImageResource(R$mipmap.transfer_ic_unlink);
        ((ky.b) getMViewBinding()).f69661j.setText("");
        ((ky.b) getMViewBinding()).f69662k.setText(getString(R$string.transfer_state_disconnect_tips, ((ky.b) getMViewBinding()).f69662k.getTag() == null ? str : ((ky.b) getMViewBinding()).f69662k.getTag().toString()));
        if (str.length() > 0) {
            ((ky.b) getMViewBinding()).f69662k.setTag(str);
        }
    }

    public final ClientViewModel o0() {
        return (ClientViewModel) this.f58957j.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String strK = WifiUtils.f59242a.k();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        sb2.append(strK);
        ImageView imageView = ((ky.b) getMViewBinding()).f69664m;
        Intrinsics.f(imageView, "mViewBinding.vTopBg");
        so.c.e(imageView);
        getWindow().addFlags(128);
        getOnBackPressedDispatcher().i(this, new e());
    }

    public final TransferStatusActivity$serverFileHandler$2.a p0() {
        return (TransferStatusActivity$serverFileHandler$2.a) this.f58955h.getValue();
    }

    public final com.transsion.transfer.impl.g q0() {
        return (com.transsion.transfer.impl.g) this.f58956i.getValue();
    }

    public final my.a r0() {
        return (my.a) this.f58954g.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public ky.b getViewBinding() {
        ky.b bVarC = ky.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    public final void t0() {
        Object obj = this.f58951c;
        if (obj != null) {
            this.f58952d = false;
            getSupportFragmentManager().beginTransaction().hide((Fragment) obj).commitNowAllowingStateLoss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0() {
        if (!o0().s() || o0().l() == null) {
            if (!f58948o) {
                String strL = o0().l();
                n0(false, strL != null ? strL : "");
            }
            o0().m().j(this, new f(new Function1<String, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initClientVM$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    if (str == null) {
                        return;
                    }
                    ((ky.b) this.this$0.getMViewBinding()).f69662k.setText(str);
                    my.a aVar = this.this$0.f58951c;
                    if (aVar != null) {
                        String strL2 = this.this$0.o0().l();
                        if (strL2 == null) {
                            strL2 = "";
                        }
                        aVar.M(strL2);
                    }
                    TransferStatusActivity transferStatusActivity = this.this$0;
                    String strL3 = transferStatusActivity.o0().l();
                    transferStatusActivity.n0(true, strL3 != null ? strL3 : "");
                }
            }));
        } else {
            ((ky.b) getMViewBinding()).f69662k.setText(o0().l());
            my.a aVar = this.f58951c;
            if (aVar != null) {
                String strL2 = o0().l();
                if (strL2 == null) {
                    strL2 = "";
                }
                aVar.M(strL2);
            }
            String strL3 = o0().l();
            n0(true, strL3 != null ? strL3 : "");
        }
        o0().k().j(this, new f(new Function1<Boolean, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initClientVM$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                TransferStatusActivity transferStatusActivity = this.this$0;
                Intrinsics.f(it, "it");
                boolean z11 = it.booleanValue() || this.this$0.q0().j();
                String strL4 = this.this$0.o0().l();
                if (strL4 == null) {
                    strL4 = "";
                }
                transferStatusActivity.n0(z11, strL4);
                if (it.booleanValue()) {
                    this.this$0.o0().o(true);
                    return;
                }
                TransferReceivedFragment transferReceivedFragment = this.this$0.f58949a;
                if (transferReceivedFragment != null) {
                    transferReceivedFragment.p0();
                }
            }
        }));
        o0().j().j(this, new f(new Function1<Integer, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initClientVM$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 1) {
                    ((ky.b) this.this$0.getMViewBinding()).f69665n.setCurrentItem(0, true);
                    py.b.f74066a.k(TransferClient.f58969t.h());
                    TransferReceivedFragment transferReceivedFragment = this.this$0.f58949a;
                    if (transferReceivedFragment != null) {
                        transferReceivedFragment.n0();
                    }
                }
            }
        }));
    }

    public final void v0() {
        if (f58948o) {
            String strP = q0().p();
            boolean z11 = !(strP == null || strP.length() == 0);
            my.a aVar = this.f58951c;
            if (aVar != null) {
                String strP2 = q0().p();
                if (strP2 == null) {
                    strP2 = "";
                }
                aVar.M(strP2);
            }
            String strP3 = q0().p();
            n0(z11, strP3 != null ? strP3 : "");
        }
        q0().k().j(this, new f(new Function1<String, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                ((ky.b) this.this$0.getMViewBinding()).f69662k.setText(it);
                my.a aVar2 = this.this$0.f58951c;
                if (aVar2 != null) {
                    aVar2.M(it == null ? "" : it);
                }
                TransferStatusActivity transferStatusActivity = this.this$0;
                Intrinsics.f(it, "it");
                transferStatusActivity.n0(true, it);
            }
        }));
        q0().o().j(this, new f(new Function1<Pair<? extends String, ? extends Boolean>, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, Boolean> pair) {
                TransferStatusActivity transferStatusActivity = this.this$0;
                boolean zBooleanValue = pair.getSecond().booleanValue();
                String strP4 = this.this$0.q0().p();
                if (strP4 == null) {
                    strP4 = "";
                }
                transferStatusActivity.n0(zBooleanValue, strP4);
                if (this.this$0.f58953f) {
                    this.this$0.f58953f = false;
                    if (pair.getSecond().booleanValue()) {
                        this.this$0.A0();
                        return;
                    } else {
                        this.this$0.y0();
                        this.this$0.finish();
                        return;
                    }
                }
                if (pair.getSecond().booleanValue()) {
                    return;
                }
                TransferReceivedFragment transferReceivedFragment = this.this$0.f58949a;
                if (transferReceivedFragment != null) {
                    transferReceivedFragment.p0();
                }
                TransferReceivedFragment transferReceivedFragment2 = this.this$0.f58949a;
                if (transferReceivedFragment2 != null) {
                    transferReceivedFragment2.p0();
                }
            }
        }));
        q0().n().j(this, new f(new Function1<String, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3

            /* JADX INFO: renamed from: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                final /* synthetic */ TransferStatusActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(TransferStatusActivity transferStatusActivity) {
                    super(0);
                    this.this$0 = transferStatusActivity;
                }

                public static final void b(final TransferStatusActivity this$0) {
                    Intrinsics.g(this$0, "this$0");
                    this$0.u0();
                    this$0.o0().h(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE 
                          (wrap com.transsion.transfer.impl.ClientViewModel:0x0008: INVOKE (r2v0 'this$0' com.transsion.transfer.impl.TransferStatusActivity) VIRTUAL call: com.transsion.transfer.impl.TransferStatusActivity.o0():com.transsion.transfer.impl.ClientViewModel A[MD:():com.transsion.transfer.impl.ClientViewModel (m), WRAPPED])
                          (wrap kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.String, kotlin.Unit>:0x000e: CONSTRUCTOR (r2v0 'this$0' com.transsion.transfer.impl.TransferStatusActivity A[DONT_INLINE]) A[MD:(com.transsion.transfer.impl.TransferStatusActivity):void (m), WRAPPED] call: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3$1$1$1.<init>(com.transsion.transfer.impl.TransferStatusActivity):void type: CONSTRUCTOR)
                         VIRTUAL call: com.transsion.transfer.impl.ClientViewModel.h(kotlin.jvm.functions.Function2):void A[MD:(kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit>):void (m)] in method: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3.1.b(com.transsion.transfer.impl.TransferStatusActivity):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3$1$1$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        java.lang.String r0 = "this$0"
                        kotlin.jvm.internal.Intrinsics.g(r2, r0)
                        com.transsion.transfer.impl.TransferStatusActivity.b0(r2)
                        com.transsion.transfer.impl.ClientViewModel r0 = com.transsion.transfer.impl.TransferStatusActivity.R(r2)
                        com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3$1$1$1 r1 = new com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3$1$1$1
                        r1.<init>(r2)
                        r0.h(r1)
                        com.transsion.transfer.impl.ClientViewModel r2 = com.transsion.transfer.impl.TransferStatusActivity.R(r2)
                        r0 = 1
                        r2.o(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3.AnonymousClass1.b(com.transsion.transfer.impl.TransferStatusActivity):void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConstraintLayout root = ((ky.b) this.this$0.getMViewBinding()).getRoot();
                    final TransferStatusActivity transferStatusActivity = this.this$0;
                    root.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE 
                          (r0v3 'root' androidx.constraintlayout.widget.ConstraintLayout)
                          (wrap java.lang.Runnable:0x0010: CONSTRUCTOR (r1v0 'transferStatusActivity' com.transsion.transfer.impl.TransferStatusActivity A[DONT_INLINE]) A[MD:(com.transsion.transfer.impl.TransferStatusActivity):void (m), WRAPPED] call: com.transsion.transfer.impl.k.<init>(com.transsion.transfer.impl.TransferStatusActivity):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] in method: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3.1.invoke():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.transsion.transfer.impl.k, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.transsion.transfer.impl.TransferStatusActivity r0 = r3.this$0
                        n6.a r0 = r0.getMViewBinding()
                        ky.b r0 = (ky.b) r0
                        androidx.constraintlayout.widget.ConstraintLayout r0 = r0.getRoot()
                        com.transsion.transfer.impl.TransferStatusActivity r1 = r3.this$0
                        com.transsion.transfer.impl.k r2 = new com.transsion.transfer.impl.k
                        r2.<init>(r1)
                        r0.post(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.impl.TransferStatusActivity$initServerVM$3.AnonymousClass1.invoke2():void");
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String remoteIP) {
                TransferClient.Companion companion = TransferClient.f58969t;
                Intrinsics.f(remoteIP, "remoteIP");
                TransferClient.Companion.j(companion, remoteIP, WifiUtils.f59242a.k(), null, new AnonymousClass1(this.this$0), 4, null);
                py.b.f74066a.t(companion.h());
            }
        }));
    }

    public final void z0() {
        TransferDisconnectTipsDialog transferDisconnectTipsDialog = new TransferDisconnectTipsDialog();
        transferDisconnectTipsDialog.q0(new Function1<Boolean, Unit>() { // from class: com.transsion.transfer.impl.TransferStatusActivity$showDisconnectTipsDialog$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (z11) {
                    if (TransferStatusActivity.f58948o) {
                        py.b.f74066a.p(this.this$0.q0().t());
                    } else {
                        py.b.f74066a.f(TransferClient.f58969t.h());
                    }
                    this.this$0.y0();
                    this.this$0.finish();
                }
            }
        });
        transferDisconnectTipsDialog.j0(this, "transfer_disconnect_tips_dialog");
    }
}
