package com.jaeger.library

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class SelectableTextView : android.support.v7.widget.AppCompatTextView {

     lateinit var mSelectableTextHelper: SelectableTextHelper

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {

    }

    /**
     *
     * @param menuId Int 操作菜单布局
     * @param selectAreaColor Int 选取区域的颜色
     * @param handlerColor Int 选取器的颜色
     * @param handlerSize Float 选取器的大小
     * @param selectListener ()->Unit //选择时的监听事件
     */
    fun setSelectable(menuId:Int,selectAreaColor:Int,handlerColor:Int,
                      handlerSize:Float,selectListener:()->Unit) {
        mSelectableTextHelper = SelectableTextHelper
                .Builder(this, menuId)//受作用的TextView以及弹出窗口的布局ID
                .setSelectedColor(selectAreaColor)//选取区域的颜色
                .setCursorHandleSizeInDp(handlerSize)//选取器的大小
                .setCursorHandleColor(handlerColor)//选取器的颜色
                .build()
        mSelectableTextHelper?.setSelectListener {
            //选择时的监听事件
            selectListener.invoke()
        }
    }

    fun getMenuView(): View {
        return mSelectableTextHelper.contentView
    }

    /**
     * 对所选文本进行复制
     * @param finishCopy ()->Unit
     */
    fun copy(finishCopy:()->Unit){
        if(mSelectableTextHelper!=null){
            mSelectableTextHelper?.doCopy { finishCopy.invoke() }
        }
    }

    /**
     * 选择当前textview的全部文本
     * @param finishSelectAll (text:String)->Unit
     */
    fun selectAll(finishSelectAll:(text:String)->Unit){
        if(mSelectableTextHelper!=null){
            mSelectableTextHelper?.doSelectAll {
                finishSelectAll.invoke(it)
            }
        }
    }
}
