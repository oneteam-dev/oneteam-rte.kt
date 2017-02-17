# oneteam-rte-kt
[![CircleCI](https://circleci.com/gh/oneteam-dev/oneteam-rte-kt.svg?style=shield)](https://circleci.com/gh/oneteam-dev/oneteam-rte-kt)
[![](https://jitpack.io/v/oneteam-dev/oneteam-rte-kt.svg)](https://jitpack.io/#oneteam-dev/oneteam-rte-kt)
[![codecov](https://codecov.io/gh/oneteam-dev/oneteam-rte-kt/branch/master/graph/badge.svg)](https://codecov.io/gh/oneteam-dev/oneteam-rte-kt)

oneteam-rte-kt is a Kotlin / Android wrapper for [oneteam-rte](https://github.com/oneteam-dev/oneteam-rte)

## How to use

There is a [sample project](sample).

### Add dependencies

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    compile 'com.github.oneteam-dev.oneteam-rte-kt:core:x.y.z'

    // If you want to use default toolbar, add this line.
    compile 'com.github.oneteam-dev.oneteam-rte-kt:toolbar:x.y.z'

    // If you are using RxKotlin or RxJava, there are adapters for it.
    compile 'com.github.oneteam-dev.oneteam-rte-kt:core_rx:x.y.z'
    compile 'com.github.oneteam-dev.oneteam-rte-kt:toolbar_rx:x.y.z'
}
```

### Include RichTextEditorView

```diff
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:id="@+id/activity_main"
    android:layout_width="match_parent" android:layout_height="match_parent" />
+    <io.one_team.oneteam_rte_kt.toolbar.Toolbar
+        android:id="@+id/toolbar"
+        android:layout_width="match_parent"
+        android:layout_height="wrap_content"
+        android:layout_alignParentTop="true" />
+    <io.one_team.oneteam_rte_kt.core.RichTextEditorView
+        android:id="@+id/editor"
+        android:layout_width="match_parent"
+        android:layout_height="match_parent"
+        android:layout_below="@id/toolbar"/>
</RelativeLayout>
```

### Setup toolbar

#### if you're using default toolbar
```kotlin
class MainActivity {
    override fun onAttachedToWindow() {
        toolbar.editor = editor
        toolbar.addOnClickImageButtonListener {
            // Prompt which image to use and call RichtextEditorView::insertImage
        }

        toolbar.addOnClickInsertLinkButtonListener {
            // Prompt what link to use and call RichtextEditorView::insertLink
        }
    }
}
```

#### or implement toolbar by yourself
please see
- [RichTextEditorView](core/src/main/kotlin/io/one_team/oneteam_rte_kt/core/RichTextEditorView.kt)
- [Toolbar](toolbar/src/main/kotlin/io/one_team/oneteam_rte_kt/toolbar/Toolbar.kt)

## Development

To change `js` directory, run command

```
npm install && npm run build:watch
```

And necessary assets will be generated in `core/main/assets` directory.

### Publish

```
git tag x.x.x
./gradlew release
```

And you can see artifact in [Jitpack.io](https://jitpack.io)
