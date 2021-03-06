//package org.kottpd

import org.kottpd.pal.Reader

data class HttpRequest(val method: HttpMethod,
                       val url: String,
                       val httpVersion: String,
                       val headers: Map<String, String>,
                       val stream: Reader) {
    val content: String by lazy {
        (1..headers.getOrElse("Content-Length", { "0" }).toInt()).fold("", { a, b -> a + stream.read().toChar() })
    }
}