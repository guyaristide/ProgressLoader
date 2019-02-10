# ProgressLoader
Android kotlin extension preloader

# usage

xml


```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/llRoot"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

    <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

</LinearLayout>

```


kotlin

```kotlin


import com.dev.neiba.progressloader.views.ProgressLoader

private lateinit var progress: ProgressLoader

progress = ProgressLoader(llRoot)
progress.show(message = "Chargement ...")


```
