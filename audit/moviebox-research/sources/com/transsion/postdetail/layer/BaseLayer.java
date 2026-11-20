package com.transsion.postdetail.layer;

import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public abstract class BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f55072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f55073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PostSubjectItem f55074d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f55075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ORPlayerView f55076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f55077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f55078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f55079j;

    public BaseLayer(final Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f55071a = getClass().getSimpleName();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f55075f = FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$3
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
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final void E(LayerFlag flag, Object... params) {
        Intrinsics.g(flag, "flag");
        Intrinsics.g(params, "params");
        a aVar = this.f55078i;
        if (aVar != null) {
            aVar.h(flag, Arrays.copyOf(params, params.length));
        }
    }

    public final ImageView F() {
        return this.f55077h;
    }

    public final f G() {
        return this.f55072b;
    }

    public final ORPlayerView H() {
        return this.f55076g;
    }

    public final boolean I() {
        return this.f55079j;
    }

    public final void J(ImageView imageView) {
        this.f55077h = imageView;
    }

    public final void K(a aVar) {
        this.f55078i = aVar;
    }

    public void L(f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55071a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPlayer----->", false, 4, null);
        this.f55072b = orPlayer;
        this.f55076g = orPlayerView;
    }

    public final void M(String postId, PostSubjectItem postSubjectItem) {
        Intrinsics.g(postId, "postId");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55071a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPostData----->", false, 4, null);
        this.f55073c = postId;
        this.f55074d = postSubjectItem;
    }

    public final void N(String str) {
        this.f55073c = str;
    }

    public final void O(boolean z11) {
        this.f55079j = z11;
    }
}
