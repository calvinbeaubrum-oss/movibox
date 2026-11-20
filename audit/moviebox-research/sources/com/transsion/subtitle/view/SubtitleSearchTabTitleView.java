package com.transsion.subtitle.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import bs.a;
import bs.c;
import com.blankj.utilcode.util.f0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLTextView;
import com.transsion.subtitle.R$color;
import h20.b;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

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
public final class SubtitleSearchTabTitleView extends BLTextView implements b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f58316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f58317b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleSearchTabTitleView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f58316a = z2.a.getColor(context, R$color.subtitle_search_title_text);
        setTextSize(12.0f);
        setGravity(17);
        int iA = f0.a(12.0f);
        setPadding(iA, 0, iA, 0);
        this.f58317b = new c(this);
    }

    @Override // bs.a
    public void changeLocal() {
        this.f58317b.changeLocal();
    }

    @Override // h20.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.b
    public int getContentLeft() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(getText().toString(), 0);
            if (listSplit.isEmpty()) {
                listL = g.l();
                break;
            }
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            string = "";
            for (String str : (String[]) listL.toArray(new String[0])) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentRight() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(getText().toString(), 0);
            if (listSplit.isEmpty()) {
                listL = g.l();
                break;
            }
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            string = "";
            for (String str : (String[]) listL.toArray(new String[0])) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
        getPaint().setFakeBoldText(false);
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(com.tn.lib.widget.R$color.white_10)).build());
        setTextColor(-1);
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
        getPaint().setFakeBoldText(true);
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(com.tn.lib.widget.R$color.white)).build());
        setTextColor(this.f58316a);
    }

    public void setHintById(int i11) {
        this.f58317b.b(i11);
    }

    public void setHintWithString(CharSequence charSequence) {
        this.f58317b.c(charSequence);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        a.C0147a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> function0) {
        this.f58317b.e(function0);
    }

    public void setTextById(int i11) {
        this.f58317b.f(i11);
    }

    public void setTextWithString(CharSequence charSequence) {
        this.f58317b.g(charSequence);
    }
}
