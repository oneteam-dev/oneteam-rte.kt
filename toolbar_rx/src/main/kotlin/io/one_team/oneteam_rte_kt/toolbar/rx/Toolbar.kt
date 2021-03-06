package io.one_team.oneteam_rte_kt.toolbar.rx

import io.one_team.oneteam_rte_kt.toolbar.Toolbar
import rx.Observable

fun Toolbar.imageButtonClicks(): Observable<Unit> =
        Observable.create<Unit> { o -> addOnClickImageButtonListener { o.onNext(Unit) } }
                .doOnCompleted { removeOnClickImageButtonListener() }
                .doOnError { removeOnClickImageButtonListener() }
