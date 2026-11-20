package com.transsion.search.fragment.values;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import bx.k;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.report.h;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchValuesRelatedCollectionEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.constant.SearchConstants;
import com.transsion.search.fragment.SearchSubjectFragment;
import java.util.ArrayList;
import java.util.HashMap;
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
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
public final class SearchValuesFragment extends PageStatusFragment<k> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f57605t = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f57606u = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<VerticalRank> f57607k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f57612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ResourcesRequestView f57613q;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f57608l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f57609m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f57610n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<SearchValuesRelatedCollectionEntity> f57611o = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f57614r = LazyKt__LazyJVMKt.b(new Function0<com.transsion.search.net.a>() { // from class: com.transsion.search.fragment.values.SearchValuesFragment$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.search.net.a invoke() {
            return (com.transsion.search.net.a) NetServiceGenerator.f49399d.a().i(com.transsion.search.net.a.class);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c0<PostEntity> f57615s = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return SearchValuesFragment.f57606u;
        }

        public final void b(String str, String str2, String str3, String str4, int i11, int i12, String str5, String str6) {
            HashMap map = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            map.put("subject_id", str2);
            if (str == null) {
                str = "";
            }
            map.put("group_id", str);
            map.put("sequence", String.valueOf(i11));
            if (str4 == null) {
                str4 = "";
            }
            map.put("ops", str4);
            if (str3 == null) {
                str3 = "";
            }
            map.put("staff_id", str3);
            map.put("type", String.valueOf(i12));
            if (str5 != null && str5.length() > 0) {
                map.put("trid", str5);
            }
            if (str6 != null && str6.length() > 0) {
                map.put("season", str6.toString());
            }
            com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
        }

        public final void d(String str, String str2, String str3, String str4, int i11, int i12) {
            HashMap map = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            map.put("subject_id", str2);
            if (str == null) {
                str = "";
            }
            map.put("group_id", str);
            map.put("sequence", String.valueOf(i11));
            if (str4 == null) {
                str4 = "";
            }
            map.put("ops", str4);
            if (str3 == null) {
                str3 = "";
            }
            map.put("staff_id", str3);
            map.put("type", String.valueOf(i12));
            if (a().length() > 0) {
                map.put("trid", a());
            }
            com.transsion.baselib.helper.a.f51183a.a("searchresult", map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<PostEntity> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            uo.b.a.j(uo.b.f78622a, AppLovinEventTypes.USER_EXECUTED_SEARCH, "SearchValuesFragment --> postRequestResource --> failed to post request resources " + str2, false, 4, null);
            SearchValuesFragment.this.X0().n(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostEntity postEntity) {
            if (postEntity != null) {
                SearchValuesFragment.this.X0().n(postEntity);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57617a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57617a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57617a;
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
            this.f57617a.invoke(obj);
        }
    }

    public static final void b1(SearchValuesFragment this$0, ResourcesRequestView requestView, View view) {
        Intrinsics.g(this$0, "this$0");
        lw.c.f70578a.c(this$0, NoticePermissionFrom.DETAIL_NO_RES);
        e1(this$0, this$0.f57608l, false, 2, null);
        Integer num = this$0.f57612p;
        if (num != null) {
            Intrinsics.d(num);
            this$0.f57612p = Integer.valueOf(num.intValue() + 1);
            Intrinsics.f(requestView, "requestView");
            Integer num2 = this$0.f57612p;
            Intrinsics.d(num2);
            ResourcesRequestView.setCount$default(requestView, num2.intValue(), false, 2, null);
        }
    }

    public static final void c1(SearchValuesFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0();
    }

    public static /* synthetic */ void e1(SearchValuesFragment searchValuesFragment, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        searchValuesFragment.d1(str, z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        if (this.f57607k == null) {
            Fragment parentFragment = getParentFragment();
            SearchSubjectFragment searchSubjectFragment = parentFragment instanceof SearchSubjectFragment ? (SearchSubjectFragment) parentFragment : null;
            if (searchSubjectFragment != null) {
                searchSubjectFragment.E0("");
            }
        }
    }

    public final String W0() {
        String string = SearchConstants.f57439a.b().getString("mCopyKeyWord", "");
        return string == null ? "" : string;
    }

    public final c0<PostEntity> X0() {
        return this.f57615s;
    }

    public final com.transsion.search.net.a Y0() {
        return (com.transsion.search.net.a) this.f57614r.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public k getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        k kVarC = k.c(inflater);
        Intrinsics.f(kVarC, "inflate(inflater)");
        return kVarC;
    }

    public final View a1() {
        String str;
        DrawableCenterTextView drawableCenterTextView;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            View view = getLayoutInflater().inflate(R$layout.view_search_no_network, (ViewGroup) null);
            TextView textView = (TextView) view.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_tips);
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_retry);
            textView.setText(R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.values.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchValuesFragment.c1(this.f57634a, view2);
                }
            });
            Intrinsics.f(view, "view");
            return view;
        }
        View view2 = getLayoutInflater().inflate(R$layout.view_search_empty, (ViewGroup) null);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) view2.findViewById(R$id.resources_request);
        this.f57613q = resourcesRequestView;
        if (this.f57608l.length() > 10) {
            String strSubstring = this.f57608l.substring(0, 10);
            Intrinsics.f(strSubstring, "substring(...)");
            str = strSubstring + "...";
        } else {
            str = this.f57608l;
        }
        String string = getString(com.transsion.search.R$string.search_value_no_result, str);
        Intrinsics.f(string, "getString(R.string.searc…value_no_result, keyword)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        d1(this.f57608l, true);
        fs.f mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (drawableCenterTextView = mViewBinding.f65283f) != null) {
            drawableCenterTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.values.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SearchValuesFragment.b1(this.f57632a, resourcesRequestView, view3);
                }
            });
        }
        Intrinsics.f(view2, "view");
        return view2;
    }

    public final void d1(String str, boolean z11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CampaignEx.JSON_KEY_AD_Q, str);
        jsonObject.addProperty("before", Boolean.valueOf(z11));
        this.f57612p = z11 ? null : this.f57612p;
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "jsonObject.toString()");
        Y0().f(cp.a.f62775a.a(), companion.create(string, MediaType.Companion.parse("application/json"))).A(q10.a.b()).subscribe(new b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        this.f57615s.j(this, new c(new Function1<PostEntity, Unit>() { // from class: com.transsion.search.fragment.values.SearchValuesFragment.initListener.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostEntity postEntity) {
                invoke2(postEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostEntity postEntity) {
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.g(aVar, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, null);
                if (postEntity == null || SearchValuesFragment.this.f57612p != null) {
                    return;
                }
                uo.b.a.g(aVar, "count changed " + postEntity.getCount(), false, 2, null);
                SearchValuesFragment searchValuesFragment = SearchValuesFragment.this;
                int count = postEntity.getCount();
                if (count == null) {
                    count = 0;
                }
                searchValuesFragment.f57612p = count;
                ResourcesRequestView resourcesRequestView = SearchValuesFragment.this.f57613q;
                if (resourcesRequestView != null) {
                    Integer count2 = postEntity.getCount();
                    resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        Context context = getContext();
        return (context != null ? context.getString(com.transsion.search.R$string.user_works_empty) : null) + " \"" + this.f57608l + "\"";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        return a1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("searchresult", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f57609m = bundle.getString("mCopyKeyWord");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.f57608l.length() < 30) {
            outState.putString("mCopyKeyWord", this.f57608l);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return true;
    }
}
