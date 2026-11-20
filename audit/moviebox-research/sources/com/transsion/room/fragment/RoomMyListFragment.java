package com.transsion.room.fragment;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$string;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
public final class RoomMyListFragment extends RoomListBaseFragment {
    public static final a C = new a(null);
    public String B;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomMyListFragment a(boolean z11, String str) {
            RoomMyListFragment roomMyListFragment = new RoomMyListFragment();
            roomMyListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("is_select_room", Boolean.valueOf(z11)), TuplesKt.a("user_id", str)));
            return roomMyListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57228a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57228a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57228a;
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
            this.f57228a.invoke(obj);
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public RoomListFrom i1() {
        return RoomListFrom.MY_ROOM;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        x1();
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<RoomBean> c0VarS;
        super.initViewModel();
        RoomViewModel roomViewModelH1 = h1();
        if (roomViewModelH1 == null || (c0VarS = roomViewModelH1.s()) == null) {
            return;
        }
        c0VarS.j(this, new b(new Function1<RoomBean, Unit>() { // from class: com.transsion.room.fragment.RoomMyListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomBean roomBean) {
                invoke2(roomBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomBean roomBean) {
                RoomMyListFragment.this.w1(roomBean);
            }
        }));
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.my_room_empty_tips);
        Intrinsics.f(string, "getString(R.string.my_room_empty_tips)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("my_room_list", false, 2, null);
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("user_id")) == null) {
            string = null;
        }
        this.B = string;
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void q1(boolean z11) {
        RoomViewModel roomViewModelH1 = h1();
        if (roomViewModelH1 != null) {
            roomViewModelH1.r(z11, f1(), g1(), this.B);
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public String v1() {
        return "my_room_list";
    }

    public final void x1() {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>() { // from class: com.transsion.room.fragment.RoomMyListFragment$observeJoinRoom$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                List<RoomItem> listD;
                Intrinsics.g(value, "value");
                RoomMyListFragment roomMyListFragment = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    if (value.getJoin()) {
                        roomMyListFragment.c1();
                    } else {
                        RoomListAdapter roomListAdapterD1 = roomMyListFragment.d1();
                        int i11 = -1;
                        if (roomListAdapterD1 != null && (listD = roomListAdapterD1.D()) != null) {
                            Iterator<RoomItem> it = listD.iterator();
                            int i12 = 0;
                            while (it.hasNext()) {
                                if (Intrinsics.b(it.next().getGroupId(), value.getGroupId())) {
                                    i11 = i12;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i11 < 0) {
                            return;
                        }
                        RoomListAdapter roomListAdapterD2 = roomMyListFragment.d1();
                        if (roomListAdapterD2 != null) {
                            roomListAdapterD2.k0(i11);
                        }
                        RoomListAdapter roomListAdapterD3 = roomMyListFragment.d1();
                        List<RoomItem> listD2 = roomListAdapterD3 != null ? roomListAdapterD3.D() : null;
                        if (listD2 == null || listD2.isEmpty()) {
                            roomMyListFragment.a1();
                        }
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }
}
