package com.transsion.subtitle.helper;

import android.app.Application;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okio.Okio;
import tr.o;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class SubtitleSearchHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f58255c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f58256d = com.transsion.baselib.report.a.f51248a.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<SubtitleSearchHelper> f58257e = LazyKt__LazyJVMKt.b(new Function0<SubtitleSearchHelper>() { // from class: com.transsion.subtitle.helper.SubtitleSearchHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubtitleSearchHelper invoke() {
            return new SubtitleSearchHelper();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58258a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f58259b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSearchHelper a() {
            return (SubtitleSearchHelper) SubtitleSearchHelper.f58257e.getValue();
        }
    }

    public final String d(DownloadBean downloadBean) {
        String name;
        if (downloadBean == null || (name = downloadBean.getTitleName()) == null) {
            name = downloadBean != null ? downloadBean.getName() : null;
            if (name == null) {
                name = "";
            }
        }
        String strF = name;
        String str = (downloadBean != null ? Integer.valueOf(downloadBean.getResolution()) : null) + "P";
        if (StringsKt__StringsKt.Q(strF, (downloadBean != null ? Integer.valueOf(downloadBean.getResolution()) : null) + "P", false, 2, null)) {
            strF = l.F(strF, str, "", false, 4, null);
        }
        return new Regex("[\\\\/:#*?\"<>|&]_-").replace(strF, " ");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:25:0x00c1->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(Continuation<? super Unit> continuation) throws Throwable {
        SubtitleSearchHelper$initLocalLanguage$1 subtitleSearchHelper$initLocalLanguage$1;
        o oVarN0;
        SubtitleSearchHelper subtitleSearchHelper;
        o oVar;
        Iterator it;
        SubtitleLanguageMapBean subtitleLanguageMapBean;
        if (continuation instanceof SubtitleSearchHelper$initLocalLanguage$1) {
            subtitleSearchHelper$initLocalLanguage$1 = (SubtitleSearchHelper$initLocalLanguage$1) continuation;
            int i11 = subtitleSearchHelper$initLocalLanguage$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                subtitleSearchHelper$initLocalLanguage$1.label = i11 - Integer.MIN_VALUE;
            } else {
                subtitleSearchHelper$initLocalLanguage$1 = new SubtitleSearchHelper$initLocalLanguage$1(this, continuation);
            }
        } else {
            subtitleSearchHelper$initLocalLanguage$1 = new SubtitleSearchHelper$initLocalLanguage$1(this, continuation);
        }
        Object objA = subtitleSearchHelper$initLocalLanguage$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = subtitleSearchHelper$initLocalLanguage$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                oVarN0 = (o) subtitleSearchHelper$initLocalLanguage$1.L$1;
                subtitleSearchHelper = (SubtitleSearchHelper) subtitleSearchHelper$initLocalLanguage$1.L$0;
                ResultKt.b(objA);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) subtitleSearchHelper$initLocalLanguage$1.L$1;
                oVar = (o) subtitleSearchHelper$initLocalLanguage$1.L$0;
                ResultKt.b(objA);
            }
            while (it.hasNext()) {
                subtitleLanguageMapBean = (SubtitleLanguageMapBean) it.next();
                subtitleSearchHelper$initLocalLanguage$1.L$0 = oVar;
                subtitleSearchHelper$initLocalLanguage$1.L$1 = it;
                subtitleSearchHelper$initLocalLanguage$1.label = 2;
                if (oVar.c(subtitleLanguageMapBean, subtitleSearchHelper$initLocalLanguage$1) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
        ResultKt.b(objA);
        AppDatabase.v0 v0Var = AppDatabase.f51036p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        oVarN0 = v0Var.b(applicationA).N0();
        subtitleSearchHelper$initLocalLanguage$1.L$0 = this;
        subtitleSearchHelper$initLocalLanguage$1.L$1 = oVarN0;
        subtitleSearchHelper$initLocalLanguage$1.label = 1;
        objA = oVarN0.a(subtitleSearchHelper$initLocalLanguage$1);
        if (objA == objE) {
            return objE;
        }
        subtitleSearchHelper = this;
        List list = (List) objA;
        if (list == null || list.isEmpty()) {
            List subtitleList = (List) n.e(subtitleSearchHelper.g(), new TypeToken<List<SubtitleLanguageMapBean>>() { // from class: com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$type$1
            }.getType());
            uo.b.a.o(uo.b.f78622a, f58256d, new String[]{"initLocalLanguage, localListSize:" + subtitleList.size() + ", insert "}, false, 4, null);
            Intrinsics.f(subtitleList, "subtitleList");
            oVar = oVarN0;
            it = subtitleList.iterator();
            while (it.hasNext()) {
                subtitleLanguageMapBean = (SubtitleLanguageMapBean) it.next();
                subtitleSearchHelper$initLocalLanguage$1.L$0 = oVar;
                subtitleSearchHelper$initLocalLanguage$1.L$1 = it;
                subtitleSearchHelper$initLocalLanguage$1.label = 2;
                if (oVar.c(subtitleLanguageMapBean, subtitleSearchHelper$initLocalLanguage$1) == objE) {
                    return objE;
                }
            }
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0219 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:102:0x021a  */
    /* JADX WARN: Code duplicated, block: B:108:0x025e A[Catch: all -> 0x027b, TryCatch #4 {all -> 0x027b, blocks: (B:106:0x0258, B:108:0x025e, B:114:0x0280, B:116:0x0284, B:124:0x029b, B:118:0x028a, B:120:0x028e), top: B:156:0x0258 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0278  */
    /* JADX WARN: Code duplicated, block: B:113:0x027f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0284 A[Catch: all -> 0x027b, TryCatch #4 {all -> 0x027b, blocks: (B:106:0x0258, B:108:0x025e, B:114:0x0280, B:116:0x0284, B:124:0x029b, B:118:0x028a, B:120:0x028e), top: B:156:0x0258 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x028a A[Catch: all -> 0x027b, TryCatch #4 {all -> 0x027b, blocks: (B:106:0x0258, B:108:0x025e, B:114:0x0280, B:116:0x0284, B:124:0x029b, B:118:0x028a, B:120:0x028e), top: B:156:0x0258 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02c2 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x02de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:147:0x0313  */
    /* JADX WARN: Code duplicated, block: B:149:0x0347 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:159:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:? A[LOOP:0: B:156:0x0258->B:161:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x015d A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0172 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0182 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0190 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x019c A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01ac A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c8 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01da A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01ee A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:141:0x02fb, B:104:0x0224, B:27:0x0087, B:135:0x02df, B:59:0x0120, B:61:0x0127, B:64:0x012f, B:66:0x015d, B:69:0x0182, B:70:0x018a, B:72:0x0190, B:74:0x019c, B:75:0x019e, B:77:0x01ac, B:78:0x01b0, B:83:0x01be, B:85:0x01c2, B:96:0x01fe, B:99:0x0204, B:87:0x01c8, B:88:0x01d4, B:90:0x01da, B:92:0x01ee, B:93:0x01f2, B:67:0x0172, B:128:0x02b8, B:130:0x02bc, B:132:0x02c2), top: B:154:0x0028 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:147:0x0313, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0063: MOVE (r4 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:22:0x0063 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final Object f(Continuation<? super Unit> continuation) throws Throwable {
        SubtitleSearchHelper$innerUpdateLanguageList$1 subtitleSearchHelper$innerUpdateLanguageList$1;
        Object obj;
        Object objM163constructorimpl;
        SubtitleSearchHelper subtitleSearchHelper;
        Throwable thM166exceptionOrNullimpl;
        SubtitleSearchHelper subtitleSearchHelper2;
        List<SubtitleLanguageMapBean> subtitleList;
        o oVar;
        SubtitleSearchHelper subtitleSearchHelper3;
        List<SubtitleLanguageMapBean> list;
        List list2;
        List list3;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Locale locale;
        boolean z11;
        List list4;
        SubtitleSearchHelper subtitleSearchHelper4;
        Locale locale2;
        SubtitleSearchHelper subtitleSearchHelper5;
        o oVar2;
        Iterator it;
        Ref.BooleanRef booleanRef3;
        Ref.BooleanRef booleanRef4;
        Locale locale3;
        String strComponent1;
        String str;
        SubtitleLanguageMapBean subtitleLanguageMapBean;
        if (continuation instanceof SubtitleSearchHelper$innerUpdateLanguageList$1) {
            subtitleSearchHelper$innerUpdateLanguageList$1 = (SubtitleSearchHelper$innerUpdateLanguageList$1) continuation;
            int i11 = subtitleSearchHelper$innerUpdateLanguageList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                subtitleSearchHelper$innerUpdateLanguageList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                subtitleSearchHelper$innerUpdateLanguageList$1 = new SubtitleSearchHelper$innerUpdateLanguageList$1(this, continuation);
            }
        } else {
            subtitleSearchHelper$innerUpdateLanguageList$1 = new SubtitleSearchHelper$innerUpdateLanguageList$1(this, continuation);
        }
        Object obj2 = subtitleSearchHelper$innerUpdateLanguageList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        ?? r11 = subtitleSearchHelper$innerUpdateLanguageList$1.label;
        try {
            try {
                switch (r11) {
                    case 0:
                        ResultKt.b(obj2);
                        if (this.f58259b) {
                            return Unit.f68710a;
                        }
                        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 1;
                            if (e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                            return Unit.f68710a;
                        }
                        try {
                            Result.Companion companion = Result.Companion;
                            ConfigBean configBeanB = ConfigManager.f53111c.a().b("subtitle_language", true);
                            String value = configBeanB != null ? configBeanB.getValue() : null;
                            if (value != null && value.length() > 0) {
                                List list5 = (List) n.e(value, new TypeToken<List<SubtitleLanguageMapBean>>() { // from class: com.transsion.subtitle.helper.SubtitleSearchHelper$innerUpdateLanguageList$2$type$1
                                }.getType());
                                this.f58259b = true;
                                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                                Application applicationA = Utils.a();
                                Intrinsics.f(applicationA, "getApp()");
                                o oVarN0 = v0Var.b(applicationA).N0();
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = this;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = list5;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = oVarN0;
                                subtitleSearchHelper$innerUpdateLanguageList$1.label = 2;
                                Object objA = oVarN0.a(subtitleSearchHelper$innerUpdateLanguageList$1);
                                if (objA == objE) {
                                    return objE;
                                }
                                subtitleList = list5;
                                oVar = oVarN0;
                                obj2 = objA;
                                subtitleSearchHelper3 = this;
                                list = (List) obj2;
                                list2 = subtitleList;
                                if (list2 != null && !list2.isEmpty()) {
                                    uo.b.a.f(uo.b.f78622a, f58256d, "get language , list = " + subtitleList, false, 4, null);
                                    booleanRef = new Ref.BooleanRef();
                                    booleanRef2 = new Ref.BooleanRef();
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        locale = Utils.a().getResources().getConfiguration().getLocales().get(0);
                                    } else {
                                        locale = Utils.a().getResources().getConfiguration().locale;
                                    }
                                    if (list != null) {
                                        z11 = false;
                                        for (SubtitleLanguageMapBean subtitleLanguageMapBean2 : list) {
                                            if (subtitleLanguageMapBean2.getInSearch()) {
                                                booleanRef.element = true;
                                            }
                                            if (Intrinsics.b(subtitleLanguageMapBean2.getLanAbbr(), locale.getLanguage())) {
                                                booleanRef.element = true;
                                                booleanRef2.element = true;
                                            }
                                            if (Intrinsics.b(subtitleLanguageMapBean2.getLanAbbr(), "en")) {
                                                z11 = true;
                                            }
                                        }
                                    } else {
                                        z11 = false;
                                    }
                                    list4 = list;
                                    if (list4 != null || list4.isEmpty()) {
                                        Intrinsics.f(subtitleList, "subtitleList");
                                        for (SubtitleLanguageMapBean subtitleLanguageMapBean3 : subtitleList) {
                                            if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), locale.getLanguage())) {
                                                booleanRef.element = true;
                                                booleanRef2.element = true;
                                            }
                                            if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), "en")) {
                                                z11 = true;
                                            }
                                        }
                                    }
                                    if (!booleanRef.element && z11) {
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper3;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = subtitleList;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = oVar;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = booleanRef2;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = locale;
                                        subtitleSearchHelper$innerUpdateLanguageList$1.label = 4;
                                        if (oVar.b("en", true, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                            return objE;
                                        }
                                        Locale locale4 = locale;
                                        subtitleSearchHelper4 = subtitleSearchHelper3;
                                        locale2 = locale4;
                                        SubtitleSearchHelper subtitleSearchHelper6 = subtitleSearchHelper4;
                                        locale = locale2;
                                        subtitleSearchHelper3 = subtitleSearchHelper6;
                                    }
                                    uo.b.a.f(uo.b.f78622a, f58256d, "get language new,locale =" + locale.getLanguage() + " list = " + subtitleList, false, 4, null);
                                    Iterator it2 = subtitleList.iterator();
                                    subtitleSearchHelper5 = subtitleSearchHelper3;
                                    oVar2 = oVar;
                                    it = it2;
                                    booleanRef3 = booleanRef;
                                    booleanRef4 = booleanRef2;
                                    locale3 = locale;
                                    while (it.hasNext()) {
                                        try {
                                            SubtitleLanguageMapBean subtitleLanguageMapBean4 = (SubtitleLanguageMapBean) it.next();
                                            strComponent1 = subtitleLanguageMapBean4.component1();
                                            String strComponent2 = subtitleLanguageMapBean4.component2();
                                            String strComponent3 = subtitleLanguageMapBean4.component3();
                                            if (Intrinsics.b(strComponent1, "in_id")) {
                                                str = "in";
                                            } else {
                                                str = strComponent1;
                                            }
                                            subtitleLanguageMapBean = new SubtitleLanguageMapBean(strComponent1, strComponent2, strComponent3, (booleanRef3.element && Intrinsics.b(str, "en")) || (booleanRef4.element && Intrinsics.b(str, locale3.getLanguage())));
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper5;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = oVar2;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = booleanRef3;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef4;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = locale3;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = it;
                                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 5;
                                            if (oVar2.c(subtitleLanguageMapBean, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                                return objE;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r11 = subtitleSearchHelper5;
                                            Result.Companion companion2 = Result.Companion;
                                            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                                            subtitleSearchHelper = r11;
                                        }
                                    }
                                    subtitleSearchHelper2 = subtitleSearchHelper5;
                                }
                                list3 = list;
                                if (list3 != null || list3.isEmpty()) {
                                    uo.b.a.u(uo.b.f78622a, f58256d, "language list all null~", false, 4, null);
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper3;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.label = 3;
                                    if (subtitleSearchHelper3.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                        return objE;
                                    }
                                }
                                return Unit.f68710a;
                            }
                            uo.b.a.u(uo.b.f78622a, f58256d, "get language list null~", false, 4, null);
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = this;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 6;
                            if (e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                            subtitleSearchHelper2 = this;
                            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                            subtitleSearchHelper = subtitleSearchHelper2;
                        } catch (Throwable th3) {
                            th = th3;
                            r11 = this;
                            Result.Companion companion3 = Result.Companion;
                            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                            subtitleSearchHelper = r11;
                            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                            if (thM166exceptionOrNullimpl != null) {
                                subtitleSearchHelper.f58259b = false;
                                uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                                if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                    return objE;
                                }
                            }
                            return Unit.f68710a;
                        }
                        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                        if (thM166exceptionOrNullimpl != null) {
                            subtitleSearchHelper.f58259b = false;
                            uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                            if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 1:
                        ResultKt.b(obj2);
                        return Unit.f68710a;
                    case 2:
                        o oVar3 = (o) subtitleSearchHelper$innerUpdateLanguageList$1.L$2;
                        List list6 = (List) subtitleSearchHelper$innerUpdateLanguageList$1.L$1;
                        SubtitleSearchHelper subtitleSearchHelper7 = (SubtitleSearchHelper) subtitleSearchHelper$innerUpdateLanguageList$1.L$0;
                        try {
                            ResultKt.b(obj2);
                            oVar = oVar3;
                            subtitleList = list6;
                            subtitleSearchHelper3 = subtitleSearchHelper7;
                            list = (List) obj2;
                            list2 = subtitleList;
                            if (list2 != null) {
                                uo.b.a.f(uo.b.f78622a, f58256d, "get language , list = " + subtitleList, false, 4, null);
                                booleanRef = new Ref.BooleanRef();
                                booleanRef2 = new Ref.BooleanRef();
                                if (Build.VERSION.SDK_INT >= 24) {
                                    locale = Utils.a().getResources().getConfiguration().getLocales().get(0);
                                } else {
                                    locale = Utils.a().getResources().getConfiguration().locale;
                                }
                                if (list != null) {
                                    z11 = false;
                                    while (r14.hasNext()) {
                                        if (subtitleLanguageMapBean2.getInSearch()) {
                                            booleanRef.element = true;
                                        }
                                        if (Intrinsics.b(subtitleLanguageMapBean2.getLanAbbr(), locale.getLanguage())) {
                                            booleanRef.element = true;
                                            booleanRef2.element = true;
                                        }
                                        if (Intrinsics.b(subtitleLanguageMapBean2.getLanAbbr(), "en")) {
                                            z11 = true;
                                        }
                                    }
                                } else {
                                    z11 = false;
                                }
                                list4 = list;
                                if (list4 != null) {
                                    Intrinsics.f(subtitleList, "subtitleList");
                                    while (r0.hasNext()) {
                                        if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), locale.getLanguage())) {
                                            booleanRef.element = true;
                                            booleanRef2.element = true;
                                        }
                                        if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), "en")) {
                                            z11 = true;
                                        }
                                    }
                                } else {
                                    Intrinsics.f(subtitleList, "subtitleList");
                                    while (r0.hasNext()) {
                                        if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), locale.getLanguage())) {
                                            booleanRef.element = true;
                                            booleanRef2.element = true;
                                        }
                                        if (Intrinsics.b(subtitleLanguageMapBean3.getLanAbbr(), "en")) {
                                            z11 = true;
                                        }
                                    }
                                }
                                if (!booleanRef.element) {
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper3;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = subtitleList;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = oVar;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = booleanRef2;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = locale;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.label = 4;
                                    if (oVar.b("en", true, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                        return objE;
                                    }
                                    Locale locale5 = locale;
                                    subtitleSearchHelper4 = subtitleSearchHelper3;
                                    locale2 = locale5;
                                    SubtitleSearchHelper subtitleSearchHelper8 = subtitleSearchHelper4;
                                    locale = locale2;
                                    subtitleSearchHelper3 = subtitleSearchHelper8;
                                }
                                uo.b.a.f(uo.b.f78622a, f58256d, "get language new,locale =" + locale.getLanguage() + " list = " + subtitleList, false, 4, null);
                                Iterator it3 = subtitleList.iterator();
                                subtitleSearchHelper5 = subtitleSearchHelper3;
                                oVar2 = oVar;
                                it = it3;
                                booleanRef3 = booleanRef;
                                booleanRef4 = booleanRef2;
                                locale3 = locale;
                                while (it.hasNext()) {
                                    SubtitleLanguageMapBean subtitleLanguageMapBean5 = (SubtitleLanguageMapBean) it.next();
                                    strComponent1 = subtitleLanguageMapBean5.component1();
                                    String strComponent4 = subtitleLanguageMapBean5.component2();
                                    String strComponent5 = subtitleLanguageMapBean5.component3();
                                    if (Intrinsics.b(strComponent1, "in_id")) {
                                        str = "in";
                                    } else {
                                        str = strComponent1;
                                    }
                                    subtitleLanguageMapBean = new SubtitleLanguageMapBean(strComponent1, strComponent4, strComponent5, (booleanRef3.element && Intrinsics.b(str, "en")) || (booleanRef4.element && Intrinsics.b(str, locale3.getLanguage())));
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper5;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = oVar2;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = booleanRef3;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef4;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = locale3;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = it;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.label = 5;
                                    if (oVar2.c(subtitleLanguageMapBean, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                        return objE;
                                    }
                                    break;
                                }
                                subtitleSearchHelper2 = subtitleSearchHelper5;
                                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                                subtitleSearchHelper = subtitleSearchHelper2;
                                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                                if (thM166exceptionOrNullimpl != null) {
                                    subtitleSearchHelper.f58259b = false;
                                    uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                                    subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                                    if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                        return objE;
                                    }
                                }
                                return Unit.f68710a;
                            }
                            list3 = list;
                            if (list3 != null) {
                                uo.b.a.u(uo.b.f78622a, f58256d, "language list all null~", false, 4, null);
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper3;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.label = 3;
                                if (subtitleSearchHelper3.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                    return objE;
                                }
                            } else {
                                uo.b.a.u(uo.b.f78622a, f58256d, "language list all null~", false, 4, null);
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper3;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.label = 3;
                                if (subtitleSearchHelper3.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                    return objE;
                                }
                            }
                            return Unit.f68710a;
                        } catch (Throwable th4) {
                            th = th4;
                            r11 = subtitleSearchHelper7;
                            Result.Companion companion4 = Result.Companion;
                            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                            subtitleSearchHelper = r11;
                            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                            if (thM166exceptionOrNullimpl != null) {
                                subtitleSearchHelper.f58259b = false;
                                uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                                subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                                if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                    return objE;
                                }
                            }
                            return Unit.f68710a;
                        }
                    case 3:
                        ResultKt.b(obj2);
                        return Unit.f68710a;
                    case 4:
                        locale2 = (Locale) subtitleSearchHelper$innerUpdateLanguageList$1.L$5;
                        booleanRef2 = (Ref.BooleanRef) subtitleSearchHelper$innerUpdateLanguageList$1.L$4;
                        booleanRef = (Ref.BooleanRef) subtitleSearchHelper$innerUpdateLanguageList$1.L$3;
                        oVar = (o) subtitleSearchHelper$innerUpdateLanguageList$1.L$2;
                        subtitleList = (List) subtitleSearchHelper$innerUpdateLanguageList$1.L$1;
                        subtitleSearchHelper4 = (SubtitleSearchHelper) subtitleSearchHelper$innerUpdateLanguageList$1.L$0;
                        ResultKt.b(obj2);
                        SubtitleSearchHelper subtitleSearchHelper9 = subtitleSearchHelper4;
                        locale = locale2;
                        subtitleSearchHelper3 = subtitleSearchHelper9;
                        uo.b.a.f(uo.b.f78622a, f58256d, "get language new,locale =" + locale.getLanguage() + " list = " + subtitleList, false, 4, null);
                        Iterator it4 = subtitleList.iterator();
                        subtitleSearchHelper5 = subtitleSearchHelper3;
                        oVar2 = oVar;
                        it = it4;
                        booleanRef3 = booleanRef;
                        booleanRef4 = booleanRef2;
                        locale3 = locale;
                        while (it.hasNext()) {
                            SubtitleLanguageMapBean subtitleLanguageMapBean6 = (SubtitleLanguageMapBean) it.next();
                            strComponent1 = subtitleLanguageMapBean6.component1();
                            String strComponent6 = subtitleLanguageMapBean6.component2();
                            String strComponent7 = subtitleLanguageMapBean6.component3();
                            if (Intrinsics.b(strComponent1, "in_id")) {
                                str = "in";
                            } else {
                                str = strComponent1;
                            }
                            subtitleLanguageMapBean = new SubtitleLanguageMapBean(strComponent1, strComponent6, strComponent7, (booleanRef3.element && Intrinsics.b(str, "en")) || (booleanRef4.element && Intrinsics.b(str, locale3.getLanguage())));
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper5;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = oVar2;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = booleanRef3;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef4;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = locale3;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = it;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 5;
                            if (oVar2.c(subtitleLanguageMapBean, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                            break;
                        }
                        subtitleSearchHelper2 = subtitleSearchHelper5;
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        subtitleSearchHelper = subtitleSearchHelper2;
                        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                        if (thM166exceptionOrNullimpl != null) {
                            subtitleSearchHelper.f58259b = false;
                            uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                            if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 5:
                        it = (Iterator) subtitleSearchHelper$innerUpdateLanguageList$1.L$5;
                        locale3 = (Locale) subtitleSearchHelper$innerUpdateLanguageList$1.L$4;
                        booleanRef4 = (Ref.BooleanRef) subtitleSearchHelper$innerUpdateLanguageList$1.L$3;
                        booleanRef3 = (Ref.BooleanRef) subtitleSearchHelper$innerUpdateLanguageList$1.L$2;
                        oVar2 = (o) subtitleSearchHelper$innerUpdateLanguageList$1.L$1;
                        SubtitleSearchHelper subtitleSearchHelper10 = (SubtitleSearchHelper) subtitleSearchHelper$innerUpdateLanguageList$1.L$0;
                        ResultKt.b(obj2);
                        subtitleSearchHelper5 = subtitleSearchHelper10;
                        while (it.hasNext()) {
                            SubtitleLanguageMapBean subtitleLanguageMapBean7 = (SubtitleLanguageMapBean) it.next();
                            strComponent1 = subtitleLanguageMapBean7.component1();
                            String strComponent8 = subtitleLanguageMapBean7.component2();
                            String strComponent9 = subtitleLanguageMapBean7.component3();
                            if (Intrinsics.b(strComponent1, "in_id")) {
                                str = "in";
                            } else {
                                str = strComponent1;
                            }
                            subtitleLanguageMapBean = new SubtitleLanguageMapBean(strComponent1, strComponent8, strComponent9, (booleanRef3.element && Intrinsics.b(str, "en")) || (booleanRef4.element && Intrinsics.b(str, locale3.getLanguage())));
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = subtitleSearchHelper5;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = oVar2;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = booleanRef3;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = booleanRef4;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = locale3;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = it;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 5;
                            if (oVar2.c(subtitleLanguageMapBean, subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                            break;
                        }
                        subtitleSearchHelper2 = subtitleSearchHelper5;
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        subtitleSearchHelper = subtitleSearchHelper2;
                        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                        if (thM166exceptionOrNullimpl != null) {
                            subtitleSearchHelper.f58259b = false;
                            uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                            if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 6:
                        SubtitleSearchHelper subtitleSearchHelper11 = (SubtitleSearchHelper) subtitleSearchHelper$innerUpdateLanguageList$1.L$0;
                        ResultKt.b(obj2);
                        subtitleSearchHelper2 = subtitleSearchHelper11;
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        subtitleSearchHelper = subtitleSearchHelper2;
                        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                        if (thM166exceptionOrNullimpl != null) {
                            subtitleSearchHelper.f58259b = false;
                            uo.b.a.j(uo.b.f78622a, f58256d, "get language list error:" + thM166exceptionOrNullimpl, false, 4, null);
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$0 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$1 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$2 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$3 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$4 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.L$5 = null;
                            subtitleSearchHelper$innerUpdateLanguageList$1.label = 7;
                            if (subtitleSearchHelper.e(subtitleSearchHelper$innerUpdateLanguageList$1) == objE) {
                                return objE;
                            }
                        }
                        return Unit.f68710a;
                    case 7:
                        ResultKt.b(obj2);
                        return Unit.f68710a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            r11 = obj;
        }
    }

    public final String g() {
        try {
            InputStream it = Utils.a().getResources().getAssets().open("sub_def_la.json");
            Intrinsics.f(it, "it");
            return Okio.buffer(Okio.source(it)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void h() {
        j.d(l0.a(w0.b()), null, null, new SubtitleSearchHelper$updateLanguageList$1(this, null), 3, null);
    }
}
