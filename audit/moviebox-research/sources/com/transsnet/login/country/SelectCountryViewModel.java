package com.transsnet.login.country;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.transsion.gslb.Utils;
import com.transsnet.loginapi.bean.Country;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;

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
public final class SelectCountryViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<List<Country>> f61459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<String>> f61460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Integer> f61461d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<l00.a<Country>> f61462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, Integer> f61463g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectCountryViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f61459b = new c0<>();
        this.f61460c = new c0<>();
        this.f61461d = new c0<>();
        this.f61462f = new c0<>();
        k();
    }

    public static final int m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.g(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public final LiveData<List<Country>> e() {
        return this.f61459b;
    }

    public final Integer f(String str) {
        HashMap<String, Integer> map = this.f61463g;
        if (map == null) {
            return null;
        }
        Intrinsics.d(map);
        return map.get(str);
    }

    public final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strSubstring = str.substring(0, 1);
        Intrinsics.f(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String upperCase = strSubstring.toUpperCase(locale);
        Intrinsics.f(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final LiveData<Integer> h() {
        return this.f61461d;
    }

    public final LiveData<l00.a<Country>> i() {
        return this.f61462f;
    }

    public final LiveData<List<String>> j() {
        return this.f61460c;
    }

    public final void k() {
        j.d(u0.a(this), w0.b(), null, new SelectCountryViewModel$initData$1(this, null), 2, null);
    }

    public final void l() throws Throwable {
        ArrayList<Country> arrayListA = m00.b.b().a(b());
        Intrinsics.f(arrayListA, "getInstance().getCountry…rayList(getApplication())");
        final SelectCountryViewModel$initPccInfo$1 selectCountryViewModel$initPccInfo$1 = new Function2<Country, Country, Integer>() { // from class: com.transsnet.login.country.SelectCountryViewModel$initPccInfo$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(Country obj, Country country) {
                Intrinsics.g(obj, "obj");
                return Integer.valueOf(obj.compareTo(country));
            }
        };
        kotlin.collections.j.z(arrayListA, new Comparator() { // from class: com.transsnet.login.country.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SelectCountryViewModel.m(selectCountryViewModel$initPccInfo$1, obj, obj2);
            }
        });
        n(arrayListA);
    }

    public final void n(List<? extends Country> list) {
        if (list == null || list.isEmpty()) {
            this.f61460c.n(null);
            return;
        }
        if (this.f61463g == null) {
            this.f61463g = new HashMap<>();
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Country country : list) {
            String country2 = country.getCountry();
            Intrinsics.f(country2, "item.country");
            String strG = g(country2);
            if (!TextUtils.isEmpty(strG) && !CollectionsKt___CollectionsKt.X(arrayList, strG)) {
                country.setIndex(strG);
                Intrinsics.d(strG);
                arrayList.add(strG);
                Integer numValueOf = Integer.valueOf(i11);
                HashMap<String, Integer> map = this.f61463g;
                Intrinsics.d(map);
                map.put(strG, numValueOf);
            }
            i11++;
        }
        arrayList.add(Utils.SEPARATOR);
        HashMap<String, Integer> map2 = this.f61463g;
        Intrinsics.d(map2);
        map2.put(Utils.SEPARATOR, Integer.valueOf(i11 - 1));
        this.f61459b.n(list);
        this.f61460c.n(arrayList);
    }

    public final void o(String index) {
        Intrinsics.g(index, "index");
        this.f61461d.q(f(index));
    }

    public final void p(Country country) {
        if (country != null) {
            this.f61462f.q(new l00.a<>(country));
        }
    }
}
