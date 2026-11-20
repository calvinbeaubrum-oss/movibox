package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.api.RoomsViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sw.x;

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
public final class RecommendRoomsView extends RoomsBaseView<x> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendRoomsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendRoomsView(Context context, AttributeSet attributeSet, int i11) {
        AppCompatTextView appCompatTextView;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_recommend_rooms, this);
        setMViewBinding(x.a(this));
        setPadding(0, gs.a.a(12), 0, gs.a.a(12));
        initRecyclerView();
        getMAdapter().L0(RoomsViewType.TYPE_ROOM_HOME);
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f76624c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendRoomsView.q(this.f57379a, view);
            }
        });
    }

    public /* synthetic */ RecommendRoomsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void q(RecommendRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.n();
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public RecyclerView getRecyclerView() {
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76623b;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public AppCompatTextView getTitleView() {
        x mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76625d;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public void initRecyclerView() {
    }

    public final void r(int i11) {
        RecyclerView recyclerView;
        x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f76623b) == null) {
            return;
        }
        if (recyclerView.getItemDecorationCount() != 0) {
            recyclerView.removeItemDecorationAt(0);
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (i11 >= 8) {
            getMAdapter().M0(false);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(0);
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 2, 0, false));
            recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), gs.a.a(12), gs.a.a(12)));
        } else if (i11 > 3) {
            getMAdapter().M0(false);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(0);
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        } else {
            getMAdapter().M0(true);
            marginLayoutParams.setMarginStart(gs.a.a(8));
            marginLayoutParams.setMarginEnd(gs.a.a(8));
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
            recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), 0, 0));
        }
        recyclerView.setLayoutParams(marginLayoutParams);
        recyclerView.setAdapter(getMAdapter());
    }

    @Override // com.transsion.room.widget.RoomsBaseView, rw.b
    public void setList(List<RoomItem> dataList) {
        Intrinsics.g(dataList, "dataList");
        r(dataList.size());
        super.setList(dataList);
    }
}
