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
import sw.y;

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
public final class SubjectDetailRoomsView extends RoomsBaseView<y> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context, AttributeSet attributeSet, int i11) {
        AppCompatTextView appCompatTextView;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_subject_detail_rooms, this);
        setMViewBinding(y.a(this));
        setPadding(0, gs.a.a(12), 0, 0);
        initRecyclerView();
        getMAdapter().L0(RoomsViewType.TYPE_SUBJECT_DETAIL);
        y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f76628c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectDetailRoomsView.q(this.f57386a, view);
            }
        });
    }

    public /* synthetic */ SubjectDetailRoomsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void q(SubjectDetailRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.n();
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public RecyclerView getRecyclerView() {
        y mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76627b;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public AppCompatTextView getTitleView() {
        y mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f76629d;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public void initRecyclerView() {
        RecyclerView recyclerView;
        y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f76627b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), 0, 0));
        recyclerView.setAdapter(getMAdapter());
    }
}
