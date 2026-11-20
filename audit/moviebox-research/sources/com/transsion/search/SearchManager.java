package com.transsion.search;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.transsion.search.SearchManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SearchManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f57422f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<SearchManager> f57423g = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SearchManager>() { // from class: com.transsion.search.SearchManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchManager invoke() {
            return new SearchManager();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f57427d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57425b = "kv_search_group";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f57426c = "kv_search_work";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f57428e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MMKV f57424a = MMKV.z("kv_search_list");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchManager a() {
            return (SearchManager) SearchManager.f57423g.getValue();
        }
    }

    public static final void f(SearchManager this$0) {
        Intrinsics.g(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this$0.f57428e);
        b.a.f(b.f78622a, "VS_SM", "add" + arrayList, false, 4, null);
        int i11 = this$0.f57427d;
        if (i11 != 1) {
            if (i11 == 2) {
                MMKV mmkv = this$0.f57424a;
                if (mmkv != null) {
                    mmkv.putString(this$0.f57425b, n.j(arrayList));
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
        }
        MMKV mmkv2 = this$0.f57424a;
        if (mmkv2 != null) {
            mmkv2.putString(this$0.f57426c, n.j(arrayList));
        }
    }

    public static final void i(SearchManager this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f57428e.clear();
        int i11 = this$0.f57427d;
        if (i11 != 1) {
            if (i11 == 2) {
                MMKV mmkv = this$0.f57424a;
                if (mmkv != null) {
                    mmkv.putString(this$0.f57425b, "");
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
        }
        MMKV mmkv2 = this$0.f57424a;
        if (mmkv2 != null) {
            mmkv2.putString(this$0.f57426c, "");
        }
    }

    public static final void l(SearchManager this$0, xw.a callback) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callback, "$callback");
        callback.a(this$0.j());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    public final void e(String keyword) {
        Intrinsics.g(keyword, "keyword");
        if (this.f57428e.contains(keyword)) {
            this.f57428e.remove(keyword);
            this.f57428e.add(keyword);
        } else {
            int i11 = this.f57427d;
            if (i11 == 1) {
                if (this.f57428e.size() >= 10) {
                    this.f57428e.remove(0);
                }
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (this.f57428e.size() >= 10) {
                        this.f57428e.remove(0);
                    }
                }
            } else if (this.f57428e.size() >= 10) {
                this.f57428e.remove(0);
            }
            this.f57428e.add(keyword);
        }
        if (this.f57428e.isEmpty()) {
            return;
        }
        g(new Runnable() { // from class: xw.d
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.f(this.f80713a);
            }
        });
    }

    public final void g(Runnable runnable) {
        ThreadExecute.f57429b.a().b(runnable);
    }

    public final void h() {
        g(new Runnable() { // from class: xw.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.i(this.f80710a);
            }
        });
    }

    @SuppressLint({"Range"})
    public final List<String> j() {
        List<String> arrayList;
        String string = null;
        if (this.f57427d == 2) {
            MMKV mmkv = this.f57424a;
            if (mmkv != null) {
                string = mmkv.getString(this.f57425b, "");
            }
        } else {
            MMKV mmkv2 = this.f57424a;
            if (mmkv2 != null) {
                string = mmkv2.getString(this.f57426c, "");
            }
        }
        b.a.f(b.f78622a, "VS_SM", "findSearch" + string, false, 4, null);
        if (TextUtils.isEmpty(string) || TextUtils.equals(string, "{}")) {
            arrayList = new ArrayList<>();
        } else {
            Object objE = n.e(string, new TypeToken<List<String>>() { // from class: com.transsion.search.SearchManager$findSearch$list$type$1
            }.getType());
            Intrinsics.f(objE, "{\n            val type =…son(json, type)\n        }");
            arrayList = (List) objE;
        }
        arrayList.isEmpty();
        this.f57428e = arrayList;
        return arrayList;
    }

    public final void k(int i11, final xw.a callback) {
        Intrinsics.g(callback, "callback");
        this.f57427d = i11;
        g(new Runnable() { // from class: xw.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.l(this.f80711a, callback);
            }
        });
    }
}
