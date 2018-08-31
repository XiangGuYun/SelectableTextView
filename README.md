# SelectableTextView
Add custom selection for TextView

![](img.png)

### How To Use
```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectTV.setSelectable(R.layout.layout_operate_windows,//window menu's layoutId
                resources.getColor(R.color.selected_blue), //selected area's color
                resources.getColor(R.color.cursor_handle_color), // selector's color
                20f //selector's size
        ) { println("selected")}//selected listener

        selectTV.getMenuView().findViewById<TextView>(R.id.tv_copy).setOnClickListener {
            //do copy operate
            selectTV.copy { Toast.makeText(this,"COPY SUCCESS!",Toast.LENGTH_SHORT).show() }
        }

        selectTV.getMenuView().findViewById<TextView>(R.id.tv_select_all).setOnClickListener {
            //do select all operate
            selectTV.selectAll { Toast.makeText(this, "SELECT SUCCESS! $it",Toast.LENGTH_SHORT).show() }
        }
    }
```