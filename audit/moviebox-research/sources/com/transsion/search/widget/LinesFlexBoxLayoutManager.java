package com.transsion.search.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class LinesFlexBoxLayoutManager extends FlexboxLayoutManager {
    public int C;
    public Function0<Unit> D;
    public List<Pair<Integer, Integer>> E;
    public int F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinesFlexBoxLayoutManager(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.E = new ArrayList();
    }

    public final int a0() {
        return (this.E.size() == 0 ? super.getFlexLinesInternal() : this.E).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void attachView(View child) {
        Intrinsics.g(child, "child");
        if (child.getParent() != null) {
            ViewParent parent = child.getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(child);
        }
        super.attachView(child);
    }

    public final int b0() {
        return this.F;
    }

    public final int c0(int i11) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf(this.E.get(i11).getSecond().intValue()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = 0;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final void d0() {
        this.E.clear();
        this.F = 0;
    }

    public final void e0(int i11) {
        this.C = i11;
        requestLayout();
    }

    @Override // com.google.android.flexbox.FlexboxLayoutManager, com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        List<b> flexLines = super.getFlexLinesInternal();
        if (flexLines.size() > this.E.size()) {
            this.E.clear();
            Intrinsics.f(flexLines, "flexLines");
            int iB = 0;
            for (b bVar : flexLines) {
                this.E.add(new Pair<>(Integer.valueOf(iB + 1), Integer.valueOf(bVar.b() + iB)));
                iB += bVar.b();
                if (this.E.size() == this.C) {
                    this.F = iB;
                }
            }
        }
        if (this.C == 0) {
            Intrinsics.f(flexLines, "flexLines");
            return flexLines;
        }
        int size = flexLines.size();
        int i11 = this.C;
        if (size > i11) {
            flexLines.subList(i11, flexLines.size()).clear();
            Function0<Unit> function0 = this.D;
            if (function0 != null) {
                function0.invoke();
            }
        }
        Intrinsics.f(flexLines, "flexLines");
        return flexLines;
    }

    @Override // com.google.android.flexbox.FlexboxLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        try {
            super.onLayoutChildren(tVar, xVar);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
