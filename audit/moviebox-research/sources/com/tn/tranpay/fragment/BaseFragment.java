package com.tn.tranpay.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseFragment<T extends n6.a> extends Fragment implements hq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f50097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50098b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f50099c = LazyKt__LazyJVMKt.b(new Function0<hq.c>(this) { // from class: com.tn.tranpay.fragment.BaseFragment$logViewConfig$2
        final /* synthetic */ BaseFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final hq.c invoke() {
            return this.this$0.g0();
        }
    });

    public hq.c g0() {
        return hq.b.a.a(this);
    }

    @Override // hq.b
    public hq.c getLogViewConfig() {
        return (hq.c) this.f50099c.getValue();
    }

    public final T getMViewBinding() {
        return this.f50097a;
    }

    public abstract T getViewBinding(LayoutInflater layoutInflater);

    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    public abstract void initView(View view, Bundle bundle);

    public abstract void lazyLoadData();

    public void logPause() {
        hq.b.a.b(this);
    }

    public void logResume() {
        hq.b.a.c(this);
    }

    public void newIntent(Intent intent) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f50098b = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        T t11 = (T) getViewBinding(inflater);
        this.f50097a = t11;
        if (t11 != null) {
            return t11.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f50097a = null;
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
    }

    public final void onVisible() {
        if (this.f50098b) {
            this.f50098b = false;
            lazyLoadData();
        }
    }
}
