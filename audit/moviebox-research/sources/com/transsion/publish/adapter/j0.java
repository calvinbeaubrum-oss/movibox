package com.transsion.publish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.view.ZoomImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class j0 extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhotoEntity> f56446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56447b;

    public j0(List<PhotoEntity> list) {
        this.f56446a = list != null ? CollectionsKt___CollectionsKt.M0(list) : null;
    }

    public final View a(Context context, int i11) {
        return LayoutInflater.from(context).inflate(i11, (ViewGroup) null, false);
    }

    public final void b(ZoomImageView zoomImageView, String str) {
        Glide.with(zoomImageView).load2(str).into(zoomImageView);
    }

    public final void c(List<PhotoEntity> list) {
        this.f56446a = list;
        this.f56447b = getCount();
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i11, Object object) {
        Intrinsics.g(container, "container");
        Intrinsics.g(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<PhotoEntity> list = this.f56446a;
        Intrinsics.d(list);
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        Intrinsics.g(object, "object");
        int i11 = this.f56447b;
        if (i11 <= 0) {
            return super.getItemPosition(object);
        }
        this.f56447b = i11 - 1;
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i11) {
        ViewParent parent;
        Intrinsics.g(container, "container");
        Context context = container.getContext();
        View viewA = context != null ? a(context, R$layout.item_travelga_image) : null;
        List<PhotoEntity> list = this.f56446a;
        Intrinsics.d(list);
        String localPath = list.get(i11).getLocalPath();
        View viewFindViewById = viewA != null ? viewA.findViewById(R$id.src_pic) : null;
        Intrinsics.e(viewFindViewById, "null cannot be cast to non-null type com.transsion.publish.view.ZoomImageView");
        ZoomImageView zoomImageView = (ZoomImageView) viewFindViewById;
        if (localPath != null) {
            b(zoomImageView, localPath);
        }
        if (viewA != null) {
            try {
                parent = viewA.getParent();
            } catch (Exception unused) {
            }
        } else {
            parent = null;
        }
        if (parent != null) {
            if ((viewA != null ? viewA.getParent() : null) instanceof ViewGroup) {
                ViewParent parent2 = viewA != null ? viewA.getParent() : null;
                Intrinsics.e(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent2).removeView(viewA);
            }
        }
        container.addView(viewA);
        return viewA;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.g(view, "view");
        Intrinsics.g(object, "object");
        return view == object;
    }
}
