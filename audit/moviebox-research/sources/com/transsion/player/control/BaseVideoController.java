package com.transsion.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.transsion.player.p006enum.PipStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jv.a;
import jv.b;
import jv.c;
import kotlin.Metadata;
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
public abstract class BaseVideoController<Data, PlayStatus> extends FrameLayout implements c<Data, PlayStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<Data, PlayStatus> f54230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap<b<Data, PlayStatus>, Boolean> f54231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b<Data, PlayStatus>> f54232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Data f54233d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseVideoController(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseVideoController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseVideoController(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f54231b = new LinkedHashMap<>();
        this.f54232c = new ArrayList();
    }

    public final void addControlComponent(b<Data, PlayStatus> component, boolean z11) {
        Intrinsics.g(component, "component");
        this.f54231b.put(component, Boolean.valueOf(z11));
        a<Data, PlayStatus> aVar = this.f54230a;
        if (aVar != null) {
            Intrinsics.d(aVar);
            component.a(aVar);
        }
        View view = component.getView();
        if (view == null || z11) {
            return;
        }
        addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void addControlComponent(b<Data, PlayStatus>... component) {
        Intrinsics.g(component, "component");
        for (b<Data, PlayStatus> bVar : component) {
            addControlComponent(bVar, false);
        }
    }

    public LinkedHashMap<b<Data, PlayStatus>, Boolean> getControlComponentMap() {
        return this.f54231b;
    }

    public final LinkedHashMap<b<Data, PlayStatus>, Boolean> getControlComponents() {
        return this.f54231b;
    }

    public final List<b<Data, PlayStatus>> getPipStatusVisibilityComponents() {
        return this.f54232c;
    }

    public final Data getVideoContentData() {
        return this.f54233d;
    }

    public final void onPipStatusChange(PipStatus pipStatus) {
        Intrinsics.g(pipStatus, "pipStatus");
        if (pipStatus == PipStatus.DEFAULT) {
            Iterator<T> it = this.f54232c.iterator();
            while (it.hasNext()) {
                View view = ((b) it.next()).getView();
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            return;
        }
        this.f54232c.clear();
        for (Map.Entry<b<Data, PlayStatus>, Boolean> entry : this.f54231b.entrySet()) {
            Intrinsics.f(entry, "controlComponents.entries");
            b<Data, PlayStatus> component = entry.getKey();
            View view2 = component.getView();
            if (view2 != null && view2.getVisibility() == 0) {
                view2.setVisibility(8);
                List<b<Data, PlayStatus>> list = this.f54232c;
                Intrinsics.f(component, "component");
                list.add(component);
            }
        }
    }

    public final void removeAllControlComponent() {
        for (Map.Entry<b<Data, PlayStatus>, Boolean> entry : this.f54231b.entrySet()) {
            Intrinsics.f(entry, "controlComponents.entries");
            removeView(entry.getKey().getView());
        }
        this.f54231b.clear();
    }

    public final void removeAllDissociateComponents() {
        Iterator<Map.Entry<b<Data, PlayStatus>, Boolean>> it = this.f54231b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                it.remove();
            }
        }
    }

    public final void removeControlComponent(b<Data, PlayStatus> component) {
        Intrinsics.g(component, "component");
        removeView(component.getView());
        this.f54231b.remove(component);
    }

    public final void setControlComponents(LinkedHashMap<b<Data, PlayStatus>, Boolean> linkedHashMap) {
        Intrinsics.g(linkedHashMap, "<set-?>");
        this.f54231b = linkedHashMap;
    }

    public final void setPayerView(com.transsion.player.ui.a playerView) {
        Intrinsics.g(playerView, "playerView");
        this.f54230a = new a<>(playerView, this);
        for (Map.Entry<b<Data, PlayStatus>, Boolean> entry : this.f54231b.entrySet()) {
            Intrinsics.f(entry, "controlComponents.entries");
            b<Data, PlayStatus> key = entry.getKey();
            a<Data, PlayStatus> aVar = this.f54230a;
            Intrinsics.d(aVar);
            key.a(aVar);
        }
    }

    public final void setVideoContentData(Data data) {
        this.f54233d = data;
    }

    public final void setVideoData(Data data) {
        this.f54233d = data;
        for (Map.Entry<b<Data, PlayStatus>, Boolean> entry : this.f54231b.entrySet()) {
            Intrinsics.f(entry, "controlComponents.entries");
            entry.getKey().d(data);
        }
    }
}
