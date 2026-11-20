package com.transsion.baseui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class BaseFragment<T extends n6.a> extends Fragment implements e {
    public static final int $stable = 8;
    private boolean isFirst = true;
    private final Lazy logViewConfig$delegate = LazyKt__LazyJVMKt.b(new Function0<h>(this) { // from class: com.transsion.baseui.fragment.BaseFragment$logViewConfig$2
        final /* synthetic */ BaseFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            return this.this$0.newLogViewConfig();
        }
    });
    private T mViewBinding;
    private g netListener;

    private final void onVisible() {
        if (this.isFirst) {
            this.isFirst = false;
            lazyLoadData();
        }
    }

    private final void registerNetwork() {
        f.f49475a.l(this.netListener);
    }

    private final void unregisterNetwork() {
        f.f49475a.m(this.netListener);
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.logViewConfig$delegate.getValue();
    }

    public final T getMViewBinding() {
        return this.mViewBinding;
    }

    public final g getNetListener() {
        return this.netListener;
    }

    public abstract T getViewBinding(LayoutInflater layoutInflater);

    public void hideLoading() {
    }

    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    public void initListener() {
    }

    public abstract void initView(View view, Bundle bundle);

    public final boolean isFirst() {
        return this.isFirst;
    }

    public abstract void lazyLoadData();

    public void logPause() {
        e.a.b(this);
    }

    public void logResume() {
        e.a.c(this);
    }

    public void newIntent(Intent intent) {
    }

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isFirst = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        T t11 = (T) getViewBinding(inflater);
        this.mViewBinding = t11;
        if (t11 != null) {
            return t11.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mViewBinding = null;
        unregisterNetwork();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        logResume();
        onVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        initView(view, bundle);
        initData(view, bundle);
        initListener();
        registerNetwork();
    }

    public final void setFirst(boolean z11) {
        this.isFirst = z11;
    }

    public final void setMViewBinding(T t11) {
        this.mViewBinding = t11;
    }

    public final void setNetListener(g gVar) {
        this.netListener = gVar;
    }

    public void startLoading() {
    }
}
