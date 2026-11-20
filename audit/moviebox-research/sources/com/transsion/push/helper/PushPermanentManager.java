package com.transsion.push.helper;

import android.app.Application;
import android.text.format.DateUtils;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PushConfigHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import uo.b;

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
public final class PushPermanentManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PermanentConfig f56898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f56899e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f56902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q1 f56903i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushPermanentManager f56895a = new PushPermanentManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56896b = LazyKt__LazyJVMKt.b(new Function0<kw.a>() { // from class: com.transsion.push.helper.PushPermanentManager$mApi$2
        @Override // kotlin.jvm.functions.Function0
        public final kw.a invoke() {
            return (kw.a) NetServiceGenerator.f49399d.a().i(kw.a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<PermanentItemBean> f56897c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f56900f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f56901g = "";

    public final void o() {
        if (PushConfigHelper.INSTANCE.isAbType()) {
            j.d(l0.a(w0.b()), null, null, new PushPermanentManager$checkShow$1(null), 3, null);
        }
    }

    public final void p(String deepLink) {
        Object next;
        Intrinsics.g(deepLink, "deepLink");
        b.a.f(b.f78622a, "PUSH_SHOW", "clickMsg deeplink:" + deepLink + ",pushCacheList:" + f56897c.size(), false, 4, null);
        Iterator<T> it = f56897c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((PermanentItemBean) next).getDeeplink(), deepLink));
        PermanentItemBean permanentItemBean = (PermanentItemBean) next;
        if (permanentItemBean == null) {
            return;
        }
        f56897c.remove(permanentItemBean);
        if (f56897c.size() < 10) {
            q();
        } else {
            v();
        }
        j.d(l0.a(w0.b()), null, null, new PushPermanentManager$clickMsg$1(permanentItemBean, null), 3, null);
    }

    public final void q() {
        j.d(l0.a(w0.b()), null, null, new PushPermanentManager$fetchPushData$1(null), 3, null);
    }

    public final kw.a r() {
        return (kw.a) f56896b.getValue();
    }

    public final String s() {
        return f56901g;
    }

    public final boolean t() {
        return DateUtils.isToday(f56902h);
    }

    public final void u(long j11) {
        b.a.f(b.f78622a, "PUSH_SHOW", "loopRequest time:" + j11, false, 4, null);
        f56903i = j.d(l0.a(w0.b()), null, null, new PushPermanentManager$loopRequest$1(j11, null), 3, null);
    }

    public final void v() {
        PermanentConfig permanentConfig = f56898d;
        if (permanentConfig != null) {
            if (!permanentConfig.getEnable() || !w(permanentConfig)) {
                return;
            }
            if (f56903i == null && permanentConfig.getInterval() > 0) {
                u(((long) (permanentConfig.getInterval() * 6)) * 1000);
            }
        }
        PushShowPermanentHelper pushShowPermanentHelper = PushShowPermanentHelper.f56904a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        pushShowPermanentHelper.k(applicationA, f56897c);
    }

    public final boolean w(PermanentConfig permanentConfig) {
        List listL;
        try {
            Result.Companion companion = Result.Companion;
            String startTime = permanentConfig.getStartTime();
            if (startTime == null) {
                return true;
            }
            List<String> listSplit = new Regex(":").split(startTime, 0);
            if (!listSplit.isEmpty()) {
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
            } else {
                listL = g.l();
                break;
            }
            String[] strArr = (String[]) listL.toArray(new String[0]);
            int i11 = Integer.parseInt(strArr[0]);
            int i12 = Integer.parseInt(strArr[1]);
            Calendar calendar = Calendar.getInstance();
            int i13 = calendar.get(11);
            int i14 = calendar.get(12);
            b.a.f(b.f78622a, "PUSH_SHOW", "timeReady, cur:" + i13 + ":" + i14 + ",time:" + i11, false, 4, null);
            if (i13 <= i11) {
                return i13 == i11 && i14 >= i12;
            }
            return true;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
            return true;
        }
    }
}
