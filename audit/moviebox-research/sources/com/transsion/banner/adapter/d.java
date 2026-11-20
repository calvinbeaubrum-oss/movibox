package com.transsion.banner.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.banner.R$id;
import com.transsion.banner.R$layout;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f50957k = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Subject> f50958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f50959j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ShapeableImageView f50960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AppCompatTextView f50961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AppCompatTextView f50962d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AppCompatTextView f50963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DownloadView f50964g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            Intrinsics.g(view, "view");
            this.f50960b = (ShapeableImageView) view.findViewById(R$id.iv_cover);
            this.f50961c = (AppCompatTextView) view.findViewById(R$id.tv_score);
            this.f50962d = (AppCompatTextView) view.findViewById(R$id.tv_title);
            this.f50963f = (AppCompatTextView) view.findViewById(R$id.tv_time);
            this.f50964g = (DownloadView) view.findViewById(R$id.ll_download);
        }

        public static final void j(or.a aVar, Subject subject, View it) {
            Intrinsics.g(subject, "$subject");
            if (aVar != null) {
                Intrinsics.f(it, "it");
                aVar.a(it, null, subject);
            }
        }

        public static final void k(b this$0, Subject subject, String str, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(subject, "$subject");
            this$0.h(subject, str);
            pr.a.f74040a.f(str, "opt", PostItemType.OP_SUBJECTS_MOVIE.getValue(), (1424 & 8) != 0 ? null : subject.getSubjectId(), (1424 & 16) != 0 ? null : null, (1424 & 32) != 0 ? null : null, (1424 & 64) != 0 ? null : subject.getHasResource(), (1424 & 128) != 0 ? null : null, (1424 & 256) != 0 ? null : null, (1424 & 512) != 0 ? null : null, (1424 & 1024) != 0 ? null : null, (1424 & 2048) != 0 ? Boolean.FALSE : null, (1424 & 4096) != 0 ? null : null, (1424 & 8192) != 0 ? null : null, (1424 & 16384) != 0 ? null : null);
        }

        public final int g(Integer num) {
            int value = SubjectType.AUDIO.getValue();
            if (num != null && num.intValue() == value) {
                return R$mipmap.home_ic_audio_white_40;
            }
            int value2 = SubjectType.TV.getValue();
            if (num != null && num.intValue() == value2) {
                return R$mipmap.home_ic_tv_white_40;
            }
            return (num != null && num.intValue() == SubjectType.SHORT_TV.getValue()) ? R$mipmap.home_ic_short_tv_white : R$mipmap.home_ic_movie_white_40;
        }

        public final void h(Subject subject, String str) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Integer subjectType2 = subject.getSubjectType();
                postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("module_name", "opt_subject").withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
            } else {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = this.itemView.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                downloadManagerApiA.a2((FragmentActivity) context, str, (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            }
        }

        public final void i(final Subject subject, final or.a aVar, final String str) {
            String url;
            String thumbnail;
            Intrinsics.g(subject, "subject");
            ShapeableImageView shapeableImageView = this.f50960b;
            if (shapeableImageView != null) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.AUDIO.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
                    Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                    ((ViewGroup.MarginLayoutParams) bVar).width = f0.a(54.0f);
                    ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(54.0f);
                    shapeableImageView.setLayoutParams(bVar);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
                    Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
                    ((ViewGroup.MarginLayoutParams) bVar2).width = f0.a(54.0f);
                    ((ViewGroup.MarginLayoutParams) bVar2).height = f0.a(72.0f);
                    shapeableImageView.setLayoutParams(bVar2);
                }
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = subject.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int iA = f0.a(54.0f);
                int iA2 = f0.a(72.0f);
                Cover cover2 = subject.getCover();
                companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : iA2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            AppCompatTextView appCompatTextView = this.f50961c;
            if (appCompatTextView != null) {
                appCompatTextView.setText(subject.getImdbRate());
            }
            AppCompatTextView appCompatTextView2 = this.f50962d;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(subject.getTitle());
                Integer subjectType2 = subject.getSubjectType();
                appCompatTextView2.setMaxLines((subjectType2 != null && subjectType2.intValue() == SubjectType.AUDIO.getValue()) ? 1 : 2);
            }
            Date dateK = h0.k(subject.getReleaseDate(), "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateK);
            AppCompatTextView appCompatTextView3 = this.f50963f;
            if (appCompatTextView3 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
                String[] strings = z.a(subject.getGenre(), ",");
                if (strings != null) {
                    Intrinsics.f(strings, "strings");
                    for (String str2 : strings) {
                        spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str2);
                    }
                }
                if (!TextUtils.isEmpty(subject.getCountryName())) {
                    spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) subject.getCountryName());
                }
                appCompatTextView3.setText(spannableStringBuilder.toString());
                Drawable drawable = z2.a.getDrawable(appCompatTextView3.getContext(), g(subject.getSubjectType()));
                if (drawable != null) {
                    drawable.setTint(z2.a.getColor(appCompatTextView3.getContext(), R$color.white_40));
                }
                appCompatTextView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            l(subject);
            DownloadView downloadView = this.f50964g;
            if (downloadView != null) {
                downloadView.setOnClickListener(new View.OnClickListener(aVar, subject) { // from class: com.transsion.banner.adapter.e

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Subject f50965a;

                    {
                        this.f50965a = subject;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.b.j(null, this.f50965a, view);
                    }
                });
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.banner.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.b.k(this.f50966a, subject, str, view);
                }
            });
        }

        public final void l(Subject subject) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadView downloadView = this.f50964g;
                if (downloadView != null) {
                    so.c.k(downloadView);
                    return;
                }
                return;
            }
            if (!Intrinsics.b(subject.getHasResource(), Boolean.TRUE)) {
                DownloadView downloadView2 = this.f50964g;
                if (downloadView2 != null) {
                    so.c.g(downloadView2);
                    return;
                }
                return;
            }
            DownloadView downloadView3 = this.f50964g;
            if (downloadView3 != null) {
                so.c.k(downloadView3);
            }
            if (m.f51320a.b()) {
                DownloadView downloadView4 = this.f50964g;
                if (downloadView4 != null) {
                    downloadView4.setShowPlayType();
                    return;
                }
                return;
            }
            DownloadView downloadView5 = this.f50964g;
            if (downloadView5 != null) {
                String subjectId = subject.getSubjectId();
                ResourceDetectors resourceDetector = subject.getResourceDetector();
                DownloadView.setShowType$default(downloadView5, subjectId, resourceDetector != null ? resourceDetector.getResourceId() : null, Boolean.valueOf(subject.isSeries()), false, 0, 24, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends Subject> datas, String str) {
        Intrinsics.g(datas, "datas");
        this.f50958i = datas;
        this.f50959j = str;
    }

    public final List<Subject> d() {
        return this.f50958i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int i11) {
        Intrinsics.g(holder, "holder");
        uo.b.a.f(uo.b.f78622a, "OpSubjectAdapter", "position=" + i11 + " " + this, false, 4, null);
        holder.i(this.f50958i.get(i11), null, this.f50959j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_subjects_op, parent, false);
        Intrinsics.f(view, "view");
        return new b(view);
    }

    public final void g(or.a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50958i.size();
    }
}
