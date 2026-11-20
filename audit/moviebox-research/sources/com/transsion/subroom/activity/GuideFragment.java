package com.transsion.subroom.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.f0;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.subroom.R$string;
import com.transsion.subroom.guide.GuideStepEnum;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.r;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GuideFragment extends BaseFragment<tx.d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f57987b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57988a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GuideFragment a(int i11) {
            Bundle bundleB = androidx.core.os.c.b(TuplesKt.a("guide_step", Integer.valueOf(i11)));
            GuideFragment guideFragment = new GuideFragment();
            guideFragment.setArguments(bundleB);
            return guideFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.tn.lib.util.networkinfo.g {
        public b() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            LinearLayoutCompat linearLayoutCompat;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            tx.d mViewBinding = GuideFragment.this.getMViewBinding();
            if (mViewBinding == null || (linearLayoutCompat = mViewBinding.f78072g) == null) {
                return;
            }
            so.c.g(linearLayoutCompat);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
            LinearLayoutCompat linearLayoutCompat;
            tx.d mViewBinding = GuideFragment.this.getMViewBinding();
            if (mViewBinding == null || (linearLayoutCompat = mViewBinding.f78072g) == null) {
                return;
            }
            so.c.k(linearLayoutCompat);
        }
    }

    public static final void i0(GuideFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.SETTINGS"));
        com.transsion.baselib.report.m.f51277a.m("guide", "click", r.f(TuplesKt.a("module_name", "setting")));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public tx.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tx.d dVarC = tx.d.c(inflater);
        Intrinsics.f(dVarC, "inflate(inflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        setNetListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        so.c.e(view);
        tx.d mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (displayMetrics.heightPixels / displayMetrics.density < 640.0f) {
                ViewGroup.LayoutParams layoutParams = mViewBinding.f78070d.getLayoutParams();
                layoutParams.height = f0.a(288.0f);
                mViewBinding.f78070d.setLayoutParams(layoutParams);
            }
            uo.b.a.f(uo.b.f78622a, "GuideFragment", "width=" + displayMetrics.widthPixels + " height=" + displayMetrics.heightPixels + " density=" + displayMetrics.density, false, 4, null);
            if (this.f57988a == GuideStepEnum.GUIDE_STEP_1.ordinal()) {
                mViewBinding.f78070d.setImageResource(R$mipmap.ic_guide1);
                View bgTransparent = mViewBinding.f78068b;
                Intrinsics.f(bgTransparent, "bgTransparent");
                so.c.k(bgTransparent);
                mViewBinding.f78071f.setText(getString(R$string.guide_title1));
                mViewBinding.f78069c.setText(getString(R$string.guide_desc1));
            } else {
                mViewBinding.f78070d.setImageResource(R$mipmap.ic_guide2);
                View bgTransparent2 = mViewBinding.f78068b;
                Intrinsics.f(bgTransparent2, "bgTransparent");
                so.c.g(bgTransparent2);
                mViewBinding.f78071f.setText(getString(R$string.guide_title2));
                mViewBinding.f78069c.setText(getString(R$string.guide_desc2));
            }
            mViewBinding.f78074i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.activity.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuideFragment.i0(this.f58030a, view2);
                }
            });
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                return;
            }
            LinearLayoutCompat llNoNetwork = mViewBinding.f78072g;
            Intrinsics.f(llNoNetwork, "llNoNetwork");
            so.c.k(llNoNetwork);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f57988a = arguments != null ? arguments.getInt("guide_step", 0) : 0;
    }
}
