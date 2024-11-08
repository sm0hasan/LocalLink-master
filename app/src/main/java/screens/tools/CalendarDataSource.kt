package screens.tools

import java.time.LocalDate
import java.time.YearMonth

/**
 * This calendar implementation is heavily based on the example in this example:
 *      https://medium.com/@meytataliti/android-simple-calendar-with-jetpack-compose-v2-b7311bd6e331
 * The github code is here:
 *      https://github.com/mzennis/MyCalendar/tree/feature/calendarv2?source=post_page-----b7311bd6e331--------------------------------
 * We heavily modified the code for our unique purposes and to fit our app
 * This particular file is directly sourced from here:
 *      https://github.com/mzennis/MyCalendar/blob/feature/calendarv2/app/src/main/java/com/pandaways/mycalendar/data/CalendarDataSource.kt
 */
class CalendarDataSource {

    fun getDates(yearMonth: YearMonth): List<CalendarUiState.Date> {
        return yearMonth.getDayOfMonthStartingFromMonday()
            .map { date ->
                CalendarUiState.Date(
                    dayOfMonth = if (date.monthValue == yearMonth.monthValue) {
                        "${date.dayOfMonth}"
                    } else {
                        "" // Fill with empty string for days outside the current month
                    },
                    isSelected = date.isEqual(LocalDate.now()) && date.monthValue == yearMonth.monthValue,
                    fullDate = date
                )
            }
    }
}