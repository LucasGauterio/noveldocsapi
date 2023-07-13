package com.lg.noveldocs.application.controller.impl

import com.lg.noveldocs.application.controller.NovelDocsController
import com.lg.noveldocs.domain.service.DomainNovelDocsService
import com.lg.noveldocs.domain.model.NovelDocs
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/noveldocs")
class NovelDocsControllerImpl(private val novelDocsService: DomainNovelDocsService) : NovelDocsController {

    @GetMapping("/{id}")
    override fun getNovelDocs(@PathVariable id: String): ResponseEntity<NovelDocs> {
        val novelDocs = novelDocsService.getNovelDocsById(id)

        if (novelDocs != null) {
            return ResponseEntity.ok(novelDocs)
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createNovelDocs(@RequestBody novelDocs: NovelDocs): ResponseEntity<Unit> {
        novelDocsService.saveNovelDocs(novelDocs)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    override fun updateNovelDocs(@PathVariable id: String, @RequestBody updatedNovelDocs: NovelDocs): ResponseEntity<Unit> {
        if (novelDocsService.exists(id)) {
            novelDocsService.updateNovelDocs(updatedNovelDocs)
            return ResponseEntity.ok().build()
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}