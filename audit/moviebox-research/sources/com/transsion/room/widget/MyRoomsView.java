package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.YourRoomsAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sw.a0;

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
public final class MyRoomsView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f57352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public YourRoomsAdapter f57353b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomsView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyRoomsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        YourRoomsAdapter yourRoomsAdapter = new YourRoomsAdapter();
        yourRoomsAdapter.B0(new f9.d() { // from class: com.transsion.room.widget.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                MyRoomsView.f(this.f57377a, baseQuickAdapter, view, i12);
            }
        });
        this.f57353b = yourRoomsAdapter;
        View.inflate(getContext(), R$layout.view_your_rooms, this);
        a0 a0VarA = a0.a(this);
        Intrinsics.f(a0VarA, "bind(this)");
        this.f57352a = a0VarA;
        RecyclerView recyclerView = a0VarA.f76482b;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.addItemDecoration(new ro.a(gs.a.a(8), 0, 0, 0));
        recyclerView.setAdapter(this.f57353b);
        a0VarA.f76483c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRoomsView.c(this.f57378a, view);
            }
        });
    }

    public static final void c(MyRoomsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.g();
    }

    private final void e(RoomItem roomItem, int i11) {
        if (roomItem != null) {
            roomItem.setNewPostCount(0L);
        }
        this.f57353b.notifyItemChanged(i11, 0L);
    }

    public static final void f(MyRoomsView this$0, BaseQuickAdapter adapter, View v11, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(v11, "v");
        if (com.transsion.baseui.util.c.f51452a.a(v11.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        this$0.h(roomItem, i11);
    }

    private final void h(RoomItem roomItem, int i11) {
        com.transsion.room.helper.k.f57301a.b("room_home", roomItem);
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", roomItem.getGroupId()).navigation();
        e(roomItem, i11);
    }

    public final void g() {
        com.transsion.room.helper.k.f57301a.a("room_home");
        com.alibaba.android.arouter.launcher.a.d().b("/room/list").withInt("index", 0).navigation();
    }

    public final List<RoomItem> getDataList() {
        return this.f57353b.D();
    }

    public final void setList(List<RoomItem> dataList) {
        Intrinsics.g(dataList, "dataList");
        if (dataList.size() > 4) {
            AppCompatTextView appCompatTextView = this.f57352a.f76483c;
            Intrinsics.f(appCompatTextView, "viewBinding.tvMore");
            so.c.k(appCompatTextView);
            dataList = dataList.subList(0, 4);
        } else {
            AppCompatTextView appCompatTextView2 = this.f57352a.f76483c;
            Intrinsics.f(appCompatTextView2, "viewBinding.tvMore");
            so.c.g(appCompatTextView2);
        }
        this.f57353b.w0(dataList);
    }
}
