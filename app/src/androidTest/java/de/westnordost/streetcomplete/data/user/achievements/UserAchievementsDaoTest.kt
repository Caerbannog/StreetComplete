package de.westnordost.streetcomplete.data.user.achievements

import de.westnordost.streetcomplete.data.ApplicationDbTestCase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UserAchievementsDaoTest : ApplicationDbTestCase() {
    private lateinit var dao: UserAchievementsDao

    @BeforeTest fun createDao() {
        dao = UserAchievementsDao(database)
    }

    @Test fun putGetAll() {
        dao.putAll(listOf(ONE to 1))
        dao.putAll(listOf(ONE to 4, TWO to 2))
        assertEquals(mapOf(
            ONE to 4,
            TWO to 2
        ), dao.getAll())
    }

    @Test fun putSingle() {
        dao.put(ONE, 1)
        dao.put(ONE, 4)
        assertEquals(mapOf(ONE to 4), dao.getAll())
    }
}

private const val ONE = "one"
private const val TWO = "two"
