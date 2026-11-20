package com.transsion.room.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$string;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class RoomsFragment extends BaseListFragment<RoomItem> implements r00.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f57229v = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RoomViewModel f57230p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f57234t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f57231q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f57232r = 10;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f57233s = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f57235u = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.fragment.RoomsFragment$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomsFragment a(String str, boolean z11) {
            RoomsFragment roomsFragment = new RoomsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("m_User_Id", str);
            bundle.putBoolean("is_Self", z11);
            roomsFragment.setArguments(bundle);
            return roomsFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57236a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57236a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57236a;
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
            this.f57236a.invoke(obj);
        }
    }

    public static final void A1(com.transsion.room.adapter.a this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withParcelable(WebConstants.FIELD_ITEM, this_apply.getItem(i11)).navigation();
    }

    private final ILoginApi z1() {
        Object value = this.f57235u.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        RoomViewModel roomViewModel = this.f57230p;
        if (roomViewModel != null) {
            roomViewModel.t(this.f57231q, this.f57232r, this.f57233s);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        n1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<RoomItem, BaseViewHolder> T0() {
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        String string = getString(R$string.str_room_title);
        Intrinsics.f(string, "getString(R.string.str_room_title)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void e1() {
        RecyclerView recyclerView;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3, 1, false));
        int iA = com.blankj.utilcode.util.f0.a(8.0f);
        int i11 = iA / 2;
        recyclerView.addItemDecoration(new tw.a(iA, i11, i11));
        final com.transsion.room.adapter.a aVar2 = new com.transsion.room.adapter.a(new ArrayList());
        aVar2.B0(new f9.d() { // from class: com.transsion.room.fragment.n0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                RoomsFragment.A1(aVar2, baseQuickAdapter, view, i12);
            }
        });
        p1(aVar2);
        recyclerView.setAdapter(W0());
        if (f1()) {
            BaseQuickAdapter<RoomItem, BaseViewHolder> baseQuickAdapterW0 = W0();
            recyclerView.addOnScrollListener(new hs.a(baseQuickAdapterW0 != null ? baseQuickAdapterW0.Q() : null));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        if (TextUtils.isEmpty(this.f57231q) || TextUtils.equals("0", this.f57231q)) {
            BaseListFragment.l1(this, false, 1, null);
        } else {
            B0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        RoomViewModel roomViewModel = (RoomViewModel) new v0(this).a(RoomViewModel.class);
        roomViewModel.u().j(this, new b(new Function1<RoomBean, Unit>() { // from class: com.transsion.room.fragment.RoomsFragment$initViewModel$1$1
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
                List<RoomItem> items;
                Pager pager;
                if (roomBean != null && (pager = roomBean.getPager()) != null) {
                    RoomsFragment roomsFragment = this.this$0;
                    if (Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
                        String nextPage = pager.getNextPage();
                        if (nextPage == null) {
                            nextPage = "";
                        }
                        roomsFragment.f57231q = nextPage;
                        Integer perPage = pager.getPerPage();
                        roomsFragment.f57232r = perPage != null ? perPage.intValue() : 10;
                        roomsFragment.j1();
                    } else {
                        BaseListFragment.l1(roomsFragment, false, 1, null);
                    }
                }
                if (roomBean == null || (items = roomBean.getItems()) == null) {
                    this.this$0.v1();
                    return;
                }
                RoomsFragment roomsFragment2 = this.this$0;
                if (!roomsFragment2.h1()) {
                    BaseQuickAdapter<RoomItem, BaseViewHolder> baseQuickAdapterW0 = roomsFragment2.W0();
                    if (baseQuickAdapterW0 != null) {
                        baseQuickAdapterW0.m(items);
                        return;
                    }
                    return;
                }
                roomsFragment2.q1(false);
                BaseQuickAdapter<RoomItem, BaseViewHolder> baseQuickAdapterW1 = roomsFragment2.W0();
                if (baseQuickAdapterW1 != null) {
                    baseQuickAdapterW1.w0(items);
                }
                if (items.isEmpty()) {
                    BaseListFragment.s1(roomsFragment2, null, 1, null);
                }
            }
        }));
        this.f57230p = roomViewModel;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.not_in_any_rooms);
        Intrinsics.f(string, "getString(R.string.not_in_any_rooms)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("myrooms", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        this.f57231q = "";
        q1(true);
        B0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f57233s = arguments.getString("m_User_Id");
            this.f57234t = arguments.getBoolean("is_Self", false);
            if (TextUtils.isEmpty(this.f57233s)) {
                UserInfo userInfoP = z1().P();
                this.f57233s = userInfoP != null ? userInfoP.getUserId() : null;
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        z1().t1(this);
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        this.f57233s = user.getUserId();
        o1();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        q1(true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
