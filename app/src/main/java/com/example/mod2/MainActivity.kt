package com.example.mod2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import kotlin.random.Random
import androidx.compose.foundation.border
import androidx.compose.runtime.remember          // ← для remember { ... }
import androidx.compose.runtime.mutableStateOf    // ← для mutableStateOf(0)
import androidx.compose.material3.OutlinedButton  // ← для кнопки "Завершить день"
import androidx.compose.ui.text.font.FontWeight      // ← для FontWeight.Bold
import androidx.compose.foundation.layout.Spacer     // ← для Spacer(...)
import androidx.compose.ui.graphics.ColorFilter      // ← для ColorFilter.tint(...)
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import com.example.mod2.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod2.ui.theme.Mod2Theme

// Цвета для задания 8
private val primaryColor = Color(0xFF6200EE)   // Фиолетовый (заголовок)
private val secondaryColor = Color(0xFF3700B3) // Темно-фиолетовый (цифра литров)
private val buttonTextColor = Color.White      // Белый текст на кнопке

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mod2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Hello(name = "Елизавета")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mod2Theme {
        Greeting("Android")
    }
}

@Composable
fun Hello(name: String?) {
    if (name == null) {
        Text(text = "Имя не задано")
    } else {
        Text(text = "Привет, $name!")
    }
}

@Preview(showBackground = true, name = "С именем")
@Composable
fun HelloPreviewWithName() {
    Mod2Theme {
        Hello(name = "Елизавета")
    }
}

@Preview(showBackground = true, name = "Без имени (null)")
@Composable
fun HelloPreviewWithNull() {
    Mod2Theme {
        Hello(name = null)
    }
}

// 1. Портретная ориентация (по умолчанию телефон вертикальный)
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Portrait"
)
@Composable
fun HelloPreviewPortrait() {
    Mod2Theme {
        Hello(name = "Портрет")
    }
}

// 2. Альбомная ориентация — ширина больше высоты
@Preview(
    showBackground = true,
    widthDp = 800,
    heightDp = 400,
    name = "Landscape"
)
@Composable
fun HelloPreviewLandscape() {
    Mod2Theme {
        Hello(name = "Альбомная")
    }
}

// 3. Круглый дисплей 200x200dp с жёлтым фоном
@Preview(
    showBackground = true,
    widthDp = 200,
    heightDp = 200,
    name = "Round Display"
)
@Composable
fun HelloPreviewRound() {
    Mod2Theme {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Yellow)
        ) {
            Hello(name = "Round")
        }
    }
}

// ================= ЗАДАНИЕ 3 =================

// ================= ЗАДАНИЕ 3 =================

// Вариант 1: зелёный, 16sp, курсив, по центру
@Composable
fun ComposeTextVariant1(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier,
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

// Вариант 2: одна строка, в конце многоточие
@Composable
fun ComposeTextVariant2(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier.width(200.dp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

// Вариант 3: отступ сверху, 24sp, чёрный на зелёном, подчёркнутый
@Composable
fun ComposeTextVariant3(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.Green)
            .padding(top = 48.dp)
    ) {
        Text(
            text = stringResource(R.string.compose_description),
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline
        )
    }
}

// ---- предпросмотры для отчёта ----
@Preview(showBackground = true, name = "Вариант 1")
@Composable
fun PreviewVariant1() {
    Mod2Theme { ComposeTextVariant1(Modifier.padding(16.dp)) }
}

@Preview(showBackground = true, name = "Вариант 2")
@Composable
fun PreviewVariant2() {
    Mod2Theme { ComposeTextVariant2(Modifier.padding(16.dp)) }
}

@Preview(showBackground = true, name = "Вариант 3")
@Composable
fun PreviewVariant3() {
    Mod2Theme { ComposeTextVariant3(Modifier.fillMaxSize()) }
}

// ================= ЗАДАНИЕ 4 =================

@Composable
fun StretchedButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { },                                  // клик пока пустой — нам важна внешность
        modifier = modifier.fillMaxWidth(),             // 1. растянуть по ширине экрана
        shape = RoundedCornerShape(16.dp),              // 2. скруглённые углы
        border = BorderStroke(2.dp, Color.Gray),        // 3. серая граница
        elevation = ButtonDefaults.buttonElevation(     // 4. тень глубиной 4.dp
            defaultElevation = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(           // 5. фон + цвет текста
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Кнопка")
    }
}

@Preview(showBackground = true, name = "Кнопка")
@Composable
fun PreviewStretchedButton() {
    Mod2Theme {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            StretchedButton()
        }
    }
}

// ================= ЗАДАНИЕ 5 =================

// Компонент с инициалами (круг). Сам решает занять всю доступную высоту.
@Composable
fun InitialsAvatar(initials: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(vertical = 16.dp)   // п.2: вертикальные отступы 16.dp
            .fillMaxHeight()             // п.3: занять ВСЮ доступную высоту контейнера
            .aspectRatio(1f)             // ширина = высоте → получается квадрат
            .clip(CircleShape)           // превращаем квадрат в круг
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

// Серый контейнер во всю ширину, высотой 100.dp, с кругом посередине.
@Composable
fun GrayContainerWithInitials(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()              // п.1: во всю ширину экрана
            .height(100.dp)              // п.1: высота 100.dp
            .background(Color.Gray),     // п.1: серый цвет
        contentAlignment = Alignment.Center  // п.2: расположить содержимое посередине
    ) {
        InitialsAvatar(initials = "Е")   // инициал имени; хотите две буквы — напишите "ЕВ"
    }
}

@Preview(showBackground = true, name = "Контейнер с инициалами")
@Composable
fun PreviewGrayContainer() {
    Mod2Theme {
        GrayContainerWithInitials()
    }
}

// ==================== ЗАДАНИЕ 6 (Вариант 1) ====================

@Composable
fun CircleTopRightBlackBox() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp) // Фиксируем размер контейнера
            .background(Color.Black),              // Чёрный фон

        // Выравнивание содержимого: правый верхний угол
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle), // Берём наш XML
            contentDescription = "Orange circle",
            modifier = Modifier.padding(8.dp) // Небольшой отступ от края, чтобы не прилипал
        )
    }
}

@Preview(showBackground = true, name = "Task6 - Black Box")
@Composable
fun PreviewCircleTopRight() {
    Mod2Theme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Вариант 1:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            CircleTopRightBlackBox()
        }
    }
}

// ==================== Задание 6 (Вариант 2) ====================

@Composable
fun BigPurpleCircleBlueBg() {
    Box(
        modifier = Modifier
            .size(200.dp)          // Размер контейнера
            .background(Color.Blue), // Синий фон контейнера

        contentAlignment = Alignment.Center // Круг по центру
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Purple circle",
            modifier = Modifier
                .fillMaxSize()     // Растягиваем картинку на весь доступный размер Box'а
                .padding(16.dp),   // Немного воздуха, чтобы не упиралась в край синего квадрата
            colorFilter = ColorFilter.tint(Color.Magenta) // Перекрашиваем оранжевый в фиолетовый/мадженту
        )
    }
}

@Preview(showBackground = true, name = "Task6 - Blue BG Purple Circle")
@Composable
fun PreviewBigPurpleCircle() {
    Mod2Theme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Вариант 2:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            BigPurpleCircleBlueBg()
        }
    }
}

// ==================== ЗАДАНИЕ 7 (Часть 1: Column - Карточка) ====================

/**
 * Компонент одной карточки контакта.
 * Использует Column для вертикального расположения текста.
 */
@Composable
fun ContactCard(
    name: String,
    surname: String,
    patronymic: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()          // Растягиваем карточку на всю ширину экрана
            .padding(8.dp)           // Отступ снаружи карточки
            .background(Color.LightGray) // Светло-серый фон карточки (как на скрине)
            .clip(RoundedCornerShape(8.dp)), // Скругленные углы для красоты
        contentAlignment = Alignment.TopEnd // Позиционируем иконку в правом верхнем углу
    ) {
        // 1. Текстовая информация (выровнена по центру горизонтали)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp), // Вертикальные отступы внутри текста
            horizontalAlignment = Alignment.CenterHorizontally // Текст по центру
        ) {
            Text("Имя: $name", fontWeight = FontWeight.Bold)
            Text("Отчество: $patronymic")
            Text("Фамилия: $surname")
            Text("Мобильный телефон: $phone")
            Text("Адрес: $address")
        }

        // 2. Иконка/Картинка (справа сверху)
        Image(
            painter = painterResource(id = R.drawable.circle), // Берём наш оранжевый круг
            contentDescription = "Contact Icon",
            modifier = Modifier
                .size(40.dp)       // Размер иконки
                .padding(8.dp)     // Отступ от края карточки
        )
    }
}

// Предпросмотр одной карточки
@Preview(showBackground = true, name = "Task7 - Single Card")
@Composable
fun PreviewSingleContactCard() {
    Mod2Theme {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            ContactCard(
                name = "Евгений",
                surname = "Лукашин",
                patronymic = "Андреевич",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
            )
        }
    }
}

// Предпросмотр списка карточек (несколько штук подряд через Column)
@Preview(showBackground = true, name = "Task7 - List of Cards")
@Composable
fun PreviewListOfContacts() {
    Mod2Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp) // Расстояние между карточками
        ) {
            ContactCard("Сергей", "Пушкин", "Александрович", "+7 900 111 22 33", "СПб, Невский пр., 1")
            ContactCard("Василий", "Гоголь", "Никитович", "+7 900 444 55 66", "Москва, Тверская, 10")
            ContactCard("Людмила", "Копейкина", "Петровна", "+7 900 777 88 99", "Казань, Кремль, 1")
        }
    }
}

// ==================== ЗАДАНИЕ 7 (Часть 2: Row - Горизонтальная строка) ====================

/**
 * Компактная строка контакта для Row.
 * Здесь данные идут горизонтально: [Иконка] [Имя] [Телефон].
 */
@Composable
fun ContactRowItem(
    name: String,
    phone: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White) // Белый фон для контраста со серыми карточками выше
            .border(1.dp, Color.Gray), // Тонкая рамка вокруг каждой строки
        horizontalArrangement = Arrangement.SpaceBetween, // Расталкиваем элементы по краям
        verticalAlignment = Alignment.CenterVertically    // Выравниваем по центру высоты
    ) {
        // Левая часть: Иконка + Имя
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Text(text = name, fontWeight = FontWeight.Bold)
        }

        // Правая часть: Телефон
        Text(text = phone, color = Color.DarkGray)
    }
}

// Предпросмотр списка через Row
@Preview(showBackground = true, name = "Task7 - Row Layout")
@Composable
fun PreviewRowLayout() {
    Mod2Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Список контактов (Row):", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            // Создаем несколько строк Row
            ContactRowItem(name = "Алексей Иванов", phone = "+7 999 123 45 67")
            ContactRowItem(name = "Мария Петрова", phone = "+7 999 765 43 21")
            ContactRowItem(name = "Дмитрий Сидоров", phone = "+7 999 111 22 33")
        }
    }
}

// ==================== ЗАДАНИЕ 8 ====================

@Composable
fun WaterTracker() {
    // Используем remember + mutableStateOf БЕЗ ключевого слова 'by'
    val waterCount = remember { mutableStateOf(0) }
    val streakDays = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Обращаемся к значению через .value
        Text(
            text = "${waterCount.value} мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Меняем значение через .value
                waterCount.value += 250
            },
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                // Логика завершения дня (через .value)
                if (waterCount.value >= 1500) {
                    streakDays.value++      // Увеличиваем серию
                } else {
                    streakDays.value = 0    // Сбрасываем серию
                }
                waterCount.value = 0        // Обнуляем воду
            },
            border = BorderStroke(2.dp, primaryColor)
        ) {
            Text("Завершить день", color = primaryColor, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Вывод статистики (через .value)
        Text(
            text = "Дней подряд с нормой: ${streakDays.value}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true, name = "Task8 - Water Tracker")
@Composable
fun PreviewWaterTracker() {
    Mod2Theme {
        WaterTracker()
    }
}

// ==================== ЗАДАНИЕ 10 ====================

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {

    // ✅ ИСПРАВЛЕНИЕ: Получаем контекст ЗДЕСЬ, в начале функции,
    // а не внутри onClick. Это обязательное правило для работы с Toast.
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    // Считаем сумму локально при каждой перерисовке
    val currentTotalSum = products.sumOf { it.price }
    val hasProducts = products.isNotEmpty()

    Column(modifier = modifier.padding(16.dp)) {

        Text(text = "Корзина:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        for (product in products) {
            Text(text = "${product.name} - ${product.price} руб.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Товаров на сумму: $currentTotalSum рублей",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val newId = if (products.isEmpty()) 0 else products.last().id + 1
            val newName = "Товар #$newId"
            val newPrice = Random.nextInt(10, 100)

            products = products + Product(newId, newName, newPrice)

            // ✅ ИСПРАВЛЕНИЕ: Используем переменную 'context', которую создали выше
            if ((currentTotalSum + newPrice) > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Добавить товар")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (hasProducts) {
            OutlinedButton(onClick = {
                if (products.isNotEmpty()) {
                    products = products.dropLast(1)
                }
            }) {
                Text("Удалить товар")
            }
        }
    }
}

@Preview(showBackground = true, name = "Task10 - Shopping Cart")
@Composable
fun PreviewShoppingCart() {
    Mod2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ShoppingCartScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}