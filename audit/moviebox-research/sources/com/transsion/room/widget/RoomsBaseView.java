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
import com.transsion.room.adapter.RecommendRoomsAdapter;
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
public abstract class RoomsBaseView<T extends n6.a> extends ConstraintLayout implements rw.b, r00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f57354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f57355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RoomJoinAnimationView f57356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57357d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Integer> f57359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f57360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f57361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecommendRoomsAdapter f57362j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomsBaseView<T> f57363a;

        public a(RoomsBaseView<T> roomsBaseView) {
            this.f57363a = roomsBaseView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 == 0) {
                this.f57363a.f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            this.f57363a.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57364a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57364a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57364a;
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
            this.f57364a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsBaseView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomsBaseView(final Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f57359g = new LinkedHashSet();
        this.f57360h = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.widget.RoomsBaseView$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f57361i = LazyKt__LazyJVMKt.b(new Function0<RoomDetailViewModel>() { // from class: com.transsion.room.widget.RoomsBaseView$mDetailViewModel$2
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
        RecommendRoomsAdapter recommendRoomsAdapter = new RecommendRoomsAdapter();
        recommendRoomsAdapter.i(R$id.v_join);
        recommendRoomsAdapter.z0(new f9.b() { // from class: com.transsion.room.widget.e
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                RoomsBaseView.i(this.f57380a, baseQuickAdapter, view, i12);
            }
        });
        recommendRoomsAdapter.B0(new f9.d() { // from class: com.transsion.room.widget.f
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                RoomsBaseView.j(this.f57381a, baseQuickAdapter, view, i12);
            }
        });
        this.f57362j = recommendRoomsAdapter;
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        getMDetailViewModel().n().j(fragmentActivity, new b(new Function1<RoomNet, Unit>(this) { // from class: com.transsion.room.widget.RoomsBaseView.1
            final /* synthetic */ RoomsBaseView<T> this$0;

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
                    RoomJoinAnimationView roomJoinAnimationView = this.this$0.f57356c;
                    if (roomJoinAnimationView != null) {
                        roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
                    }
                } else {
                    RoomJoinAnimationView roomJoinAnimationView2 = this.this$0.f57356c;
                    if (roomJoinAnimationView2 != null) {
                        roomJoinAnimationView2.setStatus(RoomJoinStatus.JOINED);
                    }
                }
                this.this$0.f57356c = null;
                this.this$0.f57355b = null;
            }
        }));
        k(fragmentActivity);
        g();
    }

    public /* synthetic */ RoomsBaseView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final RoomDetailViewModel getMDetailViewModel() {
        return (RoomDetailViewModel) this.f57361i.getValue();
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.f57360h.getValue();
    }

    public static final void i(RoomsBaseView this$0, BaseQuickAdapter adapter, View view, int i11) {
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
        this$0.f57355b = Integer.valueOf(i11);
        this$0.f57356c = (RoomJoinAnimationView) view;
        this$0.h();
    }

    public static final void j(RoomsBaseView this$0, BaseQuickAdapter adapter, View view, int i11) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setList$lambda$5(RoomsBaseView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f();
    }

    public final boolean e() {
        if (getMLoginApi().N()) {
            return true;
        }
        ILoginApi mLoginApi = getMLoginApi();
        Context context = getContext();
        Intrinsics.f(context, "context");
        mLoginApi.w0(context);
        return false;
    }

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
            o(iFindFirstVisibleItemPosition);
            if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                return;
            } else {
                iFindFirstVisibleItemPosition++;
            }
        }
    }

    public final void g() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a(this));
        }
    }

    public final RecommendRoomsAdapter getMAdapter() {
        return this.f57362j;
    }

    public final T getMViewBinding() {
        return this.f57354a;
    }

    public abstract RecyclerView getRecyclerView();

    public abstract TextView getTitleView();

    @Override // rw.b
    public RoomsBaseView<T> getView() {
        return this;
    }

    public final void h() {
        Integer num;
        RoomJoinAnimationView roomJoinAnimationView = this.f57356c;
        if ((roomJoinAnimationView == null || !roomJoinAnimationView.isLoading()) && e() && (num = this.f57355b) != null) {
            Intrinsics.d(num);
            if (num.intValue() < 0) {
                return;
            }
            RecommendRoomsAdapter recommendRoomsAdapter = this.f57362j;
            Integer num2 = this.f57355b;
            Intrinsics.d(num2);
            RoomItem item = recommendRoomsAdapter.getItem(num2.intValue());
            if (com.transsion.baseui.util.c.f51452a.a(1001, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                return;
            }
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(R$string.no_network_toast);
                return;
            }
            String groupId = item.getGroupId();
            if (groupId != null) {
                RoomJoinAnimationView roomJoinAnimationView2 = this.f57356c;
                if (roomJoinAnimationView2 != null) {
                    roomJoinAnimationView2.setStatus(RoomJoinStatus.LOADING);
                }
                getMDetailViewModel().r(groupId);
                String str = this.f57357d;
                if (str != null) {
                    com.transsion.baselib.helper.a.f51183a.g(str, "join", (28 & 4) != 0 ? "" : groupId, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                }
            }
        }
    }

    public abstract void initRecyclerView();

    public final void k(FragmentActivity fragmentActivity) {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>(this) { // from class: com.transsion.room.widget.RoomsBaseView$observerGroupEvent$1
            final /* synthetic */ RoomsBaseView<T> this$0;

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

    public final void l(RoomItem item, int i11) {
        Intrinsics.g(item, "item");
        item.setNewPostCount(0L);
        this.f57362j.notifyItemChanged(i11, 0L);
        String str = this.f57357d;
        if (str != null) {
            com.transsion.room.helper.k.f57301a.f(str, this.f57358f, item);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", item.getGroupId()).withBoolean("need_start_room_home", this instanceof TrendingRoomsView).navigation();
    }

    public final void m() {
        String str = this.f57357d;
        if (str != null) {
            com.transsion.room.helper.k.f57301a.e(str, this.f57358f);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/home").navigation();
    }

    public final void n() {
        String str = this.f57357d;
        if (str != null) {
            com.transsion.room.helper.k.f57301a.c(str, this.f57358f);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/list").withInt("index", 1).navigation();
    }

    public final void o(int i11) {
        String str;
        if (this.f57359g.contains(Integer.valueOf(i11))) {
            return;
        }
        this.f57359g.add(Integer.valueOf(i11));
        RoomItem item = this.f57362j.getItem(i11);
        String str2 = this.f57357d;
        if (str2 == null || (str = this.f57358f) == null) {
            return;
        }
        com.transsion.room.helper.k.f57301a.d(str2, str, item);
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
        this.f57362j.w0(dataList);
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.room.widget.g
                @Override // java.lang.Runnable
                public final void run() {
                    RoomsBaseView.setList$lambda$5(this.f57382a);
                }
            });
        }
    }

    public final void setMAdapter(RecommendRoomsAdapter recommendRoomsAdapter) {
        Intrinsics.g(recommendRoomsAdapter, "<set-?>");
        this.f57362j = recommendRoomsAdapter;
    }

    public final void setMViewBinding(T t11) {
        this.f57354a = t11;
    }

    @Override // rw.b
    public void setReportName(String pageName, String moduleName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        this.f57357d = pageName;
        this.f57358f = moduleName;
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
