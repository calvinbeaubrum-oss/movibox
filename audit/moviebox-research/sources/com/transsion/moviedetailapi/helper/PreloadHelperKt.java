package com.transsion.moviedetailapi.helper;

import android.content.Context;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.CustomData;
import com.transsion.moviedetailapi.bean.FilterItem;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
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
public final class PreloadHelperKt {
    public static final void a(Context context, List<OperateItem> list) {
        Cover cover;
        String url;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Subject feedsSubject = ((OperateItem) it.next()).getFeedsSubject();
                if (feedsSubject != null && (cover = feedsSubject.getCover()) != null && (url = cover.getUrl()) != null && context != null) {
                    b(url);
                }
            }
        }
    }

    public static final void b(String str) {
        ImageHelper.Companion companion = ImageHelper.f51371a;
        final String strE = companion.e(str, (124 & 2) != 0 ? 0 : companion.b(), (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
        uo.b.a.f(uo.b.f78622a, "ImageHelper", "preload url=" + strE, false, 4, null);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        companion.w(strE, str, companion.b(), new Function1<Boolean, Unit>() { // from class: com.transsion.moviedetailapi.helper.PreloadHelperKt$preloadImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (!z11) {
                    uo.b.a.f(uo.b.f78622a, "ImageHelper", strE + " 预加载失败", false, 4, null);
                    return;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                uo.b.a.f(uo.b.f78622a, "ImageHelper", "预加载成功 duration=" + jCurrentTimeMillis2 + " url=" + strE, false, 4, null);
            }
        });
    }

    public static final void c(Context context, List<PostSubjectItem> list) {
        Cover cover;
        String url;
        List<Image> image;
        if (list != null) {
            for (PostSubjectItem postSubjectItem : list) {
                Media media = postSubjectItem.getMedia();
                if (media != null && (image = media.getImage()) != null) {
                    Iterator<T> it = image.iterator();
                    while (it.hasNext()) {
                        String url2 = ((Image) it.next()).getUrl();
                        if (url2 != null && context != null) {
                            b(url2);
                        }
                    }
                }
                Media media2 = postSubjectItem.getMedia();
                if (media2 != null && (cover = media2.getCover()) != null && (url = cover.getUrl()) != null && context != null) {
                    b(url);
                }
            }
        }
    }

    public static final void d(Context context, List<OperateItem> list) {
        String url;
        CustomData customData;
        List<BannerData> items;
        String url2;
        String url3;
        String url4;
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                OperateItem operateItem = (OperateItem) obj;
                if (i11 >= 2) {
                    String type = operateItem.getType();
                    if (Intrinsics.b(type, PostItemType.FILTER.getValue())) {
                        List<FilterItem> filters = operateItem.getFilters();
                        if (filters != null) {
                            int i13 = 0;
                            for (Object obj2 : filters) {
                                int i14 = i13 + 1;
                                if (i13 < 0) {
                                    g.u();
                                }
                                FilterItem filterItem = (FilterItem) obj2;
                                if (i13 < 3) {
                                    Cover image = filterItem.getImage();
                                    if (image == null || (url4 = image.getUrl()) == null) {
                                        url4 = "";
                                    }
                                    b(url4);
                                }
                                i13 = i14;
                            }
                        }
                    } else if (Intrinsics.b(type, PostItemType.PLAY_LIST.getValue()) || Intrinsics.b(type, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
                        List<AppointSubject> subjects = operateItem.getSubjects();
                        if (subjects != null) {
                            int i15 = 0;
                            for (Object obj3 : subjects) {
                                int i16 = i15 + 1;
                                if (i15 < 0) {
                                    g.u();
                                }
                                AppointSubject appointSubject = (AppointSubject) obj3;
                                if (i15 < 4) {
                                    Cover cover = appointSubject.getCover();
                                    if (cover == null || (url = cover.getUrl()) == null) {
                                        url = "";
                                    }
                                    b(url);
                                }
                                i15 = i16;
                            }
                        }
                    } else if (Intrinsics.b(type, PostItemType.RANKING_LIST_NUMBER.getValue())) {
                        List<AppointSubject> subjects2 = operateItem.getSubjects();
                        if (subjects2 != null) {
                            int i17 = 0;
                            for (Object obj4 : subjects2) {
                                int i18 = i17 + 1;
                                if (i17 < 0) {
                                    g.u();
                                }
                                AppointSubject appointSubject2 = (AppointSubject) obj4;
                                if (i17 < 2) {
                                    Cover cover2 = appointSubject2.getCover();
                                    if (cover2 == null || (url3 = cover2.getUrl()) == null) {
                                        url3 = "";
                                    }
                                    b(url3);
                                }
                                i17 = i18;
                            }
                        }
                    } else if (Intrinsics.b(type, PostItemType.CUSTOM_DATA.getValue()) && (customData = operateItem.getCustomData()) != null && (items = customData.getItems()) != null) {
                        int i19 = 0;
                        for (Object obj5 : items) {
                            int i21 = i19 + 1;
                            if (i19 < 0) {
                                g.u();
                            }
                            BannerData bannerData = (BannerData) obj5;
                            CustomData customData2 = operateItem.getCustomData();
                            if (i19 < (customData2 != null ? customData2.getRowCount() : 0)) {
                                Image image2 = bannerData.getImage();
                                if (image2 == null || (url2 = image2.getUrl()) == null) {
                                    url2 = "";
                                }
                                b(url2);
                            }
                            i19 = i21;
                        }
                    }
                }
                i11 = i12;
            }
        }
    }
}
