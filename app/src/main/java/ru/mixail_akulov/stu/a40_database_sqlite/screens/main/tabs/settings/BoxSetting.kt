package ru.mixail_akulov.stu.a40_database_sqlite.screens.main.tabs.settings

import ru.mixail_akulov.stu.a40_database_sqlite.model.boxes.entities.Box

data class BoxSetting(
    val box: Box,
    val enabled: Boolean
)