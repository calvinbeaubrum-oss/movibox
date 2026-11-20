package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.api.RoomsViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sw.w;

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
public final class CommunityRoomsView extends RoomsHomeBaseView<w> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityRoomsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommunityRoomsView(Context context, AttributeSet attributeSet, int i11) {
        AppCompatTextView appCompatTextView;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_community_rooms, this);
        setMViewBinding(w.a(this));
        setPadding(0, gs.a.a(12), 0, gs.a.a(12));
        initRecyclerView();
        getMAdapter().L0(RoomsViewType.TYPE_ROOM_HOME);
        w mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f76620c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommunityRoomsView.p(this.f57376a, view);
            }
        });
    }

    public /* synthetic */ CommunityRoomsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void p(CommunityRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.m();
    }

    private final void q(int i11) {
        RecyclerView recyclerView;
        w mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f76619b) == null) {
            return;
        }
        if (recyclerView.getItemDecorationCount() != 0) {
            recyclerView.removeItemDecorationAt(0);
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        getMAdapter().M0(false);
        marginLayoutParams.setMarginStart(0);
        marginLayoutParams.setMarginEnd(0);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new ro.e(16.0f, 0.0f, 12.0f, 2, null));
        recyclerView.setLayoutParams(marginLayoutParams);
        recyclerView.setAdapter(getMAdapter());
    }

    public final List<RoomItem> getDataList() {
        return getMAdapter().D();
    }

    @Override // com.transsion.room.widget.RoomsHomeBaseView
    public RecyclerView getRecyclerView() {
        w mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76619b;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsHomeBaseView
    public AppCompatTextView getTitleView() {
        w mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76621d;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsHomeBaseView
    public void initRecyclerView() {
    }

    @Override // com.transsion.room.widget.RoomsHomeBaseView, rw.b
    public void setList(List<RoomItem> dataList) {
        Intrinsics.g(dataList, "dataList");
        q(dataList.size());
        super.setList(dataList);
    }
}
