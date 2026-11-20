package com.transsion.room.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLLinearLayout;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.R$string;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsion.room.R$color;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.view.roundimage.PileLayout;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
public final class RoomDetailFragmentNew extends RoomBaseFragment<sw.j> {
    public static final a N = new a(null);
    public String D;
    public boolean E;
    public RoomItem F;
    public ShareDialogFragment G;
    public PublishResult H;
    public View I;
    public final yi.n J;
    public final Lazy K;
    public final b1.b<Intent> L;
    public final Lazy M;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<String> f57166u = kotlin.collections.g.o(Utils.a().getString(R$string.Popular), Utils.a().getString(R$string.Newest));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f57167v = gs.a.a(24);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f57168w = gs.a.a(52);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f57169x = gs.a.a(24);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f57170y = gs.a.a(28);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f57171z = gs.a.a(48);
    public final int A = gs.a.a(12);
    public final int B = gs.a.a(12);
    public final int C = gs.a.a(54);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomDetailFragmentNew a(RoomItem roomItem, String str, boolean z11) {
            RoomDetailFragmentNew roomDetailFragmentNew = new RoomDetailFragmentNew();
            roomDetailFragmentNew.setArguments(androidx.core.os.c.b(TuplesKt.a(WebConstants.FIELD_ITEM, roomItem), TuplesKt.a("id", str), TuplesKt.a("need_start_room_home", Boolean.valueOf(z11))));
            return roomDetailFragmentNew;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends androidx.activity.p {
        public b() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            RoomDetailFragmentNew.this.C1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57173a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57173a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57173a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57173a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d implements com.transsion.share.share.e {
        public d() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            com.transsion.share.share.e.a.b(this, str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            String str;
            Intrinsics.g(id2, "id");
            if (com.transsion.baseui.util.c.f51452a.a(2, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (str = RoomDetailFragmentNew.this.D) == null) {
                return;
            }
            RoomDetailFragmentNew.this.T0().s(str);
        }
    }

    public RoomDetailFragmentNew() {
        yi.n nVarM = yi.n.a().q(0, 10.0f).p(yi.n.f81423m).m();
        Intrinsics.f(nVarM, "builder()\n        .setAl…el.PILL)\n        .build()");
        this.J = nVarM;
        this.K = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.room.fragment.t
            @Override // b1.a
            public final void a(Object obj) {
                RoomDetailFragmentNew.A1(this.f57275a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…tus.JOIN)\n        }\n    }");
        this.L = bVarRegisterForActivityResult;
        this.M = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew$mPublishedApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IPublishApi invoke() {
                return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void A1(RoomDetailFragmentNew this$0, ActivityResult activityResult) {
        RoomJoinAnimationView roomJoinAnimationView;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.r1();
            this$0.y1();
            return;
        }
        sw.j jVar = (sw.j) this$0.getMViewBinding();
        if (jVar == null || (roomJoinAnimationView = jVar.f76544r) == null) {
            return;
        }
        roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        if (this.E) {
            rw.e.b(rw.e.f75743a, null, null, 3, null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void H1(RoomDetailFragmentNew this$0) {
        Intrinsics.g(this$0, "this$0");
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        this$0.I1(applicationA);
    }

    private final boolean checkLogin() {
        if (p1().N()) {
            return true;
        }
        b1.b<Intent> bVar = this.L;
        Context context = getContext();
        bVar.a(context != null ? p1().o1(context) : null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            G0(false);
        } else {
            M0(false);
        }
    }

    private final ILoginApi p1() {
        return (ILoginApi) this.K.getValue();
    }

    public static final void t1(RoomDetailFragmentNew this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.F1();
    }

    public static final void u1(RoomDetailFragmentNew this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        RoomItem roomItem = this$0.F;
        if (roomItem == null || !Intrinsics.b(roomItem.getHasJoin(), Boolean.TRUE)) {
            this$0.y1();
        } else {
            this$0.z1();
        }
    }

    public static final void v1(RoomDetailFragmentNew this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.D1();
    }

    public static final void w1(RoomDetailFragmentNew this$0, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        float fAbs = Math.abs(i11) / appBarLayout.getTotalScrollRange();
        Context context = appBarLayout.getContext();
        Intrinsics.f(context, "appBarLayout.context");
        this$0.n1(context, fAbs);
    }

    public static final void x1(RoomDetailFragmentNew this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y1() {
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        sw.j jVar = (sw.j) getMViewBinding();
        if ((jVar == null || (roomJoinAnimationView2 = jVar.f76544r) == null || !roomJoinAnimationView2.isLoading()) && checkLogin() && !com.transsion.baseui.util.c.f51452a.a(1001, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
                return;
            }
            String groupId = this.D;
            if (groupId == null) {
                RoomItem roomItem = this.F;
                groupId = roomItem != null ? roomItem.getGroupId() : null;
            }
            if (groupId != null) {
                sw.j jVar2 = (sw.j) getMViewBinding();
                if (jVar2 != null && (roomJoinAnimationView = jVar2.f76544r) != null) {
                    roomJoinAnimationView.setStatus(RoomJoinStatus.LOADING);
                }
                T0().r(groupId);
                com.transsion.baselib.helper.a.f51183a.g("room_detail", "join", (28 & 4) != 0 ? "" : this.D, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        K0();
        r1();
    }

    public final void B1() {
        Object context = getContext();
        if (context instanceof ComponentActivity) {
            Function1<PublishResult, Unit> function1 = new Function1<PublishResult, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew$observer$1
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
                    this.this$0.G1(it);
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishResult.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent((androidx.lifecycle.u) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        }
    }

    public void D1() {
        Context context;
        RoomItem roomItem = this.F;
        if (roomItem == null || (context = getContext()) == null) {
            return;
        }
        IPublishApi iPublishApiQ1 = q1();
        String groupId = roomItem.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        String name = roomItem.getName();
        if (name == null) {
            name = "";
        }
        String avatar = roomItem.getAvatar();
        iPublishApiQ1.x(context, groupId, name, avatar != null ? avatar : "");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        r1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void E1(RoomItem roomItem) {
        Group group;
        String strA;
        ColorStateList colorStateList;
        int color;
        PileLayout pileLayout;
        Cover cover;
        String averageHueDark;
        PileLayout pileLayout2;
        Cover cover2;
        String averageHueDark2;
        PileLayout pileLayout3;
        Group group2;
        List<String> memberAvatars = roomItem.getMemberAvatars();
        List<String> listM0 = memberAvatars != null ? CollectionsKt___CollectionsKt.M0(memberAvatars) : null;
        List list = listM0;
        if (list == null || list.isEmpty()) {
            sw.j jVar = (sw.j) getMViewBinding();
            if (jVar == null || (group = jVar.f76533g) == null) {
                return;
            }
            so.c.g(group);
            return;
        }
        sw.j jVar2 = (sw.j) getMViewBinding();
        if (jVar2 != null && (group2 = jVar2.f76533g) != null) {
            so.c.k(group2);
        }
        if (roomItem.getUserCount() != null) {
            Long userCount = roomItem.getUserCount();
            Intrinsics.d(userCount);
            strA = com.transsion.baselib.utils.i.a(userCount.longValue());
        } else {
            strA = "0";
        }
        sw.j jVar3 = (sw.j) getMViewBinding();
        AppCompatTextView appCompatTextView = jVar3 != null ? jVar3.f76542p : null;
        int i11 = 1;
        if (appCompatTextView != null) {
            Long userCount2 = roomItem.getUserCount();
            appCompatTextView.setText((userCount2 != null ? userCount2.longValue() : 0L) == 1 ? Utils.a().getString(com.transsion.room.R$string.one_members) : Utils.a().getString(com.transsion.room.R$string.x_members, strA));
        }
        sw.j jVar4 = (sw.j) getMViewBinding();
        if (jVar4 != null && (pileLayout3 = jVar4.f76541o) != null) {
            pileLayout3.removeAllViews();
        }
        Long userCount3 = roomItem.getUserCount();
        boolean z11 = (userCount3 != null ? userCount3.longValue() : 0L) > 8;
        Cover cover3 = roomItem.getCover();
        String averageHueDark3 = cover3 != null ? cover3.getAverageHueDark() : null;
        int i12 = 2;
        if (averageHueDark3 == null || averageHueDark3.length() == 0 || (cover2 = roomItem.getCover()) == null || (averageHueDark2 = cover2.getAverageHueDark()) == null || !kotlin.text.l.L(averageHueDark2, com.transsion.gslb.Utils.SEPARATOR, false, 2, null)) {
            colorStateList = z2.a.getColorStateList(Utils.a(), R$color.post_detail_top_bg);
        } else {
            Cover cover4 = roomItem.getCover();
            colorStateList = ColorStateList.valueOf(Color.parseColor(cover4 != null ? cover4.getAverageHueDark() : null));
        }
        for (String str : listM0) {
            sw.j jVar5 = (sw.j) getMViewBinding();
            if (jVar5 != null && (pileLayout2 = jVar5.f76541o) != null) {
                ShapeableImageView shapeableImageView = new ShapeableImageView(pileLayout2.getContext());
                shapeableImageView.setStrokeWidth(gs.a.a(i12));
                shapeableImageView.setStrokeColor(colorStateList);
                shapeableImageView.setShapeAppearanceModel(this.J);
                int iA = gs.a.a(i11);
                shapeableImageView.setPadding(iA, iA, iA, iA);
                shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = pileLayout2.getContext();
                Intrinsics.f(context, "plMemberIc.context");
                int i13 = com.tn.lib.widget.R$color.transparent;
                int i14 = this.f57167v;
                companion.o(context, shapeableImageView, str, (32704 & 8) != 0 ? com.tn.lib.widget.R$color.skeleton : i13, (32704 & 16) != 0 ? companion.d() : i14, (32704 & 32) != 0 ? companion.c() : i14, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
                int i15 = this.f57167v;
                pileLayout2.addView(shapeableImageView, i15, i15);
            }
            i12 = 2;
            i11 = 1;
        }
        if (z11) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_member_avatar_more, (ViewGroup) null);
            Cover cover5 = roomItem.getCover();
            String averageHueDark4 = cover5 != null ? cover5.getAverageHueDark() : null;
            if (averageHueDark4 == null || averageHueDark4.length() == 0 || (cover = roomItem.getCover()) == null || (averageHueDark = cover.getAverageHueDark()) == null || !kotlin.text.l.L(averageHueDark, com.transsion.gslb.Utils.SEPARATOR, false, 2, null)) {
                color = viewInflate.getContext().getResources().getColor(R$color.post_detail_top_bg);
            } else {
                Cover cover6 = roomItem.getCover();
                color = Color.parseColor(cover6 != null ? cover6.getAverageHueDark() : null);
            }
            ((BLLinearLayout) viewInflate.findViewById(R$id.v_more)).setBackgroundDrawable(new DrawableCreator.Builder().setCornersRadius(gs.a.a(12)).setSolidColor(viewInflate.getContext().getResources().getColor(com.tn.lib.widget.R$color.gray_dark_30)).setStrokeColor(color).setStrokeWidth(gs.a.a(2)).build());
            sw.j jVar6 = (sw.j) getMViewBinding();
            if (jVar6 == null || (pileLayout = jVar6.f76541o) == null) {
                return;
            }
            int i16 = this.f57167v;
            pileLayout.addView(viewInflate, i16, i16);
        }
    }

    public final void F1() {
        ShareDialogFragment shareDialogFragment;
        ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
        PostType postType = PostType.GROUP_TYPE;
        String str = this.D;
        RoomItem roomItem = this.F;
        String creatorId = roomItem != null ? roomItem.getCreatorId() : null;
        String value = ReportType.GROUP.getValue();
        RoomItem roomItem2 = this.F;
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, str, creatorId, value, (3072 & 16) != 0 ? "" : roomItem2 != null ? roomItem2.getName() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : false, (3072 & 256) != 0 ? false : false, "groupdetail", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
        this.G = shareDialogFragmentA;
        if (shareDialogFragmentA != null) {
            shareDialogFragmentA.E0(new d());
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.executePendingTransactions();
        ShareDialogFragment shareDialogFragment2 = this.G;
        if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.G) != null) {
            shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
        }
        com.transsion.baselib.helper.a.f51183a.g("room_detail", AppLovinEventTypes.USER_SHARED_LINK, (28 & 4) != 0 ? "" : this.D, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G1(PublishResult publishResult) {
        sw.j jVar;
        AppCompatImageView appCompatImageView;
        this.H = publishResult;
        Integer numValueOf = publishResult != null ? Integer.valueOf(publishResult.getState()) : null;
        if (numValueOf == null || numValueOf.intValue() != 0 || (jVar = (sw.j) getMViewBinding()) == null || (appCompatImageView = jVar.f76535i) == null) {
            return;
        }
        appCompatImageView.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.n
            @Override // java.lang.Runnable
            public final void run() {
                RoomDetailFragmentNew.H1(this.f57268a);
            }
        }, 1500L);
    }

    public final void I1(Context context) {
        UploadView uploadView = new UploadView(context);
        uploadView.setPageName("room_detail");
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
        uploadView.showFloatView(this.H);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J1(RoomItem roomItem) {
        RoomJoinAnimationView roomJoinAnimationView;
        ExpandView expandView;
        ShapeableImageView shapeableImageView;
        this.F = roomItem;
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null && (shapeableImageView = jVar.f76536j) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "it.context");
            String avatar = roomItem.getAvatar();
            if (avatar == null) {
                avatar = "";
            }
            int i11 = this.f57167v;
            companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        sw.j jVar2 = (sw.j) getMViewBinding();
        AppCompatTextView appCompatTextView = jVar2 != null ? jVar2.f76543q : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(roomItem.getName());
        }
        sw.j jVar3 = (sw.j) getMViewBinding();
        if (jVar3 != null && (expandView = jVar3.f76531d) != null) {
            expandView.l(roomItem.getDescription());
        }
        sw.j jVar4 = (sw.j) getMViewBinding();
        if (jVar4 != null && (roomJoinAnimationView = jVar4.f76544r) != null) {
            roomJoinAnimationView.setStatus(Intrinsics.b(roomItem.getHasJoin(), Boolean.TRUE) ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
        }
        E1(roomItem);
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public Fragment S0(int i11) {
        return i11 == 0 ? U0().X0(this.D) : U0().E(this.D);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public MagicIndicator X0() {
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null) {
            return jVar.f76540n;
        }
        return null;
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public List<String> Z0() {
        return this.f57166u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public ViewPager2 a1() {
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null) {
            return jVar.f76546t;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        RoomJoinAnimationView roomJoinAnimationView;
        AppCompatImageView appCompatImageView2;
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null && (appCompatImageView2 = jVar.f76537k) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragmentNew.t1(this.f57270a, view);
                }
            });
        }
        sw.j jVar2 = (sw.j) getMViewBinding();
        if (jVar2 != null && (roomJoinAnimationView = jVar2.f76544r) != null) {
            roomJoinAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragmentNew.u1(this.f57271a, view);
                }
            });
        }
        sw.j jVar3 = (sw.j) getMViewBinding();
        if (jVar3 == null || (appCompatImageView = jVar3.f76535i) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomDetailFragmentNew.v1(this.f57272a, view);
            }
        });
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        T0().l().j(this, new c(new Function1<RoomItem, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomItem roomItem) {
                invoke2(roomItem);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomItem roomItem) {
                if (roomItem == null) {
                    RoomDetailFragmentNew.this.o1();
                } else {
                    RoomDetailFragmentNew.this.F0();
                    RoomDetailFragmentNew.this.J1(roomItem);
                }
            }
        }));
        T0().n().j(this, new c(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                RoomJoinAnimationView roomJoinAnimationView;
                RoomJoinAnimationView roomJoinAnimationView2;
                RoomDetailFragmentNew.this.r1();
                if (roomNet == null) {
                    sw.j jVar = (sw.j) RoomDetailFragmentNew.this.getMViewBinding();
                    if (jVar == null || (roomJoinAnimationView2 = jVar.f76544r) == null) {
                        return;
                    }
                    roomJoinAnimationView2.setStatus(RoomJoinStatus.JOIN);
                    return;
                }
                sw.j jVar2 = (sw.j) RoomDetailFragmentNew.this.getMViewBinding();
                if (jVar2 == null || (roomJoinAnimationView = jVar2.f76544r) == null) {
                    return;
                }
                roomJoinAnimationView.setStatus(RoomJoinStatus.JOINED);
            }
        }));
        T0().o().j(this, new c(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragmentNew.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                if (roomNet != null) {
                    RoomDetailFragmentNew.this.r1();
                }
            }
        }));
        B1();
        String str = this.D;
        if (str != null) {
            T0().t(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n1(Context context, float f11) {
        int color;
        RoomJoinAnimationView roomJoinAnimationView;
        ShapeableImageView shapeableImageView;
        LinearLayout linearLayout;
        View view;
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        RoomItem roomItem;
        Cover cover;
        String averageHueDark;
        Cover cover2;
        Cover cover3;
        int i11 = this.f57168w;
        float f12 = i11 - ((i11 - this.f57169x) * f11);
        float f13 = i11 - ((i11 - this.f57170y) * f11);
        int i12 = this.A;
        float f14 = i12 - ((i12 - this.f57171z) * f11);
        int i13 = this.C;
        float f15 = i13 - ((i13 - this.B) * f11);
        RoomItem roomItem2 = this.F;
        String averageHueDark2 = (roomItem2 == null || (cover3 = roomItem2.getCover()) == null) ? null : cover3.getAverageHueDark();
        if (averageHueDark2 == null || averageHueDark2.length() == 0 || (roomItem = this.F) == null || (cover = roomItem.getCover()) == null || (averageHueDark = cover.getAverageHueDark()) == null || !kotlin.text.l.L(averageHueDark, com.transsion.gslb.Utils.SEPARATOR, false, 2, null)) {
            color = context.getResources().getColor(R$color.post_detail_top_bg);
        } else {
            RoomItem roomItem3 = this.F;
            color = Color.parseColor((roomItem3 == null || (cover2 = roomItem3.getCover()) == null) ? null : cover2.getAverageHueDark());
        }
        int iA = g20.a.a(f11, color, context.getResources().getColor(com.tn.lib.widget.R$color.bg_01));
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null && (imageView = jVar.f76538l) != null) {
            imageView.setBackgroundColor(iA);
        }
        sw.j jVar2 = (sw.j) getMViewBinding();
        if (jVar2 != null && (frameLayout = jVar2.f76532f) != null) {
            frameLayout.setBackgroundColor(iA);
        }
        sw.j jVar3 = (sw.j) getMViewBinding();
        if (jVar3 != null && (constraintLayout = jVar3.f76530c) != null) {
            constraintLayout.setBackgroundColor(iA);
        }
        sw.j jVar4 = (sw.j) getMViewBinding();
        if (jVar4 != null && (view = jVar4.f76545s) != null) {
            view.setBackgroundColor(iA);
        }
        sw.j jVar5 = (sw.j) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (jVar5 == null || (linearLayout = jVar5.f76539m) == null) ? null : linearLayout.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart((int) f14);
        marginLayoutParams.topMargin = (int) f15;
        marginLayoutParams.height = (int) f13;
        sw.j jVar6 = (sw.j) getMViewBinding();
        LinearLayout linearLayout2 = jVar6 != null ? jVar6.f76539m : null;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(marginLayoutParams);
        }
        sw.j jVar7 = (sw.j) getMViewBinding();
        ViewGroup.LayoutParams layoutParams2 = (jVar7 == null || (shapeableImageView = jVar7.f76536j) == null) ? null : shapeableImageView.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int i14 = (int) f12;
        layoutParams2.width = i14;
        layoutParams2.height = i14;
        sw.j jVar8 = (sw.j) getMViewBinding();
        ShapeableImageView shapeableImageView2 = jVar8 != null ? jVar8.f76536j : null;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setLayoutParams(layoutParams2);
        }
        sw.j jVar9 = (sw.j) getMViewBinding();
        AppCompatTextView appCompatTextView = jVar9 != null ? jVar9.f76543q : null;
        if (appCompatTextView != null) {
            appCompatTextView.setMaxLines(f11 > 0.9f ? 1 : 2);
        }
        float f16 = f11 * 2;
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        sw.j jVar10 = (sw.j) getMViewBinding();
        AppCompatImageView appCompatImageView = jVar10 != null ? jVar10.f76537k : null;
        if (appCompatImageView != null) {
            appCompatImageView.setAlpha(1 - f16);
        }
        sw.j jVar11 = (sw.j) getMViewBinding();
        ExpandView expandView = jVar11 != null ? jVar11.f76531d : null;
        if (expandView != null) {
            expandView.setAlpha(1 - f16);
        }
        sw.j jVar12 = (sw.j) getMViewBinding();
        RoomJoinAnimationView roomJoinAnimationView2 = jVar12 != null ? jVar12.f76544r : null;
        if (roomJoinAnimationView2 != null) {
            roomJoinAnimationView2.setAlpha(1 - f16);
        }
        float f17 = 1 - f16;
        boolean z11 = f17 > 0.0f;
        sw.j jVar13 = (sw.j) getMViewBinding();
        if (jVar13 != null && (roomJoinAnimationView = jVar13.f76544r) != null) {
            if ((roomJoinAnimationView.getVisibility() == 0) == z11) {
                return;
            }
        }
        sw.j jVar14 = (sw.j) getMViewBinding();
        RoomJoinAnimationView roomJoinAnimationView3 = jVar14 != null ? jVar14.f76544r : null;
        if (roomJoinAnimationView3 == null) {
            return;
        }
        roomJoinAnimationView3.setVisibility(f17 > 0.0f ? 0 : 8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("room_detail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        if (this.I == null) {
            this.I = LayoutInflater.from(requireContext()).inflate(R$layout.layout_room_detail_loading, (ViewGroup) o0(), false);
        }
        return this.I;
    }

    public final IPublishApi q1() {
        return (IPublishApi) this.M.getValue();
    }

    public final void r1() {
        String str = this.D;
        if (str != null) {
            T0().k(str);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public sw.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.j jVarC = sw.j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        com.transsion.baselib.report.h logViewConfig;
        HashMap<String, String> mapG;
        OnBackPressedDispatcher onBackPressedDispatcher;
        AppCompatImageView appCompatImageView;
        AppBarLayout appBarLayout;
        ImageView imageView;
        String groupId;
        Bundle arguments = getArguments();
        String string = null;
        RoomItem roomItem = arguments != null ? (RoomItem) arguments.getParcelable(WebConstants.FIELD_ITEM) : null;
        if (roomItem == null || (groupId = roomItem.getGroupId()) == null) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                string = arguments2.getString("id");
            }
        } else {
            string = groupId;
        }
        this.D = string;
        Bundle arguments3 = getArguments();
        this.E = arguments3 != null ? arguments3.getBoolean("need_start_room_home") : false;
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar != null && (imageView = jVar.f76538l) != null) {
            so.c.e(imageView);
        }
        sw.j jVar2 = (sw.j) getMViewBinding();
        if (jVar2 != null && (appBarLayout = jVar2.f76529b) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.r
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void a(AppBarLayout appBarLayout2, int i11) {
                    RoomDetailFragmentNew.w1(this.f57273a, appBarLayout2, i11);
                }
            });
        }
        sw.j jVar3 = (sw.j) getMViewBinding();
        if (jVar3 != null && (appCompatImageView = jVar3.f76534h) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragmentNew.x1(this.f57274a, view);
                }
            });
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            androidx.lifecycle.u viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.f(viewLifecycleOwner, "viewLifecycleOwner");
            onBackPressedDispatcher.i(viewLifecycleOwner, new b());
        }
        super.v0();
        String str = this.D;
        if (str == null || (logViewConfig = getLogViewConfig()) == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("group_id", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        RoomJoinAnimationView roomJoinAnimationView;
        RoomJoinAnimationView roomJoinAnimationView2;
        sw.j jVar = (sw.j) getMViewBinding();
        if (jVar == null || (roomJoinAnimationView2 = jVar.f76544r) == null || !roomJoinAnimationView2.isLoading()) {
            String groupId = this.D;
            if (groupId == null) {
                RoomItem roomItem = this.F;
                groupId = roomItem != null ? roomItem.getGroupId() : null;
            }
            if (groupId != null) {
                sw.j jVar2 = (sw.j) getMViewBinding();
                if (jVar2 != null && (roomJoinAnimationView = jVar2.f76544r) != null) {
                    roomJoinAnimationView.setStatus(RoomJoinStatus.LOADING);
                }
                T0().s(groupId);
                com.transsion.baselib.helper.a.f51183a.g("room_detail", "leave", (28 & 4) != 0 ? "" : this.D, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
            }
        }
    }
}
