package com.transsion.ad.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestAdNativeListActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.i f50625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f50626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BiddingListManager f50627c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends BaseProviderMultiAdapter<b> implements h9.j {
        public a() {
            super(null, 1, null);
            K0(new c());
            K0(new d());
        }

        @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
        public int S0(List<? extends b> data, int i11) {
            Intrinsics.g(data, "data");
            return data.get(i11).a() != null ? 2 : 1;
        }

        @Override // h9.j
        public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
            return h9.i.a(this, baseQuickAdapter);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f50628c = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.transsion.ad.bidding.nativead.c f50630b;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String title, com.transsion.ad.bidding.nativead.c cVar) {
            Intrinsics.g(title, "title");
            this.f50629a = title;
            this.f50630b = cVar;
        }

        public final com.transsion.ad.bidding.nativead.c a() {
            return this.f50630b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f50629a, bVar.f50629a) && Intrinsics.b(this.f50630b, bVar.f50630b);
        }

        public int hashCode() {
            int iHashCode = this.f50629a.hashCode() * 31;
            com.transsion.ad.bidding.nativead.c cVar = this.f50630b;
            return iHashCode + (cVar == null ? 0 : cVar.hashCode());
        }

        public String toString() {
            return "TestAdNativeListBean(title=" + this.f50629a + ", adManager=" + this.f50630b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends BaseItemProvider<b> {
        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 2;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.test_ad_native_list_ad_item_layout;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, b item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            n nVar = new n(g());
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) helper.getViewOrNull(R$id.nativeView);
            if (nativeWrapperAdView != null) {
                nativeWrapperAdView.bindNativeView(item.a(), nVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends BaseItemProvider<b> {
        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.test_ad_native_list_content_item_layout;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, b item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
        }
    }

    public static final void R(TestAdNativeListActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.S();
    }

    private final void S() {
        kotlinx.coroutines.j.d(v.a(this), null, null, new TestAdNativeListActivity$loadMore$1(this, null), 3, null);
    }

    public final void O() {
        BiddingListManager biddingListManager = new BiddingListManager();
        pq.i iVar = this.f50625a;
        if (iVar == null) {
            Intrinsics.y("binding");
            iVar = null;
        }
        biddingListManager.F(iVar.f74028b);
        biddingListManager.A(v.a(this));
        biddingListManager.G("MBNativeTestId");
        biddingListManager.B(new LinkedHashMap());
        biddingListManager.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.ad.test.TestAdNativeListActivity$initAd$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                List<TestAdNativeListActivity.b> listD;
                Intrinsics.g(current, "current");
                TestAdNativeListActivity.a aVar = this.this$0.f50626b;
                int size = (aVar == null || (listD = aVar.D()) == null) ? 0 : listD.size();
                TestAdNativeListActivity.b bVar = new TestAdNativeListActivity.b("", current);
                if (i11 < size) {
                    TestAdNativeListActivity.a aVar2 = this.this$0.f50626b;
                    if (aVar2 != null) {
                        aVar2.j(i11, bVar);
                        return;
                    }
                    return;
                }
                TestAdNativeListActivity.a aVar3 = this.this$0.f50626b;
                if (aVar3 != null) {
                    aVar3.l(bVar);
                }
            }
        });
        this.f50627c = biddingListManager;
    }

    public final void Q() {
        pq.i iVar = this.f50625a;
        if (iVar == null) {
            Intrinsics.y("binding");
            iVar = null;
        }
        RecyclerView recyclerView = iVar.f74028b;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        a aVar = new a();
        aVar.Q().y(true);
        aVar.Q().A(true);
        aVar.Q().C(new f9.f() { // from class: com.transsion.ad.test.m
            @Override // f9.f
            public final void a() {
                TestAdNativeListActivity.R(this.f50654a);
            }
        });
        this.f50626b = aVar;
        recyclerView.setAdapter(aVar);
        S();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.i iVarC = pq.i.c(getLayoutInflater());
        Intrinsics.f(iVarC, "inflate(layoutInflater)");
        this.f50625a = iVarC;
        if (iVarC == null) {
            Intrinsics.y("binding");
            iVarC = null;
        }
        setContentView(iVarC.getRoot());
        O();
        Q();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.f50627c;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }
}
