# MVVM Core
Library to use MVVM pattern easily

## Sample Usage
### Enabling Data Binding
To configure your app to use data binding, add the dataBinding element to your build.gradle file in the app module.
```
android {
    ....
    dataBinding {
        enabled = true
    }
}
```

### XML Layout (main_activity.xml)
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="android.view.View"/>

        <variable
            name="vm"
            type="id.gits.mvvmsample.main.MainActivityVM"/>
    </data>

    <android.support.design.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"/>

        </android.support.design.widget.AppBarLayout>

        <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:adapter="@{vm.bAdapter}"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            app:layoutManager="@{vm.bLayoutManager}"/>

    </android.support.design.widget.CoordinatorLayout>
</layout>
```
### Activity (MainActivity.java)
```
public class MainActivity extends GitsActivity<MainController> {

   @Override
   protected int getToolbarId() {
      return R.id.toolbar;
   }
   
   @Override
   protected int getResLayout() {
      return R.layout.main_activity;
   }
   
   @Override
   protected MainController createController() {
      return new MainController();
   }
}
```

### Controller (MainController.java)
```
public class MainController extends GitsController<MainActivityVM, MainActivityBinding> {
   /*@Override
   public MainActivityVM createViewModel(AppCompatActivity activity, MainActivityBinding binding) {
      return new MainActivityVM(activity, this, binding);
   }*/
   
   @Override
   public MainActivityVM getmViewModel(MainActivityBinding binding) {
      return new MainActivityVM(mActivity, this, binding);
   }
   
   @Override
   public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
      binding.setVm(viewModel);
   }
   
   @Override
   public void onCreateController(Bundle savedInstanceState) {
      //TODO your onCreate

   }
}
```

### View Model (MainActivityVM.java)
```
public class MainActivityVM extends GitsVM<MainController, MainActivityBinding> {
   private final List<DummyDao> mList = new ArrayList<>();
   public DummyAdapter bAdapter;
   public LinearLayoutManager bLayoutManager;
   
   public MainActivityVM(AppCompatActivity activity, MainController controller, MainActivityBinding binding) {
      super(activity, controller, binding);
      
      //create dummy data
      mList.add(new DummyDao("Hello World"));
      mList.add(new DummyDao("Lorem Ipsum"));
      
      bAdapter = new DummyAdapter(mList);
      bLayoutManager = new LinearLayoutManager(activity);
   }
}
```

### Adapter (DummyAdapter.java)
```
public class DummyAdapter extends GitsAdapter<DummyDao, DummyRowVM, DummyRowBinding> {
   public DummyAdapter(List<DummyDao> collection) {
      super(collection);
   }
   
   @Override
   public DummyRowVM createViewModel(AppCompatActivity activity, DummyRowBinding binding, DummyDao item) {
      return new DummyRowVM(activity, binding, item);
   }
   
   @Override
   public int getLayoutRes() {
      return R.layout.dummy_row;
   }
   
   @Override
   public void render(DummyRowBinding binding, DummyRowVM viewModel, DummyDao item) {
      binding.setVm(viewModel);
   }
   
   @Override
   public void onRowClick(DummyDao data, int position) {
      Toast.makeText(mContext, "Hello " + mCollection.get(position), Toast.LENGTH_SHORT).show();
   }
}
```
For complete sample usage, you can take a look at the sample project.

## Install
The latest version is available in the Sonatype snapshots repo.
```
repositories {
   mavenCentral()
   mavenLocal()
   maven {
        url "https://oss.sonatype.org/content/repositories/snapshots"
    }
}
dependencies {
   compile 'id.gits:mvvmcore:0.0.4-SNAPSHOT'
}
```

## License
```
Copyright 2016 GITS Indonesia.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
