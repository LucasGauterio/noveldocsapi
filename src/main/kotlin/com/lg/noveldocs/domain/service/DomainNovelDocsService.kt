package com.lg.noveldocs.domain.service

import com.lg.noveldocs.domain.model.NovelDocs

interface DomainNovelDocsService {
    fun getNovelDocsById(id: String): NovelDocs?
    fun saveNovelDocs(novelDocs: NovelDocs)
    fun updateNovelDocs(updatedNovelDocs: NovelDocs)
    fun exists(id: String): Boolean
}