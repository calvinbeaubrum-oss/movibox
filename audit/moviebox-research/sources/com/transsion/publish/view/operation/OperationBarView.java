package com.transsion.publish.view.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.h;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.view.operation.OperationBarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jw.e;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.JvmOverloads;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class OperationBarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f56770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f56771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.publish.adapter.a f56772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f56773d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f56775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppCompatTextView f56778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f56779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Integer> f56780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Integer> f56781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f56782n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements jw.a {
        public a() {
        }

        @Override // jw.a
        public void a(OperationBean item, int i11) {
            com.transsion.publish.adapter.a aVar;
            Intrinsics.g(item, "item");
            if (item.getStatus() || i11 == 0) {
                if (item.getStatus() || OperationBarView.this.getSelectItem().get(0).intValue() != 1) {
                    RecyclerView rv2 = OperationBarView.this.getRv();
                    if (rv2 != null) {
                        KeyboardUtils.e(rv2);
                    }
                    int type = item.getType();
                    if (type == 0) {
                        com.transsion.publish.adapter.a aVar2 = OperationBarView.this.f56772c;
                        if (aVar2 != null) {
                            Context context = OperationBarView.this.getContext();
                            Intrinsics.f(context, "context");
                            aVar2.startPhoto(context);
                            return;
                        }
                        return;
                    }
                    if (type == 1) {
                        com.transsion.publish.adapter.a aVar3 = OperationBarView.this.f56772c;
                        if (aVar3 != null) {
                            Context context2 = OperationBarView.this.getContext();
                            Intrinsics.f(context2, "context");
                            aVar3.startVideo(context2);
                            return;
                        }
                        return;
                    }
                    if (type == 2) {
                        com.transsion.publish.adapter.a aVar4 = OperationBarView.this.f56772c;
                        if (aVar4 != null) {
                            Context context3 = OperationBarView.this.getContext();
                            Intrinsics.f(context3, "context");
                            aVar4.startAudio(context3);
                            return;
                        }
                        return;
                    }
                    if (type == 3) {
                        com.transsion.publish.adapter.a aVar5 = OperationBarView.this.f56772c;
                        if (aVar5 != null) {
                            Context context4 = OperationBarView.this.getContext();
                            Intrinsics.f(context4, "context");
                            aVar5.startWork(context4);
                            return;
                        }
                        return;
                    }
                    if (type == 4) {
                        com.transsion.publish.adapter.a aVar6 = OperationBarView.this.f56772c;
                        if (aVar6 != null) {
                            Context context5 = OperationBarView.this.getContext();
                            Intrinsics.f(context5, "context");
                            aVar6.startLink(context5);
                            return;
                        }
                        return;
                    }
                    if (type != 6) {
                        if (type == 8 && (aVar = OperationBarView.this.f56772c) != null) {
                            Context context6 = OperationBarView.this.getContext();
                            Intrinsics.f(context6, "context");
                            aVar.startLocation(context6);
                            return;
                        }
                        return;
                    }
                    com.transsion.publish.adapter.a aVar7 = OperationBarView.this.f56772c;
                    if (aVar7 != null) {
                        Context context7 = OperationBarView.this.getContext();
                        Intrinsics.f(context7, "context");
                        aVar7.startGroup(context7);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationBarView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationBarView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationBarView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.f56777i = -1;
        this.f56779k = 1000;
        this.f56780l = g.q(0, 1, 3, 6, 8);
        this.f56781m = g.q(Integer.valueOf(R$drawable.icon_post_select_image), Integer.valueOf(R$drawable.icon_post_video), Integer.valueOf(R$drawable.icon_post_select_subject), Integer.valueOf(R$drawable.icon_post_group), Integer.valueOf(R$drawable.icon_post_location));
        this.f56782n = g.q(Integer.valueOf(R$drawable.icon_post_select_image_unable), Integer.valueOf(R$drawable.icon_post_video_unable), Integer.valueOf(R$drawable.icon_post_select_subject), Integer.valueOf(R$drawable.icon_post_group), Integer.valueOf(R$drawable.icon_post_location));
        this.f56771b = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_operation_layout, this);
        this.f56770a = (RecyclerView) viewInflate.findViewById(R$id.f56357rv);
        this.f56775g = (FrameLayout) viewInflate.findViewById(R$id.ff_put);
        this.f56778j = (AppCompatTextView) viewInflate.findViewById(R$id.tvInputNum);
    }

    public /* synthetic */ OperationBarView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static final void b(OperationBarView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.publish.adapter.a aVar = this$0.f56772c;
        if (aVar != null) {
            Context context = this$0.getContext();
            Intrinsics.f(context, "context");
            aVar.put(context);
        }
    }

    public final List<OperationBean> getData() {
        List<OperationBean> listF;
        e eVar = this.f56773d;
        return (eVar == null || (listF = eVar.f()) == null) ? new ArrayList() : listF;
    }

    public final RecyclerView getRv() {
        return this.f56770a;
    }

    public final List<Integer> getSelectItem() {
        List<OperationBean> listF;
        ArrayList arrayList = new ArrayList();
        e eVar = this.f56773d;
        if (eVar != null && (listF = eVar.f()) != null) {
            for (OperationBean operationBean : listF) {
                if (operationBean.getStatus() && operationBean.getType() != 3) {
                    arrayList.add(Integer.valueOf(operationBean.getType()));
                }
            }
        }
        return arrayList;
    }

    public final void init(int i11, GroupBean groupBean, Subject subject) {
        this.f56774f = i11;
        if (groupBean != null) {
            this.f56780l.remove((Object) 6);
            this.f56781m.remove(Integer.valueOf(R$drawable.icon_post_group));
            this.f56782n.remove(Integer.valueOf(R$drawable.icon_post_group));
        } else if (subject != null) {
            this.f56780l.remove((Object) 3);
            this.f56781m.remove(Integer.valueOf(R$drawable.icon_post_select_subject));
            this.f56782n.remove(Integer.valueOf(R$drawable.icon_post_select_subject));
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.f56780l;
        if (list != null) {
            int i12 = 0;
            for (Object obj : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    g.u();
                }
                int iIntValue = ((Number) obj).intValue();
                if (i11 != 1) {
                    if (i11 == 2) {
                        arrayList.add(new OperationBean(iIntValue, this.f56781m.get(i12).intValue(), this.f56782n.get(i12).intValue()));
                    }
                } else if (iIntValue != 2 && iIntValue != 3) {
                    arrayList.add(new OperationBean(iIntValue, this.f56781m.get(i12).intValue(), this.f56782n.get(i12).intValue()));
                }
                i12 = i13;
            }
        }
        e eVar = new e();
        this.f56773d = eVar;
        eVar.e(arrayList);
        RecyclerView recyclerView = this.f56770a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.f56770a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f56773d);
        }
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.j(new a());
        }
        FrameLayout frameLayout = this.f56775g;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: jw.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OperationBarView.b(this.f68157a, view);
                }
            });
        }
    }

    public final void resetItem() {
        resetItem(false);
    }

    public final void resetItem(boolean z11) {
        int i11;
        List<OperationBean> listF;
        e eVar = this.f56773d;
        if (eVar != null && (listF = eVar.f()) != null) {
            Iterator<T> it = listF.iterator();
            while (it.hasNext()) {
                ((OperationBean) it.next()).setStatus(true);
            }
        }
        if (this.f56776h && !z11) {
            selectItem(4);
            return;
        }
        this.f56776h = false;
        if (z11 && (i11 = this.f56777i) != -1 && i11 != 4) {
            selectItem(i11);
            return;
        }
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.notifyDataSetChanged();
        }
    }

    public final void selectItem(int i11) {
        List<OperationBean> listF;
        e eVar = this.f56773d;
        if (eVar == null || (listF = eVar.f()) == null || i11 >= listF.size()) {
            return;
        }
        OperationBean operationBean = listF.get(i11);
        int type = operationBean != null ? operationBean.getType() : -1;
        this.f56777i = type;
        if (type == 0) {
            setItemState(0, listF, true);
            setItemState(1, listF, false);
            setItemState(2, listF, false);
        } else if (type == 1) {
            setItemState(1, listF, true);
            setItemState(0, listF, false);
            setItemState(2, listF, false);
        } else if (type == 2) {
            setItemState(2, listF, true);
            setItemState(1, listF, false);
            setItemState(0, listF, false);
            setItemState(4, listF, false);
        } else if (type == 4) {
            this.f56776h = true;
            setItemState(4, listF, true);
            setItemState(2, listF, false);
        }
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.notifyDataSetChanged();
        }
    }

    public final void selectItems(int i11) {
        List<OperationBean> listF;
        e eVar = this.f56773d;
        if (eVar == null || (listF = eVar.f()) == null) {
            return;
        }
        for (OperationBean operationBean : listF) {
            int type = operationBean.getType();
            boolean z11 = false;
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type == 4) {
                            if (i11 == operationBean.getType()) {
                                operationBean.setStatus(operationBean.getType() != 2);
                            } else {
                                operationBean.setStatus(i11 != 2);
                            }
                        }
                    } else if (i11 == operationBean.getType()) {
                        if (operationBean.getType() != 0 && operationBean.getType() != 1 && operationBean.getType() != 4) {
                            z11 = true;
                        }
                        operationBean.setStatus(z11);
                    } else {
                        operationBean.setStatus(false);
                    }
                } else if (i11 == operationBean.getType()) {
                    if (operationBean.getType() != 0 && operationBean.getType() != 2) {
                        z11 = true;
                    }
                    operationBean.setStatus(z11);
                } else {
                    operationBean.setStatus(false);
                }
            } else if (i11 == operationBean.getType()) {
                if (operationBean.getType() != 1 && operationBean.getType() != 2) {
                    z11 = true;
                }
                operationBean.setStatus(z11);
            } else {
                operationBean.setStatus(false);
            }
        }
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.notifyDataSetChanged();
        }
    }

    public final void setClickListener(com.transsion.publish.adapter.a listener) {
        Intrinsics.g(listener, "listener");
        this.f56772c = listener;
    }

    public final void setInputLimitColor(int i11) {
        AppCompatTextView appCompatTextView = this.f56778j;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(h.a(i11));
        }
    }

    public final void setItemState(int i11, List<OperationBean> list, boolean z11) {
        Intrinsics.g(list, "list");
        for (OperationBean operationBean : list) {
            if (i11 == operationBean.getType()) {
                operationBean.setStatus(z11);
            }
        }
    }

    public final void setPhotoStatus() {
        List<OperationBean> listF;
        e eVar = this.f56773d;
        if (eVar == null || (listF = eVar.f()) == null) {
            return;
        }
        setItemState(0, listF, false);
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.notifyDataSetChanged();
        }
    }

    public final void setRv(RecyclerView recyclerView) {
        this.f56770a = recyclerView;
    }

    public final void setVideoStatus() {
        List<OperationBean> listF;
        e eVar = this.f56773d;
        if (eVar == null || (listF = eVar.f()) == null) {
            return;
        }
        setItemState(1, listF, false);
        e eVar2 = this.f56773d;
        if (eVar2 != null) {
            eVar2.notifyDataSetChanged();
        }
    }

    public final void updateInputNum(int i11) {
        AppCompatTextView appCompatTextView = this.f56778j;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(i11 + "/" + this.f56779k);
    }
}
