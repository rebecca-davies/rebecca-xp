package com.rebecca.fetch

import com.rebecca.fetch.template.folder

/**
 *  The built HTML being inserted after processing the current directory
 *
 *  @return the HTML being inserted into the template
 */
fun built(): String {
    return instantiate().sort().built()
}

/**
 *  Templates the files in the directory after sorting them for display order
 *
 *  @return the HTML ready to be inserted into the template
 */
private fun List<File>.built(): String {
    return this.joinToString(separator = "") {
        template(it)
    }
}

/**
 *  Templates the file based on its MIME type
 *
 *  @return the <div> built and ready to be joined into a string of HTML
 */
fun template(file: File): String {
    return folder(file)
}
