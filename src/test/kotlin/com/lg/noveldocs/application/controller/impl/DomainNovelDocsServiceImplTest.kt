package com.lg.noveldocs.application.controller.impl

import com.lg.noveldocs.domain.model.*
import com.lg.noveldocs.domain.service.impl.DomainNovelDocsServiceImpl
import com.lg.noveldocs.infrastructure.repository.NovelDocsRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.util.*

class DomainNovelDocsServiceImplTest {

    @Mock
    private lateinit var novelDocsRepository: NovelDocsRepository

    private lateinit var domainNovelDocsService: DomainNovelDocsServiceImpl

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        domainNovelDocsService = DomainNovelDocsServiceImpl(novelDocsRepository)
    }

    fun createNovelDocs(suffix: String): NovelDocs{
        val name = "test$suffix"
        var chapters = Chapters("1", listOf(Chapter("1",name,"")))
        var characters = Characters("1", listOf(Character("1",name,"")))
        var scenes = Scenes("1", listOf(Scene("1",name,"")))
        var locations = Locations("1", listOf(Location("1",name,"")))
        val project = Project("1",name,name,"","","","1", Document("1"), chapters, scenes, locations, characters)
        val novelDocs = NovelDocs("1", listOf(project))
        return novelDocs
    }

    @Test
    fun testGetNovelDocsById_ValidId_ReturnsNovelDocs() {
        val novelDocs = createNovelDocs("")
        val novelDocsId = "1"
        `when`(novelDocsRepository.findById("1")).thenReturn(Optional.of(novelDocs))

        val result = domainNovelDocsService.getNovelDocsById(novelDocsId)

        assertEquals(novelDocs, result)
    }

    @Test
    fun testGetNovelDocsById_InvalidId_ReturnsNull() {
        val novelDocsId = "1"
        `when`(novelDocsRepository.findById(novelDocsId)).thenReturn(Optional.empty())

        val result = domainNovelDocsService.getNovelDocsById(novelDocsId)

        assertEquals(null, result)
    }

    @Test
    fun testSaveNovelDocs_ValidNovelDocs_CallsRepositorySave() {
        val novelDocs = createNovelDocs("")

        domainNovelDocsService.saveNovelDocs(novelDocs)

        verify(novelDocsRepository, times(1)).save(novelDocs)
    }

    @Test
    fun testUpdateNovelDocs_ExistingNovelDocs_CallsRepositorySave() {
        val existingNovelDocs = createNovelDocs("")
        val updatedNovelDocs = createNovelDocs("1")
        `when`(novelDocsRepository.existsById(existingNovelDocs.id)).thenReturn(true)

        domainNovelDocsService.updateNovelDocs(updatedNovelDocs)

        verify(novelDocsRepository, times(1)).save(updatedNovelDocs)
    }

    @Test
    fun testUpdateNovelDocs_NonExistingNovelDocs_DoesNotCallRepositorySave() {
        val novelDocsId = "1"
        val updatedNovelDocs = createNovelDocs("1")
        `when`(novelDocsRepository.existsById(novelDocsId)).thenReturn(false)

        domainNovelDocsService.updateNovelDocs(updatedNovelDocs)

        verify(novelDocsRepository, never()).save(updatedNovelDocs)
    }
}