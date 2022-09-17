package com.aking.readfiletest.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileInputStream

/**
 * Created by Rick on 2022-09-16  10:34.
 * God bless my code!
 * @Description:
 */
class FileBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val uri = intent?.getParcelableExtra<Uri>("skin_path")
        Log.d("uri--------->", "$uri")
        Log.d("uri.path--------->", "${uri?.path}")
        uri?.let {
            val file = File(it.path)
            Log.d("file.name------------>", file.name)
            Log.d("file.absolutePath------------>", file.absolutePath)

            context?.contentResolver?.openFileDescriptor(uri,"rw")?.let {
                val readText = FileInputStream(it.fileDescriptor).reader().readText()
                Log.d("readText----->",readText)
            }
        }
    }
}