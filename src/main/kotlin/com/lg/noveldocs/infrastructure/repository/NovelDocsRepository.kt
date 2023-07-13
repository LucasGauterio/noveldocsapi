package com.lg.noveldocs.infrastructure.repository

import com.lg.noveldocs.domain.model.NovelDocs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NovelDocsRepository : JpaRepository<NovelDocs, String> {
    // You can define additional custom query methods here if needed
}