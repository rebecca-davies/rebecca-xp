package com.rebecca.fetch.template

import com.rebecca.fetch.File
import com.rebecca.fetch.imageIcon
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

/**
 *  Templates an image <div> to be read as HTML
 *
 *  @param file the file being templated
 *  @return the HTML after templating to be displayed
 */
fun image(file: File): String {
    val sb = StringBuilder()
    val tagConsumer = sb.appendHTML()
    return with(tagConsumer) {
        div {
            id = "file"
            img(classes = "image") {
                src = imageIcon
            }
            p {
                id = "name"
                +file.name
            }
            p {
                id = "type"
                +"Image"
            }
            p {
                id = "size"
                +"${file.size} KB"
            }
        }
    }.toString()
}