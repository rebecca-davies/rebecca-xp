package com.rebecca

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 *	The WindowsApplication program acts as a web-server used to host
 *	a directory listing styled after Windows XP.
 *
 * 	@author Rebecca Davies <email@rebecca.sh>
 * 	@since 2022-03-11
 */

@SpringBootApplication
class WindowsApplication

fun main(args: Array<String>) {
	runApplication<WindowsApplication>(*args)
}
