package com.transsnet.downloader.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class LocalFileBaseFragment extends AllHistoricalPlayRecordFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b1.b<String[]> f60835r;

    public LocalFileBaseFragment() {
        b1.b<String[]> bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.transsnet.downloader.fragment.o1
            @Override // b1.a
            public final void a(Object obj) {
                LocalFileBaseFragment.z1(this.f60946a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f60835r = bVarRegisterForActivityResult;
    }

    public static final void B1(LocalFileBaseFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
        if (!cVar.s(activity)) {
            this$0.f60835r.a(com.transsion.baselib.helper.c.f51185a.a());
        } else {
            this$0.f60834q = true;
            cVar.C();
        }
    }

    public static final void z1(LocalFileBaseFragment this$0, Map result) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(result, "result");
        if (!com.transsion.baselib.helper.c.f51185a.c(this$0.requireContext())) {
            this$0.A1();
        } else {
            this$0.K0();
            this$0.h1().A();
        }
    }

    public final void A1() {
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.fragment_no_permission_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.p1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalFileBaseFragment.B1(this.f60949a, view);
            }
        });
        com.transsnet.downloader.adapter.a aVarG1 = g1();
        if (aVarG1 != null) {
            Intrinsics.f(inflate, "inflate");
            aVarG1.r0(inflate);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f60834q) {
            this.f60834q = false;
            h1().A();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        return LayoutInflater.from(requireContext()).inflate(R$layout.adapter_empty_local_file_layout, (ViewGroup) null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        if (com.transsnet.downloader.viewmodel.c.f61276a.a()) {
            return;
        }
        A1();
    }
}
