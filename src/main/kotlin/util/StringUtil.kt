package util

import java.text.SimpleDateFormat
import java.util.*

private val sdfDate = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)
private val sdfDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ROOT)

fun String.indicesOf(char: Char, ignoreCase: Boolean = true): List<Int> {
    val regex = if (ignoreCase) Regex(char.toString(), RegexOption.IGNORE_CASE) else Regex(char.toString())
    return regex.findAll(this).map { it.range.first }.toList()
}

fun getCurrentDate(): String = sdfDate.format(Date(System.currentTimeMillis()))
fun getCurrentDateTime(): String = sdfDateTime.format(Date(System.currentTimeMillis()))

//fun Date.toDateString(): String = sdfDate.format(this)
