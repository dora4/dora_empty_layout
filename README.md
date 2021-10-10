# DoraEmptyLayout

描述：一个用来显示暂无数据、加载中和加载错误的布局容器

复杂度：★★☆☆☆

分组：【Dora大控件组】

关系：暂无

技术要点：自定义属性、向ViewGroup中添加控件

### 照片

![avatar](https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout_1.jpg)![avatar](https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout_2.jpg)![avatar](https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout_3.jpg)![avatar](https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout_4.jpg)

### 动图

![avatar](https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout.gif)

### 软件包

https://github.com/dora4/dora_empty_layout/blob/main/art/dora_empty_layout.apk

### 用法

它只能有且只有一个子控件，这个唯一的子控件作为content。通过调用showEmpty、showError、showLoading、showContent来改变显示，在onEmpty、onError、onLoading、onRefresh中处理回调。

```kotlin
emptyLayout = findViewById(R.id.emptyLayout)
        emptyLayout
                .onEmpty {
                    Toast.makeText(this@MainActivity, "onEmpty", Toast.LENGTH_SHORT).show()
                }
                .onError { e ->
                    val tvError = findViewById<TextView>(R.id.tvError)
                    tvError.text = e.message
                    Toast.makeText(this@MainActivity, "onError", Toast.LENGTH_SHORT).show()
                }
                .onLoading {
                    ((this as ImageView).drawable as AnimationDrawable).start()
                    Toast.makeText(this@MainActivity, "onLoading", Toast.LENGTH_SHORT).show()
                }
                .onRefresh {
                    Toast.makeText(this@MainActivity, "onRefresh", Toast.LENGTH_SHORT).show()
                }
```

| 自定义属性         | 描述               |
| ------------------ | ------------------ |
| dora_emptyLayout   | 配置空数据的布局   |
| dora_errorLayout   | 配置加载错误的布局 |
| dora_loadingLayout | 配置加载中的布局   |
