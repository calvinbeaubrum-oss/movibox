package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.bumptech.glide.Glide;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class StillsFragment extends BaseFragment<tu.n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f53548a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StillsFragment a(Cover cover) {
            Intrinsics.g(cover, "cover");
            StillsFragment stillsFragment = new StillsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("cover", cover);
            stillsFragment.setArguments(bundle);
            return stillsFragment;
        }
    }

    public static final void j0(Cover cover, StillsFragment this$0, View view) {
        Intrinsics.g(cover, "$cover");
        Intrinsics.g(this$0, "this$0");
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        Integer height = cover.getHeight();
        imageInfo.imageViewHeight = height != null ? height.intValue() : 0.0f;
        Integer width = cover.getWidth();
        imageInfo.imageViewWidth = width != null ? width.intValue() : 0.0f;
        List<? extends ImageInfo> listQ = kotlin.collections.g.q(imageInfo);
        ImagePreviewActivity.a aVar = ImagePreviewActivity.Companion;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        aVar.a(contextRequireContext, 0, listQ);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public tu.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.n nVarC = tu.n.c(inflater);
        Intrinsics.f(nVarC, "inflate(inflater)");
        return nVarC;
    }

    public final void i0(final Cover cover) {
        final tu.n mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            int iF = com.transsion.core.utils.e.f();
            ImageHelper.Companion companion = ImageHelper.f51371a;
            String url = cover.getUrl();
            if (url == null) {
                url = "";
            }
            String strE = companion.e(url, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
            String thumbnail = cover.getThumbnail();
            BlurHashHelper.b(BlurHashHelper.f51391a, thumbnail == null ? "" : thumbnail, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.moviedetail.fragment.StillsFragment$showCover$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BitmapDrawable bitmapDrawable) {
                    invoke2(bitmapDrawable);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BitmapDrawable it) {
                    Intrinsics.g(it, "it");
                    mViewBinding.f77545b.setImageDrawable(it);
                }
            }, 6, null);
            Glide.with(requireContext()).load2(strE).into(mViewBinding.f77546c);
            mViewBinding.f77546c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StillsFragment.j0(cover, this, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        Bundle arguments = getArguments();
        Cover cover = (Cover) (arguments != null ? arguments.getSerializable("cover") : null);
        if (cover != null) {
            i0(cover);
        }
    }
}
