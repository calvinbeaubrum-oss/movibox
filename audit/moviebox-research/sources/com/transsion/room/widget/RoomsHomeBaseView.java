package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.widget.R$string;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.R$id;
import com.transsion.room.adapter.CommunityRoomsAdapter;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import n6.a;

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
public abstract class RoomsHomeBaseView<T extends n6.a> extends ConstraintLayout implements rw.b, r00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f57365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f57366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RoomJoinAnimationView f57367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Integer> f57370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f57371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f57372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommunityRoomsAdapter f57373j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomsHomeBaseView<T> f57374a;

        public a(RoomsHomeBaseView<T> roomsHomeBaseView) {
            this.f57374a = roomsHomeBaseView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 0) {
                this.f57374a.f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            this.f57374a.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57375a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57375a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57375a;
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
            this.f57375a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsHomeBaseView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsHomeBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsHomeBaseView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f57370g = new LinkedHashSet();
        this.f57371h = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.widget.RoomsHomeBaseView$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f57372i = LazyKt__LazyJVMKt.b(new Function0<RoomDetailViewModel>() { // from class: com.transsion.room.widget.RoomsHomeBaseView$mDetailViewModel$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomDetailViewModel invoke() {
                Context context2 = context;
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                return (RoomDetailViewModel) new v0((FragmentActivity) context2).a(RoomDetailViewModel.class);
            }
        });
        CommunityRoomsAdapter communityRoomsAdapter = new CommunityRoomsAdapter();
        communityRoomsAdapter.i(R$id.v_join);
        communityRoomsAdapter.z0(new f9.b() { // from class: com.transsion.room.widget.h
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                RoomsHomeBaseView.i(this.f57383a, baseQuickAdapter, view, i12);
            }
        });
        communityRoomsAdapter.B0(new f9.d() { // from class: com.transsion.room.widget.i
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                RoomsHomeBaseView.j(this.f57384a, baseQuickAdapter, view, i12);
            }
        });
        this.f57373j = communityRoomsAdapter;
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        getMDetailViewModel().n().j(fragmentActivity, new b(new Function1<RoomNet, Unit>(this) { // from class: com.transsion.room.widget.RoomsHomeBaseView.1
            final /* synthetic */ RoomsHomeBaseView<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                if (roomNet == null) {
                    RoomJoinAnimationView roomJoinAnimationView = this.this$0.f57367c;
                    if (roomJoinAnimationView != null) {
                        roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
                    }
                } else {
                    RoomJoinAnimationView roomJoinAnimationView2 = this.this$0.f57367c;
                    if (roomJoinAnimationView2 != null) {
                        roomJoinAnimationView2.setStatus(RoomJoinStatus.JOINED);
                    }
                }
                this.this$0.f57367c = null;
                this.this$0.f57366b = null;
            }
        }));
        k(fragmentActivity);
        g();
    }

    public /* synthetic */ RoomsHomeBaseView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final boolean e() {
        if (getMLoginApi().N()) {
            return true;
        }
        ILoginApi mLoginApi = getMLoginApi();
        Context context = getContext();
        Intrinsics.f(context, "context");
        mLoginApi.w0(context);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        RecyclerView recyclerView = getRecyclerView();
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        boolean z11 = layoutManager instanceof GridLayoutManager;
        if (z11) {
            iFindFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        } else {
            iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (z11) {
            iFindLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        } else {
            iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (iFindFirstVisibleItemPosition == -1 || iFindLastVisibleItemPosition == -1 || iFindFirstVisibleItemPosition > iFindLastVisibleItemPosition) {
            return;
        }
        while (true) {
            n(iFindFirstVisibleItemPosition);
            if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                return;
            } else {
                iFindFirstVisibleItemPosition++;
            }
        }
    }

    private final void g() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a(this));
        }
    }

    private final RoomDetailViewModel getMDetailViewModel() {
        return (RoomDetailViewModel) this.f57372i.getValue();
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.f57371h.getValue();
    }

    private final void h() {
        Integer num;
        RoomJoinAnimationView roomJoinAnimationView = this.f57367c;
        if ((roomJoinAnimationView == null || !roomJoinAnimationView.isLoading()) && this.f57366b != null && e() && (num = this.f57366b) != null) {
            Intrinsics.d(num);
            if (num.intValue() < 0) {
                return;
            }
            CommunityRoomsAdapter communityRoomsAdapter = this.f57373j;
            Integer num2 = this.f57366b;
            Intrinsics.d(num2);
            RoomItem item = communityRoomsAdapter.getItem(num2.intValue());
            if (com.transsion.baseui.util.c.f51452a.a(1001, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                return;
            }
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(R$string.no_network_toast);
                return;
            }
            String groupId = item.getGroupId();
            if (groupId != null) {
                RoomJoinAnimationView roomJoinAnimationView2 = this.f57367c;
                if (roomJoinAnimationView2 != null) {
                    roomJoinAnimationView2.setStatus(RoomJoinStatus.LOADING);
                }
                getMDetailViewModel().r(groupId);
                String str = this.f57368d;
                if (str != null) {
                    com.transsion.baselib.helper.a.f51183a.g(str, "join", (28 & 4) != 0 ? "" : groupId, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                }
            }
        }
    }

    public static final void i(RoomsHomeBaseView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        if (Intrinsics.b(roomItem.getHasJoin(), Boolean.TRUE)) {
            this$0.l(roomItem, i11);
            return;
        }
        this$0.f57366b = Integer.valueOf(i11);
        this$0.f57367c = (RoomJoinAnimationView) view;
        this$0.h();
    }

    public static final void j(RoomsHomeBaseView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        this$0.l(roomItem, i11);
    }

    private final void k(FragmentActivity fragmentActivity) {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>(this) { // from class: com.transsion.room.widget.RoomsHomeBaseView$observerGroupEvent$1
            final /* synthetic */ RoomsHomeBaseView<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                Intrinsics.g(value, "value");
                Iterator<RoomItem> it = this.this$0.getMAdapter().D().iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    }
                    if (Intrinsics.b(value.getGroupId(), it.next().getGroupId())) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    this.this$0.getMAdapter().getItem(i11).setHasJoin(Boolean.valueOf(value.getJoin()));
                    this.this$0.getMAdapter().notifyItemChanged(i11, Boolean.valueOf(value.getJoin()));
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(fragmentActivity, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    private final void n(int i11) {
        String str;
        if (this.f57370g.contains(Integer.valueOf(i11))) {
            return;
        }
        this.f57370g.add(Integer.valueOf(i11));
        RoomItem item = this.f57373j.getItem(i11);
        String str2 = this.f57368d;
        if (str2 == null || (str = this.f57369f) == null) {
            return;
        }
        com.transsion.room.helper.k.f57301a.d(str2, str, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setList$lambda$5(RoomsHomeBaseView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.g();
        this$0.f();
    }

    public final CommunityRoomsAdapter getMAdapter() {
        return this.f57373j;
    }

    public final T getMViewBinding() {
        return this.f57365a;
    }

    public abstract RecyclerView getRecyclerView();

    public abstract TextView getTitleView();

    @Override // rw.b
    public RoomsHomeBaseView<T> getView() {
        return this;
    }

    public abstract void initRecyclerView();

    public final void l(RoomItem item, int i11) {
        Intrinsics.g(item, "item");
        item.setNewPostCount(0L);
        this.f57373j.notifyItemChanged(i11, 0L);
        String str = this.f57368d;
        if (str != null) {
            com.transsion.room.helper.k.f57301a.f(str, this.f57369f, item);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", item.getGroupId()).navigation();
    }

    public final void m() {
        String str = this.f57368d;
        if (str != null) {
            com.transsion.room.helper.k.f57301a.c(str, this.f57369f);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/list").withInt("index", 1).navigation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMLoginApi().F(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMLoginApi().t1(this);
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        h();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    public void setList(List<RoomItem> dataList) {
        Intrinsics.g(dataList, "dataList");
        this.f57373j.w0(dataList);
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.room.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    RoomsHomeBaseView.setList$lambda$5(this.f57385a);
                }
            });
        }
    }

    public final void setMAdapter(CommunityRoomsAdapter communityRoomsAdapter) {
        Intrinsics.g(communityRoomsAdapter, "<set-?>");
        this.f57373j = communityRoomsAdapter;
    }

    public final void setMViewBinding(T t11) {
        this.f57365a = t11;
    }

    @Override // rw.b
    public void setReportName(String pageName, String moduleName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        this.f57368d = pageName;
        this.f57369f = moduleName;
    }

    @Override // rw.b
    public void updateTitle(String title) {
        Intrinsics.g(title, "title");
        TextView titleView = getTitleView();
        if (titleView == null) {
            return;
        }
        titleView.setText(title);
    }
}
