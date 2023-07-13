package com.lg.noveldocs.domain.service.impl

import com.lg.noveldocs.domain.service.DomainNovelDocsService
import com.lg.noveldocs.domain.model.NovelDocs
import com.lg.noveldocs.infrastructure.repository.NovelDocsRepository
import org.springframework.stereotype.Service


@Service
class DomainNovelDocsServiceImpl(private val novelDocsRepository: NovelDocsRepository) : DomainNovelDocsService {

    override fun getNovelDocsById(id: String): NovelDocs? {
        return novelDocsRepository.findById(id).orElse(null)
    }
    override fun exists(id: String): Boolean {

        return novelDocsRepository.existsById(id)
    }

    override fun saveNovelDocs(novelDocs: NovelDocs) {
        novelDocsRepository.save(novelDocs)
    }

    override fun updateNovelDocs(updatedNovelDocs: NovelDocs) {
        // Update the properties of existingNovelDocs with the values from updatedNovelDocs
        if(exists(updatedNovelDocs.id)){
            novelDocsRepository.save(updatedNovelDocs)
        }
    }
}