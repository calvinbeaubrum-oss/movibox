package com.transsion.publish.view.operation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jw.i;
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
public final class OperationVerticalBarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f56784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f56785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.publish.adapter.a f56786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f56787d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<OperationBean> f56788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f56789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f56790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f56791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f56792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Integer> f56793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Integer> f56794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Integer> f56795m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements jw.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f56797b;

        public a(View view) {
            this.f56797b = view;
        }

        @Override // jw.b
        public void a(OperationBean item, int i11) {
            com.transsion.publish.adapter.a aVar;
            Intrinsics.g(item, "item");
            if (item.getStatus() || i11 == 3) {
                int type = item.getType();
                if (type == 0) {
                    com.transsion.publish.adapter.a aVar2 = OperationVerticalBarView.this.f56786c;
                    if (aVar2 != null) {
                        Context context = this.f56797b.getContext();
                        Intrinsics.f(context, "context");
                        aVar2.startPhoto(context);
                        return;
                    }
                    return;
                }
                if (type == 1) {
                    com.transsion.publish.adapter.a aVar3 = OperationVerticalBarView.this.f56786c;
                    if (aVar3 != null) {
                        Context context2 = this.f56797b.getContext();
                        Intrinsics.f(context2, "context");
                        aVar3.startVideo(context2);
                        return;
                    }
                    return;
                }
                if (type == 2) {
                    com.transsion.publish.adapter.a aVar4 = OperationVerticalBarView.this.f56786c;
                    if (aVar4 != null) {
                        Context context3 = this.f56797b.getContext();
                        Intrinsics.f(context3, "context");
                        aVar4.startAudio(context3);
                        return;
                    }
                    return;
                }
                if (type != 3) {
                    if (type == 4 && (aVar = OperationVerticalBarView.this.f56786c) != null) {
                        Context context4 = this.f56797b.getContext();
                        Intrinsics.f(context4, "context");
                        aVar.startLink(context4);
                        return;
                    }
                    return;
                }
                com.transsion.publish.adapter.a aVar5 = OperationVerticalBarView.this.f56786c;
                if (aVar5 != null) {
                    Context context5 = this.f56797b.getContext();
                    Intrinsics.f(context5, "context");
                    aVar5.startWork(context5);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return OperationVerticalBarView.this.onTouchEvents(motionEvent);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationVerticalBarView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.f56788f = new ArrayList();
        this.f56793k = g.q(0, 1, 2, 3, 4);
        this.f56794l = g.q(Integer.valueOf(R$drawable.ic_film_photos), Integer.valueOf(R$drawable.ic_film_videos), Integer.valueOf(R$drawable.ic_film_audio), Integer.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$drawable.ic_film_link));
        this.f56795m = g.q(Integer.valueOf(R$drawable.ic_base_photos_disable), Integer.valueOf(R$drawable.ic_base_video_disable), Integer.valueOf(R$drawable.ic_base_audio_disable), Integer.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$drawable.ic_base_link_disable));
        this.f56785b = context;
        LayoutInflater.from(context).inflate(R$layout.opertaion_vertical_layout, this);
        View rootView = getRootView();
        Intrinsics.f(rootView, "rootView");
        a(rootView);
    }

    public /* synthetic */ OperationVerticalBarView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final void a(View view) {
        this.f56784a = (RecyclerView) view.findViewById(R$id.f56357rv);
        this.f56787d = new i();
        RecyclerView recyclerView = this.f56784a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
            recyclerView.setAdapter(this.f56787d);
        }
        b();
        i iVar = this.f56787d;
        if (iVar != null) {
            iVar.j(new a(view));
        }
    }

    public final void b() {
        RecyclerView recyclerView = this.f56784a;
        if (recyclerView != null) {
            recyclerView.setOnTouchListener(new b());
        }
    }

    public final List<OperationBean> getData() {
        List<OperationBean> listE;
        i iVar = this.f56787d;
        return (iVar == null || (listE = iVar.e()) == null) ? new ArrayList() : listE;
    }

    public final List<Integer> getSelectItem() {
        List<OperationBean> listE;
        ArrayList arrayList = new ArrayList();
        i iVar = this.f56787d;
        if (iVar != null && (listE = iVar.e()) != null) {
            for (OperationBean operationBean : listE) {
                if (operationBean.getStatus() && operationBean.getType() != 3) {
                    arrayList.add(Integer.valueOf(operationBean.getType()));
                }
            }
        }
        return arrayList;
    }

    public final float getX1() {
        return this.f56789g;
    }

    public final float getX2() {
        return this.f56790h;
    }

    public final float getY1() {
        return this.f56791i;
    }

    public final float getY2() {
        return this.f56792j;
    }

    public final void hide() {
        try {
            setVisibility(8);
            clearAnimation();
            postInvalidate();
        } catch (Exception unused) {
        }
    }

    public final boolean onTouchEvents(MotionEvent motionEvent) {
        int action = motionEvent != null ? motionEvent.getAction() : 0;
        if (action == 0) {
            Float fValueOf = motionEvent != null ? Float.valueOf(motionEvent.getX()) : null;
            Intrinsics.d(fValueOf);
            this.f56789g = fValueOf.floatValue();
            Float fValueOf2 = motionEvent != null ? Float.valueOf(motionEvent.getY()) : null;
            Intrinsics.d(fValueOf2);
            this.f56791i = fValueOf2.floatValue();
        }
        if (action == 1) {
            Float fValueOf3 = motionEvent != null ? Float.valueOf(motionEvent.getX()) : null;
            Intrinsics.d(fValueOf3);
            this.f56790h = fValueOf3.floatValue();
            float y11 = motionEvent.getY();
            this.f56792j = y11;
            float f11 = this.f56791i;
            if (f11 - y11 <= 50.0f && y11 - f11 > 50.0f) {
                hide();
            }
        }
        return false;
    }

    public final void resetItem() {
        List<OperationBean> listE;
        i iVar = this.f56787d;
        if (iVar != null && (listE = iVar.e()) != null) {
            Iterator<T> it = listE.iterator();
            while (it.hasNext()) {
                ((OperationBean) it.next()).setStatus(true);
            }
        }
        i iVar2 = this.f56787d;
        if (iVar2 != null) {
            iVar2.notifyDataSetChanged();
        }
    }

    public final void selectItem(int i11) {
        List<OperationBean> listE;
        i iVar = this.f56787d;
        if (iVar == null || (listE = iVar.e()) == null || i11 >= listE.size()) {
            return;
        }
        OperationBean operationBean = listE.get(i11);
        Integer numValueOf = operationBean != null ? Integer.valueOf(operationBean.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            setItemState(0, listE, true);
            setItemState(1, listE, false);
            setItemState(2, listE, false);
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            setItemState(1, listE, true);
            setItemState(0, listE, false);
            setItemState(2, listE, false);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            setItemState(2, listE, true);
            setItemState(1, listE, false);
            setItemState(0, listE, false);
            setItemState(4, listE, false);
        } else if (numValueOf != null && numValueOf.intValue() == 4) {
            setItemState(4, listE, true);
            setItemState(2, listE, false);
            for (OperationBean operationBean2 : listE) {
                if (operationBean2.getType() == 1 && operationBean2.getStatus()) {
                    setItemState(0, listE, false);
                }
                if (operationBean2.getType() == 0 && operationBean2.getStatus()) {
                    setItemState(1, listE, false);
                }
            }
        }
        i iVar2 = this.f56787d;
        if (iVar2 != null) {
            iVar2.notifyDataSetChanged();
        }
    }

    public final void setData(List<OperationBean> list, com.transsion.publish.adapter.a aVar) {
        Intrinsics.g(list, "list");
        this.f56788f = list;
        this.f56786c = aVar;
        i iVar = this.f56787d;
        if (iVar != null) {
            iVar.i(list);
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

    public final void setX1(float f11) {
        this.f56789g = f11;
    }

    public final void setX2(float f11) {
        this.f56790h = f11;
    }

    public final void setY1(float f11) {
        this.f56791i = f11;
    }

    public final void setY2(float f11) {
        this.f56792j = f11;
    }

    public final void show() {
        b();
        i iVar = this.f56787d;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
        setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        startAnimation(translateAnimation);
    }
}
