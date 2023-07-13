package com.lg.noveldocs.application.controller

import com.lg.noveldocs.domain.model.NovelDocs
import org.springframework.http.ResponseEntity

interface NovelDocsController {
    fun getNovelDocs(id: String): ResponseEntity<NovelDocs>
    fun createNovelDocs(novelDocs: NovelDocs): ResponseEntity<Unit>
    fun updateNovelDocs(id: String, updatedNovelDocs: NovelDocs): ResponseEntity<Unit>

}