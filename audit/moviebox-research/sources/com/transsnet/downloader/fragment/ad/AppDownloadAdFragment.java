package com.transsnet.downloader.fragment.ad;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.LazyFragment;
import h00.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;

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
public final class AppDownloadAdFragment extends LazyFragment<u> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WrapperIconAdManager f60887o = new WrapperIconAdManager();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<WrapperIconBean> f60888p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final WrapperAdListener f60889q = new WrapperAdListener() { // from class: com.transsnet.downloader.fragment.ad.AppDownloadAdFragment$listener$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.ad.middle.WrapperAdListener
        public void onWrapperIconReady(List<WrapperIconBean> list) {
            AppCompatTextView appCompatTextView;
            super.onWrapperIconReady(list);
            com.transsion.ad.a.B(com.transsion.ad.a.f50276a, this.this$0.j0() + " --> onWrapperIconReady() --> 获取到数据 --> 展示数据", false, 2, null);
            this.this$0.f60888p.clear();
            if (list != null && (!list.isEmpty())) {
                this.this$0.f60888p.addAll(list);
            }
            a aVar = this.this$0.f60890r;
            if (aVar != null) {
                aVar.w0(this.this$0.f60888p);
            }
            u uVar = (u) this.this$0.getMViewBinding();
            if (uVar != null && (appCompatTextView = uVar.f66036f) != null) {
                AppDownloadAdFragment appDownloadAdFragment = this.this$0;
                if (true ^ appDownloadAdFragment.f60888p.isEmpty()) {
                    appCompatTextView.setVisibility(0);
                    appCompatTextView.setText(String.valueOf(appDownloadAdFragment.f60888p.size()));
                } else {
                    appCompatTextView.setVisibility(8);
                }
            }
            u uVar2 = (u) this.this$0.getMViewBinding();
            FrameLayout frameLayout = uVar2 != null ? uVar2.f66034c : null;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(this.this$0.f60888p.isEmpty() ? 8 : 0);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.transsnet.downloader.fragment.ad.a f60890r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f60891a;

        public a(boolean z11) {
            this.f60891a = z11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                boolean z11 = this.f60891a;
                if (childAdapterPosition == 0) {
                    if (z11) {
                        outRect.right = f0.a(12.0f);
                        outRect.left = f0.a(8.0f);
                    } else {
                        outRect.left = f0.a(12.0f);
                        outRect.right = f0.a(8.0f);
                    }
                    outRect.bottom = f0.a(12.0f);
                    return;
                }
                if (childAdapterPosition == adapter.getItemCount() - 1) {
                    if (z11) {
                        outRect.left = f0.a(12.0f);
                    } else {
                        outRect.right = f0.a(12.0f);
                    }
                    outRect.bottom = f0.a(12.0f);
                    return;
                }
                if (z11) {
                    outRect.left = f0.a(8.0f);
                } else {
                    outRect.right = f0.a(8.0f);
                }
                outRect.bottom = f0.a(12.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X0() {
        RecyclerView recyclerView;
        u uVar = (u) getMViewBinding();
        if (uVar == null || (recyclerView = uVar.f66033b) == null) {
            return;
        }
        com.transsnet.downloader.fragment.ad.a aVar = new com.transsnet.downloader.fragment.ad.a(this.f60887o);
        this.f60890r = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        recyclerView.addItemDecoration(new a(TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, j0() + " --> loadDefaultData() --> 开始加载数据", false, 2, null);
        j.d(v.a(this), null, null, new AppDownloadAdFragment$loadDefaultData$1(this, null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void V0() {
        if (!this.f60888p.isEmpty()) {
            return;
        }
        B0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public u getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        u uVarC = u.c(inflater);
        Intrinsics.f(uVarC, "inflate(inflater)");
        return uVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("AppDownloadAdFragment", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        List<WrapperIconBean> listD;
        TAdNativeInfo nativeInfo;
        super.onDestroy();
        this.f60887o.destroy();
        com.transsnet.downloader.fragment.ad.a aVar = this.f60890r;
        if (aVar == null || (listD = aVar.D()) == null) {
            return;
        }
        for (WrapperIconBean wrapperIconBean : listD) {
            if (wrapperIconBean.getType() == 2 && (nativeInfo = wrapperIconBean.getNativeInfo()) != null) {
                nativeInfo.release();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        X0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
