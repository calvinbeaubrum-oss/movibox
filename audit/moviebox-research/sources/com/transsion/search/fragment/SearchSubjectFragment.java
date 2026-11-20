package com.transsion.search.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.p;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.u;
import bx.i;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tn.lib.util.networkinfo.g;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.SearchManager;
import com.transsion.search.activity.SearchManagerActivity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.constant.SearchConstants;
import com.transsion.search.fragment.hot.SearchHotFragment;
import com.transsion.search.fragment.result.SearchResultFragment;
import com.transsion.search.fragment.suggest.SearchSuggestFragment;
import com.transsion.search.speech.SpeechRecognizerView;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class SearchSubjectFragment extends BaseFragment<i> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f57447n = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f57451d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f57452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f57453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SearchHotFragment f57454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SearchSuggestFragment f57455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SearchResultFragment f57456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f57457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f57458l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57448a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57449b = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f57459m = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchSubjectFragment a(String str, String str2, boolean z11) {
            SearchSubjectFragment searchSubjectFragment = new SearchSubjectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("hot_search_word", str);
            bundle.putString("keyword", str2);
            bundle.putBoolean("back_exit", z11);
            searchSubjectFragment.setArguments(bundle);
            return searchSubjectFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Boolean> f57460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchSubjectFragment f57461b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0<Boolean> function0, SearchSubjectFragment searchSubjectFragment) {
            super(true);
            this.f57460a = function0;
            this.f57461b = searchSubjectFragment;
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (this.f57460a.invoke().booleanValue()) {
                return;
            }
            setEnabled(false);
            this.f57461b.requireActivity().getOnBackPressedDispatcher().l();
            setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements SearchSuggestFragment.b {
        public c() {
        }

        @Override // com.transsion.search.fragment.suggest.SearchSuggestFragment.b
        public void a(SuggestEntity suggestEntity, int i11, String keyWord, String mOps) {
            Staff staff;
            String subjectId;
            Integer subjectType;
            String deeplink;
            EditText editText;
            Intrinsics.g(keyWord, "keyWord");
            Intrinsics.g(mOps, "mOps");
            i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14493b) != null) {
                KeyboardUtils.e(editText);
            }
            Integer type = suggestEntity != null ? suggestEntity.getType() : null;
            if (type != null && type.intValue() == 2) {
                VerticalRank verticalRank = suggestEntity.getVerticalRank();
                if (verticalRank == null || (deeplink = verticalRank.getDeeplink()) == null) {
                    return;
                }
                Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deeplink + "&ops=" + mOps));
                if (uriD != null) {
                    com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
                    return;
                }
                return;
            }
            String str = "";
            if (type == null || type.intValue() != 1) {
                if (type == null || type.intValue() != 0) {
                    if (type == null || type.intValue() != 3 || (staff = suggestEntity.getStaff()) == null) {
                        return;
                    }
                    com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", staff).navigation();
                    return;
                }
                SearchSubjectFragment.this.f57459m = keyWord;
                SearchSubjectFragment.this.f57458l = true;
                SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
                String word = suggestEntity.getWord();
                searchSubjectFragment.N0(word != null ? word : "");
                SearchSubjectFragment.this.E0("suggest");
                return;
            }
            try {
                Subject subject = suggestEntity.getSubject();
                if (subject != null) {
                    Integer subjectType2 = subject.getSubjectType();
                    int value = SubjectType.SHORT_TV.getValue();
                    if (subjectType2 != null && subjectType2.intValue() == value) {
                        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                        Context context = SearchSubjectFragment.this.getContext();
                        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        FragmentActivity fragmentActivity = (FragmentActivity) context;
                        Subject subject2 = suggestEntity.getSubject();
                        downloadManagerApiA.a2(fragmentActivity, "searchpage", (384 & 4) != 0 ? "" : "", subject2 != null ? subject2.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : suggestEntity.getSubject(), (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                        return;
                    }
                }
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Subject subject3 = suggestEntity.getSubject();
                Postcard postcardWithInt = postcardB.withInt("subject_type", (subject3 == null || (subjectType = subject3.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
                Subject subject4 = suggestEntity.getSubject();
                if (subject4 != null && (subjectId = subject4.getSubjectId()) != null) {
                    str = subjectId;
                }
                postcardWithInt.withString("id", str).withString("ops", mOps).navigation();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements g {
        public d() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            if (SearchSubjectFragment.this.f57453g instanceof SearchHotFragment) {
                Fragment fragment = SearchSubjectFragment.this.f57453g;
                Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.search.fragment.hot.SearchHotFragment");
                ((SearchHotFragment) fragment).onConnected();
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SearchSubjectFragment.this.f57457k) {
                SearchSubjectFragment.this.f57457k = false;
                return;
            }
            SearchSubjectFragment.this.f57449b = String.valueOf(editable);
            SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
            searchSubjectFragment.O0(searchSubjectFragment.f57449b);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextView textView;
            i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding == null || (textView = mViewBinding.f14501k) == null) {
                return;
            }
            so.c.k(textView);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchSubjectFragment.this.f57449b = String.valueOf(textView != null ? textView.getText() : null);
            SearchSubjectFragment.this.E0("input");
            return true;
        }
    }

    /* JADX INFO: renamed from: com.transsion.search.fragment.SearchSubjectFragment$initView$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        public static final void b(SearchSubjectFragment this$0) {
            EditText editText;
            EditText editText2;
            Intrinsics.g(this$0, "this$0");
            i mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (editText2 = mViewBinding.f14493b) != null) {
                editText2.requestFocus();
            }
            i mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 == null || (editText = mViewBinding2.f14493b) == null) {
                return;
            }
            KeyboardUtils.i(editText);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            EditText editText;
            if (!TextUtils.isEmpty(str)) {
                SearchSubjectFragment.this.N0(str == null ? "" : str);
                SearchSubjectFragment.this.E0("voice");
                com.transsion.search.speech.d.f57673a.b(SearchSubjectFragment.this.getClass().getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 隐藏键盘");
                return;
            }
            i mViewBinding = SearchSubjectFragment.this.getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14493b) != null) {
                final SearchSubjectFragment searchSubjectFragment = SearchSubjectFragment.this;
                editText.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchSubjectFragment.AnonymousClass2.b(searchSubjectFragment);
                    }
                }, 500L);
            }
            com.transsion.search.speech.d.f57673a.b(SearchSubjectFragment.this.getClass().getSimpleName() + " --> mViewBinding?.sRView?.setCallback{} --> onResult = " + str + " --> 拉起键盘");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D0() {
        B0();
        return true;
    }

    public static final void H0(SearchSubjectFragment this$0, View view) {
        EditText editText;
        Intrinsics.g(this$0, "this$0");
        i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f14493b) == null) {
            return;
        }
        editText.setText("");
    }

    public static final void I0(SearchSubjectFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.B0();
    }

    public static final void J0(SearchSubjectFragment this$0, View view) {
        TextView textView;
        Intrinsics.g(this$0, "this$0");
        i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f14501k) == null) {
            return;
        }
        so.c.k(textView);
    }

    public static final void K0(SearchSubjectFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0("input");
    }

    public static final void L0(SearchSubjectFragment this$0, View view, boolean z11) {
        EditText editText;
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        TextView textView;
        String string;
        EditText editText2;
        EditText editText3;
        ViewGroup.LayoutParams layoutParams2;
        ImageView imageView2;
        TextView textView2;
        Intrinsics.g(this$0, "this$0");
        if (!z11) {
            i mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (textView = mViewBinding.f14501k) != null) {
                so.c.g(textView);
            }
            i mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f14498h) != null) {
                so.c.k(imageView);
            }
            i mViewBinding3 = this$0.getMViewBinding();
            if (mViewBinding3 == null || (editText = mViewBinding3.f14493b) == null || (layoutParams = editText.getLayoutParams()) == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
                return;
            }
            ((RelativeLayout.LayoutParams) layoutParams).addRule(16, R$id.search_edit_clear);
            return;
        }
        i mViewBinding4 = this$0.getMViewBinding();
        if (mViewBinding4 != null && (textView2 = mViewBinding4.f14501k) != null) {
            so.c.k(textView2);
        }
        i mViewBinding5 = this$0.getMViewBinding();
        if (mViewBinding5 != null && (imageView2 = mViewBinding5.f14498h) != null) {
            so.c.g(imageView2);
        }
        i mViewBinding6 = this$0.getMViewBinding();
        if (mViewBinding6 != null && (editText3 = mViewBinding6.f14493b) != null && (layoutParams2 = editText3.getLayoutParams()) != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(16, R$id.tv_search);
        }
        if (this$0.f57453g instanceof SearchResultFragment) {
            i mViewBinding7 = this$0.getMViewBinding();
            Editable text = (mViewBinding7 == null || (editText2 = mViewBinding7.f14493b) == null) ? null : editText2.getText();
            if (text == null || text.length() <= 0) {
                this$0.F0(this$0.f57454h);
                return;
            }
            if (text == null || (string = text.toString()) == null) {
                string = "";
            }
            this$0.O0(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(String str) {
        EditText editText;
        EditText editText2;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f14493b) != null) {
            editText2.setText(str);
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (editText = mViewBinding2.f14493b) == null) {
            return;
        }
        editText.setSelection(str.length());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        i iVarC = i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    public final void B0() {
        EditText editText;
        Fragment fragment = this.f57453g;
        if (fragment instanceof SearchHotFragment) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.f57458l && !(fragment instanceof SearchSuggestFragment)) {
            if (fragment instanceof SearchResultFragment) {
                F0(this.f57455i);
            }
        } else {
            this.f57458l = false;
            i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (editText = mViewBinding.f14493b) == null) {
                return;
            }
            editText.setText("");
        }
    }

    public final void C0() {
        i mViewBinding;
        EditText editText;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("hot_search_word") : null;
        this.f57450c = string;
        if (string == null || string.length() <= 0 || (mViewBinding = getMViewBinding()) == null || (editText = mViewBinding.f14493b) == null) {
            return;
        }
        editText.setHint(this.f57450c);
    }

    public final void E0(String str) {
        i mViewBinding;
        EditText editText;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
        }
        if (this.f57449b.length() == 0 && (mViewBinding = getMViewBinding()) != null && (editText = mViewBinding.f14493b) != null && Intrinsics.b(editText.getHint(), this.f57450c)) {
            this.f57449b = String.valueOf(this.f57450c);
            this.f57457k = true;
            editText.setText(String.valueOf(this.f57450c));
            editText.setSelection(editText.getText().length());
            str = "hint";
        }
        if (this.f57449b.length() == 0) {
            h hVar = h.f50034a;
            hVar.e(16);
            hVar.l(getString(com.transsion.search.R$string.tips_movie));
            return;
        }
        SearchHotFragment searchHotFragment = this.f57454h;
        if (searchHotFragment != null) {
            searchHotFragment.addHistoryWord(this.f57449b);
        }
        SearchResultFragment searchResultFragment = this.f57456j;
        if (searchResultFragment != null) {
            searchResultFragment.B0(this.f57449b, str);
        }
        F0(this.f57456j);
    }

    public final void F0(Fragment fragment) {
        EditText editText;
        EditText editText2;
        if (fragment == null || Intrinsics.b(this.f57453g, fragment)) {
            return;
        }
        this.f57453g = fragment;
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        SearchHotFragment searchHotFragment = this.f57454h;
        if (searchHotFragment != null && !Intrinsics.b(this.f57453g, searchHotFragment)) {
            fragmentTransactionBeginTransaction.hide(searchHotFragment);
        }
        SearchSuggestFragment searchSuggestFragment = this.f57455i;
        if (searchSuggestFragment != null && !Intrinsics.b(this.f57453g, searchSuggestFragment)) {
            fragmentTransactionBeginTransaction.hide(searchSuggestFragment);
        }
        SearchResultFragment searchResultFragment = this.f57456j;
        if (searchResultFragment != null && !Intrinsics.b(this.f57453g, searchResultFragment)) {
            fragmentTransactionBeginTransaction.hide(searchResultFragment);
        }
        fragmentTransactionBeginTransaction.show(fragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        if (Intrinsics.b(fragment, this.f57456j)) {
            i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (editText2 = mViewBinding.f14493b) == null) {
                return;
            }
            editText2.clearFocus();
            KeyboardUtils.e(editText2);
            return;
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (editText = mViewBinding2.f14493b) == null) {
            return;
        }
        editText.requestFocus();
        KeyboardUtils.i(editText);
    }

    public final void G0(boolean z11) {
        i mViewBinding;
        EditText editText;
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        TextView textView;
        EditText editText5;
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (editText5 = mViewBinding2.f14493b) != null) {
            editText5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.J0(this.f57466a, view);
                }
            });
        }
        i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (textView = mViewBinding3.f14501k) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.K0(this.f57467a, view);
                }
            });
        }
        i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (editText4 = mViewBinding4.f14493b) != null) {
            editText4.addTextChangedListener(new e());
        }
        i mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (editText3 = mViewBinding5.f14493b) != null) {
            editText3.setOnEditorActionListener(new f());
        }
        i mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (editText2 = mViewBinding6.f14493b) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.c
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z12) {
                    SearchSubjectFragment.L0(this.f57468a, view, z12);
                }
            });
        }
        i mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (imageView = mViewBinding7.f14498h) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.H0(this.f57469a, view);
                }
            });
        }
        i mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (appCompatImageView = mViewBinding8.f14495d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchSubjectFragment.I0(this.f57470a, view);
                }
            });
        }
        if (!z11 && (mViewBinding = getMViewBinding()) != null && (editText = mViewBinding.f14493b) != null) {
            editText.requestFocus();
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        w0(this, new Function0<Boolean>() { // from class: com.transsion.search.fragment.SearchSubjectFragment$setListener$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.D0());
            }
        });
    }

    public final void M0() {
        String str;
        EditText editText;
        SearchConstants.a aVar = SearchConstants.f57439a;
        List<String> listA = aVar.a();
        if (listA == null || listA.isEmpty()) {
            return;
        }
        List<String> listA2 = aVar.a();
        int size = listA2 != null ? listA2.size() : 0;
        List<String> listA3 = aVar.a();
        if (listA3 != null) {
            int i11 = this.f57451d;
            this.f57451d = i11 + 1;
            str = (String) CollectionsKt___CollectionsKt.h0(listA3, i11 % size);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            this.f57450c = str;
        }
        i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f14493b) == null) {
            return;
        }
        editText.setHint(this.f57450c);
    }

    public final void O0(String str) {
        SearchSuggestFragment searchSuggestFragment;
        if (str.length() == 0) {
            F0(this.f57454h);
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            SearchManagerActivity.f57432m.a("showLinkageSearchFragment --> currently no network does not use linkage");
            return;
        }
        if (!TextUtils.isEmpty(str) && (searchSuggestFragment = this.f57455i) != null) {
            searchSuggestFragment.u0(str);
        }
        F0(this.f57455i);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        String string;
        ImageView imageView;
        EditText editText;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("keyword")) == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        this.f57452f = arguments2 != null ? arguments2.getBoolean("back_exit") : false;
        G0(string.length() > 0);
        if (string.length() > 0) {
            this.f57449b = string;
            i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14493b) != null) {
                editText.setText(this.f57449b);
            }
            i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f14498h) != null) {
                so.c.k(imageView);
            }
            E0(WebConstants.FIELD_DEEPLINK);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        SpeechRecognizerView speechRecognizerView;
        Intrinsics.g(view, "view");
        C0();
        setNetListener(new d());
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (speechRecognizerView = mViewBinding.f14497g) != null) {
            speechRecognizerView.setCallback(new AnonymousClass2());
        }
        v0();
        x0();
        y0();
        F0(this.f57454h);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    public final void v0() {
        if (this.f57454h == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            SearchHotFragment searchHotFragmentA = SearchHotFragment.Companion.a(this.f57450c);
            fragmentTransactionBeginTransaction.add(R$id.search_fragment_container, searchHotFragmentA);
            this.f57454h = searchHotFragmentA;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    public final p w0(u uVar, Function0<Boolean> function0) {
        b bVar = new b(function0, this);
        requireActivity().getOnBackPressedDispatcher().i(uVar, bVar);
        return bVar;
    }

    public final void x0() {
        if (this.f57455i == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            SearchSuggestFragment searchSuggestFragmentA = SearchSuggestFragment.f57595h.a();
            fragmentTransactionBeginTransaction.add(R$id.search_fragment_container, searchSuggestFragmentA);
            this.f57455i = searchSuggestFragmentA;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            SearchSuggestFragment searchSuggestFragment = this.f57455i;
            if (searchSuggestFragment != null) {
                searchSuggestFragment.v0(new c());
            }
        }
    }

    public final void y0() {
        if (this.f57456j == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            SearchResultFragment searchResultFragment = new SearchResultFragment();
            fragmentTransactionBeginTransaction.add(R$id.search_fragment_container, searchResultFragment);
            this.f57456j = searchResultFragment;
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
    }

    public final void z0(String keyWord, String str, Function1<? super String, Unit> callback) {
        EditText editText;
        EditText editText2;
        Intrinsics.g(keyWord, "keyWord");
        Intrinsics.g(callback, "callback");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
        this.f57449b = keyWord;
        this.f57457k = true;
        i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (editText2 = mViewBinding.f14493b) != null) {
            editText2.setText(this.f57449b);
        }
        i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (editText = mViewBinding2.f14493b) != null) {
            editText.setSelection(this.f57449b.length());
        }
        this.f57448a = 1;
        E0(str);
        SearchManager.f57422f.a().e(this.f57449b);
        callback.invoke(keyWord);
    }
}
