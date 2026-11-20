package com.transsion.postdetail.shorttv.vskitstyle;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.v;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.shorttv.ShortTvBaseListFragment;
import com.transsion.shorttv.g;
import com.transsnet.downloader.util.ShortTvMmkv;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qx.d;
import qx.e;

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
public final class ShortTvListFragment extends ShortTvBaseListFragment {
    public static final a J = new a(null);
    public final b H = new b();
    public BiddingListManager I;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ShortTvMmkv.a {
        public b() {
        }

        @Override // com.transsnet.downloader.util.ShortTvMmkv.a
        public void a(String subjectId, int i11) {
            g gVarM0;
            List<e> listD;
            Intrinsics.g(subjectId, "subjectId");
            if (!Intrinsics.b(subjectId, ShortTvListFragment.this.P0()) || (gVarM0 = ShortTvListFragment.this.M0()) == null || (listD = gVarM0.D()) == null) {
                return;
            }
            for (e eVar : listD) {
                if (eVar instanceof d) {
                    d dVar = (d) eVar;
                    if (dVar.b() > i11) {
                        return;
                    } else {
                        dVar.g(true);
                    }
                }
            }
        }
    }

    private final void v1() {
        BiddingListManager biddingListManager = new BiddingListManager();
        nx.b mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f72177c : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("ShortTvListScene");
        biddingListManager.z(new Function2<Integer, c, Unit>() { // from class: com.transsion.postdetail.shorttv.vskitstyle.ShortTvListFragment$initAd$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            public final void invoke(int i11, c current) {
                List<e> listD;
                Intrinsics.g(current, "current");
                if (current != null) {
                    ShortTvListFragment shortTvListFragment = this.this$0;
                    qx.c cVar = new qx.c(current);
                    g gVarM0 = shortTvListFragment.M0();
                    if (i11 <= ((gVarM0 == null || (listD = gVarM0.D()) == null) ? 0 : listD.size())) {
                        g gVarM1 = shortTvListFragment.M0();
                        if (gVarM1 != null) {
                            gVarM1.j(i11, cVar);
                            return;
                        }
                        return;
                    }
                    g gVarM2 = shortTvListFragment.M0();
                    if (gVarM2 != null) {
                        gVarM2.l(cVar);
                    }
                }
            }
        });
        this.I = biddingListManager;
    }

    @Override // com.transsion.shorttv.ShortTvBaseListFragment
    public String getPageName() {
        return "minitv_play";
    }

    @Override // com.transsion.shorttv.ShortTvBaseListFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ShortTvMmkv.f61142a.g(this.H);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        ShortTvMmkv.f61142a.a(this.H);
        v1();
    }
}
