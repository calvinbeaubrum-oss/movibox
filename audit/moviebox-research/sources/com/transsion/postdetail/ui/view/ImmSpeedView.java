package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.ui.dialog.SpeedConfigDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class ImmSpeedView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f55964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f55965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f55966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55967d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmSpeedView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        updateSpeed(LocalVideoPlayerConfigMmkv.f51172a.c(), true);
        setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmSpeedView.b(this.f56124a, view);
            }
        });
        this.f55966c = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmSpeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        updateSpeed(LocalVideoPlayerConfigMmkv.f51172a.c(), true);
        setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmSpeedView.b(this.f56124a, view);
            }
        });
        this.f55966c = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmSpeedView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        updateSpeed(LocalVideoPlayerConfigMmkv.f51172a.c(), true);
        setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmSpeedView.b(this.f56124a, view);
            }
        });
        this.f55966c = true;
    }

    public static final void b(ImmSpeedView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f55964a;
        if (str != null) {
            com.transsion.baselib.report.m.f51277a.m(str, "click", kotlin.collections.s.l(new Pair("module_name", "speed"), new Pair("subject_id", this$0.f55965b), new Pair("type", "0")));
        }
        SpeedConfigDialog speedConfigDialog = new SpeedConfigDialog();
        speedConfigDialog.p0(this$0.f55967d);
        Context context = this$0.getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "context as FragmentActiv…y).supportFragmentManager");
        speedConfigDialog.show(supportFragmentManager, "SpeedConfigDialog");
    }

    public static /* synthetic */ void updateSpeed$default(ImmSpeedView immSpeedView, float f11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        immSpeedView.updateSpeed(f11, z11);
    }

    public final boolean getPkStyle() {
        return this.f55966c;
    }

    public final boolean isPortrait() {
        return this.f55967d;
    }

    public final void setPageParams(String str, String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.f55964a = str;
        this.f55965b = subjectId;
    }

    public final void setPkStyle(boolean z11) {
        this.f55966c = z11;
    }

    public final void setPortrait(boolean z11) {
        this.f55967d = z11;
    }

    public final void updateSpeed(float f11, boolean z11) {
        String str;
        if (f11 != 1.0f || this.f55966c) {
            setBackground(null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            Object[] objArr = new Object[1];
            int i11 = (int) f11;
            objArr[0] = ((float) i11) == f11 ? String.valueOf(i11) : String.valueOf(f11);
            String str2 = String.format("%sx", Arrays.copyOf(objArr, 1));
            Intrinsics.f(str2, "format(...)");
            setText(str2);
        } else {
            setBackgroundResource(R$drawable.ic_player_speed);
            setText((CharSequence) null);
        }
        if (z11 || (str = this.f55964a) == null) {
            return;
        }
        com.transsion.baselib.report.m.f51277a.m(str, "click", kotlin.collections.s.l(new Pair("module_name", "speed"), new Pair("subject_id", this.f55965b), new Pair("type", String.valueOf(f11))));
    }
}
