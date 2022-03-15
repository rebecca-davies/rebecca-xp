package com.rebecca.fetch.template

import com.rebecca.fetch.FileData
import com.rebecca.fetch.folderIcon
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

/**
 *  Templates a folder <div> to be read as HTML
 *
 *  @param file the file being templated
 *  @return the HTML after templating to be displayed
 */
fun folder(file: FileData): String {
    val sb = StringBuilder()
    val tagConsumer = sb.appendHTML()
    return with(tagConsumer) {
        div {
            id = "file"
            attributes["data"] = file.hashCode().toString()
            img(classes = "file") {
                src = folderIcon
            }
            p { +file.name }
        }
    }.toString()
}