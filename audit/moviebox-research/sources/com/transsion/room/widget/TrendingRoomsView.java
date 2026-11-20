package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.room.R$layout;
import com.transsion.room.api.RoomsViewType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sw.z;

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
public final class TrendingRoomsView extends RoomsBaseView<z> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TrendingRoomsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TrendingRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TrendingRoomsView(Context context, AttributeSet attributeSet, int i11) {
        AppCompatTextView appCompatTextView;
        View view;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_trending_rooms, this);
        setMViewBinding(z.a(this));
        initRecyclerView();
        getMAdapter().L0(RoomsViewType.TYPE_TRENDING);
        z mViewBinding = getMViewBinding();
        if (mViewBinding != null && (view = mViewBinding.f76631b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TrendingRoomsView.r(this.f57387a, view2);
                }
            });
        }
        z mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appCompatTextView = mViewBinding2.f76634f) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TrendingRoomsView.s(this.f57388a, view2);
            }
        });
    }

    public /* synthetic */ TrendingRoomsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void r(TrendingRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.m();
    }

    public static final void s(TrendingRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.n();
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public RecyclerView getRecyclerView() {
        z mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76632c;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public AppCompatTextView getTitleView() {
        z mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76635g;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public void initRecyclerView() {
        RecyclerView recyclerView;
        z mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f76632c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3, 1, false));
        recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), 0, 0));
        recyclerView.setAdapter(getMAdapter());
    }
}
