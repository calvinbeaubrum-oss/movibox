package com.transsion.play.detail;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.api.IStreamDetailService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f54193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Subject f54195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f54198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54199g;

    public b(Fragment fragment, int i11, Subject subject, String pageName, String str, boolean z11, boolean z12) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(pageName, "pageName");
        this.f54193a = fragment;
        this.f54194b = i11;
        this.f54195c = subject;
        this.f54196d = pageName;
        this.f54197e = str;
        this.f54198f = z11;
        this.f54199g = z12;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "fragment.childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.replace(i11, ((IStreamDetailService) com.alibaba.android.arouter.launcher.a.d().h(IStreamDetailService.class)).t0(subject, pageName, str, z11, z12));
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public /* synthetic */ b(Fragment fragment, int i11, Subject subject, String str, String str2, boolean z11, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, i11, subject, str, str2, (i12 & 32) != 0 ? false : z11, (i12 & 64) != 0 ? false : z12);
    }
}
