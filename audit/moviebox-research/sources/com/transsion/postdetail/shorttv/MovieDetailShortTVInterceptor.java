package com.transsion.postdetail.shorttv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.videofloat.VideoPipManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes.dex */
@Interceptor(name = "/movie/shorttv_interceptor", priority = 2)
@Metadata
@SourceDebugExtension
public final class MovieDetailShortTVInterceptor implements IInterceptor {
    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.alibaba.android.arouter.facade.template.IInterceptor
    public void process(Postcard postcard, InterceptorCallback interceptorCallback) {
        Integer numL;
        Object objM163constructorimpl;
        Integer numL2;
        Object next;
        String localClassName;
        unit = null;
        Unit unit = null;
        if (!((postcard != null ? postcard.getContext() : null) instanceof Activity)) {
            Iterator<T> it = RoomActivityLifecycleCallbacks.f51239a.e().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    localClassName = ((Activity) next).getLocalClassName();
                    Intrinsics.f(localClassName, "it.localClassName");
                }
            } while (!StringsKt__StringsKt.Q(localClassName, "MainActivity", false, 2, null));
            Context context = (Activity) next;
            if (context == null) {
                context = postcard != null ? postcard.getContext() : null;
            }
            if (postcard != null) {
                postcard.setContext(context);
            }
        }
        if (!Intrinsics.b(postcard != null ? postcard.getPath() : null, "/movie/detail")) {
            if (!Intrinsics.b(postcard != null ? postcard.getPath() : null, "/video/detail")) {
                if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    return;
                }
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                Bundle extras = postcard.getExtras();
                SubjectType subjectType = SubjectType.MOVIE;
                int value = extras.getInt("subject_type", subjectType.getValue());
                if (value < 0) {
                    String queryParameter = postcard.getUri().getQueryParameter("subject_type");
                    value = (queryParameter == null || (numL2 = kotlin.text.k.l(queryParameter)) == null) ? subjectType.getValue() : numL2.intValue();
                }
                if (value == SubjectType.MUSIC.getValue()) {
                    com.alibaba.android.arouter.launcher.a.d().b("/playvideo/music_detail").with(postcard.getExtras()).navigation(postcard.getContext());
                    if (interceptorCallback != null) {
                        interceptorCallback.onInterrupt(new RuntimeException("music detail intercept to music detail activity"));
                        unit = Unit.f68710a;
                    }
                } else if (interceptorCallback != null) {
                    interceptorCallback.onContinue(postcard);
                    unit = Unit.f68710a;
                }
                objM163constructorimpl = Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null || interceptorCallback == null) {
                return;
            }
            interceptorCallback.onContinue(postcard);
            return;
        }
        try {
            Bundle extras2 = postcard.getExtras();
            SubjectType subjectType2 = SubjectType.MOVIE;
            int value2 = extras2.getInt("subject_type", subjectType2.getValue());
            if (value2 < 0) {
                String queryParameter2 = postcard.getUri().getQueryParameter("subject_type");
                value2 = (queryParameter2 == null || (numL = kotlin.text.k.l(queryParameter2)) == null) ? subjectType2.getValue() : numL.intValue();
            }
            VideoPipManager.a.a(VideoPipManager.f60024a.a(), false, 1, null);
            if (value2 == SubjectType.SHORT_TV.getValue()) {
                com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").with(postcard.getExtras()).navigation(postcard.getContext());
                if (interceptorCallback != null) {
                    interceptorCallback.onInterrupt(new RuntimeException("movie detail intercept to shortTV"));
                    return;
                }
                return;
            }
            if (value2 != SubjectType.MUSIC.getValue()) {
                if (!com.transsion.baselib.utils.m.f51320a.b()) {
                    if (interceptorCallback != null) {
                        interceptorCallback.onContinue(postcard);
                        return;
                    }
                    return;
                } else {
                    com.alibaba.android.arouter.launcher.a.d().b("/playvideo/detail").with(postcard.getExtras()).navigation(postcard.getContext());
                    if (interceptorCallback != null) {
                        interceptorCallback.onInterrupt(new RuntimeException("movie detail intercept to play video"));
                        return;
                    }
                    return;
                }
            }
            try {
                Result.Companion companion3 = Result.Companion;
                String queryParameter3 = postcard.getUri().getQueryParameter("is_music_liked_fragment");
                Boolean boolValueOf = queryParameter3 != null ? Boolean.valueOf(Boolean.parseBoolean(queryParameter3)) : null;
                postcard.getExtras().putBoolean("is_music_liked_fragment", boolValueOf != null ? boolValueOf.booleanValue() : false);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th3));
            }
            com.alibaba.android.arouter.launcher.a.d().b("/playvideo/music_detail").with(postcard.getExtras()).navigation(postcard.getContext());
            if (interceptorCallback != null) {
                interceptorCallback.onInterrupt(new RuntimeException("music detail intercept to music detail activity"));
            }
        } catch (Exception unused) {
            if (interceptorCallback != null) {
                interceptorCallback.onContinue(postcard);
            }
        }
    }
}
