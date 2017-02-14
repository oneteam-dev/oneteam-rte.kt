package io.one_team.oneteam_rte_kt.core

import rx.Observable

fun RichTextEditorView.contentChanges(): Observable<String> =
        Observable.create<String> { o -> this.onContentChanged = { o.onNext(it) } }
                .doOnError { this.onContentChanged = null }
                .doOnCompleted { this.onContentChanged = null }

fun RichTextEditorView.inlineStylesChanges(): Observable<List<InlineStyle>> =
        Observable.create<List<InlineStyle>> { o -> this.onInlineStylesChanged = { o.onNext(it) } }
                .doOnError { this.onInlineStylesChanged = null }
                .doOnCompleted { this.onInlineStylesChanged = null }

fun RichTextEditorView.blockStyleChanges(): Observable<BlockStyle> =
        Observable.create<BlockStyle> { o -> this.onBlockStyleChanged = { o.onNext(it) } }
                .doOnError { this.onBlockStyleChanged = null }
                .doOnCompleted { this.onBlockStyleChanged = null }
