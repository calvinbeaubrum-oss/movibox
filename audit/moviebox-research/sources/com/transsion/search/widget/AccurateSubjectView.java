package com.transsion.search.widget;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bx.m;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.j;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.AccurateSubject;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.Season;
import com.transsion.search.fragment.values.SearchValuesFragment;
import com.transsion.search.widget.AccurateSubjectView;
import com.transsnet.downloader.widget.DownloadView;
import f9.d;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ro.b;
import so.c;
import tp.f;
import yw.a;

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
public final class AccurateSubjectView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f57708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f57709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57711d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f57712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f57713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f57714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f57715i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccurateSubjectView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccurateSubjectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccurateSubjectView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f57710c = f0.a(104.0f);
        this.f57711d = f0.a(149.0f);
        this.f57712f = f0.a(48.0f);
        f fVar = f.f77260a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        this.f57713g = fVar.e(applicationA);
        this.f57714h = f0.a(16.0f);
        this.f57715i = 6;
        e();
    }

    private final void e() {
        this.f57709b = m.a(View.inflate(getContext(), R$layout.item_search_values_accurate_layout, this));
        setClipChildren(false);
    }

    public static final void g(AccurateSubjectView this$0, SearchSubject searchSubject, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        a aVar = this$0.f57708a;
        Season item = aVar != null ? aVar.getItem(i11) : null;
        if (item != null) {
            this$0.f(i11, searchSubject, item);
        }
    }

    public final void b(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder.length() > 0) {
            spannableStringBuilder.append(" / ");
        }
    }

    public final void c(ViewGroup viewGroup, Subject subject) {
        String[] tags;
        if (viewGroup == null || subject == null || (tags = z.a(subject.getGenre(), ",")) == null) {
            return;
        }
        Intrinsics.f(tags, "tags");
        for (String str : tags) {
            View viewA = i9.a.a(this, R$layout.item_search_subject_tag);
            ((TextView) viewA.findViewById(R$id.tagTV)).setText(str);
            viewGroup.addView(viewA);
        }
    }

    public final void f(int i11, SearchSubject searchSubject, Season season) {
        Integer subjectType;
        Integer se2 = season.getSe();
        com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", (searchSubject == null || (subjectType = searchSubject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).withString("id", searchSubject != null ? searchSubject.getSubjectId() : null).withInt("season", i11 != this.f57715i + (-1) ? se2 != null ? se2.intValue() : 0 : 0).withString("ops", searchSubject != null ? searchSubject.getOps() : null).navigation();
        SearchValuesFragment.a aVar = SearchValuesFragment.f57605t;
        aVar.b("", searchSubject != null ? searchSubject.getSubjectId() : null, "", searchSubject != null ? searchSubject.getOps() : null, i11, 4, aVar.a(), String.valueOf(season.getSe()));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    public final void setData(AccurateSubject accurateSubject) {
        int i11;
        String str;
        RecyclerView recyclerView;
        DownloadView downloadView;
        m mVar;
        DownloadView setData$lambda$6$lambda$5$lambda$4;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        CornerTextView cornerTextView;
        Intrinsics.g(accurateSubject, "accurateSubject");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int i12 = this.f57714h;
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(-i12, 0, -i12, 0);
        final SearchSubject subject = accurateSubject.getSubject();
        m mVar2 = this.f57709b;
        ShapeableImageView shapeableImageView = mVar2 != null ? mVar2.f14513b : null;
        Cover cover = subject != null ? subject.getCover() : null;
        if (cover != null) {
            String url = cover.getUrl();
            if (url != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                Intrinsics.f(context, "context");
                if (shapeableImageView == null) {
                    i11 = 1;
                } else {
                    String thumbnail = cover.getThumbnail();
                    if (thumbnail == null) {
                        thumbnail = "";
                    }
                    i11 = 1;
                    companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                }
            } else {
                i11 = 1;
            }
            m mVar3 = this.f57709b;
            if (mVar3 != null && (cornerTextView = mVar3.f14514c) != null) {
                cornerTextView.setTextWithType(subject.getCorner(), subject.getSubjectType());
            }
            m mVar4 = this.f57709b;
            if (mVar4 != null && (appCompatTextView3 = mVar4.f14519i) != null) {
                appCompatTextView3.setText(subject.getTitle());
            }
            m mVar5 = this.f57709b;
            if (mVar5 != null && (appCompatTextView2 = mVar5.f14520j) != null) {
                appCompatTextView2.setText(subject.getImdbRate());
            }
            m mVar6 = this.f57709b;
            if (mVar6 != null && (appCompatTextView = mVar6.f14521k) != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append("  ");
                String releaseDate = subject.getReleaseDate();
                if (releaseDate != null && releaseDate.length() != 0) {
                    Date dateK = h0.k(subject.getReleaseDate(), "yyyy-MM-dd");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dateK);
                    spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(i11)));
                }
                String countryName = subject.getCountryName();
                if (countryName != null && countryName.length() != 0) {
                    b(spannableStringBuilder);
                    spannableStringBuilder.append((CharSequence) subject.getCountryName());
                }
                Integer durationSeconds = subject.getDurationSeconds();
                if (durationSeconds != null && durationSeconds.intValue() > 0 && !subject.isEPType()) {
                    b(spannableStringBuilder);
                    spannableStringBuilder.append((CharSequence) j.b(subject.getDurationSeconds()));
                }
                List<Staff> staffList = subject.getStaffList();
                if (staffList != null) {
                    int i13 = 2;
                    for (Staff staff : staffList) {
                        if (i13 != 0) {
                            i13--;
                            b(spannableStringBuilder);
                            spannableStringBuilder.append((CharSequence) staff.getName());
                        }
                    }
                }
                String duration = subject.getDuration();
                if (duration != null && duration.length() != 0 && !subject.isSeries()) {
                    b(spannableStringBuilder);
                    spannableStringBuilder.append((CharSequence) subject.getDuration());
                }
                int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
                spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(appCompatTextView.getContext(), iA, 2) : new ImageSpan(appCompatTextView.getContext(), iA, i11), 0, i11, 34);
                appCompatTextView.setText(spannableStringBuilder);
            }
            m mVar7 = this.f57709b;
            if (mVar7 != null && (downloadView = mVar7.f14516f) != null) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    c.k(downloadView);
                }
                if (Intrinsics.b(subject.getHasResource(), Boolean.TRUE)) {
                    c.k(downloadView);
                    if (com.transsion.baselib.utils.m.f51320a.b()) {
                        downloadView.setShowPlayType();
                    } else {
                        List<ResourceDetectors> resourceDetectors = subject.getResourceDetectors();
                        if (resourceDetectors != null && ((resourceDetectors.isEmpty() ? 1 : 0) ^ i11) != 0 && (mVar = this.f57709b) != null && (setData$lambda$6$lambda$5$lambda$4 = mVar.f14516f) != null) {
                            Intrinsics.f(setData$lambda$6$lambda$5$lambda$4, "setData$lambda$6$lambda$5$lambda$4");
                            String subjectId = subject.getSubjectId();
                            String resourceId = resourceDetectors.get(0).getResourceId();
                            Integer type = resourceDetectors.get(0).getType();
                            DownloadView.setShowType$default(setData$lambda$6$lambda$5$lambda$4, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == i11), false, 0, 24, null);
                        }
                    }
                } else {
                    c.h(downloadView);
                }
            }
        } else {
            i11 = 1;
        }
        List<Season> seasons = accurateSubject.getSeasons();
        int size = seasons != null ? seasons.size() : 0;
        List<Season> seasons2 = accurateSubject.getSeasons();
        List listF0 = seasons2 != null ? CollectionsKt___CollectionsKt.F0(seasons2, 6) : null;
        m mVar8 = this.f57709b;
        c(mVar8 != null ? mVar8.f14518h : null, accurateSubject.getSubject());
        if (listF0 == null || ((listF0.isEmpty() ? 1 : 0) ^ i11) != i11 || listF0.size() <= i11) {
            str = null;
            m mVar9 = this.f57709b;
            RecyclerView recyclerView2 = mVar9 != null ? mVar9.f14517g : null;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
        } else {
            m mVar10 = this.f57709b;
            RecyclerView recyclerView3 = mVar10 != null ? mVar10.f14517g : null;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            m mVar11 = this.f57709b;
            if (mVar11 == null || (recyclerView = mVar11.f14517g) == null) {
                str = null;
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
                str = null;
                a aVar = new a(0, i11, null);
                aVar.B0(new d() { // from class: jx.a
                    @Override // f9.d
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i14) {
                        AccurateSubjectView.g(this.f68174a, subject, baseQuickAdapter, view, i14);
                    }
                });
                this.f57708a = aVar;
                recyclerView.setAdapter(aVar);
                a aVar2 = this.f57708a;
                if (aVar2 != null) {
                    aVar2.w0(listF0);
                }
                a aVar3 = this.f57708a;
                if (aVar3 != null) {
                    aVar3.H0(size >= 7);
                }
                recyclerView.addItemDecoration(new b(f0.a(4.0f), f0.a(4.0f), f0.a(8.0f), f0.a(8.0f)));
            }
        }
        SearchValuesFragment.f57605t.d("", subject != null ? subject.getSubjectId() : str, "", subject != null ? subject.getOps() : str, 0, 4);
    }
}
