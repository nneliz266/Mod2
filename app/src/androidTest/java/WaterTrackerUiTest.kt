package com.example.mod2

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerUiTest {

    // Правило для запуска Compose-тестов
    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * Вспомогательная функция: запускает компонент WaterTracker БЕЗ темы.
     * Это убирает ошибку с Unresolved reference Mod2Theme.
     */
    private fun setWaterTrackerContent() {
        composeTestRule.setContent {
            // Просто вызываем нашу функцию, оборачивать в Theme не обязательно для проверки логики
            WaterTracker()
        }
    }

    /**
     * ТЕСТ 1: Проверка наличия и работы кнопки "+250 мл"
     */
    @Test
    fun testAddWaterButton() {
        setWaterTrackerContent()

        // Проверяем начальное значение "0 мл"
        composeTestRule.onNodeWithText("0 мл").assertExists()

        // Кликаем по кнопке "+250 мл"
        composeTestRule.onNodeWithText("+250 мл").performClick()

        // Проверяем, что стало "250 мл"
        composeTestRule.onNodeWithText("250 мл").assertExists()

        // Кликаем ещё раз
        composeTestRule.onNodeWithText("+250 мл").performClick()

        // Проверяем, что стало "500 мл"
        composeTestRule.onNodeWithText("500 мл").assertExists()
    }

    /**
     * ТЕСТ 2: Проверка кнопки "Завершить день" (сценарий без нормы)
     */
    @Test
    fun testFinishDayWithoutGoal() {
        setWaterTrackerContent()

        // Добавляем немного воды (2 клика = 500 мл, меньше 1500)
        repeat(2) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }

        // Убеждаемся, что там 500 мл
        composeTestRule.onNodeWithText("500 мл").assertExists()

        // Нажимаем "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // Счетчик воды должен обнулиться до "0 мл"
        composeTestRule.onNodeWithText("0 мл").assertExists()

        // Стаж дней должен остаться 0 (так как цель не достигнута)
        composeTestRule.onNodeWithText("Дней подряд с нормой: 0").assertExists()
    }

    /**
     * ТЕСТ 3: Проверка увеличения стажа дней при достижении нормы (>1500 мл)
     */
    @Test
    fun testFinishDayWithGoal() {
        setWaterTrackerContent()

        // Нужно набрать больше 1500.
        // 1500 / 250 = 6 кликов. Сделаем 7, чтобы точно превысить (1750 мл).
        repeat(7) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }

        // Проверяем текущий объем (должно быть 1750)
        composeTestRule.onNodeWithText("1750 мл").assertExists()

        // Нажимаем "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // Теперь счетчик воды обнулился...
        composeTestRule.onNodeWithText("0 мл").assertExists()

        // ...а стаж дней стал равен 1!
        composeTestRule.onNodeWithText("Дней подряд с нормой: 1").assertExists()
    }
}