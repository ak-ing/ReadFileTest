package com.aking.readfiletest

import android.Manifest
import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.aking.readfiletest.receiver.FileBroadcastReceiver
import java.io.File
import java.io.FileInputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 0)
    }

    /**
     * 注册广播
     */
    private fun init() {
        val fileBroadcastReceiver = FileBroadcastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.visteon.txzing.appstore.action.themeChanged")
        registerReceiver(fileBroadcastReceiver, intentFilter)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("Range")
    fun click(view: View) {
//        val uri = Uri.parse("content://media/external/downloads/44")
//        val file = File(uri.path)
//        Log.d("file.name------------>", file.name)
//        Log.d("file.absolutePath------------>", file.absolutePath)

//        contentResolver?.openFileDescriptor(uri, "rw")?.let {
//            val readText = FileInputStream(it.fileDescriptor).reader().readText()
//            Log.d("readText----->", readText)
//        }


        val uri = Uri.parse("content://com.visteon.txzing.appstore.skinFileProvider/download1/test.txt")
        Log.d("uri--------->", "$uri")
        Log.d("uri.path--------->", "${uri?.path}")
        uri?.let {
            val file = File(it.path)
            Log.d("file.name------------>", file.name)
            Log.d("file.absolutePath------------>", file.absolutePath)

            contentResolver?.openFileDescriptor(uri,"rw")?.let {
                val readText = FileInputStream(it.fileDescriptor).reader().readText()
                Log.d("readText----->",readText)
            }
        }


//        val cursor: Cursor? = contentResolver.query(MediaStore.Downloads.EXTERNAL_CONTENT_URI, null, null, null, null, null)
//        cursor?.let {
//            while (cursor.moveToNext()) {
//                val fileName: String? = cursor.getString(cursor.getColumnIndex(MediaStore.Downloads.DISPLAY_NAME))
//                Log.e(javaClass.simpleName, "fileName = $fileName")
//            }
//            cursor.close()
//        }


//        val uri = Uri.parse("content://com.visteon.txzing.appstore.fileProvider/d1/text.txt")
//        Log.d("uri--------->", "$uri")
//        Log.d("uri.path--------->", "${uri?.path}")
//        uri?.let {
//            val file = File(it.path)
//            Log.d("file.name------------>", file.name)
//            Log.d("file.absolutePath------------>", file.absolutePath)
//
//            contentResolver?.openFileDescriptor(uri,"rw")?.let {
//                val readText = FileInputStream(it.fileDescriptor).reader().readText()
//                Log.d("readText----->",readText)
//            }
//        }
    }

}