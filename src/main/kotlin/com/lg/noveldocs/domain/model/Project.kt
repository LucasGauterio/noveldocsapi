package com.lg.noveldocs.domain.model

data class Project(
    val id: String,
    val projectName: String,
    val description: String,
    val finishWritingDate: String,
    val finishEditingDate: String,
    val finishPublishDate: String,
    val folderId: String,
    val document: Document,
    val chapters: Chapters,
    val scenes: Scenes,
    val locations: Locations,
    val characters: Characters
)
