package com.transsion.usercenter.profile.see;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.publish.bean.SubjectCollection;
import com.transsion.share.bean.PostType;
import com.transsion.usercenter.profile.see.bean.ProfileSeeMultiItemData;
import com.transsion.usercenter.profile.see.bean.ProfileSeeSubjectItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import e9.a;
import h9.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import uo.b;

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
public final class ProfileSeeListFragment extends BaseListFragment<e9.a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f59616t = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f59618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f59619r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f59620s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileSeeListFragment a(int i11, String str, String str2) {
            ProfileSeeListFragment profileSeeListFragment = new ProfileSeeListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("load_type", i11);
            bundle.putString("load_user_id", str);
            bundle.putString("load_title_txt", str2);
            profileSeeListFragment.setArguments(bundle);
            return profileSeeListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59621a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59621a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59621a;
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
            this.f59621a.invoke(obj);
        }
    }

    public ProfileSeeListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f59617p = FragmentViewModelLazyKt.a(this, Reflection.b(ProfileSeeViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f59620s = 1;
    }

    private final void A1() {
        z1().m().j(this, new b(new Function1<ProfileSeeMultiItemData, Unit>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment$initSeeListLiveData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileSeeMultiItemData profileSeeMultiItemData) {
                invoke2(profileSeeMultiItemData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileSeeMultiItemData profileSeeMultiItemData) {
                List<a> items;
                Pager pager;
                if (profileSeeMultiItemData != null && (pager = profileSeeMultiItemData.getPager()) != null) {
                    ProfileSeeListFragment profileSeeListFragment = this.this$0;
                    if (Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
                        profileSeeListFragment.j1();
                    } else {
                        BaseListFragment.l1(profileSeeListFragment, false, 1, null);
                    }
                }
                if (profileSeeMultiItemData == null || (items = profileSeeMultiItemData.getItems()) == null) {
                    this.this$0.v1();
                    return;
                }
                ProfileSeeListFragment profileSeeListFragment2 = this.this$0;
                if (!profileSeeListFragment2.h1()) {
                    BaseQuickAdapter<a, BaseViewHolder> baseQuickAdapterW0 = profileSeeListFragment2.W0();
                    if (baseQuickAdapterW0 != null) {
                        baseQuickAdapterW0.m(items);
                        return;
                    }
                    return;
                }
                profileSeeListFragment2.q1(false);
                if (items.isEmpty()) {
                    BaseListFragment.s1(profileSeeListFragment2, null, 1, null);
                    return;
                }
                BaseQuickAdapter<a, BaseViewHolder> baseQuickAdapterW1 = profileSeeListFragment2.W0();
                if (baseQuickAdapterW1 != null) {
                    baseQuickAdapterW1.w0(items);
                }
            }
        }));
    }

    private final void B1() {
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment$observeAddToDownload$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                BaseQuickAdapter<a, BaseViewHolder> baseQuickAdapterW0;
                List<a> listD;
                Intrinsics.g(value, "value");
                try {
                    BaseQuickAdapter<a, BaseViewHolder> baseQuickAdapterW1 = this.this$0.W0();
                    int i11 = -1;
                    if (baseQuickAdapterW1 != null && (listD = baseQuickAdapterW1.D()) != null) {
                        int i12 = 0;
                        for (a aVar : listD) {
                            if ((aVar instanceof ProfileSeeSubjectItem) && Intrinsics.b(((ProfileSeeSubjectItem) aVar).getSubjectId(), value.getSubjectId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 < 0 || (baseQuickAdapterW0 = this.this$0.W0()) == null) {
                        return;
                    }
                    baseQuickAdapterW0.notifyItemChanged(i11);
                } catch (Exception unused) {
                    b.a.g(b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        n1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<e9.a, BaseViewHolder> T0() {
        return new iz.a();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        String str = this.f59619r;
        return str == null ? "" : str;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        Function1<SubjectCollection, Unit> function1 = new Function1<SubjectCollection, Unit>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment.initListener.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubjectCollection subjectCollection) {
                invoke2(subjectCollection);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubjectCollection value) {
                Intrinsics.g(value, "value");
                ProfileSeeListFragment profileSeeListFragment = ProfileSeeListFragment.this;
                String subjectId = value.getSubjectId();
                if (subjectId == null) {
                    subjectId = "";
                }
                profileSeeListFragment.y1(new Pair(subjectId, null));
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = SubjectCollection.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        A1();
        z1().k().j(this, new b(new Function1<Pair<? extends String, ? extends PostType>, Unit>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends PostType> pair) {
                invoke2((Pair<String, ? extends PostType>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends PostType> pair) {
                if (pair != null) {
                    ProfileSeeListFragment.this.y1(pair);
                }
            }
        }));
        z1().j().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeListFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                FragmentActivity fragmentActivityRequireActivity = ProfileSeeListFragment.this.requireActivity();
                Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                if ((fragmentActivityRequireActivity instanceof ProfileSeeActivity) && ProfileSeeListFragment.this.f59620s == 1) {
                    Intrinsics.f(it, "it");
                    ((ProfileSeeActivity) fragmentActivityRequireActivity).r0(it.intValue());
                }
            }
        }));
        B1();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        ProfileSeeViewModel profileSeeViewModelZ1 = z1();
        String str = this.f59618q;
        if (str == null) {
            str = "";
        }
        profileSeeViewModelZ1.n(str, this.f59620s);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("movie_audio_archies", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        ProfileSeeViewModel profileSeeViewModelZ1 = z1();
        String str = this.f59618q;
        if (str == null) {
            str = "";
        }
        profileSeeViewModelZ1.o(str, this.f59620s);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f59618q = arguments != null ? arguments.getString("load_user_id") : null;
        Bundle arguments2 = getArguments();
        this.f59619r = arguments2 != null ? arguments2.getString("load_title_txt") : null;
        Bundle arguments3 = getArguments();
        this.f59620s = arguments3 != null ? arguments3.getInt("load_type", this.f59620s) : this.f59620s;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        String str = this.f59619r;
        return str == null ? "" : str;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        f fVarQ;
        super.v0();
        q1(true);
        BaseQuickAdapter<e9.a, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 == null || (fVarQ = baseQuickAdapterW0.Q()) == null) {
            return;
        }
        fVarQ.D(4);
    }

    public final void y1(Pair<String, ? extends PostType> pair) {
        List<e9.a> listD;
        BaseQuickAdapter<e9.a, BaseViewHolder> baseQuickAdapterW0;
        BaseQuickAdapter<e9.a, BaseViewHolder> baseQuickAdapterW1 = W0();
        if (baseQuickAdapterW1 == null || (listD = baseQuickAdapterW1.D()) == null) {
            return;
        }
        Iterator<e9.a> it = listD.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            Object obj = (e9.a) it.next();
            if ((pair.getSecond() == PostType.STAFF_TYPE && (obj instanceof Staff) && Intrinsics.b(((Staff) obj).getStaffId(), pair.getFirst())) || ((obj instanceof ProfileSeeSubjectItem) && Intrinsics.b(((ProfileSeeSubjectItem) obj).getSubjectId(), pair.getFirst()))) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 > 0) {
            if (pair.getSecond() != PostType.STAFF_TYPE) {
                SyncManager.f61414a.a().g(0, pair.getFirst());
            }
            BaseQuickAdapter<e9.a, BaseViewHolder> baseQuickAdapterW2 = W0();
            if (baseQuickAdapterW2 != null) {
                baseQuickAdapterW2.k0(i11);
            }
            int i12 = i11 - 1;
            if ((listD.get(i12) instanceof ProfileSeeTimeItem) && ((i11 >= listD.size() || (listD.get(i11) instanceof ProfileSeeTimeItem)) && (baseQuickAdapterW0 = W0()) != null)) {
                baseQuickAdapterW0.k0(i12);
            }
            BaseQuickAdapter<e9.a, BaseViewHolder> baseQuickAdapterW3 = W0();
            if (baseQuickAdapterW3 == null || baseQuickAdapterW3.getItemCount() <= 0) {
                BaseListFragment.s1(this, null, 1, null);
            }
        }
    }

    public final ProfileSeeViewModel z1() {
        return (ProfileSeeViewModel) this.f59617p.getValue();
    }
}
