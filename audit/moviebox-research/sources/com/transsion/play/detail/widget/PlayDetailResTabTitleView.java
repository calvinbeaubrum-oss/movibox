package com.transsion.play.detail.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.noober.background.view.BLView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.play.detail.R$layout;
import ev.a;
import h20.b;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PlayDetailResTabTitleView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f54204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54206c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayDetailResTabTitleView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayDetailResTabTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayDetailResTabTitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_play_detail_tab, this);
        a aVarA = a.a(this);
        Intrinsics.f(aVarA, "bind(this)");
        this.f54204a = aVarA;
        aVarA.f64357b.setTextSize(16.0f);
        this.f54205b = z2.a.getColor(getContext(), R$color.white_80);
        this.f54206c = z2.a.getColor(getContext(), R$color.white);
    }

    @Override // h20.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f54204a.f64357b.getPaint().getFontMetrics();
        Intrinsics.f(fontMetrics, "viewBinding.tvTitle.paint.getFontMetrics()");
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.b
    public int getContentLeft() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(this.f54204a.f64357b.getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(this.f54204a.f64357b.getText().toString(), 0);
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
            string = this.f54204a.f64357b.getText().toString();
        }
        this.f54204a.f64357b.getPaint().getTextBounds(string, 0, string.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentRight() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(this.f54204a.f64357b.getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(this.f54204a.f64357b.getText().toString(), 0);
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
            string = this.f54204a.f64357b.getText().toString();
        }
        this.f54204a.f64357b.getPaint().getTextBounds(string, 0, string.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f54204a.f64357b.getPaint().getFontMetrics();
        Intrinsics.f(fontMetrics, "viewBinding.tvTitle.paint.getFontMetrics()");
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
        this.f54204a.f64357b.setTextColor(this.f54205b);
        this.f54204a.f64357b.setTextSize(14.0f);
        TnTextView tnTextView = this.f54204a.f64357b;
        Context context = getContext();
        Intrinsics.f(context, "context");
        tnTextView.setTypeface(so.a.d(context));
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
        this.f54204a.f64357b.setTextColor(this.f54206c);
        this.f54204a.f64357b.setTextSize(16.0f);
        TnTextView tnTextView = this.f54204a.f64357b;
        Context context = getContext();
        Intrinsics.f(context, "context");
        tnTextView.setTypeface(so.a.a(context));
    }

    public final void setDotVisibility(boolean z11) {
        BLView bLView = this.f54204a.f64358c;
        Intrinsics.f(bLView, "viewBinding.vDot");
        bLView.setVisibility(z11 ? 0 : 8);
    }

    public final void setTitle(final String title) {
        Intrinsics.g(title, "title");
        this.f54204a.f64357b.setTextAction(new Function0<CharSequence>() { // from class: com.transsion.play.detail.widget.PlayDetailResTabTitleView.setTitle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CharSequence invoke() {
                return title;
            }
        });
    }
}
